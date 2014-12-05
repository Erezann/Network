package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import serveur.Surname;

public class Main {

    public static void main(String[] args) {
        try {
            Surname surname = (Surname) Naming
                    .lookup("rmi://10.212.108.216:8888/SurnameServeur");
            surname.treateCommande("abc");
        } catch (MalformedURLException murle) {
            System.err.println("MalformedURLException: " + murle);
        } catch (RemoteException re) {
            System.err.println("RemoteException: " + re);
        } catch (NotBoundException nbe) {
            System.err.println("NotBoundException: " + nbe);
        }

    }

}
