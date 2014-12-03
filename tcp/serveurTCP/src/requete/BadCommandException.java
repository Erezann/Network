package requete;

/**
 * Created by mael on 03/12/14.
 */
public class BadCommandException extends Exception{

    private final String ERROR="Error : Command name doesn't exist.";

    @Override
    public String getMessage() {
        return ERROR;
    }
}
