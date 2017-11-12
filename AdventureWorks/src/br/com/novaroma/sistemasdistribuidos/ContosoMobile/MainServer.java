package br.com.novaroma.sistemasdistribuidos.ContosoMobile;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.swing.JOptionPane;


public class MainServer {

	public static void main(String[] args) {

		try {
			LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://localhost/cm", new ContosoMobile());

			JOptionPane.showMessageDialog(null, "Servidor rodando");
		} catch (RemoteException | MalformedURLException e) {
			JOptionPane.showMessageDialog(null, "(Erro no registro da aplica��o) " + e.toString());
		}
	}

}
