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

public class ObjectCiudades {

    PreparedStatement st = null;
    PreparedStatement copy = null;
//    Connection c = Server.getCobranza();
//    Connection rc = Server.getRcobranza();
    DB db = new DB();
    Connection c = db.Cobranza();
    Connection rc = db.Rcobranza();
    ResultSet rs = null;

    public boolean ciudadAdd(String Descripcion, boolean Activo) {
        boolean rpta = false;
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("INSERT INTO Ciudades (Descripcion ,Activo)"
                    + "values(?,?)");
            st.setString(1, Descripcion);
            st.setBoolean(2, Activo);
            rpta = st.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rpta = ciudadAddCopy(Descripcion, Activo);
                if (rpta) {
                    c.commit();
                    st.close();
                } else {
                    c.rollback();
                    st.close();
                }
            } else {
                c.rollback();
                st.close();
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

    public boolean ciudadAddCopy(String Descripcion, boolean Activo) {
        boolean rpta = false;
        try {
            rc.setAutoCommit(false);
            copy = rc.prepareStatement("INSERT INTO Ciudades (Descripcion,Activo)"
                    + "values(?,?)");
            copy.setString(1, Descripcion);
            copy.setBoolean(2, Activo);

            rpta = copy.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rc.commit();
                copy.close();
            } else {
                rc.rollback();
            }
            copy.close();
        } catch (SQLException e) {
            e.printStackTrace();
            Conexion.cerrarPrep(copy);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(copy);
        }
        return rpta;
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

    public boolean ciudadDelete(int Id_Ciudad, String Descripcion) {
        boolean rpta = false;
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("select c.RazonSocial,c.Id_Ciudad from Clientes c\n"
                    + "inner join Ciudades cd \n"
                    + "on c.Id_Ciudad = cd.Id_Ciudad\n"
                    + "where cd.Id_Ciudad = ? and c.Activo = 1");
            st.setInt(1, Id_Ciudad);
            rs = st.executeQuery();

            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("UPDATE Ciudades SET Activo = 0 WHERE Descripcion = ?");
                st.setString(1, Descripcion);
                rpta = st.executeUpdate() == 1 ? true : false;

                if (rpta) {
                    rpta = ciudadDeleteCopy(Descripcion);
                    if (!rpta) {
                        c.rollback();
                        st.close();
                    } else {
                        c.commit();
                        c.close();
                    }
                } else {
                    c.rollback();
                    st.close();
                }
                st.close();
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

    public boolean ciudadDeleteCopy(String Descripcion) {
        boolean rpta = false;
        try {
            rc.setAutoCommit(false);
            copy = rc.prepareStatement("UPDATE Ciudades SET Activo = 0 WHERE Descripcion = ?");
            copy.setString(1, Descripcion);

            rpta = copy.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rc.commit();
                copy.close();
            } else {
                rc.rollback();
                copy.close();
            }
            copy.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(copy);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(copy);
        }
        return rpta;
    }

    public boolean ciudadUpdate(String Descripcion, String Nombre) {
        boolean rpta = false;
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE Ciudades SET Descripcion = ? WHERE Descripcion = ?");
            st.setString(1, Descripcion);
            st.setString(2, Nombre);
            //st.executeUpdate();
            //st.close();
            //return true;
            rpta = st.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rpta = ciudadUpdateCopy(Descripcion, Nombre);
                if (rpta) {
                    c.commit();
                    st.close();
                } else {
                   c.rollback();
                   st.close();
                }
            } else {
                c.rollback();
            }
             st.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
            //return false;
        }
        return rpta;
    }

    public boolean ciudadUpdateCopy(String Descripcion, String Nombre) {
        boolean rpta = false;
        try {
            rc.setAutoCommit(false);
            copy = rc.prepareStatement("UPDATE Ciudades SET Descripcion = ? WHERE Descripcion = ?");
            copy.setString(1, Descripcion);
            copy.setString(2, Nombre);
            rpta = copy.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rc.commit();
                copy.close();
            } else {
               rc.rollback();
            }
            copy.close();

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
