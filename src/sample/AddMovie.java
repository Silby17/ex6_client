package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AddMovie implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
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
