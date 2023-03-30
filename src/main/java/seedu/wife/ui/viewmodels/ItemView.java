package seedu.wife.ui.viewmodels;


import java.util.Comparator;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import seedu.wife.model.food.Food;



/**
 * A view of an {@code Item} that is used for displaying in the UI.
 */
public class ItemView {
    private static final double SPACING_UNIT = 8.0;

    private ItemView() {
        // prevents instantiation
    }

    /**
     * Creates a view of an {@code Item} that is used for displaying in the UI.
     * @param foodToView the item to be displayed
     * @return a view of the item
     */
    public static Node from(Food foodToView) {
        // Name
        final Label name = new Label(foodToView.getName().toString());
        name.prefWidth(Double.MAX_VALUE);
        name.setWrapText(true);

        // Unit
        final Label unit = new Label(foodToView.getUnit().toString());

        // Quantity
        final Label quantityLabel = new Label("Quantity Remaining: ");
        final Label quantityValue = new Label(foodToView.getQuantity().toString());

        // Tags
        final FlowPane tags = new FlowPane();
        // add all tags with a styleclass to the flowpane from foodToView
        foodToView.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.getTagName()))
                .forEach(tag -> tags.getChildren().add(new Label(tag.getTagName())));

        // set styleclass for the flowpane
        tags.getStyleClass().add("tags");
        tags.setAlignment(Pos.CENTER_LEFT);
        tags.setHgap(SPACING_UNIT);
        tags.setVgap(SPACING_UNIT);


        // Combine everything
        final Separator linedSeparator = new Separator();
        linedSeparator.getStyleClass().add("lined-separator");
        final VBox foodView = new VBox(
                name,
                new HBox(unit),
                new Separator(),
                new HBox(quantityLabel, quantityValue),
                new Separator(),
                new Label("Expiry Date: " + buildExpiryDateStringFrom(foodToView)),
                new Separator(),
                tags);
        foodView.setSpacing(SPACING_UNIT);
        return foodView;
    }

    /**
     * Builds the string representation of the item's quantity attached to its units.
     *
     * @param foodToView the item whose quantity and units are to be formatted.
     * @return the string representation of the item's quantity and units.
     */
    public static String buildItemQuantityAndUnitStringFrom(Food foodToView) {
        final String unit = String.valueOf(foodToView.getUnit()).isBlank() ? "" : " " + foodToView.getUnit().toString();
        return String.format("%s%s", foodToView.getQuantity(), unit);
    }

    /**
     * Builds the string representation of the item's expiry date.
     *
     * @param foodToView the item whose expiry date is to be formatted.
     * @return the string representation of the item's expiry date.
     */
    public static String buildExpiryDateStringFrom(Food foodToView) {
        return foodToView.getExpiryDate().toString();
    }
}
