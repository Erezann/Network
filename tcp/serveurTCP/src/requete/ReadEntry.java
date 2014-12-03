package requete;

/**
 * Created by mael on 03/12/14.
 */

/**
 * This class parse the entry, create the new command and send it arguments
 *
 */

public class ReadEntry {

    private String[] entry;
    private int iterator=0;

    public ReadEntry(String s){
        entry=s.split(" ");
    }

    public String getCommands(){
        return Commands.getCommands(entry[iterator],this);
    }

    String getArguments(){
        iterator++;
        if (iterator>=entry.length) return null;
        String argument=entry[iterator];
        while (iterator+1<entry.length && ! entry[iterator+1].contains("=")){
            iterator++;
            argument+=entry[iterator];
        }

        return argument;
    }

}
