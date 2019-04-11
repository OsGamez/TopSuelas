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

public class ObjectPlaneacion {

    PreparedStatement st = null, dp = null;
    ObjectDetalle obj = new ObjectDetalle();

    Connection pa = Conexion.getRcpt();
    Connection c = Conexion.getRpt();
    ResultSet rs = null;

    public ArrayList<Planeacion> obtenerPlaneacion(int año, int semana) {
        ArrayList<Planeacion> lista = new ArrayList<Planeacion>();
        try {
            dp = pa.prepareStatement("DECLARE @v1 INT \n"
                    + "         SET @v1 = 0 \n"
                    + "         SELECT \n"
                    + "         ROW_NUMBER() OVER(ORDER BY p.Npedido) AS Numero, \n"
                    + "         dp.Npedido as Pedido,\n"
                    + "         c.RazonSocial as Cliente,c.Id_Cliente,a.Id_Agente,pd.Id_Producto,\n"
                    + "         CASE WHEN a.Descripcion = 'JUAN LOPEZ' THEN 'J'\n"
                    + "         WHEN a.Descripcion = 'GERARDO' THEN 'G'\n"
                    + "         WHEN a.Descripcion = 'HORACIO H' THEN 'H'\n"
                    + "         WHEN a.Descripcion = 'IVAN GARCIA' THEN 'I' END AS Agente,\n"
                    + "         l.Descripcion as Modelo,cr.Descripcion as Color,\n"
                    + "         cr.Id_Color,crd.Id_Corrida,\n"
                    + "         dp.C1,dp.C2,dp.C3,dp.C4,dp.C5,dp.C6\n"
                    + "          ,\n"
                    + "		CASE \n"
                    + "			WHEN Corrida = '[15-17]' THEN 15\n"
                    + "			WHEN Corrida = '[18-21]' THEN 18\n"
                    + "			WHEN Corrida = '[22-24]' THEN 22 \n"
                    + "			WHEN Corrida = '[22-26]' THEN 22\n"
                    + "			WHEN Corrida = '[23-26]' THEN 23\n"
                    + "			WHEN Corrida = '[25-30]' THEN 25\n"
                    + "			END AS 'Pto1',\n"
                    + "		CASE \n"
                    + "			WHEN Corrida = '[15-17]' THEN 16\n"
                    + "			WHEN Corrida = '[18-21]' THEN 19\n"
                    + "			WHEN Corrida = '[22-24]' THEN 23 \n"
                    + "			WHEN Corrida = '[22-26]' THEN 23\n"
                    + "			WHEN Corrida = '[23-26]' THEN 24\n"
                    + "			WHEN Corrida = '[25-30]' THEN 26\n"
                    + "			END AS 'Pto2',\n"
                    + "		CASE \n"
                    + "			WHEN Corrida = '[15-17]' THEN 17\n"
                    + "			WHEN Corrida = '[18-21]' THEN 20\n"
                    + "			WHEN Corrida = '[22-24]' THEN 24 \n"
                    + "			WHEN Corrida = '[22-26]' THEN 24\n"
                    + "			WHEN Corrida = '[23-26]' THEN 25\n"
                    + "			WHEN Corrida = '[25-30]' THEN 27\n"
                    + "			END AS 'Pto3',\n"
                    + "			CASE \n"
                    + "			WHEN Corrida = '[15-17]' THEN 0\n"
                    + "			WHEN Corrida = '[18-21]' THEN 21\n"
                    + "			WHEN Corrida = '[22-24]' THEN 0 \n"
                    + "			WHEN Corrida = '[22-26]' THEN 25\n"
                    + "			WHEN Corrida = '[23-26]' THEN 26\n"
                    + "			WHEN Corrida = '[25-30]' THEN 28\n"
                    + "			END AS 'Pto4',\n"
                    + "			CASE \n"
                    + "			WHEN Corrida = '[15-17]' THEN 0\n"
                    + "			WHEN Corrida = '[18-21]' THEN 0\n"
                    + "			WHEN Corrida = '[22-24]' THEN 0 \n"
                    + "			WHEN Corrida = '[22-26]' THEN 26\n"
                    + "			WHEN Corrida = '[23-26]' THEN 0\n"
                    + "			WHEN Corrida = '[25-30]' THEN 29\n"
                    + "			END AS 'Pto5',\n"
                    + "			CASE \n"
                    + "			WHEN Corrida = '[15-17]' THEN 0\n"
                    + "			WHEN Corrida = '[18-21]' THEN 0\n"
                    + "			WHEN Corrida = '[22-24]' THEN 0 \n"
                    + "			WHEN Corrida = '[22-26]' THEN 0\n"
                    + "			WHEN Corrida = '[23-26]' THEN 0\n"
                    + "			WHEN Corrida = '[25-30]' THEN 30\n"
                    + "			END AS 'Pto6',\n"
                    + "         dp.Pares AS TotalPares,p.Observaciones,p.OrdenCompra,dp.Estatus,p.Serie\n"
                    + "         FROM Pedidos p INNER JOIN CobranzaPhy.dbo.Clientes c\n"
                    + "         ON p.Id_Cliente = c.Id_Cliente\n"
                    + "         INNER JOIN CobranzaPhy.dbo.Agentes a\n"
                    + "         ON c.Id_Agente = a.Id_Agente\n"
                    + "         INNER JOIN Dpedido dp \n"
                    + "         ON p.Npedido = dp.Npedido\n"
                    + "         INNER JOIN ProduccionPhy.dbo.Producto pd\n"
                    + "         ON dp.Id_Producto = pd.Id_Producto\n"
                    + "         INNER JOIN ProduccionPhy.dbo.Color cr\n"
                    + "         ON pd.Id_Color = cr.Id_Color\n"
                    + "         INNER JOIN ProduccionPhy.dbo.Linea l\n"
                    + "         ON pd.Id_Linea = l.Id_Linea\n"
                    + "         INNER JOIN ProduccionPhy.dbo.Corrida crd\n"
                    + "         ON pd.Id_Corrida = crd.Id_Corrida\n"
                    + "         WHERE DATEPART(YEAR,p.Fecha_Entrega) = ? AND\n"
                    + "         DATEPART(WK,p.Fecha_Entrega) = ?");
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
                p.setPares(rs.getInt("TotalPares"));
                p.setObservaciones(rs.getString("Observaciones"));
                p.setOrdenCompra(rs.getString("OrdenCompra"));
                p.setEstatus(rs.getString("Estatus"));
                p.setPto1(rs.getInt("Pto1"));
                p.setPto2(rs.getInt("Pto2"));
                p.setPto3(rs.getInt("Pto3"));
                p.setPto4(rs.getInt("Pto4"));
                p.setPto5(rs.getInt("Pto5"));
                p.setPto6(rs.getInt("Pto6"));
                p.setSerie(rs.getString("Serie"));

                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean AddPlaneacionA(Planeacion p, String Estatus, String Npedido) {
        boolean rpta = false;
        try {
            dp = pa.prepareStatement("INSERT INTO Programa(Programa,Mes,Fecha,Pares,Cont,Npedido,Cliente,Agente,Producto,"
                    + "Color,Corrida,Pto1,Pto2,Pto3,Pto4,Pto5,Pto6,Pto7,Pto8,Pto9,Pto10,Pto11,Pto12,Cant1,Cant2,Cant3,"
                    + "Cant4,Cant5,Cant6,Cant7,Cant8,Cant9,Cant10,Cant11,Cant12,Serie)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pa.setAutoCommit(false);
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
            dp.setInt(12, p.getPto1());
            dp.setInt(13, p.getPto2());
            dp.setInt(14, p.getPto3());
            dp.setInt(15, p.getPto4());
            dp.setInt(16, p.getPto5());
            dp.setInt(17, p.getPto6());
            dp.setInt(18, p.getPto7());
            dp.setInt(19, p.getPto8());
            dp.setInt(20, p.getPto9());
            dp.setInt(21, p.getPto10());
            dp.setInt(22, p.getPto11());
            dp.setInt(23, p.getPto12());
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
                rpta = CambiarEstatusA(Estatus, Npedido);
                if (rpta) {
                    pa.commit();
                } else {
                    Conexion.rollbackA(pa);
                }
            } else {
                Conexion.rollbackA(pa);
            }
            Conexion.cerrarPhylonA(dp);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.cerrarPhylonA(dp);
        }
        return rpta;
    }

    public boolean CambiarEstatusA(String Estatus, String Npedido) {
        boolean rpta = false;
        try {
            dp = pa.prepareStatement("UPDATE Pedidos SET Estatus = ? WHERE Npedido = ?");
            pa.setAutoCommit(false);
            dp.setString(1, Estatus);
            dp.setString(2, Npedido);
            rpta = dp.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rpta = obj.cambiarEstatusA(Npedido, Estatus);
                if (rpta) {
                    pa.commit();
                } else {
                    Conexion.rollbackA(pa);
                }
            } else {
                Conexion.rollbackA(pa);
            }
            Conexion.cerrarPhylonA(dp);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rpta;
    }

    public boolean CambiarEstatus(String Estatus, String Npedido) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("UPDATE Pedidos SET Estatus = ? WHERE Npedido = ?");
            c.setAutoCommit(false);
            st.setString(1, Estatus);
            st.setString(2, Npedido);
            rpta = st.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rpta = obj.cambiarEstatus(Npedido, Estatus);
                if (rpta) {
                    c.commit();
                } else {
                    Conexion.rollback(c);
                }
            } else {
                Conexion.rollback(c);
            }
            Conexion.cerrarPrep(st);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rpta;
    }

}
