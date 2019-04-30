package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Cliente {

    private int Id_Cliente;
    private String RazonSocial;
    private String Codigo;
    private int Id_Ciudad;
    private String RFC;
    private int Id_Agente;
    private String CP;
    private int Id_Zona;
    private String Colonia;
    private String Telefono;
    private int Id_Pais;
    private int Id_Estado;
    private String Cuenta;
    private int DiasCredito;
    private String Email;
    private String Contacto;
    private String Observaciones;
    private String UsoCfdi;
    private String FormaPago;
    private int Id_Banco;
    private String Calle;
    private String MetodoPago;
    private String NumeroCalle;
    private boolean Activo;
    private String Telefono2;
    private String Telefono3;

    private String Agente;
    private String Ciudad;
    private String Estado;
    private String Banco;
    private String Pais;
    private String Zona;
    

    PreparedStatement st = null;
    Connection c = Server.getCobranza();
    ResultSet rs = null;

    public Cliente(Usuario us) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getAgente() {
        return Agente;
    }

    public void setAgente(String Agente) {
        this.Agente = Agente;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getBanco() {
        return Banco;
    }

    public void setBanco(String Banco) {
        this.Banco = Banco;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getZona() {
        return Zona;
    }

    public void setZona(String Zona) {
        this.Zona = Zona;
    }

    public Cliente() {
    }

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public int getId_Ciudad() {
        return Id_Ciudad;
    }

    public void setId_Ciudad(int Id_Ciudad) {
        this.Id_Ciudad = Id_Ciudad;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public int getId_Agente() {
        return Id_Agente;
    }

    public void setId_Agente(int Id_Agente) {
        this.Id_Agente = Id_Agente;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public int getId_Zona() {
        return Id_Zona;
    }

    public void setId_Zona(int Id_Zona) {
        this.Id_Zona = Id_Zona;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public String getMetodoPago() {
        return MetodoPago;
    }

    public void setMetodoPago(String MetodoPago) {
        this.MetodoPago = MetodoPago;
    }

    public String getNumeroCalle() {
        return NumeroCalle;
    }

    public void setNumeroCalle(String NumeroCalle) {
        this.NumeroCalle = NumeroCalle;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public int getId_Pais() {
        return Id_Pais;
    }

    public void setId_Pais(int Id_Pais) {
        this.Id_Pais = Id_Pais;
    }

    public int getId_Estado() {
        return Id_Estado;
    }

    public void setId_Estado(int Id_Estado) {
        this.Id_Estado = Id_Estado;
    }

    public String getCuenta() {
        return Cuenta;
    }

    public void setCuenta(String Cuenta) {
        this.Cuenta = Cuenta;
    }

    public int getDiasCredito() {
        return DiasCredito;
    }

    public void setDiasCredito(int DiasCredito) {
        this.DiasCredito = DiasCredito;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getUsoCfdi() {
        return UsoCfdi;
    }

    public void setUsoCfdi(String UsoCfdi) {
        this.UsoCfdi = UsoCfdi;
    }

    public String getFormaPago() {
        return FormaPago;
    }

    public void setFormaPago(String FormaPago) {
        this.FormaPago = FormaPago;
    }

    public int getId_Banco() {
        return Id_Banco;
    }

    public void setId_Banco(int Id_Banco) {
        this.Id_Banco = Id_Banco;
    }

    public boolean getActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    public String getTelefono2() {
        return Telefono2;
    }

    public void setTelefono2(String Telefono2) {
        this.Telefono2 = Telefono2;
    }

    public String getTelefono3() {
        return Telefono3;
    }

    public void setTelefono3(String Telefono3) {
        this.Telefono3 = Telefono3;
    }
    
    

    @Override
    public String toString() {
        return this.RazonSocial;
    }

    public Vector<Cliente> getClientes() {

        Vector<Cliente> datos = new Vector<Cliente>();
        Cliente cl = null;

        try {
            st = c.prepareStatement("SELECT * FROM Clientes WHERE Activo = 1 ORDER BY RazonSocial");
            rs = st.executeQuery();

            cl = new Cliente();
            cl.setId_Cliente(0);
            cl.setRazonSocial("Seleciona un cliente");
            datos.add(cl);

            while (rs.next()) {
                cl = new Cliente();
                cl.setId_Cliente(rs.getInt("Id_Cliente"));
                cl.setRazonSocial(rs.getString("RazonSocial"));
                datos.add(cl);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }
}
