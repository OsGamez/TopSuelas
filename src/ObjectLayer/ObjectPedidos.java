package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ObjectPedidos {

    Connection c = Server.getRpt();
    Connection pa = Server.getRcpt();
//    DB db = new DB();
//    Connection c = db.RPTPhylon();
//    Connection pa = db.RCPTPhylonA();

    PreparedStatement st, dp = null;
    ResultSet rs, ra = null;
    CallableStatement cl = null;
    ObjectDetalle obj = new ObjectDetalle();
    ObjectParametros parametro = new ObjectParametros();
    Connection[] datos = {c, pa};
    Connection[] cn = {pa};

    //CUANDO NO HAY PEDIDOS SI ES SERIE A INSERTA EN PHYLON,RPT Y EN PARAMETROS PHY
    //RCPTPHYLONA
    public boolean insertarVentaA(Pedido p, ArrayList<Dpedido> detalle, Parametro pam) {
        try {
            pa.setAutoCommit(false);
            c.setAutoCommit(false);
            for (int i = 0; i < datos.length; i++) {
                dp = datos[i].prepareStatement("INSERT INTO Pedidos (Npedido,NpedidoCl, Id_Cliente,Fecha_Pedido,Fecha_Entrega,"
                        + "Condiciones,Observaciones,Id_Usuario,Serie,TotalPares,CostoTotal,Estatus,ParesSurt,OrdenCompra,"
                        + "Fecha_Recibido,Fecha_Captura)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                dp.setString(1, p.getNpedido());
                dp.setString(2, p.getNpedidoCl());
                dp.setInt(3, p.getId_Cliente());
                dp.setDate(4, p.getFecha_Pedido());
                dp.setDate(5, p.getFecha_Entrega());
                dp.setString(6, p.getCondiciones());
                dp.setString(7, p.getObservaciones());
                dp.setInt(8, p.getId_Usuario());
                dp.setString(9, p.getSerie());
                dp.setInt(10, p.getTotalPares());
                dp.setDouble(11, p.getCostoTotal());
                dp.setString(12, p.getStatus());
                dp.setInt(13, p.getParesSurt());
                dp.setString(14, p.getOrdenCompra());
                dp.setDate(15, p.getFecha_Recibido());
                dp.setDate(16, p.getFecha_Captura());
                dp.executeUpdate();

                for (Dpedido dt : detalle) {
                    dp = datos[i].prepareStatement("INSERT INTO Dpedido (Renglon,Npedido, Id_Cliente,Fecha_Pedido,Fecha_Entrega, "
                            + "Id_Producto,Corrida,C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,Pares,Importe,Serie,CSurt1,CSurt2,CSurt3,"
                            + "CSurt4,CSurt5,CSurt6,CSurt7,CSurt8,CSurt9,CSurt10,CSurt11,CSurt12,ParesSurt,Estatus,Precio)"
                            + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    dp.setInt(1, dt.getRenglon());
                    dp.setString(2, dt.getNpedido());
                    dp.setInt(3, dt.getId_Cliente());
                    dp.setDate(4, dt.getFecha_Pedido());
                    dp.setDate(5, dt.getFecha_Entrega());
                    dp.setInt(6, dt.getId_Producto());
                    dp.setString(7, dt.getCorrida());
                    dp.setInt(8, dt.getC1());
                    dp.setInt(9, dt.getC2());
                    dp.setInt(10, dt.getC3());
                    dp.setInt(11, dt.getC4());
                    dp.setInt(12, dt.getC5());
                    dp.setInt(13, dt.getC6());
                    dp.setInt(14, dt.getC7());
                    dp.setInt(15, dt.getC8());
                    dp.setInt(16, dt.getC9());
                    dp.setInt(17, dt.getC10());
                    dp.setInt(18, dt.getC11());
                    dp.setInt(19, dt.getC12());
                    dp.setInt(20, dt.getPares());
                    dp.setDouble(21, dt.getImporte());
                    dp.setString(22, dt.getSerie());
                    dp.setInt(23, dt.getCSurt1());
                    dp.setInt(24, dt.getCSurt2());
                    dp.setInt(25, dt.getCSurt3());
                    dp.setInt(26, dt.getCSurt4());
                    dp.setInt(27, dt.getCSurt5());
                    dp.setInt(28, dt.getCSurt6());
                    dp.setInt(29, dt.getCSurt7());
                    dp.setInt(30, dt.getCSurt8());
                    dp.setInt(31, dt.getCSurt9());
                    dp.setInt(32, dt.getCSurt10());
                    dp.setInt(33, dt.getCSurt11());
                    dp.setInt(34, dt.getCSurt12());
                    dp.setInt(35, dt.getParesSurt());
                    dp.setString(36, dt.getStatus());
                    dp.setDouble(37, dt.getPrecio());
                    dp.executeUpdate();
                }
            }
            pa.commit();
            c.commit();
            parametro.insertarPamA(pam);
            parametro.insertarPam(pam);
            dp.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            DB.cerrarPrep(dp);
            DB.rollback(pa);
        } catch (Exception e) {
            e.printStackTrace();
            DB.cerrarPrep(dp);
            DB.rollback(pa);
        }
        return false;
    }

    //CUANDO HAY PEDIDOS SI ES SERIE A INSERTA EN PHYLON, RPT Y ACTUALIZA LAS TABLAS DE PARAMETROS PHY
    public boolean insertarVentaAPam(Pedido p, ArrayList<Dpedido> detalle, String Np) {
        try {
            pa.setAutoCommit(false);
            c.setAutoCommit(false);
            for (int i = 0; i < datos.length; i++) {
                dp = datos[i].prepareStatement("INSERT INTO Pedidos (Npedido,NpedidoCl, Id_Cliente,Fecha_Pedido,Fecha_Entrega,"
                        + "Condiciones,Observaciones,Id_Usuario,Serie,TotalPares,CostoTotal,Estatus,ParesSurt,OrdenCompra,"
                        + "Fecha_Recibido,Fecha_Captura)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                dp.setString(1, p.getNpedido());
                dp.setString(2, p.getNpedidoCl());
                dp.setInt(3, p.getId_Cliente());
                dp.setDate(4, p.getFecha_Pedido());
                dp.setDate(5, p.getFecha_Entrega());
                dp.setString(6, p.getCondiciones());
                dp.setString(7, p.getObservaciones());
                dp.setInt(8, p.getId_Usuario());
                dp.setString(9, p.getSerie());
                dp.setInt(10, p.getTotalPares());
                dp.setDouble(11, p.getCostoTotal());
                dp.setString(12, p.getStatus());
                dp.setInt(13, p.getParesSurt());
                dp.setString(14, p.getOrdenCompra());
                dp.setDate(15, p.getFecha_Recibido());
                dp.setDate(16, p.getFecha_Captura());
                dp.executeUpdate();

                for (Dpedido dt : detalle) {
                    dp = datos[i].prepareStatement("INSERT INTO Dpedido (Renglon,Npedido, Id_Cliente,Fecha_Pedido,Fecha_Entrega, "
                            + "Id_Producto,Corrida,C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,Pares,Importe,Serie,CSurt1,CSurt2,CSurt3,"
                            + "CSurt4,CSurt5,CSurt6,CSurt7,CSurt8,CSurt9,CSurt10,CSurt11,CSurt12,ParesSurt,Estatus,Precio)"
                            + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    dp.setInt(1, dt.getRenglon());
                    dp.setString(2, dt.getNpedido());
                    dp.setInt(3, dt.getId_Cliente());
                    dp.setDate(4, dt.getFecha_Pedido());
                    dp.setDate(5, dt.getFecha_Entrega());
                    dp.setInt(6, dt.getId_Producto());
                    dp.setString(7, dt.getCorrida());
                    dp.setInt(8, dt.getC1());
                    dp.setInt(9, dt.getC2());
                    dp.setInt(10, dt.getC3());
                    dp.setInt(11, dt.getC4());
                    dp.setInt(12, dt.getC5());
                    dp.setInt(13, dt.getC6());
                    dp.setInt(14, dt.getC7());
                    dp.setInt(15, dt.getC8());
                    dp.setInt(16, dt.getC9());
                    dp.setInt(17, dt.getC10());
                    dp.setInt(18, dt.getC11());
                    dp.setInt(19, dt.getC12());
                    dp.setInt(20, dt.getPares());
                    dp.setDouble(21, dt.getImporte());
                    dp.setString(22, dt.getSerie());
                    dp.setInt(23, dt.getCSurt1());
                    dp.setInt(24, dt.getCSurt2());
                    dp.setInt(25, dt.getCSurt3());
                    dp.setInt(26, dt.getCSurt4());
                    dp.setInt(27, dt.getCSurt5());
                    dp.setInt(28, dt.getCSurt6());
                    dp.setInt(29, dt.getCSurt7());
                    dp.setInt(30, dt.getCSurt8());
                    dp.setInt(31, dt.getCSurt9());
                    dp.setInt(32, dt.getCSurt10());
                    dp.setInt(33, dt.getCSurt11());
                    dp.setInt(34, dt.getCSurt12());
                    dp.setInt(35, dt.getParesSurt());
                    dp.setString(36, dt.getStatus());
                    dp.setDouble(37, dt.getPrecio());
                    dp.executeUpdate();
                }
            }
            pa.commit();
            c.commit();
            parametro.actualizarPamA(Np);
            parametro.actualizarPam(Np);
            dp.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            DB.cerrarPrep(dp);
            DB.rollback(pa);
        } catch (Exception e) {
            e.printStackTrace();
            DB.cerrarPrep(dp);
            DB.rollback(pa);
        }
        return false;
    }

    //CUANDO NO HAY PEDIDOS SI ES SERIE B INSERTA EN PHYLON Y EN PARAMETROS PHY
    //RCPTPHYLONA
    public boolean insertarVentaB(Pedido p, ArrayList<Dpedido> detalle, Parametro pam) {
        try {
            pa.setAutoCommit(false);
            dp = pa.prepareStatement("INSERT INTO Pedidos (Npedido,NpedidoCl, Id_Cliente,Fecha_Pedido,Fecha_Entrega,"
                    + "Condiciones,Observaciones,Id_Usuario,Serie,TotalPares,CostoTotal,Estatus,ParesSurt,OrdenCompra,"
                    + "Fecha_Recibido,Fecha_Captura)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            dp.setString(1, p.getNpedido());
            dp.setString(2, p.getNpedidoCl());
            dp.setInt(3, p.getId_Cliente());
            dp.setDate(4, p.getFecha_Pedido());
            dp.setDate(5, p.getFecha_Entrega());
            dp.setString(6, p.getCondiciones());
            dp.setString(7, p.getObservaciones());
            dp.setInt(8, p.getId_Usuario());
            dp.setString(9, p.getSerie());
            dp.setInt(10, p.getTotalPares());
            dp.setDouble(11, p.getCostoTotal());
            dp.setString(12, p.getStatus());
            dp.setInt(13, p.getParesSurt());
            dp.setString(14, p.getOrdenCompra());
            dp.setDate(15, p.getFecha_Recibido());
            dp.setDate(16, p.getFecha_Captura());

            dp.executeUpdate();
            pa.commit();
            insertarParametroA(pam);
            insertarParametro(pam);
            dp.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            DB.cerrarPrep(dp);
            DB.rollback(pa);
        } catch (Exception e) {
            e.printStackTrace();
            DB.cerrarPrep(dp);
            DB.rollback(pa);
        }
        return false;
    }

    //CUANDO  HAY PEDIDOS SI ES SERIE B INSERTA EN RPTPHYLON Y  ACTUALIZA EN PARAMETROS 
    //RPTPHY
    public boolean insertarVentaBPam(Pedido p, ArrayList<Dpedido> detalle, String Np) {
        try {
            pa.setAutoCommit(false);
            dp = pa.prepareStatement("INSERT INTO Pedidos (Npedido,NpedidoCl, Id_Cliente,Fecha_Pedido,Fecha_Entrega,"
                    + "Condiciones,Observaciones,Id_Usuario,Serie,TotalPares,CostoTotal,Estatus,ParesSurt,OrdenCompra,"
                    + "Fecha_Recibido,Fecha_Captura)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            dp.setString(1, p.getNpedido());
            dp.setString(2, p.getNpedidoCl());
            dp.setInt(3, p.getId_Cliente());
            dp.setDate(4, p.getFecha_Pedido());
            dp.setDate(5, p.getFecha_Entrega());
            dp.setString(6, p.getCondiciones());
            dp.setString(7, p.getObservaciones());
            dp.setInt(8, p.getId_Usuario());
            dp.setString(9, p.getSerie());
            dp.setInt(10, p.getTotalPares());
            dp.setDouble(11, p.getCostoTotal());
            dp.setString(12, p.getStatus());
            dp.setInt(13, p.getParesSurt());
            dp.setString(14, p.getOrdenCompra());
            dp.setDate(15, p.getFecha_Recibido());
            dp.setDate(16, p.getFecha_Captura());
            dp.executeUpdate();
            pa.commit();
            for (Dpedido dt : detalle) {
                obj.insertDetalleA(dt);
            }
            parametro.actualizarPam(Np);
            parametro.actualizarPamA(Np);
            dp.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            DB.cerrarPrep(dp);
            DB.rollback(pa);
        } catch (Exception e) {
            e.printStackTrace();
            DB.cerrarPrep(dp);
            DB.rollback(pa);
        }
        return false;
    }

    public boolean insertarParametro(Parametro p) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("INSERT INTO Parametros(Npedido, Entrada,Salida,Factura)"
                    + "values(?,?,?,?)");

            st.setString(1, p.getNpedido());
            st.setInt(2, p.getEntrada());
            st.setInt(3, p.getSalida());
            st.setInt(4, p.getFactura());
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertarParametroA(Parametro p) {
        try {
            pa.setAutoCommit(false);
            dp = pa.prepareStatement("INSERT INTO Parametros(Npedido, Entrada,Salida,Factura)"
                    + "values(?,?,?,?)");

            dp.setString(1, p.getNpedido());
            dp.setInt(2, p.getEntrada());
            dp.setInt(3, p.getSalida());
            dp.setInt(4, p.getFactura());
            dp.executeUpdate();
            pa.commit();
            dp.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean actualizarParametro(String Np) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("UPDATE Parametros SET Npedido = ?");
            st.setString(1, Np);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean actualizarParametroA(String Np) {
        try {
            pa.setAutoCommit(false);
            dp = pa.prepareStatement("UPDATE Parametros SET Npedido = ?");
            dp.setString(1, Np);
            dp.executeUpdate();
            pa.commit();
            dp.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Pedido> pedidoGetByID(String filtro, String Serie) {
        ArrayList<Pedido> listaPedido = new ArrayList<Pedido>();
        try {
            dp = pa.prepareStatement("Select p.Npedido,p.NpedidoCl,p.OrdenCompra,pd.Renglon,c.Id_Cliente,c.RazonSocial,c.Nombre,c.Calle,c.CP,c.Colonia,cd.Descripcion as Ciudad,\n"
                    + "e.Descripcion as Estado,ps.Descripcion as Pais,c.DiasCredito,a.Id_Agente as Agente,c.Observaciones\n"
                    + ",p.TotalPares,p.CostoTotal,\n"
                    + "pd.Importe,p.Fecha_Pedido,p.Fecha_Captura,p.Fecha_Entrega,p.Fecha_Recibido,pd.Pares,\n"
                    + "p.Serie,pd.Estatus,prod.Id_Producto,prod.Descripcion as Suela,pd.Corrida,cl.Descripcion as Color,\n"
                    + "pd.Precio,\n"
                    + "pd.C1,pd.C2,pd.C3,pd.C4,pd.C5,pd.C6,pd.C7,pd.C8,pd.C9,pd.C10,pd.C11,pd.C12\n"
                    + "from Pedidos p inner join Dpedido pd\n"
                    + "on p.Npedido = pd.Npedido \n"
                    + "inner join  CobranzaPhy.dbo.Clientes as c on p.Id_Cliente = c.Id_Cliente\n"
                    + "inner join CobranzaPhy.dbo.Agentes as a on c.Id_Agente = a.Id_Agente\n"
                    + "inner join CobranzaPhy.dbo.Ciudades as cd on c.Id_Ciudad = cd.Id_Ciudad\n"
                    + "inner join CobranzaPhy.dbo.Estados as e on c.Id_Estado = e.Id_Estado\n"
                    + "inner join CobranzaPhy.dbo.Paises as ps on c.Id_Pais = ps.Id_Pais\n"
                    + "inner join ProduccionPhy.dbo.Producto as prod on pd.Id_Producto = prod.Id_Producto\n"
                    + "inner join ProduccionPhy.dbo.Color as cl on prod.Id_Color = cl.Id_Color\n"
                    + "where p.Npedido = ?  and p.Serie = ?");

            dp.setString(1, filtro);
            dp.setString(2, Serie);
            ra = dp.executeQuery();
            while (ra.next()) {
                Pedido p = new Pedido();
                p.setNpedido(ra.getString("Npedido"));
                p.setId_Cliente(ra.getInt("Id_Cliente"));
                p.setRenglon(ra.getInt("Renglon"));
                p.setNpedidoCl(ra.getString("NpedidoCl"));
                p.setRsocial(ra.getString("RazonSocial"));
                p.setNombre(ra.getString("Nombre"));
                p.setOrdenCompra(ra.getString("OrdenCompra"));
                p.setCalle(ra.getString("Calle"));
                p.setCp(ra.getString("CP"));
                p.setColonia(ra.getString("Colonia"));
                p.setEstado(ra.getString("Estado"));
                p.setCiudad(ra.getString("Ciudad"));
                p.setPais(ra.getString("Pais"));
                p.setObservaciones(ra.getString("Observaciones"));
                p.setAgente(ra.getInt("Agente"));
                p.setCred(ra.getInt("DiasCredito"));
                p.setCostoTotal(ra.getDouble("CostoTotal"));
                p.setImporte(ra.getDouble("Importe"));
                p.setCorrida(ra.getString("Corrida"));
                p.setFecha_Captura(ra.getDate("Fecha_Captura"));
                p.setFecha_Entrega(ra.getDate("Fecha_Entrega"));
                p.setFecha_Pedido(ra.getDate("Fecha_Pedido"));
                p.setFecha_Recibido(ra.getDate("Fecha_Recibido"));
                p.setPares(ra.getInt("Pares"));
                p.setSerie(ra.getString("Serie"));
                p.setStatus(ra.getString("Estatus"));
                p.setId_Producto(ra.getInt("Id_Producto"));
                p.setSuela(ra.getString("Suela"));
                p.setColor(ra.getString("Color"));
                p.setTotalPares(ra.getInt("TotalPares"));
                p.setC1(ra.getInt("C1"));
                p.setC2(ra.getInt("C2"));
                p.setC3(ra.getInt("C3"));
                p.setC4(ra.getInt("C4"));
                p.setC5(ra.getInt("C5"));
                p.setC6(ra.getInt("C6"));
                p.setC7(ra.getInt("C7"));
                p.setC8(ra.getInt("C8"));
                p.setC9(ra.getInt("C9"));
                p.setC10(ra.getInt("C10"));
                p.setC11(ra.getInt("C11"));
                p.setC12(ra.getInt("C12"));
                p.setPrecio(ra.getDouble("Precio"));
                listaPedido.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPedido;
    }

    public ArrayList<Pedido> pedidoGetByReporte(String filtro) {
        ArrayList<Pedido> listaPedido = new ArrayList<Pedido>();
        try {
            dp = pa.prepareStatement("select * from Pedidos where Npedido = ?");
            dp.setString(1, filtro);
         
            ra = dp.executeQuery();
            while (ra.next()) {
                Pedido p = new Pedido();
                p.setNpedido(ra.getString("Npedido"));
                listaPedido.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPedido;
    }

    public boolean actualizarPedidoA(Pedido p, Dpedido detalle, int Id) {
        boolean rpta = false;
        try {
            pa.setAutoCommit(false);
            c.setAutoCommit(false);
            for (int i = 0; i < datos.length; i++) {
                dp = datos[i].prepareStatement("select p.Estatus,p.Npedido from RCPTPhylonA.dbo.Dpedido d\n"
                        + "inner join RCPTPhylonA.dbo.Pedidos p on p.Npedido = d.Npedido\n"
                        + "WHERE d.Renglon = ? and d.Npedido = ?\n"
                        + "and d.Estatus<>10");
                dp.setInt(1, Id);
                dp.setString(2, p.getNpedido());
                ra = dp.executeQuery();
                if (ra.next()) {
                    return false;
                } else {
                    dp = datos[i].prepareStatement("UPDATE Pedidos SET TotalPares = ?, CostoTotal=? WHERE Npedido= ?");
                    dp.setDouble(1, p.getTotalPares());
                    dp.setDouble(2, p.getCostoTotal());
                    dp.setString(3, p.getNpedido());
                    dp.executeUpdate();

                    dp = datos[i].prepareStatement("UPDATE Dpedido SET C1=?,C2=?,C3=?,C4=?,C5=?,C6=?,C7=?,C8=?,C9=?,C10=?,C11=?,C12=?,Pares=?,Importe=? "
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
                    dp.executeUpdate();
                }
            }
            pa.commit();
            c.commit();
            dp.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            DB.cerrarPrep(dp);
            DB.rollback(pa);
        }
        return rpta;
    }

    public boolean actualizarPedidoAPhy(Pedido p, Dpedido dt, int Id) {
        try {
            pa.setAutoCommit(false);
            dp = pa.prepareStatement("select p.Estatus,p.Npedido from RCPTPhylonA.dbo.Dpedido d\n"
                    + "            inner join RCPTPhylonA.dbo.Pedidos p on p.Npedido = d.Npedido\n"
                    + "            WHERE d.Renglon = ? and d.Npedido = ?\n"
                    + "			and d.Estatus<>10");
            dp.setInt(1, Id);
            dp.setString(2, p.getNpedido());
            ra = dp.executeQuery();
            if (ra.next()) {
                return false;
            } else {
                dp = pa.prepareStatement("UPDATE Pedidos SET TotalPares = ?, CostoTotal=? WHERE Npedido= ?");
                dp.setDouble(1, p.getTotalPares());
                dp.setDouble(2, p.getCostoTotal());
                dp.setString(3, p.getNpedido());
                dp.executeUpdate();
                pa.commit();
                obj.actualizarDetalleA(dt);
                dp.close();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            DB.cerrarPrep(dp);
            DB.rollback(pa);
        } catch (Exception ex) {
            ex.printStackTrace();
            DB.cerrarPrep(dp);
            DB.rollback(pa);
        }
        return false;
    }

    public boolean agregarPedido(Pedido p, ArrayList<Dpedido> detalle, String Np) {
        boolean rpta = false;
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("select p.Estatus,p.Npedido from RPTPhylon.dbo.Dpedido d\n"
                    + "inner join RPTPhylon.dbo.Pedidos p on p.Npedido = d.Npedido\n"
                    + "where p.Npedido = ? and p.Estatus<>10");
            st.setString(1, Np);
            rs = st.executeQuery();
            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("UPDATE Pedidos SET TotalPares = ?,CostoTotal=? WHERE Npedido=?");
                st.setDouble(1, p.getTotalPares());
                st.setDouble(2, p.getCostoTotal());
                st.setString(3, p.getNpedido());
                rpta = st.executeUpdate() == 1 ? true : false;
                if (rpta) {
                    for (Dpedido det : detalle) {
                        det.setNpedido(p.getNpedido());
                        rpta = obj.insertDetalle(det);
                        if (!rpta) {
                            c.rollback();
                            st.close();
                        } else {
                            c.commit();
                            st.close();
                        }
                    }
                } else {
                    c.rollback();
                    st.close();
                }
                st.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            DB.cerrarPrep(st);
            DB.rollback(c);
        }
        return rpta;
    }

    public boolean agregarPedidoA(Pedido p, ArrayList<Dpedido> detalle, String Np) {
        try {
            pa.setAutoCommit(false);
            c.setAutoCommit(false);
            for (int i = 0; i < datos.length; i++) {
                dp = datos[i].prepareStatement("select p.Estatus,p.Npedido from RCPTPhylonA.dbo.Dpedido d\n"
                        + "inner join RCPTPhylonA.dbo.Pedidos p on p.Npedido = d.Npedido\n"
                        + "where p.Npedido = ? and p.Estatus<>10");
                dp.setString(1, Np);
                ra = dp.executeQuery();
                if (ra.next()) {
                    return false;
                } else {
                    dp = datos[i].prepareStatement("UPDATE Pedidos SET TotalPares = ?,CostoTotal=? WHERE Npedido=?");
                    dp.setDouble(1, p.getTotalPares());
                    dp.setDouble(2, p.getCostoTotal());
                    dp.setString(3, p.getNpedido());
                    dp.executeUpdate();

                    for (Dpedido dt : detalle) {
                        dp = datos[i].prepareStatement("INSERT INTO Dpedido (Renglon,Npedido, Id_Cliente,Fecha_Pedido,Fecha_Entrega, "
                                + "Id_Producto,Corrida,C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,Pares,Importe,Serie,CSurt1,CSurt2,CSurt3,"
                                + "CSurt4,CSurt5,CSurt6,CSurt7,CSurt8,CSurt9,CSurt10,CSurt11,CSurt12,ParesSurt,Estatus,Precio)"
                                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        dp.setInt(1, dt.getRenglon());
                        dp.setString(2, dt.getNpedido());
                        dp.setInt(3, dt.getId_Cliente());
                        dp.setDate(4, dt.getFecha_Pedido());
                        dp.setDate(5, dt.getFecha_Entrega());
                        dp.setInt(6, dt.getId_Producto());
                        dp.setString(7, dt.getCorrida());
                        dp.setInt(8, dt.getC1());
                        dp.setInt(9, dt.getC2());
                        dp.setInt(10, dt.getC3());
                        dp.setInt(11, dt.getC4());
                        dp.setInt(12, dt.getC5());
                        dp.setInt(13, dt.getC6());
                        dp.setInt(14, dt.getC7());
                        dp.setInt(15, dt.getC8());
                        dp.setInt(16, dt.getC9());
                        dp.setInt(17, dt.getC10());
                        dp.setInt(18, dt.getC11());
                        dp.setInt(19, dt.getC12());
                        dp.setInt(20, dt.getPares());
                        dp.setDouble(21, dt.getImporte());
                        dp.setString(22, dt.getSerie());
                        dp.setInt(23, dt.getCSurt1());
                        dp.setInt(24, dt.getCSurt2());
                        dp.setInt(25, dt.getCSurt3());
                        dp.setInt(26, dt.getCSurt4());
                        dp.setInt(27, dt.getCSurt5());
                        dp.setInt(28, dt.getCSurt6());
                        dp.setInt(29, dt.getCSurt7());
                        dp.setInt(30, dt.getCSurt8());
                        dp.setInt(31, dt.getCSurt9());
                        dp.setInt(32, dt.getCSurt10());
                        dp.setInt(33, dt.getCSurt11());
                        dp.setInt(34, dt.getCSurt12());
                        dp.setInt(35, dt.getParesSurt());
                        dp.setString(36, dt.getStatus());
                        dp.setDouble(37, dt.getPrecio());
                        dp.executeUpdate();
                    }
                }
            }
            pa.commit();
            c.commit();
            dp.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            Server.cerrarPrep(dp);
            Server.rollback(pa);
            Server.rollback(c);
        }
        return false;
    }

    public boolean agregarPedidoAPhy(Pedido p, ArrayList<Dpedido> detalle, String Np) {
        try {
            pa.setAutoCommit(false);
            dp = pa.prepareStatement("select p.Estatus,p.Npedido from RCPTPhylonA.dbo.Dpedido d\n"
                    + "inner join RCPTPhylonA.dbo.Pedidos p on p.Npedido = d.Npedido\n"
                    + "where p.Npedido = ? and p.Estatus<>10");
            dp.setString(1, Np);
            ra = dp.executeQuery();
            if (ra.next()) {
                return false;
            } else {
                dp = pa.prepareStatement("UPDATE Pedidos SET TotalPares = ?,CostoTotal=? WHERE Npedido=?");
                dp.setDouble(1, p.getTotalPares());
                dp.setDouble(2, p.getCostoTotal());
                dp.setString(3, p.getNpedido());
                dp.executeUpdate();
                pa.commit();

                for (Dpedido dt : detalle) {
                    obj.insertDetalleA(dt);
                }
                dp.close();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            DB.cerrarPrep(dp);
            DB.rollback(pa);
        }
        return false;
    }

    public boolean eliminarPedidoA(Pedido p, int id, String Npedido) {
        try {
            pa.setAutoCommit(false);
            c.setAutoCommit(false);
            for (int i = 0; i < datos.length; i++) {
                dp = datos[i].prepareStatement("select d.Estatus,d.Npedido from RCPTPhylonA.dbo.Dpedido d\n"
                        + "            inner join RCPTPhylonA.dbo.Pedidos p on p.Npedido = d.Npedido\n"
                        + "            WHERE d.Renglon = ? and d.Npedido = ?\n"
                        + "			and d.Estatus<>10");
                dp.setInt(1, id);
                dp.setString(2, p.getNpedido());
                ra = dp.executeQuery();
                if (ra.next()) {
                    return false;
                } else {
                    dp = datos[i].prepareStatement("UPDATE Pedidos SET TotalPares = ?,CostoTotal=? WHERE Npedido=?");
                    dp.setDouble(1, p.getTotalPares());
                    dp.setDouble(2, p.getCostoTotal());
                    dp.setString(3, p.getNpedido());
                    dp.executeUpdate();

                    dp = datos[i].prepareStatement("DELETE FROM Dpedido WHERE Renglon=? AND Npedido=?");
                    dp.setInt(1, id);
                    dp.setString(2, Npedido);
                    dp.executeUpdate();
                }
            }
            pa.commit();
            c.commit();
            dp.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            DB.cerrarPrep(dp);
            DB.rollback(pa);
        }
        return false;
    }

    public boolean eliminarPedidoB(Pedido p, int id, String Npedido) {
        boolean rpta = false;
        try {
            pa.setAutoCommit(false);
            dp = pa.prepareStatement("select d.Estatus,d.Npedido from RCPTPhylonA.dbo.Dpedido d\n"
                    + "inner join RCPTPhylonA.dbo.Pedidos p on p.Npedido = d.Npedido\n"
                    + "WHERE d.Renglon = ? and d.Npedido = ?\n"
                    + "and d.Estatus<>10");
            dp.setInt(1, id);
            dp.setString(2, p.getNpedido());
            ra = dp.executeQuery();
            if (ra.next()) {
                return false;
            } else {
                dp = pa.prepareStatement("UPDATE Pedidos SET TotalPares = ?,CostoTotal=? WHERE Npedido=?");
                dp.setDouble(1, p.getTotalPares());
                dp.setDouble(2, p.getCostoTotal());
                dp.setString(3, p.getNpedido());
                dp.executeUpdate();
                pa.commit();
                obj.eliminarDetalleA(id, Npedido);
                dp.close();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            DB.cerrarPrep(dp);
            DB.rollback(pa);
        }
        return rpta;
    }

    public int validarPedido(int Npedido) {
        try {
            dp = pa.prepareStatement("SELECT COUNT (Npedido) FROM Parametros  WHERE Npedido =?");
            dp.setInt(1, Npedido);

            rs = dp.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 1;
        }
    }

    public int validarProducto(int Id_Producto) {
        try {
            st = c.prepareStatement("SELECT COUNT (Id_Producto) FROM Pedidos  WHERE Npedido =? ");
            st.setInt(1, Id_Producto);

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
    
    public int buscarPedido(int Num){
        try {
            st = c.prepareStatement("SELECT COUNT (CONVERT(INT,Npedido)) FROM Pedidos  WHERE Npedido =? ");
            st.setInt(1, Num);

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

    public ArrayList<Pedido> getPedidoActual() {
        ArrayList<Pedido> listaP = new ArrayList<Pedido>();
        try {
            dp = pa.prepareStatement("SELECT  MAX(CONVERT(INT,Npedido)) as Pedido FROM Pedidos");

            rs = dp.executeQuery();

            while (rs.next()) {
                int Np = rs.getInt("Pedido");
                Pedido par = new Pedido();
                par.setNpedido(String.valueOf(Np));

                listaP.add(par);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaP;
    }

    public boolean getPedido() {
        try {
            st = c.prepareStatement("SELECT Npedido FROM Pedidos ORDER BY CAST(Npedido AS INT) ASC");
            rs = st.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean cancelarPedidoA(String Npedido) {
        try {
            pa.setAutoCommit(false);
            c.setAutoCommit(false);
            for (int i = 0; i < datos.length; i++) {
                dp = datos[i].prepareStatement("SELECT Estatus,Npedido FROM Pedidos WHERE Npedido = ? AND Estatus<>10");
                dp.setString(1, Npedido);
                rs = dp.executeQuery();

                if (rs.next()) {
                    return false;
                } else {
                    dp = datos[i].prepareStatement("DELETE Pedidos WHERE Npedido = ?");
                    dp.setString(1, Npedido);
                    dp.executeUpdate();
                }
            }
            pa.commit();
            c.commit();
            dp.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            DB.cerrarPrep(dp);
            DB.rollback(pa);
        }
        return false;
    }

    public boolean cancelarPedido(String Npedido) {
        boolean rpta = false;
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("SELECT Estatus,Npedido FROM Pedidos WHERE Npedido = ? AND Estatus<>10");
            st.setString(1, Npedido);
            rs = st.executeQuery();

            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("DELETE Pedidos WHERE Npedido = ?");
                st.setString(1, Npedido);
                rpta = st.executeUpdate() == 1 ? true : false;
                if (rpta) {
                    //rpta = parametro.cancelarPam(Npedido);
                    c.commit();
                    st.close();
                } else {
                    c.rollback();
                    st.close();
                }
                st.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            DB.cerrarPrep(st);
            DB.rollback(c);
        }
        return rpta;
    }

    public boolean cancelarPedidoB(String Npedido) {
        try {
            pa.setAutoCommit(false);
            dp = pa.prepareStatement("SELECT Estatus,Npedido FROM Pedidos WHERE Npedido = ? AND Estatus<>10");
            dp.setString(1, Npedido);
            rs = dp.executeQuery();

            if (rs.next()) {
                return false;
            } else {
                dp = pa.prepareStatement("DELETE Pedidos WHERE Npedido = ?");
                dp.setString(1, Npedido);
                dp.executeUpdate();
                pa.commit();
                dp.close();
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            DB.cerrarPrep(dp);
            DB.rollback(pa);
        }
        return false;
    }

    public ArrayList<Parametro> getParametro() {
        ArrayList<Parametro> listaP = new ArrayList<Parametro>();
        try {
            dp = pa.prepareStatement("SELECT  NPedido FROM Parametros");

            rs = dp.executeQuery();

            while (rs.next()) {
                String Np = rs.getString("NPedido");
                Parametro par = new Parametro();
                par.setNpedido(Np);

                listaP.add(par);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaP;
    }

    public boolean anularPedido(String Np) {
        try {
            c.setAutoCommit(false);
            st = c.prepareStatement("DELETE FROM Pedido WHERE Npedido = ?");
            st.setString(1, Np);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Conexion.cerrarPrep(st);
            return false;
        }
    }

    public boolean anularPedidoA(String Np) {
        try {
            pa.setAutoCommit(false);
            dp = pa.prepareStatement("DELETE FROM Pedido WHERE Npedido = ?");
            dp.setString(1, Np);
            dp.executeUpdate();
            pa.commit();
            dp.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Conexion.cerrarPrep(dp);
            return false;
        }
    }
}
