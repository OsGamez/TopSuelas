

package ObjectLayer;

import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ObjectConceptosPrima {
    PreparedStatement st = null;
    ResultSet rs = null;
    Connection c = Server.getCmpPhylon();
    
    
    public boolean conceptoAdd(String Cuenta, String SubCuenta, String Des) {
            try {
                st = c.prepareStatement("INSERT INTO Conceptoses(Cuenta,SubCuenta,Descripcion)"
                       + "VALUES(?,?,?)");
                st.setString(1, Cuenta);
                st.setString(2, SubCuenta);
                st.setString(3, Des);
                st.executeUpdate();
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
            st = c.prepareStatement("SELECT * FROM Conceptoses WHERE Descripcion LIKE'%" + filtro + "%' "
                    + "or cuenta like '%"+filtro+"%' ORDER BY Cuenta");
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
    
    public boolean validarCuenta(String cuenta,String Subcuenta) {
        boolean resp=true;
        try {
            st = c.prepareStatement("SELECT Cuenta FROM Conceptoses WHERE Cuenta = ? and Subcuenta=?");
            st.setString(1, cuenta);
            st.setString(2, Subcuenta);
            rs = st.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                rs.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(ObjectConceptosPrima.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }
    

     public boolean conceptoDelete(String Cuenta,String subcuenta) {
        try {
            st = c.prepareStatement("DELETE FROM Conceptoses WHERE Cuenta = ? and Subcuenta=?");
            st.setString(1, Cuenta);
            st.setString(2, subcuenta);
            st.execute();
            st.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
