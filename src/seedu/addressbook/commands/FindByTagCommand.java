package seedu.addressbook.commands;

import java.util.Set;

public class FindByTagCommand {
    public static final String COMMAND_WORD = "findbytag";
    
    private final Set<String> keywords;
    
    public FindByTagCommand(Set<String> keywords) {
        this.keywords = keywords;
    }
}
