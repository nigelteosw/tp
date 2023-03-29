package seedu.wife.ui;

import static java.util.Objects.requireNonNull;

import seedu.wife.model.food.Food;
import seedu.wife.ui.ResultDisplay;
import seedu.wife.ui.viewmodels.StringView;
import seedu.wife.ui.viewmodels.ItemView;

public class UiView {
    private final ResultDisplay display;

    public UiView(ResultDisplay display) {
        this.display = display;
    }

    public void viewFrom(Object object) throws AssertionError{
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
