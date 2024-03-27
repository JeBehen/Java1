package com.example.transformapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MVVM extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        EmploymentRequestView view = new EmploymentRequestView();

        Scene scene = new Scene(view);

        primaryStage.setTitle("MVVM App");
        primaryStage.setScene( scene );
        primaryStage.setWidth( 480 );
        primaryStage.setHeight( 320 );
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



