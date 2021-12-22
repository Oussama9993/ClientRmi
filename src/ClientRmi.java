import métiers.Compte;
import rmi.IBanqueRemote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class ClientRmi {
    public static void main(String[] args) {
        try {
            IBanqueRemote stub= (IBanqueRemote) Naming.lookup("rmi://localhost:1099/BK");
            System.out.println(stub.conversion(9000));
            Compte cp= stub.consulterCompte(1);
            System.out.println("Code:"+cp.getCode());
            List<Compte> comptes=stub.listComptes();
            for (Compte c:comptes){
                System.out.println("-------------------");
                System.out.println("Code:"+c.getCode());
                System.out.println("Solde:"+c.getSolde());
                System.out.println("Date:"+c.getDateCreation());

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
