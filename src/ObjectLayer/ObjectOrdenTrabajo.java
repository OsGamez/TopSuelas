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
public class ObjectOrdenTrabajo {

    PreparedStatement st = null;
    ResultSet rs = null;
    Connection c = Server.getProduccion();
    Connection rcpta = Server.getRcpt();

// consultas
    public ArrayList<String> GetSemana() {
        ArrayList<String> listasem = new ArrayList<>();
        listasem.add("Seleccione Semana:");
        try {
            st = rcpta.prepareStatement("SELECT distinct programa from Programa");
            rs = st.executeQuery();
            while (rs.next()) {
                listasem.add(rs.getString("programa"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        }
        return listasem;
    }

    public ArrayList<Ordentrabajo> GetLineaxSemana(String semana) {
        ArrayList<Ordentrabajo> listasem = new ArrayList<>();
        try {
            int prod;
            PreparedStatement st1 = null;
            ResultSet rs1 = null;
            st = rcpta.prepareStatement("select id_Producto as prod,sum(pares)\n"
                    + "from  Dpedido dp join pedidos p on dp.npedido=p.npedido\n"
                    + "where  datepart(wk,fecha_captura) =" + semana + " and dp.estatus ='20' \n"
                    + "group by id_producto\n"
                    + "order by sum(pares) desc");
            rs = st.executeQuery();
            while (rs.next()) {
                prod = rs.getInt("prod");
                st1 = rcpta.prepareStatement("select prod.Id_Producto as producto,prod.descripcion as nombre,sum(pares) as pares \n"
                        + ",id_linea from programa p join ProduccionPhy.dbo.Producto prod \n"
                        + "on p.producto =prod.id_producto\n"
                        + "where  programa =" + semana + " and prod.id_producto=" + prod + "\n"
                        + "group by prod.id_producto,prod.descripcion,id_linea\n"
                        + "order by pares desc");
                rs1 = st1.executeQuery();
                while (rs1.next()) {
                    Ordentrabajo ot = new Ordentrabajo();
                    ot.setProducto(rs1.getInt("producto"));
                    ot.setNombreprod(rs1.getString("nombre"));
                    ot.setTotal(rs1.getInt("pares"));
                    ot.setLinea(rs1.getInt("id_linea"));
                    listasem.add(ot);
                }
            }
            rs1.close();
            st1.close();
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        }
        return listasem;
    }

    public ArrayList<Ordentrabajo> GetLineaxProg() {
        ArrayList<Ordentrabajo> arr = new ArrayList<>();
        try {
            st = c.prepareStatement("select dot.producto as producto,p.descripcion as nproducto,dot.linea as linea,\n"
                    + "pares = case when count(dot.producto)>1 THEN avg(ot.total) else sum(ot.total) END from OrdenTrabajo ot \n"
                    + "join DOrdenTrabajo dot on dot.Orden=ot.orden\n"
                    + "join producto p on dot.producto = p.Id_Producto\n"
                    + "where ot.stat='1'\n"
                    + "group by dot.producto,p.Descripcion,dot.linea\n"
                    + "order by sum(ot.total)desc");
            rs = st.executeQuery();
            while (rs.next()) {
                Ordentrabajo ot = new Ordentrabajo();
                ot.setProducto(rs.getInt("producto"));
                ot.setNombreprod(rs.getString("nproducto"));
                ot.setTotal(rs.getInt("pares"));
                ot.setLinea(rs.getInt("linea"));
                ot.setTotal(rs.getInt("pares"));
                arr.add(ot);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        }
        return arr;
    }

    public ArrayList<Ordentrabajo> GetOrdenxLinea(ArrayList<Ordentrabajo> arr, int row) {
        try {
            ArrayList<Soloorden> arrs = new ArrayList<>();
            String q = "select Dorden,ot.orden as orden,punto_inicial,punto_final,semana"
                    + " from OrdenTrabajo ot \n"
                    + "join DOrdenTrabajo dot on dot.Orden=ot.orden\n"
                    + "join producto p on dot.producto=p.id_producto\n"
                    + "join corrida c on p.Id_Corrida=c.Id_Corrida\n"
                    + "where ot.stat='1' and p.Id_Producto = " + arr.get(row).getProducto() + "\n"
                    + "group by Dorden,ot.orden,punto_inicial,punto_final,semana\n"
                    + "order by ot.orden asc";
            st = c.prepareStatement(q);
            rs = st.executeQuery();
            boolean cont = true;
            Ordentrabajo ot = new Ordentrabajo();
            while (rs.next()) {
                Soloorden s = new Soloorden();
                if (cont) {
                    ot.setProducto(arr.get(row).getProducto());
                    ot.setNombreprod(arr.get(row).getNombreprod());
                    ot.setLinea(arr.get(row).getLinea());
                    ot.setNombrelinea(arr.get(row).getNombrelinea());
                    ot.setTotal(arr.get(row).getTotal());
                    ot.setPi(rs.getInt("punto_inicial"));
                    ot.setPf(rs.getInt("punto_final"));
                    s.setOrden(rs.getInt("orden"));
                    s.setDOrden(rs.getInt("Dorden"));
                    s.setProducto(arr.get(row).getProducto());
                    s.setNombreprod(arr.get(row).getNombreprod());
                    s.setSemana(rs.getInt("semana"));
                    arrs.add(s);
                    cont = false;
                } else {
                    s.setOrden(rs.getInt("orden"));
                    s.setDOrden(rs.getInt("Dorden"));
                    s.setProducto(arr.get(row).getProducto());
                    s.setNombreprod(arr.get(row).getNombreprod());
                    s.setSemana(rs.getInt("semana"));
                    arrs.add(s);
                }
            }
            ot.setArrorden(arrs);
            arr.set(row, ot);
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        }
        return arr;
    }
// deletes

    public void PrensistaDelete(int Prensista) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE Prensistas set stat ='0' where Prensista=" + Prensista + "");
            st.executeUpdate();
            c.commit();
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
                Logger.getLogger(ObjectOrdenTrabajo.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(ObjectOrdenTrabajo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

// updates
    public boolean OrdentUpdate(Ordentrabajo o) {
        try {
            c.setAutoCommit(false);
            String q;
            q = "update OrdenTrabajo set maquina='" + o.getMaquina() + "', estacion=" + o.getEstacion()
                    + ",pares="+o.getCantidadOrden()+" where orden =" + o.getOrden();
            st = c.prepareStatement(q);
            st.executeUpdate();
            q = o.getQuery();
            st = c.prepareStatement(q);
            st.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectOrdenTrabajo.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(ObjectOrdenTrabajo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
// inserts

    public boolean OrdenesTAdd(Ordentrabajo o) {
        String q;
        try {
            c.setAutoCommit(false);
            rcpta.setAutoCommit(false);
            for (int i = 0; i < o.getCantidadOrden(); i++) {
                q = "insert into OrdenTrabajo (semana,fecha,total,pares,maquina,estacion,stat) "
                        + "values(" + o.getSemana() + ",'" + o.getFecha() + "'," + o.getTotal() + ",0,0,0,'1')";
                System.out.println(q);
                st = c.prepareStatement(q);
                st.execute();
                // obtener ultima orden
                st = c.prepareStatement("SELECT max(Orden) as orden from OrdenTrabajo");
                rs = st.executeQuery();
                int clave = 0;
                while (rs.next()) {
                    clave = rs.getInt("Orden");
                }
                rs.close();
                q = "insert into DOrdenTrabajo(Orden,Producto,linea,cant1,cant2,cant3,cant4,cant5,cant6,cant7,cant8,cant9,cant10,cant11,cant12) "
                        + "values(" + clave + "," + o.getProducto() + "," + o.getLinea() + ",0,0,0,0,0,0,0,0,0,0,0,0)";
                System.out.println(q);
                st = c.prepareStatement(q);
                st.execute();
            }
            q = "select p.Producto,p.npedido as pedido\n"
                    + "from programa p \n"
                    + "join Dpedido dp on dp.id_producto=p.producto\n"
                    + "where  programa =" + o.getSemana() + " and dp.estatus ='20' and dp.id_producto=" + o.getProducto() + "\n"
                    + "group by p.producto,p.npedido\n"
                    + "order by p.npedido desc";
            st = rcpta.prepareStatement(q);
            rs = st.executeQuery();

            while (rs.next()) {
                String pedido = rs.getString("pedido");
                q = "update dpedido set estatus ='25' where id_producto=" + o.getProducto() + " and npedido='" + pedido + "' ";
                System.out.println(q);
                st = rcpta.prepareStatement(q);
                st.execute();
            }
            rs.close();
//            c.rollback();
//            rcpta.rollback();
            c.commit();
            rcpta.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
                Logger.getLogger(ObjectOrdenTrabajo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectOrdenTrabajo.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(ObjectOrdenTrabajo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}
