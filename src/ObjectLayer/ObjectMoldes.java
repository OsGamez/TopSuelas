/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectLayer;

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

    public ArrayList<Molde> MoldeGetAll() {
        ArrayList<Molde> listamoldes = new ArrayList<Molde>();
        try {
            st = c.prepareStatement("select molde,punto,cant,stat,suela,l.descripcion as 'descripcion'"
                    + " from Moldes m join Linea l on m.suela=l.Id_Linea where stat='1'");
            rs = st.executeQuery();
            while (rs.next()) {
                Molde m = new Molde();
                m.setMolde(rs.getInt("molde"));
                m.setCantidad(rs.getInt("cant"));
                m.setPunto(rs.getInt("punto"));
                m.setLinea(rs.getShort("suela"));
                m.setStatus(rs.getString("stat"));
                m.setCharlinea(rs.getString("descripcion"));
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
            st = c.prepareStatement("select molde,punto,cant,stat,suela from Moldes m \n"
                    + "join Linea l on m.suela=l.Id_Linea where l.descripcion like '%" + dato + "%' or molde like '%" + dato + "%'");
            rs = st.executeQuery();
            while (rs.next()) {
                Molde m = new Molde();
                m.setMolde(rs.getInt("molde"));
                m.setCantidad(rs.getInt("cant"));
                m.setPunto(rs.getInt("punto"));
                m.setLinea(rs.getShort("linea"));
                m.setStatus(rs.getString("stat"));
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
            st.close();

        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectMoldes.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    public boolean MoldeUpdate(Molde m) {
        try {
            c.setAutoCommit(false);
            String q="UPDATE moldes SET cant="+m.getCantidad()+", punto="+m.getPunto()+", suela="+m.getLinea()+" WHERE molde="+m.getMolde();
            st = c.prepareStatement(q);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectMoldes.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }
        public boolean MoldeAdd(Molde m) {
        try {
            c.setAutoCommit(false);
            String q="insert into Moldes(punto,cant,stat,suela) values("+m.getPunto()+","+m.getCantidad()+",'1',"+m.getLinea()+")";
           try {
                st = c.prepareStatement(q);
                st.execute();
                c.commit();
                st.close();
                return true;
            } catch (SQLException ex) {
                c.rollback();
                st.close();
                ex.printStackTrace();
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ObjectPrecios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
