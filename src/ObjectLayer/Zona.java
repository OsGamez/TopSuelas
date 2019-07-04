package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Zona {

    private int Id_Zona;
    private String Descripcion;
    private boolean Activo;

    PreparedStatement st = null;
    Connection c = Server.getCobranza();
//    DB db = new DB();
//    Connection c = db.Cobranza();
    ResultSet rs = null;

    public Zona() {
    }

    public int getId_Zona() {
        return Id_Zona;
    }

    public void setId_Zona(int Id_Zona) {
        this.Id_Zona = Id_Zona;
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

    public Vector<Zona> getZonas() {

        Vector<Zona> datos = new Vector<Zona>();
        Zona zn = null;

        try {
            st = c.prepareStatement("SELECT * FROM Zonas WHERE Activo = 1");
            rs = st.executeQuery();

            zn = new Zona();
            zn.setId_Zona(0);
            zn.setDescripcion("Seleciona una zona");
            datos.add(zn);

            while (rs.next()) {
                zn = new Zona();
                zn.setId_Zona(rs.getInt("Id_Zona"));
                zn.setDescripcion(rs.getString("Descripcion"));
                datos.add(zn);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }
}
