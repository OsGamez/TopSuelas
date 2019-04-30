package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Banco {

    private int Id_Banco;
    private String Descripcion;
    private String RFC;
    private String CTA;
    private boolean Activo;

    PreparedStatement st = null;
    Connection c = Server.getCobranza();
    ResultSet rs = null;

    public Banco() {
    }

    public int getId_Banco() {
        return Id_Banco;
    }

    public void setId_Banco(int Id_Banco) {
        this.Id_Banco = Id_Banco;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getCTA() {
        return CTA;
    }

    public void setCTA(String CTA) {
        this.CTA = CTA;
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

    public Vector<Banco> getBancos() {

        Vector<Banco> datos = new Vector<Banco>();
        Banco bc = null;

        try {
            st = c.prepareStatement("SELECT * FROM Bancos WHERE Activo = 1");
            rs = st.executeQuery();

            bc = new Banco();
            bc.setId_Banco(0);
            bc.setDescripcion("Seleciona un banco");
            datos.add(bc);

            while (rs.next()) {
                bc = new Banco();
                bc.setId_Banco(rs.getInt("Id_Banco"));
                bc.setDescripcion(rs.getString("Descripcion"));
                bc.setRFC(rs.getString("RFC"));
                bc.setCTA(rs.getString("CTA"));
                datos.add(bc);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }
}
