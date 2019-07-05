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

public class ObjectKardexCmp {

    PreparedStatement st = null;
    ResultSet rs = null;
    Connection c = Server.getCmpPhylon();

    public boolean KardexCmpAdd(KardexCmp k) {
        try {
            c.setAutoCommit(false);
            int renglon = 1;
            //bucle para insercion en kardex y actualizacion de cantidades en existencias.
            for (int i = 0; i < k.getMat().size(); i++) {
                int cant = k.getMat().get(i).getCantidad();
                float cos = k.getMat().get(i).getCosto();
                String material = k.getMat().get(i).getMaterial();
                String sql = "INSERT INTO KardexCmp values(" + k.getFolio() + "," + k.getCuenta() + ""
                        + "," + k.getSubcuenta() + "," + k.getProveedor() + "," + k.getAlmacen() + ",'" + material + "'"
                        + ",'" + k.getOrdenc() + "','" + k.getFechamov() + "','" + k.getFechadoc() + "','" + k.getSerie() + "'"
                        + ",'" + k.getTipo() + "','" + k.getDocref() + "'," + cant + "," + cos + "," + cos * cant + "," + renglon + ",'1',"
                        + "" + k.getUsuario() + ")";
//                System.out.println("kardex "+sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();
                Statement s;
                s = c.createStatement();
                sql = "select cvemat from existencias where almacen =" + k.getAlmacen() + " and "
                        + "cvemat='" + material + "'";
                rs = s.executeQuery(sql);
                boolean flag = false;
                while (rs.next()) {
                    flag = true;
                }
//                flag verificara si existe o no un registro con respecto al
//                material y al almacen
                if (flag) {
                    sql = "update existencias set existencia =existencia"+k.getOperacion()+" " + cant + ", ultcosto=" + cos + " "
                            + "where almacen =" + k.getAlmacen() + " and "
                            + "cvemat='" + material + "'";
                } else {
                    sql = "insert into existencias values('" + material + "'," 
                            + k.getAlmacen() + "," + cos + "," + cant + ")";
                }
                st = c.prepareStatement(sql);
                st.executeUpdate();
//                System.out.println("existencias "+sql);
                renglon++;
            }
            String columna =(k.getTipo().equals("E"))?"Entradas":"Salidas";
            st=c.prepareStatement("update parametroscmp set "+columna+"="+k.getFolio());
            st.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectKardexCmp.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                rs.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(ObjectKardexCmp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public ArrayList<KardexCmp> KardexCmpGatAll() {
        ArrayList<KardexCmp> listaKardexCmp = new ArrayList<>();
        try {
            String sql="select top(30) folio,k.cuenta,k.subcuenta,fechamov,fechadoc,serie,k.tipo,"
                    + "k.ProveedorMPrima,k.Almacen,docref,k.cvemat,k.cantidad,k.costo,importe,\n"
                    + "k.usuario,k.status,renglon,Ordencompra,mat.descripcion as 'mdescripcion',pmp.nombre as 'ndescripcion'"
                    + ",alm.descripcion as 'adescripcion'\n"
                    + "from KardexCmp k \n"
                    + "join ProvedoresMPrima pmp on k.ProveedorMPrima=pmp.Proveedor\n"
                    + "join Almacenes alm on k.Almacen=alm.Almacen\n"
                    + "join Materiales mat on k.Cvemat=mat.CveMat  ORDER BY fechamov DESC";
            System.out.println(sql);
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                KardexCmp k = new KardexCmp();
                k.setFolio(rs.getInt("Folio"));
                k.setCuenta(rs.getInt("cuenta"));
                k.setSubcuenta(rs.getInt("subcuenta"));
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
                    + "from KardexCmp k \n"
                    + "join ProvedoresMPrima pmp on k.ProveedorMPrima=pmp.Proveedor\n"
                    + "join Almacenes alm on k.Almacen=alm.Almacen\n"
                    + "join Materiales mat on k.Cvemat=mat.CveMat"
                    + " where folio like '%" + filtro + "%' or mat.descripcion like '%" + filtro + "%' "
                    + "or pmp.nombre like '%" + filtro + "%'  ORDER BY fechamov DESC");
            rs = st.executeQuery();
            while (rs.next()) {
                KardexCmp k = new KardexCmp();
                k.setFolio(rs.getInt("Folio"));
                k.setCuenta(rs.getInt("cuenta"));
                 k.setSubcuenta(rs.getInt("subcuenta"));
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
        int parametro = 0;
        try {
            st = c.prepareStatement("SELECT " + columna + " FROM parametroscmp");
            rs = st.executeQuery();
            while (rs.next()) {
                parametro = rs.getInt(columna);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return String.valueOf(parametro);
    }
        public String getparametro2(String columna) {
        String parametro = "";
        try {
            st = c.prepareStatement("SELECT " + columna + " FROM parametroscmp");
            rs = st.executeQuery();

            while (rs.next()) {
                parametro = rs.getString(columna);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return parametro;
    }
}
