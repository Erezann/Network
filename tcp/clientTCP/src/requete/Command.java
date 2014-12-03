package requete;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mael on 09/11/14.
 */
abstract class  Command {

    static final String sep="%%";
    static final String egalite="=";

    static final String[] com = {"List","Save","Modify", "Delete"};
    private final static String packageName="requete.";

    static String commande;
    //Contient les arguments de la requete
    static Map<String,String> arguments;



    //permet d'obtenir le réultat de la requète en récupérant les arguments
    abstract String exec();

    public static Command getInstanceOf(String com,String[] args) {

        String className = com;
        commande=args[0];
        arguments=new HashMap<String,String>();
        for(int i=1;i<args.length;i++){
            setArgument(args[i]);
        }

        try {
            return (Command) Class.forName(packageName+className).newInstance();
        }
        catch ( InstantiationException e){
            e.printStackTrace();
            System.err.println("Instantiation fail in Commande \n");
        }
        catch (IllegalAccessException e){
            e.printStackTrace();
            System.err.println("Illegal access in Commande \n");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
            System.err.println("Class not found in Commande \n");
        }
        System.err.println("No class matchs to "+className +"\n");
        System.exit(1);
        return null;
    }

    String writeArgument(String argName,String argValue){
        return sep+argName+egalite+argValue;
    }

    static void printCom(){
        System.out.println("Commands :");
        for(int i=0;i<com.length;i++){
            System.out.println("\t"+com[i]);
        }
    }

    private static void setArgument(String argument){
        String key=argument.split(egalite)[0];
        String value=argument.split(egalite)[1];
        arguments.put(key,value);
    }

    @Override
    public String toString() {
        return commande+exec();
    }
}
