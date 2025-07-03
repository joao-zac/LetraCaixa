package org.example.demo2.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.demo2.dao.DaoFactory;
import org.example.demo2.model.Filme;
import org.example.demo2.model.LogFilme;
import org.example.demo2.util.Alertas;

import java.math.BigDecimal;


public class LogController {
    private Filme filmeAtual;
    private int idUsuarioLogado;

    @FXML
    private Label lblTituloFilme;
    @FXML
    private Label lblAnoLancamento;
    @FXML
    private TextArea txtReview;
    @FXML
    private Label lblDiretor;
    @FXML
    private Slider sliderNota;
    @FXML
    private Label lblNota;
    @FXML
    private ImageView imgViewPoster;
    @FXML
    private DatePicker datepickerData;


    public void setFilme(Filme filme) {
        this.filmeAtual = filme;

        if (filmeAtual != null) {
            lblTituloFilme.setText(filmeAtual.getTitulo());
            lblAnoLancamento.setText((String.valueOf(filmeAtual.getAnoLancamento())));
            lblDiretor.setText(filmeAtual.getDiretor());
            imgViewPoster.setImage(new Image(filmeAtual.getPoster()));
            lblNota.setText(String.valueOf(sliderNota.getValue()));
        }
    }

    @FXML
    public void initialize() {
        lblNota.setText(String.format("%.1f", sliderNota.getValue()));

        sliderNota.valueProperty().addListener((obs, oldVal, newVal) -> {
            lblNota.setText(String.format("%.1f", newVal.doubleValue()));
        });
    }

    public void setIdUsuarioLogado(int idUsuario) {
        this.idUsuarioLogado = idUsuario;
        System.out.println("LogController recebeu o ID do usuário: " + idUsuarioLogado);
    }

    @FXML
    public void onBtnSalvarLogClicked() {
        LogFilme logFilme = new LogFilme();
        logFilme.setIdFilme(filmeAtual.getIdFilme());
        logFilme.setDescricao(txtReview.getText());
        logFilme.setDataAssistido(datepickerData.getValue());
        logFilme.setNota(BigDecimal.valueOf(sliderNota.getValue()));
        logFilme.setIdUsuario(this.idUsuarioLogado);

        DaoFactory.createLogFilmeDAO().adicionarLogFilme(logFilme);

        Alertas.mostraAlerta(null, null, "Log feito com sucesso!", Alert.AlertType.CONFIRMATION);
         Stage stage = (Stage) lblTituloFilme.getScene().getWindow();
         stage.close();

    }
}
