package pageElements;

import test.Commands;

import java.util.ArrayList;

/**
 * Created by mayesh on 6/29/17.
 */
public class Tags {
    private static Tags ourInstance = new Tags();
    private ArrayList<String> actionNames = new ArrayList<>();
    private ArrayList<String> childTagNames = new ArrayList<>();
    private ArrayList<String> stringType = new ArrayList<>();


    public static Tags getInstance() {
        return ourInstance;
    }

    private Tags() {
        actionNames.add(Click.CLICK);
        actionNames.add(NavigateTo.NAVIGATE_TO);
        actionNames.add(Text.TEXT);

        childTagNames.add("stringType");
        childTagNames.add("string");
        childTagNames.add("verificationMessage");

        stringType.add(Commands.ID);
        stringType.add(Commands.LINK_TEXT);
        stringType.add(Commands.NAME);
        stringType.add(Commands.URL);
        stringType.add(Commands.XPATH);

    }

    public ArrayList<String> getActionNames() {
        return actionNames;
    }

    public ArrayList<String> getChildTagNames(String parentName) {
        if (parentName.equals(Text.TEXT)) {
            childTagNames.add("text");
        }
        return childTagNames;
    }

    public ArrayList<String> getStringType() {
        return stringType;
    }
}
