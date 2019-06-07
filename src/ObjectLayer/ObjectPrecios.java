package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ObjectPrecios {

    Connection c = Server.getRpt();
    Connection pa = Server.getRcpt();
    //Connection c = Conexion.getRpt();
    //Connection pa = Conexion.getRcpt();

    PreparedStatement st, st2 = null;
    ResultSet rs = null;

    public boolean precioAdd(Precio pc) {
        boolean rpta = false;
        try {
            pa.setAutoCommit(false);
            st2 = pa.prepareStatement("INSERT INTO Precios (Id_Cliente,Id_Producto,PrecioA,PrecioB,PrecioAP,PrecioBP,Activo)"
                    + "VALUES(?,?,?,?,?,?,?)");
            st2.setInt(1, pc.getId_Cliente());
            st2.setInt(2, pc.getId_Producto());
            st2.setDouble(3, pc.getPrecioA());
            st2.setDouble(4, pc.getPrecioB());
            st2.setDouble(5, pc.getPrecioAP());
            st2.setDouble(6, pc.getPrecioBP());
            st2.setBoolean(7, pc.getActivo());

            rpta = st2.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rpta = precioAddCopy(pc);
                if (rpta) {
                    pa.commit();
                    st2.close();
                } else {
                    pa.rollback();
                    st2.close();
                }
            } else {
                pa.rollback();
                st2.close();
            }
           st2.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rpta;
    }

    public boolean precioAddCopy(Precio pc) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("INSERT INTO Precios (Id_Cliente,Id_Producto,PrecioA,PrecioB,PrecioAP,PrecioBP,Activo)"
                    + "VALUES(?,?,?,?,?,?,?)");
            c.setAutoCommit(false);
            st.setInt(1, pc.getId_Cliente());
            st.setInt(2, pc.getId_Producto());
            st.setDouble(3, pc.getPrecioA());
            st.setDouble(4, pc.getPrecioB());
            st.setDouble(5, pc.getPrecioAP());
            st.setDouble(6, pc.getPrecioBP());
            st.setBoolean(7, pc.getActivo());

            rpta = st.executeUpdate() == 1 ? true : false;

            if (rpta) {
                c.commit();
            } else {
                Conexion.rollback(c);
            }
            Conexion.cerrarPrep(st);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rpta;
    }

    public ArrayList<Precio> preciosGetAll() {
        ArrayList<Precio> listaPrecios = new ArrayList<Precio>();
        try {
            st2 = pa.prepareStatement("select p.Id_Lista,p.PrecioA,p.PrecioB,p.PrecioAP,p.PrecioBP,p.Id_Cliente,p.Id_Producto\n"
                    + ",c.Nombre as Cliente,pd.Descripcion as Producto from\n"
                    + "Precios p inner join CobranzaPhy.dbo.Clientes as c on p.Id_Cliente = c.Id_Cliente\n"
                    + "inner join ProduccionPhy.dbo.Producto as pd on p.Id_Producto = pd.Id_Producto\n"
                    + "where p.Activo = 1   order by c.Nombre");

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
                pc.setPrecioAP(rs.getDouble("PrecioAP"));
                pc.setPrecioBP(rs.getDouble("PrecioBP"));

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
            st2 = pa.prepareStatement("SELECT p.Id_Lista,p.PrecioA,p.PrecioB,p.PrecioAP,p.PrecioBP,\n"
                    + "c.Nombre as Cliente,pd.Descripcion as Producto ,p.Id_Cliente,p.Id_Producto\n"
                    + "FROM Precios p INNER JOIN CobranzaPhy.dbo.Clientes as c on p.Id_Cliente = c.Id_Cliente\n"
                    + "INNER JOIN ProduccionPhy.dbo.Producto pd on p.Id_Producto = pd.Id_Producto WHERE p.Activo =1 AND c.Nombre LIKE'%" + filtro + "%'"
                    + "ORDER BY c.Nombre");

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
                pc.setPrecioAP(rs.getDouble("PrecioAP"));
                pc.setPrecioBP(rs.getDouble("PrecioBP"));

                listaPrecios.add(pc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPrecios;
    }

    public boolean precioUpdate(Precio pc) {
        boolean rpta = false;
        try {
            st2 = pa.prepareStatement("UPDATE Precios SET PrecioA = ?,PrecioB = ?,PrecioAP = ?,\n"
                    + "PrecioBP = ? WHERE Id_Producto = ? AND Id_Cliente = ?");
            pa.setAutoCommit(false);

            st2.setDouble(1, pc.getPrecioA());
            st2.setDouble(2, pc.getPrecioB());
            st2.setDouble(3, pc.getPrecioAP());
            st2.setDouble(4, pc.getPrecioBP());
            st2.setInt(5, pc.getId_Producto());
            st2.setInt(6, pc.getId_Cliente());

            st2.executeUpdate();

            rpta = st2.executeUpdate() == 1 ? true : false;

            if (rpta) {
                rpta = precioUpdateCopy(pc);
                if (rpta) {
                    pa.commit();
                } else {
                    Conexion.rollback(pa);
                }
            } else {
                Conexion.rollback(pa);
            }
            Conexion.cerrarPrep(st2);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rpta;
    }

    public boolean precioUpdateCopy(Precio pc) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("UPDATE Precios SET PrecioA = ?,PrecioB = ?,PrecioAP = ?,\n"
                    + "PrecioBP = ? WHERE Id_Producto = ? AND Id_Cliente = ?");
            c.setAutoCommit(false);

            st.setDouble(1, pc.getPrecioA());
            st.setDouble(2, pc.getPrecioB());
            st.setDouble(3, pc.getPrecioAP());
            st.setDouble(4, pc.getPrecioBP());
            st.setInt(5, pc.getId_Producto());
            st.setInt(6, pc.getId_Cliente());

            rpta = st.executeUpdate() == 1 ? true : false;

            if (rpta) {
                c.commit();
            } else {
                Conexion.rollback(c);
            }
            Conexion.cerrarPrep(st);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rpta;
    }

    public boolean precioDelete(int Id_Prod, int Id_Cli) {
        boolean rpta = false;
        try {
            st2 = pa.prepareStatement("UPDATE Precios set Activo = 0 where Id_Producto = ? and Id_Cliente = ?");
            pa.setAutoCommit(false);
            st2.setInt(1, Id_Prod);
            st2.setInt(2, Id_Cli);
            rpta = st2.executeUpdate() == 1 ? true : false;
             
            if (rpta) {
                rpta = precioDeleteCopy(Id_Prod,Id_Cli);
                if (rpta) {
                    pa.commit();
                } else {
                    Conexion.rollback(pa);
                }
            } else {
                Conexion.rollback(pa);
            }
            Conexion.cerrarPrep(st2);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return rpta;
    }

    public boolean precioDeleteCopy(int Id_Prod, int Id_Cli) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("UPDATE Precios set Activo = 0 where Id_Producto = ? and Id_Cliente = ?");
            c.setAutoCommit(false);
            st.setInt(1, Id_Prod);
            st.setInt(2, Id_Cli);
            
            rpta = st.executeUpdate() == 1 ? true : false;
            
            if (rpta) {
                c.commit();
            } else {
                Conexion.rollback(c);
            }
            Conexion.cerrarPrep(st);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rpta;
    }

    public ArrayList<Precio> GetByID(int Id_Producto, int Id_Cliente) {
        ArrayList<Precio> lista = new ArrayList<Precio>();
        try {
            st2 = pa.prepareStatement("select p.PrecioA,p.PrecioB,p.PrecioAP,p.PrecioBP,p.Id_Producto,p.Id_Cliente\n"
                    + "from Precios p inner join ProduccionPhy.dbo.Producto as  pd\n"
                    + "on p.Id_Producto = pd.Id_Producto \n"
                    + "inner join CobranzaPhy.dbo.Clientes as c on p.Id_Cliente = c.Id_Cliente\n"
                    + "where p.Activo = 1 and p.Id_Cliente =" + Id_Cliente + "and p.Id_Producto =" + Id_Producto);

            rs = st2.executeQuery();

            while (rs.next()) {
                Precio pc = new Precio();
                pc.setId_Producto(rs.getInt("Id_Producto"));
                pc.setId_Cliente(rs.getInt("Id_Cliente"));
                pc.setPrecioA(rs.getDouble("PrecioA"));
                pc.setPrecioB(rs.getDouble("PrecioB"));
                pc.setPrecioAP(rs.getDouble("PrecioAP"));
                pc.setPrecioBP(rs.getDouble("PrecioBP"));
                
                lista.add(pc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}