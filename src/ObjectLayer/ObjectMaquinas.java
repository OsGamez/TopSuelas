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
public class ObjectMaquinas {

    PreparedStatement st = null;
    ResultSet rs = null;
    Connection c = Server.getProduccion();

    public ArrayList<Maquina> MaquinaGetAll() {
        ArrayList<Maquina> listamaquinas = new ArrayList<Maquina>();
        try {
            st = c.prepareStatement("select m.maquina as 'maquina', m.stat as 'stat',"
                    + "count(e.maquina) as 'estaciones' from maquinas m join estaciones e on e.maquina=m.maquina "
                    + "where m.stat='1' and e.stat='1' group by m.maquina,m.stat");
            rs = st.executeQuery();
            while (rs.next()) {
                Maquina m = new Maquina();
                m.setMaquina(rs.getInt("maquina"));
                m.setStatus(rs.getString("stat"));
                m.setEstaciones(rs.getInt("estaciones"));
                listamaquinas.add(m);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        }
        return listamaquinas;
    }

    public ArrayList<Maquina> BuscaMaquina(String dato) {
        ArrayList<Maquina> listamaquinas = new ArrayList<>();
        try {
            st = c.prepareStatement("select m.maquina as 'maquina', m.stat as 'stat',count(e.maquina) as 'estaciones' from maquinas m \n"
                    + "join estaciones e on e.maquina=m.maquina\n"
                    + "where m.stat='1' and e.stat='1' and m.maquina like '%" + dato + "%'\n"
                    + "group by m.maquina,m.stat");
            rs = st.executeQuery();
            while (rs.next()) {
                Maquina m = new Maquina();
                m.setMaquina(rs.getInt("maquina"));
                m.setStatus(rs.getString("stat"));
                m.setEstaciones(rs.getInt("estaciones"));
                listamaquinas.add(m);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listamaquinas;
    }

    public boolean BuscaMaquinab(String dato) {
        boolean resp = true;
        try {
            st = c.prepareStatement("select m.maquina as 'maquina' from maquinas m \n"
                    + "join estaciones e on e.maquina=m.maquina\n"
                    + "where m.maquina = '" + dato + "'\n"
                    + "group by m.maquina,m.stat");
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

    public void MaquinaDelete(int maquina) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE Maquinas set stat ='0' where maquina=" + maquina);
            st.executeUpdate();
            c.commit();
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectMaquinas.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }finally {
            try {
                st.close();
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(ObjectMaquinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean MaquinaUpdate(Maquina m, String resp) {
        try {
            c.setAutoCommit(false);
            String q;
            if (resp.equals("borrar")) {
                for (int i = m.getEstacionesmod() + 1; i <= m.getEstaciones(); i++) {
                    q = "delete from Estaciones where estacion=" + i;
                    st = c.prepareStatement(q);
                    st.executeUpdate();
                }
            } else {
                for (int i = m.getEstaciones() + 1; i <= m.getEstacionesmod(); i++) {
                    q = "insert into estaciones values(" + i + "," + m.getMaquina() + ",'1')";
                    st = c.prepareStatement(q);
                    st.executeUpdate();
                }
            }
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectMaquinas.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }finally {
            try {
                st.close();
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(ObjectMaquinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean MaquinaAdd(Maquina maq) {
        try {
            c.setAutoCommit(false);
            String q = "insert into Maquinas(maquina,stat) values(" + maq.getMaquina() + ",'1')";
            try {
                st = c.prepareStatement(q);
                st.execute();
                c.commit();
                st.close();
                for (int i = 1; i <= maq.getEstaciones(); i++) {
                    q = "insert into Estaciones(estacion,maquina,stat) values(" + i + "," + maq.getMaquina() + ",'1')";
                    st = c.prepareStatement(q);
                    st.execute();
                }
                c.commit();
                return true;
            } catch (SQLException ex) {
                c.rollback();
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObjectMaquinas.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                st.close();
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(ObjectMaquinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}
