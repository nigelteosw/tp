package seedu.wife.ui;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;



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

    /**
     * Clears the result display.
     */
    public void clear() {
        pane.getChildren().clear();
    }

    /**
     * Places a node in the result display.
     * @param item The node to place.
     */
    public void place(Node item) {
        pane.getChildren().add(item);
        scrollPane.setContent(pane);
    }

}
