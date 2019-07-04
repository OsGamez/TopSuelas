package ObjectLayer;

import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectProveedoresMPrima {

    PreparedStatement st = null;
    ResultSet rs = null;
    Connection c = Server.getCmpPhylon();
//    DB db = new DB();
//    Connection c = db.Cmp();

    public boolean ProveedorMPrimaAdd(ProveedorMPrima p) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("INSERT INTO ProvedoresMPrima(nombre,calle,colonia,ciudad,estado,pais,cp,rfc,email,telefono"
                    + ",telefono2,contacto,tipo,embarque,diascredito,limitecredito,fechaultimacompra,stat)"
                    + "VALUES ('" + p.getNombre() + "','" + p.getCalle() + "','" + p.getColonia() + "','" + p.getCiudad() + "',"
                    + "'" + p.getEstado() + "','" + p.getPais() + "'," + p.getCp() + ",'" + p.getRfc() + "','" + p.getEmail() + "',"
                    + "'" + p.getTelefono() + "','" + p.getTelefono2() + "','" + p.getContacto() + "',"
                    + "'" + p.getTpo() + "','" + p.getEmbarque() + "'," + p.getDiascredito() + ","
                    + "'" + p.getLimitecredito() + "','" + p.getFechaultima() + "','1')");
            st.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectProveedoresMPrima.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(ObjectProveedoresMPrima.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean ProveedorMPrimaUpdate(ProveedorMPrima p) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE ProvedoresMPrima SET nombre = '" + p.getNombre() + "', calle='" + p.getCalle() + "'"
                    + ", colonia='" + p.getColonia() + "', ciudad='" + p.getCiudad() + "', estado='" + p.getEstado() + "'"
                    + ", pais='" + p.getPais() + "', cp=" + p.getCp() + ", rfc='" + p.getRfc() + "', email='" + p.getEmail() + "'"
                    + ", telefono='" + p.getTelefono() + "', telefono2='" + p.getTelefono2() + "', contacto='" + p.getContacto() + "'"
                    + ", embarque ='" + p.getEmbarque() + "', diascredito=" + p.getDiascredito() + ", limitecredito='" + p.getLimitecredito() + "' "
                    + "WHERE Proveedor = " + p.getProveedor());
            st.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectProveedoresMPrima.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(ObjectProveedoresMPrima.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public ArrayList<ProveedorMPrima> ProveedorMPrimaGetAll() {
        ArrayList<ProveedorMPrima> listaProveedorMPrima = new ArrayList<>();
        try {
            st = c.prepareStatement("SELECT top(50) * FROM ProvedoresMPrima where stat='1' ORDER BY Nombre");
            rs = st.executeQuery();
            while (rs.next()) {
                ProveedorMPrima cs = new ProveedorMPrima();
                cs.setProveedor(rs.getInt("Proveedor"));
                cs.setNombre(rs.getString("nombre"));
                cs.setCalle(rs.getString("calle"));
                cs.setColonia(rs.getString("Colonia"));
                cs.setEstado(rs.getString("estado"));
                cs.setCiudad(rs.getString("ciudad"));
                cs.setPais(rs.getString("pais"));
                cs.setCp(rs.getString("cp"));
                cs.setRfc(rs.getString("rfc"));
                cs.setTelefono(rs.getString("telefono"));
                cs.setEmail(rs.getString("email"));
                cs.setTelefono2(rs.getString("telefono2"));
                cs.setContacto(rs.getString("contacto"));
                cs.setEmbarque(rs.getString("embarque"));
                cs.setDiascredito(rs.getInt("diascredito"));
                cs.setLimitecredito(rs.getString("limitecredito"));
                listaProveedorMPrima.add(cs);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaProveedorMPrima;
    }

    public ArrayList<ProveedorMPrima> ProveedorMPrimaSearch(String filtro) {
        ArrayList<ProveedorMPrima> listaProveedorMPrima = new ArrayList<ProveedorMPrima>();
        try {
            st = c.prepareStatement("SELECT top(50)  * FROM ProvedoresMPrima WHERE stat='1' and (nombre LIKE'%" + filtro + "%' "
                    + "or rfc like '%" + filtro + "%') ORDER BY Nombre");
            rs = st.executeQuery();

            while (rs.next()) {
                ProveedorMPrima cs = new ProveedorMPrima();
                cs.setProveedor(rs.getInt("Proveedor"));
                cs.setNombre(rs.getString("nombre"));
                cs.setCalle(rs.getString("calle"));
                cs.setColonia(rs.getString("Colonia"));
                cs.setEstado(rs.getString("estado"));
                cs.setCiudad(rs.getString("ciudad"));
                cs.setPais(rs.getString("pais"));
                cs.setCp(rs.getString("cp"));
                cs.setRfc(rs.getString("rfc"));
                cs.setTelefono(rs.getString("telefono"));
                cs.setEmail(rs.getString("email"));
                cs.setTelefono2(rs.getString("telefono2"));
                cs.setContacto(rs.getString("contacto"));
                cs.setEmbarque(rs.getString("embarque"));
                cs.setDiascredito(rs.getInt("diascredito"));
                cs.setLimitecredito(rs.getString("limitecredito"));
                listaProveedorMPrima.add(cs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaProveedorMPrima;
    }

    public boolean validarCuenta(String cuenta, String Subcuenta) {
        boolean resp = true;
        try {
            st = c.prepareStatement("SELECT Cuenta FROM ProveedorMPrimases WHERE Cuenta = ? and Subcuenta=?");
            st.setString(1, cuenta);
            st.setString(2, Subcuenta);
            rs = st.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(ObjectProveedoresMPrima.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    public int validarProveedor(String nombre, String rfc) {
        try {
            st = c.prepareStatement("SELECT COUNT (nombre) FROM ProvedoresMPrima WHERE Nombre='" + nombre + "' or rfc = '" + rfc + "'");
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            st.close();
            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 1;
        }
    }

    public boolean ProveedorMPrimaDelete(int id) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("Update ProvedoresMPrima set stat='0' WHERE Proveedor=" + id);
            st.execute();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
                Logger.getLogger(ObjectProveedoresMPrima.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(ObjectProveedoresMPrima.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
