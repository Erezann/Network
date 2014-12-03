package requete;

import database.Data;

/**
 * Created by mael on 03/12/14.
 */
public class Modify extends Commands{
    private static Modify modify= new Modify();
    private Modify(){}

    private final static String NAME="name";
    private final static String SURNAME="surname";
    private final static String NEW_SURNAME="newsurname";
    private final static String MESSAGE="Modify successful";

    private String name;
    private String surname;
    private String newSurname;

    static Commands getInstance(){
        return modify;
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
            else if (args.split("=")[0].equalsIgnoreCase(NEW_SURNAME) && newSurname==null){
                newSurname = args.split("=")[1];
            }
            else {
                throw new requete.BadArgumentException();
            }

            args = entry.getArguments();
        }

        if(name==null || surname==null || newSurname==null){
            throw new requete.BadArgumentException();
        }
        else {
            Data.modify(name,surname,newSurname);
        }

        name=null;
        surname=null;
        newSurname=null;

        return MESSAGE;
    }


}
