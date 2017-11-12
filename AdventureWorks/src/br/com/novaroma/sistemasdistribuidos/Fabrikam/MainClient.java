package br.com.novaroma.sistemasdistribuidos.Fabrikam;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

public class MainClient {

    public static void main(String[] args) {

        try {
            IFabrikam fabrikam = (IFabrikam) Naming.lookup("rmi://localhost/fb");
            System.out.println(fabrikam.listProcess().isEmpty());
            fabrikam.startCheckAllStatus();
            fabrikam.openProcess(123, "81983445318");
            System.out.println(fabrikam.listProcess().isEmpty());
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            JOptionPane.showMessageDialog(null, "(Erro no registro da aplicação) " + e.toString());
        }

    }

}
