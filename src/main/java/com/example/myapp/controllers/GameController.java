package com.example.myapp.controllers;

import com.example.myapp.services.QuizzService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController<URL> implements Initializable {
    @FXML
    private Label question;
    @FXML
    private RadioButton options;
    @FXML
    private Button answerIndex;

    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {

    }
}
