package seedu.wife.ui.viewmodels;

import javafx.scene.Node;
import javafx.scene.control.TextArea;

/**
 * A view that displays a string.
 */
public class StringView {
    /**
     * Prevents instantiation.
     */
    private StringView() {}

    /**
     * Creates a view that displays a string.
     *
     * @param stringToView The string to display.
     * @return A view that displays the string.
     */
    public static Node from(String stringToView) {
        final TextArea stringView = new TextArea(stringToView);
        stringView.setEditable(false);
        stringView.setWrapText(true);
        stringView.setMinHeight(800);

        return stringView;
    }
}
