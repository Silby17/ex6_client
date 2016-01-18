/****************************************
 * Yossi Silberhaft & Nava Shemoul		*
 * Exercise 6							*
 * File: MainController.java			*
 ****************************************/
package sample;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.omg.CORBA.INTERNAL;

import java.awt.*;
import java.io.IOException;


public class MainController{
    private ServerInfo info;
    @FXML
    private ContextMenu cmAll;
    @FXML
    private ContextMenu cmAdd;
    @FXML
    private ContextMenu cmDelete;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnAll;
    @FXML
    private TextField tfOptions;



    @FXML
    public void initialize() {
        //Create new serverInfo
        info = new ServerInfo();
        //Creates all the needed context Menu with its items
        createAllContextMenus();



        /*******************************************************
         * This will display the Context Menu when clicking on
         * the SEARCH button
         ******************************************************/
        btnSearch.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //cmAll.show(btnSearch, event.getScreenX(), event.getScreenY());
            }
        });


        /*******************************************************
         * This will display the Context Menu when clicking on
         * the DELETE button
         ******************************************************/
        btnDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cmDelete.show(btnDelete, event.getScreenX(), event.getScreenY());
            }
        });


        /*********************************************************************
         * This will display the Context Menu when clicking on
         * the ADD button
         ********************************************************************/
        btnAdd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cmAdd.show(btnAdd,event.getScreenX(), event.getScreenY());
            }
        });


        /*********************************************************************
         * This will display the Context Menu when clicking on
         * the ALL button
         ********************************************************************/
        btnAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            }
        });
    }


    /*********************************************************************
     * This function will create all the context Menus for the 3 buttons
     * - All, Add and Remove
     *********************************************************************/
    private void createAllContextMenus() {
        //Create a new Context Menu
        cmAdd = new ContextMenu();
        //Add new items to context Menu
        MenuItem miAddMovie = new MenuItem("Movie");
        miAddMovie.setOnAction(new AddMovie(this));
        MenuItem miAddPro = new MenuItem("Professional");
        miAddPro.setOnAction(new AddPro(this));
        cmAdd.getItems().addAll(miAddMovie, miAddPro);

        cmAll = new ContextMenu();
        MenuItem miAllMovie = new MenuItem("Movie");
        MenuItem miAllPros = new MenuItem("Professional");
        //TODO add function for handling clicks
        cmAll.getItems().addAll(miAllMovie, miAllPros);

        cmDelete = new ContextMenu();
        MenuItem miDelMovie = new MenuItem("Movie");
        MenuItem miDelPros = new MenuItem("Professional");
        miDelMovie.setOnAction(new DeleteMovie(this));
        miDelPros.setOnAction(new DeletePro(this));
        cmDelete.getItems().addAll(miDelMovie, miDelPros);
    }


    /*********************************************************************
     * This function will deal with the event of clicking on the
     * connection button to set the server information
     ********************************************************************/
    @FXML
    public void btnConn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("setServer.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        ConnectionController con = loader.getController();
        con.init(this);
        stage.show();
    }


    /*********************************************************************
     * This returns the input from the text box
     ********************************************************************/
    public String getInput(){
        return this.tfOptions.getText();
    }

    /*********************************************************************
     * This returns the Textfield box
     ********************************************************************/
   public TextField getOptionBox(){
       return this.tfOptions;
   }

    /*********************************************************************
     * This sets the port number of the server
     ********************************************************************/
    public void setPort(int n){
        this.info.setPort(n);
    }

    /*********************************************************************
     * This Sets the IP address to connect to the Server
     ********************************************************************/
    public void setIP(String ip){
        this.info.setIp(ip);
    }

    /*********************************************************************
     * This will connect the client to the server and display
     * a information box stating that there is a connection
     ********************************************************************/
    public void connect(){
        if(this.info.createConnection()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Connection Established");
            alert.setHeaderText(null);
            alert.setContentText(
                    "Connection Established!");
            alert.showAndWait();
        }
    }

    /*********************************************************************
     * This function sends the string to server and will receive
     * a result and return 1 for success and 0 for failure
     ********************************************************************/
    public int send(String str) throws IOException {
        String result = this.info.transactions(str);
        if (result.contains("S")) {
            return 1;
        } else if (result.contains("F")) {
            return 0;
        }
        return -1;
    }
}


/*******************************************************
 * This Abstract class will deal with the Addition of
 * a Movie to the server
 ******************************************************/
class AddMovie implements EventHandler<ActionEvent> {
    private MainController cont;
    public AddMovie(MainController mCont){
        this.cont = mCont;
    }
    @Override
    public void handle(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("addMovie.fxml"));
            loader.load();
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            AddMovieController con = loader.getController();
            con.init(this.cont);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/*******************************************************
 * This Abstract class will deal with the Addition
 * of a professional to the server
 ******************************************************/
class AddPro implements EventHandler<ActionEvent> {
    private MainController mainCont;
    public AddPro(MainController mCont){
        this.mainCont = mCont;
    }
    @Override
    public void handle(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("addPro.fxml"));
            loader.load();
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            AddProController con = loader.getController();
            con.init(this.mainCont);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/*******************************************************
 * This Abstract class will deal with the deletion
 * of a movie from the server
 ******************************************************/
class DeleteMovie implements EventHandler<ActionEvent> {
    private MainController main;
    public DeleteMovie(MainController controller){
        this.main = controller;
    }
    @Override
    public void handle(ActionEvent event) {
        String toSend;
        int result;
        main.getOptionBox().setStyle("-fx-background-color: white");
        toSend = 10 + " " + main.getOptionBox().getText();
        try{
            result = main.send(toSend);
            if(result == 0){
                main.getOptionBox().setStyle("-fx-background-color: red");
            }
            else if(result == 1){
                main.getOptionBox().setStyle("-fx-background-color: white");
                main.getOptionBox().clear();
                main.getOptionBox().promptTextProperty().
                        setValue("Enter ID or Code");
            }
        }catch(IOException e){
            main.getOptionBox().setStyle("-fx-background-color: red");
        }
    }
}


/*******************************************************
 * This Abstract class will deal with the deletion
 * of a Professional from the server
 ******************************************************/
class DeletePro implements EventHandler<ActionEvent> {
    private MainController main;
    public DeletePro(MainController controller){
        this.main = controller;
    }
    @Override
    public void handle(ActionEvent event) {
        String toSend;
        int result;
        toSend = 11 + " " + main.getOptionBox().getText();
        try{
            //Checks if the value entered is a numerical ID number
            int ID = Integer.parseInt(main.getInput());
            try{
                //Tries to send the request to the server to remove the
                //professional
                result = main.send(toSend);
                if(result == 0){
                    main.getOptionBox().setStyle("-fx-background-color: red");
                }
                else if(result == 1){
                    main.getOptionBox().setStyle("-fx-background-color: white");
                    main.getOptionBox().promptTextProperty().
                            setValue("Enter ID or Code");
                }
            }catch (IOException e){
                main.getOptionBox().setStyle("-fx-background-color: red");
            }

        }catch (NumberFormatException e){
            main.getOptionBox().setStyle("-fx-background-color: red");
        }
    }
}