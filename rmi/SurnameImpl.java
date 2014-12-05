

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SurnameImpl extends UnicastRemoteObject implements Surname {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public SurnameImpl() throws RemoteException {
        super();
    }

    public void treateCommande(String commande) throws RemoteException {
        System.out.println("Marche!! " + commande);

    }

}
