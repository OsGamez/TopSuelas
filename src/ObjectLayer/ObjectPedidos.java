package ObjectLayer;

import DataAccesLayer.Conexion;
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
    
    //Connection c= Conexion.getRpt();
    //Connection pa = Conexion.getRcpt();
    
    PreparedStatement st, dp = null;
    ResultSet rs, ra = null;
    CallableStatement cl = null;
    ObjectDetalle obj = new ObjectDetalle();
    ObjectParametros parametro = new ObjectParametros();

    public boolean insertarVenta(Pedido p, ArrayList<Dpedido> detalle, Parametro pam) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("INSERT INTO Pedidos (Npedido,NpedidoCl, Id_Cliente,Fecha_Pedido,Fecha_Entrega, "
                    + "Condiciones,Observaciones,Id_Usuario,Serie,TotalPares,CostoTotal,Estatus,ParesSurt,OrdenCompra,"
                    + "Fecha_Recibido,Fecha_Captura)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            c.setAutoCommit(false);
            //c.getTransactionIsolation();
            st.setString(1, p.getNpedido());
            st.setString(2, p.getNpedidoCl());
            st.setInt(3, p.getId_Cliente());
            st.setDate(4, p.getFecha_Pedido());
            st.setDate(5, p.getFecha_Entrega());
            st.setString(6, p.getCondiciones());
            st.setString(7, p.getObservaciones());
            st.setInt(8, p.getId_Usuario());
            st.setString(9, p.getSerie());
            st.setInt(10, p.getTotalPares());
            st.setDouble(11, p.getCostoTotal());
            st.setString(12, p.getStatus());
            st.setInt(13, p.getParesSurt());
            st.setString(14, p.getOrdenCompra());
            st.setDate(15, p.getFecha_Recibido());
            st.setDate(16, p.getFecha_Captura());

            rpta = st.executeUpdate() == 1 ? true : false;

            if (rpta) {
                for (Dpedido det : detalle) {
                    det.setNpedido(p.getNpedido());
                    rpta = obj.insertDetalle(det);

                    if (!rpta) {
                        break;
                    }
                }
                pam.setNpedido(Integer.parseInt(p.getNpedido()));
                rpta = parametro.insertarPam(pam);
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
            Conexion.cerrarPrep(st);
            Conexion.rollback(c);
            Conexion.cerrarConexion(c);
        } catch (Exception e) {
            e.printStackTrace();
            Conexion.cerrarPrep(st);
            Conexion.rollback(c);
            Conexion.cerrarConexion(c);
        }
        return rpta;
    }

    public boolean insertarVentaA(Pedido p, ArrayList<Dpedido> detalle, Parametro pam) {
        boolean rpta = false;
        try {
            dp = pa.prepareStatement("INSERT INTO Pedidos (Npedido,NpedidoCl, Id_Cliente,Fecha_Pedido,Fecha_Entrega,"
                    + "Condiciones,Observaciones,Id_Usuario,Serie,TotalPares,CostoTotal,Estatus,ParesSurt,OrdenCompra,"
                    + "Fecha_Recibido,Fecha_Captura)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pa.setAutoCommit(false);
            //pa.getTransactionIsolation();
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

            rpta = dp.executeUpdate() == 1 ? true : false;

            if (rpta) {
                for (Dpedido dt : detalle) {
                    dt.setNpedido(p.getNpedido());
                    rpta = obj.insertDetalleA(dt);
                    if (!rpta) {
                        break;
                    }
                }
                pam.setNpedido(Integer.parseInt(p.getNpedido()));
                rpta = parametro.insertarPamA(pam);
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
            Conexion.rollbackA(pa);
            Conexion.cerrarConexionA(pa);
        } catch (Exception e) {
            e.printStackTrace();
            Conexion.cerrarPhylonA(dp);
            Conexion.rollbackA(pa);
            Conexion.cerrarConexionA(pa);
        }
        return rpta;
    }

    public boolean insertarParametro(Parametro p) {
        try {
            st = c.prepareStatement("INSERT INTO Parametros(Npedido, Entrada,Salida,Factura)"
                    + "values(?,?,?,?)");

            st.setInt(1, p.getNpedido());
            st.setInt(2, p.getEntrada());
            st.setInt(3, p.getSalida());
            st.setInt(4, p.getFactura());

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Pedido> pedidoGetByID(String filtro) {
        ArrayList<Pedido> listaPedido = new ArrayList<Pedido>();
        try {
            dp = pa.prepareStatement("Select p.Npedido,p.NpedidoCl,p.OrdenCompra,pd.Renglon,c.Id_Cliente,c.RazonSocial,c.Calle,c.CP,c.Colonia,cd.Descripcion as Ciudad,\n"
                    + "e.Descripcion as Estado,ps.Descripcion as Pais,c.DiasCredito,a.Id_Agente as Agente,c.Observaciones\n"
                    + ",p.TotalPares,p.CostoTotal,\n"
                    + "pd.Importe,p.Fecha_Pedido,p.Fecha_Captura,p.Fecha_Entrega,p.Fecha_Recibido,pd.Pares,\n"
                    + "p.Serie,pd.Estatus,prod.Id_Producto,prod.Descripcion as Suela,pd.Corrida,cl.Descripcion as Color,\n"
                    + "pd.Precio,\n"
                    + "pd.C1,pd.C2,pd.C3,pd.C4,pd.C5,pd.C6,pd.CSurt1,pd.CSurt2,pd.CSurt3,pd.CSurt4,pd.CSurt5,pd.CSurt6 \n"
                    + "from Pedidos p inner join Dpedido pd\n"
                    + "on p.Npedido = pd.Npedido \n"
                    + "inner join  CobranzaPhy.dbo.Clientes as c on p.Id_Cliente = c.Id_Cliente\n"
                    + "inner join CobranzaPhy.dbo.Agentes as a on c.Id_Agente = a.Id_Agente\n"
                    + "inner join CobranzaPhy.dbo.Ciudades as cd on c.Id_Ciudad = cd.Id_Ciudad\n"
                    + "inner join CobranzaPhy.dbo.Estados as e on c.Id_Estado = e.Id_Estado\n"
                    + "inner join CobranzaPhy.dbo.Paises as ps on c.Id_Pais = ps.Id_Pais\n"
                    + "inner join ProduccionPhy.dbo.Producto as prod on pd.Id_Producto = prod.Id_Producto\n"
                    + "inner join ProduccionPhy.dbo.Color as cl on prod.Id_Color = cl.Id_Color\n"
                    + "where p.Npedido = ?");

            dp.setString(1, filtro);
            ra = dp.executeQuery();
            while (ra.next()) {
                Pedido p = new Pedido();
                p.setNpedido(ra.getString("Npedido"));
                p.setId_Cliente(ra.getInt("Id_Cliente"));
                p.setRenglon(ra.getInt("Renglon"));
                p.setNpedidoCl(ra.getString("NpedidoCl"));
                p.setRsocial(ra.getString("RazonSocial"));
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
                p.setCSurt1(ra.getInt("CSurt1"));
                p.setCSurt2(ra.getInt("CSurt2"));
                p.setCSurt3(ra.getInt("CSurt3"));
                p.setCSurt4(ra.getInt("CSurt4"));
                p.setCSurt5(ra.getInt("CSurt5"));
                p.setCSurt6(ra.getInt("CSurt6"));
                p.setPrecio(ra.getDouble("Precio"));
                listaPedido.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPedido;
    }
    
    public ArrayList<Pedido> pedidoGetByIDA(String filtro, String filtro2) {
        ArrayList<Pedido> listaPedido = new ArrayList<Pedido>();
        try {
            st = c.prepareStatement("Select pd.Id_Detalle \n"
                    + "from  Dpedido p\n"
                    + "inner join PtPhylon.dbo.Dpedido pd\n"
                    + "on p.Npedido = pd.Npedido\n"
                    + "where pd.Serie = ? and pd.Npedido = ?\n"
                    + "group by pd.Id_Detalle");
            st.setString(1, filtro);
            st.setString(2, filtro2);
            rs = st.executeQuery();
            while (rs.next()) {
                //String Np = rs.getString("Npedido");
                int Detalle = rs.getInt("Id_Detalle");
                Pedido p = new Pedido();
                //p.setNpedido(Np);
                // p.setId_Detalle(Detalle);

                listaPedido.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPedido;
    }

    public boolean actualizarPedido(Pedido p, Dpedido dt, int Id) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("select p.Estatus,p.Npedido from RPTPhylon.dbo.Dpedido d\n"
                    + "inner join RPTPhylon.dbo.Pedidos p on p.Npedido = d.Npedido\n"
                    + "WHERE d.Renglon = ? and d.Npedido = ?\n"
                    + "and d.Estatus<>10");
            c.setAutoCommit(false);
            st.setInt(1, Id);
            st.setString(2, p.getNpedido());
            rs = st.executeQuery();
            if (rs.next()) {
                return false;
            } else {
                st = c.prepareStatement("UPDATE Pedidos SET TotalPares = ?, CostoTotal=? WHERE Npedido=?");
                st.setDouble(1, p.getTotalPares());
                st.setDouble(2, p.getCostoTotal());
                st.setString(3, p.getNpedido());
                rpta = st.executeUpdate() == 1 ? true : false;
                if (rpta) {
                    dt.setNpedido(p.getNpedido());
                    rpta = obj.actualizarDetalle(dt);
                    if (rpta) {
                        c.commit();
                    } else {
                        Conexion.rollback(c);
                    }
                } else {
                    Conexion.rollback(c);
                }
                Conexion.cerrarPrep(st);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rpta;
    }

    public boolean actualizarPedidoA(Pedido p, Dpedido dt, int Id) {
        boolean rpta = false;
        try {
            dp = pa.prepareStatement("select p.Estatus,p.Npedido from RCPTPhylonA.dbo.Dpedido d\n"
                    + "            inner join RCPTPhylonA.dbo.Pedidos p on p.Npedido = d.Npedido\n"
                    + "            WHERE d.Renglon = ? and d.Npedido = ?\n"
                    + "			and d.Estatus<>10");
            pa.setAutoCommit(false);
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
                rpta = dp.executeUpdate() == 1 ? true : false;
                if (rpta) {
                    dt.setNpedido(p.getNpedido());
                    rpta = obj.actualizarDetalleA(dt);
                    if (rpta) {
                        pa.commit();
                    } else {
                        Conexion.rollbackA(pa);
                    }
                } else {
                    Conexion.rollbackA(pa);
                }
                Conexion.cerrarPhylonA(dp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rpta;

    }

    public boolean agregarPedido(Pedido p, ArrayList<Dpedido> detalle, String Np) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("select p.Estatus,p.Npedido from RPTPhylon.dbo.Dpedido d\n"
                    + "inner join RPTPhylon.dbo.Pedidos p on p.Npedido = d.Npedido\n"
                    + "where p.Npedido = ? and p.Estatus<>10");
            c.setAutoCommit(false);
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
                            break;
                        }
                    }
                    if (rpta) {
                        c.commit();
                    } else {
                        Conexion.rollback(c);
                    }
                } else {
                    Conexion.rollback(c);
                }
                Conexion.cerrarPrep(st);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rpta;
    }

    public boolean agregarPedidoA(Pedido p, ArrayList<Dpedido> detalle, String Np) {
        boolean rpta = false;
        try {
            dp = pa.prepareStatement("select p.Estatus,p.Npedido from RCPTPhylonA.dbo.Dpedido d\n"
                    + "inner join RCPTPhylonA.dbo.Pedidos p on p.Npedido = d.Npedido\n"
                    + "where p.Npedido = ? and p.Estatus<>10");
            pa.setAutoCommit(false);
            dp.setString(1, Np);
            ra = dp.executeQuery();
            if (ra.next()) {
                return false;
            } else {
                dp = pa.prepareStatement("UPDATE Pedidos SET TotalPares = ?,CostoTotal=? WHERE Npedido=?");
                dp.setDouble(1, p.getTotalPares());
                dp.setDouble(2, p.getCostoTotal());
                dp.setString(3, p.getNpedido());
                rpta = dp.executeUpdate() == 1 ? true : false;
                if (rpta) {
                    for (Dpedido dt : detalle) {
                        dt.setNpedido(p.getNpedido());
                        rpta = obj.insertDetalleA(dt);
                        if (!rpta) {
                            break;
                        }
                    }
                    if (rpta) {
                        pa.commit();
                    } else {
                        Conexion.rollbackA(pa);
                    }
                } else {
                    Conexion.rollbackA(pa);
                }
                Conexion.cerrarPhylonA(dp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rpta;
    }

    public boolean eliminarPedido(Pedido p, int id) {
        boolean rpta = false;
        try {
            st = c.prepareStatement("select p.Estatus,p.Npedido from RPTPhylon.dbo.Dpedido d\n"
                    + "            inner join RPTPhylon.dbo.Pedidos p on p.Npedido = d.Npedido\n"
                    + "            WHERE d.Renglon = ? and d.Npedido = ?\n"
                    + "			and d.Estatus<>10");
            c.setAutoCommit(false);
            st.setInt(1, id);
            st.setString(2, p.getNpedido());
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
                    rpta = obj.eliminarDetalle(id, p.getNpedido());
                    if (rpta) {
                        c.commit();
                    } else {
                        Conexion.rollback(c);
                    }
                } else {
                    Conexion.rollback(c);
                }
                Conexion.cerrarPrep(st);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rpta;
    }

    public boolean eliminarPedidoA(Pedido p, int id) {
        boolean rpta = false;
        try {
            dp = pa.prepareStatement("select p.Estatus,p.Npedido from RCPTPhylonA.dbo.Dpedido d\n"
                    + "            inner join RCPTPhylonA.dbo.Pedidos p on p.Npedido = d.Npedido\n"
                    + "            WHERE d.Renglon = ? and d.Npedido = ?\n"
                    + "			and d.Estatus<>10");
            pa.setAutoCommit(false);
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
                rpta = dp.executeUpdate() == 1 ? true : false;
                if (rpta) {
                    rpta = obj.eliminarDetalleA(id, p.getNpedido());
                    if (rpta) {
                        pa.commit();
                    } else {
                        Conexion.rollbackA(pa);
                    }
                } else {
                    Conexion.rollbackA(pa);
                }
                Conexion.cerrarPhylonA(dp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rpta;
    }

    public int validarPedido(int Npedido) {
        try {
            st = c.prepareStatement("SELECT COUNT (Npedido) FROM Parametros  WHERE Npedido =?");
            st.setInt(1, Npedido);

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

    public ArrayList<Parametro> getPedidoActual() {
        ArrayList<Parametro> listaP = new ArrayList<Parametro>();
        try {
            st = c.prepareStatement("SELECT  MAX(CONVERT(INT,Npedido)) as Pedido FROM Pedidos");

            rs = st.executeQuery();

            while (rs.next()) {
                int Np = rs.getInt("Pedido");
                Parametro par = new Parametro();
                par.setNpedido(Np);

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
}