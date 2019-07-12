package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ObjectPlaneacion {

    PreparedStatement st = null, dp = null;
    ObjectDetalle obj = new ObjectDetalle();

    Connection pa = Server.getRcpt();
    Connection c = Server.getRpt();
    Connection[] datos = {c, pa};

    ResultSet rs = null;

    public ArrayList<Planeacion> obtenerPlaneacion(int año, int semana) {
        ArrayList<Planeacion> lista = new ArrayList<Planeacion>();
        try {
            dp = pa.prepareStatement("DECLARE @v1 INT  \n"
                    + "SET @v1 = 0  \n"
                    + "SELECT  \n"
                    + "ROW_NUMBER() OVER(ORDER BY p.Npedido) AS Numero,  \n"
                    + "dp.Npedido as Pedido,\n"
                    + "CASE WHEN dp.Serie = 'A' THEN c.RazonSocial \n"
                    + "WHEN dp.Serie = 'B' THEN c.Nombre \n"
                    + "END AS Cliente,\n"
                    + "c.Id_Cliente,a.Id_Agente,pd.Id_Producto,a.Descripcion as Agente,  \n"
                    + "l.Descripcion as Modelo,cr.Descripcion as Color, \n"
                    + "cr.Id_Color,crd.Id_Corrida, \n"
                    + "dp.C1,dp.C2,dp.C3,dp.C4,dp.C5,dp.C6,dp.C7,dp.C8,dp.C9,dp.C10,dp.C11,dp.C12, \n"
                    + " CASE  \n"
                    + "		WHEN Corrida = '10-12' THEN 10 \n"
                    + "		WHEN Corrida = '11-14' THEN 11 \n"
                    + "		WHEN Corrida = '12-14' THEN 12 \n"
                    + "		WHEN Corrida = '13-16' THEN 13 \n"
                    + "        WHEN Corrida = '15-17' THEN 15 \n"
                    + "							WHEN Corrida = '17-21' THEN 17 \n"
                    + "                   			WHEN Corrida = '18-21' THEN 18 \n"
                    + "							WHEN Corrida = '21-25' THEN 21 \n"
                    + "                   			WHEN Corrida = '22-24' THEN 22  \n"
                    + "                   			WHEN Corrida = '22-26' THEN 22 \n"
                    + "                   			WHEN Corrida = '23-26' THEN 22 \n"
                    + "							WHEN Corrida = '22-27' THEN 22 \n"
                    + "							WHEN Corrida = '23-27' THEN 23 \n"
                    + "                   			WHEN Corrida = '25-30' THEN 25 \n"
                    + "							WHEN Corrida = '25-29' THEN 25 \n"
                    + "							WHEN Corrida = '27-29' THEN 27 \n"
                    + "							WHEN Corrida = '30-33' THEN 30 \n"
                    + "                   			END AS 'Pto1', \n"
                    + "                   		CASE  \n"
                    + "                   			WHEN Corrida = '10-12' THEN 10.5 \n"
                    + "							WHEN Corrida = '11-14' THEN 11.5 \n"
                    + "							WHEN Corrida = '12-14' THEN 12.5 \n"
                    + "							WHEN Corrida = '13-16' THEN 13.5 \n"
                    + "                   			WHEN Corrida = '15-17' THEN 15.5 \n"
                    + "							WHEN Corrida = '17-21' THEN 17.5 \n"
                    + "                   			WHEN Corrida = '18-21' THEN 18.5 \n"
                    + "							WHEN Corrida = '21-25' THEN 21.5 \n"
                    + "                   			WHEN Corrida = '22-24' THEN 22.5  \n"
                    + "                   			WHEN Corrida = '22-26' THEN 22.5 \n"
                    + "                   			WHEN Corrida = '23-26' THEN 22.5 \n"
                    + "							WHEN Corrida = '22-27' THEN 22.5 \n"
                    + "							WHEN Corrida = '23-27' THEN 23.5 \n"
                    + "                   			WHEN Corrida = '25-30' THEN 25.5 \n"
                    + "							WHEN Corrida = '25-29' THEN 25.5 \n"
                    + "							WHEN Corrida = '27-29' THEN 27.5 \n"
                    + "							WHEN Corrida = '30-33' THEN 30.5 \n"
                    + "                   			END AS 'Pto2', \n"
                    + "                   		CASE  \n"
                    + "                   			WHEN Corrida = '10-12' THEN 11 \n"
                    + "							WHEN Corrida = '11-14' THEN 12 \n"
                    + "							WHEN Corrida = '12-14' THEN 13 \n"
                    + "							WHEN Corrida = '13-16' THEN 14 \n"
                    + "                   			WHEN Corrida = '15-17' THEN 16 \n"
                    + "							WHEN Corrida = '17-21' THEN 18 \n"
                    + "                   			WHEN Corrida = '18-21' THEN 19 \n"
                    + "							WHEN Corrida = '21-25' THEN 22 \n"
                    + "                   			WHEN Corrida = '22-24' THEN 23  \n"
                    + "                   			WHEN Corrida = '22-26' THEN 23 \n"
                    + "                   			WHEN Corrida = '23-26' THEN 23 \n"
                    + "							WHEN Corrida = '22-27' THEN 23 \n"
                    + "							WHEN Corrida = '23-27' THEN 24 \n"
                    + "                   			WHEN Corrida = '25-30' THEN 26 \n"
                    + "							WHEN Corrida = '25-29' THEN 26 \n"
                    + "							WHEN Corrida = '27-29' THEN 28 \n"
                    + "							WHEN Corrida = '30-33' THEN 31 \n"
                    + "                   			END AS 'Pto3', \n"
                    + "                   			CASE  \n"
                    + "                   			WHEN Corrida = '10-12' THEN 11.5 \n"
                    + "							WHEN Corrida = '11-14' THEN 12.5 \n"
                    + "							WHEN Corrida = '12-14' THEN 13.5 \n"
                    + "							WHEN Corrida = '13-16' THEN 14.5 \n"
                    + "                   			WHEN Corrida = '15-17' THEN 16.5 \n"
                    + "							WHEN Corrida = '17-21' THEN 18.5 \n"
                    + "                   			WHEN Corrida = '18-21' THEN 19.5 \n"
                    + "							WHEN Corrida = '21-25' THEN 22.5 \n"
                    + "                   			WHEN Corrida = '22-24' THEN 23.5  \n"
                    + "                   			WHEN Corrida = '22-26' THEN 23.5 \n"
                    + "                   			WHEN Corrida = '23-26' THEN 23.5 \n"
                    + "							WHEN Corrida = '22-27' THEN 23.5 \n"
                    + "							WHEN Corrida = '23-27' THEN 24.5 \n"
                    + "                   			WHEN Corrida = '25-30' THEN 26.5 \n"
                    + "							WHEN Corrida = '25-29' THEN 26.5 \n"
                    + "							WHEN Corrida = '27-29' THEN 28.5 \n"
                    + "							WHEN Corrida = '30-33' THEN 31.5 \n"
                    + "                   			END AS 'Pto4', \n"
                    + "                   			CASE  \n"
                    + "                   			WHEN Corrida = '10-12' THEN 12 \n"
                    + "							WHEN Corrida = '11-14' THEN 13 \n"
                    + "							WHEN Corrida = '12-14' THEN 14 \n"
                    + "							WHEN Corrida = '13-16' THEN 15 \n"
                    + "                   			WHEN Corrida = '15-17' THEN 17 \n"
                    + "							WHEN Corrida = '17-21' THEN 19 \n"
                    + "                   			WHEN Corrida = '18-21' THEN 20 \n"
                    + "							WHEN Corrida = '21-25' THEN 23 \n"
                    + "                   			WHEN Corrida = '22-24' THEN 24 \n"
                    + "                   			WHEN Corrida = '22-26' THEN 24 \n"
                    + "                   			WHEN Corrida = '23-26' THEN 24 \n"
                    + "							WHEN Corrida = '22-27' THEN 24 \n"
                    + "							WHEN Corrida = '23-27' THEN 25 \n"
                    + "                   			WHEN Corrida = '25-30' THEN 27 \n"
                    + "							WHEN Corrida = '25-29' THEN 27 \n"
                    + "							WHEN Corrida = '27-29' THEN 29 \n"
                    + "							WHEN Corrida = '30-33' THEN 32 \n"
                    + "                   			END AS 'Pto5', \n"
                    + "                   			CASE  \n"
                    + "                   			WHEN Corrida = '10-12' THEN 12.5 \n"
                    + "							WHEN Corrida = '11-14' THEN 13.5 \n"
                    + "							WHEN Corrida = '12-14' THEN 14.5 \n"
                    + "							WHEN Corrida = '13-16' THEN 15.5 \n"
                    + "                   			WHEN Corrida = '15-17' THEN 17.5 \n"
                    + "							WHEN Corrida = '17-21' THEN 19.5 \n"
                    + "                   			WHEN Corrida = '18-21' THEN 20.5 \n"
                    + "							WHEN Corrida = '21-25' THEN 23.5 \n"
                    + "                   			WHEN Corrida = '22-24' THEN 24.5 \n"
                    + "                   			WHEN Corrida = '22-26' THEN 24.5 \n"
                    + "                   			WHEN Corrida = '23-26' THEN 24.5 \n"
                    + "							WHEN Corrida = '22-27' THEN 24.5 \n"
                    + "							WHEN Corrida = '23-27' THEN 25.5 \n"
                    + "                   			WHEN Corrida = '25-30' THEN 27.5 \n"
                    + "							WHEN Corrida = '25-29' THEN 27.5 \n"
                    + "							WHEN Corrida = '27-29' THEN 29.5 \n"
                    + "							WHEN Corrida = '30-33' THEN 32.5 \n"
                    + "                   			END AS 'Pto6', \n"
                    + "							CASE  \n"
                    + "                   			WHEN Corrida = '10-12' THEN 0 \n"
                    + "							WHEN Corrida = '11-14' THEN 14 \n"
                    + "							WHEN Corrida = '12-14' THEN 0 \n"
                    + "							WHEN Corrida = '13-16' THEN 16 \n"
                    + "                   			WHEN Corrida = '15-17' THEN 0 \n"
                    + "							WHEN Corrida = '17-21' THEN 20 \n"
                    + "                   			WHEN Corrida = '18-21' THEN 21 \n"
                    + "							WHEN Corrida = '21-25' THEN 24 \n"
                    + "                   			WHEN Corrida = '22-24' THEN 0 \n"
                    + "                   			WHEN Corrida = '22-26' THEN 25 \n"
                    + "                   			WHEN Corrida = '23-26' THEN 25 \n"
                    + "							WHEN Corrida = '22-27' THEN 25 \n"
                    + "							WHEN Corrida = '23-27' THEN 26 \n"
                    + "                   			WHEN Corrida = '25-30' THEN 28 \n"
                    + "							WHEN Corrida = '25-29' THEN 28 \n"
                    + "							WHEN Corrida = '27-29' THEN 0 \n"
                    + "							WHEN Corrida = '30-33' THEN 33 \n"
                    + "                   			END AS 'Pto7', \n"
                    + "							CASE  \n"
                    + "                   			WHEN Corrida = '10-12' THEN 0 \n"
                    + "							WHEN Corrida = '11-14' THEN 14.5 \n"
                    + "							WHEN Corrida = '12-14' THEN 0 \n"
                    + "							WHEN Corrida = '13-16' THEN 16.5 \n"
                    + "                   			WHEN Corrida = '15-17' THEN 0 \n"
                    + "							WHEN Corrida = '17-21' THEN 20.5 \n"
                    + "                   			WHEN Corrida = '18-21' THEN 21.5 \n"
                    + "							WHEN Corrida = '21-25' THEN 24.5 \n"
                    + "                   			WHEN Corrida = '22-24' THEN 0 \n"
                    + "                   			WHEN Corrida = '22-26' THEN 25.5 \n"
                    + "                   			WHEN Corrida = '23-26' THEN 25.5 \n"
                    + "							WHEN Corrida = '22-27' THEN 25.5 \n"
                    + "							WHEN Corrida = '23-27' THEN 26.5 \n"
                    + "                   			WHEN Corrida = '25-30' THEN 28.5 \n"
                    + "							WHEN Corrida = '25-29' THEN 28.5 \n"
                    + "							WHEN Corrida = '27-29' THEN 0 \n"
                    + "							WHEN Corrida = '30-33' THEN 33.5 \n"
                    + "                   			END AS 'Pto8', \n"
                    + "							CASE  \n"
                    + "                   			WHEN Corrida = '10-12' THEN 0 \n"
                    + "							WHEN Corrida = '11-14' THEN 0 \n"
                    + "							WHEN Corrida = '12-14' THEN 0 \n"
                    + "							WHEN Corrida = '13-16' THEN 0 \n"
                    + "                   			WHEN Corrida = '15-17' THEN 0 \n"
                    + "							WHEN Corrida = '17-21' THEN 21 \n"
                    + "                   			WHEN Corrida = '18-21' THEN 0 \n"
                    + "							WHEN Corrida = '21-25' THEN 25 \n"
                    + "                   			WHEN Corrida = '22-24' THEN 0 \n"
                    + "                   			WHEN Corrida = '22-26' THEN 26 \n"
                    + "                   			WHEN Corrida = '23-26' THEN 26 \n"
                    + "							WHEN Corrida = '22-27' THEN 26 \n"
                    + "							WHEN Corrida = '23-27' THEN 27 \n"
                    + "                   			WHEN Corrida = '25-30' THEN 29 \n"
                    + "							WHEN Corrida = '25-29' THEN 29 \n"
                    + "							WHEN Corrida = '27-29' THEN 0 \n"
                    + "							WHEN Corrida = '30-33' THEN 0 \n"
                    + "                   			END AS 'Pto9', \n"
                    + "							CASE  \n"
                    + "                   			WHEN Corrida = '10-12' THEN 0 \n"
                    + "							WHEN Corrida = '11-14' THEN 0 \n"
                    + "							WHEN Corrida = '12-14' THEN 0 \n"
                    + "							WHEN Corrida = '13-16' THEN 0 \n"
                    + "                   			WHEN Corrida = '15-17' THEN 0 \n"
                    + "							WHEN Corrida = '17-21' THEN 21.5 \n"
                    + "                   			WHEN Corrida = '18-21' THEN 0 \n"
                    + "							WHEN Corrida = '21-25' THEN 25.5 \n"
                    + "                   			WHEN Corrida = '22-24' THEN 0 \n"
                    + "                   			WHEN Corrida = '22-26' THEN 26.5 \n"
                    + "                   			WHEN Corrida = '23-26' THEN 26.5 \n"
                    + "							WHEN Corrida = '22-27' THEN 26.5 \n"
                    + "							WHEN Corrida = '23-27' THEN 27.5 \n"
                    + "                   			WHEN Corrida = '25-30' THEN 29.5 \n"
                    + "							WHEN Corrida = '25-29' THEN 29.5 \n"
                    + "							WHEN Corrida = '27-29' THEN 0 \n"
                    + "							WHEN Corrida = '30-33' THEN 0 \n"
                    + "                   			END AS 'Pto10', \n"
                    + "							CASE  \n"
                    + "                   			WHEN Corrida = '10-12' THEN 0 \n"
                    + "							WHEN Corrida = '11-14' THEN 0 \n"
                    + "							WHEN Corrida = '12-14' THEN 0 \n"
                    + "							WHEN Corrida = '13-16' THEN 0 \n"
                    + "                   			WHEN Corrida = '15-17' THEN 0 \n"
                    + "							WHEN Corrida = '17-21' THEN 0 \n"
                    + "                   			WHEN Corrida = '18-21' THEN 0 \n"
                    + "							WHEN Corrida = '21-25' THEN 0 \n"
                    + "                   			WHEN Corrida = '22-24' THEN 0 \n"
                    + "                   			WHEN Corrida = '22-26' THEN 0 \n"
                    + "                   			WHEN Corrida = '23-26' THEN 0 \n"
                    + "							WHEN Corrida = '22-27' THEN 27 \n"
                    + "							WHEN Corrida = '23-27' THEN 0 \n"
                    + "                   			WHEN Corrida = '25-30' THEN 30 \n"
                    + "							WHEN Corrida = '25-29' THEN 30 \n"
                    + "							WHEN Corrida = '27-29' THEN 0 \n"
                    + "							WHEN Corrida = '30-33' THEN 0 \n"
                    + "                   			END AS 'Pto11', \n"
                    + "							CASE  \n"
                    + "                   			WHEN Corrida = '10-12' THEN 0 \n"
                    + "							WHEN Corrida = '11-14' THEN 0 \n"
                    + "							WHEN Corrida = '12-14' THEN 0 \n"
                    + "							WHEN Corrida = '13-16' THEN 0 \n"
                    + "                   			WHEN Corrida = '15-17' THEN 0 \n"
                    + "							WHEN Corrida = '17-21' THEN 0 \n"
                    + "                   			WHEN Corrida = '18-21' THEN 0 \n"
                    + "							WHEN Corrida = '21-25' THEN 0 \n"
                    + "                   			WHEN Corrida = '22-24' THEN 0 \n"
                    + "                   			WHEN Corrida = '22-26' THEN 0 \n"
                    + "                   			WHEN Corrida = '23-26' THEN 0 \n"
                    + "							WHEN Corrida = '22-27' THEN 27.5 \n"
                    + "							WHEN Corrida = '23-27' THEN 0 \n"
                    + "                   			WHEN Corrida = '25-30' THEN 30.5 \n"
                    + "							WHEN Corrida = '25-29' THEN 30.5 \n"
                    + "							WHEN Corrida = '27-29' THEN 0 \n"
                    + "							WHEN Corrida = '30-33' THEN 0 \n"
                    + "                   			END AS 'Pto12', \n"
                    + "                            dp.Pares AS TotalPares,p.Observaciones,p.OrdenCompra,dp.Estatus,p.Serie \n"
                    + "                            FROM Pedidos p INNER JOIN CobranzaPhy.dbo.Clientes c \n"
                    + "                            ON p.Id_Cliente = c.Id_Cliente \n"
                    + "                            INNER JOIN CobranzaPhy.dbo.Agentes a \n"
                    + "                            ON c.Id_Agente = a.Id_Agente \n"
                    + "                            INNER JOIN Dpedido dp  \n"
                    + "                            ON p.Npedido = dp.Npedido \n"
                    + "                            INNER JOIN ProduccionPhy.dbo.Producto pd \n"
                    + "                            ON dp.Id_Producto = pd.Id_Producto \n"
                    + "                            INNER JOIN ProduccionPhy.dbo.Color cr \n"
                    + "                            ON pd.Id_Color = cr.Id_Color \n"
                    + "                            INNER JOIN ProduccionPhy.dbo.Linea l \n"
                    + "                            ON pd.Id_Linea = l.Id_Linea \n"
                    + "                            INNER JOIN ProduccionPhy.dbo.Corrida crd \n"
                    + "                            ON pd.Id_Corrida = crd.Id_Corrida \n"
                    + "                            WHERE DATEPART(YEAR,p.Fecha_Entrega) = ? AND \n"
                    + "                            DATEPART(WK,p.Fecha_Entrega) = ?");
            dp.setInt(1, año);
            dp.setInt(2, semana);
            rs = dp.executeQuery();

            while (rs.next()) {
                Planeacion p = new Planeacion();
                p.setNumero(rs.getInt("Numero"));
                p.setNpedido(rs.getString("Pedido"));
                p.setCliente(rs.getString("Cliente"));
                p.setId_Cliente(rs.getInt("Id_Cliente"));
                p.setId_Agente(rs.getInt("Id_Agente"));
                p.setId_Producto(rs.getInt("Id_Producto"));
                p.setAgente(rs.getString("Agente"));
                p.setModelo(rs.getString("Modelo"));
                p.setColor(rs.getString("Color"));
                p.setId_Color(rs.getInt("Id_Color"));
                p.setId_Corrida(rs.getInt("Id_Corrida"));
                p.setC1(rs.getInt("C1"));
                p.setC2(rs.getInt("C2"));
                p.setC3(rs.getInt("C3"));
                p.setC4(rs.getInt("C4"));
                p.setC5(rs.getInt("C5"));
                p.setC6(rs.getInt("C6"));
                p.setC7(rs.getInt("C7"));
                p.setC8(rs.getInt("C8"));
                p.setC9(rs.getInt("C9"));
                p.setC10(rs.getInt("C10"));
                p.setC11(rs.getInt("C11"));
                p.setC12(rs.getInt("C12"));
                p.setPares(rs.getInt("TotalPares"));
                p.setObservaciones(rs.getString("Observaciones"));
                p.setOrdenCompra(rs.getString("OrdenCompra"));
                p.setEstatus(rs.getString("Estatus"));
                p.setPto1(rs.getString("Pto1"));
                p.setPto2(rs.getString("Pto2"));
                p.setPto3(rs.getString("Pto3"));
                p.setPto4(rs.getString("Pto4"));
                p.setPto5(rs.getString("Pto5"));
                p.setPto6(rs.getString("Pto6"));
                p.setPto7(rs.getString("Pto7"));
                p.setPto8(rs.getString("Pto8"));
                p.setPto9(rs.getString("Pto9"));
                p.setPto10(rs.getString("Pto10"));
                p.setPto11(rs.getString("Pto11"));
                p.setPto12(rs.getString("Pto12"));
                p.setSerie(rs.getString("Serie"));

                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    /*public boolean AddPlaneacionA(Planeacion p, String Estatus, String Npedido) {
        boolean rpta = false;
        try {
            String query1 = "INSERT INTO Programa(Programa,Mes,Fecha,Pares,Cont,Npedido,Cliente,Agente,Producto,"
                    + "Color,Corrida,Pto1,Pto2,Pto3,Pto4,Pto5,Pto6,Pto7,Pto8,Pto9,Pto10,Pto11,Pto12,Cant1,Cant2,Cant3,"
                    + "Cant4,Cant5,Cant6,Cant7,Cant8,Cant9,Cant10,Cant11,Cant12,Serie)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            String query2 = "UPDATE Pedidos SET Estatus ="+Estatus+" WHERE Npedido ="+ Npedido;
            
            String query3 = "UPDATE Dpedido SET Estatus ="+Estatus+" WHERE Npedido ="+ Npedido;
            pa.setAutoCommit(false);
            dp = pa.prepareStatement(query1);
            dp.setInt(1, p.getPrograma());
            dp.setString(2, p.getMes());
            dp.setDate(3, p.getFecha());
            dp.setInt(4, p.getPares());
            dp.setInt(5, p.getCont());
            dp.setString(6, p.getNpedido());
            dp.setInt(7, p.getId_Cliente());
            dp.setInt(8, p.getId_Agente());
            dp.setInt(9, p.getId_Producto());
            dp.setInt(10, p.getId_Color());
            dp.setInt(11, p.getId_Corrida());
            dp.setString(12, p.getPto1());
            dp.setString(13, p.getPto2());
            dp.setString(14, p.getPto3());
            dp.setString(15, p.getPto4());
            dp.setString(16, p.getPto5());
            dp.setString(17, p.getPto6());
            dp.setString(18, p.getPto7());
            dp.setString(19, p.getPto8());
            dp.setString(20, p.getPto9());
            dp.setString(21, p.getPto10());
            dp.setString(22, p.getPto11());
            dp.setString(23, p.getPto12());
            dp.setInt(24, p.getC1());
            dp.setInt(25, p.getC2());
            dp.setInt(26, p.getC3());
            dp.setInt(27, p.getC4());
            dp.setInt(28, p.getC5());
            dp.setInt(29, p.getC6());
            dp.setInt(30, p.getC7());
            dp.setInt(31, p.getC8());
            dp.setInt(32, p.getC9());
            dp.setInt(33, p.getC10());
            dp.setInt(34, p.getC11());
            dp.setInt(35, p.getC12());
            dp.setString(36, p.getSerie());
           
            rpta = dp.executeUpdate() == 1 ? true : false;

            if (rpta) {
                dp = pa.prepareStatement(query2);
                rpta = dp.executeUpdate() == 1 ? true : false;
                if (rpta) {
                    //FUNCIONA
                    dp = pa.prepareStatement(query3);
                    rpta = dp.executeUpdate() == 1 ? true : false;
                    pa.commit();
                    dp.close();
                } else {
                    pa.rollback();
                    dp.close();
                }
            } else {
                pa.rollback();
                dp.close();
            }
           dp.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.cerrarPhylonA(dp);
        }
        return rpta;
    }*/
    public boolean AddPlaneacionA(Planeacion p, String Estatus, String Npedido) {
        try {
            pa.setAutoCommit(false);
            c.setAutoCommit(false);
            st = pa.prepareStatement("INSERT INTO Programa(Programa,Mes,Fecha,Pares,Cont,Npedido,Cliente,Agente,Producto,"
                    + "Color,Corrida,Pto1,Pto2,Pto3,Pto4,Pto5,Pto6,Pto7,Pto8,Pto9,Pto10,Pto11,Pto12,Cant1,Cant2,Cant3,"
                    + "Cant4,Cant5,Cant6,Cant7,Cant8,Cant9,Cant10,Cant11,Cant12,Serie)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, p.getPrograma());
            st.setString(2, p.getMes());
            st.setDate(3, p.getFecha());
            st.setInt(4, p.getPares());
            st.setInt(5, p.getCont());
            st.setString(6, p.getNpedido());
            st.setInt(7, p.getId_Cliente());
            st.setInt(8, p.getId_Agente());
            st.setInt(9, p.getId_Producto());
            st.setInt(10, p.getId_Color());
            st.setInt(11, p.getId_Corrida());
            st.setString(12, p.getPto1());
            st.setString(13, p.getPto2());
            st.setString(14, p.getPto3());
            st.setString(15, p.getPto4());
            st.setString(16, p.getPto5());
            st.setString(17, p.getPto6());
            st.setString(18, p.getPto7());
            st.setString(19, p.getPto8());
            st.setString(20, p.getPto9());
            st.setString(21, p.getPto10());
            st.setString(22, p.getPto11());
            st.setString(23, p.getPto12());
            st.setInt(24, p.getC1());
            st.setInt(25, p.getC2());
            st.setInt(26, p.getC3());
            st.setInt(27, p.getC4());
            st.setInt(28, p.getC5());
            st.setInt(29, p.getC6());
            st.setInt(30, p.getC7());
            st.setInt(31, p.getC8());
            st.setInt(32, p.getC9());
            st.setInt(33, p.getC10());
            st.setInt(34, p.getC11());
            st.setInt(35, p.getC12());
            st.setString(36, p.getSerie());
            st.execute();

            st = pa.prepareStatement("UPDATE Pedidos SET Estatus =" + Estatus + "WHERE Npedido =" + Npedido);
            st.executeUpdate();

            st = pa.prepareStatement("UPDATE Dpedido SET Estatus =" + Estatus + "WHERE Npedido =" + Npedido);
            st.executeUpdate();

            pa.commit();
            dp.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Server.cerrarPrep(dp);
            Server.rollback(pa);
        }
        return false;
    }

    public boolean rolback(int programa) {
        try {
            dp = pa.prepareStatement("DELETE FROM Programa WHERE Programa = ?");
            dp.setInt(1, programa);
            dp.executeUpdate();
            Conexion.cerrarPhylonA(dp);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean CambiarEstatusA(String Estatus, String Npedido) {
        boolean rpta = false;
        try {
            pa.setAutoCommit(false);
            dp = pa.prepareStatement("UPDATE Pedidos SET Estatus = ? WHERE Npedido = ?");
            pa.setAutoCommit(false);
            dp.setString(1, Estatus);
            dp.setString(2, Npedido);
            //dp.executeUpdate();
            //Conexion.cerrarPhylonA(dp);
            //return true;
            rpta = dp.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rpta = obj.cambiarEstatusA(Npedido, Estatus);
                if (rpta) {
                    pa.commit();
                    dp.close();
                } else {
                    pa.rollback();
                    dp.close();
                }
            } else {
                pa.rollback();
                dp.close();
            }
            dp.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.rollback(pa);
            Conexion.cerrarPrep(dp);
            //return false;
        }
        return rpta;
    }

    public boolean CambiarEstatus(String Estatus, String Npedido) {
        try {
            c.setAutoCommit(false);
            //String query2 = "UPDATE Dpedido SET Estatus =" + Estatus + " WHERE Npedido =" + Npedido;
            st = c.prepareStatement("UPDATE Pedidos SET Estatus =" + Estatus + "WHERE Npedido =" + Npedido);
            st.executeUpdate();

            st = c.prepareStatement("UPDATE Dpedido SET Estatus =" + Estatus + "WHERE Npedido =" + Npedido);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
            //st.executeUpdate();
            //Conexion.cerrarPrep(st);
            //return true;
            //AQUI ESTA EL ERROR
        } catch (SQLException ex) {
            ex.printStackTrace();
            Server.rollback(c);
            Server.cerrarPrep(st);
        }
        return false;
    }
}
