package Controller;

import Model.GestionUsuarios;

import java.util.List;
import Data.GestionDatos;
import Model.Usuario;

public class ControllerUsuarios {


    public static GestionUsuarios cargaMasivaDatos(GestionUsuarios gestionUsuarios){
        GestionDatos.leerArchivoUsuarios(gestionUsuarios, "usuarios.txt");

        return gestionUsuarios;
    }
    /*public static List buscarVehiculo(GestionUsuarios gestionUsuarios, String nombre){
        return automotora.buscarAutoNombre(nombre);
    }*/
    public static Usuario agregarUsuario(GestionUsuarios gestionUsuarios, String nombre, String contrasena){
        return gestionUsuarios.añadirUsuario(nombre,contrasena);
    }

    public static void almacenarDatos(GestionUsuarios gestionUsuarios) {
        // Se registran los datos de los clientes en un archivo llamado "clientes.txt"
        GestionDatos.registrarDatos(gestionUsuarios.getUsuarios(), "usuario.txt");

    }


}
