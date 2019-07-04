package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ObjectColores {

    PreparedStatement st = null;
    public Connection c = Server.getProduccion();
//    DB db = new DB();
//    Connection c = db.Produccion();
    public ResultSet rs = null;

    public boolean colorAdd(String Descripcion, boolean Activo) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("INSERT INTO Color (Descripcion ,Activo)"
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

    public int validarColor(String nombre) {
        try {
            st = c.prepareStatement("SELECT COUNT (Id_Color) FROM Color WHERE Descripcion=? AND Activo = 1");
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

    public ArrayList<Color> coloresGetAll() {
        ArrayList<Color> listaColores = new ArrayList<Color>();
        try {
            st = c.prepareStatement("SELECT * FROM Color WHERE Activo = 1 ORDER BY Descripcion");
            rs = st.executeQuery();
            while (rs.next()) {
                Color color = new Color();
                color.setId_Color(rs.getInt("Id_Color"));
                color.setDescripcion(rs.getString("Descripcion"));
                listaColores.add(color);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaColores;
    }

    public ArrayList<Color> colorSearch(String criterio) {
        ArrayList<Color> listaColores = new ArrayList<Color>();
        try {
            st = c.prepareStatement("SELECT * FROM Color WHERE Activo = 1 And Descripcion LIKE '%" + criterio + "%'"
                    + "ORDER BY Descripcion");
            rs = st.executeQuery();
            while (rs.next()) {
                Color color = new Color();
                color.setId_Color(rs.getInt("Id_Color"));
                color.setDescripcion(rs.getString("Descripcion"));
                listaColores.add(color);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaColores;
    }

    public boolean colorDelete(int Id_Color) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("select p.Descripcion,c.Id_Color from Producto p\n"
                    + "inner join Color c \n"
                    + "on p.Id_Color = c.Id_Color\n"
                    + "where c.Id_Color = ? and p.Activo = 1");
            st.setInt(1, Id_Color);
            rs = st.executeQuery();
            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("UPDATE Color SET Activo = 0 WHERE Id_Color = ?");
                st.setInt(1, Id_Color);
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

    public boolean colorUpdate(String Descripcion, int id) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE Color SET Descripcion = ? WHERE Id_Color = ?");
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