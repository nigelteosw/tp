package seedu.wife.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;


/**
 * Represents the result of a command execution.
 */
public class CommandResult<T> {

    private final String feedbackToUser;

    private final String helpMessage;

    /** Help information should be shown to the user. */
    private final boolean showHelp;

    /** The application should exit. */
    private final boolean exit;

    private final T output;

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, String helpMessage, boolean showHelp, boolean exit, T output) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.helpMessage = requireNonNull(helpMessage);
        this.showHelp = showHelp;
        this.exit = exit;
        this.output = output;
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser, T output) {
        this(feedbackToUser, "", false, false, output);
    }


    /**
     * Constructs a {@code CommandResult} with the specified output.
     * @param output the output to eventually display to the user.
     * @return a {@code CommandResult} that holds the output.
     */
    public static <T> CommandResult<T> from(T output) {
        requireNonNull(output);
        return new CommandResult<T>("", output);
    }

    public T getOutput() {
        return output;
    }

    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    public String getHelpMessage() {
        return helpMessage;
    }

    public boolean isShowHelp() {
        return showHelp;
    }

    public boolean isExit() {
        return exit;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CommandResult)) {
            return false;
        }

        CommandResult otherCommandResult = (CommandResult) other;
        return feedbackToUser.equals(otherCommandResult.feedbackToUser)
                && helpMessage.equals(otherCommandResult.helpMessage)
                && showHelp == otherCommandResult.showHelp
                && exit == otherCommandResult.exit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, helpMessage, showHelp, exit);
    }

}
