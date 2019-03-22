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

public class ObjectEstados {

    PreparedStatement st = null;
    PreparedStatement copy = null;
    Connection c = Server.getCobranza();
    Connection rc = Server.getRcobranza();
    ResultSet rs = null;

    public boolean estadoAdd(Estado estado) {
        try {
            c.setAutoCommit(false);
            rc.setAutoCommit(false);
            try {
                st = c.prepareStatement("INSERT INTO Estados (Descripcion ,Activo)"
                        + "values(?,?)");

                st.setString(1, estado.getDescripcion());
                st.setBoolean(2, estado.getActivo());
                st.executeUpdate();

                copy = rc.prepareStatement("INSERT INTO Estados (Descripcion ,Activo)"
                        + "values(?,?)");

                copy.setString(1, estado.getDescripcion());
                copy.setBoolean(2, estado.getActivo());
                copy.executeUpdate();
                c.commit();
                rc.commit();
                return true;
            } catch (SQLException ex) {
                c.rollback();
                ex.printStackTrace();
            } finally {
                try {
                    if (st != null) {
                        st.close();
                    }
                    if (copy != null) {
                        copy.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObjectEstados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int validarEstado(String nombre) {
        try {
            st = c.prepareStatement("SELECT COUNT (Id_Estado) FROM Estados WHERE Descripcion=? AND Activo = 1");
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

    public ArrayList<Estado> EstadosGetAll() {
        ArrayList<Estado> listaEstados = new ArrayList<Estado>();
        try {
            st = c.prepareStatement("SELECT * FROM Estados WHERE Activo = 1 ORDER BY Descripcion");
            rs = st.executeQuery();
            while (rs.next()) {
                Estado estado = new Estado();
                estado.setId_Estado(rs.getInt("Id_Estado"));
                estado.setDescripcion(rs.getString("Descripcion"));
                listaEstados.add(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaEstados;
    }

    public ArrayList<Estado> estadoSearch(String criterio) {
        ArrayList<Estado> listaEstados = new ArrayList<Estado>();
        try {
            st = c.prepareStatement("SELECT * FROM Estados WHERE Activo = 1 AND  Descripcion LIKE '%" + criterio + "%'"
                    + "ORDER BY Descripcion ");
            rs = st.executeQuery();
            while (rs.next()) {
                Estado estado = new Estado();
                estado.setId_Estado(rs.getInt("Id_Estado"));
                estado.setDescripcion(rs.getString("Descripcion"));
                listaEstados.add(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaEstados;
    }

    public boolean estadoDelete(int Id_Estado) {
        try {
            st = c.prepareStatement("select c.RazonSocial,e.Id_Estado from Clientes c\n"
                    + "inner join Estados e \n"
                    + "on c.Id_Estado = e.Id_Estado\n"
                    + "where e.Id_Estado = ? and c.Activo = 1");
            st.setInt(1, Id_Estado);
            rs = st.executeQuery();

            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("UPDATE Estados SET Activo = 0 WHERE Id_Estado = ?");
                st.setInt(1, Id_Estado);
                st.execute();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean estadoUpdate(Estado estado) {
        try {
            st = c.prepareStatement("UPDATE Estados SET Descripcion = ? WHERE Id_Estado = ?");

            st.setString(1, estado.getDescripcion());
            st.setInt(2, estado.getId_Estado());

            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
