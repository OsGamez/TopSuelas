package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ObjectParametros {

//    Connection c = Server.getRpt();
//    Connection pa = Server.getRcpt();
    DB db = new DB();
    Connection c = db.RPTPhylon();
    Connection pa = db.RCPTPhylonA();

    PreparedStatement st, dp = null;
    ResultSet rs = null;

    public boolean insertarPam(Parametro p) throws SQLException {
        boolean rpta = false;
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("INSERT INTO Parametros (Npedido, Entrada,Salida,Factura,Mes)"
                    + "values(?,?,?,?,?)");
            st.setString(1, p.getNpedido());
            st.setInt(2, p.getEntrada());
            st.setInt(3, p.getSalida());
            st.setInt(4, p.getFactura());
            st.setString(5, p.getMes());

            rpta = st.executeUpdate() == 1 ? true : false;

            if (rpta) {
                c.commit();
                st.close();
            } else {
                c.rollback();
                st.close();
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
            st.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            st.close();
        }
        return rpta;
    }

    public boolean actualizarPam(String Np) throws SQLException {
        try {
           c.setAutoCommit(false);
           st = c.prepareStatement("UPDATE Parametros SET Npedido = ?");
           st.setString(1, Np);
           st.executeUpdate();
           c.commit();
           st.close();
           return true;
        } catch (SQLException e) {
            e.printStackTrace();
            c.rollback();
            st.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            c.rollback();
            st.close();
        }
        return false;
    }

    public boolean actualizarPamA(String Np) throws SQLException {
        try {
            pa.setAutoCommit(false);
            dp = pa.prepareStatement("UPDATE Parametros SET Npedido = ?");
            dp.setString(1, Np);
            dp.executeUpdate();
            pa.commit();
            dp.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            pa.rollback();
            dp.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            pa.rollback();
            dp.close();
        }
        return false;
    }

    public boolean insertarPamA(Parametro p) throws SQLException {
        boolean rpta = false;
        try {
            dp = pa.prepareStatement("INSERT INTO Parametros (Npedido, Entrada,Salida,Factura,Mes)"
                    + "values(?,?,?,?,?)");
            dp.setString(1, p.getNpedido());
            dp.setInt(2, p.getEntrada());
            dp.setInt(3, p.getSalida());
            dp.setInt(4, p.getFactura());
            dp.setString(5, p.getMes());

            rpta = dp.executeUpdate() == 1 ? true : false;
            dp.close();
        } catch (SQLException e) {
            e.printStackTrace();
            dp.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            dp.close();
        }
        return rpta;
    }

    public boolean cancelarPam(String Npedido) throws SQLException {
        boolean rpta = false;
        try {
            st = c.prepareStatement("DELETE Parametros WHERE Npedido = ?");
            st.setString(1, Npedido);
            rpta = st.executeUpdate() == 1 ? true : false;
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
            st.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            st.close();
        }
        return rpta;
    }

    public boolean cancelarPamA(String Npedido) throws SQLException {
        boolean rpta = false;
        try {
            dp = pa.prepareStatement("DELETE Parametros WHERE Npedido = ?");
            dp.setString(1, Npedido);
            rpta = dp.executeUpdate() == 1 ? true : false;
            dp.close();
        } catch (SQLException e) {
            e.printStackTrace();
            dp.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            dp.close();
        }
        return rpta;
    }

    public ArrayList<Parametro> getFolioActual() {
        ArrayList<Parametro> listaP = new ArrayList<Parametro>();
        try {
            st = pa.prepareStatement("SELECT  MAX(Entrada) as Folio FROM Parametros");

            rs = st.executeQuery();

            while (rs.next()) {
                int F = rs.getInt("Folio");
                Parametro par = new Parametro();
                par.setEntrada(F);
                listaP.add(par);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaP;
    }

    public ArrayList<Parametro> getFolioActualB() {
        ArrayList<Parametro> listaP = new ArrayList<Parametro>();
        try {
            st = pa.prepareStatement("SELECT  MAX(Salida) as Folio FROM Parametros");

            rs = st.executeQuery();

            while (rs.next()) {
                int F = rs.getInt("Folio");
                Parametro par = new Parametro();
                par.setSalida(F);
                listaP.add(par);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaP;
    }
}
