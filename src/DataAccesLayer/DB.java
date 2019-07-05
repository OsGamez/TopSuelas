package DataAccesLayer;

import ObjectLayer.Sesioninfo;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB {

    Sesioninfo sesion = new Sesioninfo();
    private String ip = sesion.getIp();
    private String pass = sesion.getContraseña();

    public String url = "jdbc:sqlserver://192.168.90.1:1433;databaseName=UsuariosPhy,sa,"+pass;
    

    public Connection User() {

        Connection link = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            link = DriverManager.getConnection("jdbc:sqlserver://"+ip+":1433;databaseName=UsuariosPhy", "sa",""+pass);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return link;
    }
    
    public Connection Produccion() {

        Connection link = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            link = DriverManager.getConnection("jdbc:sqlserver://"+ip+":1433;databaseName=ProduccionPhy", "sa",""+pass);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return link;
    }
    
    public Connection Cobranza() {

        Connection link = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            link = DriverManager.getConnection("jdbc:sqlserver://"+ip+":1433;databaseName=CobranzaPhy", "sa",""+pass);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return link;
    }
    
    public Connection Cmp() {

        Connection link = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            link = DriverManager.getConnection("jdbc:sqlserver://"+ip+":1433;databaseName=CmpPhylon", "sa",""+pass);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return link;
    }

    public Connection RCPTPhylonA() {

        Connection link = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            link = DriverManager.getConnection("jdbc:sqlserver://"+ip+":1433;databaseName=RCPTPhylonA", "sa",""+pass);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return link;
    }
    
    public Connection RPTPhylon() {

        Connection link = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            link = DriverManager.getConnection("jdbc:sqlserver://"+ip+":1433;databaseName=RPTPhylon", "sa",""+pass);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return link;
    }

    public Connection tempphy() {

        Connection link = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            link = DriverManager.getConnection("jdbc:sqlserver://"+ip+":1433;databaseName=tempphy", "sa",""+pass);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return link;
    }

    public Connection Rcobranza() {

        Connection link = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            link = DriverManager.getConnection("jdbc:sqlserver://"+ip+":1433;databaseName=RcobranzaPhy", "sa",""+pass);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return link;
    }
    
    public Connection Server() {

        Connection link = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            link = DriverManager.getConnection("jdbc:sqlserver://"+ip+":1433;databaseName=RCPTPhylon", "sa",""+pass);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return link;
    }
    
     public static synchronized void cerrarPrep(PreparedStatement st) {
        try {
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    public static synchronized void rollback(Connection cn) {
        try {
            cn.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     
}
