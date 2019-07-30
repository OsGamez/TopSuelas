package ObjectLayer;

public class Parametro {

    private String Npedido;
    private int Entrada;
    private int Salida;
    private int Factura;
    private int Folio;
    private String Mes;
    
    public Parametro() {
    }

    public int getFolio() {
        return Folio;
    }

    public void setFolio(int Folio) {
        this.Folio = Folio;
    }

    public String getMes() {
        return Mes;
    }

    public void setMes(String Mes) {
        this.Mes = Mes;
    }
    
    public String getNpedido() {
        return Npedido;
    }

    public void setNpedido(String Npedido) {
        this.Npedido = Npedido;
    }

    public int getEntrada() {
        return Entrada;
    }

    public void setEntrada(int Entrada) {
        this.Entrada = Entrada;
    }

    public int getSalida() {
        return Salida;
    }

    public void setSalida(int Salida) {
        this.Salida = Salida;
    }

    public int getFactura() {
        return Factura;
    }

    public void setFcatura(int Factura) {
        this.Factura = Factura;
    }
}
