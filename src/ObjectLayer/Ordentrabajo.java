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
public class Ordentrabajo implements java.io.Serializable{
    private String fecha,nombreprensista,nombrelinea,nombreprod,status,pedido,maquina,query            ;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
    private ArrayList<Linea> arrlinea=new ArrayList<>();
    private ArrayList<Soloorden> arrorden=new ArrayList<>();

    public ArrayList<Soloorden> getArrorden() {
        return arrorden;
    }

    public void setArrorden(ArrayList<Soloorden> arrorden) {
        this.arrorden = arrorden;
    }
    

    public ArrayList<Linea> getArrlinea() {
        return arrlinea;
    }

    public void setArrlinea(ArrayList<Linea> arrlinea) {
        this.arrlinea = arrlinea;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }
    private int Orden,total,semana,estacion,prensista,Producto,linea,IdDOrden,cantidad,cantidadOrden,pi,pf;

    public int getCantidadOrden() {
        return cantidadOrden;
    }

    public void setCantidadOrden(int cantidadOrden) {
        this.cantidadOrden = cantidadOrden;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreprensista() {
        return nombreprensista;
    }

    public void setNombreprensista(String nombreprensista) {
        this.nombreprensista = nombreprensista;
    }

    public String getNombrelinea() {
        return nombrelinea;
    }

    public void setNombrelinea(String nombrelinea) {
        this.nombrelinea = nombrelinea;
    }

    public String getNombreprod() {
        return nombreprod;
    }

    public void setNombreprod(String nombreprod) {
        this.nombreprod = nombreprod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrden() {
        return Orden;
    }

    public void setOrden(int Orden) {
        this.Orden = Orden;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public int getEstacion() {
        return estacion;
    }

    public void setEstacion(int estacion) {
        this.estacion = estacion;
    }

    public int getPrensista() {
        return prensista;
    }

    public void setPrensista(int prensista) {
        this.prensista = prensista;
    }

    public int getProducto() {
        return Producto;
    }

    public void setProducto(int Producto) {
        this.Producto = Producto;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getIdDOrden() {
        return IdDOrden;
    }

    public void setIdDOrden(int IdDOrden) {
        this.IdDOrden = IdDOrden;
    }
    
    public int getPi() {
        return pi;
    }

    public void setPi(int pi) {
        this.pi = pi;
    }

    public int getPf() {
        return pf;
    }

    public void setPf(int pf) {
        this.pf = pf;
    }
}
