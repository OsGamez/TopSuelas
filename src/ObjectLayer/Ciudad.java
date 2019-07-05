package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Ciudad {
//    DB db = new DB();
    
    private int Id_Ciudad;
    private String Descripcion;
    private boolean Activo;

    PreparedStatement st = null;
    Connection c = Server.getCobranza();
//    Connection c = db.Cobranza();
    ResultSet rs = null;

    public Ciudad() {
    }

    public int getId_Ciudad() {
        return Id_Ciudad;
    }

    public void setId_Ciudad(int Id_Ciudad) {
        this.Id_Ciudad = Id_Ciudad;
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
        return this.Descripcion;
    }

    public Vector<Ciudad> getCiudades() {

        Vector<Ciudad> datos = new Vector<Ciudad>();
        Ciudad cd = null;

        try {
            st = c.prepareStatement("SELECT * FROM Ciudades WHERE Activo = 1");
            rs = st.executeQuery();

            cd = new Ciudad();
            cd.setId_Ciudad(0);
            cd.setDescripcion("Seleciona una ciudad");
            datos.add(cd);

            while (rs.next()) {
                cd = new Ciudad();
                cd.setId_Ciudad(rs.getInt("Id_Ciudad"));
                cd.setDescripcion(rs.getString("Descripcion"));
                datos.add(cd);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }
}
