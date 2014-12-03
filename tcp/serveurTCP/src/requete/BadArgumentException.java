package requete;

/**
 * Created by mael on 03/12/14.
 */
public class BadArgumentException extends Exception {

    private final String ERROR="Error : Wrong number of argument";

    @Override
    public String getMessage() {
        return ERROR;
    }
}
