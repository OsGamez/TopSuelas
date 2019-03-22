package ObjectLayer;

public class Costo {

    private int Id_Producto;
    private String Descripcion;
    private int Id_ProductoRCPT;
    private String Dp;
    private int Punto;
    private double PesoGr;
    private double Tolerancia;
    private double Colada;
    private String CveMat;
    private String Material;
    private double Ptolerancia;
    private double Pcolada;
    private double PesoTotal;
    private double Precio;
    private double Costo;
    private int Linea;

    public Costo() {
    }

    public String getDp() {
        return Dp;
    }

    public void setDp(String Dp) {
        this.Dp = Dp;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
    }

    public int getId_Producto() {
        return Id_Producto;
    }

    public void setId_Producto(int Id_Producto) {
        this.Id_Producto = Id_Producto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getId_ProductoRCPT() {
        return Id_ProductoRCPT;
    }

    public void setId_ProductoRCPT(int Id_ProductoRCPT) {
        this.Id_ProductoRCPT = Id_ProductoRCPT;
    }

    public int getPunto() {
        return Punto;
    }

    public void setPunto(int Punto) {
        this.Punto = Punto;
    }

    public double getPesoGr() {
        return PesoGr;
    }

    public void setPesoGr(double PesoGr) {
        this.PesoGr = PesoGr;
    }

    public double getTolerancia() {
        return Tolerancia;
    }

    public void setTolerancia(double Tolerancia) {
        this.Tolerancia = Tolerancia;
    }

    public double getColada() {
        return Colada;
    }

    public void setColada(double Colada) {
        this.Colada = Colada;
    }

    public String getCveMat() {
        return CveMat;
    }

    public void setCveMat(String CveMat) {
        this.CveMat = CveMat;
    }

    public double getPtolerancia() {
        return Ptolerancia;
    }

    public void setPtolerancia(double Ptolerancia) {
        this.Ptolerancia = Ptolerancia;
    }

    public double getPcolada() {
        return Pcolada;
    }

    public void setPcolada(double Pcolada) {
        this.Pcolada = Pcolada;
    }

    public double getPesoTotal() {
        return PesoTotal;
    }

    public void setPesoTotal(double PesoTotal) {
        this.PesoTotal = PesoTotal;
    }

    public double getCosto() {
        return Costo;
    }

    public void setCosto(double Costo) {
        this.Costo = Costo;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getLinea() {
        return Linea;
    }

    public void setLinea(int Linea) {
        this.Linea = Linea;
    }

}
