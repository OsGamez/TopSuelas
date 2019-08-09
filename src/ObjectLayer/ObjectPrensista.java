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
public class ObjectPrensista {

    PreparedStatement st = null;
    ResultSet rs = null;
    Connection c = Server.getProduccion();
//    DB db = new DB();
//    Connection c = db.Produccion();

    public ArrayList<Prensista> PrensistaGetAll() {
        ArrayList<Prensista> listaPrensistas = new ArrayList<>();
        try {
            st = c.prepareStatement("select top(50) prensista,nombre, apellidos from Prensistas  "
                    + "where stat='1' order by nombre");
            rs = st.executeQuery();
            while (rs.next()) {
                Prensista m = new Prensista();
                m.setId(rs.getInt("prensista"));
                m.setNombre(rs.getString("nombre"));
                m.setApellido(rs.getString("Apellidos"));
                listaPrensistas.add(m);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        }
        return listaPrensistas;
    }

    public ArrayList<Prensista> BuscaPrensista(String dato) {
        ArrayList<Prensista> listaPrensistas = new ArrayList<>();
        try {
            st = c.prepareStatement("select prensista,nombre,apellidos from Prensistas \n"
                    + "where stat='1' and nombre like '%" + dato + "%' \n"
                    + "order by nombre");
            rs = st.executeQuery();
            while (rs.next()) {
                 Prensista m = new Prensista();
                m.setId(rs.getInt("prensista"));
                m.setNombre(rs.getString("nombre"));
                m.setApellido(rs.getString("Apellidos"));
                listaPrensistas.add(m);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPrensistas;
    }

    public boolean BuscaPrensistab(Prensista p) {
        boolean resp = true;
        try {
            st = c.prepareStatement("select Nombre,Apellidos from Prensistas \n"
                    + "where Nombre = '" + p.getNombre()+ "' and apellidos ='"+p.getApellido()+"' \n"
                    + "order by nombre");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = false;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    public void PrensistaDelete(int Prensista) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE Prensistas set stat ='0' where Prensista=" + Prensista+"");
            st.executeUpdate();
            c.commit();
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
                Logger.getLogger(ObjectPrensista.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }finally {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(ObjectPrensista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean PrensistaUpdate(Prensista p) {
        try {
            c.setAutoCommit(false);
            String q;
                    q = "update prensistas set nombre ='"+p.getNombre()+"', Apellidos ='"+p.getApellido()+"' "
                            + "where prensista ="+p.getId()+"";
                    st = c.prepareStatement(q);
                    st.executeUpdate();
             
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectPrensista.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }finally {
            try {
                st.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(ObjectPrensista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean PrensistaAdd(Prensista p) {
        try {
            c.setAutoCommit(false);
            String q = "insert into Prensistas(nombre,apellidos,stat) values('"+p.getNombre()+"','"+p.getApellido()+"','1')";
            try {
                st = c.prepareStatement(q);
                st.execute();
                st.close();
                c.commit();
                return true;
            } catch (SQLException ex) {
                c.rollback();
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObjectPrensista.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(ObjectPrensista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}
