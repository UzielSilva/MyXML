package com.myxml;/**
 * Created by Uziel on 30/08/2014.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        String path = DefaultProperties.get("fxml.path");
        Parent root = FXMLLoader.load(getClass().getResource(String.format("%s/main.fxml",path)));
        primaryStage.setTitle("MyXML");
        primaryStage.setScene(new Scene(root));
        MainController.setStage(primaryStage);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
