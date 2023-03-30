package seedu.wife.ui.viewmodels;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class StringView {
    private StringView() {
        // prevents instantiation
    }

    public static Node from(String stringToView) {

        final Label text = new Label(stringToView);

        final VBox stringView = new VBox(text);
        stringView.getStyleClass().add("pane-with-border");

        return stringView;
    }
}
