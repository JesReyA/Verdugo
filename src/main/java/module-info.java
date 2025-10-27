module fes.aragon.verdugo {
    requires javafx.controls;
    requires javafx.fxml;
    requires Herramientas;


    opens fes.aragon.verdugo to javafx.fxml;
    exports fes.aragon.verdugo;
    exports fes.aragon.verdugo.controller;
    opens fes.aragon.verdugo.controller to javafx.fxml;
    exports fes.aragon.verdugo.inicio;
    opens fes.aragon.verdugo.inicio to javafx.fxml;
}