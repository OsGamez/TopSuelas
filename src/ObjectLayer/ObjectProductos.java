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

public class ObjectProductos {

    Connection c = Server.getProduccion();
//    DB db = new DB();
//    Connection c = db.Produccion();
    PreparedStatement st, prod = null;
    ResultSet rs = null;
    Statement sta = null;

    public boolean productoAdd(Producto producto) {
        try {
            st = c.prepareStatement("INSERT INTO Producto (Id_Linea,Descripcion, Observaciones, Id_Color, Id_Corrida, Activo)"
                    + "values(?,?,?,?,?,?)");
            c.setAutoCommit(false);
            st.setInt(1, producto.getId_Linea());
            st.setString(2, producto.getDescripcion());
            st.setString(3, producto.getObservaciones());
            st.setInt(4, producto.getId_Color());
            st.setInt(5, producto.getId_Corrida());
            st.setBoolean(6, producto.getActivo());
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.rollbackA(c);
            Conexion.cerrarPrep(st);
        }
        return false;
    }

    public ArrayList<Producto> productosGetAll() {
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        try {
            st = c.prepareStatement("SELECT  p.Id_Producto,p.Descripcion, p.Observaciones,"
                    + "c.Descripcion as Color ,cr.Descripcion as Corrida,l.Descripcion as Linea ,p.Id_Color,p.Id_Linea ,p.Id_Corrida\n"
                    + "FROM Producto p INNER JOIN Color c on p.Id_Color = c.Id_Color\n"
                    + "INNER JOIN Corrida cr on p.Id_Corrida = cr.Id_Corrida "
                    + "INNER JOIN Linea l on p.Id_Linea = l.Id_Linea WHERE p.Activo = 1 ORDER BY p.Descripcion");

            rs = st.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_Linea(rs.getInt("Id_Linea"));
                producto.setId_Color(rs.getInt("Id_Color"));
                producto.setId_Corrida(rs.getInt("Id_Color"));
                producto.setDescripcionLinea(rs.getString("Linea"));
                producto.setDescripcionColor(rs.getString("Color"));
                producto.setDescripcionCorrida(rs.getString("Corrida"));
                producto.setId_Producto(rs.getInt("Id_Producto"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setObservaciones(rs.getString("Observaciones"));

                listaProductos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaProductos;
    }

    public ArrayList<Producto> GetByID(String filtro) {
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        try {
            st = c.prepareStatement("select  p.Descripcion,p.Id_Producto,\n"
                    + "p.Id_Color, p.Id_Corrida,c.Descripcion as Color,cr.Descripcion as Corrida,\n"
                    + "l.Id_Lista,l.PrecioA,l.PrecioB \n"
                    + "from Producto p inner join Color c on p.Id_Color = c.Id_Color\n"
                    + "inner join Corrida cr on p.Id_Corrida = cr.Id_Corrida\n"
                    + "inner join Precios l on l.Id_Producto = p.Id_Producto\n"
                    + "WHERE p.Activo = 1 and l.Activo = 1 and p.Id_Producto LIKE'" + filtro + "%' ORDER BY p.Descripcion");

            rs = st.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_Color(rs.getInt("Id_Color"));
                producto.setId_Corrida(rs.getInt("Id_Corrida"));
                producto.setDescripcionColor(rs.getString("Color"));
                producto.setDescripcionCorrida(rs.getString("Corrida"));
                producto.setId_Producto(rs.getInt("Id_Producto"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setPrecioA(rs.getDouble("PrecioA"));
                producto.setPrecioB(rs.getDouble("PrecioB"));
                producto.setId_Lista(rs.getInt("Id_Lista"));

                listaProductos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaProductos;
    }

    public ArrayList<Producto> GetByC(String filtro) {
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        try {
            st = c.prepareStatement("select  p.Descripcion,p.Id_Producto,\n"
                    + "p.Id_Color, p.Id_Corrida,c.Descripcion as Color,cr.Descripcion as Corrida,\n"
                    + "cr.Punto_Inicial,cr.Punto_Final\n"
                    + "from Producto p inner join Color c on p.Id_Color = c.Id_Color\n"
                    + "inner join Corrida cr on p.Id_Corrida = cr.Id_Corrida\n"
                    + "WHERE p.Activo = 1  and p.Descripcion LIKE'" + filtro + "%' and p.Activo = 1 ORDER BY p.Descripcion");

            rs = st.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_Color(rs.getInt("Id_Color"));
                producto.setId_Corrida(rs.getInt("Id_Corrida"));
                producto.setDescripcionColor(rs.getString("Color"));
                producto.setDescripcionCorrida(rs.getString("Corrida"));
                producto.setId_Producto(rs.getInt("Id_Producto"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setPti(rs.getFloat("Punto_Inicial"));
                producto.setPtf(rs.getFloat("Punto_Final"));

                listaProductos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaProductos;
    }

    public ArrayList<Producto> productoSearch(String filtro) {
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        try {
            st = c.prepareStatement("SELECT p.Id_Producto, p.Descripcion, p.Observaciones, c.Descripcion as Color,cr.Descripcion as Corrida,\n"
                    + "l.Descripcion as Linea, p.Id_Color,p.Id_Corrida, p.Id_linea\n"
                    + "FROM Producto p INNER JOIN Color c on p.Id_Color = c.Id_Color\n"
                    + "INNER JOIN Corrida cr on p.Id_Corrida = cr.Id_Corrida\n"
                    + "INNER JOIN Linea l on p.Id_Linea = l.Id_Linea WHERE p.Activo = 1 AND p.Descripcion LIKE '%" + filtro + "%'"
                    + "ORDER BY p.Descripcion");

            rs = st.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_Color(rs.getInt("Id_Color"));
                producto.setId_Corrida(rs.getInt("Id_Corrida"));
                producto.setId_Linea(rs.getInt("Id_Linea"));
                producto.setDescripcionColor(rs.getString("Color"));
                producto.setDescripcionCorrida(rs.getString("Corrida"));
                producto.setDescripcionLinea(rs.getString("Linea"));
                producto.setId_Producto(rs.getInt("Id_Producto"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setObservaciones(rs.getString("Observaciones"));

                listaProductos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaProductos;
    }

    public ArrayList<Producto> GetByCosto(String filtro) {
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        try {
            String sql = "SELECT * FROM Producto WHERE Activo = 1 AND  Descripcion LIKE '%" + filtro + "%'"
                    + "ORDER BY Descripcion";
            sta = c.createStatement();
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_Linea(rs.getInt("Id_Linea"));
                producto.setId_Color(rs.getInt("Id_Color"));
                producto.setId_Corrida(rs.getInt("Id_Color"));
                producto.setId_Producto(rs.getInt("Id_Producto"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setObservaciones(rs.getString("Observaciones"));
                listaProductos.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProductos;
    }
    
     public ArrayList<Producto> GetByCliente(int id, String filtro) {
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        try {
            st = c.prepareStatement("select p.Id_Producto,p.Descripcion  as Suela,cr.Punto_Inicial, cr.Punto_Final,cr.Descripcion as Corrida,\n"
                    + "cl.Descripcion as Color,pc.PrecioA,pc.PrecioB,PC.PrecioAP,PC.PrecioBP\n"
                    + "from RCPTPhylonA.dbo.Precios as pc inner join ProduccionPhy.dbo.Producto as p\n"
                    + "on pc.Id_Producto = p.Id_Producto \n"
                    + "inner join ProduccionPhy.dbo.Color as cl\n"
                    + "on p.Id_Color = cl.Id_Color\n"
                    + "inner join ProduccionPhy.dbo.Corrida as cr\n"
                    + "on p.Id_Corrida = cr.Id_Corrida\n"
                    + "inner join CobranzaPhy.dbo.Clientes as c on pc.Id_Cliente = c.Id_Cliente\n"
                    + "where pc.Id_Cliente=" + id
                    +"and p.Descripcion like '%" + filtro + "%' and pc.Activo = 1 order by P.Descripcion");
            rs = st.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_Producto(rs.getInt("Id_Producto"));
                producto.setDescripcion(rs.getString("Suela"));
                producto.setPti(rs.getFloat("Punto_Inicial"));
                producto.setPtf(rs.getFloat("Punto_Final"));
                producto.setDescripcionCorrida(rs.getString("Corrida"));
                producto.setDescripcionColor(rs.getString("Color"));
                producto.setPrecioA(rs.getDouble("PrecioA"));
                producto.setPrecioB(rs.getDouble("PrecioB"));
                producto.setPrecioAP(rs.getDouble("PrecioAP"));
                producto.setPrecioBP(rs.getDouble("PrecioBP"));
                listaProductos.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProductos;
    }

    public boolean productoUpdate(Producto producto) {
        try {
            st = c.prepareStatement("UPDATE Producto SET Descripcion=?,Observaciones=?,"
                    + "Id_Color=?, Id_Corrida=?,Id_Linea=?  WHERE Id_Producto=?");
            c.setAutoCommit(false);
            st.setString(1, producto.getDescripcion());
            st.setString(2, producto.getObservaciones());
            st.setInt(3, producto.getId_Color());
            st.setInt(4, producto.getId_Corrida());
            st.setInt(5, producto.getId_Linea());
            st.setInt(6, producto.getId_Producto());
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean productoDelete(int Id_Producto) {
        try {
            st = c.prepareStatement("select d.Estatus,p.Id_Producto from RCPTPhylonA.dbo.Dpedido d\n"
                    + "inner join ProduccionPhy.dbo.Producto p on p.Id_Producto = d.Id_Producto\n"
                    + "where p.Id_Producto =? and d.Estatus<>30");
            c.setAutoCommit(false);
            st.setInt(1, Id_Producto);
            rs = st.executeQuery();
            if (rs.next()) {

                return false;
            } else {
                st = c.prepareStatement("UPDATE Producto set Activo = 0 where Id_Producto=?");
                st.setInt(1, Id_Producto);
                st.execute();
                c.commit();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public int validarProd(int id) {
        try {
            st = c.prepareStatement("SELECT COUNT(p.Id_Producto) from RCPTPhylonA.dbo.Dpedido p\n"
                    + "inner join Producto pd on pd.Id_Producto = p.Id_Producto\n"
                    + "where p.Id_Producto = ?");
            st.setInt(1, id);

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

    public void getCorrida(int Id_Producto) {
        try {
            st = c.prepareStatement("select cr.Descripcion,cr.Id_Corrida\n"
                    + "from Producto p inner join Corrida cr\n"
                    + "on p.Id_Corrida = cr.Id_Corrida where p.Id_Producto=" + Id_Producto);
            rs = st.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_Corrida(rs.getInt("Id_Corrida"));
                producto.setDescripcionCorrida(rs.getString("Descripcion"));
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
