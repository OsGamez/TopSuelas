package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ObjectInfisico {

    PreparedStatement st = null;
    Connection c = Server.getRcpt();
    Connection server = Server.getServer();
    ResultSet rs = null;

    public boolean AddInventarioCopy(Infisico inv) {
        try {
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
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
     public boolean AddInventarioCopyN(Infisico inv) {
        try {
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
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
     
     public boolean AddInventarioCopyK(Infisico inv) {
        try {
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
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean AddInventario(Infisico inv) {
        try {
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
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteDatos() {
        try {
            st = c.prepareStatement("DELETE FROM InCopy");
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteDatosN() {
        try {
            st = c.prepareStatement("DELETE FROM InCopyN");
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteDatosK() {
        try {
            st = c.prepareStatement("DELETE FROM InCopyK");
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int validarInv() {
        try {
            st = c.prepareStatement("select count(*) from InCopy");
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
            st = c.prepareStatement("SELECT Producto, Almacen, Estilo, Corrida, Combinacion,Tipo,\n" +
"\n" +
"CASE WHEN Corrida = '80' THEN sum(Pto1) WHEN Corrida = '85' THEN sum(Pto1)\n" +
"	WHEN Corrida = '89' THEN sum(Pto1) WHEN Corrida = '81' THEN sum(Pto1)\n" +
"	WHEN Corrida = '90' THEN sum(Pto1) WHEN Corrida = '97' THEN sum(Pto1)\n" +
"	WHEN Corrida = '91' THEN sum(Pto1) WHEN Corrida = '95' THEN sum(Pto1)\n" +
"	WHEN Corrida = '92' THEN sum(Pto1) WHEN Corrida = '93' THEN sum(Pto1)\n" +
"	WHEN Corrida = '88' THEN sum(Pto1) WHEN Corrida = '98' THEN sum(Pto1)\n" +
"	WHEN Corrida = '94' THEN sum(Pto1) WHEN Corrida = '82' THEN sum(Pto1)\n" +
"	WHEN Corrida = '96' THEN sum(Pto1) END AS Pto1,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto2) WHEN Corrida = '81' THEN sum(Pto2)\n" +
"	WHEN Corrida = '90' THEN sum(Pto2) WHEN Corrida = '97' THEN sum(Pto2)\n" +
"	WHEN Corrida = '91' THEN sum(Pto2) WHEN Corrida = '95' THEN sum(Pto2)\n" +
"	WHEN Corrida = '92' THEN sum(Pto2) WHEN Corrida = '93' THEN sum(Pto2)\n" +
"	WHEN Corrida = '88' THEN sum(Pto2) WHEN Corrida = '98' THEN sum(Pto2)\n" +
"	WHEN Corrida = '94' THEN sum(Pto2) WHEN Corrida = '82' THEN sum(Pto2)\n" +
"	WHEN Corrida = '96' THEN sum(Pto2) END AS Pto2,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto3) WHEN Corrida = '81' THEN sum(Pto3)\n" +
"	WHEN Corrida = '90' THEN sum(Pto3) WHEN Corrida = '97' THEN sum(Pto3)\n" +
"	WHEN Corrida = '91' THEN sum(Pto3) WHEN Corrida = '95' THEN sum(Pto3)\n" +
"	WHEN Corrida = '92' THEN sum(Pto3) WHEN Corrida = '93' THEN sum(Pto3)\n" +
"	WHEN Corrida = '88' THEN sum(Pto3) WHEN Corrida = '98' THEN sum(Pto3)\n" +
"	WHEN Corrida = '94' THEN sum(Pto3) WHEN Corrida = '82' THEN sum(Pto3)\n" +
"	WHEN Corrida = '96' THEN sum(Pto3) END AS Pto3,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto4) WHEN Corrida = '81' THEN sum(Pto4)\n" +
"	WHEN Corrida = '90' THEN sum(Pto4) WHEN Corrida = '97' THEN sum(Pto4)\n" +
"	WHEN Corrida = '91' THEN sum(Pto4) WHEN Corrida = '95' THEN sum(Pto4)\n" +
"	WHEN Corrida = '92' THEN sum(Pto4) WHEN Corrida = '93' THEN sum(Pto4)\n" +
"	WHEN Corrida = '88' THEN sum(Pto4) WHEN Corrida = '98' THEN sum(Pto4)\n" +
"	WHEN Corrida = '94' THEN sum(Pto4) WHEN Corrida = '82' THEN sum(Pto4)\n" +
"	WHEN Corrida = '96' THEN sum(Pto4) END AS Pto4,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto5) WHEN Corrida = '81' THEN sum(Pto5)\n" +
"	WHEN Corrida = '90' THEN sum(Pto5) WHEN Corrida = '97' THEN sum(Pto5)\n" +
"	WHEN Corrida = '91' THEN sum(Pto5) WHEN Corrida = '95' THEN sum(Pto5)\n" +
"	WHEN Corrida = '92' THEN sum(Pto5) WHEN Corrida = '93' THEN sum(Pto5)\n" +
"	WHEN Corrida = '88' THEN sum(Pto5) WHEN Corrida = '98' THEN sum(Pto5)\n" +
"	WHEN Corrida = '94' THEN sum(Pto5) WHEN Corrida = '82' THEN sum(Pto5)\n" +
"	WHEN Corrida = '96' THEN sum(Pto5) END AS Pto5,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto6) WHEN Corrida = '81' THEN sum(Pto6)\n" +
"	WHEN Corrida = '90' THEN sum(Pto6) WHEN Corrida = '97' THEN sum(Pto6)\n" +
"	WHEN Corrida = '91' THEN sum(Pto6) WHEN Corrida = '95' THEN sum(Pto6)\n" +
"	WHEN Corrida = '92' THEN sum(Pto6) WHEN Corrida = '93' THEN sum(Pto6)\n" +
"	WHEN Corrida = '88' THEN sum(Pto6) WHEN Corrida = '98' THEN sum(Pto6)\n" +
"	WHEN Corrida = '94' THEN sum(Pto6) WHEN Corrida = '82' THEN sum(Pto6)\n" +
"	WHEN Corrida = '96' THEN sum(Pto6) END AS Pto6,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto7) WHEN Corrida = '81' THEN sum(Pto7)\n" +
"	WHEN Corrida = '90' THEN sum(Pto7) WHEN Corrida = '97' THEN sum(Pto7)\n" +
"	WHEN Corrida = '91' THEN sum(Pto7) WHEN Corrida = '95' THEN sum(Pto7)\n" +
"	WHEN Corrida = '92' THEN sum(Pto7) WHEN Corrida = '93' THEN sum(Pto7)\n" +
"	WHEN Corrida = '88' THEN sum(Pto7) WHEN Corrida = '98' THEN sum(Pto7)\n" +
"	WHEN Corrida = '94' THEN sum(Pto7) WHEN Corrida = '82' THEN sum(Pto7)\n" +
"	WHEN Corrida = '96' THEN sum(Pto7) END AS Pto7,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto8) WHEN Corrida = '81' THEN sum(Pto8)\n" +
"	WHEN Corrida = '90' THEN sum(Pto8) WHEN Corrida = '97' THEN sum(Pto8)\n" +
"	WHEN Corrida = '91' THEN sum(Pto8) WHEN Corrida = '95' THEN sum(Pto8)\n" +
"	WHEN Corrida = '92' THEN sum(Pto8) WHEN Corrida = '93' THEN sum(Pto8)\n" +
"	WHEN Corrida = '88' THEN sum(Pto8) WHEN Corrida = '98' THEN sum(Pto8)\n" +
"	WHEN Corrida = '94' THEN sum(Pto8) WHEN Corrida = '82' THEN sum(Pto8)\n" +
"	WHEN Corrida = '96' THEN sum(Pto8) END AS Pto8,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto9) WHEN Corrida = '81' THEN sum(Pto9)\n" +
"	WHEN Corrida = '90' THEN sum(Pto9) WHEN Corrida = '97' THEN sum(Pto9)\n" +
"	WHEN Corrida = '91' THEN sum(Pto9) WHEN Corrida = '95' THEN sum(Pto9)\n" +
"	WHEN Corrida = '92' THEN sum(Pto9) WHEN Corrida = '93' THEN sum(Pto9)\n" +
"	WHEN Corrida = '88' THEN sum(Pto9) WHEN Corrida = '98' THEN sum(Pto9)\n" +
"	WHEN Corrida = '94' THEN sum(Pto9) WHEN Corrida = '82' THEN sum(Pto9)\n" +
"	WHEN Corrida = '96' THEN sum(Pto9) END AS Pto9,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto10) WHEN Corrida = '81' THEN sum(Pto10)\n" +
"	WHEN Corrida = '90' THEN sum(Pto10) WHEN Corrida = '97' THEN sum(Pto10)\n" +
"	WHEN Corrida = '91' THEN sum(Pto10) WHEN Corrida = '95' THEN sum(Pto10)\n" +
"	WHEN Corrida = '92' THEN sum(Pto10) WHEN Corrida = '93' THEN sum(Pto10)\n" +
"	WHEN Corrida = '88' THEN sum(Pto10) WHEN Corrida = '98' THEN sum(Pto10)\n" +
"	WHEN Corrida = '94' THEN sum(Pto10) WHEN Corrida = '82' THEN sum(Pto10)\n" +
"	WHEN Corrida = '96' THEN sum(Pto10) END AS Pto10,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto11) WHEN Corrida = '81' THEN sum(Pto11)\n" +
"	WHEN Corrida = '90' THEN sum(Pto11) WHEN Corrida = '97' THEN sum(Pto11)\n" +
"	WHEN Corrida = '91' THEN sum(Pto11) WHEN Corrida = '95' THEN sum(Pto11)\n" +
"	WHEN Corrida = '92' THEN sum(Pto11) WHEN Corrida = '93' THEN sum(Pto11)\n" +
"	WHEN Corrida = '88' THEN sum(Pto11) WHEN Corrida = '98' THEN sum(Pto11)\n" +
"	WHEN Corrida = '94' THEN sum(Pto11) WHEN Corrida = '82' THEN sum(Pto11)\n" +
"	WHEN Corrida = '96' THEN sum(Pto11) END AS Pto11,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto12) WHEN Corrida = '81' THEN sum(Pto12)\n" +
"	WHEN Corrida = '90' THEN sum(Pto12) WHEN Corrida = '97' THEN sum(Pto12)\n" +
"	WHEN Corrida = '91' THEN sum(Pto12) WHEN Corrida = '95' THEN sum(Pto12)\n" +
"	WHEN Corrida = '92' THEN sum(Pto12) WHEN Corrida = '93' THEN sum(Pto12)\n" +
"	WHEN Corrida = '88' THEN sum(Pto12) WHEN Corrida = '98' THEN sum(Pto12)\n" +
"	WHEN Corrida = '94' THEN sum(Pto12) WHEN Corrida = '82' THEN sum(Pto12)\n" +
"	WHEN Corrida = '96' THEN sum(Pto12) END AS Pto12,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto13) WHEN Corrida = '81' THEN sum(Pto13)\n" +
"	WHEN Corrida = '90' THEN sum(Pto13) WHEN Corrida = '97' THEN sum(Pto13)\n" +
"	WHEN Corrida = '91' THEN sum(Pto13) WHEN Corrida = '95' THEN sum(Pto13)\n" +
"	WHEN Corrida = '92' THEN sum(Pto13) WHEN Corrida = '93' THEN sum(Pto13)\n" +
"	WHEN Corrida = '88' THEN sum(Pto13) WHEN Corrida = '98' THEN sum(Pto13)\n" +
"	WHEN Corrida = '94' THEN sum(Pto13) WHEN Corrida = '82' THEN sum(Pto13)\n" +
"	WHEN Corrida = '96' THEN sum(Pto13) END AS Pto13,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto14) WHEN Corrida = '81' THEN sum(Pto14)\n" +
"	WHEN Corrida = '90' THEN sum(Pto14) WHEN Corrida = '97' THEN sum(Pto14)\n" +
"	WHEN Corrida = '91' THEN sum(Pto14) WHEN Corrida = '95' THEN sum(Pto14)\n" +
"	WHEN Corrida = '92' THEN sum(Pto14) WHEN Corrida = '93' THEN sum(Pto14)\n" +
"	WHEN Corrida = '88' THEN sum(Pto14) WHEN Corrida = '98' THEN sum(Pto14)\n" +
"	WHEN Corrida = '94' THEN sum(Pto14) WHEN Corrida = '82' THEN sum(Pto14)\n" +
"	WHEN Corrida = '96' THEN sum(Pto14) END AS Pto14,\n" +
"\n" +
"	CASE WHEN Corrida = '80' THEN sum(TotalPares) WHEN Corrida = '85' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '89' THEN sum(TotalPares) WHEN Corrida = '81' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '90' THEN sum(TotalPares) WHEN Corrida = '97' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '91' THEN sum(TotalPares) WHEN Corrida = '95' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '92' THEN sum(TotalPares) WHEN Corrida = '93' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '88' THEN sum(TotalPares) WHEN Corrida = '98' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '94' THEN sum(TotalPares) WHEN Corrida = '82' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '96' THEN sum(TotalPares) END AS TotalPares\n" +
"\n" +
"FROM InCopy\n" +
"group by Producto,Almacen,Estilo,Corrida,Combinacion,Tipo\n" +
"order by Producto");
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
            st = c.prepareStatement("SELECT Producto, Almacen, Estilo, Corrida, Combinacion,Tipo,\n" +
"\n" +
"CASE WHEN Corrida = '80' THEN sum(Pto1) WHEN Corrida = '85' THEN sum(Pto1)\n" +
"	WHEN Corrida = '89' THEN sum(Pto1) WHEN Corrida = '81' THEN sum(Pto1)\n" +
"	WHEN Corrida = '90' THEN sum(Pto1) WHEN Corrida = '97' THEN sum(Pto1)\n" +
"	WHEN Corrida = '91' THEN sum(Pto1) WHEN Corrida = '95' THEN sum(Pto1)\n" +
"	WHEN Corrida = '92' THEN sum(Pto1) WHEN Corrida = '93' THEN sum(Pto1)\n" +
"	WHEN Corrida = '88' THEN sum(Pto1) WHEN Corrida = '98' THEN sum(Pto1)\n" +
"	WHEN Corrida = '94' THEN sum(Pto1) WHEN Corrida = '82' THEN sum(Pto1)\n" +
"	WHEN Corrida = '96' THEN sum(Pto1) END AS Pto1,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto2) WHEN Corrida = '81' THEN sum(Pto2)\n" +
"	WHEN Corrida = '90' THEN sum(Pto2) WHEN Corrida = '97' THEN sum(Pto2)\n" +
"	WHEN Corrida = '91' THEN sum(Pto2) WHEN Corrida = '95' THEN sum(Pto2)\n" +
"	WHEN Corrida = '92' THEN sum(Pto2) WHEN Corrida = '93' THEN sum(Pto2)\n" +
"	WHEN Corrida = '88' THEN sum(Pto2) WHEN Corrida = '98' THEN sum(Pto2)\n" +
"	WHEN Corrida = '94' THEN sum(Pto2) WHEN Corrida = '82' THEN sum(Pto2)\n" +
"	WHEN Corrida = '96' THEN sum(Pto2) END AS Pto2,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto3) WHEN Corrida = '81' THEN sum(Pto3)\n" +
"	WHEN Corrida = '90' THEN sum(Pto3) WHEN Corrida = '97' THEN sum(Pto3)\n" +
"	WHEN Corrida = '91' THEN sum(Pto3) WHEN Corrida = '95' THEN sum(Pto3)\n" +
"	WHEN Corrida = '92' THEN sum(Pto3) WHEN Corrida = '93' THEN sum(Pto3)\n" +
"	WHEN Corrida = '88' THEN sum(Pto3) WHEN Corrida = '98' THEN sum(Pto3)\n" +
"	WHEN Corrida = '94' THEN sum(Pto3) WHEN Corrida = '82' THEN sum(Pto3)\n" +
"	WHEN Corrida = '96' THEN sum(Pto3) END AS Pto3,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto4) WHEN Corrida = '81' THEN sum(Pto4)\n" +
"	WHEN Corrida = '90' THEN sum(Pto4) WHEN Corrida = '97' THEN sum(Pto4)\n" +
"	WHEN Corrida = '91' THEN sum(Pto4) WHEN Corrida = '95' THEN sum(Pto4)\n" +
"	WHEN Corrida = '92' THEN sum(Pto4) WHEN Corrida = '93' THEN sum(Pto4)\n" +
"	WHEN Corrida = '88' THEN sum(Pto4) WHEN Corrida = '98' THEN sum(Pto4)\n" +
"	WHEN Corrida = '94' THEN sum(Pto4) WHEN Corrida = '82' THEN sum(Pto4)\n" +
"	WHEN Corrida = '96' THEN sum(Pto4) END AS Pto4,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto5) WHEN Corrida = '81' THEN sum(Pto5)\n" +
"	WHEN Corrida = '90' THEN sum(Pto5) WHEN Corrida = '97' THEN sum(Pto5)\n" +
"	WHEN Corrida = '91' THEN sum(Pto5) WHEN Corrida = '95' THEN sum(Pto5)\n" +
"	WHEN Corrida = '92' THEN sum(Pto5) WHEN Corrida = '93' THEN sum(Pto5)\n" +
"	WHEN Corrida = '88' THEN sum(Pto5) WHEN Corrida = '98' THEN sum(Pto5)\n" +
"	WHEN Corrida = '94' THEN sum(Pto5) WHEN Corrida = '82' THEN sum(Pto5)\n" +
"	WHEN Corrida = '96' THEN sum(Pto5) END AS Pto5,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto6) WHEN Corrida = '81' THEN sum(Pto6)\n" +
"	WHEN Corrida = '90' THEN sum(Pto6) WHEN Corrida = '97' THEN sum(Pto6)\n" +
"	WHEN Corrida = '91' THEN sum(Pto6) WHEN Corrida = '95' THEN sum(Pto6)\n" +
"	WHEN Corrida = '92' THEN sum(Pto6) WHEN Corrida = '93' THEN sum(Pto6)\n" +
"	WHEN Corrida = '88' THEN sum(Pto6) WHEN Corrida = '98' THEN sum(Pto6)\n" +
"	WHEN Corrida = '94' THEN sum(Pto6) WHEN Corrida = '82' THEN sum(Pto6)\n" +
"	WHEN Corrida = '96' THEN sum(Pto6) END AS Pto6,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto7) WHEN Corrida = '81' THEN sum(Pto7)\n" +
"	WHEN Corrida = '90' THEN sum(Pto7) WHEN Corrida = '97' THEN sum(Pto7)\n" +
"	WHEN Corrida = '91' THEN sum(Pto7) WHEN Corrida = '95' THEN sum(Pto7)\n" +
"	WHEN Corrida = '92' THEN sum(Pto7) WHEN Corrida = '93' THEN sum(Pto7)\n" +
"	WHEN Corrida = '88' THEN sum(Pto7) WHEN Corrida = '98' THEN sum(Pto7)\n" +
"	WHEN Corrida = '94' THEN sum(Pto7) WHEN Corrida = '82' THEN sum(Pto7)\n" +
"	WHEN Corrida = '96' THEN sum(Pto7) END AS Pto7,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto8) WHEN Corrida = '81' THEN sum(Pto8)\n" +
"	WHEN Corrida = '90' THEN sum(Pto8) WHEN Corrida = '97' THEN sum(Pto8)\n" +
"	WHEN Corrida = '91' THEN sum(Pto8) WHEN Corrida = '95' THEN sum(Pto8)\n" +
"	WHEN Corrida = '92' THEN sum(Pto8) WHEN Corrida = '93' THEN sum(Pto8)\n" +
"	WHEN Corrida = '88' THEN sum(Pto8) WHEN Corrida = '98' THEN sum(Pto8)\n" +
"	WHEN Corrida = '94' THEN sum(Pto8) WHEN Corrida = '82' THEN sum(Pto8)\n" +
"	WHEN Corrida = '96' THEN sum(Pto8) END AS Pto8,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto9) WHEN Corrida = '81' THEN sum(Pto9)\n" +
"	WHEN Corrida = '90' THEN sum(Pto9) WHEN Corrida = '97' THEN sum(Pto9)\n" +
"	WHEN Corrida = '91' THEN sum(Pto9) WHEN Corrida = '95' THEN sum(Pto9)\n" +
"	WHEN Corrida = '92' THEN sum(Pto9) WHEN Corrida = '93' THEN sum(Pto9)\n" +
"	WHEN Corrida = '88' THEN sum(Pto9) WHEN Corrida = '98' THEN sum(Pto9)\n" +
"	WHEN Corrida = '94' THEN sum(Pto9) WHEN Corrida = '82' THEN sum(Pto9)\n" +
"	WHEN Corrida = '96' THEN sum(Pto9) END AS Pto9,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto10) WHEN Corrida = '81' THEN sum(Pto10)\n" +
"	WHEN Corrida = '90' THEN sum(Pto10) WHEN Corrida = '97' THEN sum(Pto10)\n" +
"	WHEN Corrida = '91' THEN sum(Pto10) WHEN Corrida = '95' THEN sum(Pto10)\n" +
"	WHEN Corrida = '92' THEN sum(Pto10) WHEN Corrida = '93' THEN sum(Pto10)\n" +
"	WHEN Corrida = '88' THEN sum(Pto10) WHEN Corrida = '98' THEN sum(Pto10)\n" +
"	WHEN Corrida = '94' THEN sum(Pto10) WHEN Corrida = '82' THEN sum(Pto10)\n" +
"	WHEN Corrida = '96' THEN sum(Pto10) END AS Pto10,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto11) WHEN Corrida = '81' THEN sum(Pto11)\n" +
"	WHEN Corrida = '90' THEN sum(Pto11) WHEN Corrida = '97' THEN sum(Pto11)\n" +
"	WHEN Corrida = '91' THEN sum(Pto11) WHEN Corrida = '95' THEN sum(Pto11)\n" +
"	WHEN Corrida = '92' THEN sum(Pto11) WHEN Corrida = '93' THEN sum(Pto11)\n" +
"	WHEN Corrida = '88' THEN sum(Pto11) WHEN Corrida = '98' THEN sum(Pto11)\n" +
"	WHEN Corrida = '94' THEN sum(Pto11) WHEN Corrida = '82' THEN sum(Pto11)\n" +
"	WHEN Corrida = '96' THEN sum(Pto11) END AS Pto11,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto12) WHEN Corrida = '81' THEN sum(Pto12)\n" +
"	WHEN Corrida = '90' THEN sum(Pto12) WHEN Corrida = '97' THEN sum(Pto12)\n" +
"	WHEN Corrida = '91' THEN sum(Pto12) WHEN Corrida = '95' THEN sum(Pto12)\n" +
"	WHEN Corrida = '92' THEN sum(Pto12) WHEN Corrida = '93' THEN sum(Pto12)\n" +
"	WHEN Corrida = '88' THEN sum(Pto12) WHEN Corrida = '98' THEN sum(Pto12)\n" +
"	WHEN Corrida = '94' THEN sum(Pto12) WHEN Corrida = '82' THEN sum(Pto12)\n" +
"	WHEN Corrida = '96' THEN sum(Pto12) END AS Pto12,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto13) WHEN Corrida = '81' THEN sum(Pto13)\n" +
"	WHEN Corrida = '90' THEN sum(Pto13) WHEN Corrida = '97' THEN sum(Pto13)\n" +
"	WHEN Corrida = '91' THEN sum(Pto13) WHEN Corrida = '95' THEN sum(Pto13)\n" +
"	WHEN Corrida = '92' THEN sum(Pto13) WHEN Corrida = '93' THEN sum(Pto13)\n" +
"	WHEN Corrida = '88' THEN sum(Pto13) WHEN Corrida = '98' THEN sum(Pto13)\n" +
"	WHEN Corrida = '94' THEN sum(Pto13) WHEN Corrida = '82' THEN sum(Pto13)\n" +
"	WHEN Corrida = '96' THEN sum(Pto13) END AS Pto13,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto14) WHEN Corrida = '81' THEN sum(Pto14)\n" +
"	WHEN Corrida = '90' THEN sum(Pto14) WHEN Corrida = '97' THEN sum(Pto14)\n" +
"	WHEN Corrida = '91' THEN sum(Pto14) WHEN Corrida = '95' THEN sum(Pto14)\n" +
"	WHEN Corrida = '92' THEN sum(Pto14) WHEN Corrida = '93' THEN sum(Pto14)\n" +
"	WHEN Corrida = '88' THEN sum(Pto14) WHEN Corrida = '98' THEN sum(Pto14)\n" +
"	WHEN Corrida = '94' THEN sum(Pto14) WHEN Corrida = '82' THEN sum(Pto14)\n" +
"	WHEN Corrida = '96' THEN sum(Pto14) END AS Pto14,\n" +
"\n" +
"	CASE WHEN Corrida = '80' THEN sum(TotalPares) WHEN Corrida = '85' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '89' THEN sum(TotalPares) WHEN Corrida = '81' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '90' THEN sum(TotalPares) WHEN Corrida = '97' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '91' THEN sum(TotalPares) WHEN Corrida = '95' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '92' THEN sum(TotalPares) WHEN Corrida = '93' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '88' THEN sum(TotalPares) WHEN Corrida = '98' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '94' THEN sum(TotalPares) WHEN Corrida = '82' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '96' THEN sum(TotalPares) END AS TotalPares\n" +
"\n" +
"FROM InCopyN\n" +
"group by Producto,Almacen,Estilo,Corrida,Combinacion,Tipo\n" +
"order by Producto");
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
            st = c.prepareStatement("SELECT Producto, Almacen, Estilo, Corrida, Combinacion,Tipo,\n" +
"\n" +
"CASE WHEN Corrida = '80' THEN sum(Pto1) WHEN Corrida = '85' THEN sum(Pto1)\n" +
"	WHEN Corrida = '89' THEN sum(Pto1) WHEN Corrida = '81' THEN sum(Pto1)\n" +
"	WHEN Corrida = '90' THEN sum(Pto1) WHEN Corrida = '97' THEN sum(Pto1)\n" +
"	WHEN Corrida = '91' THEN sum(Pto1) WHEN Corrida = '95' THEN sum(Pto1)\n" +
"	WHEN Corrida = '92' THEN sum(Pto1) WHEN Corrida = '93' THEN sum(Pto1)\n" +
"	WHEN Corrida = '88' THEN sum(Pto1) WHEN Corrida = '98' THEN sum(Pto1)\n" +
"	WHEN Corrida = '94' THEN sum(Pto1) WHEN Corrida = '82' THEN sum(Pto1)\n" +
"	WHEN Corrida = '96' THEN sum(Pto1) END AS Pto1,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto2) WHEN Corrida = '81' THEN sum(Pto2)\n" +
"	WHEN Corrida = '90' THEN sum(Pto2) WHEN Corrida = '97' THEN sum(Pto2)\n" +
"	WHEN Corrida = '91' THEN sum(Pto2) WHEN Corrida = '95' THEN sum(Pto2)\n" +
"	WHEN Corrida = '92' THEN sum(Pto2) WHEN Corrida = '93' THEN sum(Pto2)\n" +
"	WHEN Corrida = '88' THEN sum(Pto2) WHEN Corrida = '98' THEN sum(Pto2)\n" +
"	WHEN Corrida = '94' THEN sum(Pto2) WHEN Corrida = '82' THEN sum(Pto2)\n" +
"	WHEN Corrida = '96' THEN sum(Pto2) END AS Pto2,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto3) WHEN Corrida = '81' THEN sum(Pto3)\n" +
"	WHEN Corrida = '90' THEN sum(Pto3) WHEN Corrida = '97' THEN sum(Pto3)\n" +
"	WHEN Corrida = '91' THEN sum(Pto3) WHEN Corrida = '95' THEN sum(Pto3)\n" +
"	WHEN Corrida = '92' THEN sum(Pto3) WHEN Corrida = '93' THEN sum(Pto3)\n" +
"	WHEN Corrida = '88' THEN sum(Pto3) WHEN Corrida = '98' THEN sum(Pto3)\n" +
"	WHEN Corrida = '94' THEN sum(Pto3) WHEN Corrida = '82' THEN sum(Pto3)\n" +
"	WHEN Corrida = '96' THEN sum(Pto3) END AS Pto3,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto4) WHEN Corrida = '81' THEN sum(Pto4)\n" +
"	WHEN Corrida = '90' THEN sum(Pto4) WHEN Corrida = '97' THEN sum(Pto4)\n" +
"	WHEN Corrida = '91' THEN sum(Pto4) WHEN Corrida = '95' THEN sum(Pto4)\n" +
"	WHEN Corrida = '92' THEN sum(Pto4) WHEN Corrida = '93' THEN sum(Pto4)\n" +
"	WHEN Corrida = '88' THEN sum(Pto4) WHEN Corrida = '98' THEN sum(Pto4)\n" +
"	WHEN Corrida = '94' THEN sum(Pto4) WHEN Corrida = '82' THEN sum(Pto4)\n" +
"	WHEN Corrida = '96' THEN sum(Pto4) END AS Pto4,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto5) WHEN Corrida = '81' THEN sum(Pto5)\n" +
"	WHEN Corrida = '90' THEN sum(Pto5) WHEN Corrida = '97' THEN sum(Pto5)\n" +
"	WHEN Corrida = '91' THEN sum(Pto5) WHEN Corrida = '95' THEN sum(Pto5)\n" +
"	WHEN Corrida = '92' THEN sum(Pto5) WHEN Corrida = '93' THEN sum(Pto5)\n" +
"	WHEN Corrida = '88' THEN sum(Pto5) WHEN Corrida = '98' THEN sum(Pto5)\n" +
"	WHEN Corrida = '94' THEN sum(Pto5) WHEN Corrida = '82' THEN sum(Pto5)\n" +
"	WHEN Corrida = '96' THEN sum(Pto5) END AS Pto5,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto6) WHEN Corrida = '81' THEN sum(Pto6)\n" +
"	WHEN Corrida = '90' THEN sum(Pto6) WHEN Corrida = '97' THEN sum(Pto6)\n" +
"	WHEN Corrida = '91' THEN sum(Pto6) WHEN Corrida = '95' THEN sum(Pto6)\n" +
"	WHEN Corrida = '92' THEN sum(Pto6) WHEN Corrida = '93' THEN sum(Pto6)\n" +
"	WHEN Corrida = '88' THEN sum(Pto6) WHEN Corrida = '98' THEN sum(Pto6)\n" +
"	WHEN Corrida = '94' THEN sum(Pto6) WHEN Corrida = '82' THEN sum(Pto6)\n" +
"	WHEN Corrida = '96' THEN sum(Pto6) END AS Pto6,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto7) WHEN Corrida = '81' THEN sum(Pto7)\n" +
"	WHEN Corrida = '90' THEN sum(Pto7) WHEN Corrida = '97' THEN sum(Pto7)\n" +
"	WHEN Corrida = '91' THEN sum(Pto7) WHEN Corrida = '95' THEN sum(Pto7)\n" +
"	WHEN Corrida = '92' THEN sum(Pto7) WHEN Corrida = '93' THEN sum(Pto7)\n" +
"	WHEN Corrida = '88' THEN sum(Pto7) WHEN Corrida = '98' THEN sum(Pto7)\n" +
"	WHEN Corrida = '94' THEN sum(Pto7) WHEN Corrida = '82' THEN sum(Pto7)\n" +
"	WHEN Corrida = '96' THEN sum(Pto7) END AS Pto7,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto8) WHEN Corrida = '81' THEN sum(Pto8)\n" +
"	WHEN Corrida = '90' THEN sum(Pto8) WHEN Corrida = '97' THEN sum(Pto8)\n" +
"	WHEN Corrida = '91' THEN sum(Pto8) WHEN Corrida = '95' THEN sum(Pto8)\n" +
"	WHEN Corrida = '92' THEN sum(Pto8) WHEN Corrida = '93' THEN sum(Pto8)\n" +
"	WHEN Corrida = '88' THEN sum(Pto8) WHEN Corrida = '98' THEN sum(Pto8)\n" +
"	WHEN Corrida = '94' THEN sum(Pto8) WHEN Corrida = '82' THEN sum(Pto8)\n" +
"	WHEN Corrida = '96' THEN sum(Pto8) END AS Pto8,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto9) WHEN Corrida = '81' THEN sum(Pto9)\n" +
"	WHEN Corrida = '90' THEN sum(Pto9) WHEN Corrida = '97' THEN sum(Pto9)\n" +
"	WHEN Corrida = '91' THEN sum(Pto9) WHEN Corrida = '95' THEN sum(Pto9)\n" +
"	WHEN Corrida = '92' THEN sum(Pto9) WHEN Corrida = '93' THEN sum(Pto9)\n" +
"	WHEN Corrida = '88' THEN sum(Pto9) WHEN Corrida = '98' THEN sum(Pto9)\n" +
"	WHEN Corrida = '94' THEN sum(Pto9) WHEN Corrida = '82' THEN sum(Pto9)\n" +
"	WHEN Corrida = '96' THEN sum(Pto9) END AS Pto9,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto10) WHEN Corrida = '81' THEN sum(Pto10)\n" +
"	WHEN Corrida = '90' THEN sum(Pto10) WHEN Corrida = '97' THEN sum(Pto10)\n" +
"	WHEN Corrida = '91' THEN sum(Pto10) WHEN Corrida = '95' THEN sum(Pto10)\n" +
"	WHEN Corrida = '92' THEN sum(Pto10) WHEN Corrida = '93' THEN sum(Pto10)\n" +
"	WHEN Corrida = '88' THEN sum(Pto10) WHEN Corrida = '98' THEN sum(Pto10)\n" +
"	WHEN Corrida = '94' THEN sum(Pto10) WHEN Corrida = '82' THEN sum(Pto10)\n" +
"	WHEN Corrida = '96' THEN sum(Pto10) END AS Pto10,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto11) WHEN Corrida = '81' THEN sum(Pto11)\n" +
"	WHEN Corrida = '90' THEN sum(Pto11) WHEN Corrida = '97' THEN sum(Pto11)\n" +
"	WHEN Corrida = '91' THEN sum(Pto11) WHEN Corrida = '95' THEN sum(Pto11)\n" +
"	WHEN Corrida = '92' THEN sum(Pto11) WHEN Corrida = '93' THEN sum(Pto11)\n" +
"	WHEN Corrida = '88' THEN sum(Pto11) WHEN Corrida = '98' THEN sum(Pto11)\n" +
"	WHEN Corrida = '94' THEN sum(Pto11) WHEN Corrida = '82' THEN sum(Pto11)\n" +
"	WHEN Corrida = '96' THEN sum(Pto11) END AS Pto11,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto12) WHEN Corrida = '81' THEN sum(Pto12)\n" +
"	WHEN Corrida = '90' THEN sum(Pto12) WHEN Corrida = '97' THEN sum(Pto12)\n" +
"	WHEN Corrida = '91' THEN sum(Pto12) WHEN Corrida = '95' THEN sum(Pto12)\n" +
"	WHEN Corrida = '92' THEN sum(Pto12) WHEN Corrida = '93' THEN sum(Pto12)\n" +
"	WHEN Corrida = '88' THEN sum(Pto12) WHEN Corrida = '98' THEN sum(Pto12)\n" +
"	WHEN Corrida = '94' THEN sum(Pto12) WHEN Corrida = '82' THEN sum(Pto12)\n" +
"	WHEN Corrida = '96' THEN sum(Pto12) END AS Pto12,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto13) WHEN Corrida = '81' THEN sum(Pto13)\n" +
"	WHEN Corrida = '90' THEN sum(Pto13) WHEN Corrida = '97' THEN sum(Pto13)\n" +
"	WHEN Corrida = '91' THEN sum(Pto13) WHEN Corrida = '95' THEN sum(Pto13)\n" +
"	WHEN Corrida = '92' THEN sum(Pto13) WHEN Corrida = '93' THEN sum(Pto13)\n" +
"	WHEN Corrida = '88' THEN sum(Pto13) WHEN Corrida = '98' THEN sum(Pto13)\n" +
"	WHEN Corrida = '94' THEN sum(Pto13) WHEN Corrida = '82' THEN sum(Pto13)\n" +
"	WHEN Corrida = '96' THEN sum(Pto13) END AS Pto13,\n" +
"\n" +
"	CASE WHEN Corrida = '89' THEN sum(Pto14) WHEN Corrida = '81' THEN sum(Pto14)\n" +
"	WHEN Corrida = '90' THEN sum(Pto14) WHEN Corrida = '97' THEN sum(Pto14)\n" +
"	WHEN Corrida = '91' THEN sum(Pto14) WHEN Corrida = '95' THEN sum(Pto14)\n" +
"	WHEN Corrida = '92' THEN sum(Pto14) WHEN Corrida = '93' THEN sum(Pto14)\n" +
"	WHEN Corrida = '88' THEN sum(Pto14) WHEN Corrida = '98' THEN sum(Pto14)\n" +
"	WHEN Corrida = '94' THEN sum(Pto14) WHEN Corrida = '82' THEN sum(Pto14)\n" +
"	WHEN Corrida = '96' THEN sum(Pto14) END AS Pto14,\n" +
"\n" +
"	CASE WHEN Corrida = '80' THEN sum(TotalPares) WHEN Corrida = '85' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '89' THEN sum(TotalPares) WHEN Corrida = '81' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '90' THEN sum(TotalPares) WHEN Corrida = '97' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '91' THEN sum(TotalPares) WHEN Corrida = '95' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '92' THEN sum(TotalPares) WHEN Corrida = '93' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '88' THEN sum(TotalPares) WHEN Corrida = '98' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '94' THEN sum(TotalPares) WHEN Corrida = '82' THEN sum(TotalPares)\n" +
"	WHEN Corrida = '96' THEN sum(TotalPares) END AS TotalPares\n" +
"\n" +
"FROM InCopyK\n" +
"group by Producto,Almacen,Estilo,Corrida,Combinacion,Tipo\n" +
"order by Producto");
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
