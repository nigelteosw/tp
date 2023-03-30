package seedu.wife.ui.viewmodels;

import javafx.scene.Node;
import javafx.scene.control.TextArea;


/**
 * A view of a {@code String} that is used for displaying in the UI.
 */
public class StringView {

    /*
     * Prevents instantiation.
     */
    private StringView() {}

    /**
     * Returns a Node that displays the stringToView.
     */
    public static Node from(String stringToView) {

        final TextArea stringView = new TextArea(stringToView);
        stringView.setEditable(false);
        stringView.setWrapText(true);
        stringView.setMinHeight(800);
        stringView.setStyle("-fx-font-size: 14px");

        return stringView;
    }
}
