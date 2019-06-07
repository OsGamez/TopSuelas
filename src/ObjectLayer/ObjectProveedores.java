package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ObjectProveedores {

    PreparedStatement st = null;
    ResultSet rs = null;
    Connection c = Server.getPhylon();

    public boolean addProveedor(Proveedor p) {
        try {
            st = c.prepareStatement("INSERT INTO Proveedores(Nombre, RFC, Direccion, Ciudad, CP, Telefonos,Fax, CorreoE,Contacto, Estatus)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, p.getNombre());
            st.setString(2, p.getRFC());
            st.setString(3, p.getDireccion());
            st.setString(4, p.getCiudad());
            st.setString(5, p.getCP());
            st.setString(6, p.getTelefonos());
            st.setString(7, p.getFax());
            st.setString(8, p.getCorreoE());
            st.setString(9, p.getContacto());
            st.setString(10, p.getEstatus());
            st.executeUpdate();
            st.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    public int validarProveedor(String nombre) {
        try {
            st = c.prepareStatement("SELECT COUNT (Proveedor) FROM Proveedores WHERE Nombre=? AND Estatus = 'A'");
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

    public ArrayList<Proveedor> provedorGetAll() {
        ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
        try {
            st = c.prepareStatement("SELECT * FROM Proveedores WHERE Estatus = 'A' ORDER BY Nombre");
            rs = st.executeQuery();
            while (rs.next()) {
                Proveedor pv = new Proveedor();
                pv.setProveedor(rs.getInt("Proveedor"));
                pv.setNombre(rs.getString("Nombre"));
                pv.setRFC(rs.getString("RFC"));
                pv.setDireccion(rs.getString("Direccion"));
                pv.setCiudad(rs.getString("Ciudad"));
                pv.setCP(rs.getString("CP"));
                pv.setTelefonos(rs.getString("Telefonos"));
                pv.setFax(rs.getString("Fax"));
                pv.setCorreoE(rs.getString("CorreoE"));
                pv.setContacto(rs.getString("Contacto"));

                listaProveedores.add(pv);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaProveedores;
    }

    public ArrayList<Proveedor> proveedorSearch(String filtro){
         ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
         try {
            st = c.prepareStatement("SELECT * FROM Proveedores WHERE Estatus = 'A' AND Nombre LIKE'%" + filtro + "%'"
                     + "ORDER BY Nombre");
            rs = st.executeQuery();
            
            while(rs.next()){
                Proveedor pv = new Proveedor();
                pv.setProveedor(rs.getInt("Proveedor"));
                pv.setNombre(rs.getString("Nombre"));
                pv.setRFC(rs.getString("RFC"));
                pv.setDireccion(rs.getString("Direccion"));
                pv.setCiudad(rs.getString("Ciudad"));
                pv.setCP(rs.getString("CP"));
                pv.setTelefonos(rs.getString("Telefonos"));
                pv.setFax(rs.getString("Fax"));
                pv.setCorreoE(rs.getString("CorreoE"));
                pv.setContacto(rs.getString("Contacto"));

                listaProveedores.add(pv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          return listaProveedores;
    }
    
    public boolean proveedorUpdate(Proveedor pv) {
        try {
            st = c.prepareStatement("UPDATE Proveedores SET Nombre = ?, RFC = ?, Direccion = ?, Ciudad = ?, CP = ?, Telefonos = ?,"
                    + "Fax = ?, CorreoE = ?, Contacto = ? WHERE Proveedor = ?");
            st.setString(1, pv.getNombre());
            st.setString(2, pv.getRFC());
            st.setString(3, pv.getDireccion());
            st.setString(4, pv.getCiudad());
            st.setString(5, pv.getCP());
            st.setString(6, pv.getTelefonos());
            st.setString(7, pv.getFax());
            st.setString(8, pv.getCorreoE());
            st.setString(9, pv.getContacto());
            st.setInt(10, pv.getProveedor());
            st.executeUpdate();
            st.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteProveedor(int Pv){
        try {
            st = c.prepareStatement("UPDATE Proveedores SET Estatus = 'I' WHERE Proveedor = ?");
            st.setInt(1, Pv);
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
