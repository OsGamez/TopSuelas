
package Plugins;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ParametroCliente {
    
    
    Connection c = Server.getCobranza();
    //Connection pa = Server.get
    PreparedStatement st = null;
    ResultSet rs = null;
   
    public String NumCliente;

    public String getNumCliente() {
        return NumCliente;
    }

    public void setNumCliente(String NumCliente) {
        this.NumCliente = NumCliente;
    }
    
    public boolean insertarPam(String Num) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE  ParametroCliente SET NumCliente = ?");
                  
            st.setString(1, Num);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
            
        }catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
        }
        return false;
    }
    
    public int validarNumCliente(int Num) {
        try {
            st = c.prepareStatement("SELECT COUNT (NumCliente) FROM ParametroCliente  WHERE NumCliente = ?");
            st.setInt(1, Num);

            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 1;
        }
    }
    
    public ArrayList<ParametroCliente> getNumCli() {
        ArrayList<ParametroCliente> listaP = new ArrayList<ParametroCliente>();
        try {
            st = c.prepareStatement("SELECT  MAX(CONVERT(INT,NumCliente)) as NumCliente FROM ParametroCliente");
            rs = st.executeQuery();

            while (rs.next()) {
                int Num = rs.getInt("NumCliente");
                ParametroCliente par = new ParametroCliente();
                par.setNumCliente(String.valueOf(Num));

                listaP.add(par);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaP;
    }
   
}
