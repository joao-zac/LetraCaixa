package org.example.demo2.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.demo2.dao.DaoFactory;
import org.example.demo2.dao.UsuarioDAO;
import org.example.demo2.model.Usuario;
import org.example.demo2.util.Alertas;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;

public class AdicionarUser {

    @FXML
    TextField inputNome;
    @FXML
    Button btnRegistrar;
    @FXML
    ImageView imgviewUser;
    @FXML
    Button btnLoadPhoto;

    private FileInputStream fis;
    private int tamanho;

    private File selectedFile;


    @FXML
    public void initialize() {

        updateButtonState();

        inputNome.textProperty().addListener((observable, oldValue, newValue) -> {
            updateButtonState();
        });

        imgviewUser.imageProperty().addListener((observable, oldValue, newValue) -> {
            updateButtonState();
        });
    }

    @FXML
    public void onLoadPhotoClicked() {
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Selecione um arquivo");
        jfc.setFileFilter(new FileNameExtensionFilter("Arquivo de imagens (*.PNG,*.JPG,*.JPEG)","png","jpg","jpeg"));
        int result = jfc.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = jfc.getSelectedFile();
                fis = new FileInputStream(selectedFile);
                tamanho = (int) selectedFile.length();

                imgviewUser.setImage(new Image(selectedFile.toURI().toString()));
            } catch (Exception e) {
                System.out.println(e);
                selectedFile = null;
                imgviewUser.setImage(null);
            }
        } else {
            selectedFile = null;
            imgviewUser.setImage(null);
        }

        updateButtonState();
    }

    @FXML
    public void onBtnRegistrarClick() {
        String nomeUser = inputNome.getText();

        Usuario u = new Usuario();
        u.setNome(nomeUser);

        if (selectedFile != null) {
            try {
                byte[] imageBytes = new byte[(int) selectedFile.length()];
                try (FileInputStream imageFis = new FileInputStream(selectedFile)) {
                    imageFis.read(imageBytes);
                }

                u.setFotoPerfil(imageBytes);
                DaoFactory.createUsuarioDAO().adicionarUsuario(u);
                Alertas.mostraAlerta(null, null, "Inserido", Alert.AlertType.CONFIRMATION);

            } catch (Exception e) {
                System.err.println("Erro ao ler os bytes da imagem: " + e.getMessage());
            }
        } else {
            System.out.println("Nenhuma imagem selecionada para o registro.");
        }

    }

    private void updateButtonState() {
        boolean isNomeEmpty = inputNome.getText().trim().isEmpty();

        boolean isImageNotSelected = selectedFile == null;

        btnRegistrar.setDisable(isNomeEmpty || isImageNotSelected);
    }
}