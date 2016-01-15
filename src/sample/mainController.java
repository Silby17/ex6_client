/****************************************
 * Yossi Silberhaft & Nava Shemoul		*
 * Exercise 6							*
 * File: mainController.java	        *
 ****************************************/
package sample;

import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

public class mainController {
    @FXML
    HBox hbMain;
    @FXML
    ChoiceBox cbOptions;
    @FXML
    Button btnConn;
    @FXML
    Button btnSearch;
    @FXML
    Button btnAll;
    @FXML
    Button btnDelete;
    @FXML
    Button btnAdd;
    @FXML
    TextField tfOptions;

    /****************************************************************
     * This is an inner class which is in charge of creating a new  *
     * server Config window                                         *
     ***************************************************************/
    class SetServer implements EventHandler<MouseEvent> {
        public void handle(MouseEvent event) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader(
                        getClass().getResource("setServer.fxml"));
                Parent root1 = fxmlloader.load();
                Stage stage = new Stage();
                stage.setTitle("Server Settings");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }


    /****************************************************************
     * This is an inner class which is in charge of creating a new  *
     * window for adding a movie                                    *
     ***************************************************************/
    class addMovie implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event){
            try {
                FXMLLoader fxmlloader = new FXMLLoader(
                        getClass().getResource("addMovie.fxml"));
                Parent root1 = fxmlloader.load();
                Stage stage = new Stage();
                stage.setTitle("Add addMovie");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }


    /****************************************************************
     * This is an inner class which is in charge of creating a new  *
     * window for adding a new Professional                         *
     ***************************************************************/
    class AddPro implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event){
            try {
                FXMLLoader fxmlloader = new FXMLLoader(
                        getClass().getResource("addPro.fxml"));
                Parent root1 = fxmlloader.load();
                Stage stage = new Stage();
                stage.setTitle("Add Professional");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }


    /****************************************************************
     * This is an inner class which is in charge of setting a new
     * window according to the search
     ****************************************************************/
    @FXML
    void initialize() {
        ContextMenu cmAll = new ContextMenu();
        MenuItem miMovie = new MenuItem("Movie");
        MenuItem miPro = new MenuItem("Professional");
        cmAll.getItems().addAll(miMovie, miPro);


        btnConn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnConn.setOnMouseClicked(new SetServer());
                System.out.println(cbOptions.getItems());


            }
        });

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //btnConn.requestFocus();
            }
        });

        btnSearch.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cmAll.show(btnSearch, event.getScreenX(), event.getScreenY());

            }
        });


        btnDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cmAll.show(btnDelete, event.getScreenX(), event.getScreenY());

                try{
                    int ID = Integer.parseInt(tfOptions.getText());
                    tfOptions.setStyle("-fx-background-color: white");

                }catch (NumberFormatException e){
                    tfOptions.setStyle("-fx-background-color: red");
                }

            }
        });



        btnAdd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cmAll.show(btnAdd, event.getScreenX(), event.getScreenY());
                miMovie.setOnAction(new addMovie());
                miPro.setOnAction(new AddPro());
            }
        });


        /****************************************************************
         * This will deal with the clicking of the addMovie menu-item
         ****************************************************************/
        btnAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cmAll.show(btnAll, event.getScreenX(), event.getScreenY());
                miPro.setOnAction(new AddPro());
                miMovie.setOnAction(new addMovie());

            }
        });
    }
}