package ObjectLayer;

import DataAccesLayer.Conexion;
import DataAccesLayer.DB;
import DataAccesLayer.Server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectVersioning {

    Connection us = Conexion.getUsuario();
//    DB db = new DB();
//    Connection us = db.User();
    PreparedStatement st = null;
    ResultSet rs = null;

    public String validarVersion() {
        String version = "";
        try {
            st = us.prepareStatement("SELECT versioning from versiones");
            rs = st.executeQuery();
            if (rs.next()) {
                version = rs.getString("versioning");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return version;
    }

}
