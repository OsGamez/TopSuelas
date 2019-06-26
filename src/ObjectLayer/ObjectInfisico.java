package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ObjectInfisico {

    PreparedStatement st = null;
//    Connection c = Server.getRcpt();
//    Connection server = Server.gettempphy();
    DB db = new DB();
    Connection c = db.RCPTPhylonA();
    Connection server = db.tempphy();
    ResultSet rs = null;

    public boolean AddInventarioCopy(Infisico inv) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("INSERT INTO InCopy(Almacen,Producto,Estilo,Corrida,Combinacion,Tipo,Pto1,"
                    + "Pto2,Pto3,Pto4,Pto5,Pto6,Pto7,Pto8,Pto9,Pto10,Pto11,Pto12,Pto13,Pto14,TotalPares)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, inv.getAlmacen());
            st.setInt(2, inv.getProducto());
            st.setInt(3, inv.getEstilo());
            st.setInt(4, inv.getCorrida());
            st.setInt(5, inv.getCombinacion());
            st.setString(6, inv.getTipo());
            st.setInt(7, inv.getPto1());
            st.setInt(8, inv.getPto2());
            st.setInt(9, inv.getPto3());
            st.setInt(10, inv.getPto4());
            st.setInt(11, inv.getPto5());
            st.setInt(12, inv.getPto6());
            st.setInt(13, inv.getPto7());
            st.setInt(14, inv.getPto8());
            st.setInt(15, inv.getPto9());
            st.setInt(16, inv.getPto10());
            st.setInt(17, inv.getPto11());
            st.setInt(18, inv.getPto12());
            st.setInt(19, inv.getPto13());
            st.setInt(20, inv.getPto14());
            st.setInt(21, inv.getTotalPares());
            st.execute();
            c.commit();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean AddInventarioCopyN(Infisico inv) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("INSERT INTO InCopyN(Almacen,Producto,Estilo,Corrida,Combinacion,Tipo,Pto1,"
                    + "Pto2,Pto3,Pto4,Pto5,Pto6,Pto7,Pto8,Pto9,Pto10,Pto11,Pto12,Pto13,Pto14,TotalPares)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, inv.getAlmacen());
            st.setInt(2, inv.getProducto());
            st.setInt(3, inv.getEstilo());
            st.setInt(4, inv.getCorrida());
            st.setInt(5, inv.getCombinacion());
            st.setString(6, inv.getTipo());
            st.setInt(7, inv.getPto1());
            st.setInt(8, inv.getPto2());
            st.setInt(9, inv.getPto3());
            st.setInt(10, inv.getPto4());
            st.setInt(11, inv.getPto5());
            st.setInt(12, inv.getPto6());
            st.setInt(13, inv.getPto7());
            st.setInt(14, inv.getPto8());
            st.setInt(15, inv.getPto9());
            st.setInt(16, inv.getPto10());
            st.setInt(17, inv.getPto11());
            st.setInt(18, inv.getPto12());
            st.setInt(19, inv.getPto13());
            st.setInt(20, inv.getPto14());
            st.setInt(21, inv.getTotalPares());
            st.execute();
            c.commit();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean AddInventarioCopyK(Infisico inv) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("INSERT INTO InCopyK(Almacen,Producto,Estilo,Corrida,Combinacion,Tipo,Pto1,"
                    + "Pto2,Pto3,Pto4,Pto5,Pto6,Pto7,Pto8,Pto9,Pto10,Pto11,Pto12,Pto13,Pto14,TotalPares)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, inv.getAlmacen());
            st.setInt(2, inv.getProducto());
            st.setInt(3, inv.getEstilo());
            st.setInt(4, inv.getCorrida());
            st.setInt(5, inv.getCombinacion());
            st.setString(6, inv.getTipo());
            st.setInt(7, inv.getPto1());
            st.setInt(8, inv.getPto2());
            st.setInt(9, inv.getPto3());
            st.setInt(10, inv.getPto4());
            st.setInt(11, inv.getPto5());
            st.setInt(12, inv.getPto6());
            st.setInt(13, inv.getPto7());
            st.setInt(14, inv.getPto8());
            st.setInt(15, inv.getPto9());
            st.setInt(16, inv.getPto10());
            st.setInt(17, inv.getPto11());
            st.setInt(18, inv.getPto12());
            st.setInt(19, inv.getPto13());
            st.setInt(20, inv.getPto14());
            st.setInt(21, inv.getTotalPares());
            st.execute();
            c.commit();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean AddInventarioCopyA(Infisico inv) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("INSERT INTO InCopyA(Almacen,Producto,Estilo,Corrida,Combinacion,Tipo,Pto1,"
                    + "Pto2,Pto3,Pto4,Pto5,Pto6,Pto7,Pto8,Pto9,Pto10,Pto11,Pto12,Pto13,Pto14,TotalPares)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, inv.getAlmacen());
            st.setInt(2, inv.getProducto());
            st.setInt(3, inv.getEstilo());
            st.setInt(4, inv.getCorrida());
            st.setInt(5, inv.getCombinacion());
            st.setString(6, inv.getTipo());
            st.setInt(7, inv.getPto1());
            st.setInt(8, inv.getPto2());
            st.setInt(9, inv.getPto3());
            st.setInt(10, inv.getPto4());
            st.setInt(11, inv.getPto5());
            st.setInt(12, inv.getPto6());
            st.setInt(13, inv.getPto7());
            st.setInt(14, inv.getPto8());
            st.setInt(15, inv.getPto9());
            st.setInt(16, inv.getPto10());
            st.setInt(17, inv.getPto11());
            st.setInt(18, inv.getPto12());
            st.setInt(19, inv.getPto13());
            st.setInt(20, inv.getPto14());
            st.setInt(21, inv.getTotalPares());
            st.execute();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean AddInventario(Infisico inv) {
        try {
            server.setAutoCommit(false);
            st = server.prepareStatement("INSERT INTO InvFisico(Almacen,Producto,Estilo,corrida,Combinacion,Tipo,Punto1,"
                    + "Punto2,Punto3,Punto4,Punto5,Punto6,Punto7,Punto8,Punto9,Punto10,Punto11,Punto12,Punto13,Punto14,TotalPares)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, inv.getAlmacen());
            st.setInt(2, inv.getProducto());
            st.setInt(3, inv.getEstilo());
            st.setInt(4, inv.getCorrida());
            st.setInt(5, inv.getCombinacion());
            st.setString(6, inv.getTipo());
            st.setInt(7, inv.getPto1());
            st.setInt(8, inv.getPto2());
            st.setInt(9, inv.getPto3());
            st.setInt(10, inv.getPto4());
            st.setInt(11, inv.getPto5());
            st.setInt(12, inv.getPto6());
            st.setInt(13, inv.getPto7());
            st.setInt(14, inv.getPto8());
            st.setInt(15, inv.getPto9());
            st.setInt(16, inv.getPto10());
            st.setInt(17, inv.getPto11());
            st.setInt(18, inv.getPto12());
            st.setInt(19, inv.getPto13());
            st.setInt(20, inv.getPto14());
            st.setInt(21, inv.getTotalPares());
            st.execute();
            server.commit();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteDatos() {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("DELETE FROM InCopy");
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteDatosN() {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("DELETE FROM InCopyN");
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteDatosK() {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("DELETE FROM InCopyK");
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteDatosA() {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("DELETE FROM InCopyA");
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int validarInv(String nombre) {
        try {
            st = c.prepareStatement("select count(*) from " + nombre);
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

    public int validarInvN() {
        try {
            st = c.prepareStatement("select count(*) from InCopyN");
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

    public int validarInvK() {
        try {
            st = c.prepareStatement("select count(*) from InCopyK");
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

    public int validarInvA() {
        try {
            st = c.prepareStatement("select count(*) from InCopyA");
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

    public ArrayList<Infisico> validarAlmacen(String id) {
        ArrayList<Infisico> listaAlmacen = new ArrayList<Infisico>();
        try {
            st = c.prepareStatement("SELECT * FROM InvFisico where Almacen = ?");
            st.setString(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                Infisico inv = new Infisico();
                inv.setAlmacen(rs.getInt("Almacen"));
                listaAlmacen.add(inv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaAlmacen;
    }

    public ArrayList<Infisico> InvGetAll() {
        ArrayList<Infisico> listaInv = new ArrayList<Infisico>();
        try {
            st = c.prepareStatement("SELECT Producto, Almacen, Estilo, Corrida, Combinacion,Tipo,\n"
                    + "sum(Pto1) as Pto1,sum(Pto2) as Pto2,sum(Pto3) as Pto3,sum(Pto4) as Pto4,sum(Pto5) as Pto5,sum(Pto6) as Pto6,sum(Pto7) as Pto7,\n"
                    + "sum(Pto8) as Pto8,sum(Pto9) as Pto9,sum(Pto10) as Pto10,sum(Pto11) as Pto11,sum(Pto12) as Pto12,sum(Pto13) as Pto13,\n"
                    + "sum(Pto14) as Pto14,sum(TotalPares) as TotalPares FROM group by Producto,Almacen,Estilo,Corrida,Combinacion,Tipo\n"
                    + "order by Producto");
            rs = st.executeQuery();
            while (rs.next()) {
                Infisico inv = new Infisico();
                inv.setProducto(rs.getInt("Producto"));
                inv.setAlmacen(rs.getInt("Almacen"));
                inv.setEstilo(rs.getInt("Estilo"));
                inv.setCorrida(rs.getInt("Corrida"));
                inv.setCombinacion(rs.getInt("Combinacion"));
                inv.setTipo(rs.getString("Tipo"));
                inv.setPto1(rs.getInt("Pto1"));
                inv.setPto2(rs.getInt("Pto2"));
                inv.setPto3(rs.getInt("Pto3"));
                inv.setPto4(rs.getInt("Pto4"));
                inv.setPto5(rs.getInt("Pto5"));
                inv.setPto6(rs.getInt("Pto6"));
                inv.setPto7(rs.getInt("Pto7"));
                inv.setPto8(rs.getInt("Pto8"));
                inv.setPto9(rs.getInt("Pto9"));
                inv.setPto10(rs.getInt("Pto10"));
                inv.setPto11(rs.getInt("Pto11"));
                inv.setPto12(rs.getInt("Pto12"));
                inv.setPto13(rs.getInt("Pto13"));
                inv.setPto14(rs.getInt("Pto14"));
                inv.setTotalPares(rs.getInt("TotalPares"));
                listaInv.add(inv);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listaInv;
    }

    public ArrayList<Infisico> InvGetAllN() {
        ArrayList<Infisico> listaInv = new ArrayList<Infisico>();
        try {
            st = c.prepareStatement("SELECT Producto, Almacen, Estilo, Corrida, Combinacion,Tipo,\n"
                    + "sum(Pto1) as Pto1,sum(Pto2) as Pto2,sum(Pto3) as Pto3,sum(Pto4) as Pto4,sum(Pto5) as Pto5,sum(Pto6) as Pto6,sum(Pto7) as Pto7,\n"
                    + "sum(Pto8) as Pto8,sum(Pto9) as Pto9,sum(Pto10) as Pto10,sum(Pto11) as Pto11,sum(Pto12) as Pto12,sum(Pto13) as Pto13,\n"
                    + "sum(Pto14) as Pto14,sum(TotalPares) as TotalPares\n"
                    + "\n"
                    + "FROM InCopy\n"
                    + "group by Producto,Almacen,Estilo,Corrida,Combinacion,Tipo\n"
                    + "order by Producto");
            rs = st.executeQuery();
            while (rs.next()) {
                Infisico inv = new Infisico();
                inv.setProducto(rs.getInt("Producto"));
                inv.setAlmacen(rs.getInt("Almacen"));
                inv.setEstilo(rs.getInt("Estilo"));
                inv.setCorrida(rs.getInt("Corrida"));
                inv.setCombinacion(rs.getInt("Combinacion"));
                inv.setTipo(rs.getString("Tipo"));
                inv.setPto1(rs.getInt("Pto1"));
                inv.setPto2(rs.getInt("Pto2"));
                inv.setPto3(rs.getInt("Pto3"));
                inv.setPto4(rs.getInt("Pto4"));
                inv.setPto5(rs.getInt("Pto5"));
                inv.setPto6(rs.getInt("Pto6"));
                inv.setPto7(rs.getInt("Pto7"));
                inv.setPto8(rs.getInt("Pto8"));
                inv.setPto9(rs.getInt("Pto9"));
                inv.setPto10(rs.getInt("Pto10"));
                inv.setPto11(rs.getInt("Pto11"));
                inv.setPto12(rs.getInt("Pto12"));
                inv.setPto13(rs.getInt("Pto13"));
                inv.setPto14(rs.getInt("Pto14"));
                inv.setTotalPares(rs.getInt("TotalPares"));
                listaInv.add(inv);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listaInv;
    }

    public ArrayList<Infisico> InvGetAllK() {
        ArrayList<Infisico> listaInv = new ArrayList<Infisico>();
        try {
            st = c.prepareStatement("SELECT Producto, Almacen, Estilo, Corrida, Combinacion,Tipo,\n"
                    + "sum(Pto1) as Pto1,sum(Pto2) as Pto2,sum(Pto3) as Pto3,sum(Pto4) as Pto4,sum(Pto5) as Pto5,sum(Pto6) as Pto6,sum(Pto7) as Pto7,\n"
                    + "sum(Pto8) as Pto8,sum(Pto9) as Pto9,sum(Pto10) as Pto10,sum(Pto11) as Pto11,sum(Pto12) as Pto12,sum(Pto13) as Pto13,\n"
                    + "sum(Pto14) as Pto14,sum(TotalPares) as TotalPares\n"
                    + "\n"
                    + "FROM InCopy\n"
                    + "group by Producto,Almacen,Estilo,Corrida,Combinacion,Tipo\n"
                    + "order by Producto");
            rs = st.executeQuery();
            while (rs.next()) {
                Infisico inv = new Infisico();
                inv.setProducto(rs.getInt("Producto"));
                inv.setAlmacen(rs.getInt("Almacen"));
                inv.setEstilo(rs.getInt("Estilo"));
                inv.setCorrida(rs.getInt("Corrida"));
                inv.setCombinacion(rs.getInt("Combinacion"));
                inv.setTipo(rs.getString("Tipo"));
                inv.setPto1(rs.getInt("Pto1"));
                inv.setPto2(rs.getInt("Pto2"));
                inv.setPto3(rs.getInt("Pto3"));
                inv.setPto4(rs.getInt("Pto4"));
                inv.setPto5(rs.getInt("Pto5"));
                inv.setPto6(rs.getInt("Pto6"));
                inv.setPto7(rs.getInt("Pto7"));
                inv.setPto8(rs.getInt("Pto8"));
                inv.setPto9(rs.getInt("Pto9"));
                inv.setPto10(rs.getInt("Pto10"));
                inv.setPto11(rs.getInt("Pto11"));
                inv.setPto12(rs.getInt("Pto12"));
                inv.setPto13(rs.getInt("Pto13"));
                inv.setPto14(rs.getInt("Pto14"));
                inv.setTotalPares(rs.getInt("TotalPares"));
                listaInv.add(inv);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listaInv;
    }

    public ArrayList<Infisico> InvGetAllA() {
        ArrayList<Infisico> listaInv = new ArrayList<Infisico>();
        try {
            st = c.prepareStatement("SELECT Producto, Almacen, Estilo, Corrida, Combinacion,Tipo,\n"
                    + "sum(Pto1) as Pto1,sum(Pto2) as Pto2,sum(Pto3) as Pto3,sum(Pto4) as Pto4,sum(Pto5) as Pto5,sum(Pto6) as Pto6,sum(Pto7) as Pto7,\n"
                    + "sum(Pto8) as Pto8,sum(Pto9) as Pto9,sum(Pto10) as Pto10,sum(Pto11) as Pto11,sum(Pto12) as Pto12,sum(Pto13) as Pto13,\n"
                    + "sum(Pto14) as Pto14,sum(TotalPares) as TotalPares\n"
                    + "\n"
                    + "FROM InCopy\n"
                    + "group by Producto,Almacen,Estilo,Corrida,Combinacion,Tipo\n"
                    + "order by Producto");
            rs = st.executeQuery();
            while (rs.next()) {
                Infisico inv = new Infisico();
                inv.setProducto(rs.getInt("Producto"));
                inv.setAlmacen(rs.getInt("Almacen"));
                inv.setEstilo(rs.getInt("Estilo"));
                inv.setCorrida(rs.getInt("Corrida"));
                inv.setCombinacion(rs.getInt("Combinacion"));
                inv.setTipo(rs.getString("Tipo"));
                inv.setPto1(rs.getInt("Pto1"));
                inv.setPto2(rs.getInt("Pto2"));
                inv.setPto3(rs.getInt("Pto3"));
                inv.setPto4(rs.getInt("Pto4"));
                inv.setPto5(rs.getInt("Pto5"));
                inv.setPto6(rs.getInt("Pto6"));
                inv.setPto7(rs.getInt("Pto7"));
                inv.setPto8(rs.getInt("Pto8"));
                inv.setPto9(rs.getInt("Pto9"));
                inv.setPto10(rs.getInt("Pto10"));
                inv.setPto11(rs.getInt("Pto11"));
                inv.setPto12(rs.getInt("Pto12"));
                inv.setPto13(rs.getInt("Pto13"));
                inv.setPto14(rs.getInt("Pto14"));
                inv.setTotalPares(rs.getInt("TotalPares"));
                listaInv.add(inv);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listaInv;
    }

    public boolean CrearTb(String nombre) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("CREATE TABLE " + nombre + "(\n"
                    + "	[Almacen] [tinyint] NOT NULL,\n"
                    + "	[Producto] [smallint] NOT NULL,\n"
                    + "	[Estilo] [smallint] NULL,\n"
                    + "	[Corrida] [tinyint] NULL,\n"
                    + "	[Combinacion] [smallint] NULL,\n"
                    + "	[Tipo] [char](1) NOT NULL,\n"
                    + "	[Pto1] [int] NOT NULL,\n"
                    + "	[Pto2] [int] NOT NULL,\n"
                    + "	[Pto3] [int] NOT NULL,\n"
                    + "	[Pto4] [int] NOT NULL,\n"
                    + "	[Pto5] [int] NOT NULL,\n"
                    + "	[Pto6] [int] NOT NULL,\n"
                    + "	[Pto7] [int] NOT NULL,\n"
                    + "	[Pto8] [int] NOT NULL,\n"
                    + "	[Pto9] [int] NOT NULL,\n"
                    + "	[Pto10] [int] NOT NULL,\n"
                    + "	[Pto11] [int] NOT NULL,\n"
                    + "	[Pto12] [int] NOT NULL,\n"
                    + "	[Pto13] [int] NOT NULL,\n"
                    + "	[Pto14] [int] NOT NULL,\n"
                    + "	[TotalPares] [int] NOT NULL\n"
                    + ") ON [PRIMARY]");
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int VerificarTabla(String nombre) {
        try {
            st = c.prepareStatement("SELECT COUNT(*) FROM sysobjects  WHERE type = 'U' AND name = '"+nombre+"'");
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
             return 1;
        }
    }
    
    public boolean AddTemporal(Infisico inv, String nombre) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("INSERT INTO "+ nombre + " (Almacen,Producto,Estilo,Corrida,Combinacion,Tipo,Pto1,"
                    + "Pto2,Pto3,Pto4,Pto5,Pto6,Pto7,Pto8,Pto9,Pto10,Pto11,Pto12,Pto13,Pto14,TotalPares)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, inv.getAlmacen());
            st.setInt(2, inv.getProducto());
            st.setInt(3, inv.getEstilo());
            st.setInt(4, inv.getCorrida());
            st.setInt(5, inv.getCombinacion());
            st.setString(6, inv.getTipo());
            st.setInt(7, inv.getPto1());
            st.setInt(8, inv.getPto2());
            st.setInt(9, inv.getPto3());
            st.setInt(10, inv.getPto4());
            st.setInt(11, inv.getPto5());
            st.setInt(12, inv.getPto6());
            st.setInt(13, inv.getPto7());
            st.setInt(14, inv.getPto8());
            st.setInt(15, inv.getPto9());
            st.setInt(16, inv.getPto10());
            st.setInt(17, inv.getPto11());
            st.setInt(18, inv.getPto12());
            st.setInt(19, inv.getPto13());
            st.setInt(20, inv.getPto14());
            st.setInt(21, inv.getTotalPares());
            st.execute();
            c.commit();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteTemp(String nombre) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("DELETE FROM "+nombre);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean dropTable(String nombre){
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("DROP TABLE "+ nombre);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<Infisico> InvGetTemp(String nombre) {
        ArrayList<Infisico> listaInv = new ArrayList<Infisico>();
        try {
            st = c.prepareStatement("SELECT Producto, Almacen, Estilo, Corrida, Combinacion,Tipo,\n"
                    + "sum(Pto1) as Pto1,sum(Pto2) as Pto2,sum(Pto3) as Pto3,sum(Pto4) as Pto4,sum(Pto5) as Pto5,sum(Pto6) as Pto6,sum(Pto7) as Pto7,\n"
                    + "sum(Pto8) as Pto8,sum(Pto9) as Pto9,sum(Pto10) as Pto10,sum(Pto11) as Pto11,sum(Pto12) as Pto12,sum(Pto13) as Pto13,\n"
                    + "sum(Pto14) as Pto14,sum(TotalPares) as TotalPares\n"
                    + "FROM "+ nombre + " group by Producto,Almacen,Estilo,Corrida,Combinacion,Tipo\n"
                    + "order by Producto");
            rs = st.executeQuery();
            while (rs.next()) {
                Infisico inv = new Infisico();
                inv.setProducto(rs.getInt("Producto"));
                inv.setAlmacen(rs.getInt("Almacen"));
                inv.setEstilo(rs.getInt("Estilo"));
                inv.setCorrida(rs.getInt("Corrida"));
                inv.setCombinacion(rs.getInt("Combinacion"));
                inv.setTipo(rs.getString("Tipo"));
                inv.setPto1(rs.getInt("Pto1"));
                inv.setPto2(rs.getInt("Pto2"));
                inv.setPto3(rs.getInt("Pto3"));
                inv.setPto4(rs.getInt("Pto4"));
                inv.setPto5(rs.getInt("Pto5"));
                inv.setPto6(rs.getInt("Pto6"));
                inv.setPto7(rs.getInt("Pto7"));
                inv.setPto8(rs.getInt("Pto8"));
                inv.setPto9(rs.getInt("Pto9"));
                inv.setPto10(rs.getInt("Pto10"));
                inv.setPto11(rs.getInt("Pto11"));
                inv.setPto12(rs.getInt("Pto12"));
                inv.setPto13(rs.getInt("Pto13"));
                inv.setPto14(rs.getInt("Pto14"));
                inv.setTotalPares(rs.getInt("TotalPares"));
                listaInv.add(inv);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listaInv;
    }

}
