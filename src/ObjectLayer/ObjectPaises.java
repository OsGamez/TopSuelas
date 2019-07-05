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

public class ObjectPaises {

    PreparedStatement st = null;
    PreparedStatement copy = null;
    Connection c = Server.getCobranza();
    Connection rc = Server.getRcobranza();
//    DB db = new DB();
//    Connection c = db.Cobranza();
//    Connection rc = db.Rcobranza();
    ResultSet rs = null;

    public boolean paisAdd(String Descripcion, boolean Activo) {
        boolean rpta = false;
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("INSERT INTO Paises (Descripcion ,Activo)"
                    + "values(?,?)");
            c.setAutoCommit(false);
            st.setString(1, Descripcion);
            st.setBoolean(2, Activo);
            rpta = st.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rpta = paisAddCopy(Descripcion, Activo);
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
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.cerrarPhylonA(st);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
        }
        return rpta;
    }

    public boolean paisAddCopy(String Descripcion, boolean Activo) {
        boolean rpta = false;
        try {
            copy = rc.prepareStatement("INSERT INTO Paises (Descripcion ,Activo)"
                    + "values(?,?)");
            rc.setAutoCommit(false);
            copy.setString(1, Descripcion);
            copy.setBoolean(2, Activo);
            rpta = copy.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rc.commit();
                copy.close();
            } else {
                rc.rollback();
                copy.close();
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

    public int validarPais(String nombre) {
        try {
            st = c.prepareStatement("SELECT COUNT (Id_Pais) FROM Paises WHERE Descripcion=? AND Activo = 1");
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

    public ArrayList<Pais> paisesGetAll() {
        ArrayList<Pais> listaPaises = new ArrayList<Pais>();
        try {
            st = c.prepareStatement("SELECT * FROM Paises WHERE Activo = 1 ORDER BY Descripcion");
            rs = st.executeQuery();
            while (rs.next()) {
                Pais pais = new Pais();
                pais.setId_Pais(rs.getInt("Id_Pais"));
                pais.setDescripcion(rs.getString("Descripcion"));
                listaPaises.add(pais);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPaises;
    }

    public ArrayList<Pais> paisSearch(String criterio) {
        ArrayList<Pais> listaPaises = new ArrayList<Pais>();
        try {
            st = c.prepareStatement("SELECT * FROM Paises WHERE Activo = 1 AND  Descripcion LIKE '%" + criterio + "%'"
                    + "ORDER BY Descripcion ");
            rs = st.executeQuery();
            while (rs.next()) {
                Pais pais = new Pais();
                pais.setId_Pais(rs.getInt("Id_Pais"));
                pais.setDescripcion(rs.getString("Descripcion"));
                listaPaises.add(pais);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPaises;
    }

    public boolean paisDelete(int Id_Pais, String Descripcion) {
        boolean rpta = false;
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("select c.RazonSocial,p.Id_Pais from Clientes c\n"
                    + "inner join Paises p \n"
                    + "on c.Id_Pais = p.Id_Pais\n"
                    + "where p.Id_Pais = ? and c.Activo = 1");
            c.setAutoCommit(false);
            st.setInt(1, Id_Pais);
            rs = st.executeQuery();
            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("UPDATE Paises SET Activo = 0 WHERE Descripcion = ?");
                st.setString(1, Descripcion);
                rpta = st.executeUpdate() == 1 ? true : false;
                if (rpta) {
                    rpta = paisDeleteCopy(Descripcion);
                    if (!rpta) {
                        c.rollback();
                        c.close();
                    } else {
                        c.commit();
                        c.close();
                    }
                } else {
                    c.rollback();
                    c.close();
                }
                c.close();
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

    public boolean paisDeleteCopy(String Descripcion) {
        boolean rpta = false;
        try {
            rc.setAutoCommit(false);
            copy = rc.prepareStatement("UPDATE Paises SET Activo = 0 WHERE Descripcion = ?");
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

    public boolean paisUpdate(String Descripcion, String Nombre) {
        boolean rpta = false;
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE Paises SET Descripcion = ? WHERE Descripcion = ?");
            c.setAutoCommit(false);
            st.setString(1, Descripcion);
            st.setString(2, Nombre);
            rpta = st.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rpta = paisUpdateCopy(Descripcion, Nombre);
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
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.cerrarPhylonA(st);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
        }
        return rpta;
    }

    public boolean paisUpdateCopy(String Descripcion, String Nombre) {
        boolean rpta = false;
        try {
            rc.setAutoCommit(false);
            copy = rc.prepareStatement("UPDATE Paises SET Descripcion = ? WHERE Descripcion = ?");
            copy.setString(1, Descripcion);
            copy.setString(2, Nombre);
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
}
