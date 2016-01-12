/****************************************
 * Yossi Silberhaft & Nava Shemoul		*
 * Exercise 6							*
 * File: maincontrooler.java	        *
 ****************************************/
package sample;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class maincontroller {
    @FXML
    GridPane serverGrid;
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
    @FXML
    Button ipTextBox;
    @FXML
    VBox VbLogin;


    /***************************************************************************************************
     * This is an inner class which is incharge of setting a new window to connect to server        	*
     ***************************************************************************************************/
    class SetServer implements EventHandler<MouseEvent>{

        public void handle(MouseEvent event) {
            Stage connectWindow = new Stage();
            connectWindow.setTitle("Connect to server");
            connectWindow.show();

            try {
                Parent root = FXMLLoader.load(getClass().getResource("sample/setServer.fxml"));
                System.out.print("here3");
                connectWindow.setTitle("Connect to server");
                System.out.print("here4");
                Scene scene = new Scene(root,1000, 1000);
                scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
                connectWindow.setScene(scene);
                connectWindow.show();
            } catch(Exception e){
                System.out.print("here5");
            }
        }
    }
    /*

public void show(){
    TextField textField = new TextField("Type Something"); // we will add a popup menu to this text field
    final ContextMenu contextMenu = new ContextMenu();
    MenuItem cut = new MenuItem("Cut");
    MenuItem copy = new MenuItem("Copy");
    MenuItem paste = new MenuItem("Paste");
    contextMenu.getItems().addAll(cut, copy, paste);
    cut.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            System.out.println("Cut...");
        }
    });
// ...
    textField.setContextMenu(contextMenu);
}


    public void initialize2() {
          final ContextMenu contextMenu = new ContextMenu(new VBox(new Button("Movie"),new Button("Professional")));
          serverGrid.setOnMouseClicked(new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent mouseEvent) {
                  contextMenu.show(
                          serverGrid,
                          mouseEvent.getScreenX(),
                          mouseEvent.getScreenY()
                  );
              }
          });
      }


      /************************************************************************************************************
       * This is an inner class which is incharge of setting a new window according to button which was pressed	*
       ************************************************************************************************************/
    /*
    class Operation implements EventHandler<MouseEvent>{
                  @Override
                  public void handle(MouseEvent t) {
                      ContextMenu conMenu  =new ContextMenu();
                      MenuItem movieOption = new MenuItem("Movie");
                      MenuItem professionalOption = new MenuItem("Professional");
                      conMenu.getItems().addAll(movieOption,professionalOption);
                      if(t.getButton().toString().equals("SECONDARY")) {
                          conMenu.show(allBtn, t.getScreenX(), t.getSceneY());
                      }
                  }

    }
    */
    /************************************************************************************************************
     * This is an inner class which is incharge of setting a new window according to the search              	*
     ************************************************************************************************************/
    /*
    class  ShowSearchResults implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent event) {
            hbLogin.setVisible(false);

        }
    }
    */
//Like constructor
    @FXML
    void initialize(){

        logoBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event){
            logoBtn.setOnMouseClicked(new SetServer());
        //    addBtn.setOnMouseClicked(new Operation());
         //   deletBtn.setOnMouseClicked(new Operation());
          //  allBtn.setOnMouseClicked(new Operation());
            //change it
           // search.setOnMouseClicked(new ShowSearchResults());

    }

});

        Platform.runLater(new Runnable(){
        @Override
        public void run() {
            logoBtn.requestFocus();
        }
        });

        } }