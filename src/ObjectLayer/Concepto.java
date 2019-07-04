
package ObjectLayer;

import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class Concepto {
    
    
    PreparedStatement st = null;
    ResultSet rs = null;
//    DB db = new DB();
//    Connection c = db.RCPTPhylonA();
    Connection c = Server.getRcpt();
    
    private String Cuenta;
    private String SubCuenta;
    private String Descripcion;

    public String getCuenta() {
        return Cuenta;
    }

    public void setCuenta(String Cuenta) {
        this.Cuenta = Cuenta;
    }

    public String getSubCuenta() {
        return SubCuenta;
    }

    public void setSubCuenta(String SubCuenta) {
        this.SubCuenta = SubCuenta;
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
    
    public Vector<Concepto>getCp() {
        Vector<Concepto> datos = new Vector<Concepto>();
        Concepto ct = null;

        try {
            st = c.prepareStatement("SELECT * FROM Conceptoses ORDER BY Descripcion");
            rs = st.executeQuery();

            ct = new Concepto();
            ct.setCuenta(String.valueOf(0));
            ct.setDescripcion("Seleciona una cuenta");
            datos.add(ct);

            while (rs.next()) {
                ct = new Concepto();
                ct.setCuenta(rs.getString("Cuenta"));
                ct.setDescripcion(rs.getString("Descripcion"));
                ct.setSubCuenta(rs.getString("SubCuenta"));
                datos.add(ct);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }
}
