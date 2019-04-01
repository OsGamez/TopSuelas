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

public class ObjectPrecios {

    //Connection c = Server.getRpt();
    //Connection pa = Server.getRcpt();
    
    Connection c = Conexion.getRpt();
    Connection pa = Conexion.getRcpt();

    PreparedStatement st, st2 = null;
    ResultSet rs = null;

    public boolean precioAdd(Precio pc) {
        try {
            c.setAutoCommit(false);
            pa.setAutoCommit(false);
            try {
                st = c.prepareStatement("INSERT INTO Precios (Id_Cliente,Id_Producto,PrecioA,PrecioB,Activo)"
                        + "VALUES(?,?,?,?,?)");
                st.setInt(1, pc.getId_Cliente());
                st.setInt(2, pc.getId_Producto());
                st.setDouble(3, pc.getPrecioA());
                st.setDouble(4, pc.getPrecioB());
                st.setBoolean(5, pc.getActivo());

                st2 = pa.prepareStatement("INSERT INTO Precios (Id_Cliente,Id_Producto,PrecioA,PrecioB,Activo)"
                        + "VALUES(?,?,?,?,?)");
                st2.setInt(1, pc.getId_Cliente());
                st2.setInt(2, pc.getId_Producto());
                st2.setDouble(3, pc.getPrecioA());
                st2.setDouble(4, pc.getPrecioB());
                st2.setBoolean(5, pc.getActivo());

                st.execute();
                st2.execute();
                c.commit();
                pa.commit();
                return true;
            } catch (SQLException ex) {
                c.rollback();
                pa.rollback();
                ex.printStackTrace();
            } finally {
                try {
                    if (st != null) {
                        st.close();
                    }
                    if (st2 != null) {
                        st2.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObjectPrecios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Precio> preciosGetAll() {
        ArrayList<Precio> listaPrecios = new ArrayList<Precio>();
        try {
            st2 = pa.prepareStatement("select p.Id_Lista,p.PrecioA,p.PrecioB,p.Id_Cliente,p.Id_Producto\n"
                    + ",c.RazonSocial as Cliente,pd.Descripcion as Producto from\n"
                    + "Precios p inner join CobranzaPhy.dbo.Clientes as c on p.Id_Cliente = c.Id_Cliente\n"
                    + "inner join ProduccionPhy.dbo.Producto as pd on p.Id_Producto = pd.Id_Producto\n"
                    + "where p.Activo = 1  and c.Activo = 1 and pd.Activo =1 order by c.RazonSocial");

            rs = st2.executeQuery();
            while (rs.next()) {
                Precio pc = new Precio();
                pc.setId_Lista(rs.getInt("Id_Lista"));
                pc.setId_Producto(rs.getInt("Id_Producto"));
                pc.setId_Cliente(rs.getInt("Id_Cliente"));
                pc.setDesCli(rs.getString("Cliente"));
                pc.setDesProd(rs.getString("Producto"));
                pc.setPrecioA(rs.getDouble("PrecioA"));
                pc.setPrecioB(rs.getDouble("PrecioB"));

                listaPrecios.add(pc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPrecios;
    }

    public int validarLista(int producto, int cliente) {
        try {
            st2 = pa.prepareStatement("SELECT COUNT (Id_Lista) FROM Precios WHERE Id_Producto=? AND Id_Cliente=? AND Activo = 1");
            st2.setInt(1, producto);
            st2.setInt(2, cliente);
            rs = st2.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 1;
        }
    }

    public ArrayList<Precio> precioSearch(String filtro) {
        ArrayList<Precio> listaPrecios = new ArrayList<Precio>();
        try {
            st2 = pa.prepareStatement("SELECT p.Id_Lista,p.PrecioA,p.PrecioB, \n"
                    + "c.RazonSocial as Cliente,pd.Descripcion as Producto ,p.Id_Cliente,p.Id_Producto\n"
                    + "FROM Precios p INNER JOIN CobranzaPhy.dbo.Clientes as c on p.Id_Cliente = c.Id_Cliente\n"
                    + "INNER JOIN ProduccionPhy.dbo.Producto pd on p.Id_Producto = pd.Id_Producto WHERE p.Activo =1 AND c.RazonSocial LIKE'%" + filtro + "%'"
                    + "ORDER BY c.RazonSocial");

            rs = st2.executeQuery();
            while (rs.next()) {
                Precio pc = new Precio();
                pc.setId_Lista(rs.getInt("Id_Lista"));
                pc.setId_Producto(rs.getInt("Id_Producto"));
                pc.setId_Cliente(rs.getInt("Id_Cliente"));
                pc.setDesCli(rs.getString("Cliente"));
                pc.setDesProd(rs.getString("Producto"));
                pc.setPrecioA(rs.getDouble("PrecioA"));
                pc.setPrecioB(rs.getDouble("PrecioB"));

                listaPrecios.add(pc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPrecios;
    }

    public boolean precioUpdate(Precio precio) {
        try {
            st = c.prepareStatement("UPDATE Precios SET PrecioA=?, PrecioB=? WHERE Id_Producto = ? AND Id_Cliente = ?");
            st.setDouble(1, precio.getPrecioA());
            st.setDouble(2, precio.getPrecioB());
            st.setInt(3, precio.getId_Producto());
            st.setInt(4, precio.getId_Cliente());

            st2 = pa.prepareStatement("UPDATE Precios SET PrecioA=?, PrecioB=? WHERE Id_Producto = ? AND Id_Cliente = ?");
            st2.setDouble(1, precio.getPrecioA());
            st2.setDouble(2, precio.getPrecioB());
            st2.setInt(3, precio.getId_Producto());
            st2.setInt(4, precio.getId_Cliente());

            st2.executeUpdate();
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public void precioDelete(int Id_Prod, int Id_Cli) {
        try {
            st = c.prepareStatement("UPDATE Precios set Activo = 0 where Id_Producto = ? and Id_Cliente = ?");
            st.setInt(1, Id_Prod);
            st.setInt(2, Id_Cli);

            st2 = pa.prepareStatement("UPDATE Precios set Activo = 0 where Id_Producto = ? and Id_Cliente = ?");
            st2.setInt(1, Id_Prod);
            st2.setInt(2, Id_Cli);

            st2.executeUpdate();
            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Precio> GetByID(int Id_Producto, int Id_Cliente) {
        ArrayList<Precio> lista = new ArrayList<Precio>();
        try {
            st2 = pa.prepareStatement("select p.PrecioA,p.PrecioB,p.Id_Producto,p.Id_Cliente\n"
                    + "from Precios p inner join ProduccionPhy.dbo.Producto as  pd\n"
                    + "on p.Id_Producto = pd.Id_Producto \n"
                    + "inner join CobranzaPhy.dbo.Clientes as c on p.Id_Cliente = c.Id_Cliente\n"
                    + "where p.Id_Cliente =" + Id_Cliente + "and p.Id_Producto =" + Id_Producto);

            rs = st2.executeQuery();

            while (rs.next()) {
                Precio pc = new Precio();
                pc.setId_Producto(rs.getInt("Id_Producto"));
                pc.setId_Cliente(rs.getInt("Id_Cliente"));
                pc.setPrecioA(rs.getDouble("PrecioA"));
                pc.setPrecioB(rs.getDouble("PrecioB"));
                lista.add(pc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
