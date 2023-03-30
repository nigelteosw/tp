package seedu.wife.ui;

import static java.util.Objects.requireNonNull;

import seedu.wife.model.food.Food;
import seedu.wife.ui.viewmodels.ItemView;
import seedu.wife.ui.viewmodels.StringView;



/**
 * Represents the view of the UI.
 */
public class UiView {
    private final ResultDisplay display;

    /**
     * Constructs a UiView with the specified ResultDisplay.
     * @param display the ResultDisplay to display the view.
     */
    public UiView(ResultDisplay display) {
        this.display = display;
    }

    /**
     * Displays the view of the object.
     * @param object the object to display.
     * @throws AssertionError if the object is not a Food or String.
     */
    public void viewFrom(Object object) throws AssertionError {
        requireNonNull(object);
        display.clear();
        if (object instanceof String) {
            display.place(StringView.from((String) object));
            return;
        }
        if (object instanceof Food) {
            display.place(ItemView.from((Food) object));
            return;
        }

        // Code should not reach this point
        throw new AssertionError("Object is not a Food or String");
    }
}
