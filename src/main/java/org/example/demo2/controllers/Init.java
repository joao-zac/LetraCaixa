package org.example.demo2.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import org.example.demo2.HelloApplication;
import org.example.demo2.dao.DaoFactory;
import org.example.demo2.model.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.example.demo2.HelloApplication.criarTela;

public class Init {
    @FXML
    public ImageView imgUserPic;
    @FXML
    public Button btnAddUser;
    @FXML
    public ComboBox<Usuario> cmbxUsuarios;

    @FXML
    public void initialize() {
        List<Usuario> usuarios = DaoFactory.createUsuarioDAO().listarTodosUsuarios();
        List<String> options = new ArrayList<String>();
        for (Usuario usuario : usuarios) {
            options.add(usuario.getNome());
        }

        ObservableList obs = FXCollections.observableArrayList(options);
        cmbxUsuarios.setItems(obs);
    }

    public void onBtnAddUserClick() {
        try {
            HelloApplication.criarTela("AdicionarUser.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
