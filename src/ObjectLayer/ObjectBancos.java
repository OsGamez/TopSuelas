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
    Connection c = Conexion.getCobranza();
    Connection rc = Conexion.getRcobranza();
    ResultSet rs = null;

    public boolean bancoAdd(Banco banco) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("INSERT INTO Bancos (Descripcion,RFC, CTA ,Activo)"
                    + "values(?,?,?,?)");
            c.setAutoCommit(false);
            st.setString(1, banco.getDescripcion());
            st.setString(2, banco.getRFC());
            st.setString(3, banco.getCTA());
            st.setBoolean(4, banco.getActivo());

            rpta = st.executeUpdate() == 1 ? true : false;

             if (rpta) {
                rpta = bancoAddCopy(banco);
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

    public boolean bancoAddCopy(Banco banco){
        boolean rpta = false;
        try {
            copy = rc.prepareStatement("INSERT INTO Bancos (Descripcion,RFC,CTA ,Activo)"
                    + "values(?,?,?,?)");
            rc.setAutoCommit(false);
            copy.setString(1, banco.getDescripcion());
            copy.setString(2, banco.getRFC());
            copy.setString(3, banco.getCTA());
            copy.setBoolean(4, banco.getActivo());
            
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
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(copy);
        }
        return rpta;
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

    public boolean bancoDelete(int Id_Banco, String Descripcion) {
       boolean rpta = false;
        try {
            st = c.prepareStatement("select c.RazonSocial,c.Id_Banco from Clientes c\n"
                    + "inner join Bancos b \n"
                    + "on c.Id_Banco = b.Id_Banco\n"
                    + "where b.Id_Banco = ? and c.Activo = 1");
            c.setAutoCommit(false);
            st.setInt(1, Id_Banco);
            rs = st.executeQuery();

            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("UPDATE Bancos SET Activo = 0 WHERE Descripcion = ?");
                st.setString(1, Descripcion);
                rpta = st.executeUpdate() == 1 ? true : false;
                if (rpta) {
                    rpta = bancoDeleteCopy(Descripcion);
                    c.commit();
                } else {
                    Conexion.rollbackA(c);
                }
                Conexion.cerrarPhylonA(st);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.cerrarPhylonA(st);
        }catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(copy);
        }
        return rpta;
    }
    public boolean bancoDeleteCopy(String Descripcion) {
        boolean rpta = false;
        try {
            copy = rc.prepareStatement("UPDATE Bancos SET Activo = 0 WHERE Descripcion = ?");
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
        }catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(copy);
        }
        return rpta;
    }
    

    public boolean bancoUpdate(String Descripcion,String Rfc,String Cta,String Nombre) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("UPDATE Bancos SET Descripcion = ?, RFC = ?, CTA = ? WHERE Descripcion = ?");
            c.setAutoCommit(false);
            st.setString(1, Descripcion);
            st.setString(2, Rfc);
            st.setString(3, Cta);
            st.setString(4,Nombre);

            rpta = st.executeUpdate() == 1 ? true : false;
            
             if(rpta){
                rpta = bancoUpdateCopy(Descripcion,Rfc, Cta, Nombre);
                 if (rpta) {
                    c.commit();
                } else {
                    Conexion.rollbackA(c);
                }
            }else {
                Conexion.rollbackA(c);
            }
            Conexion.cerrarPhylonA(st);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.cerrarPhylonA(st);
        }catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
        }
        return rpta;
    }
    
    public boolean bancoUpdateCopy(String Descripcion,String Rfc,String Cta,String Nombre) {
        boolean rpta = false;
        try {
            copy = rc.prepareStatement("UPDATE Bancos SET Descripcion = ?, RFC = ?, CTA = ? WHERE Descripcion = ?");
            rc.setAutoCommit(false);
            copy.setString(1, Descripcion);
            copy.setString(2, Rfc);
            copy.setString(3, Cta);
            copy.setString(4, Nombre);

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
        }catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(copy);
        }
        return rpta;
    }
    
}
