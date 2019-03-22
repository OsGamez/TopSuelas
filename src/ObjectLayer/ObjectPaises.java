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

public class ObjectPaises {

    PreparedStatement st = null;
    PreparedStatement copy = null;
    Connection c = Server.getCobranza();
    Connection rc = Server.getRcobranza();
    ResultSet rs = null;

    public boolean paisAdd(Pais pais) {
        try {
            c.setAutoCommit(false);
            rc.setAutoCommit(false);
            try {
                st = c.prepareStatement("INSERT INTO Paises (Descripcion ,Activo)"
                        + "values(?,?)");

                st.setString(1, pais.getDescripcion());
                st.setBoolean(2, pais.getActivo());
                st.executeUpdate();

                copy = rc.prepareStatement("INSERT INTO Paises (Descripcion ,Activo)"
                        + "values(?,?)");

                copy.setString(1, pais.getDescripcion());
                copy.setBoolean(2, pais.getActivo());
                copy.executeUpdate();
                c.commit();
                rc.commit();
                return true;
            } catch (SQLException ex) {
                c.rollback();
                rc.rollback();
                ex.printStackTrace();
            } finally {
                try {
                    if (st != null) {
                        st.close();
                    }
                    if (copy != null) {
                        copy.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObjectPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
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

    public boolean paisDelete(int Id_Pais) {
        try {
            st = c.prepareStatement("select c.RazonSocial,p.Id_Pais from Clientes c\n"
                    + "inner join Paises p \n"
                    + "on c.Id_Pais = p.Id_Pais\n"
                    + "where p.Id_Pais = ? and c.Activo = 1");
            st.setInt(1, Id_Pais);
            rs = st.executeQuery();

            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("UPDATE Paises SET Activo = 0 WHERE Id_Pais = ?");
                st.setInt(1, Id_Pais);
                st.execute();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean paisUpdate(Pais pais) {
        try {
            st = c.prepareStatement("UPDATE Paises SET Descripcion = ? WHERE Id_Pais = ?");

            st.setString(1, pais.getDescripcion());
            st.setInt(2, pais.getId_Pais());

            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
