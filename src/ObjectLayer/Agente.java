package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Agente {

    private int Id_Agente;
    private String Descripcion;
    private boolean Activo;

    PreparedStatement st = null;
    Connection c = Conexion.getCobranza();
    ResultSet rs = null;

    public Agente() {
    }

    public int getId_Agente() {
        return Id_Agente;
    }

    public void setId_Agente(int Id_Agente) {
        this.Id_Agente = Id_Agente;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public boolean getActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    @Override
    public String toString() {
        return this.getDescripcion();
    }

    public Vector<Agente> getAgentes() {

        Vector<Agente> datos = new Vector<Agente>();
        Agente a = null;

        try {
            st = c.prepareStatement("SELECT * FROM Agentes WHERE Activo = 1");
            rs = st.executeQuery();

            a = new Agente();
            a.setId_Agente(0);
            a.setDescripcion("Seleciona un agente");
            datos.add(a);

            while (rs.next()) {
                a = new Agente();
                a.setId_Agente(rs.getInt("Id_Agente"));
                a.setDescripcion(rs.getString("Descripcion"));
                datos.add(a);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }
}
