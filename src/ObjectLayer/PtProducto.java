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
import java.util.Vector;

public class PtProducto {

    PreparedStatement st = null;
//    Connection c = Server.getServer();
    DB db = new DB();
    Connection c = db.Server();
    ResultSet rs = null;
    Statement sta = null;

    private int Producto;
    private String Descripcion;
    private int Corrida;
    private int Estilo;
    private int Combinacion;
    private int Almacen;
    private int Pti;
    private int Ptf;
    private int SuelaPhy;
    private String DescripcionAlmacen;
    private String Estatus;

    public PtProducto() {
    }

    public int getSuelaPhy() {
        return SuelaPhy;
    }

    public void setSuelaPhy(int SuelaPhy) {
        this.SuelaPhy = SuelaPhy;
    }
    
    public int getPti() {
        return Pti;
    }

    public void setPti(int Pti) {
        this.Pti = Pti;
    }

    public int getPtf() {
        return Ptf;
    }

    public void setPtf(int Ptf) {
        this.Ptf = Ptf;
    }

    public int getAlmacen() {
        return Almacen;
    }

    public void setAlmacen(int Almacen) {
        this.Almacen = Almacen;
    }

    public String getDescripcionAlmacen() {
        return DescripcionAlmacen;
    }

    public void setDescripcionAlmacen(String DescripcionAlmacen) {
        this.DescripcionAlmacen = DescripcionAlmacen;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String Estatus) {
        this.Estatus = Estatus;
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

    public int getCorrida() {
        return Corrida;
    }

    public void setCorrida(int Corrida) {
        this.Corrida = Corrida;
    }

    public int getEstilo() {
        return Estilo;
    }

    public void setEstilo(int Estilo) {
        this.Estilo = Estilo;
    }

    public int getCombinacion() {
        return Combinacion;
    }

    public void setCombinacion(int Combinacion) {
        this.Combinacion = Combinacion;
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
