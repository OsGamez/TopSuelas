package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ObjectPlaneacion {

    PreparedStatement st = null;
    Connection c = Conexion.getRcpt();
    ResultSet rs = null;

    public ArrayList<Planeacion> obtenerPlaneacion(int año, int mes, int semana) {
        ArrayList<Planeacion> lista = new ArrayList<Planeacion>();
        try {
            st = c.prepareStatement("DECLARE @v1 INT \n"
                    + "	SET @v1 = 0 \n"
                    + "SELECT \n"
                    + " ROW_NUMBER() OVER(ORDER BY p.Npedido) AS Numero, \n"
                    + " dp.Npedido as Pedido,\n"
                    + " c.RazonSocial as Cliente,c.Id_Cliente,a.Id_Agente,pd.Id_Producto,\n"
                    + " CASE WHEN a.Descripcion = 'JUAN LOPEZ' THEN 'J'\n"
                    + "	WHEN a.Descripcion = 'GERARDO' THEN 'G'\n"
                    + "	WHEN a.Descripcion = 'HORACIO H' THEN 'H'\n"
                    + "	WHEN a.Descripcion = 'IVAN GARCIA' THEN 'I' END AS Agente,\n"
                    + " l.Descripcion as Modelo,cr.Descripcion as Color,\n"
                    + " cr.Id_Color,crd.Id_Corrida\n"
                    + ",\n"
                    + "CASE \n"
                    + "	WHEN Corrida = '[11-14]' THEN C1\n"
                    + "	WHEN Corrida = '[15-17]' THEN @v1 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN @v1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN @v1 \n"
                    + "	WHEN Corrida = '[30-33]' THEN @v1 END AS '11',\n"
                    + "CASE \n"
                    + "	WHEN Corrida = '[11-14]' THEN C2\n"
                    + "	WHEN Corrida = '[15-17]' THEN @v1 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN @v1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN @v1 \n"
                    + "	WHEN Corrida = '[30-33]' THEN @v1 END AS '12',\n"
                    + "CASE \n"
                    + "	WHEN Corrida = '[11-14]' THEN C3\n"
                    + "	WHEN Corrida = '[15-17]' THEN @v1 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN @v1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN @v1 \n"
                    + "	WHEN Corrida = '[30-33]' THEN @v1 END AS '13',\n"
                    + "CASE \n"
                    + "	WHEN Corrida = '[11-14]' THEN C4\n"
                    + "	WHEN Corrida = '[15-17]' THEN @v1 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN @v1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN @v1\n"
                    + "	WHEN Corrida = '[30-33]' THEN @v1 END AS '14',\n"
                    + "CASE\n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN C1 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN @v1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN @v1 \n"
                    + "	WHEN Corrida = '[30-33]' THEN @v1 END AS '15',\n"
                    + "CASE \n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN C2 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN @v1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN @v1 \n"
                    + "	WHEN Corrida = '[30-33]' THEN @v1 END AS '16',\n"
                    + "CASE \n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN C3 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN @v1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN @v1\n"
                    + "	WHEN Corrida = '[30-33]' THEN @v1 END AS '17',\n"
                    + "CASE\n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN  @v1 WHEN Corrida = '[18-21]' THEN C1 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN @v1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN @v1 END AS '18',\n"
                    + "CASE \n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN  @v1 WHEN Corrida = '[18-21]' THEN C2 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN @v1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN @v1\n"
                    + "	WHEN Corrida = '[30-33]' THEN @v1 END AS '19',\n"
                    + "CASE \n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN  @v1 WHEN Corrida = '[18-21]' THEN C3 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN @v1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN @v1\n"
                    + "	WHEN Corrida = '[30-33]' THEN @v1 END AS '20',\n"
                    + "CASE \n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN  @v1 WHEN Corrida = '[18-21]' THEN C4 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN @v1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN @v1\n"
                    + "	WHEN Corrida = '[30-33]' THEN @v1 END AS '21',\n"
                    + "CASE \n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN  @v1 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN C1 WHEN Corrida = '[22-26]' THEN C1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN @v1\n"
                    + "	WHEN Corrida = '[30-33]' THEN @v1 END AS '22',\n"
                    + "CASE \n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN  @v1 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN C2 WHEN Corrida = '[22-26]' THEN C2\n"
                    + "	WHEN Corrida = '[23-26]' THEN C1 WHEN Corrida = '[25-30]' THEN @v1\n"
                    + "	WHEN Corrida = '[30-33]' THEN @v1 END AS '23',\n"
                    + "CASE \n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN  @v1 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN C3 WHEN Corrida = '[22-26]' THEN C3\n"
                    + "	WHEN Corrida = '[23-26]' THEN C2 WHEN Corrida = '[25-30]' THEN @v1\n"
                    + "	WHEN Corrida = '[30-33]' THEN @v1 END AS '24',\n"
                    + "CASE\n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN  @v1 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN C4\n"
                    + "	WHEN Corrida = '[23-26]' THEN C3 WHEN Corrida = '[25-30]' THEN C1\n"
                    + "	WHEN Corrida = '[30-33]' THEN @v1 END AS '25',\n"
                    + "CASE \n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN  @v1 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN C5\n"
                    + "	WHEN Corrida = '[23-26]' THEN C4 WHEN Corrida = '[25-30]' THEN C2\n"
                    + "	WHEN Corrida = '[30-33]' THEN @v1 END AS '26',\n"
                    + "CASE \n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN  @v1 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN @v1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN C3\n"
                    + "	WHEN Corrida = '[30-33]' THEN @v1 END AS '27',\n"
                    + "CASE \n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN  @v1 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN @v1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN C4\n"
                    + "	WHEN Corrida = '[30-33]' THEN @v1 END AS '28',\n"
                    + "CASE \n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN  @v1 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN @v1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN C5\n"
                    + "	WHEN Corrida = '[30-33]' THEN @v1 END AS '29',\n"
                    + "CASE \n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN  @v1 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN @v1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN C6\n"
                    + "	WHEN Corrida = '[30-33]' THEN C1 END AS '30',\n"
                    + "CASE\n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN  @v1 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN @v1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN @v1\n"
                    + "	WHEN Corrida = '[30-33]' THEN C2 END AS '31',\n"
                    + "CASE \n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN  @v1 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN @v1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN @v1\n"
                    + "	WHEN Corrida = '[30-33]' THEN C3 END AS '32',\n"
                    + "CASE\n"
                    + "	WHEN Corrida = '[11-14]' THEN @v1 WHEN Corrida = '[15-17]' THEN  @v1 WHEN Corrida = '[18-21]' THEN @v1 WHEN Corrida = '[22-24]' THEN @v1 WHEN Corrida = '[22-26]' THEN @v1\n"
                    + "	WHEN Corrida = '[23-26]' THEN @v1 WHEN Corrida = '[25-30]' THEN @v1\n"
                    + "	WHEN Corrida = '[30-33]' THEN C4 END AS '33',\n"
                    + "	dp.Pares AS TotalPares,p.Observaciones,p.OrdenCompra,dp.Estatus\n"
                    + "FROM Pedidos p INNER JOIN CobranzaPhy.dbo.Clientes c\n"
                    + "ON p.Id_Cliente = c.Id_Cliente\n"
                    + "INNER JOIN CobranzaPhy.dbo.Agentes a\n"
                    + "ON c.Id_Agente = a.Id_Agente\n"
                    + "INNER JOIN Dpedido dp \n"
                    + "ON p.Npedido = dp.Npedido\n"
                    + "INNER JOIN ProduccionPhy.dbo.Producto pd\n"
                    + "ON dp.Id_Producto = pd.Id_Producto\n"
                    + "INNER JOIN ProduccionPhy.dbo.Color cr\n"
                    + "ON pd.Id_Color = cr.Id_Color\n"
                    + "INNER JOIN ProduccionPhy.dbo.Linea l\n"
                    + "ON pd.Id_Linea = l.Id_Linea\n"
                    + "INNER JOIN ProduccionPhy.dbo.Corrida crd\n"
                    + "ON pd.Id_Corrida = crd.Id_Corrida\n"
                    + "WHERE DATEPART(YEAR,p.Fecha_Entrega) = ? AND DATEPART(MONTH,p.Fecha_Entrega) = ? AND\n"
                    + "DATEPART(WK,p.Fecha_Entrega) = ?");
            st.setInt(1, año);
            st.setInt(2, mes);
            st.setInt(3, semana);
            rs = st.executeQuery();
            
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
                p.setC11(rs.getInt("11"));
                p.setC12(rs.getInt("12"));
                p.setC13(rs.getInt("13"));
                p.setC14(rs.getInt("14"));
                p.setC15(rs.getInt("15"));
                p.setC16(rs.getInt("16"));
                p.setC17(rs.getInt("17"));
                p.setC18(rs.getInt("18"));
                p.setC19(rs.getInt("19"));
                p.setC20(rs.getInt("20"));
                p.setC21(rs.getInt("21"));
                p.setC22(rs.getInt("22"));
                p.setC23(rs.getInt("23"));
                p.setC24(rs.getInt("24"));
                p.setC25(rs.getInt("25"));
                p.setC26(rs.getInt("26"));
                p.setC27(rs.getInt("27"));
                p.setC28(rs.getInt("28"));
                p.setC29(rs.getInt("29"));
                p.setC30(rs.getInt("30"));
                p.setC31(rs.getInt("31"));
                p.setC32(rs.getInt("32"));
                p.setC33(rs.getInt("33"));
                p.setPares(rs.getInt("TotalPares"));
                p.setObservaciones(rs.getString("Observaciones"));
                p.setOrdenCompra(rs.getString("OrdenCompra"));
                
               lista.add(p);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

}
