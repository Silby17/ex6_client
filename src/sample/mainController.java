/****************************************
 * Yossi Silberhaft & Nava Shemoul		*
 * Exercise 6							*
 * File: maincontrooler.java	        *
 ****************************************/
package sample;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    Button ipTextBox;
    @FXML
    VBox VbLogin;


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

    /****************************************************************
     * This is an inner class which is in charge of setting a new   *
     * window according to the search              	                *
     * /
     **************************************************************/
    @FXML
    void initialize() {
        btnConn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnConn.setOnMouseClicked(new SetServer());
            }
        });

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //btnConn.requestFocus();
            }
        });

    }
}