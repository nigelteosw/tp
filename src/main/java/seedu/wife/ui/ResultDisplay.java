package seedu.wife.ui;

import static java.util.Objects.requireNonNull;

import javafx.fxml.FXML;

import javafx.scene.layout.Region;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.Node;


/**
 * A ui for the status bar that is displayed at the header of the application.
 */
public class ResultDisplay extends UiPart<Region> {

    private static final String FXML = "ResultDisplay.fxml";

    @FXML 
    private ScrollPane scrollPane;
    @FXML 
    private VBox pane;

    public ResultDisplay() {
        super(FXML);
    }

    public void clear() {
        pane.getChildren().clear();
    }

    public void place(Node item) {
        pane.getChildren().add(item);
        scrollPane.setContent(pane);
    }

}
