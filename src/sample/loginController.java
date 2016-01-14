package sample;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class  loginController {
    @FXML
    VBox vbox;
    @FXML
    TextField code;
    @FXML
    TextField name;
    @FXML
    CheckBox female;
    @FXML
    CheckBox male;
    @FXML
    TextField length;
    @FXML
    TextField year;
    @FXML
    Slider slider;
    @FXML
    CheckBox genre;
    @FXML
    CheckBox proffesionals;
    @FXML
    Button btnDone;

    @FXML
    public void handleCloseButtonAction() {

        Stage stage = (Stage) btnDone.getScene().getWindow();
        stage.close();

    }

    @FXML
    void initialize(){

        btnDone.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handleCloseButtonAction();

            }
        });
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                btnDone.requestFocus();
            }
        });
    }

}
