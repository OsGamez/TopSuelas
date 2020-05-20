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
public class KardexCmp implements java.io.Serializable{
    private String fechamov, fechadoc, serie,tipo, nombrecuenta,nombreproveedor,nombrealmacen,
            docref,material,nombrematerial,nombreusuario,status,operacion,Ordenc;

    public String getOrdenc() {
        return Ordenc;
    }

    public void setOrdenc(String Ordenc) {
        this.Ordenc = Ordenc;
    }
    private ArrayList<Movs_materiales> mat;

    public ArrayList<Movs_materiales> getMat() {
        return mat;
    }

    public void setMat(ArrayList<Movs_materiales> mat) {
        this.mat = mat;
    }

    
    public String getOperacion() {
        return operacion;
    }

    public int getFolio2() {
        return folio2;
    }

    public void setFolio2(int folio2) {
        this.folio2 = folio2;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    private int cuenta,subcuenta,folio,proveedor,almacen,renglon,usuario,folio2;

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    private float costo,importe,cantidad;

    public String getFechamov() {
        return fechamov;
    }

    public void setFechamov(String fechamov) {
        this.fechamov = fechamov;
    }

    public String getFechadoc() {
        return fechadoc;
    }

    public void setFechadoc(String fechadoc) {
        this.fechadoc = fechadoc;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombrecuenta() {
        return nombrecuenta;
    }

    public void setNombrecuenta(String nombrecuenta) {
        this.nombrecuenta = nombrecuenta;
    }

    public String getNombreproveedor() {
        return nombreproveedor;
    }

    public void setNombreproveedor(String nombreproveedor) {
        this.nombreproveedor = nombreproveedor;
    }

    public String getNombrealmacen() {
        return nombrealmacen;
    }

    public void setNombrealmacen(String nombrealmacen) {
        this.nombrealmacen = nombrealmacen;
    }

    public String getDocref() {
        return docref;
    }

    public void setDocref(String docref) {
        this.docref = docref;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getNombrematerial() {
        return nombrematerial;
    }

    public void setNombrematerial(String nombrematerial) {
        this.nombrematerial = nombrematerial;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public int getSubcuenta() {
        return subcuenta;
    }

    public void setSubcuenta(int subcuenta) {
        this.subcuenta = subcuenta;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public int getAlmacen() {
        return almacen;
    }

    public void setAlmacen(int almacen) {
        this.almacen = almacen;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public int getRenglon() {
        return renglon;
    }

    public void setRenglon(int renglon) {
        this.renglon = renglon;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
}
