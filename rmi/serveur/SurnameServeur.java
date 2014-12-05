package serveur;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class SurnameServeur {

    public SurnameServeur() {
        try{
            Surname surname=new SurnameImpl();
            LocateRegistry.createRegistry(8888);
            Naming.rebind("rmi://10.212.108.216:8888/SurnameServeur", surname);
        }catch(Exception e){
            System.err.println("Erreur: "+e);
        }
    }

}
