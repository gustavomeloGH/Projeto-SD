package br.com.novaroma.sistemasdistribuidos.AdventureWorks;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

public class MainClient {

    public static void main(String[] args) {

        try {
            
            IAdventureWorks adventureWorks = (IAdventureWorks) Naming.lookup("rmi://localhost/aw");
            Tabelas tabelas = new Tabelas();
            tabelas.setAdventureWorks(adventureWorks);
            
        } catch (RemoteException e) {
            JOptionPane.showMessageDialog(null, "(Erro no registro da aplicação) " + e.toString());
        } catch (NotBoundException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, "(Erro no link da aplicação) " + e.toString());
        }

    }
}
