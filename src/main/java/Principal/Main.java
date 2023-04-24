package Principal;

import Controller.ControllerUsuarios;
import Model.GestionUsuarios;
import Model.Usuario;
import Vista.PantallaLogin;

public class Main {
	public static void main(String[] args) {
		GestionUsuarios gestionusuarios= new GestionUsuarios();
		gestionusuarios= ControllerUsuarios.cargaMasivaDatos(gestionusuarios);
		PantallaLogin ventana= new PantallaLogin(gestionusuarios);
	}
}
/*public class Main {
    public static void main(String[] args) {
        Automotora automotora= new Automotora();
        automotora= AutomotoraController.cargaMasivaDatos(automotora);
        VentanaMenuBienvenida ventana= new VentanaMenuBienvenida(automotora);
    }
}*/