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
public class ObjectConsumos {

    PreparedStatement st = null;
    ResultSet rs = null;
    //Connection c = Server.getProduccion();
    DB db = new DB();
    Connection c = db.Produccion();
    
    public ArrayList<Consumo> ConsumoGetAll() {
        ArrayList<Consumo> listaconsumos = new ArrayList<>();
        try {
            st = c.prepareStatement("select p.id_producto as 'producto',punto,peso,desperdicio,p.descripcion as 'descripcion' \n"
                    + "from consumos c join Producto p on c.id_producto=p.Id_Producto where stat='1'");
            rs = st.executeQuery();
            while (rs.next()) {
                Consumo c = new Consumo();
                c.setProducto(rs.getInt("producto"));
                c.setPunto(rs.getInt("punto"));
                c.setPeso(rs.getFloat("peso"));
                c.setDesperdicio(rs.getFloat("desperdicio"));
                c.setDescripcionprod(rs.getString("descripcion"));
                listaconsumos.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        }
        return listaconsumos;
    }

    public ArrayList<Consumo> BuscaConsumo(String dato) {
        ArrayList<Consumo> listaconsumos = new ArrayList<>();
        try {
            st = c.prepareStatement("select p.id_producto as 'producto',punto,peso,desperdicio,p.descripcion as 'descripcion' \n"
                    + "from consumos c join Producto p on c.id_producto=p.Id_Producto where p.descripcion like '%" + dato + "%'"
                    + "order by p.descripcion");
            rs = st.executeQuery();
            while (rs.next()) {
                Consumo c = new Consumo();
                c.setProducto(rs.getInt("producto"));
                c.setPunto(rs.getInt("punto"));
                c.setPeso(rs.getFloat("peso"));
                c.setDesperdicio(rs.getFloat("desperdicio"));
                c.setDescripcionprod(rs.getString("descripcion"));
                listaconsumos.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaconsumos;
    }

    public boolean BuscaConsumob(Consumo sumos) {
        boolean resp = true;
        try {
            st = c.prepareStatement("select id_producto from consumos "
                    + "where id_producto= " + sumos.getProducto() + " and punto =" + sumos.getPunto());
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

    public void ConsumoDelete(Consumo sumos) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE Consumos set stat ='0' where id_producto=" + sumos.getProducto() + " and punto=" + sumos.getPunto());
            st.executeUpdate();
            c.commit();
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectConsumos.class.getName()).log(Level.SEVERE, null, ex1);
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

    public boolean ConsumoUpdate(Consumo sumos) {
        try {
            c.setAutoCommit(false);
            String q = "update Consumos set peso=" + sumos.getPeso() + ", desperdicio=" + sumos.getDesperdicio()
                    + " where id_producto=" + sumos.getProducto() + " and punto=" + sumos.getPunto();
            st = c.prepareStatement(q);
            st.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectConsumos.class.getName()).log(Level.SEVERE, null, ex1);
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

    public boolean ConsumoUpdateDesperdicio(Consumo consumo) {
        ArrayList<Consumo> listaconsumos = new ArrayList<>();
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("select c.id_producto  from consumos c \n"
                    + "join producto p on c.id_producto =p.id_producto\n"
                    + "join Linea l on p.Id_Linea=l.id_linea " + consumo.getConsulta());
            rs = st.executeQuery();
            while (rs.next()) {
                Consumo c = new Consumo();
                c.setProducto(rs.getInt("id_producto"));
                //System.out.println(rs.getInt("id_producto"));
                listaconsumos.add(c);
            }
            rs.close();
            st.close();
            String q="";
            for (int i = 0; i < listaconsumos.size(); i++) {
                q = "update Consumos set desperdicio=" + consumo.getDesperdicio()+" where id_producto="+listaconsumos.get(i).getProducto();
                st = c.prepareStatement(q);
                st.executeUpdate();
            }
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectConsumos.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    public boolean ConsumoAdd(Consumo sumos) {
        try {
            c.setAutoCommit(false);
            String q = "insert into Consumos values(" + sumos.getProducto() + "," + sumos.getPunto() + "," + sumos.getPeso() + ","
                    + sumos.getDesperdicio() + ",'1')";
                st = c.prepareStatement(q);
                st.execute();
                c.commit();
                return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
                Logger.getLogger(ObjectConsumos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectConsumos.class.getName()).log(Level.SEVERE, null, ex1);
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

}
