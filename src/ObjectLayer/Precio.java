package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Precio {

    private int Id_Lista;
    private int Id_Cliente;
    private int Id_Producto;
    private double PrecioA;
    private double PrecioB;
    private boolean Activo;
    private String DesProd;
    private String DesCli;

    PreparedStatement st = null;
    Connection c = Server.getRcpt();
    //Connection c = Conexion.getRcpt();
    
    ResultSet rs = null;

    public Precio() {
    }

    public String getDesProd() {
        return DesProd;
    }

    public void setDesProd(String DesProd) {
        this.DesProd = DesProd;
    }

    public String getDesCli() {
        return DesCli;
    }

    public void setDesCli(String DesCli) {
        this.DesCli = DesCli;
    }

    public int getId_Lista() {
        return Id_Lista;
    }

    public void setId_Lista(int Id_Lista) {
        this.Id_Lista = Id_Lista;
    }

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    public int getId_Producto() {
        return Id_Producto;
    }

    public void setId_Producto(int Id_Producto) {
        this.Id_Producto = Id_Producto;
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

    public boolean getActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    public double toDouble() {
        return this.PrecioA;
    }

    public Vector<Precio> getPrecio(int Id_Producto, int Id_Cliente) {
        Vector<Precio> datos = new Vector<Precio>();
        Precio pc = null;

        try {
            st = c.prepareStatement("select pc.PrecioA,pc.Id_Producto,pc.Id_Cliente\n"
                    + "from Precios pc inner join ProduccionPhy.dbo.Producto p\n"
                    + "on pc.Id_Producto = p.Id_Producto \n"
                    + "inner join CobranzaPhy.dbo.Clientes c on pc.Id_Cliente = c.Id_Cliente\n"
                    + "where pc.Id_Cliente =" + Id_Cliente + "and pc.Id_Producto =" + Id_Producto);
            rs = st.executeQuery();

            pc = new Precio();
            while (rs.next()) {
                pc = new Precio();

                pc.setPrecioA(rs.getDouble("PrecioA"));
                pc.setId_Producto(rs.getInt("Id_Producto"));
                pc.setId_Cliente(rs.getInt("Id_Cliente"));
                datos.add(pc);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }
}
