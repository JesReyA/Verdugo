package fes.aragon.verdugo.controller;

import fes.aragon.verdugo.inicio.Verdugo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    Verdugo verdugo= new Verdugo();

    @FXML
    private Label labelRespuesta, numeroPosicion;
    public TextField cantidadPrisioneros, prisionerosSaltar, ubicacionAmigo;


    @FXML
    public void obtenerPosicion (ActionEvent e) {
        String n = cantidadPrisioneros.getText();
        String k = prisionerosSaltar.getText();
        String amigo = ubicacionAmigo.getText();
            try {
                if (n.isEmpty() || k.isEmpty() || amigo.isEmpty()) {
                    mostrarError("Los campos no pueden estar vacios.");
                } else if (amigo.equals("0")||(Integer.parseInt(amigo))<0) {
                    mostrarError("El campo ubicación amigo debe ser mayor que cero");
                } else if ((Integer.parseInt(amigo))>(Integer.parseInt(n))) {
                     mostrarError("El amigo debe de estar en el rango de prisioneros");
                } else {
                    String posicion = verdugo.matar(Integer.parseInt(k), Integer.parseInt(n), Integer.parseInt(amigo));
                    labelRespuesta.setText("El verdugo debe iniciar \nmatando en la posición");
                    numeroPosicion.setText(posicion);
                }
            }catch (NumberFormatException ex){
                mostrarError("Sólo puede ingresar números");
            }
        }


    private void mostrarError(String mensaje) {
        var alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText("Error");
        alerta.setContentText(mensaje+"\nRevise bien los datos ingresados");
        alerta.showAndWait();
    }
}
