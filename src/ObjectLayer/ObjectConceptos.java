

package ObjectLayer;

import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ObjectConceptos {
    PreparedStatement st = null;
    ResultSet rs = null;
//    Connection c = Server.getPhylon();
    DB db = new DB();
    Connection c = db.Cmp();
    
    
    public boolean conceptoAdd(String Cuenta, String SubCuenta, String Des) {
            try {
                c.setAutoCommit(false);
                st = c.prepareStatement("INSERT INTO Conceptoses(Cuenta,SubCuenta,Descripcion)"
                       + "VALUES(?,?,?)");
                st.setString(1, Cuenta);
                st.setString(2, SubCuenta);
                st.setString(3, Des);
                st.executeUpdate();
                c.commit();
                st.close();
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } 
        return false;
    }
    
    public boolean conceptoUpdate(String Des, String Cuenta){
        try {
                st = c.prepareStatement("UPDATE Conceptoses SET Descripcion = ? WHERE Cuenta = ?");
                st.setString(1, Des);
                st.setString(2, Cuenta);
                st.executeUpdate();
                st.close();
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } 
        return false;
    }
    
    public ArrayList<Concepto> conceptoGetAll() {
        ArrayList<Concepto> listaConcepto = new ArrayList<Concepto>();
        try {
            st = c.prepareStatement("SELECT * FROM Conceptoses ORDER BY Cuenta");
            rs = st.executeQuery();

            while (rs.next()) {
                Concepto cs = new Concepto();
                cs.setCuenta(rs.getString("Cuenta"));
                cs.setSubCuenta(rs.getString("SubCuenta"));
                cs.setDescripcion(rs.getString("Descripcion"));
                listaConcepto.add(cs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaConcepto;
    }
    
    public ArrayList<Concepto> ConceptoSearch(String filtro) {
        ArrayList<Concepto> listaConcepto = new ArrayList<Concepto>();
        try {
            st = c.prepareStatement("SELECT * FROM Conceptoses WHERE Descripcion LIKE'%" + filtro + "%'"
                    + "ORDER BY Cuenta");
            rs = st.executeQuery();

            while (rs.next()) {
                Concepto cs = new Concepto();
                cs.setCuenta(rs.getString("Cuenta"));
                cs.setSubCuenta(rs.getString("SubCuenta"));
                cs.setDescripcion(rs.getString("Descripcion"));
                listaConcepto.add(cs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaConcepto;
    }
    
    public int validarCuenta(String cuenta) {
        try {
            st = c.prepareStatement("SELECT COUNT (Cuenta) FROM Conceptoses WHERE Cuenta = ?");
            st.setString(1, cuenta);

            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 1;
        }
    }
    
    public int validarSubCuenta(String Subcuenta) {
        try {
            st = c.prepareStatement("SELECT COUNT (SubCuenta) FROM Conceptoses WHERE SubCuenta = ?");
            st.setString(1, Subcuenta);

            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 1;
        }
    }
     public boolean conceptoDelete(String Cuenta) {
        try {
            st = c.prepareStatement("DELETE FROM Conceptoses WHERE Cuenta = ?");
            st.setString(1, Cuenta);
            st.execute();
            st.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
