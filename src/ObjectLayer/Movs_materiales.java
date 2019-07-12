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
public class Movs_materiales implements java.io.Serializable{
    private String nombre_material,material;
    private float costo;
    private double importe;
    private int surtido;

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getSurtido() {
        return surtido;
    }

    public void setSurtido(int surtido) {
        this.surtido = surtido;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
    public String getNombre_material() {
        return nombre_material;
    }

    public void setNombre_material(String nombre_material) {
        this.nombre_material = nombre_material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    private int cantidad;
}
