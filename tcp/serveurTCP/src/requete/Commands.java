package requete;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mael on 03/12/14.
 */


public abstract class  Commands {

    private static Map<String,Commands> COMMANDS=new HashMap<String, Commands>() {
    };
    static {
        COMMANDS.put("list", List.getInstance());
        COMMANDS.put("modify", Modify.getInstance());
        COMMANDS.put("delete", Delete.getInstance());
        COMMANDS.put("save", Save.getInstance());
    }

    abstract String virtualConstructor(ReadEntry entry) throws BadArgumentException;

    static String getCommands(String commandeName,ReadEntry entry){
        try {
            return COMMANDS.get(commandeName.toLowerCase()).virtualConstructor(entry);
        }
        catch (BadArgumentException e){
            return e.getMessage();
        }

    }
}
