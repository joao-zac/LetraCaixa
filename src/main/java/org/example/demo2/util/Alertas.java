package org.example.demo2.util;

import javafx.scene.control.Alert;

public class Alertas {
    public static void mostraAlerta(String titulo, String cabecalho, String corpo, Alert.AlertType tipo){
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(corpo);
        alerta.show();
    }
}
