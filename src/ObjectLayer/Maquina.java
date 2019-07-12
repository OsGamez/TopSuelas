/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectLayer;

import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author GATEWAY1-
 */
public class Maquina implements java.io.Serializable {

    private int estaciones, estacionesmod;
    private String Maquina;
    PreparedStatement st = null;
//    DB db = new DB();
//    Connection c = db.Produccion();
    Connection c = Server.getProduccion();
    ResultSet rs = null;

    public int getEstacionesmod() {
        return estacionesmod;
    }

    public void setEstacionesmod(int estacionesmod) {
        this.estacionesmod = estacionesmod;
    }

    public int getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(int estaciones) {
        this.estaciones = estaciones;
    }
    private String status, nombre;

    public String getMaquina() {
        return Maquina;
    }

    public void setMaquina(String Maquina) {
        this.Maquina = Maquina;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Vector<Maquina> getMaquinamodelo() {
        Vector<Maquina> datos = new Vector<Maquina>();
        try {
            st = c.prepareStatement("SELECT * FROM maquinas WHERE stat = '1'");
            rs = st.executeQuery();
            Maquina maq = new Maquina();
            maq.setMaquina("");
            maq.setStatus("1");
            datos.add(maq);
            while (rs.next()) {
                maq=new Maquina();
                maq.setMaquina(rs.getString("Maquina"));
                maq.setStatus(rs.getString("stat"));
                datos.add(maq);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }

}
