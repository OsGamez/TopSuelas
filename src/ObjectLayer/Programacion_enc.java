/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectLayer;

import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class Programacion_enc{
    private int renglon,linea,pares,id_arbol,producto,radiado;
    private String desclinea,color,raiz,horma;

    public String getRaiz() {
        return raiz;
    }

    public void setRaiz(String raiz) {
        this.raiz = raiz;
    }
    private ArrayList<Programacion_det> arrdet= new ArrayList<>();

    public int getRenglon() {
        return renglon;
    }

    public int getRadiado() {
        return radiado;
    }

    public void setRadiado(int radiado) {
        this.radiado = radiado;
    }

    public String getHorma() {
        return horma;
    }

    public void setHorma(String horma) {
        this.horma = horma;
    }

    public void setRenglon(int renglon) {
        this.renglon = renglon;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getPares() {
        return pares;
    }

    public void setPares(int pares) {
        this.pares = pares;
    }

    public int getId_arbol() {
        return id_arbol;
    }

    public void setId_arbol(int id_arbol) {
        this.id_arbol = id_arbol;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public String getDesclinea() {
        return desclinea;
    }

    public void setDesclinea(String desclinea) {
        this.desclinea = desclinea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Programacion_det> getArrdet() {
        return arrdet;
    }

    public void setArrdet(ArrayList<Programacion_det> arrdet) {
        this.arrdet = arrdet;
    }
}
