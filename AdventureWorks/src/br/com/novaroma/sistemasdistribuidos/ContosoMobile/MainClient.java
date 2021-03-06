package br.com.novaroma.sistemasdistribuidos.ContosoMobile;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

public class MainClient {

    public static void main(String[] args) {
        try {

            IContosoMobile notify = (IContosoMobile) Naming.lookup("rmi://localhost/cm");
            String fone = JOptionPane.showInputDialog("Digite o celular para enviar a requisição:");
            notify.setStartRequisition(fone);

        } catch (RemoteException e) {
            JOptionPane.showMessageDialog(null, "(Erro no registro da aplicação) " + e.toString());
        } catch (NotBoundException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, "(Erro no link da aplicação) " + e.toString());
        }
    }

}
