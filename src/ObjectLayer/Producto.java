package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Producto {

    private int Id_Producto;
    private int Id_Linea;
    private String Descripcion;
    private String Observaciones;
    private String DescripcionColor;
    private String DescripcionCorrida;
    private String DescripcionLinea;
    private int Id_Color;
    private int Id_Corrida;
    private boolean Activo;
    private double PrecioA;
    private double PrecioB;
    private int Id_Lista;
    PreparedStatement st = null;
    Connection c = Conexion.getProduccion();
    ResultSet rs = null;

    public Producto() {
    }

    public int getId_Lista() {
        return Id_Lista;
    }

    public void setId_Lista(int Id_Lista) {
        this.Id_Lista = Id_Lista;
    }

    public double getPrecioA() {
        return PrecioA;
    }

    public void setPrecioA(double PrecioA) {
        this.PrecioA = PrecioA;
    }

    public double getPrecioB() {
        return PrecioB;
    }

    public void setPrecioB(double PrecioB) {
        this.PrecioB = PrecioB;
    }

    public String getDescripcionColor() {
        return DescripcionColor;
    }

    public void setDescripcionColor(String DescripcionColor) {
        this.DescripcionColor = DescripcionColor;
    }

    public String getDescripcionCorrida() {
        return DescripcionCorrida;
    }

    public void setDescripcionCorrida(String DescripcionCorrida) {
        this.DescripcionCorrida = DescripcionCorrida;
    }

    public String getDescripcionLinea() {
        return DescripcionLinea;
    }

    public void setDescripcionLinea(String DescripcionLinea) {
        this.DescripcionLinea = DescripcionLinea;
    }

    public int getId_Producto() {
        return Id_Producto;
    }

    public int getId_Linea() {
        return Id_Linea;
    }

    public void setId_Linea(int Id_Linea) {
        this.Id_Linea = Id_Linea;
    }

    public void setId_Producto(int Id_Producto) {
        this.Id_Producto = Id_Producto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public int getId_Color() {
        return Id_Color;
    }

    public void setId_Color(int Id_Color) {
        this.Id_Color = Id_Color;
    }

    public int getId_Corrida() {
        return Id_Corrida;
    }

    public void setId_Corrida(int Id_Corrida) {
        this.Id_Corrida = Id_Corrida;
    }

    public boolean getActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    @Override
    public String toString() {
        return this.Descripcion;
    }

    public Vector<Producto> getProductos() {

        Vector<Producto> datos = new Vector<Producto>();
        Producto p = null;

        try {
            st = c.prepareStatement("SELECT * FROM Producto WHERE Activo = 1 ORDER BY Descripcion");
            rs = st.executeQuery();

            p = new Producto();
            p.setId_Producto(0);
            p.setDescripcion("Seleciona un producto");
            datos.add(p);

            while (rs.next()) {
                p = new Producto();
                p.setId_Producto(rs.getInt("Id_Producto"));
                p.setDescripcion(rs.getString("Descripcion"));
                datos.add(p);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }

    public Vector<Producto> getProd(int Id_Cliente) {
        Vector<Producto> datos = new Vector<Producto>();
        Producto pc = null;

        try {
            st = c.prepareStatement("select p.Id_Producto,p.Descripcion  as Combinacion\n"
                    + "from RCPTPhylonA.dbo.Precios as pc inner join ProduccionPhy.dbo.Producto as p\n"
                    + "on pc.Id_Producto = p.Id_Producto \n"
                    + "inner join ProduccionPhy.dbo.Color as cl\n"
                    + "on p.Id_Color = cl.Id_Color\n"
                    + "inner join ProduccionPhy.dbo.Corrida as cr\n"
                    + "on p.Id_Corrida = cr.Id_Corrida\n"
                    + "inner join CobranzaPhy.dbo.Clientes as c on pc.Id_Cliente = c.Id_Cliente\n"
                    + "where pc.Id_Cliente=" + Id_Cliente
                    + "and pc.Activo = 1 order by P.Descripcion");
            rs = st.executeQuery();

            pc = new Producto();
            pc.setId_Producto(0);
            pc.setDescripcion("Seleciona un producto");
            datos.add(pc);

            while (rs.next()) {
                pc = new Producto();
                pc.setId_Producto(rs.getInt("Id_Producto"));
                pc.setDescripcion(rs.getString("Combinacion"));
                datos.add(pc);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }

    public Vector<Producto> getPventa() {
        Vector<Producto> datos = new Vector<Producto>();
        Producto p = null;

        try {
            st = c.prepareStatement("select p.Id_Producto,(p.Descripcion ) as Combinacion\n"
                    + "from Producto p inner join Color c on p.Id_Color = c.Id_Color\n"
                    + "inner join Corrida cr on p.Id_Corrida = cr.Id_Corrida where p.Activo = 1 order by Combinacion");
            rs = st.executeQuery();

            p = new Producto();
            p.setId_Producto(0);
            p.setDescripcion("Seleciona un producto");
            datos.add(p);

            while (rs.next()) {
                p = new Producto();
                p.setId_Producto(rs.getInt("Id_Producto"));
                p.setDescripcion(rs.getString("Combinacion"));
                datos.add(p);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }
}
