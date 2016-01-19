/****************************************
 * Yossi Silberhaft & Nava Shemoul		*
 * Exercise 6							*
 * File: ConnectionController.java  	*
 ****************************************/
package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class ConnectionController {
    private MainController mainCont;
    private ServerInfo currentInfo;
    @FXML
    Button btnConnect;
    @FXML
    VBox vbConnect;
    @FXML
    Label lblLogin;
    @FXML
    TextField tfIP;
    @FXML
    TextField tfPort;


    @FXML
    private void btnConnect(ActionEvent event) throws IOException{
        ((Node)event.getSource()).getScene().getWindow().hide();
        mainCont.setPort(Integer.parseInt(tfPort.getText()));
        mainCont.setIP(tfIP.getText());
        mainCont.connect();
    }

    public void setCurrentInfo(ServerInfo currentInfo) {
        this.currentInfo = currentInfo;
    }

    public void init(MainController mainController) {
        this.mainCont = mainController;
    }
}
