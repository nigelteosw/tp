package seedu.wife.ui.viewmodels;


import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Separator;
import seedu.wife.model.food.Food;

/**
 * A view of an {@code Item} that is used for displaying in the UI.
 */
public class ItemView {
	
	private static final double SPACING_UNIT = 8.0;

	private ItemView() {
		// prevents instantiation
	}

	public static Node from(Food foodToView) {
		// Name
		final Label name = new Label(foodToView.getName().toString());


		// Unit
		final Label unit = new Label(foodToView.getUnit().toString());

		// Quantity
		final Label quantityLabel = new Label("Quantity Remaining: ");
		final Label quantityValue = new Label(foodToView.getQuantity().toString());

		// Expiry Date
		final Label expiryDate = new Label(foodToView.getExpiryDate().toString());

		// Tags
		final Label tags = new Label(foodToView.getTags().toString());

		// Combine everything
        final Separator linedSeparator = new Separator();
        linedSeparator.getStyleClass().add("lined-separator");
        final VBox foodView = new VBox(
                name,
                new HBox(quantityLabel, quantityValue),
                new Separator(),
                new Label("Expiry Date: " + buildExpiryDateStringFrom(foodToView)),
                new Separator(),
				new Label("Tags: " + tags.getText()));
        foodView.setSpacing(SPACING_UNIT);
        return foodView;
	}

	 /**
     * Builds the string representation of the item's quantity attached to its units.
     *
     * @param item the item whose quantity is to be formatted.
     * @return the string representation of the item's quantity and units.
     */
    public static String buildItemQuantityAndUnitStringFrom(Food foodToView) {
        final String unit = String.valueOf(foodToView.getUnit()).isBlank() ? "" : " " + foodToView.getUnit().toString();
        return String.format("%s%s", foodToView.getQuantity(), unit);
    }

    /**
     * Builds the string representation of the item's expiry date.
     *
     * @param item the item whose expiry date is to be formatted.
     * @return the string representation of the item's expiry date.
     */
    public static String buildExpiryDateStringFrom(Food foodToView) {
        return foodToView.getExpiryDate().toString();
    }
  
}
