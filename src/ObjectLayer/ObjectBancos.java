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

public class ObjectBancos {

    PreparedStatement st = null;
    PreparedStatement copy = null;
    Connection c = Server.getCobranza();
    Connection rc = Server.getRcobranza();
    ResultSet rs = null;

    public boolean bancoAdd(Banco banco) {
        try {
            c.setAutoCommit(false);
            rc.setAutoCommit(false);
            try {
                st = c.prepareStatement("INSERT INTO Bancos (Descripcion,RFC, CTA ,Activo)"
                        + "values(?,?,?,?)");

                st.setString(1, banco.getDescripcion());
                st.setString(2, banco.getRFC());
                st.setString(3, banco.getCTA());
                st.setBoolean(4, banco.getActivo());
                st.executeUpdate();

                copy = rc.prepareStatement("INSERT INTO Bancos (Descripcion,RFC, CTA ,Activo)"
                        + "values(?,?,?,?)");
                copy.setString(1, banco.getDescripcion());
                copy.setString(2, banco.getRFC());
                copy.setString(3, banco.getCTA());
                copy.setBoolean(4, banco.getActivo());
                copy.executeUpdate();

                c.commit();
                rc.commit();
                return true;
            } catch (SQLException ex) {
                c.rollback();
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
            Logger.getLogger(ObjectBancos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int validarBanco(String nombre) {
        try {
            st = c.prepareStatement("SELECT COUNT (Id_Banco) FROM Bancos WHERE Descripcion=? AND Activo=1");
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

    public ArrayList<Banco> bancosGetAll() {
        ArrayList<Banco> listaBancos = new ArrayList<Banco>();
        try {
            st = c.prepareStatement("SELECT * FROM Bancos WHERE Activo = 1 ORDER BY Descripcion");
            rs = st.executeQuery();

            while (rs.next()) {
                Banco banco = new Banco();
                banco.setId_Banco(rs.getInt("Id_Banco"));
                banco.setDescripcion(rs.getString("Descripcion"));
                banco.setRFC(rs.getString("RFC"));
                banco.setCTA(rs.getString("CTA"));
                listaBancos.add(banco);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaBancos;
    }

    public ArrayList<Banco> bancoSearch(String criterio) {
        ArrayList<Banco> listaBancos = new ArrayList<Banco>();
        try {
            st = c.prepareStatement("SELECT * FROM Bancos WHERE Activo = 1 And Descripcion LIKE '%" + criterio + "%'"
                    + "ORDER BY Descripcion");

            rs = st.executeQuery();

            while (rs.next()) {
                Banco banco = new Banco();
                banco.setId_Banco(rs.getInt("Id_Banco"));
                banco.setDescripcion(rs.getString("Descripcion"));
                banco.setRFC(rs.getString("RFC"));
                banco.setCTA(rs.getString("CTA"));

                listaBancos.add(banco);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaBancos;
    }

    public boolean bancoDelete(int Id_Banco) {
        try {
            st = c.prepareStatement("select c.RazonSocial,c.Id_Banco from Clientes c\n"
                    + "inner join Bancos b \n"
                    + "on c.Id_Banco = b.Id_Banco\n"
                    + "where b.Id_Banco = ? and c.Activo = 1");
            st.setInt(1, Id_Banco);
            rs = st.executeQuery();

            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("UPDATE Bancos SET Activo = 0 WHERE Id_Banco = ?");
                st.setInt(1, Id_Banco);
                st.execute();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean bancoUpdate(Banco banco) {
        try {
            st = c.prepareStatement("UPDATE Bancos SET Descripcion = ?, RFC = ?, CTA = ? WHERE Id_Banco = ?");

            st.setString(1, banco.getDescripcion());
            st.setString(2, banco.getRFC());
            st.setString(3, banco.getCTA());
            st.setInt(4, banco.getId_Banco());

            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}