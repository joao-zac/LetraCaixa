package org.example.demo2.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.demo2.dao.DaoFactory;
import org.example.demo2.dao.FilmeDAO;
import org.example.demo2.dao.LogFilmeDAO;
import org.example.demo2.model.Filme;
import org.example.demo2.model.LogFilme;
import org.example.demo2.model.Usuario;
import org.example.demo2.util.Alertas;
import javafx.scene.control.Alert;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateLog {
    public ComboBox cmbxLogsDoUsuario;
    public Label lblFilmeDoLog;
    public DatePicker datepickerDataLog;
    private Usuario usuarioLogado;
    private int idUsuarioLogado;
    private Map<String, LogFilme> logsMap = new HashMap<>();
    private LogFilme logFilmeSelecionado;

    public TextArea txtReview;
    public Button btnAtualizar;
    public Slider sliderNota;
    public Label lblNota;
    public ImageView imgPoster;

    public void setUsuario(Usuario usuario) {
        this.usuarioLogado = usuario;
        if (usuario != null) {
            this.idUsuarioLogado = usuario.getIdUsuario();
            carregarLogsDoUsuario();
        } else {
            cmbxLogsDoUsuario.setDisable(true);
        }
    }

    @FXML
    public void initialize() {
        lblNota.setText(String.format("%.1f", sliderNota.getValue()));

        sliderNota.valueProperty().addListener((obs, oldVal, newVal) -> {
            lblNota.setText(String.format("%.1f", newVal.doubleValue()));
        });

        cmbxLogsDoUsuario.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                logFilmeSelecionado = logsMap.get(newVal);
                if (logFilmeSelecionado != null) {
                    preencherCamposComLog(logFilmeSelecionado);
                }
            } else {
                limparCamposDeLog();
            }
        });
    }

    private void preencherCamposComLog(LogFilme log) {
        if (log != null) {
            Filme filme = DaoFactory.createFilmeDAO().buscarFilmePorId(log.getIdFilme());
            lblFilmeDoLog.setText((filme != null) ? filme.getTitulo() : "Filme Desconhecido");
            datepickerDataLog.setValue(log.getDataAssistido());
            sliderNota.setValue(log.getNota().doubleValue());
            txtReview.setText(log.getDescricao());
            imgPoster.setImage(new Image (filme.getPoster()));
        }
    }

    private void limparCamposDeLog() {
        lblFilmeDoLog.setText("N/A");
        datepickerDataLog.setValue(null);
        sliderNota.setValue(0.0);
        lblNota.setText("0.0");
        txtReview.setText("");
        logFilmeSelecionado = null;
    }
    private void carregarLogsDoUsuario() {
        if (idUsuarioLogado == 0) {
            System.err.println("ID do usuário não definido para carregar logs.");
            return;
        }

        List<LogFilme> logs = DaoFactory.createLogFilmeDAO().listarLogsPorUsuario(idUsuarioLogado);
        List<String> logStrings = new ArrayList<>();
        logsMap.clear();

        for (LogFilme log : logs) {
            Filme filme = DaoFactory.createFilmeDAO().buscarFilmePorId(log.getIdFilme());
            String tituloFilme = (filme != null) ? filme.getTitulo() : "Filme Desconhecido";
            String logDisplay = String.format("%s - %s (Nota: %.1f)", tituloFilme, log.getDataAssistido().toString(), log.getNota().doubleValue());

            logStrings.add(logDisplay);
            logsMap.put(logDisplay, log);
        }

        ObservableList<String> obsLogs = FXCollections.observableArrayList(logStrings);
        cmbxLogsDoUsuario.setItems(obsLogs);

        if (!obsLogs.isEmpty()) {
            cmbxLogsDoUsuario.getSelectionModel().selectFirst();
        } else {
            Alertas.mostraAlerta(null, "Sem Logs", "Este usuário ainda não possui logs de filmes.", Alert.AlertType.INFORMATION);
            limparCamposDeLog();
        }

    }

    public void onBtnAtualizar(ActionEvent actionEvent) {
        if (logFilmeSelecionado == null) {
            Alertas.mostraAlerta(null, "Erro", "Selecione um log para atualizar.", Alert.AlertType.WARNING);
            return;
        }

        logFilmeSelecionado.setDescricao(txtReview.getText());
        logFilmeSelecionado.setDataAssistido(datepickerDataLog.getValue());
        logFilmeSelecionado.setNota(BigDecimal.valueOf(sliderNota.getValue()));

        LogFilmeDAO logFilmeDAO = DaoFactory.createLogFilmeDAO();
        logFilmeDAO.atualizarLog(logFilmeSelecionado);
        Alertas.mostraAlerta(null, null, "Log atualizado com sucesso!", Alert.AlertType.INFORMATION);

        carregarLogsDoUsuario();
    }

    public void onBtnExcluir() {
        if (logFilmeSelecionado == null) {
            System.out.println("Selecione um log para remover.");
            return;
        }

        DaoFactory.createLogFilmeDAO().deletarLog(logFilmeSelecionado.getIdLog());
        Alertas.mostraAlerta(null, null, "Log removido com sucesso!", Alert.AlertType.INFORMATION);

        carregarLogsDoUsuario();
        limparCamposDeLog();
    }
}
