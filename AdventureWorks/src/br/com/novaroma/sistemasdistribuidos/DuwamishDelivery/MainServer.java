package br.com.novaroma.sistemasdistribuidos.DuwamishDelivery;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.swing.JOptionPane;

public class MainServer {

    public static void main(String[] args) {

        try {
            LocateRegistry.createRegistry(2015);
            Naming.rebind("rmi://localhost/dd", new DuwamishDelivery());

            JOptionPane.showMessageDialog(null, "Servidor rodando");
        } catch (RemoteException | MalformedURLException e) {
            JOptionPane.showMessageDialog(null, "(Erro no registro da aplicação) " + e.toString());
        }

    }

}
