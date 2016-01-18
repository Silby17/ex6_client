/****************************************
 * Yossi Silberhaft & Nava Shemoul		*
 * Exercise 6							*
 * File: AddMovieController.java			*
 ****************************************/
package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;


public class AddMovieController {
    private MainController main;

    @FXML TextField tfCode;
    @FXML TextField tfName;
    @FXML TextField tfLength;
    @FXML TextField tfYear;
    @FXML Slider sldrRating;
    @FXML CheckBox female;
    @FXML CheckBox male;
    @FXML TextField tfDes;
    @FXML CheckBox cbDrama;
    @FXML CheckBox cbSciFi;
    @FXML CheckBox cbAction;
    @FXML CheckBox cbComedy;
    @FXML Button btnAdd;
    String strToSend;


    public void init(MainController mainCont) {
        this.main = mainCont;
    }

    @FXML
    public String btnDoneClick(ActionEvent event) throws IOException{
        System.out.println("Clicekd  add");
        strToSend = this.tfCode.getText();
        return strToSend;
    }
}
