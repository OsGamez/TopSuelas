package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Corrida {

    private int Id_Corrida;
    private String Descripcion;
    private float Punto_Inicial;
    private float Punto_Final;
    private String Observaciones;
    private boolean Activo;

    PreparedStatement st = null;
    Connection c = Server.getProduccion();
    ResultSet rs = null;

    public Corrida() {
    }

    public int getId_Corrida() {
        return Id_Corrida;
    }

    public void setId_Corrida(int Id_Corrida) {
        this.Id_Corrida = Id_Corrida;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public float getPunto_Inicial() {
        return Punto_Inicial;
    }

    public void setPunto_Inicial(float Punto_Inicial) {
        this.Punto_Inicial = Punto_Inicial;
    }

    public float getPunto_Final() {
        return Punto_Final;
    }

    public void setPunto_Final(float Punto_Final) {
        this.Punto_Final = Punto_Final;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
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

    public Vector<Corrida> getCorrida() {

        Vector<Corrida> datos = new Vector<Corrida>();
        Corrida cr = null;

        try {
            st = c.prepareStatement("SELECT * FROM Corrida WHERE Activo = 1");
            rs = st.executeQuery();

            cr = new Corrida();
            cr.setId_Corrida(0);
            cr.setDescripcion("Seleciona una corrida");
            datos.add(cr);

            while (rs.next()) {
                cr = new Corrida();
                cr.setId_Corrida(rs.getInt("Id_Corrida"));
                cr.setDescripcion(rs.getString("Descripcion"));
                datos.add(cr);
            }
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }

    public Vector<Corrida> getCorridas(int Id_Producto) {
        Vector<Corrida> datos = new Vector<Corrida>();
        Corrida pc = null;

        try {
            st = c.prepareStatement("select cr.Descripcion,cr.Id_Corrida\n"
                    + "from Producto p inner join Corrida cr\n"
                    + "on p.Id_Corrida = cr.Id_Corrida where p.Id_Producto=" + Id_Producto);
            rs = st.executeQuery();

            pc = new Corrida();
            //pc.setId_Corrida(0);
            //pc.setDescripcion("Seleciona");
            //datos.add(pc);

            while (rs.next()) {
                pc = new Corrida();
                pc.setId_Corrida(rs.getInt("Id_Corrida"));
                pc.setDescripcion(rs.getString("Descripcion"));
                datos.add(pc);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }
}
