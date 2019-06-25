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
public class Sesioninfo implements java.io.Serializable{
    static private String serie,usuario,ip,contraseña;

    static private int id_usuario;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        Sesioninfo.id_usuario = id_usuario;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        Sesioninfo.serie = serie;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        Sesioninfo.usuario = usuario;
    }   
        public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        Sesioninfo.ip = ip;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        Sesioninfo.contraseña = contraseña;
    }
}
