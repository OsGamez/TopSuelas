/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectLayer;

import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-
 */
public class ObjectMoldes {

    PreparedStatement st = null;
    ResultSet rs = null;
    Connection c = Server.getProduccion();
//    DB db = new DB();
//    Connection c = db.Produccion();

    public ArrayList<Molde> MoldeGetAll() {
        ArrayList<Molde> listamoldes = new ArrayList<Molde>();
        try {
            st = c.prepareStatement("select molde,punto,cant,stat,suela,l.descripcion as 'descripcion',parxcaja"
                    + " from Moldes m join Linea l on m.suela=l.Id_Linea where stat='1'");
            rs = st.executeQuery();
            while (rs.next()) {
                Molde m = new Molde();
                m.setMolde(rs.getInt("molde"));
                m.setCantidad(rs.getInt("cant"));
                m.setPunto(rs.getString("punto"));
                m.setLinea(rs.getShort("suela"));
                m.setStatus(rs.getString("stat"));
                m.setCharlinea(rs.getString("descripcion"));
                m.setParxcaja(rs.getInt("parxcaja"));
                listamoldes.add(m);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        }
        return listamoldes;
    }

    public ArrayList<Molde> BuscaMolde(String dato) {
        ArrayList<Molde> listamoldes = new ArrayList<Molde>();
        try {
            st = c.prepareStatement("select molde,punto,cant,stat,suela,l.descripcion as 'descripcion',parxcaja from Moldes m \n"
                    + "join Linea l on m.suela=l.Id_Linea where l.descripcion like '%" + dato + "%' or molde like '%" + dato + "%'");
            rs = st.executeQuery();
            while (rs.next()) {
                Molde m = new Molde();
                m.setMolde(rs.getInt("molde"));
                m.setCantidad(rs.getInt("cant"));
                m.setPunto(rs.getString("punto"));
                m.setLinea(rs.getShort("suela"));
                m.setStatus(rs.getString("stat"));
                m.setCharlinea(rs.getString("descripcion"));
                m.setParxcaja(rs.getInt("parxcaja"));
                listamoldes.add(m);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listamoldes;
    }

    public void MoldeDelete(int molde) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE Moldes set stat ='0' where molde=" + molde);
            st.executeUpdate();
            c.commit();
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectMoldes.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                st.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(ObjectMoldes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean MoldeUpdate(Molde m) {
        try {
            c.setAutoCommit(false);
            String q = "UPDATE moldes SET cant=" + m.getCantidad() + ", punto='" +
                    m.getPunto() + "', suela=" + m.getLinea() +", parxcaja="+m.getParxcaja()+ " WHERE molde=" + m.getMolde();
            st = c.prepareStatement(q);
            st.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectMoldes.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                st.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(ObjectMoldes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean MoldeAdd(Molde m) {
        try {
            c.setAutoCommit(false);
            String q = "insert into Moldes(punto,cant,stat,suela,parxcaja) values('"
                    + m.getPunto() + "'," + m.getCantidad() + ",'1'," + m.getLinea() + ","+m.getParxcaja()+")";
            st = c.prepareStatement(q);
            st.execute();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
                Logger.getLogger(ObjectPrecios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectMoldes.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                st.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(ObjectMoldes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}
