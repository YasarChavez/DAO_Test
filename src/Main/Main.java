package Main;


import Usuario.UsuarioServicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        UsuarioServicio usuarioServicio = new UsuarioServicio();
        int menu = 0;
        do {
            System.out.println("1. Crear Usuario");
            System.out.println("2. Mostrar Usuarios");
            System.out.println("3. Eliminar Usuario");
            System.out.println("4. Salir \n");
            menu = leer.nextInt();
            switch (menu) {
                case 1:
                    usuarioServicio.crearUsuario();
                    break;
                case 2:
                    usuarioServicio.mostrarUsuarios();
                    break;
                case 3:
                    usuarioServicio.eliminarUsuario();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (menu != 4);

    }

}
