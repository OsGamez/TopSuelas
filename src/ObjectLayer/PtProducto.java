package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class PtProducto {

    PreparedStatement st = null;
    Connection c = Server.getServer();
    ResultSet rs = null;
    Statement sta = null;

    private int Producto;
    private String Descripcion;

    public PtProducto() {
    }

    public int getProducto() {
        return Producto;
    }

    public void setProducto(int Producto) {
        this.Producto = Producto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return this.Descripcion;
    }

    
    
    public Vector<PtProducto> getProductos() {
        Vector<PtProducto> datos = new Vector<PtProducto>();
        PtProducto p = null;

        try {
            st = c.prepareStatement("SELECT Producto, Descripcion FROM Productos ORDER BY Descripcion");
            rs = st.executeQuery();

            p = new PtProducto();
            p.setProducto(0);
            p.setDescripcion("Seleciona un producto");
            datos.add(p);

            while (rs.next()) {
                p = new PtProducto();
                p.setProducto(rs.getInt("Producto"));
                p.setDescripcion(rs.getString("Descripcion"));
                datos.add(p);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }

    public Vector<PtProducto> getProducto(String Descripcion) {
        Vector<PtProducto> datos = new Vector<PtProducto>();
        PtProducto p = null;

        try {
            st = c.prepareStatement("select pt.Producto,pt.Descripcion\n"
                    + "from [RCPTPhylon].dbo.[Productos] pt WHERE Descripcion = ?");
            st.setString(1, Descripcion);
            rs = st.executeQuery();

            /*p = new PtProducto();
            p.setProducto(0);
            p.setDescripcion("Seleciona un producto");
            datos.add(p);*/
            while (rs.next()) {
                p = new PtProducto();
                p.setProducto(rs.getInt("Producto"));
                p.setDescripcion(rs.getString("Descripcion"));
                datos.add(p);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }
}
