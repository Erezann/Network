package requete;

/**
 * Created by mael on 07/11/14.
 */
class Delete extends Command {
    static final String NAME = "NAME";
    static final String SURNAME = "SURNAME";

    @Override
    String exec() {
        if(arguments.containsKey(SURNAME)){
            return writeArgument(NAME, arguments.get(NAME))+writeArgument(SURNAME, arguments.get(SURNAME));
        }
        return writeArgument(NAME, arguments.get(NAME));
    }
}
