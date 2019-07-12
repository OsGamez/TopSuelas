package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectOrdencompra {

    Connection c = Server.getCmpPhylon();
//    DB db = new DB();
//    Connection c = db.Produccion();
    PreparedStatement st, prod = null;
    ResultSet rs = null;
    Statement sta = null;

    public boolean OrdenAdd(Ordencompra o) {
        try {
            c.setAutoCommit(false);
            String sql = "insert into Ordencompra values (" + o.getFolio() + ","
                    + o.getProveedor() + ",'" + o.getRefdoc() + "'," + o.getCantidad() + "," + o.getTotal()
                    + ",'" + o.getFecha() + "','" + o.getFechadoc() + "','" + o.getObservaciones()
                    + "','1'," + o.getUsuario() + ",'" + o.getSerie() + "')";
            System.out.println("enc " + sql);
            st = c.prepareStatement(sql);
            st.executeUpdate();
            int y = 1;
            for (int i = 0; i < o.getMat().size(); i++) {
                float costo = o.getMat().get(i).getCosto();
                int cant = o.getMat().get(i).getCantidad();
                String material = o.getMat().get(i).getMaterial();
                float sub = costo * cant;
                sql = "insert into DOrdencompra values (" + o.getFolio() + "," + y
                        + ",'" + material + "'," + costo + "," + cant + "," + sub + ",0,'1')";
                System.out.println("det " + sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();
                y++;
            }
            sql = "update parametroscmp set OrdenCompra=OrdenCompra+1";
            System.out.println("parametro " + sql);
            st = c.prepareStatement(sql);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            try {
                ex.printStackTrace();
                c.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectOrdencompra.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
//            try {
//                //st.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(ObjectOrdencompra.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
        return false;
    }

    public ArrayList<Producto> productosGetAll() {
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        try {
            st = c.prepareStatement("");

            rs = st.executeQuery();

            while (rs.next()) {

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaProductos;
    }

    public ArrayList<Ordencompra> ordenSearch(String filtro) {
        ArrayList<Ordencompra> listaordenes = new ArrayList<>();
        try {
            st = c.prepareStatement("select top(20) o.folio as 'folio',p.nombre as 'nombre' from Ordencompra o \n"
                    + "join ProvedoresMPrima p on p.Proveedor=o.proveedor\n"
                    + "join DOrdencompra d on d.folio=o.folio\n"
                    + "join Materiales mat on d.Cvemat=mat.CveMat\n"
                    + "where o.folio like '%"+filtro+"%' or p.nombre like '%"+filtro+"%' or mat.Descripcion like '%"+filtro+"%'\n"
                    + "order by o.fecha desc");

            rs = st.executeQuery();

            while (rs.next()) {
                Ordencompra o = new Ordencompra();
                o.setFolio(rs.getInt("folio"));
                o.setNombreproveedor(rs.getString("folio")+", "+rs.getString("nombre"));
                listaordenes.add(o);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaordenes;
    }

}
