package database;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by mael on 03/12/14.
 */
public class Data {
    private static Map<String,Vector<String>> data=new HashMap<String, Vector<String>>();

    public static void add(String name,String surname){
        if (! data.containsKey(name)){
            data.put(name,new Vector<String>());
        }
        data.get(name).add(surname);
    }

    public static void delete(String name){
        data.remove(name);
    }

    public static void delete(String name, String surname){
        data.get(name).remove(surname);
    }

    public static void modify(String name, String oldSurname, String newSurname){
        data.get(name).remove(oldSurname);
        data.get(name).add(newSurname);
    }

    public static String list(){
        String s="";
        for(String name : data.keySet()){
            s+=name+"->[ ";
            for (Object surname :data.get(name).toArray()){
                s+="'"+surname.toString()+"' ";
            }
            s+="] ";
        }

        return s;
    }
}
