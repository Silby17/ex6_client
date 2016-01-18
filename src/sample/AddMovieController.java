/****************************************
 * Yossi Silberhaft & Nava Shemoul		*
 * Exercise 6							*
 * File: AddMovieController.java		*
 ****************************************/
package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.math.BigDecimal;


public class AddMovieController {
    private MainController main;

    @FXML TextField tfCode;
    @FXML TextField tfName;
    @FXML TextField tfLength;
    @FXML TextField tfYear;
    @FXML Slider sldrRating;
    @FXML TextField tfURL;
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
        double rating =  new BigDecimal(this.sldrRating.getValue())
                .setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();

        strToSend = "1" + " " + this.tfCode.getText() + " " + tfName.getText() +
                " " + tfLength.getText() + " " + tfYear.getText() +
                " " + rating + " " + tfURL.getText() + " " + tfDes.getText();

        System.out.println("Aout to bring string");
        System.out.println(strToSend);
        return strToSend;
    }
}
