package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ObjectUsuarios {

    Connection us = Server.getUsuario();
//    DB db = new DB();
//    Connection us = db.User();
    PreparedStatement st = null;
    ResultSet rs = null;

    private boolean ComprobatCn() {
        if (us != null) {
            System.out.println("Conectado");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo conectar");
        }
        return false;
    }

    public boolean registrarUsuario(Usuario usuario) {
        try {
            st = us.prepareStatement("INSERT INTO Usuarios (Nombre,Usuario,Password,Departamento,Activo)"
                    + "VALUES(?,?,?,?,?)");

            st.setString(1, usuario.getNombre());
            st.setString(2, usuario.getUsuario());
            st.setString(3, usuario.getPassword());
            st.setString(4, usuario.getDepartamento());
            st.setBoolean(5, usuario.getActivo());
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public int validarUsuario(String usuario) {
        try {
            st = us.prepareStatement("SELECT COUNT (Id_Usuario) FROM Usuarios WHERE Usuario=? AND Activo = 1");
            st.setString(1, usuario);

            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 1;
        }
    }

    public boolean Login(Usuario user) {
        if(ComprobatCn()){
           try {
            st = us.prepareStatement("SELECT Id_Usuario,Nombre,Password,Usuario,Departamento FROM Usuarios\n"
                    + "WHERE Usuario= ?");
            st.setString(1, user.getUsuario());
            rs = st.executeQuery();

            if (rs.next()) {
                if (user.getPassword().equals(rs.getString(3))) {

                    user.setId_Usuario(rs.getInt(1));
                    user.setNombre(rs.getString(4));
                    user.setDepartamento(rs.getString(5));

                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
        }else{
            return false;
        }
    }

    public boolean usuarioUpdate(Usuario usuario) {
        try {
            st = us.prepareStatement("UPDATE Usuarios SET Usuario=?, Nombre=?,"
                    + "Password=?,Departamento=? WHERE Id_Usuario=?");
            st.setString(1, usuario.getUsuario());
            st.setString(2, usuario.getNombre());
            st.setString(3, usuario.getPassword());
            st.setString(4, usuario.getDepartamento());
            st.setInt(5, usuario.getId_Usuario());

            st.executeUpdate();
            st.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<Usuario> usuariosGetAll() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

        try {
            st = us.prepareStatement("SELECT Id_Usuario,Nombre,Usuario,Password,Departamento\n"
                    + "FROM Usuarios WHERE Activo=1 ORDER BY Nombre");

            rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id_Usuario");
                String nombre = rs.getString("Nombre");
                String usuario = rs.getString("Usuario");
                String pass = rs.getString("Password");
                String Dep = rs.getString("Departamento");

                Usuario us = new Usuario();
                us.setId_Usuario(id);
                us.setNombre(nombre);
                us.setUsuario(usuario);
                us.setPassword(pass);
                us.setDepartamento(Dep);

                listaUsuarios.add(us);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaUsuarios;
    }

    public ArrayList<Usuario> usuarioSearch(String filtro) {
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        try {
            st = us.prepareStatement("SELECT Id_Usuario,Nombre,Usuario,Password,Departamento\n"
                    + "FROM Usuarios WHERE Activo=1 AND Nombre LIKE'%" + filtro + "%'"
                    + "ORDER BY Nombre");

            rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id_Usuario");
                String nombre = rs.getString("Nombre");
                String usuario = rs.getString("Usuario");
                String pass = rs.getString("Password");
                String Dep = rs.getString("Departamento");

                Usuario us = new Usuario();
                us.setId_Usuario(id);
                us.setNombre(nombre);
                us.setUsuario(usuario);
                us.setPassword(pass);
                us.setDepartamento(Dep);
                listaUsuarios.add(us);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaUsuarios;
    }

    public void usuarioDelete(int Id_Usuario) {
        try {
            st = us.prepareStatement("UPDATE Usuarios SET Activo = 0 WHERE Id_Usuario = ?");
            st.setInt(1, Id_Usuario);
            st.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public InputStream buscarFoto(Usuario usuario) {
        InputStream streamFoto = null;
        try {
            st = us.prepareStatement("SELECT Imagen FROM Usuarios WHERE Id_Usuario = ?");
            st.setInt(1, usuario.getId_Usuario());
            rs = st.executeQuery();

            while (rs.next()) {
                streamFoto = rs.getBinaryStream("Imagen");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return streamFoto;
    }
}
