package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MenuController {

    @FXML
    private TextArea input;

    public void exit(){

        if (input.getText().isEmpty()) {
            Platform.exit();
            return;
        }
        else{
            Alert alert = new Alert(
                    Alert.AlertType.CONFIRMATION,
                    "Your text will be lost",
                    ButtonType.YES,
                    ButtonType.CANCEL
            );

            alert.setTitle("Confirm");
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                Platform.exit();
            }
        }

    }

    @FXML
    public void about(){

        Alert about = new Alert(Alert.AlertType.INFORMATION);

        about.setTitle("About");
        about.setHeaderText("Practica 2");
        about.showAndWait();

    }

    @FXML
    public void chooseFontSize(ActionEvent e) {
        String choice = ((CheckMenuItem) e.getSource()).getId();

        switch (choice) {
            case "sizeSmall":
                input.setStyle("-fx-font-size: 14px");
                break;
            case "sizeDefault":
                input.setStyle("-fx-font-size: 22px");
                break;
            case "sizeLarge":
                input.setStyle("-fx-font-size: 30px");
                break;
            default:
                input.setStyle("-fx-font-size: 22px");
        }
    }

    public void chooseFontStyle(){

    }

}
