package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ObjectAlmacenes {

    PreparedStatement st = null;
    ResultSet rs = null;
//    DB db = new DB();
//    Connection c = db.Cmp();
    Connection c = Server.getCmpPhylon();

    public boolean almacenAdd(int am, String Desc) {
            try {
                c.setAutoCommit(false);
                st = c.prepareStatement("INSERT INTO Almacenes(Almacen,Descripcion)"
                       + "VALUES(?,?)");
                st.setInt(1, am);
                st.setString(2, Desc);
                st.executeUpdate();
                c.commit();
                st.close();
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } 
        return false;
    }

    public ArrayList<Almacen> AlmacenGatAll() {
        ArrayList<Almacen> listaAlmacen = new ArrayList<Almacen>();
        try {
            st = c.prepareStatement("SELECT * FROM Almacenes ORDER BY Almacen");
            rs = st.executeQuery();

            while (rs.next()) {
                Almacen am = new Almacen();
                am.setAlmacen(rs.getInt("Almacen"));
                am.setDescripcion(rs.getString("Descripcion"));
                listaAlmacen.add(am);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaAlmacen;
    }

    public int validarAlmacen(int Id, String Des) {
        try {
            st = c.prepareStatement("SELECT COUNT(Almacen) FROM Almacenes WHERE Almacen = ? OR Descripcion = ?");
            st.setInt(1, Id);
            st.setString(2, Des);

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

    public int validar(String Des) {
        try {
            st = c.prepareStatement("SELECT COUNT(Almacen) FROM Almacenes WHERE Descripcion = ?");
            st.setString(1, Des);

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

    public ArrayList<Almacen> almacenSearch(String filtro) {
        ArrayList<Almacen> listaAlmacen = new ArrayList<Almacen>();
        try {
            st = c.prepareStatement("SELECT * FROM Almacenes WHERE Descripcion LIKE'%" + filtro + "%'"
                    + "ORDER BY Almacen");
            rs = st.executeQuery();

            while (rs.next()) {
                Almacen am = new Almacen();
                am.setAlmacen(rs.getInt("Almacen"));
                am.setDescripcion(rs.getString("Descripcion"));
                listaAlmacen.add(am);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaAlmacen;
    }

    public boolean almacenUpdate(String Desc, int am) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE Almacenes SET Descripcion =? WHERE Almacen = ?");
            st.setString(1, Desc);
            st.setInt(2, am);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean almacenDelete(int Id, String Des) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("DELETE FROM Almacenes WHERE Almacen = ? AND Descripcion = ?");
            st.setInt(1, Id);
            st.setString(2, Des);
            st.execute();
            c.commit();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<Almacen>getById(String id){
        ArrayList<Almacen> listaAlmacen = new ArrayList<Almacen>();
        try {
            st = c.prepareStatement("SELECT Almacen  FROM Almacenes WHERE Almacen =?");
            st.setString(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                Almacen am = new Almacen();
                am.setAlmacen(rs.getInt("Almacen"));
                listaAlmacen.add(am);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaAlmacen;
    }
    

}
