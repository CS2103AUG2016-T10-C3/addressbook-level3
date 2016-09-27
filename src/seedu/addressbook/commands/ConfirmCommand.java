package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;

/**
 * Prompts user for confirmation of command e.g. DeleteCommand
 * Expects an input of the format: Y/N
 */

public class ConfirmCommand extends Command {

    public static final String MESSAGE_DELETE_PERSON_CONFIRMATION = "Are you sure? Enter confirm + y/n";
    
    public static final String MESSAGE_DELETE_CONFIRMATION_SUCCESS = "Deletion confirmed.";
    
    public static final String MESSAGE_DELETE_CONFIRMATION_ABORT = "Deletion aborted.";
    
    public static final String COMMAND_WORD = "confirm";
    
    public static final String MESSAGE_WRONG_LETTER = "Please enter \"confirm + y/n\"";

    private String confirm;
    
    public ConfirmCommand(String arguments){
        this.setConfirm(arguments);        
    }
    
    @Override
    public CommandResult execute() {
        if (getConfirm().equals("y"))
            return new CommandResult(MESSAGE_DELETE_CONFIRMATION_SUCCESS);
        else if (getConfirm().equals("n"))
            return new CommandResult(MESSAGE_DELETE_CONFIRMATION_ABORT);
        else
            return new CommandResult(MESSAGE_WRONG_LETTER);
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public static void showConfirm() {
        System.out.println(MESSAGE_DELETE_PERSON_CONFIRMATION);
    }
}
