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

public class ObjectGastos {

    PreparedStatement st = null;
    Connection c = Server.getProduccion();
    ResultSet rs = null;

    public boolean gastoAdd(Gasto g) {
        try {
            st = c.prepareStatement("INSERT INTO Gastos(Mes,Año,Mo,Gf,Ga,Mi)"
                    + "VALUES(?,?,?,?,?,?)");
            st.setString(1, g.getMes());
            st.setInt(2, g.getAño());
            st.setDouble(3, g.getMo());
            st.setDouble(4, g.getGf());
            st.setDouble(5, g.getGa());
            st.setDouble(6, g.getMi());
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObjectGastos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public ArrayList<Gasto> gastoGetAll() {
        ArrayList<Gasto> listaGastos = new ArrayList<Gasto>();
        try {
            st = c.prepareStatement("SELECT Año,\n" +
"\n" +
"CASE WHEN Mes = 1 THEN 'ENERO'\n" +
"	 WHEN Mes = 2 THEN 'FEBRERO'\n" +
"	 WHEN Mes = 3 THEN 'MARZO'\n" +
"	 WHEN Mes = 4 THEN 'ABRIL'\n" +
"	 WHEN Mes = 5 THEN 'MAYO'\n" +
"	 WHEN Mes = 6 THEN 'JUNIO'\n" +
"	 WHEN Mes = 7 THEN 'JULIO'\n" +
"	 WHEN Mes = 8 THEN 'AGOSTO'\n" +
"	 WHEN Mes = 9 THEN 'SEPTIEMBRE'\n" +
"	 WHEN Mes = 10 THEN 'OCTUBRE'\n" +
"	 WHEN Mes = 11 THEN 'NOVIEMBRE'\n" +
"	 WHEN Mes = 12 THEN 'DICIEMBRE'\n" +
"\n" +
"END AS MES \n" +
"	,Mo,Gf,Ga,Mi\n" +
"	FROM Gastos\n" +
"order by Año");
            rs = st.executeQuery();
            while (rs.next()) {
                Gasto gs = new Gasto();
                gs.setAño(rs.getInt("Año"));
                gs.setMes(rs.getString("Mes"));
                gs.setMo(rs.getDouble("Mo"));
                gs.setGf(rs.getDouble("Gf"));
                gs.setGa(rs.getDouble("Ga"));
                gs.setMi(rs.getDouble("Mi"));
                listaGastos.add(gs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaGastos;
    }

    public ArrayList<Gasto> gastoSearch(String filtro) {
        ArrayList<Gasto> listaGastos = new ArrayList<Gasto>();
        try {
            st = c.prepareStatement("SELECT Año,\n" +
"\n" +
"CASE WHEN Mes = 1 THEN 'ENERO'\n" +
"	 WHEN Mes = 2 THEN 'FEBRERO'\n" +
"	 WHEN Mes = 3 THEN 'MARZO'\n" +
"	 WHEN Mes = 4 THEN 'ABRIL'\n" +
"	 WHEN Mes = 5 THEN 'MAYO'\n" +
"	 WHEN Mes = 6 THEN 'JUNIO'\n" +
"	 WHEN Mes = 7 THEN 'JULIO'\n" +
"	 WHEN Mes = 8 THEN 'AGOSTO'\n" +
"	 WHEN Mes = 9 THEN 'SEPTIEMBRE'\n" +
"	 WHEN Mes = 10 THEN 'OCTUBRE'\n" +
"	 WHEN Mes = 11 THEN 'NOVIEMBRE'\n" +
"	 WHEN Mes = 12 THEN 'DICIEMBRE'\n" +
"\n" +
"END AS MES \n" +
"	,Mo,Gf,Ga,Mi\n" +
"	FROM Gastos WHERE Año LIKE'%"+ filtro+"%'\n" +
"order by Año");
            rs = st.executeQuery();

            while (rs.next()) {
                Gasto gs = new Gasto();
                gs.setAño(rs.getInt("Año"));
                gs.setMes(rs.getString("Mes"));
                gs.setMo(rs.getDouble("Mo"));
                gs.setGf(rs.getDouble("Gf"));
                gs.setGa(rs.getDouble("Ga"));
                gs.setMi(rs.getDouble("Mi"));
                listaGastos.add(gs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaGastos;
    }

    public boolean gastoUpdate(Gasto g) {
        try {
            st = c.prepareStatement("UPDATE Gastos SET Mo=?,Gf=?,Ga=?,Mi=? WHERE Mes=? AND Año = ?");

            st.setDouble(1, g.getMo());
            st.setDouble(2, g.getGf());
            st.setDouble(3, g.getGa());
            st.setDouble(4, g.getMi());
            st.setString(5, g.getMes());
            st.setInt(6, g.getAño());

            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean gastoDelete(String Mes, int Año) {
        try {
            st = c.prepareStatement("DELETE FROM Gastos WHERE Mes = ? AND Año = ?");
            st.setString(1, Mes);
            st.setInt(2, Año);
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public int validarGasto(int Año, String Mes) {
        try {
            st = c.prepareStatement("SELECT COUNT(Año)  FROM Gastos WHERE Año = ? AND Mes = ?");
            st.setInt(1, Año);
            st.setString(2, Mes);
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
}
