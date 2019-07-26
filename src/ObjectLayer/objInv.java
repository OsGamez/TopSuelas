
package ObjectLayer;


import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class objInv {
 
    Connection c = Server.getRcpt();
    ResultSet rs = null;
    PreparedStatement st = null;
    
    public ArrayList<invFolio> getInv() {
        ArrayList<invFolio> list = new ArrayList<>();
        try {
            st = c.prepareStatement("SELECT * FROM EncInvxPistola ORDER BY Folio");
            rs = st.executeQuery();
            while (rs.next()) {
                invFolio inv = new invFolio();
                inv.setFolio(rs.getInt("Folio"));
                inv.setFecha(rs.getDate("Fecha"));
                inv.setAlmacen(rs.getInt("Almacen"));
                inv.setEstatus(rs.getString("Estatus"));
                inv.setTipo(rs.getString("Tipo"));
                inv.setPares(rs.getInt("Pares"));
                inv.setEstado(rs.getBoolean("Estado"));
                list.add(inv);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Folio> getFolioById(int id) {
        ArrayList<Folio> listaF = new ArrayList<>();
        try {
            st = c.prepareStatement("SELECT * FROM foliostemp WHERE Folio = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            
            while (rs.next()) {
                Folio f = new Folio();
                f.setAlmacen(rs.getInt("Almacen"));
                f.setProducto(rs.getInt("Producto"));
                f.setCorrida(rs.getInt("Corrida"));
                f.setCombinacion(rs.getInt("Combinacion"));
                f.setEstilo(rs.getInt("Estilo"));
                f.setTipo(rs.getString("Tipo"));
                f.setPto1(rs.getInt("Pto1"));
                f.setPto2(rs.getInt("Pto2"));
                f.setPto3(rs.getInt("Pto3"));
                f.setPto4(rs.getInt("Pto4"));
                f.setPto5(rs.getInt("Pto5"));
                f.setPto6(rs.getInt("Pto6"));
                f.setPto7(rs.getInt("Pto7"));
                f.setPto8(rs.getInt("Pto8"));
                f.setPto9(rs.getInt("Pto9"));
                f.setPto10(rs.getInt("Pto10"));
                f.setPto11(rs.getInt("Pto11"));
                f.setPto12(rs.getInt("Pto12"));
                f.setPto13(rs.getInt("Pto13"));
                f.setPto14(rs.getInt("Pto14"));
                f.setTotalPares(rs.getInt("TotalPares"));
                listaF.add(f);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaF;
    }
    
    public int validarEnvio() {
        try {
            st = c.prepareStatement("SELECT COUNT(Estatus) FROM EncInvxPistola WHERE Estatus = 'V'");
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
    
    public boolean updateFolioxPistola(int folio){
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE EncInvxPistola SET Estatus = 'A' WHERE Folio="+ folio);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Server.cerrarPrep(st);
            Server.rollback(c);
        }
        return false;
    }
    
}
