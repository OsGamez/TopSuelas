package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ObjectCostos {

    PreparedStatement st = null;
    Connection c = Conexion.getProduccion();
    ResultSet rs = null;

    public boolean CostoAdd(Costo costo) {
        try {
            st = c.prepareStatement("INSERT INTO Costos(Id_Producto,Id_ProductoRCPT,Punto,PesoGr,Ptolerancia,"
                    + "Pcolada,CveMat,Tolerancia,Colada,PesoTotal,Costo,Precio)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, costo.getId_Producto());
            st.setInt(2, costo.getId_ProductoRCPT());
            st.setInt(3, costo.getPunto());
            st.setDouble(4, costo.getPesoGr());
            st.setDouble(5, costo.getPtolerancia());
            st.setDouble(6, costo.getPcolada());
            st.setString(7, costo.getCveMat());
            st.setDouble(8, costo.getTolerancia());
            st.setDouble(9, costo.getColada());
            st.setDouble(10, costo.getPesoTotal());
            st.setDouble(11, costo.getCosto());
            st.setDouble(12, costo.getPrecio());
            st.executeUpdate();
            st.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<Costo> costoGetAll() {
        ArrayList<Costo> listaCostos = new ArrayList<Costo>();
        try {
            st = c.prepareStatement("select c.Id_Producto,p.Descripcion  AS Suela,c.Id_ProductoRCPT,p.Descripcion as Producto,c.Punto,c.PesoGr,c.Ptolerancia,c.Pcolada,\n"
                    + "c.Tolerancia,c.Colada,c.PesoTotal,c.Precio,c.Costo,\n"
                    + "m.Descripcion as Material,c.CveMat\n"
                    + "from Costos c inner join Producto p\n"
                    + "on c.Id_Producto = p.Id_Producto\n"
                    + "inner join CmpPhylon.dbo.Materiales m \n"
                    + "on c.CveMat = m.CveMat Group by p.Descripcion,c.Id_Producto,c.Id_ProductoRCPT,c.Punto,c.PesoGr,\n"
                    + "c.Ptolerancia,c.Pcolada,\n"
                    + "c.Tolerancia,c.Colada,c.PesoTotal,c.Precio,Costo,m.Descripcion,c.CveMat");
            rs = st.executeQuery();
            while (rs.next()) {
                Costo ct = new Costo();
                ct.setId_Producto(rs.getInt("Id_Producto"));
                ct.setId_ProductoRCPT(rs.getInt("Id_ProductoRCPT"));
                ct.setDescripcion(rs.getString("Suela"));
                ct.setDp(rs.getString("Producto"));
                ct.setPunto(rs.getInt("Punto"));
                ct.setPesoGr(rs.getDouble("PesoGr"));
                ct.setPtolerancia(rs.getDouble("Ptolerancia"));
                ct.setPcolada(rs.getDouble("Pcolada"));
                ct.setTolerancia(rs.getDouble("Tolerancia"));
                ct.setColada(rs.getDouble("Colada"));
                ct.setPesoTotal(rs.getDouble("PesoTotal"));
                ct.setPrecio(rs.getDouble("Precio"));
                ct.setCosto(rs.getDouble("Costo"));
                ct.setCveMat(rs.getString("CveMat"));
                ct.setMaterial(rs.getString("Material"));
                listaCostos.add(ct);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCostos;
    }

    public int validarCosto(int Id, int Punto) {
        try {
            st = c.prepareStatement("SELECT COUNT(Id_Producto)  FROM Costos WHERE Id_Producto = ? AND Punto = ?");
            st.setInt(1, Id);
            st.setInt(2, Punto);
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

    public boolean costoUpdate(Costo ct) {
        try {
            st = c.prepareStatement("UPDATE Costos SET Ptolerancia=?,Pcolada=? WHERE Id_Producto=? AND Punto = ?");
            st.setDouble(1, ct.getPtolerancia());
            st.setDouble(2, ct.getPcolada());
            st.setInt(3, ct.getId_Producto());
            st.setInt(4, ct.getPunto());
            st.executeUpdate();
            st.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean UpdateRegistro(Costo ct) {
        try {
            st = c.prepareStatement("UPDATE Costos SET Ptolerancia = ?,Pcolada=?");
            st.setDouble(1, ct.getPtolerancia());
            st.setDouble(2, ct.getPcolada());
            st.executeUpdate();
            st.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean UpdateByLinea(Costo ct) {
        try {
            st = c.prepareStatement("UPDATE C\n"
                    + "SET C.Ptolerancia = ?,\n"
                    + "C.Pcolada = ?\n"
                    + "FROM  Costos C\n"
                    + "INNER JOIN \n"
                    + "Producto P\n"
                    + "ON C.Id_Producto = P.Id_Producto\n"
                    + "WHERE P.Id_Linea = ?");
            st.setDouble(1, ct.getPtolerancia());
            st.setDouble(2, ct.getPcolada());
            st.setInt(3, ct.getLinea());
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean UpdateCve(double precio,String cve){
        try {
            st = c.prepareStatement("update Costos set Precio = ?\n" +
            "where CveMat = ?");
            st.setDouble(1, precio);
            st.setString(2, cve);
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
            

    public ArrayList<Costo> costoSearch(String filtro) {
        ArrayList<Costo> listaCostos = new ArrayList<Costo>();
        try {
            st = c.prepareStatement("select c.Id_Producto,p.Descripcion  AS Suela,c.Id_ProductoRCPT,p.Descripcion as Producto,c.Punto,c.PesoGr,c.Ptolerancia,c.Pcolada,\n"
                    + "c.Tolerancia,c.Colada,c.PesoTotal,c.Precio,c.Costo,\n"
                    + "m.Descripcion as Material,c.CveMat\n"
                    + "from Costos c inner join Producto p\n"
                    + "on c.Id_Producto = p.Id_Producto\n"
                    + "inner join CmpPhylon.dbo.Materiales m \n"
                    + "on c.CveMat = m.CveMat \n"
                    + "WHERE p.Descripcion LIKE '%" + filtro + "%'\n"
                    + "Group by p.Descripcion,c.Id_Producto,c.Id_ProductoRCPT,c.Punto,c.PesoGr,\n"
                    + "c.Ptolerancia,c.Pcolada,\n"
                    + "c.Tolerancia,c.Colada,c.PesoTotal,c.Precio,Costo,m.Descripcion,c.CveMat");
            rs = st.executeQuery();

            while (rs.next()) {
                Costo ct = new Costo();
                ct.setId_Producto(rs.getInt("Id_Producto"));
                ct.setId_ProductoRCPT(rs.getInt("Id_ProductoRCPT"));
                ct.setDescripcion(rs.getString("Suela"));
                ct.setDp(rs.getString("Producto"));
                ct.setPunto(rs.getInt("Punto"));
                ct.setPesoGr(rs.getDouble("PesoGr"));
                ct.setPtolerancia(rs.getDouble("Ptolerancia"));
                ct.setPcolada(rs.getDouble("Pcolada"));
                ct.setTolerancia(rs.getDouble("Tolerancia"));
                ct.setColada(rs.getDouble("Colada"));
                ct.setPesoTotal(rs.getDouble("PesoTotal"));
                ct.setPrecio(rs.getDouble("Precio"));
                ct.setCosto(rs.getDouble("Costo"));
                ct.setCveMat(rs.getString("CveMat"));
                ct.setMaterial(rs.getString("Material"));
                listaCostos.add(ct);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCostos;
    }

    public boolean costoDelete(int Id_Producto, int Punto) {
        try {
            st = c.prepareStatement("DELETE FROM Costos WHERE Id_Producto = ? AND Punto=?");
            st.setInt(1, Id_Producto);
            st.setInt(2, Punto);
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
