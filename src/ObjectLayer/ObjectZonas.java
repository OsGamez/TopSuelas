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

public class ObjectZonas {

    PreparedStatement st = null;
    PreparedStatement copy = null;
    Connection c = Server.getCobranza();
    Connection rc = Server.getRcobranza();
    ResultSet rs = null;

    public boolean zonaAdd(Zona zona) {
        try {
            c.setAutoCommit(false);
            rc.setAutoCommit(false);
            try {
                st = c.prepareStatement("INSERT INTO Zonas (Descripcion ,Activo)"
                        + "values(?,?)");

                st.setString(1, zona.getDescripcion());
                st.setBoolean(2, zona.getActivo());
                st.executeUpdate();

                copy = rc.prepareStatement("INSERT INTO Zonas (Descripcion ,Activo)"
                        + "values(?,?)");

                copy.setString(1, zona.getDescripcion());
                copy.setBoolean(2, zona.getActivo());
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
            Logger.getLogger(ObjectZonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void zonaAddCopy(Zona zona) {
        try {
            st = rc.prepareStatement("INSERT INTO Zonas (Descripcion ,Activo)"
                    + "values(?,?)");

            st.setString(1, zona.getDescripcion());
            st.setBoolean(2, zona.getActivo());

            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int validarZona(String nombre) {
        try {
            st = c.prepareStatement("SELECT COUNT (Id_Zona) FROM Zonas WHERE Descripcion=? AND Activo = 1");
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

    public ArrayList<Zona> zonasGetAll() {
        ArrayList<Zona> listaZonas = new ArrayList<Zona>();
        try {
            st = c.prepareStatement("SELECT * FROM Zonas WHERE Activo = 1 ORDER BY Descripcion");
            rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Id_Zona");
                String descripcion = rs.getString("Descripcion");

                Zona zona = new Zona();
                zona.setId_Zona(id);
                zona.setDescripcion(descripcion);
                listaZonas.add(zona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaZonas;
    }

    public ArrayList<Zona> zonaSearch(String criterio) {
        ArrayList<Zona> listaZonas = new ArrayList<Zona>();
        try {
            st = c.prepareStatement("SELECT * FROM Zonas WHERE Activo = 1 AND  Descripcion LIKE '%" + criterio + "%'"
                    + "ORDER BY Descripcion ");

            rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Id_Zona");
                String descripcion = rs.getString("Descripcion");

                Zona zona = new Zona();
                zona.setId_Zona(id);
                zona.setDescripcion(descripcion);
                listaZonas.add(zona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaZonas;

    }

    public boolean zonaDelete(int Id_Zona) {
        try {
            st = c.prepareStatement("select c.RazonSocial,z.Id_Zona from Clientes c\n"
                    + "inner join Zonas z \n"
                    + "on c.Id_Zona = z.Id_Zona\n"
                    + "where z.Id_Zona = ? and c.Activo = 1");
            st.setInt(1, Id_Zona);
            rs = st.executeQuery();

            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("UPDATE Zonas SET Activo = 0 WHERE Id_Zona = ?");
                st.setInt(1, Id_Zona);
                st.execute();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean zonaUpdate(Zona zona) {
        try {
            st = c.prepareStatement("UPDATE Zonas SET Descripcion = ? WHERE Id_Zona = ?");

            st.setString(1, zona.getDescripcion());
            st.setInt(2, zona.getId_Zona());

            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
