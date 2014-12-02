package requete;

/**
 * Created by mael on 07/11/14.
 */


public class Requete {

    Command command;

    public Requete(String requete) throws CommandNotFoundException{

        String[] req=requete.split("%%");

        command = createCommand(req);
    }

    private Command createCommand(String[] req) throws CommandNotFoundException{
        Command.printCom();
        Command c=null;

        String command=req[0];

        for(int i=0; i<Command.com.length;i++){
            if(command.equalsIgnoreCase(Command.com[i])){
                c=Command.getInstanceOf(Command.com[i],req);
            }
        }

        if(c==null) {
            errorCommand(command);
        }

        return c;
    }

    private void errorCommand(String commmand) throws CommandNotFoundException{
        throw new CommandNotFoundException();
    }

    @Override
    public String toString() {
        return command.toString();
    }
}
