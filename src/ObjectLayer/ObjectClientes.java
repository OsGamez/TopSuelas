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

public class ObjectClientes {

    Connection c = Server.getCobranza();
    Connection rc = Server.getRcobranza();
    PreparedStatement st = null;
    PreparedStatement copy = null;
    ResultSet rs = null;

    public boolean clientesAdd(Cliente cliente) {
        //boolean rpta = false;
        try {

            st = c.prepareStatement("INSERT INTO Clientes (RazonSocial, Codigo, Id_Ciudad, RFC, Id_Agente, CP,"
                    + "Id_Zona, Colonia,Calle,NumeroCalle ,Telefono,Telefono2, Telefono3, Id_Pais, Id_Estado, Cuenta, DiasCredito, Email, Contacto, Observaciones,"
                    + "UsoCfdi, FormaPago,MetodoPago ,Id_Banco, Activo)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            //c.setAutoCommit(false);
            st.setString(1, cliente.getRazonSocial());
            st.setString(2, cliente.getCodigo());
            st.setInt(3, cliente.getId_Ciudad());
            st.setString(4, cliente.getRFC());
            st.setInt(5, cliente.getId_Agente());
            st.setString(6, cliente.getCP());
            st.setInt(7, cliente.getId_Zona());
            st.setString(8, cliente.getColonia());
            st.setString(9, cliente.getCalle());
            st.setString(10, cliente.getNumeroCalle());
            st.setString(11, cliente.getTelefono());
            st.setString(12, cliente.getTelefono2());
            st.setString(13, cliente.getTelefono3());
            st.setInt(14, cliente.getId_Pais());
            st.setInt(15, cliente.getId_Estado());
            st.setString(16, cliente.getCuenta());
            st.setInt(17, cliente.getDiasCredito());
            st.setString(18, cliente.getEmail());
            st.setString(19, cliente.getContacto());
            st.setString(20, cliente.getObservaciones());
            st.setString(21, cliente.getUsoCfdi());
            st.setString(22, cliente.getFormaPago());
            st.setString(23, cliente.getMetodoPago());
            st.setInt(24, cliente.getId_Banco());
            st.setBoolean(25, cliente.getActivo());
            
            st.execute();
            return true; 
        }catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
        }
        return false;
    }

