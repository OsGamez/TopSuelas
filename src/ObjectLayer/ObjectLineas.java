package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectLineas {

    PreparedStatement st = null;
//    Connection c = Server.getProduccion();
    DB db = new DB();
    Connection c = db.Produccion();
    ResultSet rs = null;

    public boolean lineaAdd(String Descripcion, boolean Activo) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("INSERT INTO Linea (Descripcion ,Activo)"
                    + "values(?,?)");
            st.setString(1, Descripcion);
            st.setBoolean(2, Activo);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return false;
    }

    public int validarlineas(String nombre) {
        try {
            st = c.prepareStatement("SELECT COUNT (Id_Linea) FROM Linea WHERE Descripcion=? AND Activo = 1");
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

    public ArrayList<Linea> lineasGetAll() {
        ArrayList<Linea> listaLineas = new ArrayList<Linea>();
        try {
            st = c.prepareStatement("SELECT * FROM Linea WHERE Activo = 1 ORDER BY Descripcion");
            rs = st.executeQuery();
            while (rs.next()) {
                Linea linea = new Linea();
                linea.setId_Linea(rs.getInt("Id_linea"));
                linea.setDescripcion(rs.getString("Descripcion"));
                listaLineas.add(linea);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaLineas;
    }

    public ArrayList<Linea> lineaSearch(String criterio) {
        ArrayList<Linea> listaLineas = new ArrayList<Linea>();
        try {
            st = c.prepareStatement("SELECT * FROM Linea WHERE Activo = 1 AND  Descripcion LIKE '%" + criterio + "%'"
                    + "ORDER BY Descripcion");
            rs = st.executeQuery();
            while (rs.next()) {
                Linea linea = new Linea();
                linea.setId_Linea(rs.getInt("Id_linea"));
                linea.setDescripcion(rs.getString("Descripcion"));
                listaLineas.add(linea);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaLineas;
    }

    public boolean lineaDelete(int Id_Linea) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("select p.Descripcion,l.Id_Linea from Producto p\n"
                    + "inner join Linea l \n"
                    + "on p.Id_Linea = l.Id_Linea\n"
                    + "where l.Id_Linea = ? and p.Activo = 1");
            st.setInt(1, Id_Linea);
            rs = st.executeQuery();

            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("UPDATE Linea SET Activo = 0 WHERE Id_Linea = ?");
                st.setInt(1, Id_Linea);
                st.execute();
                c.commit();
                st.close();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean lineaUpdate(String Descripcion, int id) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE Linea SET Descripcion = ? WHERE Id_Linea = ?");

            st.setString(1, Descripcion);
            st.setInt(2, id);

            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
