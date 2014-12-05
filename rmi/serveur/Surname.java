package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Surname extends Remote{
    public void treateCommande(String commande)throws RemoteException;
}
