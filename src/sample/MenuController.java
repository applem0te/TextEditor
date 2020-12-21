package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.*;

public class MenuController {

    @FXML
    private TextArea input;

    JFrame f;

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

    // If a button is pressed
    public void actionPerformed(ActionEvent e)
    {
        String choice = ((MenuItem) e.getSource()).getId();

        if (choice.equals("cut")) {
            cut();
        }
        else if (choice.equals("copy")) {
            copy();
        }
        else if (choice.equals("paste")) {
            paste();
        }
        else if (choice.equals("optionSave")) {
            // Create an object of JFileChooser class
            JFileChooser j = new JFileChooser("f:");

            // Invoke the showsSaveDialog function to show the save dialog
            int r = j.showSaveDialog(null);

            if (r == JFileChooser.APPROVE_OPTION) {

                // Set the label to the path of the selected directory
                File fi = new File(j.getSelectedFile().getAbsolutePath());

                try {
                    // Create a file writer
                    FileWriter wr = new FileWriter(fi, false);

                    // Create buffered writer to write
                    BufferedWriter w = new BufferedWriter(wr);

                    // Write
                    w.write(input.getText());

                    w.flush();
                    w.close();
                }
                catch (Exception evt) {
                    JOptionPane.showMessageDialog(f, evt.getMessage());
                }
            }
            // If the user cancelled the operation
            else
                JOptionPane.showMessageDialog(f, "Operation cancelled");
        }
        else if (choice.equals("optionOpen")) {
            // Create an object of JFileChooser class
            JFileChooser j = new JFileChooser("f:");

            // Invoke the showsOpenDialog function to show the save dialog
            int r = j.showOpenDialog(null);

            // If the user selects a file
            if (r == JFileChooser.APPROVE_OPTION) {
                // Set the label to the path of the selected directory
                File fi = new File(j.getSelectedFile().getAbsolutePath());

                try {
                    // String
                    String s1 = "", sl = "";

                    // File reader
                    FileReader fr = new FileReader(fi);

                    // Buffered reader
                    BufferedReader br = new BufferedReader(fr);

                    // Initilize sl
                    sl = br.readLine();

                    // Take the input from the file
                    while ((s1 = br.readLine()) != null) {
                        sl = sl + "\n" + s1;
                    }

                    // Set the text
                    input.setText(sl);
                }
                catch (Exception evt) {
                    JOptionPane.showMessageDialog(f, evt.getMessage());
                }
            }
            // If the user cancelled the operation
            else
                JOptionPane.showMessageDialog(f, "Operation cancelled");
        }
        else if (choice.equals("optionNew")) {
            input.setText("");
        }
    }

    public void cut(){
        input.cut();
    }

    public void copy(){
        input.copy();

    }

    public void paste() {
        input.paste();
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
