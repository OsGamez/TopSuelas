package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import Plugins.ParametroCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ObjectClientes {

    Connection c = Server.getCobranza();
    Connection rc = Server.getRcobranza();
//    DB db = new DB();
//    Connection c = db.Cobranza();
//    Connection rc = db.Rcobranza();
    PreparedStatement st = null;
    Statement sta = null;
    PreparedStatement copy = null;
    ResultSet rs = null;

    public boolean clientesAdd(Cliente cliente) {
        try {
            c.setAutoCommit(false);
            String query = "INSERT INTO Clientes (NumCliente,Nombre,RazonSocial, Codigo, Id_Ciudad, RFC, Id_Agente, CP,Id_Zona, Colonia,"
                    + "Calle,NumeroCalle ,Telefono,Telefono2, Telefono3, Id_Pais, Id_Estado, Cuenta, DiasCredito, Email,"
                    + "Contacto, Observaciones,UsoCfdi, FormaPago,MetodoPago ,Id_Banco, Activo, Serie)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                st = c.prepareStatement(query);

                st.setString(1, cliente.getNumCliente());
                st.setString(2, cliente.getNombre());
                st.setString(3, cliente.getRazonSocial());
                st.setString(4, cliente.getCodigo());
                st.setInt(5, cliente.getId_Ciudad());
                st.setString(6, cliente.getRFC());
                st.setInt(7, cliente.getId_Agente());
                st.setString(8, cliente.getCP());
                st.setInt(9, cliente.getId_Zona());
                st.setString(10, cliente.getColonia());
                st.setString(11, cliente.getCalle());
                st.setString(12, cliente.getNumeroCalle());
                st.setString(13, cliente.getTelefono());
                st.setString(14, cliente.getTelefono2());
                st.setString(15, cliente.getTelefono3());
                st.setInt(16, cliente.getId_Pais());
                st.setInt(17, cliente.getId_Estado());
                st.setString(18, cliente.getCuenta());
                st.setInt(19, cliente.getDiasCredito());
                st.setString(20, cliente.getEmail());
                st.setString(21, cliente.getContacto());
                st.setString(22, cliente.getObservaciones());
                st.setString(23, cliente.getUsoCfdi());
                st.setString(24, cliente.getFormaPago());
                st.setString(25, cliente.getMetodoPago());
                st.setInt(26, cliente.getId_Banco());
                st.setBoolean(27, cliente.getActivo());
                st.setString(28, cliente.getSerie());
                st.executeUpdate();
                c.commit();
                st.close();
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                Conexion.rollback(c);
                Conexion.cerrarPrep(st);
                JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.WARNING_MESSAGE);

            }
        } catch (SQLException Sq) {
            Logger.getLogger(ObjectClientes.class.getName()).log(Level.SEVERE, null, Sq);
            JOptionPane.showMessageDialog(null, Sq, "Message", JOptionPane.WARNING_MESSAGE);
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

    public int validarCliente(String nombre, String Rz) {
        try {
            st = c.prepareStatement("SELECT COUNT (Id_Cliente) FROM Clientes WHERE (Nombre = ? AND RazonSocial=?) AND Activo = 1");
            st.setString(1, nombre);
            st.setString(2, Rz);

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
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        try {
            st = c.prepareStatement("SELECT  c.Id_Cliente,c.NumCliente,c.Nombre,c.RazonSocial,c.Codigo,c.CP,c.Colonia,c.Calle,"
                    + "c.NumeroCalle,c.UsoCfdi,c.Email,c.Observaciones,c.RFC,c.Telefono,c.Telefono2,c.Telefono3,\n"
                    + "c.Cuenta,c.DiasCredito,c.Contacto,c.FormaPago,c.MetodoPago,\n"
                    + "a.Descripcion as Agente ,z.Descripcion as Zona,p.Descripcion as Pais,\n"
                    + "e.Descripcion as Estado,cd.Descripcion as Ciudad,b.Descripcion as Banco ,c.Id_Agente, c.Id_Banco,\n"
                    + "c.Id_Ciudad, c.Id_Estado,c.Id_Pais, c.Id_Zona,c.Serie\n"
                    + "from Clientes c INNER JOIN Agentes a on c.Id_Agente = a.Id_agente\n"
                    + "INNER JOIN Zonas z on c.Id_Zona = z.Id_Zona \n"
                    + "INNER JOIN Paises p on c.Id_Pais = p.Id_Pais\n"
                    + "INNER JOIN Estados e on c.Id_Estado = e.Id_Estado\n"
                    + "INNER JOIN Ciudades cd on c.Id_Ciudad = cd.Id_Ciudad\n"
                    + "INNER JOIN Bancos b on c.Id_Banco = b.Id_Banco  WHERE c.Activo = 1 ORDER BY c.Nombre");

            rs = st.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_Cliente(rs.getInt("Id_Cliente"));
                cliente.setNumCliente(rs.getString("NumCliente"));
                cliente.setNombre(rs.getString("Nombre"));
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
                cliente.setSerie(rs.getString("Serie"));
                listaClientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaClientes;
    }

    public ArrayList<Cliente> clienteGetByNombre(String filtro) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        try {
            st = c.prepareStatement("SELECT  c.Id_Cliente,c.NumCliente,c.Nombre,c.Codigo,c.CP,c.Colonia,c.Calle,"
                    + "c.NumeroCalle,c.UsoCfdi,c.Email,c.Observaciones,c.RFC,c.Telefono,c.Telefono2,c.Telefono3,\n"
                    + "c.Cuenta,c.DiasCredito,c.Contacto,c.FormaPago,c.MetodoPago,\n"
                    + "a.Descripcion as Agente ,z.Descripcion as Zona,p.Descripcion as Pais,\n"
                    + "e.Descripcion as Estado,cd.Descripcion as Ciudad,b.Descripcion as Banco ,c.Id_Agente, c.Id_Banco,\n"
                    + "c.Id_Ciudad, c.Id_Estado,c.Id_Pais, c.Id_Zona,c.Serie\n"
                    + "from Clientes c INNER JOIN Agentes a on c.Id_Agente = a.Id_agente\n"
                    + "INNER JOIN Zonas z on c.Id_Zona = z.Id_Zona \n"
                    + "INNER JOIN Paises p on c.Id_Pais = p.Id_Pais\n"
                    + "INNER JOIN Estados e on c.Id_Estado = e.Id_Estado\n"
                    + "INNER JOIN Ciudades cd on c.Id_Ciudad = cd.Id_Ciudad\n"
                    + "INNER JOIN Bancos b on c.Id_Banco = b.Id_Banco WHERE c.Nombre LIKE'%" + filtro + "%' and c.Activo = 1 ORDER BY c.Nombre");

            rs = st.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_Cliente(rs.getInt("Id_Cliente"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setDiasCredito(rs.getInt("DiasCredito"));
                cliente.setContacto(rs.getString("Contacto"));
                cliente.setCodigo(rs.getString("Codigo"));
                cliente.setColonia(rs.getString("Colonia"));
                cliente.setCalle(rs.getString("Calle"));
                cliente.setNumeroCalle(rs.getString("NumeroCalle"));
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
                cliente.setSerie(rs.getString("Serie"));
                listaClientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaClientes;
    }

    public ArrayList<Cliente> clienteGetByRz(String filtro) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        try {
            st = c.prepareStatement("SELECT c.Id_Cliente,c.Nombre,c.RazonSocial,c.CP,c.Colonia,c.Calle,"
                    + "c.NumeroCalle,c.Observaciones,\n"
                    + "c.DiasCredito,c.Contacto,\n"
                    + "a.Descripcion as Agente ,z.Descripcion as Zona,p.Descripcion as Pais,\n"
                    + "e.Descripcion as Estado,cd.Descripcion as Ciudad,b.Descripcion as Banco ,c.Id_Agente, c.Id_Banco,\n"
                    + "c.Id_Ciudad, c.Id_Estado,c.Id_Pais, c.Id_Zona,c.Serie\n"
                    + "from Clientes c INNER JOIN Agentes a on c.Id_Agente = a.Id_agente\n"
                    + "INNER JOIN Zonas z on c.Id_Zona = z.Id_Zona \n"
                    + "INNER JOIN Paises p on c.Id_Pais = p.Id_Pais\n"
                    + "INNER JOIN Estados e on c.Id_Estado = e.Id_Estado\n"
                    + "INNER JOIN Ciudades cd on c.Id_Ciudad = cd.Id_Ciudad\n"
                    + "INNER JOIN Bancos b on c.Id_Banco = b.Id_Banco WHERE (c.Nombre LIKE'%" + filtro + "%' or c.RazonSocial LIKE'%" + filtro + "%' ) and c.Activo = 1 ORDER BY c.Nombre");

            rs = st.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
               
                cliente.setId_Cliente(rs.getInt("Id_Cliente"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setRazonSocial(rs.getString("RazonSocial"));
                cliente.setCP(rs.getString("CP"));
                cliente.setColonia(rs.getString("Colonia"));
                cliente.setCalle(rs.getString("Calle"));
                cliente.setNumeroCalle(rs.getString("NumeroCalle"));
                cliente.setObservaciones(rs.getString("Observaciones"));
                cliente.setDiasCredito(rs.getInt("DiasCredito"));
                cliente.setContacto(rs.getString("Contacto"));
                cliente.setAgente(rs.getString("Agente"));
                cliente.setZona(rs.getString("Zona"));
                cliente.setPais(rs.getString("Pais"));
                cliente.setEstado(rs.getString("Estado"));
                cliente.setCiudad(rs.getString("Ciudad"));
                cliente.setBanco(rs.getString("Banco"));
                cliente.setSerie(rs.getString("Serie"));
                cliente.setId_Agente(rs.getInt("Id_Agente"));
                cliente.setId_Zona(rs.getInt("Id_Zona"));
                cliente.setId_Pais(rs.getInt("Id_Pais"));
                cliente.setId_Estado(rs.getInt("Id_Estado"));
                cliente.setId_Ciudad(rs.getInt("Id_Ciudad"));
                cliente.setId_Banco(rs.getInt("Id_Banco"));
                
                listaClientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaClientes;
    }

    public ArrayList<Cliente> clienteSearch(String filtro) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        try {
            st = c.prepareStatement("SELECT  c.Id_Cliente,c.NumCliente,c.Nombre,c.RazonSocial,c.Codigo,c.CP,c.Colonia,c.Calle,"
                    + "c.NumeroCalle,c.UsoCfdi,c.Email,c.Observaciones,c.RFC,c.Telefono,c.Telefono2,c.Telefono3,\n"
                    + "c.Cuenta,c.DiasCredito,c.Contacto,c.FormaPago,c.MetodoPago,\n"
                    + "a.Descripcion as Agente ,z.Descripcion as Zona,p.Descripcion as Pais,\n"
                    + "e.Descripcion as Estado,cd.Descripcion as Ciudad,b.Descripcion as Banco ,c.Id_Agente, c.Id_Banco,\n"
                    + "c.Id_Ciudad, c.Id_Estado,c.Id_Pais, c.Id_Zona,c.Serie\n"
                    + "from Clientes c INNER JOIN Agentes a on c.Id_Agente = a.Id_agente\n"
                    + "INNER JOIN Zonas z on c.Id_Zona = z.Id_Zona \n"
                    + "INNER JOIN Paises p on c.Id_Pais = p.Id_Pais\n"
                    + "INNER JOIN Estados e on c.Id_Estado = e.Id_Estado\n"
                    + "INNER JOIN Ciudades cd on c.Id_Ciudad = cd.Id_Ciudad\n"
                    + "INNER JOIN Bancos b on c.Id_Banco = b.Id_Banco  WHERE c.Activo = 1 AND c.Nombre LIKE'%" + filtro + "%' OR c.RazonSocial LIKE'%" + filtro + "%' AND c.Activo = 1 ORDER BY c.Nombre");

            rs = st.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_Cliente(rs.getInt("Id_Cliente"));
                cliente.setNumCliente(rs.getString("NumCliente"));
                cliente.setNombre(rs.getString("Nombre"));
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
                cliente.setSerie(rs.getString("Serie"));
                listaClientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaClientes;
    }

    public int validarNumCliente(int Num) {
        try {
            st = c.prepareStatement("SELECT COUNT (NumCliente) FROM Clientes  WHERE NumCliente = ?");
            st.setInt(1, Num);

            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 1;
        }
    }

    public ArrayList<Cliente> getClienteById(String filtro) {
        ArrayList<Cliente> listaC = new ArrayList<Cliente>();
        try {
            String sql = "SELECT * FROM Clientes WHERE Activo = 1 AND  Nombre LIKE '%" + filtro + "%'"
                    + " ORDER BY Nombre";

            sta = c.createStatement();
            rs = sta.executeQuery(sql);

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setId_Cliente(rs.getInt("Id_Cliente"));
                cliente.setRazonSocial(rs.getString("RazonSocial"));
                cliente.setNombre(rs.getString("Nombre"));
                listaC.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaC;
    }

    public ArrayList<Cliente> getClientesR() {
        ArrayList<Cliente> listaC = new ArrayList<Cliente>();
        try {
            String sql = "SELECT  c.Id_Cliente,c.NumCliente,c.Nombre,c.RazonSocial,c.Codigo,c.CP,c.Colonia,c.Calle,"
                    + "c.NumeroCalle,c.UsoCfdi,c.Email,c.Observaciones,c.RFC,c.Telefono,c.Telefono2,c.Telefono3,\n"
                    + "c.Cuenta,c.DiasCredito,c.Contacto,c.FormaPago,c.MetodoPago,\n"
                    + "a.Descripcion as Agente ,z.Descripcion as Zona,p.Descripcion as Pais,\n"
                    + "e.Descripcion as Estado,cd.Descripcion as Ciudad,b.Descripcion as Banco ,c.Id_Agente, c.Id_Banco,\n"
                    + "c.Id_Ciudad, c.Id_Estado,c.Id_Pais, c.Id_Zona,c.Serie\n"
                    + "from Clientes c INNER JOIN Agentes a on c.Id_Agente = a.Id_agente\n"
                    + "INNER JOIN Zonas z on c.Id_Zona = z.Id_Zona \n"
                    + "INNER JOIN Paises p on c.Id_Pais = p.Id_Pais\n"
                    + "INNER JOIN Estados e on c.Id_Estado = e.Id_Estado\n"
                    + "INNER JOIN Ciudades cd on c.Id_Ciudad = cd.Id_Ciudad\n"
                    + "INNER JOIN Bancos b on c.Id_Banco = b.Id_Banco  WHERE c.Activo = 1  ORDER BY c.RazonSocial";

            sta = c.createStatement();
            rs = sta.executeQuery(sql);

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_Cliente(rs.getInt("Id_Cliente"));
                cliente.setNumCliente(rs.getString("NumCliente"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setRazonSocial(rs.getString("RazonSocial"));
                cliente.setRFC(rs.getString("RFC"));
                cliente.setTelefono(rs.getString("Telefono"));
                cliente.setCuenta(rs.getString("Cuenta"));
                cliente.setDiasCredito(rs.getInt("DiasCredito"));
                cliente.setContacto(rs.getString("Contacto"));
                cliente.setFormaPago(rs.getString("FormaPago"));
                cliente.setMetodoPago(rs.getString("MetodoPago"));
                cliente.setCodigo(rs.getString("Codigo"));
                cliente.setColonia(rs.getString("Colonia"));
                cliente.setCalle(rs.getString("Calle"));
                cliente.setNumeroCalle(rs.getString("NumeroCalle"));
                cliente.setUsoCfdi(rs.getString("UsoCfdi"));
                cliente.setCP(rs.getString("CP"));
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
                cliente.setSerie(rs.getString("Serie"));
                listaC.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaC;
    }

    public ArrayList<Cliente> getNumCli() {
        ArrayList<Cliente> listaP = new ArrayList<Cliente>();
        try {
            st = c.prepareStatement("SELECT  MAX(CONVERT(INT,NumCliente)) as NumCliente FROM Clientes");
            rs = st.executeQuery();

            while (rs.next()) {
                int Num = rs.getInt("NumCliente");
                Cliente par = new Cliente();
                par.setNumCliente(String.valueOf(Num));
                listaP.add(par);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaP;
    }

    public boolean clienteDelete(int Id_Cliente) {
        try {
            c.setAutoCommit(false);
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
                c.commit();
                st.close();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.rollback(c);
            Conexion.cerrarPrep(st);
            return false;
        }
    }

    public boolean anularCliente(String Num) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("DELETE FROM Clientes WHERE NumCliente = ?");
            st.setString(1, Num);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Conexion.rollback(c);
            Conexion.cerrarPrep(st);
        }
        return false;
    }

    public ArrayList<Cliente> clienteGetByID(int filtro) {
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            st = c.prepareStatement("SELECT  c.Id_Cliente,c.RazonSocial,c.Nombre,c.RFC,c.Codigo,c.CP,c.Colonia,c.Calle,\n"
                    + "c.NumeroCalle,c.Observaciones,c.DiasCredito,cd.Descripcion as Ciudad,e.Descripcion as Estado,\n"
                    + "p.Descripcion as Pais, a.Id_Agente as Agente FROM Clientes c\n"
                    + "inner join Ciudades cd on c.Id_Ciudad = cd.Id_Ciudad\n"
                    + "inner join Estados e on c.Id_Estado = e.Id_Estado\n"
                    + "inner join Paises p on c.Id_Pais = p.Id_Pais\n"
                    + "inner join Agentes a on c.Id_Agente = a.Id_Agente WHERE c.Activo = 1 AND c.Id_Cliente = " + filtro + " ORDER BY c.Nombre");
            rs = st.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_Cliente(rs.getInt("Id_Cliente"));
                cliente.setNombre(rs.getString("Nombre"));
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

    public ArrayList<Cliente> clienteGetByIDR(int filtro) {
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
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE Clientes SET Nombre = ?, RazonSocial=?, Codigo=?, Id_Ciudad = ?, RFC=?, Id_Agente=?,CP=?, Id_Zona=?,"
                    + "Colonia=?,Calle = ?,NumeroCalle=? ,Telefono=?,Telefono2 = ?, Telefono3 = ?, Id_Pais=?, Id_Estado=?, "
                    + "Cuenta =?, DiasCredito=?, Email=?,Contacto=?, Observaciones=?,UsoCfdi=?,"
                    + "FormaPago=?,MetodoPago=? ,Id_Banco=? WHERE Id_Cliente=?");
            st.setString(1, cliente.getNombre());
            st.setString(2, cliente.getRazonSocial());
            st.setString(3, cliente.getCodigo());
            st.setInt(4, cliente.getId_Ciudad());
            st.setString(5, cliente.getRFC());
            st.setInt(6, cliente.getId_Agente());
            st.setString(7, cliente.getCP());
            st.setInt(8, cliente.getId_Zona());
            st.setString(9, cliente.getColonia());
            st.setString(10, cliente.getCalle());
            st.setString(11, cliente.getNumeroCalle());
            st.setString(12, cliente.getTelefono());
            st.setString(13, cliente.getTelefono2());
            st.setString(14, cliente.getTelefono3());
            st.setInt(15, cliente.getId_Pais());
            st.setInt(16, cliente.getId_Estado());
            st.setString(17, cliente.getCuenta());
            st.setInt(18, cliente.getDiasCredito());
            st.setString(19, cliente.getEmail());
            st.setString(20, cliente.getContacto());
            st.setString(21, cliente.getObservaciones());
            st.setString(22, cliente.getUsoCfdi());
            st.setString(23, cliente.getFormaPago());
            st.setString(24, cliente.getMetodoPago());
            st.setInt(25, cliente.getId_Banco());
            st.setInt(26, cliente.getId_Cliente());

            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.WARNING_MESSAGE);
            Conexion.cerrarPrep(st);
        } 
        return false;
    }

}
