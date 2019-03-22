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

public class ObjectAlmacenes {

    PreparedStatement st = null;
    ResultSet rs = null;
    Connection c = Server.getCmpPhylon();

    public boolean almacenAdd(Almacen a) {
        try {
            c.setAutoCommit(false);
            try {
                st = c.prepareStatement("INSERT INTO Almacenes(Almacen,Descripcion)"
                        + "VALUES(?,?)");
                st.setInt(1, a.getAlmacen());
                st.setString(2, a.getDescripcion());
                st.executeUpdate();
                c.commit();
                return true;
            } catch (SQLException ex) {
                c.rollback();
                ex.printStackTrace();
            } finally {
                if (st != null) {
                    st.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObjectGastos.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean almacenUpdate(Almacen a) {
        try {
            st = c.prepareStatement("UPDATE Almacenes SET Descripcion =? WHERE Almacen = ?");
            st.setString(1, a.getDescripcion());
            st.setInt(2, a.getAlmacen());
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean almacenDelete(int Id, String Des) {
        try {
            st = c.prepareStatement("DELETE FROM Almacenes WHERE Almacen = ? AND Descripcion = ?");
            st.setInt(1, Id);
            st.setString(2, Des);
            st.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
