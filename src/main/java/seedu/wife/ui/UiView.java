package seedu.wife.ui;

import static java.util.Objects.requireNonNull;

import seedu.wife.model.food.Food;
import seedu.wife.ui.viewmodels.ItemView;
import seedu.wife.ui.viewmodels.StringView;



/**
 * A UiView that displays the result of a command.
 */
public class UiView {
    private final ResultDisplay display;

    /**
     * Constructs a UiView that displays the result of a command.
     * @param display the ResultDisplay to display the result of a command.
     */
    public UiView(ResultDisplay display) {
        this.display = display;
    }

    /**
     * Displays the result of a command.
     * @param object the result of a command.
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
