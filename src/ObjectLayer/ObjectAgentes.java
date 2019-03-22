package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectAgentes {

    PreparedStatement st = null;
    PreparedStatement copy = null;
    Connection c = Server.getCobranza();
    Connection rc = Server.getRcobranza();
    
    //Connection c = Conexion.getCobranza();
    //Connection rc = Conexion.getRcobranza();
    ResultSet rs = null;

    public boolean agenteAdd(Agente agente) {
        try {
            c.setAutoCommit(false);
            rc.setAutoCommit(false);
            try {
                st = c.prepareStatement("INSERT INTO Agentes (Descripcion ,Activo)"
                        + "values(?,?)");
                st.setString(1, agente.getDescripcion());
                st.setBoolean(2, agente.getActivo());
                st.executeUpdate();

                copy = rc.prepareStatement("INSERT INTO Agentes (Descripcion ,Activo)"
                        + "values(?,?)");
                copy.setString(1, agente.getDescripcion());
                copy.setBoolean(2, agente.getActivo());
                copy.executeUpdate();
                c.commit();
                rc.commit();
                return true;
            } catch (SQLException ex) {
                c.rollback();
                ex.printStackTrace();
            } finally {
                if (st != null) {
                    st.close();
                }
                if (copy != null) {
                    copy.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObjectAgentes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int validarAgente(String nombre) {
        try {
            st = c.prepareStatement("SELECT COUNT (Id_Agente) FROM Agentes WHERE Descripcion=? AND Activo = 1");
            st.setString(1, nombre);

            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 1;
        }
    }

    public ArrayList<Agente> agentesGetAll() {
        ArrayList<Agente> listaAgentes = new ArrayList<Agente>();
        try {
            st = c.prepareStatement("SELECT * FROM Agentes WHERE Activo = 1 ORDER BY Descripcion");
            rs = st.executeQuery();
            while (rs.next()) {
                Agente agente = new Agente();
                agente.setId_Agente(rs.getInt("Id_Agente"));
                agente.setDescripcion(rs.getString("Descripcion"));
                listaAgentes.add(agente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaAgentes;
    }

    public ArrayList<Agente> agenteSearch(String criterio) {
        ArrayList<Agente> listaAgentes = new ArrayList<Agente>();
        try {
            st = c.prepareStatement("SELECT * FROM Agentes WHERE Activo = 1 AND  Descripcion LIKE '%" + criterio + "%'"
                    + "ORDER BY Descripcion ");
            rs = st.executeQuery();
            while (rs.next()) {
                Agente agente = new Agente();
                agente.setId_Agente(rs.getInt("Id_Agente"));
                agente.setDescripcion(rs.getString("Descripcion"));
                agente.setActivo(rs.getBoolean("Activo"));
                listaAgentes.add(agente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaAgentes;
    }
    public boolean agenteDelete(int Id_Agente) {
        try {
            st = c.prepareStatement("select c.RazonSocial,a.Id_Agente from Clientes c\n"
                    + "inner join Agentes a \n"
                    + "on c.Id_Agente = a.Id_Agente\n"
                    + "where a.Id_Agente = ? and c.Activo = 1");
            st.setInt(1, Id_Agente);
            rs = st.executeQuery();
            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("UPDATE Agentes SET Activo = 0 WHERE Id_Agente = ?");
                st.setInt(1, Id_Agente);
                st.execute();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean agenteUpdate(Agente agente) {
        try {
            st = c.prepareStatement("UPDATE Agentes SET Descripcion = ? WHERE Id_Agente = ?");
            st.setString(1, agente.getDescripcion());
            st.setInt(2, agente.getId_Agente());
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}