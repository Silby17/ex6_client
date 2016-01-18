package sample;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
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


    @FXML
    public void initialize() {
        System.out.println("Application started");
        //Create new serverInfo
        info = new ServerInfo();

        //Create a new Context Menu
        cmAll = new ContextMenu();

        //Add new items to context Menu
        MenuItem miMovie = new MenuItem("Movie");
        MenuItem miPro = new MenuItem("Professional");
        cmAll.getItems().addAll(miMovie, miPro);


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
        System.out.println("After shows");
    }


    public void setPort(int n){
        this.info.setPort(n);
        System.out.println("Post Set");
    }

    public void setIP(String ip){
        this.info.setIp(ip);
        System.out.println("IP Set");
    }
}

