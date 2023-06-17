package Persistencia;

import Persistencia.DAO;
import Usuario.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public final class UsuarioDAO extends DAO {

    public void guardarUsuario(Usuario usuario) throws Exception {
        try {
            if (usuario == null){
                throw new Exception("El usuario es nulo!");
            }
            String sql = "INSERT INTO usuarios (nombre, apellido,documento, direccion) " +
                    "VALUES ('" + usuario.getNombre() + "','" + usuario.getApellido() + "','" + usuario.getDocumento() + "','" + usuario.getDireccion() + "')";
            insertarModificarEliminar(sql);
        }catch (Exception e){
            throw e;
        }
    }
    public void eliminarUsuarios(int documento) throws Exception {
        try {
            String sql = "DELETE FROM usuarios WHERE documento = " + documento;
            insertarModificarEliminar(sql);
        }catch (Exception e){
            throw e;
        }
    }
    public void mostrarUsuarios() throws Exception {
        try {
            String sql = "SELECT * FROM usuarios";
            consultarBaseDeDatos(sql);
            System.out.println("Usuarios: \n");
            while (resultado.next()) {
                System.out.println("Nombre: " + resultado.getString("nombre"));
                System.out.println("Apellido: " + resultado.getString("apellido"));
                System.out.println("Documento: " + resultado.getInt("documento"));
                System.out.println("Direccion: " + resultado.getString("direccion"));
                System.out.println("-----------------------------");
            }
        }catch (Exception e){
            throw e;
        }
    }
}
