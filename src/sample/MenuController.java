package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Font;

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
        about.setHeaderText("M07 P2");
        about.showAndWait();

    }

    public void copy(){

    }

    public void paste(){

    }

    public void delete(){

    }

    public void undo(){

    }

    @FXML
    public void chooseFontSize(ActionEvent e) {
        String choice = ((RadioMenuItem) e.getSource()).getId();

        switch (choice) {
            case "sizeSmall":
                input.setStyle("-fx-font-size: 14px");
                break;
            case "sizeNormal":
                input.setStyle("-fx-font-size: 22px");
                break;
            case "sizeLarge":
                input.setStyle("-fx-font-size: 30px");
                break;
        }
    }

    public void chooseFontStyle(ActionEvent e){
        String choice = ((RadioMenuItem) e.getSource()).getId();
        double defaultSize = Font.getDefault().getSize();

        switch (choice) {
            case "timesNewRoman":
                input.setFont(new Font("Times New Roman", defaultSize));
                break;
            case "verdana":
                input.setFont(new Font("Verdana", defaultSize));
                break;
            default:
                //jet mono brains
                input.setFont(Font.getDefault());
        }

    }

}
