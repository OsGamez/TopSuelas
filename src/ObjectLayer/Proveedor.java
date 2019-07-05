
package ObjectLayer;

import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class Proveedor {
    
    private int Proveedor;
    private String Nombre;
    private String RFC;
    private String Direccion;
    private String Ciudad;
    private String CP;
    private String Telefonos;
    private String Fax;
    private String CorreoE;
    private String Contacto;
    private String Estatus;

    PreparedStatement st = null;
    ResultSet rs = null;
    Connection c = Server.getPhylon();
//    DB db = new DB();
//    Connection c = db.RCPTPhylonA();
    
    
    public int getProveedor() {
        return Proveedor;
    }

    public void setProveedor(int Proveedor) {
        this.Proveedor = Proveedor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getTelefonos() {
        return Telefonos;
    }

    public void setTelefonos(String Telefonos) {
        this.Telefonos = Telefonos;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public String getCorreoE() {
        return CorreoE;
    }

    public void setCorreoE(String CorreoE) {
        this.CorreoE = CorreoE;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String Estatus) {
        this.Estatus = Estatus;
    }
    
    @Override
    public String toString(){
        return this.Nombre;
    }
    
    public Vector<Proveedor>getProveedores() {
        Vector<Proveedor> datos = new Vector<Proveedor>();
        Proveedor p = null;

        try {
            st = c.prepareStatement("SELECT * FROM Proveedores WHERE Estatus = 'A' ORDER BY Nombre");
            rs = st.executeQuery();

            p = new Proveedor();
            p.setProveedor(0);
            p.setNombre("Seleciona un proveedor");
            datos.add(p);

            while (rs.next()) {
                p = new Proveedor();
                p.setProveedor(rs.getInt("Proveedor"));
                p.setNombre(rs.getString("Nombre"));
                datos.add(p);
            }
            rs.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            //rs.close();
        }
        return datos;
    }
}
