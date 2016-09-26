package seedu.addressbook.commands;

import java.util.List;
import java.util.Set;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class FindByTagCommand extends Command{
    public static final String COMMAND_WORD = "findbytag";
    
    private final Set<String> keywords;
    
    public FindByTagCommand(Set<String> keywords) {
        this.keywords = keywords;
    }

}
