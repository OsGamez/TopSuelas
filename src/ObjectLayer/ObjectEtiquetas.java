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
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class ObjectEtiquetas {

    PreparedStatement st = null;
    ResultSet rs = null;
    Connection c = Server.getProduccion();
//    DB db = new DB();
//    Connection c = db.Produccion();

    public ArrayList<etiqueta> EtiquetaGetAll() {
        ArrayList<etiqueta> listaetiquetas = new ArrayList<>();
        etiqueta e;
        try {
            st = c.prepareStatement("select p.Descripcion as descrip,p.id_producto as prod,l.Descripcion as linea,"
                    + "cor.Punto_Inicial as pin,cor.Punto_Final as pf,c.Descripcion as color\n"
                    + "from producto p join Linea l on l.Id_Linea=p.Id_Linea\n"
                    + "join color c on c.Id_Color=p.Id_Color\n"
                    + "join corrida cor on cor.Id_Corrida=p.Id_Corrida\n"
                    + "order by l.descripcion");
            rs = st.executeQuery();
             e = new etiqueta();
             e.setDescripcion("");
             listaetiquetas.add(e);
            while (rs.next()) {
                e = new etiqueta();
                e.setProducto(rs.getString("prod"));
                e.setDescripcion(rs.getString("descrip"));
                e.setColor(rs.getString("color"));
                e.setModelo(rs.getString("linea"));
                e.setPi(rs.getInt("pin"));
                e.setPf(rs.getInt("pf"));
                listaetiquetas.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        }
        return listaetiquetas;
    }
        public ArrayList<etiqueta> EtiquetaBusca(int producto) {
        ArrayList<etiqueta> listaetiquetas = new ArrayList<>();
        etiqueta e;
        try {
            st = c.prepareStatement("select p.Descripcion as descrip,p.id_producto as prod,l.Descripcion as linea,"
                    + "cor.Punto_Inicial as pin,cor.Punto_Final as pf,c.Descripcion as color\n"
                    + "from producto p join Linea l on l.Id_Linea=p.Id_Linea\n"
                    + "join color c on c.Id_Color=p.Id_Color\n"
                    + "join corrida cor on cor.Id_Corrida=p.Id_Corrida where id_producto="+producto+" \n"
                    + "order by l.descripcion");
            rs = st.executeQuery();
             e = new etiqueta();
             e.setDescripcion("");
             listaetiquetas.add(e);
            while (rs.next()) {
                e = new etiqueta();
                e.setProducto(rs.getString("prod"));
                e.setDescripcion(rs.getString("descrip"));
                e.setColor(rs.getString("color"));
                e.setModelo(rs.getString("linea"));
                e.setPi(rs.getInt("pin"));
                e.setPf(rs.getInt("pf"));
                listaetiquetas.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        }
        return listaetiquetas;
    }

}
