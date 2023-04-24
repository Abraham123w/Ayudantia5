package Model;


import Data.GestionDatos;
//import Utils.GestorPDF;
import Utils.ValidadorContrasena;
import Utils.ValidadorDeUsuario;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionUsuarios {
    private List<Usuario> usuarios;

    public GestionUsuarios() {
        this.usuarios = new ArrayList<Usuario>();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public Usuario buscarUsuarioPorNombre(String nombre) {
        // Se inicializa la variable "cliente" como nula
        Usuario usuario = null;
        // Se recorre la lista de clientes de la automotora
        for (Usuario clienteAux : this.usuarios) {
            // Si se encuentra un cliente con el RUT indicado, se asigna a la variable "cliente" y se detiene el ciclo
            if (clienteAux.getNombreUsuario().equals(nombre)) {
                usuario = clienteAux;
                break;
            }
        }

        return usuario;
    }


    public boolean añadirUsuario1(String nombre, String contrasena) {
        // Verifica que el RUT ingresado sea válido y que no exista ya un cliente con ese RUT en la base de datos
        if ( this.buscarUsuarioPorNombre(nombre)==null) {
            // Si el RUT es válido y no existe un cliente con ese RUT, crea un nuevo objeto "Cliente" con los datos ingresados y lo agrega a la lista de clientes
            Usuario usuario= new Usuario(nombre,contrasena);
            this.usuarios.add(usuario);
            // Retorna verdadero para indicar que el cliente fue añadido correctamente
            return true;
        } else {
            // Si el RUT es inválido o ya existe un cliente con ese RUT, retorna falso para indicar que el cliente no pudo ser añadido
            return false;
        }
    }
    public Usuario añadirUsuario(String nombre,String contrasena){
        Usuario usuario= new Usuario(nombre,contrasena);
        this.usuarios.add(usuario);
        // GestorDatos.registrarDato(vehiculo,"vehiculos.txt");
        return usuario;
    }

}