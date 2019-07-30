
package ObjectLayer;

import java.sql.Date;


public class invFolio {
    
    private int Folio;
    private Date Fecha;
    private int Almacen;
    private String Estatus;
    private String Tipo;
    private int Pares;
    private boolean Estado;

    public boolean getEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public int getFolio() {
        return Folio;
    }

    public void setFolio(int Folio) {
        this.Folio = Folio;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public int getAlmacen() {
        return Almacen;
    }

    public void setAlmacen(int Almacen) {
        this.Almacen = Almacen;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String Estatus) {
        this.Estatus = Estatus;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getPares() {
        return Pares;
    }

    public void setPares(int Pares) {
        this.Pares = Pares;
    }
}
