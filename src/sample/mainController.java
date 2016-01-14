/****************************************
 * Yossi Silberhaft & Nava Shemoul		*
 * Exercise 6							*
 * File: mainController.java	        *
 ****************************************/
package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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



    class Movie implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event){
            try {
                FXMLLoader fxmlloader = new FXMLLoader(
                        getClass().getResource("addMovie.fxml"));
                Parent root1 = fxmlloader.load();
                Stage stage = new Stage();
                stage.setTitle("Add Movie");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }


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
                System.out.println("Opening set Server");
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




        /****************************************************************
         * This will deal with the clicking of the Movie menu-item
         ****************************************************************/
        btnAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cmAll.show(btnAll, event.getScreenX(), event.getScreenY());
                miPro.setOnAction(new AddPro());
                miMovie.setOnAction(new Movie());

            }
        });



        btnAdd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cmAll.show(btnAll, event.getScreenX(), event.getScreenY());
                miMovie.setOnAction(new Movie());
                miPro.setOnAction(new AddPro());
            }
        });



        btnDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cmAll.show(btnAll, event.getScreenX(), event.getScreenY());

            }
        });

        btnSearch.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cmAll.show(btnAll, event.getScreenX(), event.getScreenY());

            }
        });
    }
}