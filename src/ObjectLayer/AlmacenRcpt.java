
package ObjectLayer;

import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class AlmacenRcpt {
    
    private int Almacen;
    private String Descripcion;
    
    PreparedStatement st = null;
    Connection c = Server.getRcpt();
    ResultSet rs = null;
  
    public AlmacenRcpt() {
    }

    public int getAlmacen() {
        return Almacen;
    }

    public void setAlmacen(int Almacen) {
        this.Almacen = Almacen;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return this.Descripcion;
    }

    public Vector<AlmacenRcpt>getAlmacenes() {

        Vector<AlmacenRcpt> datos = new Vector<AlmacenRcpt>();
        AlmacenRcpt a = null;

        try {
            st = c.prepareStatement("SELECT * FROM Almacenes  ORDER BY Descripcion");
            rs = st.executeQuery();

            a = new AlmacenRcpt();
            a.setAlmacen(0);
            a.setDescripcion("Seleciona un almacen");
            datos.add(a);

            while (rs.next()) {
                a = new AlmacenRcpt();
                a.setAlmacen(rs.getInt("Almacen"));
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
