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

public class ObjectZonas {

    PreparedStatement st = null;
    PreparedStatement copy = null;
    Connection c = Server.getCobranza();
    Connection rc = Server.getRcobranza();
//    DB db = new DB();
//    Connection c = db.Cobranza();
//    Connection rc = db.Rcobranza();
    ResultSet rs = null;

    public boolean zonaAdd(String Descripcion, boolean Activo) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("INSERT INTO Zonas (Descripcion ,Activo)"
                    + "values(?,?)");
            c.setAutoCommit(false);
            st.setString(1, Descripcion);
            st.setBoolean(2, Activo);
            rpta = st.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rpta = zonaAddCopy(Descripcion, Activo);
                if (rpta) {
                    c.commit();
                } else {
                    Conexion.rollbackA(c);
                }
            } else {
                Conexion.rollbackA(c);
            }
            Conexion.cerrarPhylonA(st);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.cerrarPhylonA(st);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
        }
        return rpta;
    }

    public boolean zonaAddCopy(String Descripcion, boolean Activo) {
        boolean rpta = false;
        try {
            copy = rc.prepareStatement("INSERT INTO Zonas (Descripcion ,Activo)"
                    + "values(?,?)");
            rc.setAutoCommit(false);
            copy.setString(1, Descripcion);
            copy.setBoolean(2, Activo);
            rpta = copy.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rc.commit();
            } else {
                Conexion.rollbackA(rc);
            }

            Conexion.cerrarPrep(copy);
        } catch (SQLException e) {
            e.printStackTrace();
            Conexion.cerrarPrep(copy);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(copy);
        }
        return rpta;
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

    public boolean zonaDelete(int Id_Zona, String Descripcion) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("select c.RazonSocial,z.Id_Zona from Clientes c\n"
                    + "inner join Zonas z \n"
                    + "on c.Id_Zona = z.Id_Zona\n"
                    + "where z.Id_Zona = ? and c.Activo = 1");
            c.setAutoCommit(false);
            st.setInt(1, Id_Zona);
            rs = st.executeQuery();
            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("UPDATE Zonas SET Activo = 0 WHERE Descripcion = ?");
                st.setString(1, Descripcion);
                rpta = st.executeUpdate() == 1 ? true : false;
                if (rpta) {
                    rpta = zonaDeleteCopy(Descripcion);
                    c.commit();
                } else {
                    Conexion.rollbackA(c);
                }
                Conexion.cerrarPhylonA(st);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.cerrarPhylonA(st);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
        }
        return rpta;
    }

    public boolean zonaDeleteCopy(String Descripcion) {
        boolean rpta = false;
        try {
            copy = rc.prepareStatement("UPDATE Zonas SET Activo = 0 WHERE Descripcion = ?");
            rc.setAutoCommit(false);
            copy.setString(1, Descripcion);

            rpta = copy.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rc.commit();
            } else {
                Conexion.rollbackA(rc);
            }
            Conexion.cerrarPrep(copy);

        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(copy);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(copy);
        }
        return rpta;
    }

    public boolean zonaUpdate(String Descripcion, String Nombre) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("UPDATE Zonas SET Descripcion = ? WHERE Descripcion = ?");
            c.setAutoCommit(false);
            st.setString(1, Descripcion);
            st.setString(2, Nombre);
            rpta = st.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rpta = zonaUpdateCopy(Descripcion, Nombre);
                if (rpta) {
                    c.commit();
                } else {
                    Conexion.rollbackA(c);
                }
            } else {
                Conexion.rollbackA(c);
            }
            Conexion.cerrarPhylonA(st);

        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.cerrarPhylonA(st);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
        }
        return rpta;
    }

    public boolean zonaUpdateCopy(String Descripcion, String Nombre) {
        boolean rpta = false;
        try {
            copy = rc.prepareStatement("UPDATE Zonas SET Descripcion = ? WHERE Descripcion = ?");
            rc.setAutoCommit(false);
            copy.setString(1, Descripcion);
            copy.setString(2, Nombre);
            rpta = copy.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rc.commit();
            } else {
                Conexion.rollbackA(rc);
            }
            Conexion.cerrarPrep(copy);

        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(copy);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(copy);
        }
        return rpta;
    }
}
