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
public class Programacion {

//    PreparedStatement st = null;
//    ResultSet rs = null;
    //Connection c = Server.getProduccion();
    //Connection rcpta = Server.getRcpt();

// consultas
    public void GetModelos() {
        
       // ArrayList<Programacion_enc> lista = new ArrayList<>();
       
//        try {
//            String query="select prod.Id_Producto as producto,sum(pares) as pares,"
//                    + " l.id_linea as linea,l.descripcion as lineadesc,c.descripcion as color\n" +
//"			from dpedido dp join ProduccionPhy.dbo.Producto prod \n" +
//"                       on dp.id_producto =prod.id_producto\n" +
//"			join ProduccionPhy.dbo.Linea l on prod.id_linea=l.id_linea\n" +
//"			join ProduccionPhy.dbo.Color c on prod.id_color=c.id_color\n" +
//"			where dp.Fecha_Entrega between '"+fi+"' and '"+ff+"'\n" +
//"                       group by prod.id_producto,prod.descripcion,l.id_linea,l.descripcion,c.descripcion\n" +
//"                       order by pares desc";
//            st = rcpta.prepareStatement(query);
//            System.out.println(query);
//            rs = st.executeQuery();
//            // raiz del arbol
//            Programacion_enc p1= new Programacion_enc();
//            p1.setProducto(0);
//            p1.setId_arbol(0);
//            lista.add(p1);
//            int arbol=1;
//            while (rs.next()) {
//                Programacion_enc p= new Programacion_enc();
//                p.setProducto(rs.getInt("producto"));
//                p.setPares(rs.getInt("pares"));
//                p.setLinea(rs.getInt("linea"));
//                p.setDesclinea(rs.getString("lineadesc"));
//                p.setColor(rs.getString("color"));
//                p.setId_arbol(arbol);
//                lista.add(p);
//                arbol++;
//            }
//            System.out.println("tamaño "+lista.size());
//            rs.close();
//            st.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } 
//        return lista;
    }






// deletes



// updates

// inserts



}
