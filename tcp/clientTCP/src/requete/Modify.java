package requete;

/**
 * Created by mael on 07/11/14.
 */
class Modify extends Command {
    static final String NAME = "NAME";
    static final String SURNAME = "SURNAME";
    static final String NEW_SURNAME = "NEW_SURNAME";

    @Override
    String exec() {
        return writeArgument(NAME, arguments.get(NAME)) + writeArgument(SURNAME, arguments.get(SURNAME) );

    }
}
