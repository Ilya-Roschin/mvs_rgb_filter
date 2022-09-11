package com.java.mvs.mvs_rgb_filter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

public class HelloController {


    @FXML
    private RadioButton blueBtn;

    @FXML
    private Button button;

    @FXML
    private TextField filePath;

    @FXML
    private RadioButton grayBtn;

    @FXML
    private RadioButton greenBtn;

    @FXML
    private ToggleGroup group;

    @FXML
    private ImageView imageOutput;

    @FXML
    private RadioButton redBtn;

    @FXML
    public void initialize() {

        button.setOnAction(actionEvent -> {
            filePath.getText();

        });



    }



}