package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ObjectAgentes {

    PreparedStatement st = null;
    PreparedStatement copy = null;
//    DB db = new DB();
//    Connection c = db.Cobranza();
//    Connection rc = db.Rcobranza();

    Connection c = Server.getCobranza();
    Connection rc = Server.getRcobranza();
    ResultSet rs = null;

    public boolean agenteAdd(String Descripcion, boolean Activo) {
        boolean rpta = false;
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("INSERT INTO Agentes (Descripcion ,Activo)"
                    + "values(?,?)");
            st.setString(1, Descripcion);
            st.setBoolean(2, Activo);
            rpta = st.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rpta = agregarCopia(Descripcion, Activo);
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

    public boolean agregarCopia(String Descripcion, boolean Activo) {
        boolean rpta = false;
        try {
            rc.setAutoCommit(false);
            copy = rc.prepareStatement("INSERT INTO Agentes (Descripcion ,Activo)"
                    + "values(?,?)");
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

    public int validarAgente(String nombre) {
        try {
            st = c.prepareStatement("SELECT COUNT (Id_Agente) FROM Agentes WHERE Descripcion=? AND Activo = 1");
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

    public ArrayList<Agente> agentesGetAll() {
        ArrayList<Agente> listaAgentes = new ArrayList<Agente>();
        try {
            st = c.prepareStatement("SELECT * FROM Agentes WHERE Activo = 1 ORDER BY Descripcion");
            rs = st.executeQuery();
            while (rs.next()) {
                Agente agente = new Agente();
                agente.setId_Agente(rs.getInt("Id_Agente"));
                agente.setDescripcion(rs.getString("Descripcion"));
                listaAgentes.add(agente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaAgentes;
    }

    public ArrayList<Agente> agenteSearch(String criterio) {
        ArrayList<Agente> listaAgentes = new ArrayList<Agente>();
        try {
            st = c.prepareStatement("SELECT * FROM Agentes WHERE Activo = 1 AND  Descripcion LIKE '%" + criterio + "%'"
                    + "ORDER BY Descripcion ");
            rs = st.executeQuery();
            while (rs.next()) {
                Agente agente = new Agente();
                agente.setId_Agente(rs.getInt("Id_Agente"));
                agente.setDescripcion(rs.getString("Descripcion"));
                agente.setActivo(rs.getBoolean("Activo"));
                listaAgentes.add(agente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaAgentes;
    }

    public boolean agenteDelete(int Id_Agente, String Descripcion) {
        boolean rpta = false;
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("select c.RazonSocial,a.Id_Agente from Clientes c\n"
                    + "inner join Agentes a \n"
                    + "on c.Id_Agente = a.Id_Agente\n"
                    + "where a.Id_Agente = ? and c.Activo = 1");
            st.setInt(1, Id_Agente);
            rs = st.executeQuery();
            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("UPDATE Agentes SET Activo = 0 WHERE Descripcion = ?");
                st.setString(1, Descripcion);
                rpta = st.executeUpdate() == 1 ? true : false;
                if (rpta) {
                    rpta = agenteDeleteCopy(Descripcion);
                    if (!rpta) {
                        c.rollback();
                        st.close();
                    } else {
                        c.commit();
                        st.close();
                    }
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

    public boolean agenteUpdate(String Descripcion, String Nombre) {
        boolean rpta = false;
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE Agentes SET Descripcion = ? WHERE Descripcion = ?");
            st.setString(1, Descripcion);
            st.setString(2, Nombre);
            rpta = st.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rpta = agenteUpdateCopy(Descripcion, Nombre);
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

    public boolean agenteUpdateCopy(String Descripcion, String Nombre) {
        boolean rpta = false;
        try {
            copy = rc.prepareStatement("UPDATE Agentes SET Descripcion = ? WHERE Descripcion = ?");
            rc.setAutoCommit(false);
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

    public boolean agenteDeleteCopy(String Descripcion) {
        boolean rpta = false;
        try {
            rc.setAutoCommit(false);
            copy = rc.prepareStatement("UPDATE Agentes SET Activo = 0 WHERE Descripcion = ?");
            copy.setString(1, Descripcion);

            rpta = copy.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rc.commit();
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
    
    /*public ArrayList<Agente> getNumAgente() {
        ArrayList<Agente> listaP = new ArrayList<Agente>();
        try {
            st = c.prepareStatement("SELECT  MAX(CONVERT(INT,Num)) as NumAgentes FROM Agentes");
            rs = st.executeQuery();

            while (rs.next()) {
                int Num = rs.getInt("Num");
                Agente par = new Agente();
                par.setNumCliente(String.valueOf(Num));
                listaP.add(par);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaP;
    }*/
}
