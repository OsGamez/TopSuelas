package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ObjectRCPT {

    Connection c = Server.getServer();
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
                    + "WHERE p.Estatus = 'A'  and p.Descripcion LIKE'%" + id + "%' ORDER BY p.Descripcion");
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

    public ArrayList<PtProducto> GetByInventario(int filtro) {
        ArrayList<PtProducto> listaProductos = new ArrayList<PtProducto>();
        try {
            st = c.prepareStatement("select c.Id_ProductoRCPT,c.Id_Producto,p.Descripcion  AS Suela,cr.Corrida as Corrida,\n"
                    + "cr.PuntoInicial,cr.PuntoFinal,pt.Combinacion,pt.Estilo\n"
                    + "from ProduccionPhy.dbo.Costos c inner join ProduccionPhy.dbo.Producto p\n"
                    + "on c.Id_Producto = p.Id_Producto\n"
                    + "inner join RCPTPhylon.dbo.Productos pt\n"
                    + "on c.Id_ProductoRCPT = pt.Producto\n"
                    + "inner join RCPTPhylon.dbo.Corridas cr\n"
                    + "on pt.Corrida = cr.Corrida\n"
                    + "where c.Id_Producto = "+filtro+ " group by c.Id_Producto,p.Descripcion,c.Id_ProductoRCPT,cr.Corrida\n"
                    + ",cr.PuntoInicial,cr.PuntoFinal,pt.Combinacion,pt.Estilo");

            rs = st.executeQuery();

            while (rs.next()) {
                PtProducto producto = new PtProducto();
                producto.setProducto(rs.getInt("Id_Producto"));
                producto.setSuelaPhy(rs.getInt("Id_ProductoRCPT"));
                producto.setDescripcion(rs.getString("Suela"));
                producto.setCorrida(rs.getInt("Corrida"));
                producto.setPti(rs.getInt("PuntoInicial"));
                producto.setPtf(rs.getInt("PuntoFinal"));
                producto.setCombinacion(rs.getInt("Combinacion"));
                producto.setEstilo(rs.getInt("Estilo"));

                listaProductos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaProductos;
    }

}
