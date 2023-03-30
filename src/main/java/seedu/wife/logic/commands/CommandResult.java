package seedu.wife.logic.commands;

import static java.util.Objects.requireNonNull;

/**
 * Represents the result of a command execution.
 */
public abstract class CommandResult<T> {

    // private final String feedbackToUser;

    // private final String helpMessage;

    // /** Help information should be shown to the user. */
    // private final boolean showHelp;

    // /** The application should exit. */
    // private final boolean exit;

    /**
     * Constructs a {@code CommandResult} with the specified output.
     * @param output the output to eventually display to the user.
     * @return a {@code CommandResult} that holds the output.
     */
    public static <T> CommandResult<T> from(T output) {
        requireNonNull(output);
        return new CommandResult<>() {
            @Override
            public T getOutput() {
                return output;
            }

            @Override
            public boolean equals(Object other) {
                if (other == this) {
                    return true;
                }
                if (!(other instanceof CommandResult)) {
                    return false;
                }

                CommandResult<?> asType = (CommandResult<?>) other;
                try {
                    return getOutput().equals(asType.getOutput())
                            && super.equals(asType);
                } catch (UnsupportedOperationException e) {
                    return false;
                }
            }
        };
    }


    public T getOutput() {
        throw new UnsupportedOperationException();
    }

    public String getHelpMessage() {
        throw new UnsupportedOperationException();
    }

    public boolean isShowHelp() {
        return false;
    }

    public boolean isExit() {
        return false;
    }

    protected boolean equals(CommandResult<?> other) {
        // To be called by derived classes
        return getHelpMessage() == other.getHelpMessage()
                && isExit() == other.isExit();
    }

    @Override
    public boolean equals(Object obj) {
        // To be overridden by derived classes
        return false;
    }
}

