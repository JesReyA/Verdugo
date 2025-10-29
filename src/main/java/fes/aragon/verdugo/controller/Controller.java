package fes.aragon.verdugo.controller;

import fes.aragon.verdugo.inicio.Verdugo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    Verdugo verdugo= new Verdugo();

    @FXML
    private Label labelRespuesta, numeroPosicion;
    public TextField cantidadPrisioneros, prisionerosSaltar, ubicacionAmigo;


    @FXML
    public void obtenerPosicion (ActionEvent e){
        String n = cantidadPrisioneros.getText();
        String k = prisionerosSaltar.getText();
        String amigo = ubicacionAmigo.getText();
        String posicion = verdugo.matar(Integer.parseInt(k), Integer.parseInt(n), Integer.parseInt(amigo));

        labelRespuesta.setText("El verdugo debe iniciar matando en la posición");
        numeroPosicion.setText(posicion);
    }
}
