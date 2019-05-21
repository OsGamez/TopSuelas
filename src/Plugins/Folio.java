
package Plugins;

import DataAccesLayer.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Folio {
    
    PreparedStatement st = null;
    ResultSet rs = null;
    Connection c = Conexion.getRcpt();
    
    private int dato;
    private final int cont = 1;
    private String num = "";
    public String numFolio;
    
    public void generar(int dato){
        this.dato = dato;
        if((this.dato>=100) || (this.dato<1000)){
            int cant = cont+this.dato;
            num = "" + cant;
        }
        if((this.dato>=100) || (this.dato<100)){
            int can = cont+this.dato;
            num = "0" + can;
        }
        if((this.dato>=9) || (this.dato<100)){
            int can = cont+this.dato;
            num = "00" + can;
        }
        if((this.dato<9)){
            int can = cont+this.dato;
            num = "000" + can;
        }
    }
    
    public String Serie(){
        return this.num;
    }
    
    public ArrayList<Folio> Cargar(){
        ArrayList<Folio> lista = new ArrayList<Folio>();
        try {
            st = c.prepareStatement("SELECT MAX(Folio) as Folio FROM Folios");
            rs = st.executeQuery();
            
            if(rs.next()){
               String Folio = rs.getString("Folio");
               numFolio = Folio;
               lista.add(this);
               c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
