package seedu.addressbook.commands;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.person.UniquePersonList.DuplicatePersonException;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;

/**
 * Edit the phone number of a contact in the address book
 * Expects an input of the format: edit <name> <phone>
 */

public class EditPhoneCommand extends Command {

    public static final String COMMAND_WORD = "EditPhone";
    
    public static final String MESSAGE_SUCCESS = "Number has been successfully changed";

    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book";

    private static final String MESSAGE_PERSON_NONEXISTENT = "This person is not a contact in the address book";
    
    private final String keyword;
    private final String phone;
    private Person personEdited;

    public EditPhoneCommand(String[] details) {
        this.keyword = details[0];
        this.phone = details[1];
    }

    @Override
    public CommandResult execute(){
        try {
            final ReadOnlyPerson personFound = getPersonWithNameContainingKeyword(keyword);
            if(personFound == null)
                return new CommandResult(MESSAGE_PERSON_NONEXISTENT);
            personEdited = new Person(personFound);
            addressBook.removePerson(personFound);
            addressBook.addPerson(personEdited);
            return new CommandResult(String.format(MESSAGE_SUCCESS, personEdited));
        } catch (UniquePersonList.DuplicatePersonException dpe) {
            return new CommandResult(MESSAGE_DUPLICATE_PERSON);
        } catch (PersonNotFoundException pnfe) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        }

    }
    
    /**
     * Find and return the person with the keyword in the name
     */
    
    private ReadOnlyPerson getPersonWithNameContainingKeyword(String keyword){
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            if(keyword.equals(person.getName().getWordsInName())){
                return person;
            }
        }
        return null;
    }
    
}
