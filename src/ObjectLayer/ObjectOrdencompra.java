package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
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
//            System.out.println("enc " + sql);
            st = c.prepareStatement(sql);
            st.executeUpdate();
            int y = 1;
            for (int i = 0; i < o.getMat().size(); i++) {
                float costo = o.getMat().get(i).getCosto();
                int cant = o.getMat().get(i).getCantidad();
                String material = o.getMat().get(i).getMaterial();
                float sub = costo * cant;
                DecimalFormat df = new DecimalFormat("#.00");
                sql = "insert into DOrdencompra values (" + o.getFolio() + "," + y
                        + ",'" + material + "'," + costo + "," + cant + "," + df.format(sub) + ",0,'1')";
//                System.out.println("det " + sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();
                y++;
            }
            sql = "update parametroscmp set OrdenCompra=OrdenCompra+1";
//            System.out.println("parametro " + sql);
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
                    + "where o.folio like '%" + filtro + "%' or p.nombre like '%" + filtro + "%' or mat.Descripcion like '%" + filtro + "%'\n"
                    + " group by o.folio,p.nombre,o.fecha order by o.fecha desc");

            rs = st.executeQuery();
            while (rs.next()) {
                Ordencompra o = new Ordencompra();
                o.setFolio(rs.getInt("folio"));
                o.setNombreproveedor(rs.getString("nombre"));
                listaordenes.add(o);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaordenes;
    }

    public ArrayList<Ordencompra> ordenSearchxfolio(String filtro) {
        ArrayList<Ordencompra> listaordenes = new ArrayList<>();
        ArrayList<Movs_materiales> listamat = new ArrayList<>();
        
        try {
        // se convierte la fecha a un formato ddmmyyyy para poderlo ingresar al kardex ademas, 
        // de tambien obtener la hora en que se emitio la orden
            st = c.prepareStatement("select o.folio as'folio',p.nombre,convert(varchar,fecha,103) as 'fecha',"
                    + "convert(varchar,fecha,108) as 'tiempo',observaciones,"
                    + "d.cvemat as 'material',renglon,precio,d.cantidad as 'cant',subtotal,"
                    + "mat.descripcion as 'nmaterial', serie,o.usuario,d.cantsurtido \n"
                    + "from Ordencompra o \n"
                    + "join ProvedoresMPrima p on p.Proveedor=o.proveedor\n"
                    + "join DOrdencompra d on d.folio=o.folio\n"
                    + "join Materiales mat on d.Cvemat=mat.CveMat\n"
                    + "where o.folio = "+filtro+" \n"
                    + "order by renglon");
            rs = st.executeQuery();
            boolean flag = true;
            Ordencompra o = new Ordencompra();
            while (rs.next()) {
                if (flag) {
                    o.setFolio(rs.getInt("folio"));
                    o.setNombreproveedor(rs.getString("nombre"));
                    o.setFecha(rs.getString("fecha"));
                    o.setTiempo(rs.getString("tiempo"));
                    o.setObservaciones(rs.getString("observaciones"));
                    o.setSerie(rs.getString("serie"));
                    o.setUsuario(rs.getInt("usuario"));
                    Movs_materiales m = new Movs_materiales();
                    m.setMaterial(rs.getString("material"));
                    m.setNombre_material(rs.getString("nmaterial"));
                    m.setRenglon(rs.getInt("renglon"));
                    m.setCosto(rs.getFloat("precio"));
                    m.setCantidad(rs.getInt("cant"));
                    m.setImporte(rs.getFloat("subtotal"));
                    m.setSurtido(rs.getInt("cantsurtido"));
                    listamat.add(m);
                    flag = false;
                } else {
                    Movs_materiales m = new Movs_materiales();
                    m.setMaterial(rs.getString("material"));
                    m.setRenglon(rs.getInt("renglon"));
                    m.setCosto(rs.getFloat("precio"));
                    m.setCantidad(rs.getInt("cant"));
                    m.setImporte(rs.getFloat("subtotal"));
                    m.setNombre_material(rs.getString("nmaterial"));
                    m.setSurtido(rs.getInt("cantsurtido"));
                    listamat.add(m);
                }
            }
            rs.close();
            st.close();
            o.setMat(listamat);
            listaordenes.add(o);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaordenes;
    }
}
