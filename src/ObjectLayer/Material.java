package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Material {

    private int Almacen,cveproveedor;

    public int getCveproveedor() {
        return cveproveedor;
    }

    public void setCveproveedor(int cveproveedor) {
        this.cveproveedor = cveproveedor;
    }
    private String DesAlm,descproveedor;

    public String getDescproveedor() {
        return descproveedor;
    }

    public void setDescproveedor(String descproveedor) {
        this.descproveedor = descproveedor;
    }

    public PreparedStatement getSt() {
        return st;
    }

    public void setSt(PreparedStatement st) {
        this.st = st;
    }

    public Connection getC() {
        return c;
    }

    public void setC(Connection c) {
        this.c = c;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    private String CveMat;
    private String Descripcion;
    private String CodigoSat;
    private String UdeC;
    private double Fcompra;
    private String UdeCs;
    private double Fconsumo;
    private double UltimoCosto;
    private double CostoCosteo;
    private double CantidadMinima;
    private double CantidadMaxima;
    private String TipoCosto;
    private String divisa;
    PreparedStatement st = null;
    DB db = new DB();
    Connection c = db.Cmp();
    //Connection c = Server.getCmpPhylon();
    ResultSet rs = null;

    public Material() {
    }

    public int getAlmacen() {
        return Almacen;
    }

    public void setAlmacen(int Almacen) {
        this.Almacen = Almacen;
    }

    public String getDesAlm() {
        return DesAlm;
    }

    public void setDesAlm(String DesAlm) {
        this.DesAlm = DesAlm;
    }

    public String getCveMat() {
        return CveMat;
    }

    public void setCveMat(String CveMat) {
        this.CveMat = CveMat;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCodigoSat() {
        return CodigoSat;
    }

    public void setCodigoSat(String CodigoSat) {
        this.CodigoSat = CodigoSat;
    }

    public String getUdeC() {
        return UdeC;
    }

    public void setUdeC(String UdeC) {
        this.UdeC = UdeC;
    }

    public double getFcompra() {
        return Fcompra;
    }

    public void setFcompra(double Fcompra) {
        this.Fcompra = Fcompra;
    }

    public String getUdeCs() {
        return UdeCs;
    }

    public void setUdeCs(String UdeCs) {
        this.UdeCs = UdeCs;
    }

    public double getFconsumo() {
        return Fconsumo;
    }

    public void setFconsumo(double Fconsumo) {
        this.Fconsumo = Fconsumo;
    }

    public double getUltimoCosto() {
        return UltimoCosto;
    }

    public void setUltimoCosto(double UltimoCosto) {
        this.UltimoCosto = UltimoCosto;
    }

    public double getCostoCosteo() {
        return CostoCosteo;
    }

    public void setCostoCosteo(double CostoCosteo) {
        this.CostoCosteo = CostoCosteo;
    }

    public double getCantidadMinima() {
        return CantidadMinima;
    }

    public void setCantidadMinima(double CantidadMinima) {
        this.CantidadMinima = CantidadMinima;
    }

    public double getCantidadMaxima() {
        return CantidadMaxima;
    }

    public void setCantidadMaxima(double CantidadMaxima) {
        this.CantidadMaxima = CantidadMaxima;
    }

    public String getTipoCosto() {
        return TipoCosto;
    }

    public void setTipoCosto(String TipoCosto) {
        this.TipoCosto = TipoCosto;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    @Override
    public String toString() {
        return this.Descripcion;
    }

    public Vector<Material> getMaterial() {
        Vector<Material> datos = new Vector<Material>();
        Material m = null;
        try {
            st = c.prepareStatement("SELECT * FROM Materiales ORDER BY Descripcion");
            rs = st.executeQuery();
            m = new Material();

            m.setCveMat(String.valueOf(0));
            m.setDescripcion("Selecciona un material");
            datos.add(m);
            while (rs.next()) {
                m = new Material();
                m.setCveMat(rs.getString("CveMat"));
                m.setDescripcion(rs.getString("Descripcion"));
                m.setCostoCosteo(rs.getDouble("CostoCosteo"));
                datos.add(m);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }
}
