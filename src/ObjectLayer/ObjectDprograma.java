
package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ObjectDprograma {
    //Connection c = Conexion.getRcpt();
    DB db = new DB();
    Connection c = db.RCPTPhylonA();
    PreparedStatement st = null; 
    ResultSet rs = null;
    
     public boolean addDetalle(Dprograma p){
       boolean rpta = false;
         try {
            st = c.prepareStatement("INSERT INTO Dprograma (cont, Npedido, Programa, Cliente, Agente,Suela,Color,Corrida,Pto1,"
                    + "Pto2,Pto3,Pto4,Pto5,Pto6,Pto7,Pto8,Pto9,Pto10,Pto11,Pto12,Cant1,Cant2,Cant3,Cant4,Cant5,Cant6,Cant7,Cant8"
                    + ",Cant9,Cant10,Cant11,Cant12,Serie)"
                    +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            c.setAutoCommit(false);
            st.setInt(1, p.getCont());
            st.setString(2, p.getNpedido());
            st.setInt(3, p.getPrograma());
            st.setInt(4, p.getId_Cliente());
            st.setInt(5, p.getId_Agente());
            st.setInt(6, p.getId_Producto());
            st.setInt(7, p.getId_Color());
            st.setInt(8, p.getId_Corrida());
            st.setInt(9, p.getPto1());
            st.setInt(10, p.getPto2());
            st.setInt(11, p.getPto3());
            st.setInt(12, p.getPto4());
            st.setInt(13, p.getPto5());
            st.setInt(14, p.getPto6());
            st.setInt(15, p.getPto7());
            st.setInt(16, p.getPto8());
            st.setInt(17, p.getPto9());
            st.setInt(18, p.getPto10());
            st.setInt(19, p.getPto11());
            st.setInt(20, p.getPto12());
            st.setInt(21, p.getC1());
            st.setInt(22, p.getC2());
            st.setInt(23, p.getC3());
            st.setInt(24, p.getC4());
            st.setInt(25, p.getC5());
            st.setInt(26, p.getC6());
            st.setInt(27, p.getC7());
            st.setInt(28, p.getC8());
            st.setInt(29, p.getC9());
            st.setInt(30, p.getC10());
            st.setInt(31, p.getC11());
            st.setInt(32, p.getC12());
            st.setString(33, p.getSerie());
            
            rpta = st.executeUpdate() == 1 ? true : false;
            
            if(rpta){
                c.commit();
            }else{
                c.rollback();
            }
             st.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
         return rpta;
     }
}
