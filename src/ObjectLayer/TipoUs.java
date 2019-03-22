package ObjectLayer;

import DataAccesLayer.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class TipoUs {

    private int Id_Tipo;
    private String Nombre;

    PreparedStatement st = null;
    Connection c = Conexion.getConnection();
    ResultSet rs = null;

    public TipoUs() {
    }

    public int getId_Tipo() {
        return Id_Tipo;
    }

    public void setId_Tipo(int Id_Tipo) {
        this.Id_Tipo = Id_Tipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

    public Vector<TipoUs> getUsuarios() {

        Vector<TipoUs> datos = new Vector<TipoUs>();
        TipoUs tp = null;

        try {
            st = c.prepareStatement("SELECT * FROM Tipo_Usuario");
            rs = st.executeQuery();

            tp = new TipoUs();
            tp.setId_Tipo(0);
            tp.setNombre("Seleciona un tipo de usuario");
            datos.add(tp);

            while (rs.next()) {
                tp = new TipoUs();
                tp.setId_Tipo(rs.getInt("Id_Tipo"));
                tp.setNombre(rs.getString("Nombre"));
                datos.add(tp);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }
}
