package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectParametros {

    //Connection c = Server.getRpt();
    //Connection pa = Server.getRcpt();
    
    Connection c = Conexion.getRpt();
    Connection pa = Conexion.getRcpt();
    
    PreparedStatement st, dp = null;
    ResultSet rs = null;

    public boolean insertarPam(Parametro p) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("INSERT INTO Parametros(Npedido, Entrada,Salida,Factura)"
                    + "values(?,?,?,?)");

            st.setString(1, p.getNpedido());
            st.setInt(2, p.getEntrada());
            st.setInt(3, p.getSalida());
            st.setInt(4, p.getFactura());

            rpta = st.executeUpdate() == 1 ? true : false;
            Conexion.cerrarPrep(st);
        } catch (SQLException e) {
            e.printStackTrace();
            Conexion.cerrarPrep(st);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
        }
        return rpta;
    }

    public boolean insertarPamA(Parametro p) {
        boolean rpta = false;
        try {
            dp = pa.prepareStatement("INSERT INTO Parametros (Npedido, Entrada,Salida,Factura)"
                    + "values(?,?,?,?)");

            dp.setString(1, p.getNpedido());
            dp.setInt(2, p.getEntrada());
            dp.setInt(3, p.getSalida());
            dp.setInt(4, p.getFactura());

            rpta = dp.executeUpdate() == 1 ? true : false;
            Conexion.cerrarPhylonA(dp);
        } catch (SQLException e) {
            e.printStackTrace();
            Conexion.cerrarPhylonA(dp);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPhylonA(dp);
        }
        return rpta;
    }
    
    public boolean cancelarPam(String Npedido){
        boolean rpta = false;
        try {
            st = c.prepareStatement("DELETE Parametros WHERE Npedido = ?");
            st.setString(1, Npedido);
            rpta = st.executeUpdate() == 1 ? true : false;
            Conexion.cerrarPrep(st);
        } catch (SQLException e) {
            e.printStackTrace();
            Conexion.cerrarPrep(st);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
        }
        return rpta;
    }
    
    public boolean cancelarPamA(String Npedido){
        boolean rpta = false;
        try {
            dp = pa.prepareStatement("DELETE Parametros WHERE Npedido = ?");
            dp.setString(1, Npedido);
            rpta = dp.executeUpdate() == 1 ? true : false;
            Conexion.cerrarPhylonA(dp);
        } catch (SQLException e) {
            e.printStackTrace();
            Conexion.cerrarPhylonA(dp);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPhylonA(dp);
        }
        return rpta;
    }
}
