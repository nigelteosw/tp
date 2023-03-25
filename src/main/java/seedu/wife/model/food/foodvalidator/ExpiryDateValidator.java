package seedu.wife.model.food.foodvalidator;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

import static seedu.wife.commons.util.AppUtil.checkArgument;

/**
 * Validator class to validate Expiry Date.
 */
public class ExpiryDateValidator implements FoodValidator {
    public static final String VALIDATION_REGEX = "[0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]";
    public static final String MESSAGE_FORMAT_CONSTRAINTS = "Format of your date is incorrect. "
            + "Please insert using the format DD-MM-YYYY";
    public static final String MESSAGE_DATE_NOT_EXIST = "The date you entered does not exist.";
    public static final String MESSAGE_DATE_NOT_AFTER = "The date you entered should not be before today.";
    public static final DateTimeFormatter validDateFormat = DateTimeFormatter.ofPattern("dd-MM-uuuu");

    /**
     * Checks if the date format is valid.
     *
     * @param date Date entered by the user.
     * @return True if format is valid.
     */
    public static boolean isValidDateFormat(String date) {
        return date.matches(VALIDATION_REGEX);
    }

    /**
     * Checks if the date is an actual calendar date.
     *
     * @param date Date entered by the user.
     * @return True if the date exists, else false.
     */
    public static boolean isDateExist(String date) {
        try {
            LocalDate.parse(date, validDateFormat.withResolverStyle(ResolverStyle.STRICT));
        } catch (DateTimeException de) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the date is after the date of insertion of the food item.
     *
     * @param date Date entered by the user.
     * @return True if the date is after the date of insertion, else false.
     */
    public static boolean isDateAfter(String date) {
        LocalDate expiryDate = LocalDate.parse(date, validDateFormat);
        LocalDate dateNow = LocalDate.now();
        return expiryDate.isAfter(dateNow);
    }

    public static Void validate(String date) {
        checkArgument(isValidDateFormat(date), MESSAGE_FORMAT_CONSTRAINTS);
        checkArgument(isDateExist(date), MESSAGE_DATE_NOT_EXIST);
        checkArgument(isDateAfter(date), MESSAGE_DATE_NOT_AFTER);
        return null;
    }
}
