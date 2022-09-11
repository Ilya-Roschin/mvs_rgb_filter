package com.java.mvs.mvs_rgb_filter;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

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
            setStartImage();
            IMAGE_LOGIC.toRedImage();
        });

        button.setOnAction(actionEvent -> {
            RadioButton selected = (RadioButton) group.getSelectedToggle();
            switch (selected.getText()) {
                case ("gray"):
                    IMAGE_LOGIC.toGrayImage();
                    setFilterImage();
                    break;
                case ("red"):
                    IMAGE_LOGIC.toRedImage();
                    setFilterImage();
                    break;
                case ("green"):
                    IMAGE_LOGIC.toGreenImage();
                    setFilterImage();
                    break;
                case ("blue"):
                    IMAGE_LOGIC.toBlueImage();
                    setFilterImage();
                    break;
                default:
                    setStartImage();
                    break;
            }
        });
    }

    private void setStartImage() {
        File file = new File("src/main/java/com/java/mvs/mvs_rgb_filter/none_filter.png");
        String localUrl = null;
        try {
            localUrl = file.toURI().toURL().toString();
        } catch (MalformedURLException e) {

        }
        imageOutput.setImage(new Image(localUrl));
    }

    private void setFilterImage() {
        File file = new File("src/main/java/com/java/mvs/mvs_rgb_filter/filter.png");
        String localUrl = null;
        try {
            localUrl = file.toURI().toURL().toString();
        } catch (MalformedURLException e) {

        }
        imageOutput.setImage(new Image(localUrl));
    }



}