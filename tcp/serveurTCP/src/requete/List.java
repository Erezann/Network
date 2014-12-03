package requete;

import database.Data;

/**
 * Created by mael on 03/12/14.
 */
public class List extends Commands{

    private static List list= new List();
    private List(){}



    static Commands getInstance(){
        return list;
    }

    String virtualConstructor(ReadEntry entry) throws requete.BadArgumentException{
        if(entry.getArguments()!=null){
            throw new requete.BadArgumentException();
        }
        return Data.list();
    }
}
