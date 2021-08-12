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

    PreparedStatement std = null;
    ResultSet rsd = null;
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

    public ArrayList<Programacion_enc> GetModelos(String fi, String ff) {

        ArrayList<Programacion_enc> lista = new ArrayList<>();

        try {
            String query = "select prod.Id_Producto as producto,sum(pares) as pares,"
                    + " l.id_linea as linea,l.descripcion as lineadesc,c.descripcion as color,ped.horma as horma,ped.radiado as rad\n"
                    + "	from dpedido dp join ProduccionPhy.dbo.Producto prod \n"
                    + " on dp.id_producto =prod.id_producto\n"
                    + "	join ProduccionPhy.dbo.Linea l on prod.id_linea=l.id_linea\n"
                    + "	join ProduccionPhy.dbo.Color c on prod.id_color=c.id_color\n"
                    + " join pedidos ped on dp.Npedido=ped.Npedido"
                    + "	where dp.estatus='10' and dp.Fecha_Entrega between '" + fi + "' and '" + ff + "'\n"
                    + " group by prod.id_producto,prod.descripcion,l.id_linea,l.descripcion,c.descripcion,ped.horma,ped.radiado\n"
                    + " order by pares desc";
            st = rcpta.prepareStatement(query);
            System.out.println(query);
            rs = st.executeQuery();
            // raiz del arbol
            Programacion_enc p1 = new Programacion_enc();
            p1.setProducto(0);
            p1.setId_arbol(0);
            p1.setRaiz("y");
            lista.add(p1);
            int arbol = 1;
            while (rs.next()) {
                Programacion_enc p = new Programacion_enc();
                p.setProducto(rs.getInt("producto"));
                p.setPares(rs.getInt("pares"));
                p.setLinea(rs.getInt("linea"));
                p.setDesclinea(rs.getString("lineadesc"));
                p.setColor(rs.getString("color"));
                p.setId_arbol(arbol);
                p.setRaiz("y");
                p.setHorma(rs.getString("horma"));
                p.setRadiado(rs.getInt("rad"));

                ArrayList<Programacion_det> arrdet = new ArrayList<>();
                //detalle por cliente y fechas
                String query2 = "select prod.Id_Producto as producto,dp.id_cliente,sum(pares) as pares, l.id_linea as linea,l.Descripcion as ldesc,\n"
                        + " c.descripcion,dp.Fecha_Pedido as fechap,dp.Fecha_Entrega as fechae,cli.nombre,dp.Npedido as pedido,dp.id as id,"
                        + "dp.c1 as c1,dp.c2 as c2,dp.c3 as c3,dp.c4 as c4,dp.c5 as c5,dp.c6 as c6,dp.c7 as c7,dp.c8 as c8,dp.c9 as c9,dp.c10 as c10,dp.c11 as c11,dp.c12 as c12 \n"
                        + " from dpedido dp join ProduccionPhy.dbo.Producto prod \n"
                        + " on dp.id_producto =prod.id_producto\n"
                        + " join ProduccionPhy.dbo.Linea l on prod.id_linea=l.id_linea\n"
                        + " join ProduccionPhy.dbo.Color c on prod.id_color=c.id_color\n"
                        + " join CobranzaPhy.dbo.Clientes cli on dp.id_cliente=cli.id_cliente\n"
                        + " where dp.estatus='10' and prod.id_producto=" + p.getProducto() + " and dp.Fecha_Entrega between '" + fi + "' and '" + ff + "'\n"
                        + " group by l.id_linea,prod.id_producto,prod.descripcion,l.descripcion,\n"
                        + " dp.id_cliente,c.descripcion,dp.Fecha_Pedido,dp.Fecha_Entrega,cli.nombre,dp.Npedido,dp.id,"
                        + " dp.c1,dp.c2,dp.c3,dp.c4 ,dp.c5,dp.c6,dp.c7,dp.c8,dp.c9,dp.c10,dp.c11,dp.c12\n"
                        + " order by pares desc";
                std = rcpta.prepareStatement(query2);
//                System.out.println(query2);
                rsd = std.executeQuery();
                int conta = 0;

                while (rsd.next()) {
                    Programacion_det pdet = new Programacion_det();
                    pdet.setProducto(rsd.getInt("producto"));
                    pdet.setCliente(rsd.getInt("id_cliente"));
                    pdet.setPares(rsd.getInt("pares"));
                    pdet.setLinea(rsd.getInt("linea"));
                    pdet.setLineadesc(rsd.getString("ldesc"));
                    pdet.setFecha_cap(rsd.getString("fechap"));
                    pdet.setFecha_entrega(rsd.getString("fechae"));
                    pdet.setClientedesc(rsd.getString("nombre"));
                    pdet.setRenglon(conta);
                    pdet.setRaiz("n");
                    pdet.setId_arbol(conta);
                    pdet.setPedido(rsd.getInt("pedido"));
                    pdet.setIdped(rsd.getInt("id"));
                    pdet.setC1(rsd.getInt("c1"));
                    pdet.setC2(rsd.getInt("c2"));
                    pdet.setC3(rsd.getInt("c3"));
                    pdet.setC4(rsd.getInt("c4"));
                    pdet.setC5(rsd.getInt("c5"));
                    pdet.setC6(rsd.getInt("c6"));
                    pdet.setC7(rsd.getInt("c7"));
                    pdet.setC8(rsd.getInt("c8"));
                    pdet.setC9(rsd.getInt("c9"));
                    pdet.setC10(rsd.getInt("c10"));
                    pdet.setC11(rsd.getInt("c11"));
                    pdet.setC12(rsd.getInt("c12"));
                    conta++;
                    arrdet.add(pdet);
                }
                p.setArrdet(arrdet);
                lista.add(p);
                arbol++;
            }
            System.out.println("tamaño " + lista.size());

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                std.close();
            } catch (SQLException ex) {
                Logger.getLogger(ObjectOrdenTrabajo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
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
                    + ",pares=" + o.getCantidadOrden() + " where orden =" + o.getOrden();
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

    public int ProgramaAdd(ArrayList<Programacion_enc> arrlineas, int enc, int det, String fechas) {
        String q;
        int programa = 0;
        int tarjeta = 0;
        ArrayList<String> puntoc = new ArrayList<>();
        ArrayList<String> punto = new ArrayList<>();
        try {//recoleccion de datos
            st = c.prepareStatement("select top(1) tarjeta from programa order by tarjeta desc");
            rs = st.executeQuery();
            while (rs.next()) {
                tarjeta = rs.getInt("tarjeta");
            }
            tarjeta = tarjeta++;
            int pares = arrlineas.get(enc).getArrdet().get(det).getPares();
            int prod = arrlineas.get(enc).getArrdet().get(det).getProducto();
            int pedido = arrlineas.get(enc).getArrdet().get(det).getPedido();
            String fechap = arrlineas.get(enc).getArrdet().get(det).getFecha_cap();
            String fechae = arrlineas.get(enc).getArrdet().get(det).getFecha_entrega();
            int cliente = arrlineas.get(enc).getArrdet().get(det).getCliente();
            int ren = arrlineas.get(enc).getArrdet().get(det).getRenglon();
            int c1 = arrlineas.get(enc).getArrdet().get(det).getC1();
            int c2 = arrlineas.get(enc).getArrdet().get(det).getC2();
            int c3 = arrlineas.get(enc).getArrdet().get(det).getC3();
            int c4 = arrlineas.get(enc).getArrdet().get(det).getC4();
            int c5 = arrlineas.get(enc).getArrdet().get(det).getC5();
            int c6 = arrlineas.get(enc).getArrdet().get(det).getC6();
            int c7 = arrlineas.get(enc).getArrdet().get(det).getC7();
            int c8 = arrlineas.get(enc).getArrdet().get(det).getC8();
            int c9 = arrlineas.get(enc).getArrdet().get(det).getC9();
            int c10 = arrlineas.get(enc).getArrdet().get(det).getC10();
            int c11 = arrlineas.get(enc).getArrdet().get(det).getC11();
            int c12 = arrlineas.get(enc).getArrdet().get(det).getC12();
            int linea = arrlineas.get(enc).getLinea();
            int id = arrlineas.get(enc).getArrdet().get(det).getIdped();

            String radiado = (arrlineas.get(enc).getArrdet().get(det).getRadiado() == null) ? "" : arrlineas.get(enc).getArrdet().get(det).getRadiado();
            c.setAutoCommit(false);
            q = "insert into Programa (pares,id_linea,id_producto,pedido,fechacap,fechaentrega,id_cliente,renglon,avance,radiado,"
                    + "c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,estado,tarjeta) "
                    + "values(" + pares + "," + linea + "," + prod + "," + pedido + ",'" + fechap + "','" + fechae + "'," + cliente + "," + ren + ""
                    + ",'','" + radiado + "'," + c1 + "," + c2 + "," + c3 + "," + c4 + "," + c5 + "," + c6 + "," + c7 + "," + c8 + "," + c9 + "," + c10 + "," + c11 + "," + c12 + ",'1'," + tarjeta + ")";
//            System.out.println(q);
            st = c.prepareStatement(q);
            st.execute();
            // obtener ultimo programa

            int molde = 0;
            float pi = 0;
            float pf = 0;
            st = c.prepareStatement("select top(1) id_programa from programa order by id_programa desc");
            rs = st.executeQuery();
            while (rs.next()) {
                programa = rs.getInt("id_programa");
            }
            //obtener pares por molde
            st = c.prepareStatement(" select top(1)parxcaja from moldes where suela=" + linea);
            rs = st.executeQuery();
            while (rs.next()) {
                molde = rs.getInt("parxcaja");
            }
            //obtener punto inicio y final
            st = c.prepareStatement(" select cor.descripcion as corrida,Punto_Inicial,Punto_Final from ProduccionPhy.dbo.corrida cor\n"
                    + "  join ProduccionPhy.dbo.producto p on p.id_corrida=cor.id_corrida where p.Id_Producto=" + prod);
            rs = st.executeQuery();
            while (rs.next()) {
                pi = rs.getInt("Punto_Inicial");
                pf = rs.getInt("Punto_Final");
            }
            System.out.println("programa " + programa + "-" + molde + "-" + pi + "-" + punto.size());
            //arreglo con las cantidades
            punto = getpuntospar(punto, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12);
            int rengloni = 0;

            for (int i = 0; i < punto.size(); i++) {// recorrido de cada cantidad x punto
//                System.out.println(pi + "." + punto.get(i));
                if (Integer.parseInt(punto.get(i)) != 0) {//solamente cantidades que sean distintas de cero
                    int res = Integer.parseInt(punto.get(i)) / molde;
                    int res1 = Integer.parseInt(punto.get(i)) % molde;
//                    System.out.println(res + "¿" + res1 + "¿" + molde);
                    String[] arrcode = new String[2];
                    if (res < 1) {// ejecuta si solo es una cantidad menor a la caja
                        q = "insert into Avances (id_programa,pares,par_completo,renglon,fechaingreso,punto,codigo,estado,inyeccion,rebabeado,radiado,empaque,operador,turno) "
                                + "values(" + programa + "," + punto.get(i) + ",0," + rengloni + ",'" + fechas + "',"
                                + pi + ",'','1',null,null,null,null,0,'0')";
//                        System.out.println(q);
                        st = c.prepareStatement(q);
                        st.execute();
                        arrcode = codigo(arrcode);//actualizar codigo
                        q = "update Avances set codigo='" + arrcode[1] + "' where id_avance=" + arrcode[0];
                        st = c.prepareStatement(q);
                        st.executeUpdate();
                        rengloni++;
                    } else {
                        for (int j = 0; j < res; j++) {//n renglones
                            q = "insert into Avances (id_programa,pares,par_completo,renglon,fechaingreso,punto,codigo,estado,inyeccion,rebabeado,radiado,empaque,operador,turno) "
                                    + "values(" + programa + "," + molde + ",0," + rengloni + ",'" + fechas + "',"
                                    + pi + ",'','1',null,null,null,null,0,'0')";
//                            System.out.println(q);
                            st = c.prepareStatement(q);
                            st.execute();
                            arrcode = codigo(arrcode);//actualizar codigo
                            q = "update Avances set codigo='" + arrcode[1] + "' where id_avance=" + arrcode[0];
                            st = c.prepareStatement(q);
                            st.executeUpdate();
                            rengloni++;
                        }
                        if (res1 != 0) {//sobrantes
                            q = "insert into Avances (id_programa,pares,par_completo,renglon,fechaingreso,punto,codigo,estado,inyeccion,rebabeado,radiado,empaque,operador,turno) "
                                    + "values(" + programa + "," + res1 + ",0," + rengloni + ",'" + fechas + "',"
                                    + pi + ",'','1',null,null,null,null,0,'0')";
//                            System.out.println(q);
                            st = c.prepareStatement(q);
                            st.execute();
                            arrcode = codigo(arrcode);//actualizar codigo
                            q = "update Avances set codigo='" + arrcode[1] + "' where id_avance=" + arrcode[0];
                            st = c.prepareStatement(q);
                            st.executeUpdate();
                            rengloni++;
                        }
                    }
                }
                pi += 0.5;//control de puntos
            }
            //actualizar estatus de pedidos
            q = "update RCPTPhylonA.dbo.Dpedido set Estatus='15' where id=" + id;
//            System.out.println(q);
            st = c.prepareStatement(q);
            st.executeUpdate();
            //finalizar conexiones
            rs.close();
            st.close();
            c.commit();
            return programa;
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
        return programa;
    }

    public int ProgramaAddAll(ArrayList<Programacion_enc> arrlineas, int enc, String fechas) {
        String q;
        int programa = 0;
        int tarjeta = 0;
        ArrayList<String> puntoc = new ArrayList<>();

        try {//recoleccion de datos
            st = c.prepareStatement("select top(1) tarjeta from programa order by tarjeta desc");
            rs = st.executeQuery();
            while (rs.next()) {
                tarjeta = rs.getInt("tarjeta");
            }
            tarjeta = tarjeta + 1;
            int tamañodet = arrlineas.get(enc).getArrdet().size();
            //System.out.println("% " + tamañodet + " % " + tarjeta);
            //encabezado            
            for (int x = 0; x < tamañodet; x++) {
                ArrayList<String> punto = new ArrayList<>();
                int pares = arrlineas.get(enc).getArrdet().get(x).getPares();
                int prod = arrlineas.get(enc).getArrdet().get(x).getProducto();
                int pedido = arrlineas.get(enc).getArrdet().get(x).getPedido();
                String fechap = arrlineas.get(enc).getArrdet().get(x).getFecha_cap();
                String fechae = arrlineas.get(enc).getArrdet().get(x).getFecha_entrega();
                int cliente = arrlineas.get(enc).getArrdet().get(x).getCliente();
                int ren = arrlineas.get(enc).getArrdet().get(x).getRenglon();
                int c1 = arrlineas.get(enc).getArrdet().get(x).getC1();
                int c2 = arrlineas.get(enc).getArrdet().get(x).getC2();
                int c3 = arrlineas.get(enc).getArrdet().get(x).getC3();
                int c4 = arrlineas.get(enc).getArrdet().get(x).getC4();
                int c5 = arrlineas.get(enc).getArrdet().get(x).getC5();
                int c6 = arrlineas.get(enc).getArrdet().get(x).getC6();
                int c7 = arrlineas.get(enc).getArrdet().get(x).getC7();
                int c8 = arrlineas.get(enc).getArrdet().get(x).getC8();
                int c9 = arrlineas.get(enc).getArrdet().get(x).getC9();
                int c10 = arrlineas.get(enc).getArrdet().get(x).getC10();
                int c11 = arrlineas.get(enc).getArrdet().get(x).getC11();
                int c12 = arrlineas.get(enc).getArrdet().get(x).getC12();
                int linea = arrlineas.get(enc).getLinea();
                int id = arrlineas.get(enc).getArrdet().get(x).getIdped();
                int radiado = arrlineas.get(enc).getRadiado();
                String horma = arrlineas.get(enc).getHorma();
                //cantidades al 5%
                c1 = (int) ((c1 * 0.05) + c1);
                c2 = (int) ((c2 * 0.05) + c2);
                c3 = (int) ((c3 * 0.05) + c3);
                c4 = (int) ((c4 * 0.05) + c4);
                c5 = (int) ((c5 * 0.05) + c5);
                c6 = (int) ((c6 * 0.05) + c6);
                c7 = (int) ((c7 * 0.05) + c7);
                c8 = (int) ((c8 * 0.05) + c8);
                c9 = (int) ((c9 * 0.05) + c9);
                c10 = (int) ((c10 * 0.05) + c10);
                c11 = (int) ((c11 * 0.05) + c11);
                c12 = (int) ((c12 * 0.05) + c12);
                pares=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12;
                //
                c.setAutoCommit(false);
                q = "insert into Programa (pares,id_linea,id_producto,pedido,fechacap,fechaentrega,id_cliente,renglon,avance,radiado,"
                        + "c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,estado,tarjeta,c1f,c2f,c3f,c4f,c5f,c6f,c7f,c8f,c9f,c10f,c11f,c12f,horma,pares_completos) "
                        + "values(" + pares + "," + linea + "," + prod + "," + pedido + ",'" + fechap + "','" + fechae + "'," + cliente + "," + ren + ""
                        + ",'','" + radiado + "'," + c1 + "," + c2 + "," + c3 + "," + c4 + "," + c5 + "," + c6 + "," + c7 + "," + c8 + "," + c9 + ","
                        + c10 + "," + c11 + "," + c12 + ",'1'," + tarjeta + ",0,0,0,0,0,0,0,0,0,0,0,0,'" + horma + "',0)";
                System.out.println(q);
                st = c.prepareStatement(q);
                st.execute();
                // obtener ultimo programa
                int molde = 0;
                float pi = 0;
                float pf = 0;
                st = c.prepareStatement("select top(1) id_programa from programa order by id_programa desc");
                rs = st.executeQuery();
                while (rs.next()) {
                    programa = rs.getInt("id_programa");
                }
                //obtener pares por molde
                st = c.prepareStatement(" select top(1)parxcaja from moldes where suela=" + linea);
                rs = st.executeQuery();
                while (rs.next()) {
                    molde = rs.getInt("parxcaja");
                }
                //obtener punto inicio y final
                st = c.prepareStatement(" select cor.descripcion as corrida,Punto_Inicial,Punto_Final from ProduccionPhy.dbo.corrida cor\n"
                        + "  join ProduccionPhy.dbo.producto p on p.id_corrida=cor.id_corrida where p.Id_Producto=" + prod);
                rs = st.executeQuery();
                while (rs.next()) {
                    pi = rs.getInt("Punto_Inicial");
                    pf = pi;
                }
                System.out.println("programa " + programa + "-" + molde + "-" + pi + "-" + punto.size());
                //arreglo con las cantidades
                punto = getpuntospar(punto, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12);
                int rengloni = 0;

                for (int i = 0; i < punto.size(); i++) {// recorrido de cada cantidad x punto

//                System.out.println(pi + "." + punto.get(i));
                    if (Integer.parseInt(punto.get(i)) != 0) {//solamente cantidades que sean distintas de cero
                        int res = Integer.parseInt(punto.get(i)) / molde;
                        int res1 = Integer.parseInt(punto.get(i)) % molde;
//                    System.out.println(res + "¿" + res1 + "¿" + molde);
                        String[] arrcode = new String[2];
                        if (res < 1) {// ejecuta si solo es una cantidad menor a la caja
                            q = "insert into Avances (id_programa,pares,par_completo,renglon,fechaingreso,punto,codigo,estado,inyeccion,rebabeado,radiado,empaque,operador,turno) "
                                    + "values(" + programa + "," + punto.get(i) + ",0," + rengloni + ",'" + fechas + "',"
                                    + pi + ",'','1',null,null,null,null,0,'0')";
//                        System.out.println(q);
                            st = c.prepareStatement(q);
                            st.execute();
                            arrcode = codigo(arrcode);//actualizar codigo
                            q = "update Avances set codigo='" + arrcode[1] + "' where id_avance=" + arrcode[0];
                            st = c.prepareStatement(q);
                            st.executeUpdate();
                            rengloni++;
                        } else {
                            for (int j = 0; j < res; j++) {//n renglones
                                q = "insert into Avances (id_programa,pares,par_completo,renglon,fechaingreso,punto,codigo,estado,inyeccion,rebabeado,radiado,empaque,operador,turno) "
                                        + "values(" + programa + "," + molde + ",0," + rengloni + ",'" + fechas + "',"
                                        + pi + ",'','1',null,null,null,null,0,'0')";
//                            System.out.println(q);
                                st = c.prepareStatement(q);
                                st.execute();
                                arrcode = codigo(arrcode);//actualizar codigo
                                q = "update Avances set codigo='" + arrcode[1] + "' where id_avance=" + arrcode[0];
                                st = c.prepareStatement(q);
                                st.executeUpdate();
                                rengloni++;
                            }
                            if (res1 != 0) {//sobrantes
                                q = "insert into Avances (id_programa,pares,par_completo,renglon,fechaingreso,punto,codigo,estado,inyeccion,rebabeado,radiado,empaque,operador,turno) "
                                        + "values(" + programa + "," + res1 + ",0," + rengloni + ",'" + fechas + "',"
                                        + pi + ",'','1',null,null,null,null,0,'0')";
//                            System.out.println(q);
                                st = c.prepareStatement(q);
                                st.execute();
                                arrcode = codigo(arrcode);//actualizar codigo
                                q = "update Avances set codigo='" + arrcode[1] + "' where id_avance=" + arrcode[0];
                                st = c.prepareStatement(q);
                                st.executeUpdate();
                                rengloni++;
                            }
                        }
                    }
                    pi += 0.5;//control de puntos
                }
                //actualizar estatus de pedidos
                q = "update RCPTPhylonA.dbo.Dpedido set Estatus='15' where id=" + id;
//            System.out.println(q);
                st = c.prepareStatement(q);
                st.executeUpdate();
            }

            //finalizar conexiones
            rs.close();
            st.close();
            c.commit();

            return tarjeta;

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

        return tarjeta;
    }

    private ArrayList<String> getpuntospar(ArrayList<String> arr, int c1, int c2, int c3,
            int c4, int c5, int c6, int c7, int c8, int c9, int c10, int c11, int c12) {
        arr.add(String.valueOf(c1));
        arr.add(String.valueOf(c2));
        arr.add(String.valueOf(c3));
        arr.add(String.valueOf(c4));
        arr.add(String.valueOf(c5));
        arr.add(String.valueOf(c6));
        arr.add(String.valueOf(c7));
        arr.add(String.valueOf(c8));
        arr.add(String.valueOf(c9));
        arr.add(String.valueOf(c10));
        arr.add(String.valueOf(c11));
        arr.add(String.valueOf(c12));
        return arr;
    }

    private String[] codigo(String[] arrcode) {
        String code = "";
        try {
            String avance = "";
            st = c.prepareStatement("select top(1) id_avance from avances order by id_avance desc");
            rs = st.executeQuery();
            while (rs.next()) {
                avance = rs.getString("id_avance");
            }

            for (int i = 0; i < (16 - avance.length()); i++) {
                code += "0";
            }
            code += avance;
            arrcode[0] = avance;//id
            arrcode[1] = code;
        } catch (SQLException ex) {
            Logger.getLogger(ObjectOrdenTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrcode;
    }

}
