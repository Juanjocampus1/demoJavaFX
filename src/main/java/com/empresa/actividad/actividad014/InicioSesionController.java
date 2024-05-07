package com.empresa.actividad.actividad014;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InicioSesionController {

    @FXML
    private TextField correoField;

    @FXML
    private PasswordField contrasenaField;

    @FXML
    protected void onIniciarSesionButtonClick() {
        String correo = correoField.getText();
        String contrasena = contrasenaField.getText();

        // Verificación de las credenciales
        if (correo.equals("admin@gmail.com") && contrasena.equals("123")) {
            mostrarMensaje("Inicio de sesión correcto.");
            // Aquí se podría cerrar la ventana de inicio de sesión y realizar otras acciones, como abrir otra ventana
        } else {
            mostrarMensaje("Correo o contraseña incorrectos.");
        }
    }

    private void mostrarMensaje(String mensaje) {
        // Aquí se podría mostrar el mensaje en un Label u otro componente visual
        System.out.println(mensaje);
    }
}