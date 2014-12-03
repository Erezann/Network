package requete;

import database.Data;

/**
 * Created by mael on 03/12/14.
 */
public class Save extends Commands{

    private static Save save= new Save();
    private Save(){}

    private final static String NAME="name";
    private final static String SURNAME="surname";
    private final static String MESSAGE="Save successful";

    private String name=null;
    private String surname=null;

    static Commands getInstance(){
        return save;
    }

    String virtualConstructor(ReadEntry entry) throws requete.BadArgumentException{
        String args;
        args = entry.getArguments();

        while (args != null){

            if (args.split("=")[0].equalsIgnoreCase(NAME) && name==null) {
                name = args.split("=")[1];
            }
            else if (args.split("=")[0].equalsIgnoreCase(SURNAME) && surname==null) {
                surname = args.split("=")[1];
            }
            else {
                throw new requete.BadArgumentException();
            }

            args = entry.getArguments();
        }

        if(name==null || surname==null){
            throw new requete.BadArgumentException();
        }

        Data.add(name,surname);

        name=null;
        surname=null;

        return MESSAGE;
    }
}
