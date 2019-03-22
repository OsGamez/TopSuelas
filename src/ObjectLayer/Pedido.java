package ObjectLayer;

import java.sql.Date;

public class Pedido {

    private String Npedido;
    private String NpedidoCl;
    private int Id_Cliente;
    private int Renglon;
    private int Id_A;
    private Date Fecha_Pedido;
    private Date Fecha_Entrega;
    private String Condiciones;
    private String Observaciones;
    private int Id_Usuario;
    private String Serie;
    private int TotalPares;
    private double Importe;
    private String Status;
    private int ParesSurt;
    private int Pares;
    private String OrdenCompra;
    private Date Fecha_Recibido;
    private Date Fecha_Captura;
    private double CostoTotal;
    private String Rsocial;
    private String Calle;
    private String Cp;
    private String Colonia;
    private String Estado;
    private String Ciudad;
    private String Pais;
    private int Agente;
    private int Cred;
    private String corrida;
    private String Suela;
    private String Color;
    private int C1;
    private int C2;
    private int C3;
    private int C4;
    private int C5;
    private int C6;
    private int CSurt1;
    private int CSurt2;
    private int CSurt3;
    private int CSurt4;
    private int CSurt5;
    private int CSurt6;
    private int Id_Producto;
    private double Precio;

    public Pedido() {
    }

    public int getId_A() {
        return Id_A;
    }

    public void setId_A(int Id_A) {
        this.Id_A = Id_A;
    }

    public int getRenglon() {
        return Renglon;
    }

    public void setRenglon(int Renglon) {
        this.Renglon = Renglon;
    }

    public int getPares() {
        return Pares;
    }

    public void setPares(int Pares) {
        this.Pares = Pares;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getId_Producto() {
        return Id_Producto;
    }

    public void setId_Producto(int Id_Producto) {
        this.Id_Producto = Id_Producto;
    }

    public double getCostoTotal() {
        return CostoTotal;
    }

    public void setCostoTotal(double CostoTotal) {
        this.CostoTotal = CostoTotal;
    }

    public String getRsocial() {
        return Rsocial;
    }

    public int getCSurt2() {
        return CSurt2;
    }

    public void setCSurt2(int CSurt2) {
        this.CSurt2 = CSurt2;
    }

    public int getCSurt5() {
        return CSurt5;
    }

    public void setCSurt5(int CSurt5) {
        this.CSurt5 = CSurt5;
    }

    public void setRsocial(String Rsocial) {
        this.Rsocial = Rsocial;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public String getCp() {
        return Cp;
    }

    public void setCp(String Cp) {
        this.Cp = Cp;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public int getAgente() {
        return Agente;
    }

    public void setAgente(int Agente) {
        this.Agente = Agente;
    }

    public int getCred() {
        return Cred;
    }

    public void setCred(int Cred) {
        this.Cred = Cred;
    }

    public String getCorrida() {
        return corrida;
    }

    public void setCorrida(String corrida) {
        this.corrida = corrida;
    }

    public String getSuela() {
        return Suela;
    }

    public void setSuela(String Suela) {
        this.Suela = Suela;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public int getC1() {
        return C1;
    }

    public void setC1(int C1) {
        this.C1 = C1;
    }

    public int getC2() {
        return C2;
    }

    public void setC2(int C2) {
        this.C2 = C2;
    }

    public int getC3() {
        return C3;
    }

    public void setC3(int C3) {
        this.C3 = C3;
    }

    public int getC4() {
        return C4;
    }

    public void setC4(int C4) {
        this.C4 = C4;
    }

    public int getC5() {
        return C5;
    }

    public void setC5(int C5) {
        this.C5 = C5;
    }

    public int getC6() {
        return C6;
    }

    public void setC6(int C6) {
        this.C6 = C6;
    }

    public int getCSurt1() {
        return CSurt1;
    }

    public void setCSurt1(int CSurt1) {
        this.CSurt1 = CSurt1;
    }

    public int getCSurt3() {
        return CSurt3;
    }

    public void setCSurt3(int CSurt3) {
        this.CSurt3 = CSurt3;
    }

    public int getCSurt4() {
        return CSurt4;
    }

    public void setCSurt4(int CSurt4) {
        this.CSurt4 = CSurt4;
    }

    public int getCSurt6() {
        return CSurt6;
    }

    public void setCSurt6(int CSurt6) {
        this.CSurt6 = CSurt6;
    }

    public String getNpedido() {
        return Npedido;
    }

    public void setNpedido(String Npedido) {
        this.Npedido = Npedido;
    }

    public String getNpedidoCl() {
        return NpedidoCl;
    }

    public void setNpedidoCl(String NpedidoCl) {
        this.NpedidoCl = NpedidoCl;
    }

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    public Date getFecha_Pedido() {
        return Fecha_Pedido;
    }

    public void setFecha_Pedido(Date Fecha_Pedido) {
        this.Fecha_Pedido = Fecha_Pedido;
    }

    public Date getFecha_Entrega() {
        return Fecha_Entrega;
    }

    public void setFecha_Entrega(Date Fecha_Entrega) {
        this.Fecha_Entrega = Fecha_Entrega;
    }

    public String getCondiciones() {
        return Condiciones;
    }

    public void setCondiciones(String Condiciones) {
        this.Condiciones = Condiciones;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }

    public int getTotalPares() {
        return TotalPares;
    }

    public void setTotalPares(int TotalPares) {
        this.TotalPares = TotalPares;
    }

    public double getImporte() {
        return Importe;
    }

    public void setImporte(double Importe) {
        this.Importe = Importe;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getParesSurt() {
        return ParesSurt;
    }

    public void setParesSurt(int ParesSurt) {
        this.ParesSurt = ParesSurt;
    }

    public String getOrdenCompra() {
        return OrdenCompra;
    }

    public void setOrdenCompra(String OrdenCompra) {
        this.OrdenCompra = OrdenCompra;
    }

    public Date getFecha_Recibido() {
        return Fecha_Recibido;
    }

    public void setFecha_Recibido(Date Fecha_Recibido) {
        this.Fecha_Recibido = Fecha_Recibido;
    }

    public Date getFecha_Captura() {
        return Fecha_Captura;
    }

    public void setFecha_Captura(Date Fecha_Captura) {
        this.Fecha_Captura = Fecha_Captura;
    }
    /*@Override
    public String toString(){
        return String.valueOf(this.Id_Detalle);
    }*/
}
