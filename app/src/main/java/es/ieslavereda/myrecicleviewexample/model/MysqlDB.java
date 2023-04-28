package es.ieslavereda.myrecicleviewexample.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.ieslavereda.myrecicleviewexample.MyDataSource;

public class MysqlDB {
    public List<Usuario> getAllUsers(){
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection connection = MyDataSource.getMySQLDataSource().getConnection();
             Statement statement = connection.createStatement();){
            int id,oficio;
            String nombre,apellidos;
            ResultSet rs = statement.executeQuery("SELECT * FROM USUARIO");
            while (rs.next()){
                id = rs.getInt("idUsuario");
                oficio = rs.getInt("oficio");
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellidos");
                usuarios.add(new Usuario(id,nombre, apellidos, oficio));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
