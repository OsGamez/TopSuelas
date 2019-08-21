package ObjectLayer;

import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectKardex {

    PreparedStatement st = null;
    ResultSet rs = null;
    Connection c = Server.getRcpt();

    public boolean kardexAdd(Kardex kx) {
        try {
            c.setAutoCommit(false);
            String query = "INSERT INTO Kardex(Almacen,Producto,Folio,FMovimiento,Renglon,DocumentoRef,Nvale,Cl_Prv\n"
                + ",Cuenta,SubCuenta,TotalPares,PCosto,PVenta,ImporteCosto,Cantidad1,Cantidad2,Cantidad3\n"
                + ",Cantidad4,Cantidad5,Cantidad6,Cantidad7,Cantidad8,Cantidad9,Cantidad10,Cantidad11\n"
                + ",Cantidad12,StockPedidos,StatusSalida,Observaciones,StatusImpresion,Npedido,RenglonP\n"
                + ",OCompra,CveConsignatario,TipoDivisa,TipoCambio,Factura,Serie ,Usuario,Registro)\n"
                + "     VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            st = c.prepareStatement(query);
            st.setInt(1, kx.getAlmacen());
            st.setInt(2, kx.getProducto());
            st.setInt(3, kx.getFolio());
            st.setDate(4, kx.getFMovimiento());
            st.setInt(5, kx.getRenglon());
            st.setString(6, kx.getDocumentoRef());
            st.setInt(7, kx.getNvale());
            st.setInt(8, kx.getCI_Pvr());
            st.setString(9, kx.getCuenta());
            st.setString(10, kx.getSubCuenta());
            st.setInt(11, kx.getTotalPares());
            st.setDouble(12, kx.getPCosto());
            st.setDouble(13, kx.getPVenta());
            st.setDouble(14, kx.getImporteCosto());
            st.setInt(15, kx.getCantidad1());
            st.setInt(16, kx.getCantidad2());
            st.setInt(17, kx.getCantidad3());
            st.setInt(18, kx.getCantidad4());
            st.setInt(19, kx.getCantidad5());
            st.setInt(20, kx.getCantidad6());
            st.setInt(21, kx.getCantidad7());
            st.setInt(22, kx.getCantidad8());
            st.setInt(23, kx.getCantidad9());
            st.setInt(24, kx.getCantidad10());
            st.setInt(25, kx.getCantidad11());
            st.setInt(26, kx.getCantidad12());
            st.setString(27, kx.getStockPedidos());
            st.setString(28, kx.getStatusSalida());
            st.setString(29, kx.getObservaciones());
            st.setString(30, kx.getStatusImpresion());
            st.setString(31, kx.getNpedido());
            st.setInt(32, kx.getRenglonP());
            st.setString(33, kx.getOCompra());
            st.setInt(34, kx.getCveConsignatario());
            st.setInt(35, kx.getTipoDivisa());
            st.setDouble(36, kx.getTipoCambio());
            st.setString(37, kx.getFactura());
            st.setString(38, kx.getSerie());
            st.setString(39, kx.getUsuario());
            st.setDate(40, kx.getRegistro());
            st.execute();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            Server.cerrarPrep(st);
            Server.rollback(c);
        }
        return false;
    }
}
