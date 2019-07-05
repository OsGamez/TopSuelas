package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Linea {

    private int Id_Linea;
    private String Descripcion;
    private boolean Activo;

    PreparedStatement st = null;
//    DB db = new DB();
//    Connection c = db.Produccion();
    Connection c = Server.getProduccion();
    ResultSet rs = null;

    public Linea() {
    }

    public int getId_Linea() {
        return Id_Linea;
    }

    public void setId_Linea(int Id_Linea) {
        this.Id_Linea = Id_Linea;
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

    public Vector<Linea> getLinea() {

        Vector<Linea> datos = new Vector<Linea>();
        Linea ln = null;

        try {
            st = c.prepareStatement("SELECT * FROM Linea WHERE Activo = 1 ORDER BY Descripcion");
            rs = st.executeQuery();

            ln = new Linea();
            ln.setId_Linea(0);
            ln.setDescripcion("Seleciona una linea");
            datos.add(ln);

            while (rs.next()) {
                ln = new Linea();
                ln.setId_Linea(rs.getInt("Id_Linea"));
                ln.setDescripcion(rs.getString("Descripcion"));
                datos.add(ln);
            }
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }
}
