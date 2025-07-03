package org.example.demo2.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.demo2.HelloApplication;
import org.example.demo2.dao.DaoFactory;
import org.example.demo2.model.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Init {
    @FXML
    public ImageView imgUserPic;
    @FXML
    public Button btnAddUser;
    @FXML
    public ComboBox<String> cmbxUsuarios;
    @FXML
    public Label labelNameUser;
    @FXML
    public Button btnEntrar;

    private Map<String, Usuario> usuariosMap = new HashMap<>();
    private Usuario usuarioAtualmenteSelecionado;

    @FXML
    public void initialize() {
        List<Usuario> usuarios = DaoFactory.createUsuarioDAO().listarTodosUsuarios();
        List<String> options = new ArrayList<String>();

        btnEntrar.setDisable(true);

        for (Usuario usuario : usuarios) {
            options.add(usuario.getNome());
            usuariosMap.put(usuario.getNome(), usuario);
        }

        ObservableList obs = FXCollections.observableArrayList(options);
        cmbxUsuarios.setItems(obs);

        cmbxUsuarios.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                labelNameUser.setText("Olá, " + newValue + "!");
                usuarioAtualmenteSelecionado = usuariosMap.get(newValue);
                btnEntrar.setDisable(false);
            }else {
                labelNameUser.setText("Nenhum usuário selecionado.");
                usuarioAtualmenteSelecionado = null;
                btnEntrar.setDisable(true);
            }
        });
    }

    public void onBtnAddUserClick(ActionEvent event){
        try {
            HelloApplication.ScreenManager.criarTelaModal("AdicionarUser.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onBtnEntrar(ActionEvent event) {
        if (usuarioAtualmenteSelecionado != null) {
            try {
                Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = HelloApplication.ScreenManager.criarTelaNaMesmaJanela(currentStage, "Profile.fxml");
                Profile destinoController = loader.getController();
                destinoController.setUsuario(usuarioAtualmenteSelecionado);

            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Erro ao carregar a tela de detalhes do usuário: " + e.getMessage());
            }
        } else {
            System.out.println("Nenhum usuário selecionado para ver detalhes.");
        }
    }


}
