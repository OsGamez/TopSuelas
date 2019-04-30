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

    public boolean estadoAdd(String Descripcion, boolean Activo) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("INSERT INTO Estados (Descripcion ,Activo)"
                    + "values(?,?)");
            c.setAutoCommit(false);
            st.setString(1, Descripcion);
            st.setBoolean(2, Activo);
            rpta = st.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rpta = estadoAddCopy(Descripcion, Activo);
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

    public boolean estadoAddCopy(String Descripcion, boolean Activo) {
        boolean rpta = false;
        try {
            copy = rc.prepareStatement("INSERT INTO Estados (Descripcion ,Activo)"
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

    public boolean estadoDelete(int Id_Estado, String Descripcion) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("select c.RazonSocial,e.Id_Estado from Clientes c\n"
                    + "inner join Estados e \n"
                    + "on c.Id_Pais = e.Id_Estado\n"
                    + "where e.Id_Estado = ? and c.Activo = 1");
            c.setAutoCommit(false);
            st.setInt(1, Id_Estado);
            rs = st.executeQuery();
            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("UPDATE Estados SET Activo = 0 WHERE Descripcion = ?");
                st.setString(1, Descripcion);
                rpta = st.executeUpdate() == 1 ? true : false;
                if (rpta) {
                    rpta = estadoDeleteCopy(Descripcion);
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

    public boolean estadoDeleteCopy(String Descripcion) {
        boolean rpta = false;
        try {
            copy = rc.prepareStatement("UPDATE Estados SET Activo = 0 WHERE Descripcion = ?");
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

    public boolean estadoUpdate(String Descripcion, String Nombre) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("UPDATE Estados SET Descripcion = ? WHERE Descripcion = ?");
            c.setAutoCommit(false);
            st.setString(1, Descripcion);
            st.setString(2, Nombre);
            rpta = st.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rpta = estadoUpdateCopy(Descripcion, Nombre);
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
    
    public boolean estadoUpdateCopy(String Descripcion, String Nombre){
        boolean rpta = false;
        try {
            copy = rc.prepareStatement("UPDATE Estados SET Descripcion = ? WHERE Descripcion = ?");
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
