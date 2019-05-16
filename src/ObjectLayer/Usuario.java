package ObjectLayer;

import java.io.File;

public class Usuario {

    private int Id_Usuario;
    private String Usuario;
    private String Nombre;
    private String Password;
    private String Departamento;
    private boolean Activo;
    private File Foto;

    public Usuario() {
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean getActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    public File getFoto() {
        return Foto;
    }

    public void setFoto(File Foto) {
        this.Foto = Foto;
    }
    
    

    @Override
    public String toString() {
        return this.Departamento;
    }
}
