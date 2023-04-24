package Vista;

import Model.GestionUsuarios;
import Model.Usuario;

import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.awt.event.ActionEvent;

public class PantallaLogin extends Ventana {
    // Define varios componentes JLabel para mostrar texto descriptivo en la interfaz gráfica.
    private JLabel textoEncabezado, textoUsuario, textoContrasena;

    // Define varios componentes JTextField para que el usuario pueda ingresar datos en la interfaz gráfica.
    private JTextField campoContrasena, campoUsuario;

    // Define dos botones JButton para permitir al usuario confirmar o cancelar la acción en la interfaz gráfica.
    private JButton botonIngresar, botonRegistrase;

    // Define una instancia de la clase Automotora, que se utilizará para almacenar los datos ingresados por el usuario.
    private GestionUsuarios gestionUsuarios;



    public PantallaLogin(GestionUsuarios gestionUsuarios){
        super("", 500, 520);
        this.gestionUsuarios= gestionUsuarios;
        generarElementosVentana();
    }
    private void generarElementosVentana() {
        generarEncabezado();
        generarBotonCancelar();
        generarBotonRegistrar();

        generarCampoUsuario();

        generarCampoContrasena();

    }
    private void generarEncabezado() {
        String textoCabecera = "Registro de cliente";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

    }
    private void generarBotonRegistrar() {
        String textoBoton= "Ingresar";
        this.botonIngresar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonIngresar);
        this.botonIngresar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonCancelar = "Registrase";
        this.botonRegistrase = super.generarBoton(textoBotonCancelar, 275, 400, 150, 20);
        this.add(this.botonRegistrase);
        this.botonRegistrase.addActionListener(this);
    }
    // Este método se utiliza para generar un campo de entrada de texto para el nombre del usuario.
    private void generarCampoUsuario(){

        // Define un texto descriptivo para el campo de entrada de texto del nombre.
        String textoNombre= "Usuario:";

        // Genera un JLabel con el texto descriptivo y lo agrega al panel.
        super.generarJLabel(this.textoUsuario,textoNombre,20,50,150,20);

        // Genera un JTextField para que el usuario pueda ingresar su nombre y lo agrega al panel.
        this.campoUsuario= super.generarJTextField(200,50,250,20);
        this.add(this.campoUsuario);
    }
    private void generarCampoContrasena(){
        String textoRut= "Contrasena:";
        super.generarJLabel(this.textoContrasena,textoRut,20,100,150,20);
        this.campoContrasena= super.generarJTextField(200,100,250,20);
        this.add(this.campoContrasena);
    }

    private boolean registrarCliente() {
        // Llama al método "añadirCliente" de la clase "automotora" pasándole los datos del cliente ingresados en los campos de texto correspondientes
        return gestionUsuarios.añadirUsuario1(this.campoUsuario.getText(), this.campoContrasena.getText());
    }
    private boolean igresarUsuario() {
        // Llama al método "añadirCliente" de la clase "automotora" pasándole los datos del cliente ingresados en los campos de texto correspondientes
        Usuario us;
        us =gestionUsuarios.buscarUsuarioPorNombre(this.campoUsuario.getText());
        return true;

    }
    public void actionPerformed(ActionEvent e) {
        // Comprueba si el evento de acción fue disparado por el botón "botonRegistrar"
        if (e.getSource() == this.botonRegistrase) {
            // Si es así, llama al método "registrarCliente()" para intentar registrar un nuevo cliente
            if(registrarCliente()) {
                // Si el registro fue exitoso, muestra un mensaje de confirmación utilizando la clase JOptionPane
                JOptionPane.showMessageDialog(this,"Cliente registrado correctamente");
                // Crea una nueva instancia de la clase VentanaMenuBienvenida pasándole como argumento un objeto "automotora"
                PantallaLogin ventanaMenuBienvenida = new PantallaLogin(gestionUsuarios);
                // Cierra la ventana actual
                this.dispose();
            }
            else{
                // Si el registro falló, muestra un mensaje de advertencia al usuario pidiéndole que ingrese un RUT válido
                JOptionPane.showMessageDialog(this,"Usuario ya registrado");
            }

        }
        // Comprueba si el evento de acción fue disparado por el botón "botonCancelar"
        if (e.getSource() == this.botonIngresar){
            if(igresarUsuario()) {
                // Si el registro fue exitoso, muestra un mensaje de confirmación utilizando la clase JOptionPane
                JOptionPane.showMessageDialog(this,"hola:"+ this.campoUsuario);
                // Crea una nueva instancia de la clase VentanaMenuBienvenida pasándole como argumento un objeto "automotora"
                PantallaLogin ventanaMenuBienvenida = new PantallaLogin(gestionUsuarios);
                // Cierra la ventana actual
                this.dispose();
            }
            else{
                // Si el registro falló, muestra un mensaje de advertencia al usuario pidiéndole que ingrese un RUT válido
                JOptionPane.showMessageDialog(this,"Usuario ya registrado");
            }
        }
    }



}

