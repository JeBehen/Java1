package com.example.transformapp;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ConnectionDialog extends Dialog<com.example.transformapp.ConnectionInfo> {

    private final TextField tfHost = new TextField();
    private final TextField tfUser = new TextField();
    private final TextField tfPassword = new TextField();

    public ConnectionDialog(com.example.transformapp.ConnectionInfo initialData) {
        Label hostLabel = new Label("Host");
        Label userLabel = new Label("User");
        Label passwordLabel = new Label("Password");

        VBox vbox = new VBox(
                hostLabel, tfHost,
                userLabel, tfUser,
                passwordLabel, tfPassword
        );

        vbox.setSpacing( 10.0d );
        vbox.setPadding( new Insets(40.0d) );

        DialogPane dp = getDialogPane();

        setTitle( "Connection Info" );
        setResultConverter( this:: formResult );

        ButtonType bt = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        dp.getButtonTypes().addAll( bt, ButtonType.CANCEL);
        dp.setContent( vbox );

        init( initialData);
    }
    private void init(com.example.transformapp.ConnectionInfo ci) {
        if (ci != null) {
            tfHost.setText( ci. getHost() );
            tfUser.setText( ci.getUsername() );
            tfPassword.setText( ci.getPassword() );
        }
    }
    private com.example.transformapp.ConnectionInfo formResult(ButtonType bt) {
        com.example.transformapp.ConnectionInfo retval = null;
        if( bt.getButtonData() == ButtonBar.ButtonData.OK_DONE ) {
            retval = new com.example.transformapp.ConnectionInfo(
                    tfHost.getText(), tfUser.getText(), tfPassword.getText()
            );


        }
        return retval;
    }
}

