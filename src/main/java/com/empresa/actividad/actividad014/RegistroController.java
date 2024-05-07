package com.empresa.actividad.actividad014;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegistroController {

    @FXML
    private TextField correoField;

    @FXML
    private PasswordField contrasenaField;

    @FXML
    private PasswordField confirmarContrasenaField;

    @FXML
    private TextField fechaAltaField;

    @FXML
    private CheckBox privacidadCheckbox;

    @FXML
    private Label mensajeLabel;

    @FXML
    protected void onRegistrarseButtonClick() {
        String correo = correoField.getText();
        String contrasena = contrasenaField.getText();
        String confirmarContrasena = confirmarContrasenaField.getText();
        String fechaAlta = fechaAltaField.getText();
        boolean privacidadAceptada = privacidadCheckbox.isSelected();

        if (correo.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty() || fechaAlta.isEmpty()) {
            mostrarMensaje("Por favor, complete todos los campos.");
            return;
        }

        if (!contrasena.equals(confirmarContrasena)) {
            mostrarMensaje("Las contraseñas no coinciden.");
            return;
        }

        if (!privacidadAceptada) {
            mostrarMensaje("Debe aceptar la política de privacidad.");
            return;
        }

        try {
            LocalDate.parse(fechaAlta, DateTimeFormatter.ISO_DATE);
        } catch (Exception e) {
            mostrarMensaje("Formato de fecha incorrecto. Utilice YYYY-MM-DD.");
            return;
        }

        mostrarMensaje("Usuario registrado.");
    }

    private void mostrarMensaje(String mensaje) {
        mensajeLabel.setText(mensaje);
    }

    @FXML
    protected void onInicioSesionButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SessionView.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Inicio de Sesión");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}