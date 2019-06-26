
package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class Color {
    DB db = new DB();
    private  int Id_Color;
    private String Descripcion;
    private boolean Activo;
    
    PreparedStatement st = null;
    //Connection c = Server.getProduccion();
    Connection c = db.Produccion();
    ResultSet rs = null;
    
    public Color(){}

    public int getId_Color() {
        return Id_Color;
    }

    public void setId_Color(int Id_Color) {
        this.Id_Color = Id_Color;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public boolean getActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }
    @Override
    public String toString(){
        return this.Descripcion;
    }
    public Vector<Color> getColores(){
       
        Vector<Color> datos = new Vector<Color>();
        Color cl = null;
        
        try{
            st = c.prepareStatement("SELECT * FROM Color WHERE Activo = 1 ORDER BY Descripcion");
            rs = st.executeQuery();
            
            cl = new Color();
            cl.setId_Color(0);
            cl.setDescripcion("Seleciona un color");
            datos.add(cl);
                    
            while(rs.next()){
                cl = new Color();
                cl.setId_Color(rs.getInt("Id_Color"));
                cl.setDescripcion(rs.getString("Descripcion"));
                datos.add(cl);
            }
            rs.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return datos;
    }
    public Vector<Color> getByID(String filtro){
         Vector<Color> datos = new Vector<Color>();
        Color cl = null;
        
        try{
            st = c.prepareStatement("select c.Id_Color,c.Descripcion from Color c\n" +
"inner join Producto p on c.Id_Color = p.Id_Color\n" +
"WHERE p.Id_Producto LIKE '%"+filtro+"%'");
            rs = st.executeQuery();
            
            cl = new Color();
            cl.setId_Color(0);
            cl.setDescripcion("Seleciona un color");
            datos.add(cl);
                    
            while(rs.next()){
                cl = new Color();
                cl.setId_Color(rs.getInt("Id_Color"));
                cl.setDescripcion(rs.getString("Descripcion"));
                datos.add(cl);
            }
            rs.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return datos;
    }
    public Vector<Color>getColor(int Id_Producto){
        Vector<Color> datos = new Vector<Color>();
         Color cl = null;
        
        try{
            st = c.prepareStatement("select c.Descripcion,c.Id_Color\n" +
"from Producto p inner join Color c\n" +
"on p.Id_Color = c.Id_Color  where p.Id_Producto=" + Id_Producto+"order by c.Descripcion");
            rs = st.executeQuery();
            
            cl = new Color();
            //pc.setId_Corrida(0);
            //pc.setDescripcion("Seleciona");
            //datos.add(pc);
                    
            while(rs.next()){
                cl = new Color();
                cl.setId_Color(rs.getInt("Id_Color"));
                cl.setDescripcion(rs.getString("Descripcion"));
                datos.add(cl);
            }
            rs.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return datos;
    }
}
