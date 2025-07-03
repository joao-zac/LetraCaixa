package org.example.demo2.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.demo2.HelloApplication;
import org.example.demo2.dao.DaoFactory;
import org.example.demo2.model.Filme;
import org.example.demo2.model.Usuario;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Profile {

    @FXML
    public Label labelNomeUsuario;
    @FXML
    public ImageView imgPerfil;
    @FXML
    public ComboBox cmbxFilmes;
    @FXML
    public Button btnUpdate;
    @FXML
    public Button btnReview;

    private Usuario usuarioSelecionado;
    private int idUsuarioLogado;


    @FXML
    public void initialize(){
        List<Filme> filmes = DaoFactory.createFilmeDAO().listarTodosFilmes();
        List<String> options = new ArrayList<String>();

        for (Filme filme : filmes) {
            options.add(filme.getTitulo());
        }

        ObservableList obs = FXCollections.observableArrayList(options);
        cmbxFilmes.setItems(obs);

        cmbxFilmes.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                btnReview.setDisable(false);
            }else {
                btnReview.setDisable(true);
            }
        });

        btnReview.setDisable(true);
    }

    @FXML
    public void onCmbClicked() {
        System.out.println("oi");
    }

    @FXML
    public void onBtnReviewClicked() {
        try {
            String tituloFilmeSelecionado = cmbxFilmes.getSelectionModel().getSelectedItem().toString();
            idUsuarioLogado = usuarioSelecionado.getIdUsuario();

            if (tituloFilmeSelecionado == null || tituloFilmeSelecionado.isEmpty()) {
                System.out.println("Nenhum filme selecionado no ComboBox.");
                return;
            }

            Filme filmeSelecionado = null;
            List<Filme> filmesEncontrados = DaoFactory.createFilmeDAO().buscarFilmesPorTitulo(tituloFilmeSelecionado);
            if (!filmesEncontrados.isEmpty()) {
                filmeSelecionado = filmesEncontrados.get(0); // Pega o primeiro encontrado
            } else {
                System.out.println("Filme com título '" + tituloFilmeSelecionado + "' não encontrado no banco de dados.");
                return;
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo2/Log.fxml")); // Caminho do seu FXML
            Parent root = loader.load();

            LogController logController = loader.getController();
            logController.setFilme(filmeSelecionado);
            logController.setIdUsuarioLogado(idUsuarioLogado);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); // Torna a janela modal
            stage.setTitle("Registrar Filme"); // Título da janela
            stage.setScene(new Scene(root));
            stage.showAndWait();
//            HelloApplication.ScreenManager.criarTelaModal("Log.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onBtnUpdate() {

    }

    public void setUsuario(Usuario usuario) {
        this.usuarioSelecionado = usuario;
        if (usuarioSelecionado != null) {
            labelNomeUsuario.setText("Olá " + usuarioSelecionado.getNome());
            imgPerfil.setImage(new Image(new ByteArrayInputStream(usuarioSelecionado.getFotoPerfil())));
        } else {
            labelNomeUsuario.setText("Nenhum usuário carregado.");
        }
    }

}
