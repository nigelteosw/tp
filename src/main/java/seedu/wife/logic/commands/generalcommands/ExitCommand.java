package seedu.wife.logic.commands.generalcommands;

import seedu.wife.logic.commands.Command;
import seedu.wife.logic.commands.CommandResult;
import seedu.wife.model.Model;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "exit";

    public static final String MESSAGE_EXIT_ACKNOWLEDGEMENT = "Exiting WIFE as requested ...";


    @Override
    public CommandResult<String> execute(Model model) {
        return new CommandResult<String>() {
            @Override
            public String getOutput() {
                return MESSAGE_EXIT_ACKNOWLEDGEMENT;
            }

            @Override
            public boolean isExit() {
                return true;
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

}
