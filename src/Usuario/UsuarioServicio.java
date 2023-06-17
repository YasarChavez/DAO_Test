package Usuario;

import Persistencia.UsuarioDAO;

import java.util.Scanner;

public class UsuarioServicio {
    private UsuarioDAO dao;

    public UsuarioServicio() {
        this.dao = new UsuarioDAO();
    }

    public void crearUsuario() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("\n***Nuevo Usuario***\n");
        System.out.println("Ingrese nombre: ");
        String nombre = leer.next();
        System.out.println("Ingrese apellido: ");
        String Apellido = leer.next();
        System.out.println("Ingrese el documento:");
        int documento = leer.nextInt();
        System.out.println("Ingrese direccion: ");
        String direccion = leer.next();
        try {
            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setApellido(Apellido);
            usuario.setDocumento(documento);
            usuario.setDireccion(direccion);
            dao.guardarUsuario(usuario);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarUsuario() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("\nIngrese el documento del usuario a eliminar: ");
        int id = leer.nextInt();
        try {
            dao.eliminarUsuarios(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public void mostrarUsuarios() throws Exception {
        try {
            dao.mostrarUsuarios();
        } catch (Exception e) {
            throw e;
        }


    }
}
