package com.java.mvs.mvs_rgb_filter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Controller {


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
    private Button addFileButton;

    private static final ImageLogic IMAGE_LOGIC = new ImageLogic();

    @FXML
    public void initialize() {
        addFileButton.setOnAction(actionEvent -> {
            IMAGE_LOGIC.setStartImage(filePath.getText());
            try {
                File file = new File("src/main/java/com/java/mvs/mvs_rgb_filter/test_filter.png");
                String localUrl = file.toURI().toURL().toString();
                imageOutput.setImage(new Image(localUrl));
            } catch (IOException e) {
                System.out.println("");
            }
            IMAGE_LOGIC.toRedImage();
        });

        button.setOnAction(actionEvent -> {


        });
    }



}