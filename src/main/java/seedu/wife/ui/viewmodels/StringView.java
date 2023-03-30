package seedu.wife.ui.viewmodels;

import javafx.scene.Node;
import javafx.scene.control.TextArea;

public class StringView {
    private StringView() {
        // prevents instantiation
    }

    public static Node from(String stringToView) {

        final TextArea stringView = new TextArea(stringToView);
        stringView.setEditable(false);
        stringView.setWrapText(true);
        stringView.setMinHeight(800);

        return stringView;
    }
}
