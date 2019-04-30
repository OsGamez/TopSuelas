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
public class Consumo implements java.io.Serializable{
    private int producto,punto;
    private float peso,desperdicio;
    private String descripcionprod,consulta;

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getPunto() {
        return punto;
    }

    public void setPunto(int punto) {
        this.punto = punto;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getDesperdicio() {
        return desperdicio;
    }

    public void setDesperdicio(float desperdicio) {
        this.desperdicio = desperdicio;
    }

    public String getDescripcionprod() {
        return descripcionprod;
    }

    public void setDescripcionprod(String descripcionprod) {
        this.descripcionprod = descripcionprod;
    }
    
}
