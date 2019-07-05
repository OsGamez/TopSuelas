package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Pais {

    private int Id_Pais;
    private String Descripcion;
    private boolean Activo;

    PreparedStatement st = null;
    Connection c = Server.getCobranza();
//    DB db = new DB();
//    Connection c = db.Cobranza();
   
    ResultSet rs = null;

    public Pais() {
    }

    public int getId_Pais() {
        return Id_Pais;
    }

    public void setId_Pais(int Id_Pais) {
        this.Id_Pais = Id_Pais;
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

    public Vector<Pais> getPaises() {

        Vector<Pais> datos = new Vector<Pais>();
        Pais ps = null;

        try {
            st = c.prepareStatement("SELECT * FROM Paises WHERE Activo = 1");
            rs = st.executeQuery();

            ps = new Pais();
            ps.setId_Pais(0);
            ps.setDescripcion("Seleciona un pais");
            datos.add(ps);

            while (rs.next()) {
                ps = new Pais();
                ps.setId_Pais(rs.getInt("Id_Pais"));
                ps.setDescripcion(rs.getString("Descripcion"));
                datos.add(ps);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }
}
