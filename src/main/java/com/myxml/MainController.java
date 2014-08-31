package com.myxml;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class MainController {
    @FXML
    private TabPane tabContainer;
    private static Stage stage;
    public static void setStage(Stage theStage){
        stage = theStage;
    }
    @FXML
    private void closeApp() {
        stage.close();
    }
    @FXML
    private void addDoc() {
        Tab t = new Tab("New");
        tabContainer.getTabs().add(t);
    }
}
