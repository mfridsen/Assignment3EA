package dev.groupeighteen.gui;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import javafx.fxml.FXML;

public class StudentGrades {


    @FXML
    private MenuButton saveDraftButton;


    @FXML
    public void initialize() {
        for (MenuItem item : saveDraftButton.getItems()) {
            item.setOnAction(event -> saveDraftButton.setText(item.getText()));
        }
    }
}
