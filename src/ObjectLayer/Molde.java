/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectLayer;


/**
 *
 * @author GATEWAY1-
 */
public class Molde implements java.io.Serializable{
    private int linea,molde,cantidad;
    private String status,charlinea,punto;

    public String getCharlinea() {
        return charlinea;
    }

    public void setCharlinea(String charlinea) {
        this.charlinea = charlinea;
    }
    

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public String getPunto() {
        return punto;
    }

    public void setPunto(String punto) {
        this.punto = punto;
    }

    public int getMolde() {
        return molde;
    }

    public void setMolde(int molde) {
        this.molde = molde;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
