package requete;

import database.Data;

/**
 * Created by mael on 03/12/14.
 */
public class Delete extends Commands{
    private static Delete delete= new Delete();
    private Delete(){}

    private final static String NAME="name";
    private final static String SURNAME="surname";
    private final static String MESSAGE="Delete successful";

    private String name;
    private String surname;

    static Commands getInstance(){
        return delete;
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

        if(name==null){
            throw new requete.BadArgumentException();
        }

        if (surname==null){
            Data.delete(name);
        }
        else {
            Data.delete(name,surname);
        }

        name=null;
        surname=null;

        return MESSAGE;
    }

}
