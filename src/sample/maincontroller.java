package sample;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;





public class maincontroller {
    @FXML
    Label lblLogin;
    @FXML
    Button logoBtn;
    @FXML
    HBox hbLogin;
    @FXML
    TextField search;
    @FXML
    Button deletBtn;
    @FXML
    Button addBtn;
    @FXML
    Button allBtn;


//Like constructor
    @FXML
    void initialize(){
       // EventHandler<MouseEvent> connection = new EventHandler<MouseEvent>();
        logoBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event){

            hbLogin.setVisible(false);
           // logoBtn.setOnMouseClicked();
    }

});

        Platform.runLater(new Runnable(){
        @Override
    public void run() {

            lblLogin.requestFocus();
        }

        });

        } }