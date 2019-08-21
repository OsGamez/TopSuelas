package ObjectLayer;

import java.sql.Date;

public class Kardex {

    private int Almacen;
    private int Producto;
    private int Folio;
    private Date FMovimiento;
    private int Renglon;
    private String DocumentoRef;
    private int Nvale;
    private int CI_Pvr;
    private String Cuenta;
    private String SubCuenta;
    private int TotalPares;
    private double PCosto;
    private double PVenta;
    private double ImporteCosto;
    private int Cantidad1;
    private int Cantidad2;
    private int Cantidad3;
    private int Cantidad4;
    private int Cantidad5;
    private int Cantidad6;
    private int Cantidad7;
    private int Cantidad8;
    private int Cantidad9;
    private int Cantidad10;
    private int Cantidad11;
    private int Cantidad12;
    private String StockPedidos;
    private String StatusSalida;
    private String Observaciones;
    private String StatusImpresion;
    /*PENDIENTES*/
    private String Npedido;
    private int RenglonP;
    private String OCompra;
    private int CveConsignatario;
    /**/
    private int TipoDivisa;
    private double TipoCambio;
    private String Usuario;
    private String Factura;
    private String Serie;
    private Date Registro;

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getFactura() {
        return Factura;
    }

    public void setFactura(String Factura) {
        this.Factura = Factura;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }

    public Date getRegistro() {
        return Registro;
    }

    public void setRegistro(Date Registro) {
        this.Registro = Registro;
    }
    
    public int getAlmacen() {
        return Almacen;
    }

    public void setAlmacen(int Almacen) {
        this.Almacen = Almacen;
    }

    public int getProducto() {
        return Producto;
    }

    public void setProducto(int Producto) {
        this.Producto = Producto;
    }

    public int getFolio() {
        return Folio;
    }

    public void setFolio(int Folio) {
        this.Folio = Folio;
    }

    public Date getFMovimiento() {
        return FMovimiento;
    }

    public void setFMovimiento(Date FMovimiento) {
        this.FMovimiento = FMovimiento;
    }

    public int getRenglon() {
        return Renglon;
    }

    public void setRenglon(int Renglon) {
        this.Renglon = Renglon;
    }

    public String getDocumentoRef() {
        return DocumentoRef;
    }

    public void setDocumentoRef(String DocumentoRef) {
        this.DocumentoRef = DocumentoRef;
    }

    public int getNvale() {
        return Nvale;
    }

    public void setNvale(int Nvale) {
        this.Nvale = Nvale;
    }

    public int getCI_Pvr() {
        return CI_Pvr;
    }

    public void setCI_Pvr(int CI_Pvr) {
        this.CI_Pvr = CI_Pvr;
    }

    public String getCuenta() {
        return Cuenta;
    }

    public void setCuenta(String Cuenta) {
        this.Cuenta = Cuenta;
    }

    public String getSubCuenta() {
        return SubCuenta;
    }

    public void setSubCuenta(String SubCuenta) {
        this.SubCuenta = SubCuenta;
    }

    public int getTotalPares() {
        return TotalPares;
    }

    public void setTotalPares(int TotalPares) {
        this.TotalPares = TotalPares;
    }

    public double getPCosto() {
        return PCosto;
    }

    public void setPCosto(double PCosto) {
        this.PCosto = PCosto;
    }

    public double getPVenta() {
        return PVenta;
    }

    public void setPVenta(double PVenta) {
        this.PVenta = PVenta;
    }

    public double getImporteCosto() {
        return ImporteCosto;
    }

    public void setImporteCosto(double ImporteCosto) {
        this.ImporteCosto = ImporteCosto;
    }

    public int getCantidad1() {
        return Cantidad1;
    }

    public void setCantidad1(int Cantidad1) {
        this.Cantidad1 = Cantidad1;
    }

    public int getCantidad2() {
        return Cantidad2;
    }

    public void setCantidad2(int Cantidad2) {
        this.Cantidad2 = Cantidad2;
    }

    public int getCantidad3() {
        return Cantidad3;
    }

    public void setCantidad3(int Cantidad3) {
        this.Cantidad3 = Cantidad3;
    }

    public int getCantidad4() {
        return Cantidad4;
    }

    public void setCantidad4(int Cantidad4) {
        this.Cantidad4 = Cantidad4;
    }

    public int getCantidad5() {
        return Cantidad5;
    }

    public void setCantidad5(int Cantidad5) {
        this.Cantidad5 = Cantidad5;
    }

    public int getCantidad6() {
        return Cantidad6;
    }

    public void setCantidad6(int Cantidad6) {
        this.Cantidad6 = Cantidad6;
    }

    public int getCantidad7() {
        return Cantidad7;
    }

    public void setCantidad7(int Cantidad7) {
        this.Cantidad7 = Cantidad7;
    }

    public int getCantidad8() {
        return Cantidad8;
    }

    public void setCantidad8(int Cantidad8) {
        this.Cantidad8 = Cantidad8;
    }

    public int getCantidad9() {
        return Cantidad9;
    }

    public void setCantidad9(int Cantidad9) {
        this.Cantidad9 = Cantidad9;
    }

    public int getCantidad10() {
        return Cantidad10;
    }

    public void setCantidad10(int Cantidad10) {
        this.Cantidad10 = Cantidad10;
    }

    public int getCantidad11() {
        return Cantidad11;
    }

    public void setCantidad11(int Cantidad11) {
        this.Cantidad11 = Cantidad11;
    }

    public int getCantidad12() {
        return Cantidad12;
    }

    public void setCantidad12(int Cantidad12) {
        this.Cantidad12 = Cantidad12;
    }

    public String getStockPedidos() {
        return StockPedidos;
    }

    public void setStockPedidos(String StockPedidos) {
        this.StockPedidos = StockPedidos;
    }

    public String getStatusSalida() {
        return StatusSalida;
    }

    public void setStatusSalida(String StatusSalida) {
        this.StatusSalida = StatusSalida;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getStatusImpresion() {
        return StatusImpresion;
    }

    public void setStatusImpresion(String StatusImpresion) {
        this.StatusImpresion = StatusImpresion;
    }

    public String getNpedido() {
        return Npedido;
    }

    public void setNpedido(String Npedido) {
        this.Npedido = Npedido;
    }

    public int getRenglonP() {
        return RenglonP;
    }

    public void setRenglonP(int RenglonP) {
        this.RenglonP = RenglonP;
    }

    public String getOCompra() {
        return OCompra;
    }

    public void setOCompra(String OCompra) {
        this.OCompra = OCompra;
    }

    public int getCveConsignatario() {
        return CveConsignatario;
    }

    public void setCveConsignatario(int CveConsignatario) {
        this.CveConsignatario = CveConsignatario;
    }

    public int getTipoDivisa() {
        return TipoDivisa;
    }

    public void setTipoDivisa(int TipoDivisa) {
        this.TipoDivisa = TipoDivisa;
    }

    public double getTipoCambio() {
        return TipoCambio;
    }

    public void setTipoCambio(double TipoCambio) {
        this.TipoCambio = TipoCambio;
    }
    
    

}
