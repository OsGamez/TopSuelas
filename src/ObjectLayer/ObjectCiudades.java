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

public class ObjectCiudades {

    PreparedStatement st = null;
    PreparedStatement copy = null;
    Connection c = Server.getCobranza();
    Connection rc = Server.getRcobranza();
    ResultSet rs = null;

    public boolean ciudadAdd(Ciudad ciudad) {
        try {
            rc.setAutoCommit(false);
            c.setAutoCommit(false);
            try {
                st = c.prepareStatement("INSERT INTO Ciudades (Descripcion ,Activo)"
                        + "values(?,?)");

                st.setString(1, ciudad.getDescripcion());
                st.setBoolean(2, ciudad.getActivo());
                st.executeUpdate();

                copy = rc.prepareStatement("INSERT INTO Ciudades (Descripcion ,Activo)"
                        + "values(?,?)");

                copy.setString(1, ciudad.getDescripcion());
                copy.setBoolean(2, ciudad.getActivo());
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
            Logger.getLogger(ObjectCiudades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int validarCiudad(String nombre) {
        try {
            st = c.prepareStatement("SELECT COUNT (Id_Ciudad) FROM Ciudades WHERE Descripcion=? AND Activo = 1");
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

    public ArrayList<Ciudad> ciudadesGetAll() {
        ArrayList<Ciudad> listaCiudades = new ArrayList<Ciudad>();
        try {
            st = c.prepareStatement("SELECT * FROM Ciudades WHERE Activo = 1 ORDER BY Descripcion");
            rs = st.executeQuery();

            while (rs.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setId_Ciudad(rs.getInt("Id_Ciudad"));
                ciudad.setDescripcion(rs.getString("Descripcion"));
                listaCiudades.add(ciudad);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCiudades;
    }

    public ArrayList<Ciudad> ciudadSearch(String criterio) {
        ArrayList<Ciudad> listaCiudades = new ArrayList<Ciudad>();
        try {
            st = c.prepareStatement("SELECT * FROM Ciudades WHERE Activo = 1 AND  Descripcion LIKE '%" + criterio + "%'"
                    + "ORDER BY Descripcion ");

            rs = st.executeQuery();

            while (rs.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setId_Ciudad(rs.getInt("Id_Ciudad"));
                ciudad.setDescripcion(rs.getString("Descripcion"));
                listaCiudades.add(ciudad);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCiudades;
    }

    public boolean ciudadDelete(int Id_Ciudad) {
        try {
            st = c.prepareStatement("select c.RazonSocial,c.Id_Ciudad from Clientes c\n"
                    + "inner join Ciudades cd \n"
                    + "on c.Id_Ciudad = cd.Id_Ciudad\n"
                    + "where cd.Id_Ciudad = ? and c.Activo = 1");
            st.setInt(1, Id_Ciudad);
            rs = st.executeQuery();

            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("UPDATE Ciudades SET Activo = 0 WHERE Id_Ciudad = ?");
                st.setInt(1, Id_Ciudad);
                st.execute();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean ciudadUpdate(Ciudad ciudad) {
        try {
            st = c.prepareStatement("UPDATE Ciudades SET Descripcion = ? WHERE Id_Ciudad = ?");

            st.setString(1, ciudad.getDescripcion());
            st.setInt(2, ciudad.getId_Ciudad());

            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
