package ObjectLayer;

public class Parametro {

    private String Npedido;
    private int Entrada;
    private int Salida;
    private int Factura;

    public Parametro() {
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
