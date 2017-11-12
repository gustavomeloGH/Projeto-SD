package br.com.novaroma.sistemasdistribuidos.AdventureWorks;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.swing.JOptionPane;

public class MainServer {

    public static void main(String[] args) {

        try {

            LocateRegistry.createRegistry(3050);
            Naming.rebind("rmi://localhost/aw", new AdventureWorks());

            JOptionPane.showMessageDialog(null, "Servidor rodando");
        } catch (RemoteException | MalformedURLException e) {

            JOptionPane.showMessageDialog(null, "(Erro no registro da aplicação) " + e.toString());
        }

    }

}