    public boolean clienteAddCopy(Cliente cliente) {
        boolean rpta = false;
        try {
            copy = rc.prepareStatement("INSERT INTO Clientes (RazonSocial, Codigo, Id_Ciudad, RFC, Id_Agente, CP,"
                    + "Id_Zona, Colonia,Calle,NumeroCalle ,Telefono,Telefono2, Telefono3, Id_Pais, Id_Estado, Cuenta, DiasCredito, Email, Contacto, Observaciones,"
                    + "UsoCfdi, FormaPago,MetodoPago ,Id_Banco, Activo)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            rc.setAutoCommit(false);
            copy.setString(1, cliente.getRazonSocial());
            copy.setString(2, cliente.getCodigo());
            copy.setInt(3, cliente.getId_Ciudad());
            copy.setString(4, cliente.getRFC());
            copy.setInt(5, cliente.getId_Agente());
            copy.setString(6, cliente.getCP());
            copy.setInt(7, cliente.getId_Zona());
            copy.setString(8, cliente.getColonia());
            copy.setString(9, cliente.getColonia());
            copy.setString(10, cliente.getNumeroCalle());
            copy.setString(11, cliente.getTelefono());
            copy.setString(12, cliente.getTelefono2());
            copy.setString(13, cliente.getTelefono3());
            copy.setInt(14, cliente.getId_Pais());
            copy.setInt(15, cliente.getId_Estado());
            copy.setString(16, cliente.getCuenta());
            copy.setInt(17, cliente.getDiasCredito());
            copy.setString(18, cliente.getEmail());
            copy.setString(19, cliente.getContacto());
            copy.setString(20, cliente.getObservaciones());
            copy.setString(21, cliente.getUsoCfdi());
            copy.setString(22, cliente.getFormaPago());
            copy.setString(23, cliente.getMetodoPago());
            copy.setInt(24, cliente.getId_Banco());
            copy.setBoolean(25, cliente.getActivo());

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
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(copy);
        }
        return rpta;

    }

    public int validarCliente(String nombre) {
        try {
            st = c.prepareStatement("SELECT COUNT (Id_Cliente) FROM Clientes WHERE RazonSocial=? AND Activo = 1");
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

    public ArrayList<Cliente> clientesGetAll() {
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            st = c.prepareStatement("SELECT  c.Id_Cliente,c.RazonSocial,c.Codigo,c.CP,c.Colonia,c.Calle,"
                    + "c.NumeroCalle,c.UsoCfdi,c.Email,c.Observaciones,c.RFC,c.Telefono,c.Telefono2,c.Telefono3,\n"
                    + "c.Cuenta,c.DiasCredito,c.Contacto,c.FormaPago,c.MetodoPago,\n"
                    + "a.Descripcion as Agente ,z.Descripcion as Zona,p.Descripcion as Pais,\n"
                    + "e.Descripcion as Estado,cd.Descripcion as Ciudad,b.Descripcion as Banco ,c.Id_Agente, c.Id_Banco,\n"
                    + "c.Id_Ciudad, c.Id_Estado,c.Id_Pais, c.Id_Zona\n"
                    + "from Clientes c INNER JOIN Agentes a on c.Id_Agente = a.Id_agente\n"
                    + "INNER JOIN Zonas z on c.Id_Zona = z.Id_Zona \n"
                    + "INNER JOIN Paises p on c.Id_Pais = p.Id_Pais\n"
                    + "INNER JOIN Estados e on c.Id_Estado = e.Id_Estado\n"
                    + "INNER JOIN Ciudades cd on c.Id_Ciudad = cd.Id_Ciudad\n"
                    + "INNER JOIN Bancos b on c.Id_Banco = b.Id_Banco  WHERE c.Activo = 1 ORDER BY c.RazonSocial");

            rs = st.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_Cliente(rs.getInt("Id_Cliente"));
                cliente.setRazonSocial(rs.getString("RazonSocial"));
                cliente.setRFC(rs.getString("RFC"));
                cliente.setTelefono(rs.getString("Telefono"));
                cliente.setTelefono2(rs.getString("Telefono2"));
                cliente.setTelefono3(rs.getString("Telefono3"));
                cliente.setCuenta(rs.getString("Cuenta"));
                cliente.setDiasCredito(rs.getInt("DiasCredito"));
                cliente.setContacto(rs.getString("Contacto"));
                cliente.setFormaPago(rs.getString("FormaPago"));
                cliente.setMetodoPago(rs.getString("MetodoPago"));
                cliente.setCodigo(rs.getString("Codigo"));
                cliente.setColonia(rs.getString("Colonia"));
                cliente.setCalle(rs.getString("Calle"));
                cliente.setNumeroCalle(rs.getString("NumeroCalle"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setUsoCfdi(rs.getString("UsoCfdi"));
                cliente.setCP(rs.getString("CP"));
                cliente.setObservaciones(rs.getString("Observaciones"));
                cliente.setId_Agente(rs.getInt("Id_Agente"));
                cliente.setId_Zona(rs.getInt("Id_Zona"));
                cliente.setId_Pais(rs.getInt("Id_Pais"));
                cliente.setId_Estado(rs.getInt("Id_Estado"));
                cliente.setId_Ciudad(rs.getInt("Id_Ciudad"));
                cliente.setId_Banco(rs.getInt("Id_Banco"));
                cliente.setAgente(rs.getString("Agente"));
                cliente.setZona(rs.getString("Zona"));
                cliente.setPais(rs.getString("Pais"));
                cliente.setEstado(rs.getString("Estado"));
                cliente.setCiudad(rs.getString("Ciudad"));
                cliente.setBanco(rs.getString("Banco"));
                listaClientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaClientes;
    }

    public ArrayList<Cliente> clienteSearch(String filtro) {
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            st = c.prepareStatement("SELECT  c.Id_Cliente,c.RazonSocial,c.Codigo,c.CP,c.Colonia,c.Calle,"
                    + "c.NumeroCalle,c.UsoCfdi,c.Email,c.Observaciones,c.RFC,c.Telefono,c.Telefono2,c.Telefono3,\n"
                    + "c.Cuenta,c.DiasCredito,c.Contacto,c.FormaPago,c.MetodoPago,\n"
                    + "a.Descripcion as Agente ,z.Descripcion as Zona,p.Descripcion as Pais,\n"
                    + "e.Descripcion as Estado,cd.Descripcion as Ciudad,b.Descripcion as Banco ,c.Id_Agente, c.Id_Banco,\n"
                    + "c.Id_Ciudad, c.Id_Estado,c.Id_Pais, c.Id_Zona\n"
                    + "from Clientes c INNER JOIN Agentes a on c.Id_Agente = a.Id_agente\n"
                    + "INNER JOIN Zonas z on c.Id_Zona = z.Id_Zona \n"
                    + "INNER JOIN Paises p on c.Id_Pais = p.Id_Pais\n"
                    + "INNER JOIN Estados e on c.Id_Estado = e.Id_Estado\n"
                    + "INNER JOIN Ciudades cd on c.Id_Ciudad = cd.Id_Ciudad\n"
                    + "INNER JOIN Bancos b on c.Id_Banco = b.Id_Banco  WHERE c.Activo = 1 AND c.RazonSocial LIKE '" + filtro + "%'"
                    + "ORDER BY c.RazonSocial");

            rs = st.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_Cliente(rs.getInt("Id_Cliente"));
                cliente.setRazonSocial(rs.getString("RazonSocial"));
                cliente.setRFC(rs.getString("RFC"));
                cliente.setTelefono(rs.getString("Telefono"));
                cliente.setTelefono2(rs.getString("Telefono2"));
                cliente.setTelefono3(rs.getString("Telefono3"));
                cliente.setCuenta(rs.getString("Cuenta"));
                cliente.setDiasCredito(rs.getInt("DiasCredito"));
                cliente.setContacto(rs.getString("Contacto"));
                cliente.setFormaPago(rs.getString("FormaPago"));
                cliente.setMetodoPago(rs.getString("MetodoPago"));
                cliente.setCodigo(rs.getString("Codigo"));
                cliente.setColonia(rs.getString("Colonia"));
                cliente.setCalle(rs.getString("Calle"));
                cliente.setNumeroCalle(rs.getString("NumeroCalle"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setUsoCfdi(rs.getString("UsoCfdi"));
                cliente.setCP(rs.getString("CP"));
                cliente.setObservaciones(rs.getString("Observaciones"));
                cliente.setId_Agente(rs.getInt("Id_Agente"));
                cliente.setId_Zona(rs.getInt("Id_Zona"));
                cliente.setId_Pais(rs.getInt("Id_Pais"));
                cliente.setId_Estado(rs.getInt("Id_Estado"));
                cliente.setId_Ciudad(rs.getInt("Id_Ciudad"));
                cliente.setId_Banco(rs.getInt("Id_Banco"));
                cliente.setAgente(rs.getString("Agente"));
                cliente.setZona(rs.getString("Zona"));
                cliente.setPais(rs.getString("Pais"));
                cliente.setEstado(rs.getString("Estado"));
                cliente.setCiudad(rs.getString("Ciudad"));
                cliente.setBanco(rs.getString("Banco"));
                listaClientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaClientes;
    }

    public boolean clienteDelete(int Id_Cliente) {
        try {
            st = c.prepareStatement("select d.Estatus,c.Id_Cliente from RCPTPhylonA.dbo.Dpedido d\n"
                    + "inner join CobranzaPhy.dbo.Clientes c on c.Id_Cliente = d.Id_Cliente\n"
                    + "where c.Id_Cliente = ? and d.Estatus<>30");
            st.setInt(1, Id_Cliente);
            rs = st.executeQuery();
            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("UPDATE Clientes set Activo = 0 where Id_Cliente=?");
                st.setInt(1, Id_Cliente);
                st.execute();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<Cliente> clienteGetByID(int filtro) {
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            st = c.prepareStatement("SELECT  c.Id_Cliente,c.RazonSocial,c.RFC,c.Codigo,c.CP,c.Colonia,c.Calle,\n"
                    + "                    c.NumeroCalle,c.Observaciones,c.DiasCredito,cd.Descripcion as Ciudad,e.Descripcion as Estado,\n"
                    + "p.Descripcion as Pais, a.Id_Agente as Agente FROM Clientes c\n"
                    + "                    inner join Ciudades cd on c.Id_Ciudad = cd.Id_Ciudad\n"
                    + "inner join Estados e on c.Id_Estado = e.Id_Estado\n"
                    + "inner join Paises p on c.Id_Pais = p.Id_Pais\n"
                    + "inner join Agentes a on c.Id_Agente = a.Id_Agente WHERE c.Activo = 1 AND c.Id_Cliente LIKE '" + filtro + "%' ORDER BY c.RazonSocial");
            rs = st.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_Cliente(rs.getInt("Id_Cliente"));
                cliente.setRazonSocial(rs.getString("RazonSocial"));
                cliente.setRFC(rs.getString("RFC"));
                cliente.setDiasCredito(rs.getInt("DiasCredito"));
                cliente.setCodigo(rs.getString("Codigo"));
                cliente.setColonia(rs.getString("Colonia"));
                cliente.setCalle(rs.getString("Calle"));
                cliente.setNumeroCalle(rs.getString("NumeroCalle"));
                cliente.setCP(rs.getString("CP"));
                cliente.setObservaciones(rs.getString("Observaciones"));
                cliente.setCiudad(rs.getString("Ciudad"));
                cliente.setEstado(rs.getString("Estado"));
                cliente.setPais(rs.getString("Pais"));
                cliente.setId_Agente(rs.getInt("Agente"));
                listaClientes.add(cliente);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaClientes;
    }

    public boolean clienteUpdate(Cliente cliente) {
        try {
            st = c.prepareStatement("UPDATE Clientes SET RazonSocial=?, Codigo=?, Id_Ciudad = ?, RFC=?, Id_Agente=?,CP=?, Id_Zona=?,"
                    + "Colonia=?,Calle = ?,NumeroCalle=? ,Telefono=?,Telefono2 = ?, Telefono3 = ?, Id_Pais=?, Id_Estado=?, "
                    + "Cuenta =?, DiasCredito=?, Email=?,Contacto=?, Observaciones=?,UsoCfdi=?,"
                    + "FormaPago=?,MetodoPago=? ,Id_Banco=? WHERE Id_Cliente=?");

            st.setString(1, cliente.getRazonSocial());
            st.setString(2, cliente.getCodigo());
            st.setInt(3, cliente.getId_Ciudad());
            st.setString(4, cliente.getRFC());
            st.setInt(5, cliente.getId_Agente());
            st.setString(6, cliente.getCP());
            st.setInt(7, cliente.getId_Zona());
            st.setString(8, cliente.getColonia());
            st.setString(9, cliente.getCalle());
            st.setString(10, cliente.getNumeroCalle());
            st.setString(11, cliente.getTelefono());
            st.setString(12, cliente.getTelefono2());
            st.setString(13, cliente.getTelefono3());
            st.setInt(14, cliente.getId_Pais());
            st.setInt(15, cliente.getId_Estado());
            st.setString(16, cliente.getCuenta());
            st.setInt(17, cliente.getDiasCredito());
            st.setString(18, cliente.getEmail());
            st.setString(19, cliente.getContacto());
            st.setString(20, cliente.getObservaciones());
            st.setString(21, cliente.getUsoCfdi());
            st.setString(22, cliente.getFormaPago());
            st.setString(23, cliente.getMetodoPago());
            st.setInt(24, cliente.getId_Banco());
            st.setInt(25, cliente.getId_Cliente());

            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}
