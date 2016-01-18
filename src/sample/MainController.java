/****************************************
 * Yossi Silberhaft & Nava Shemoul		*
 * Exercise 6							*
 * File: MainController.java			*
 ****************************************/
package sample;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import java.io.IOException;


public class MainController{
    @FXML
    private Button btnConn;
    @FXML
    private ContextMenu cmAll;
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
    private ServerInfo info;
    private String name;


    @FXML
    public void initialize() {
        //Create new serverInfo
        info = new ServerInfo();

        //Create a new Context Menu
        cmAll = new ContextMenu();

        //Add new items to context Menu
        MenuItem miMovie = new MenuItem("Movie");
        miMovie.setOnAction(new AddMovie(this));
        MenuItem miPro = new MenuItem("Professional");
        miPro.setOnAction(new AddPro(this));
        cmAll.getItems().addAll(miMovie, miPro);


        /*******************************************************
         * This will display the Context Menu when clicking on
         * the SEARCH button
         ******************************************************/
        btnSearch.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cmAll.show(btnSearch, event.getScreenX(), event.getScreenY());

            }
        });

        /*******************************************************
         * This will display the Context Menu when clicking on
         * the DELETE button
         ******************************************************/
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

        /*******************************************************
         * This will display the Context Menu when clicking on
         * the ADD button
         ******************************************************/
        btnAdd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cmAll.show(btnSearch, event.getScreenX(), event.getScreenY());
            }
        });



        btnAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cmAll.show(btnAll, event.getScreenX(), event.getScreenY());
            }
        });
    }


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

    public void setName(String n){
        this.name = n;
        System.out.println(this.name);
    }

    public void setPort(int n){
        this.info.setPort(n);
    }

    public void setIP(String ip){
        this.info.setIp(ip);
    }

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

    public void send(String str) throws IOException {
        System.out.println(this.info.transactions(str));
    }


}

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
            System.out.println("Here 1");
            loader.load();
            Parent root = loader.getRoot();
            System.out.println("Here 2");
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            System.out.println("Here 3");
            AddProController con = loader.getController();
            con.init(this.mainCont);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}