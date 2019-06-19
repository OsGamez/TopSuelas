package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ObjectRCPT {

    Connection c = Conexion.getLocal();
    ResultSet rs = null;
    Statement sta = null;
    PreparedStatement st = null;

    public ArrayList<PtProducto> GetByRCPT(String filtro) {
        ArrayList<PtProducto> listaProductos = new ArrayList<PtProducto>();
        try {
            String sql = "SELECT * FROM Productos WHERE Descripcion LIKE '%" + filtro + "%'"
                    + "ORDER BY Descripcion";
            sta = c.createStatement();
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                PtProducto producto = new PtProducto();
                producto.setProducto(rs.getInt("Producto"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setEstilo(rs.getInt("Estilo"));
                producto.setCombinacion(rs.getInt("Combinacion"));
                producto.setCorrida(rs.getInt("Corrida"));
                listaProductos.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProductos;
    }

    public ArrayList<PtProducto> getPhylon(String id) {
        ArrayList<PtProducto> listaProductos = new ArrayList<PtProducto>();
        try {
            st = c.prepareStatement("SELECT Producto,Descripcion,Estilo, Combinacion, Corrida FROM Productos WHERE Producto = ?");
            st.setString(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                PtProducto producto = new PtProducto();
                producto.setProducto(rs.getInt("Producto"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setEstilo(rs.getInt("Estilo"));
                producto.setCombinacion(rs.getInt("Combinacion"));
                producto.setCorrida(rs.getInt("Corrida"));

                listaProductos.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProductos;
    }

    public ArrayList<PtProducto> getById(String id) {
        ArrayList<PtProducto> listaProductos = new ArrayList<PtProducto>();
        try {
            st = c.prepareStatement("select p.Producto,p.Descripcion,p.Estilo,p.Combinacion, p.Corrida,\n"
                    + "c.PuntoInicial,c.PuntoFinal from Productos p \n"
                    + "inner join Corridas c on p.Corrida = c.Corrida\n"
                    + "WHERE p.Estatus = 'A'  and p.Descripcion LIKE'%"+id+"%' ORDER BY p.Descripcion");
            rs = st.executeQuery();

            while (rs.next()) {
                PtProducto producto = new PtProducto();
                producto.setProducto(rs.getInt("Producto"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setEstilo(rs.getInt("Estilo"));
                producto.setCombinacion(rs.getInt("Combinacion"));
                producto.setCorrida(rs.getInt("Corrida"));
                producto.setPti(rs.getInt("PuntoInicial"));
                producto.setPtf(rs.getInt("PuntoFinal"));

                listaProductos.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProductos;
    }

    public ArrayList<PtProducto> getPhyAlmacen(String id) {
        ArrayList<PtProducto> listaAlmacen = new ArrayList<PtProducto>();
        try {
            st = c.prepareStatement("SELECT Almacen  FROM Almacenes WHERE Almacen =?");
            st.setString(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                PtProducto producto = new PtProducto();
                producto.setAlmacen(rs.getInt("Almacen"));
                listaAlmacen.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaAlmacen;
    }

}
