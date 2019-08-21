
package ObjectLayer;

import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ObjExistenciasStock {
   
    PreparedStatement st = null;
    ResultSet rs = null;
    Connection c = Server.getRcpt();
    
    public boolean AddExistencia(ExistenciasStock e){
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("INSERT INTO ExistenciasStock(Almacen,Producto,Costo,Punto1,Punto2,Punto3,Punto4,Punto5\n" +
            ",Punto6,Punto7,Punto8,Punto9,Punto10,Punto11,Punto12,TPunto1,TPunto2\n" +
            ",TPunto3,TPunto4,TPunto5,TPunto6,TPunto7,TPunto8,TPunto9,TPunto10,TPunto11,TPunto12\n" +
            ",Serie,Usuario,Registro)\n" +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, e.getAlmacen());
            st.setInt(2, e.getProducto());
            st.setDouble(3, e.getCosto());
            st.setInt(4, e.getPunto1());
            st.setInt(5, e.getPunto2());
            st.setInt(6, e.getPunto3());
            st.setInt(7, e.getPunto4());
            st.setInt(8, e.getPunto5());
            st.setInt(9, e.getPunto6());
            st.setInt(10, e.getPunto7());
            st.setInt(11, e.getPunto8());
            st.setInt(12, e.getPunto9());
            st.setInt(13, e.getPunto10());
            st.setInt(14, e.getPunto11());
            st.setInt(15, e.getPunto12());
            st.setInt(16, e.getTPunto1());
            st.setInt(17, e.getTPunto2());
            st.setInt(18, e.getTPunto3());
            st.setInt(19, e.getTPunto4());
            st.setInt(20, e.getTPunto5());
            st.setInt(21, e.getTPunto6());
            st.setInt(22, e.getTPunto7());
            st.setInt(23, e.getTPunto8());
            st.setInt(24, e.getTPunto9());
            st.setInt(25, e.getTPunto10());
            st.setInt(26, e.getTPunto11());
            st.setInt(27, e.getTPunto12());
           // st.setInt(30, e.getTPunto13());
            //st.setInt(31, e.getTPunto14());
            st.setString(28, e.getSerie());
            st.setString(29, e.getUsuario());
            st.setDate(30, e.getRegistro());
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
    
    public boolean sumarExistencia(ExistenciasStock e){
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE ExistenciasStock SET Punto1 = Punto1 + ?, Punto2 = Punto2 + ?, Punto3 = Punto3 + ?,"
                    + "Punto4 = Punto4 + ?, Punto5 = Punto5 + ?, Punto6 = Punto6 + ?, Punto7 = Punto7 + ?, Punto8 = Punto8 + ?,"
                    + "Punto9 = Punto9 + ?, Punto10 = Punto10 + ?, Punto11 = Punto11 + ?, Punto12 = Punto12 + ? WHERE Almacen = ? AND Producto = ?");
            st.setInt(1, e.getPunto1());
            st.setInt(2, e.getPunto2());
            st.setInt(3, e.getPunto3());
            st.setInt(4, e.getPunto4());
            st.setInt(5, e.getPunto5());
            st.setInt(6, e.getPunto6());
            st.setInt(7, e.getPunto7());
            st.setInt(8, e.getPunto8());
            st.setInt(9, e.getPunto9());
            st.setInt(10, e.getPunto10());
            st.setInt(11, e.getPunto11());
            st.setInt(12, e.getPunto12());
            st.setInt(13, e.getAlmacen());
            st.setInt(14, e.getProducto());
            st.executeUpdate();
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
    
    public boolean quitarExistencia(ExistenciasStock e){
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE ExistenciasStock SET Punto1 = Punto1 - ?, Punto2 = Punto2 - ?, Punto3 = Punto3 - ?,"
                    + "Punto4 = Punto4 - ?, Punto5 = Punto5 - ?, Punto6 = Punto6 - ?, Punto7 = Punto7 - ?, Punto8 = Punto8 - ?,"
                    + "Punto9 = Punto9 - ?, Punto10 = Punto10 - ?, Punto11 = Punto11 - ?, Punto12 = Punto12 - ? WHERE Almacen = ? AND Producto = ?");
            st.setInt(1, e.getPunto1());
            st.setInt(2, e.getPunto2());
            st.setInt(3, e.getPunto3());
            st.setInt(4, e.getPunto4());
            st.setInt(5, e.getPunto5());
            st.setInt(6, e.getPunto6());
            st.setInt(7, e.getPunto7());
            st.setInt(8, e.getPunto8());
            st.setInt(9, e.getPunto9());
            st.setInt(10, e.getPunto10());
            st.setInt(11, e.getPunto11());
            st.setInt(12, e.getPunto12());
            st.setInt(13, e.getAlmacen());
            st.setInt(14, e.getProducto());
            st.executeUpdate();
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
    
    public ArrayList<ExistenciasStock> getStock(int am, int id){
        ArrayList<ExistenciasStock> list = new ArrayList<>();
        try {
            st = c.prepareStatement("SELECT Punto1,Punto2,Punto3,Punto4,Punto5,Punto6,Punto7,Punto8,Punto9,Punto10,Punto11,"
                    + "Punto12 FROM ExistenciasStock WHERE Almacen = ? AND Producto = ?");
            st.setInt(1, am);
            st.setInt(2, id);
            
            rs = st.executeQuery();
            
            while(rs.next()){
                ExistenciasStock e = new ExistenciasStock();
                e.setPunto1(rs.getInt("Punto1"));
                e.setPunto2(rs.getInt("Punto2"));
                e.setPunto3(rs.getInt("Punto3"));
                e.setPunto4(rs.getInt("Punto4"));
                e.setPunto5(rs.getInt("Punto5"));
                e.setPunto6(rs.getInt("Punto6"));
                e.setPunto7(rs.getInt("Punto7"));
                e.setPunto8(rs.getInt("Punto8"));
                e.setPunto9(rs.getInt("Punto9"));
                e.setPunto10(rs.getInt("Punto10"));
                e.setPunto11(rs.getInt("Punto11"));
                e.setPunto12(rs.getInt("Punto12"));
                //e.setPunto13(rs.getInt("Punto13"));
                //e.setPunto14(rs.getInt("Punto14"));
                list.add(e);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            Server.cerrarPrep(st);
        }
        return list;
    }
}
