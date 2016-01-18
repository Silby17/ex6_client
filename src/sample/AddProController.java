/****************************************
 * Yossi Silberhaft & Nava Shemoul		*
 * Exercise 6							*
 * File: AddProController.java  		*
 ****************************************/
package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AddProController {
    private MainController mainControl;

    @FXML ChoiceBox cbType;
    @FXML TextField tfID;
    @FXML TextField tfAge;
    @FXML TextField tfDes;
    @FXML TextField tfName;
    @FXML ChoiceBox cbSex;
    @FXML private Button btnAddPro;

    public void init(MainController cont){
        this.mainControl = cont;
    }

    public void btnAddPro(ActionEvent event) throws IOException{
        Stage stage = (Stage)this.btnAddPro.getScene().getWindow();
        int type;
        String sex;
        String toSend;

        if(cbType.getValue().equals("Director")){
            type =  0;
        }
        else if(cbType.getValue().equals("Actor")){
            type = 1;
        }
        else if(cbType.getValue().equals("Screenwriter")){
            type = 2;
        }
        else {
            type = 3;
        }
        if(cbSex.getValue().equals("Male")){
            sex = "Male";
        }
        else {
            sex = "Female";
        }

        String sType = Integer.toString(type);
        toSend = "2" + " " + sType + " " + tfID.getText() +
                " " + tfAge.getText() + " " + tfDes.getText() +
                " " + sex + " " + tfName.getText();
        mainControl.send(toSend);
       stage.close();
    }
}