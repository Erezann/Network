package requete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mael on 07/11/14.
 */
class List extends Command {

    private final String NAME="NAME";

    @Override
    String exec() {
        if(arguments.containsKey(NAME)){
               return writeArgument(NAME, arguments.get(NAME));
        }
        return "";
    }


}

