
package DataAccesLayer;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
 
private static Connection con = null;
private static Connection cbz = null;
private static Connection prod = null;
private static Connection pt = null;
private static Connection us = null;
private static Connection Rc = null;
private static Connection pa = null;
private static Connection cm = null;
private static Connection sv = null;
 
public static Connection getConnection(){
     try{
         if(con == null){
             String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
             Class.forName(driver);
             con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-FHVBC8N:1433;databaseName=Prueba", "sa", "123");
         }
     }catch(ClassNotFoundException | SQLException ex){
         ex.printStackTrace();
     }
     return con;
 }
public static Connection getCobranza(){
    try{
        if(cbz == null){
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
            cbz = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-FHVBC8N:1433;databaseName=CobranzaPhy", "sa", "123");
        }
    }catch(ClassNotFoundException | SQLException ex){
        ex.printStackTrace();
    }
    return cbz;
}
public static Connection getRcobranza(){
    try{
        if(Rc == null){
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
            Rc = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-FHVBC8N:1433;databaseName=RcobranzaPhy", "sa", "123");
        }
    }catch(ClassNotFoundException | SQLException ex){
        ex.printStackTrace();
    }
    return Rc;
}
public static Connection getProduccion(){
     try{
        if(prod == null){
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
            prod = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-FHVBC8N:1433;databaseName=ProduccionPhy", "sa", "123");
        }
    }catch(ClassNotFoundException | SQLException ex){
        ex.printStackTrace();
    }
    return prod;
}
public static Connection getRpt(){
        try{
        if(pt == null){
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
            pt = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-FHVBC8N:1433;databaseName=RPTPhylon", "sa", "123");
        }
    }catch(ClassNotFoundException | SQLException ex){
        ex.printStackTrace();
    }
    return pt;
}
public static Connection getUsuario(){
          try{
        if(us == null){
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
            us = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-FHVBC8N:1433;databaseName=UsuariosPhy", "sa", "123");
        }
    }catch(ClassNotFoundException | SQLException ex){
        ex.printStackTrace();
    }
    return us;
}
public static Connection getRcpt(){
        try{
        if(pa == null){
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
            pa = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-FHVBC8N:1433;databaseName=RCPTPhylonA", "sa", "123");
        }
    }catch(ClassNotFoundException | SQLException ex){
        ex.printStackTrace();
    }
    return pa;
}
public static Connection getCmpPhylon(){
        try{
        if(cm == null){
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
            cm = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-FHVBC8N:1433;databaseName=CmpPhylon", "sa", "123");
        }
    }catch(ClassNotFoundException | SQLException ex){
        ex.printStackTrace();
    }
    return cm;
}
public static Connection getServer(){
    try{
        if(sv == null){
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
            sv = DriverManager.getConnection("jdbc:sqlserver://192.168.90.1:1433;databaseName=RCPTPhylon", "sa", "Admin1305");
        }
    }catch(ClassNotFoundException | SQLException ex){
        ex.printStackTrace();
    }
    return sv;
}
public static synchronized void cerrarCall(CallableStatement cl){
        try{cl.close();}catch(Exception e){e.printStackTrace();}
    }
public static synchronized void cerrarPrep(PreparedStatement st){
        try{st.close();}catch(Exception e){e.printStackTrace();}
    }
public static synchronized void cerrarPhylonA(PreparedStatement dp){
        try{dp.close();}catch(Exception e){e.printStackTrace();}
    }
public static synchronized void cerrarConexion(ResultSet rs){
        try{rs.close();}catch(Exception e){e.printStackTrace();}
    }
public static synchronized void cerrarConexion(Connection pt){
        try{pt.close();}catch(Exception e){e.printStackTrace();}
    }
public static synchronized void cerrarConexionA(Connection pa){
        try{pa.close();}catch(Exception e){e.printStackTrace();}
    }
public static synchronized void rollback(Connection pt){
        try{pt.rollback();}catch(Exception e){e.printStackTrace();}
    }
public static synchronized void rollbackA(Connection pa){
        try{pa.rollback();}catch(Exception e){e.printStackTrace();}
    }
}