package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectDetalle {

    //Connection c = Server.getRpt();
    //Connection p = Server.getRcpt();
    Connection c = Conexion.getRpt();
    Connection p = Conexion.getRcpt();

    PreparedStatement st, dp = null;
    ResultSet rs = null;

    public boolean insertDetalle(Dpedido detalle) throws SQLException {

        boolean rpta = false;
        try {
            st = c.prepareStatement("INSERT INTO Dpedido (Renglon,Npedido, Id_Cliente,Fecha_Pedido,Fecha_Entrega, "
                    + "Id_Producto,Corrida,C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,Pares,Importe,Serie,CSurt1,CSurt2,CSurt3,"
                    + "CSurt4,CSurt5,CSurt6,CSurt7,CSurt8,CSurt9,CSurt10,CSurt11,CSurt12,ParesSurt,Estatus,Precio)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            st.setInt(1, detalle.getRenglon());
            st.setString(2, detalle.getNpedido());
            st.setInt(3, detalle.getId_Cliente());
            st.setDate(4, detalle.getFecha_Pedido());
            st.setDate(5, detalle.getFecha_Entrega());
            st.setInt(6, detalle.getId_Producto());
            st.setString(7, detalle.getCorrida());
            st.setInt(8, detalle.getC1());
            st.setInt(9, detalle.getC2());
            st.setInt(10, detalle.getC3());
            st.setInt(11, detalle.getC4());
            st.setInt(12, detalle.getC5());
            st.setInt(13, detalle.getC6());
            st.setInt(14, detalle.getC7());
            st.setInt(15, detalle.getC8());
            st.setInt(16, detalle.getC9());
            st.setInt(17, detalle.getC10());
            st.setInt(18, detalle.getC11());
            st.setInt(19, detalle.getC12());
            st.setInt(20, detalle.getPares());
            st.setDouble(21, detalle.getImporte());
            st.setString(22, detalle.getSerie());
            st.setInt(23, detalle.getCSurt1());
            st.setInt(24, detalle.getCSurt2());
            st.setInt(25, detalle.getCSurt3());
            st.setInt(26, detalle.getCSurt4());
            st.setInt(27, detalle.getCSurt5());
            st.setInt(28, detalle.getCSurt6());
            st.setInt(29, detalle.getCSurt7());
            st.setInt(30, detalle.getCSurt8());
            st.setInt(31, detalle.getCSurt9());
            st.setInt(32, detalle.getCSurt10());
            st.setInt(33, detalle.getCSurt11());
            st.setInt(34, detalle.getCSurt12());
            st.setInt(35, detalle.getParesSurt());
            st.setString(36, detalle.getStatus());
            st.setDouble(37, detalle.getPrecio());

            rpta = st.executeUpdate() == 1 ? true : false;
            Conexion.cerrarPrep(st);
        } catch (SQLException e) {

            e.printStackTrace();
            Conexion.cerrarPrep(st);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
        }
        return rpta;
    }

    public boolean insertDetalleA(Dpedido detalle) throws SQLException {

        boolean rpta = false;
        try {
            dp = p.prepareStatement("INSERT INTO Dpedido (Renglon,Npedido, Id_Cliente,Fecha_Pedido,Fecha_Entrega, "
                    + "Id_Producto,Corrida,C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,Pares,Importe,Serie,CSurt1,CSurt2,CSurt3,"
                    + "CSurt4,CSurt5,CSurt6,CSurt7,CSurt8,CSurt9,CSurt10,CSurt11,CSurt12,ParesSurt,Estatus,Precio)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            dp.setInt(1, detalle.getRenglon());
            dp.setString(2, detalle.getNpedido());
            dp.setInt(3, detalle.getId_Cliente());
            dp.setDate(4, detalle.getFecha_Pedido());
            dp.setDate(5, detalle.getFecha_Entrega());
            dp.setInt(6, detalle.getId_Producto());
            dp.setString(7, detalle.getCorrida());
            dp.setInt(8, detalle.getC1());
            dp.setInt(9, detalle.getC2());
            dp.setInt(10, detalle.getC3());
            dp.setInt(11, detalle.getC4());
            dp.setInt(12, detalle.getC5());
            dp.setInt(13, detalle.getC6());
            dp.setInt(14, detalle.getC7());
            dp.setInt(15, detalle.getC8());
            dp.setInt(16, detalle.getC9());
            dp.setInt(17, detalle.getC10());
            dp.setInt(18, detalle.getC11());
            dp.setInt(19, detalle.getC12());
            dp.setInt(20, detalle.getPares());
            dp.setDouble(21, detalle.getImporte());
            dp.setString(22, detalle.getSerie());
            dp.setInt(23, detalle.getCSurt1());
            dp.setInt(24, detalle.getCSurt2());
            dp.setInt(25, detalle.getCSurt3());
            dp.setInt(26, detalle.getCSurt4());
            dp.setInt(27, detalle.getCSurt5());
            dp.setInt(28, detalle.getCSurt6());
            dp.setInt(29, detalle.getCSurt7());
            dp.setInt(30, detalle.getCSurt8());
            dp.setInt(31, detalle.getCSurt9());
            dp.setInt(32, detalle.getCSurt10());
            dp.setInt(33, detalle.getCSurt11());
            dp.setInt(34, detalle.getCSurt12());
            dp.setInt(35, detalle.getParesSurt());
            dp.setString(36, detalle.getStatus());
            dp.setDouble(37, detalle.getPrecio());

            rpta = dp.executeUpdate() == 1 ? true : false;
            Conexion.cerrarPhylonA(dp);
        } catch (SQLException e) {
            e.printStackTrace();
            Conexion.cerrarPhylonA(dp);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPhylonA(dp);
        }
        return rpta;
    }

    public boolean insertNuevo(Dpedido detalle) throws SQLException {

        boolean rpta = false;
        try {
            st = c.prepareStatement("INSERT INTO Dpedido (Renglon,Npedido, Id_Cliente,Fecha_Pedido,Fecha_Entrega, "
                    + "Id_Producto,Corrida,C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,Pares,Importe,Serie,CSurt1,CSurt2,CSurt3,"
                    + "CSurt4,CSurt5,CSurt6,CSurt7,CSurt8,CSurt9,CSurt10,CSurt11,CSurt12,ParesSurt,Estatus,Precio)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, detalle.getRenglon());
            st.setString(2, detalle.getNpedido());
            st.setInt(3, detalle.getId_Cliente());
            st.setDate(4, detalle.getFecha_Pedido());
            st.setDate(5, detalle.getFecha_Entrega());
            st.setInt(6, detalle.getId_Producto());
            st.setString(7, detalle.getCorrida());
            st.setInt(8, detalle.getC1());
            st.setInt(9, detalle.getC2());
            st.setInt(10, detalle.getC3());
            st.setInt(11, detalle.getC4());
            st.setInt(12, detalle.getC5());
            st.setInt(13, detalle.getC6());
            st.setInt(14, detalle.getC7());
            st.setInt(15, detalle.getC8());
            st.setInt(16, detalle.getC9());
            st.setInt(17, detalle.getC10());
            st.setInt(18, detalle.getC11());
            st.setInt(19, detalle.getC12());
            st.setInt(20, detalle.getPares());
            st.setDouble(21, detalle.getImporte());
            st.setString(22, detalle.getSerie());
            st.setInt(23, detalle.getCSurt1());
            st.setInt(24, detalle.getCSurt2());
            st.setInt(25, detalle.getCSurt3());
            st.setInt(26, detalle.getCSurt4());
            st.setInt(27, detalle.getCSurt5());
            st.setInt(28, detalle.getCSurt6());
            st.setInt(29, detalle.getCSurt7());
            st.setInt(30, detalle.getCSurt8());
            st.setInt(31, detalle.getCSurt9());
            st.setInt(32, detalle.getCSurt10());
            st.setInt(33, detalle.getCSurt11());
            st.setInt(34, detalle.getCSurt12());
            st.setInt(35, detalle.getParesSurt());
            st.setString(36, detalle.getStatus());
            st.setDouble(37, detalle.getPrecio());

            rpta = st.executeUpdate() == 1 ? true : false;
            Conexion.cerrarPrep(st);
        } catch (SQLException e) {

            e.printStackTrace();
            Conexion.cerrarPrep(st);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
        }
        return rpta;
    }

    public boolean actualizarDetalle(Dpedido detalle) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("UPDATE Dpedido SET C1=?,C2=?,C3=?,C4=?,C5=?,C6=?,C7=?,C8=?,C9=?,C10=?,C11=?,C12=?,Pares=?,Importe=? "
                    + "WHERE Renglon=? AND Npedido=?");
            st.setInt(1, detalle.getC1());
            st.setInt(2, detalle.getC2());
            st.setInt(3, detalle.getC3());
            st.setInt(4, detalle.getC4());
            st.setInt(5, detalle.getC5());
            st.setInt(6, detalle.getC6());
            st.setInt(7, detalle.getC7());
            st.setInt(8, detalle.getC8());
            st.setInt(9, detalle.getC9());
            st.setInt(10, detalle.getC10());
            st.setInt(11, detalle.getC11());
            st.setInt(12, detalle.getC12());
            st.setInt(13, detalle.getPares());
            st.setDouble(14, detalle.getImporte());
            st.setInt(15, detalle.getRenglon());
            st.setString(16, detalle.getNpedido());

            rpta = st.executeUpdate() == 1 ? true : false;
            Conexion.cerrarPrep(st);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
        }
        return rpta;
    }

    public boolean actualizarDetalleA(Dpedido detalle) {
        boolean rpta = false;
        try {
            dp = p.prepareStatement("UPDATE Dpedido SET C1=?,C2=?,C3=?,C4=?,C5=?,C6=?,C7=?,C8=?,C9=?,C10=?,C11=?,C12=?,Pares=?,Importe=? "
                    + "WHERE Renglon=? AND Npedido=?");

            dp.setInt(1, detalle.getC1());
            dp.setInt(2, detalle.getC2());
            dp.setInt(3, detalle.getC3());
            dp.setInt(4, detalle.getC4());
            dp.setInt(5, detalle.getC5());
            dp.setInt(6, detalle.getC6());
            dp.setInt(7, detalle.getC7());
            dp.setInt(8, detalle.getC8());
            dp.setInt(9, detalle.getC9());
            dp.setInt(10, detalle.getC10());
            dp.setInt(11, detalle.getC11());
            dp.setInt(12, detalle.getC12());
            dp.setInt(13, detalle.getPares());
            dp.setDouble(14, detalle.getImporte());
            dp.setInt(15, detalle.getRenglon());
            dp.setString(16, detalle.getNpedido());
            rpta = dp.executeUpdate() == 1 ? true : false;
            Conexion.cerrarPhylonA(dp);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.cerrarPhylonA(dp);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPhylonA(dp);
        }
        return rpta;
    }

    public boolean eliminarDetalle(int id, String Npedido) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("DELETE FROM Dpedido WHERE Renglon=? AND Npedido=?");
            st.setInt(1, id);
            st.setString(2, Npedido);
            rpta = st.executeUpdate() == 1 ? true : false;
            Conexion.cerrarPrep(st);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
        }
        return rpta;
    }

    public boolean eliminarDetalleA(int id, String Npedido) {
        boolean rpta = false;
        try {
            dp = p.prepareStatement("DELETE FROM Dpedido WHERE Renglon=? AND Npedido=?");
            dp.setInt(1, id);
            dp.setString(2, Npedido);
            rpta = dp.executeUpdate() == 1 ? true : false;
            Conexion.cerrarPhylonA(dp);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.cerrarPhylonA(dp);
        } catch (Exception ex) {
            Conexion.cerrarPhylonA(dp);
            ex.printStackTrace();
        }
        return rpta;
    }

    public boolean cambiarEstatusA(String Npedido, String Estatus) {
        boolean rpta = false;
        try {
            dp = p.prepareStatement("UPDATE Dpedido SET Estatus = ? WHERE Npedido = ?");
            dp.setString(1, Estatus);
            dp.setString(2, Npedido);
            rpta = dp.executeUpdate() == 1 ? true : false;
            Conexion.cerrarPhylonA(dp);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.cerrarPhylonA(dp);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPhylonA(dp);
        }
        return rpta;
    }

    public boolean cambiarEstatus(String Npedido, String Estatus) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("UPDATE Dpedido SET Estatus = ? WHERE Npedido = ?");
            st.setString(1, Estatus);
            st.setString(2, Npedido);
            rpta = st.executeUpdate() == 1 ? true : false;
            Conexion.cerrarPrep(st);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
        } catch (Exception ex) {
            ex.printStackTrace();
            Conexion.cerrarPrep(st);
        }
        return rpta;
    }
}
