package sample;

import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class connectionController {
    @FXML
    Button btnConnect;
    @FXML
    VBox vbConnect;
    @FXML
    Label lblLogin;
    @FXML
    TextField tfIP;
    @FXML
    TextField tfSocket;

    @FXML
    public void handleCloseButtonAction() {
        Stage stage = (Stage) btnConnect.getScene().getWindow();
        System.out.println(tfIP.getText());
        System.out.println(tfSocket.getText());
        stage.close();
    }

    @FXML
    void initialize(){
        btnConnect.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handleCloseButtonAction();

            }
        });
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                lblLogin.requestFocus();
            }
        });
    }

}
