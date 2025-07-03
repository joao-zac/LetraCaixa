package org.example.demo2.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Alertas {
    public static void mostraAlerta(String titulo, String cabecalho, String corpo, Alert.AlertType tipo){
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(corpo);
        alerta.showAndWait();
    }

    public static Optional<ButtonType> mostraAlertaConfirmacao(String titulo, String cabecalho, String conteudo) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecalho);
        alert.setContentText(conteudo);
        return alert.showAndWait();
    }
}
