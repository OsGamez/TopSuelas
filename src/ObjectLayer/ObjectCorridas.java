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

public class ObjectCorridas {

    Connection c = Server.getProduccion();
//    DB db = new DB();
//    Connection c = db.Produccion();
    PreparedStatement st = null;
    ResultSet rs = null;

    public boolean corridaAdd(Corrida corrida) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("INSERT INTO Corrida (Descripcion,Punto_Inicial,Punto_Final,Observaciones ,Activo)"
                    + "values(?,?,?,?,?)");
            st.setString(1, corrida.getDescripcion());
            st.setFloat(2, corrida.getPunto_Inicial());
            st.setFloat(3, corrida.getPunto_Final());
            st.setString(4, corrida.getObservaciones());
            st.setBoolean(5, corrida.getActivo());
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    public int validarCorrida(String nombre) {
        try {
            st = c.prepareStatement("SELECT COUNT (Id_Corrida) FROM Corrida WHERE Descripcion=? AND Activo = 1");
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

    public ArrayList<Corrida> corridasGetAll() {
        ArrayList<Corrida> listaCorridas = new ArrayList<>();
        try {
            st = c.prepareStatement("SELECT * FROM Corrida WHERE Activo = 1");

            rs = st.executeQuery();

            while (rs.next()) {
                Corrida corrida = new Corrida();
                corrida.setId_Corrida(rs.getInt("Id_Corrida"));
                corrida.setDescripcion(rs.getString("Descripcion"));
                corrida.setPunto_Inicial(rs.getFloat("Punto_Inicial"));
                corrida.setPunto_Final(rs.getFloat("Punto_Final"));
                corrida.setObservaciones(rs.getString("Observaciones"));

                listaCorridas.add(corrida);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCorridas;
    }

    public ArrayList<Corrida> getById(int Id) {
        ArrayList<Corrida> listaCorridas = new ArrayList<Corrida>();
        try {
            st = c.prepareStatement("SELECT * FROM Corrida WHERE Id_Corrida = ? AND Activo = 1");
            st.setInt(1, Id);

            rs = st.executeQuery();

            while (rs.next()) {
                Corrida corrida = new Corrida();
                corrida.setId_Corrida(rs.getInt("Id_Corrida"));
                corrida.setPunto_Inicial(rs.getFloat("Punto_Inicial"));
                corrida.setPunto_Final(rs.getFloat("Punto_Final"));

                listaCorridas.add(corrida);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCorridas;
    }

    public ArrayList<Corrida> corridaSearch(String criterio) {
        ArrayList<Corrida> listaCorridas = new ArrayList<Corrida>();
        try {
            st = c.prepareStatement("SELECT * FROM Corrida WHERE Activo = 1 AND Descripcion LIKE '%" + criterio + "%'"
                    + "ORDER BY Id_Corrida");

            rs = st.executeQuery();

            while (rs.next()) {
                Corrida corrida = new Corrida();
                corrida.setId_Corrida(rs.getInt("Id_Corrida"));
                corrida.setDescripcion(rs.getString("Descripcion"));
                corrida.setPunto_Inicial(rs.getFloat("Punto_Inicial"));
                corrida.setPunto_Final(rs.getFloat("Punto_Final"));
                corrida.setObservaciones(rs.getString("Observaciones"));
                listaCorridas.add(corrida);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCorridas;
    }

    public boolean corridaUpdate(Corrida corrida) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE Corrida SET Descripcion = ?,Punto_Inicial=?,Punto_Final=?,Observaciones=?  WHERE Id_Corrida = ?");

            st.setString(1, corrida.getDescripcion());
            st.setFloat(2, corrida.getPunto_Inicial());
            st.setFloat(3, corrida.getPunto_Final());
            st.setString(4, corrida.getObservaciones());
            st.setInt(5, corrida.getId_Corrida());

            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean corridaDelete(int Id_Corrida) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("select p.Descripcion,c.Id_Corrida from Producto p\n"
                    + "inner join Corrida c \n"
                    + "on p.Id_Corrida = c.Id_Corrida\n"
                    + "where c.Id_Corrida = ?");
            st.setInt(1, Id_Corrida);
            rs = st.executeQuery();

            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("UPDATE Corrida SET Activo = 0 WHERE Id_Corrida = ?");
                st.setInt(1, Id_Corrida);
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
}
