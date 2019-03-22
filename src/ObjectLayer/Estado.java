package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Estado {

    private int Id_Estado;
    private String Descripcion;
    private boolean Activo;

    PreparedStatement st = null;
    Connection c = Server.getCobranza();
    ResultSet rs = null;

    public Estado() {
    }

    public int getId_Estado() {
        return Id_Estado;
    }

    public void setId_Estado(int Id_Estado) {
        this.Id_Estado = Id_Estado;
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

    public Vector<Estado> getEstados() {

        Vector<Estado> datos = new Vector<Estado>();
        Estado ed = null;

        try {
            st = c.prepareStatement("SELECT * FROM Estados WHERE Activo = 1");
            rs = st.executeQuery();

            ed = new Estado();
            ed.setId_Estado(0);
            ed.setDescripcion("Seleciona un estado");
            datos.add(ed);

            while (rs.next()) {
                ed = new Estado();
                ed.setId_Estado(rs.getInt("Id_Estado"));
                ed.setDescripcion(rs.getString("Descripcion"));
                datos.add(ed);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }

}
