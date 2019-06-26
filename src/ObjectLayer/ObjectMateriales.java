package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectMateriales {

    PreparedStatement st = null;
    ResultSet rs = null;
    Connection c = Server.getCmpPhylon();
    Statement sta = null;

    public boolean addMaterial(Material mat) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("INSERT INTO Materiales(Almacen,CveMat,Descripcion,CodigoSat,UdeC,Fcompra,UdeCs,Fconsumo,UltimoCosto,"
                    + "CostoCosteo,CantidadMinima,CantidadMaxima,TipoCosto,Divisa,Proveedor)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, mat.getAlmacen());
            st.setString(2, mat.getCveMat());
            st.setString(3, mat.getDescripcion());
            st.setString(4, mat.getCodigoSat());
            st.setString(5, mat.getUdeC());
            st.setDouble(6, mat.getFcompra());
            st.setString(7, mat.getUdeCs());
            st.setDouble(8, mat.getFconsumo());
            st.setDouble(9, mat.getUltimoCosto());
            st.setDouble(10, mat.getCostoCosteo());
            st.setDouble(11, mat.getCantidadMinima());
            st.setDouble(12, mat.getCantidadMaxima());
            st.setString(13, mat.getTipoCosto());
            st.setString(14, mat.getDivisa());
            st.setInt(15, mat.getCveproveedor());
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectMateriales.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        return false;
    }

    public ArrayList<Material> materialGetAll() {
        ArrayList<Material> listaMat = new ArrayList<Material>();
        try {
            st = c.prepareStatement("SELECT m.Almacen as #,a.Descripcion as Almacen,m.CveMat,m.Descripcion,m.CodigoSat,\n"
                    + "                    m.UdeC,m.Fcompra,m.UdeCs,m.Fconsumo,m.UltimoCosto,m.CostoCosteo,m.CantidadMinima,\n"
                    + "                    m.CantidadMaxima,m.TipoCosto,m.Divisa,m.proveedor as 'proveedor', pmp.nombre as 'nombre'\n"
                    + "                    FROM Materiales m INNER JOIN Almacenes a ON m.Almacen = a.Almacen"
                    + "                    join ProvedoresMPrima pmp on pmp.proveedor=m.proveedor");
            rs = st.executeQuery();

            while (rs.next()) {
                Material mat = new Material();
                mat.setAlmacen(rs.getInt("#"));
                mat.setDesAlm(rs.getString("Almacen"));
                mat.setCveMat(rs.getString("CveMat"));
                mat.setDescripcion(rs.getString("Descripcion"));
                mat.setCodigoSat(rs.getString("CodigoSat"));
                mat.setUdeC(rs.getString("UdeC"));
                mat.setFcompra(rs.getDouble("Fcompra"));
                mat.setUdeCs(rs.getString("UdeCs"));
                mat.setFconsumo(rs.getDouble("Fconsumo"));
                mat.setUltimoCosto(rs.getDouble("UltimoCosto"));
                mat.setCostoCosteo(rs.getDouble("CostoCosteo"));
                mat.setCantidadMinima(rs.getDouble("CantidadMinima"));
                mat.setCantidadMaxima(rs.getDouble("CantidadMaxima"));
                mat.setTipoCosto(rs.getString("TipoCosto"));
                mat.setDivisa(rs.getString("Divisa"));
                mat.setCveproveedor(rs.getInt("proveedor"));
                mat.setDescproveedor(rs.getString("nombre"));
                listaMat.add(mat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaMat;
    }

    public ArrayList<Material> materialSearch(String filtro) {
        ArrayList<Material> listaMat = new ArrayList<Material>();
        try {
            st = c.prepareStatement("SELECT m.Almacen as #,a.Descripcion as Almacen,m.CveMat,m.Descripcion,m.CodigoSat,\n"
                    + "                    m.UdeC,m.Fcompra,m.UdeCs,m.Fconsumo,m.UltimoCosto,m.CostoCosteo,m.CantidadMinima,\n"
                    + "                    m.CantidadMaxima,m.TipoCosto,m.Divisa,m.proveedor as 'proveedor', pmp.nombre as 'nombre'\n"
                    + "                    FROM Materiales m INNER JOIN Almacenes a ON m.Almacen = a.Almacen \n"
                    + "                    join ProvedoresMPrima pmp on pmp.proveedor=m.proveedor"
                    + " WHERE m.Descripcion LIKE'%" + filtro + "%'");
            rs = st.executeQuery();

            while (rs.next()) {
                Material mat = new Material();
                mat.setAlmacen(rs.getInt("#"));
                mat.setDesAlm(rs.getString("Almacen"));
                mat.setCveMat(rs.getString("CveMat"));
                mat.setDescripcion(rs.getString("Descripcion"));
                mat.setCodigoSat(rs.getString("CodigoSat"));
                mat.setUdeC(rs.getString("UdeC"));
                mat.setFcompra(rs.getDouble("Fcompra"));
                mat.setUdeCs(rs.getString("UdeCs"));
                mat.setFconsumo(rs.getDouble("Fconsumo"));
                mat.setUltimoCosto(rs.getDouble("UltimoCosto"));
                mat.setCostoCosteo(rs.getDouble("CostoCosteo"));
                mat.setCantidadMinima(rs.getDouble("CantidadMinima"));
                mat.setCantidadMaxima(rs.getDouble("CantidadMaxima"));
                mat.setTipoCosto(rs.getString("TipoCosto"));
                mat.setDivisa(rs.getString("Divisa"));
                mat.setCveproveedor(rs.getInt("proveedor"));
                mat.setDescproveedor(rs.getString("nombre"));
                listaMat.add(mat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaMat;
    }

    public ArrayList<Material> GetByCosto(String filtro) {
        ArrayList<Material> listaMat = new ArrayList<Material>();
        try {
            String sql = "SELECT * FROM Materiales WHERE Descripcion LIKE'%" + filtro + "%'"
                    + "ORDER BY Descripcion";
            sta = c.createStatement();
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                Material mat = new Material();
                mat.setCveMat(rs.getString("CveMat"));
                mat.setDescripcion(rs.getString("Descripcion"));
                mat.setCostoCosteo(rs.getDouble("CostoCosteo"));
                listaMat.add(mat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaMat;
    }

    public ArrayList<Material> GetPrecio(String filtro) {
        ArrayList<Material> listaMat = new ArrayList<Material>();
        try {
            st = c.prepareStatement("SELECT CveMat,CostoCosteo FROM Materiales WHERE CveMat LIKE'%" + filtro + "%'");
            rs = st.executeQuery();
            while (rs.next()) {
                Material mat = new Material();
                mat.setCveMat(rs.getString("CveMat"));
                mat.setCostoCosteo(rs.getDouble("CostoCosteo"));
                listaMat.add(mat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaMat;
    }

    public boolean materialUpdate(Material mat) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE Materiales SET Descripcion=?, CodigoSat=?, UdeC=?,Fcompra=?,UdeCs=?,Fconsumo=?,UltimoCosto=?,"
                    + "CostoCosteo=?,CantidadMinima=?,CantidadMaxima=?,TipoCosto=?,Divisa=?,Proveedor=? WHERE Almacen=? AND CveMat=?");

            st.setString(1, mat.getDescripcion());
            st.setString(2, mat.getCodigoSat());
            st.setString(3, mat.getUdeC());
            st.setDouble(4, mat.getFcompra());
            st.setString(5, mat.getUdeCs());
            st.setDouble(6, mat.getFconsumo());
            st.setDouble(7, mat.getUltimoCosto());
            st.setDouble(8, mat.getCostoCosteo());
            st.setDouble(9, mat.getCantidadMinima());
            st.setDouble(10, mat.getCantidadMaxima());
            st.setString(11, mat.getTipoCosto());
            st.setString(12, mat.getDivisa());
            st.setInt(13, mat.getCveproveedor());
            st.setInt(14, mat.getAlmacen());
            st.setString(15, mat.getCveMat());
            st.executeUpdate();
            c.commit();
            st.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean materialDelete(int Almacen, String Cv) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("DELETE Materiales WHERE Almacen=? AND CveMat=?");
            st.setInt(1, Almacen);
            st.setString(2, Cv);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public int validarMaterial(String Des, int Alm, String Cve) {
        try {
            st = c.prepareStatement("SELECT COUNT (Almacen) FROM Materiales WHERE Almacen =? AND Descripcion =?  AND CveMat=?");
            st.setInt(1, Alm);
            st.setString(2, Des);
            st.setString(3, Cve);
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 1;
        }
    }

    public int validarMat(String Des, int Alm) {
        try {
            st = c.prepareStatement("SELECT COUNT (Almacen) FROM Materiales WHERE  Almacen = ? AND Descripcion = ?");
            st.setInt(1, Alm);

            st.setString(2, Des);
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 1;
        }
    }

    public int validarMatr(int Alm, String Cve) {
        try {
            st = c.prepareStatement("SELECT COUNT (Almacen) FROM Materiales WHERE  Almacen = ? AND CveMat = ?");
            st.setInt(1, Alm);
            st.setString(2, Cve);
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 1;
        }
    }

    public int validarNombre(String Desc) {
        try {
            st = c.prepareStatement("SELECT COUNT(Descripcion)  FROM Materiales WHERE Descripcion = ?");
            st.setString(1, Desc);
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 1;
        }
    }
        public int validaralmacen_material(int almacen, String material){
        int resp=0;
        try {
            st = c.prepareStatement("SELECT existencia FROM Existencias WHERE Almacen = "+almacen+
                    " and cvemat = '"+material+"'");
            rs = st.executeQuery();
            if (rs.next()) {
                resp=rs.getInt("existencia");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }
}
