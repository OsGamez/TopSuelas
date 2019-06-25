package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ObjectKardexCmp {

    PreparedStatement st = null;
    ResultSet rs = null;
    Connection c = Server.getCmpPhylon();

    public boolean KardexCmpAdd(int am, String Desc) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("INSERT INTO KardexCmpes(KardexCmp,Descripcion)"
                    + "VALUES(?,?)");
            st.setInt(1, am);
            st.setString(2, Desc);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<KardexCmp> KardexCmpGatAll() {
        ArrayList<KardexCmp> listaKardexCmp = new ArrayList<>();
        try {
            st = c.prepareStatement("select top(30) folio,k.cuenta,k.subcuenta,fechamov,fechadoc,serie,k.tipo,"
                    + "k.ProveedorMPrima,k.Almacen,docref,k.cvemat,k.cantidad,k.costo,importe,\n"
                    + "k.usuario,k.status,renglon,Ordencompra,mat.descripcion as 'mdescripcion',pmp.nombre as 'ndescripcion'"
                    + ",alm.descripcion as 'adescripcion'\n"
                    + "from KardexCmp k join  ConceptosES c on k.cuenta=c.Cuenta\n"
                    + "join ProvedoresMPrima pmp on k.ProveedorMPrima=pmp.Proveedor\n"
                    + "join Almacenes alm on k.Almacen=alm.Almacen\n"
                    + "join Materiales mat on k.Cvemat=mat.CveMat  ORDER BY folio DESC");
            rs = st.executeQuery();
            while (rs.next()) {
                KardexCmp k = new KardexCmp();
                k.setFolio(rs.getInt("Folio"));
                k.setCuenta(rs.getInt("cuenta"));
                k.setFechamov(rs.getString("fechamov"));
                k.setSerie(rs.getString("serie"));
                k.setNombrealmacen(rs.getString("adescripcion"));
                k.setNombrematerial(rs.getString("mdescripcion"));
                k.setCantidad(rs.getInt("cantidad"));
                listaKardexCmp.add(k);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaKardexCmp;
    }

    public ArrayList<KardexCmp> KardexCmpSearch(String filtro) {
        ArrayList<KardexCmp> listaKardexCmp = new ArrayList<>();
        try {
            st = c.prepareStatement("select top(30) folio,k.cuenta,k.subcuenta,fechamov,fechadoc,serie,k.tipo,"
                    + "k.ProveedorMPrima,k.Almacen,docref,k.cvemat,k.cantidad,k.costo,importe,\n"
                    + "k.usuario,k.status,renglon,Ordencompra,mat.descripcion as 'mdescripcion',pmp.nombre as 'ndescripcion'"
                    + ",alm.descripcion as 'adescripcion'\n"
                    + "from KardexCmp k join  ConceptosES c on k.cuenta=c.Cuenta\n"
                    + "join ProvedoresMPrima pmp on k.ProveedorMPrima=pmp.Proveedor\n"
                    + "join Almacenes alm on k.Almacen=alm.Almacen\n"
                    + "join Materiales mat on k.Cvemat=mat.CveMat"
                    + " where folio like '%" + filtro + "%' or mat.descripcion like '%" + filtro + "%' "
                    + "or pmp.nombre like '%" + filtro + "%'  ORDER BY folio DESC");
            rs = st.executeQuery();
            while (rs.next()) {
                KardexCmp k = new KardexCmp();
                k.setFolio(rs.getInt("Folio"));
                k.setCuenta(rs.getInt("cuenta"));
                k.setFechamov(rs.getString("fechamov"));
                k.setSerie(rs.getString("serie"));
                k.setNombrealmacen(rs.getString("adescripcion"));
                k.setNombrematerial(rs.getString("mdescripcion"));
                k.setCantidad(rs.getInt("cantidad"));
                listaKardexCmp.add(k);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaKardexCmp;
    }

    public boolean KardexCmpUpdate(String Desc, int am) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE KardexCmpes SET Descripcion =? WHERE KardexCmp = ?");
            st.setString(1, Desc);
            st.setInt(2, am);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean KardexCmpDelete(int Id, String Des) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("DELETE FROM KardexCmpes WHERE KardexCmp = ? AND Descripcion = ?");
            st.setInt(1, Id);
            st.setString(2, Des);
            st.execute();
            c.commit();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<KardexCmp> getById(String id) {
        ArrayList<KardexCmp> listaKardexCmp = new ArrayList<KardexCmp>();
        try {
            st = c.prepareStatement("SELECT KardexCmp  FROM KardexCmpes WHERE KardexCmp =?");
            st.setString(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                KardexCmp am = new KardexCmp();
                listaKardexCmp.add(am);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaKardexCmp;
    }
     public String getparametro(String columna) {
        String parametro ="";
        try {
            st = c.prepareStatement("SELECT "+columna+" FROM parametroscmp");
            rs = st.executeQuery();

            while (rs.next()) {
                parametro=rs.getString(columna);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return parametro;
    }
}
