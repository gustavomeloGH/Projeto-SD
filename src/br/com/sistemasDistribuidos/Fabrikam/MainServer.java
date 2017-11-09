package br.com.sistemasDistribuidos.Fabrikam;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class MainServer {

	public static void main(String[] args) {
		

		
		try {
			LocateRegistry.createRegistry(2099);
			Naming.rebind("rmi://localhost/fb", new Fabrikam());
			JOptionPane.showMessageDialog(null, "Servidor rodando");
		} catch (RemoteException | MalformedURLException e) {
			JOptionPane.showMessageDialog(null, "(Erro no registro da aplica��o) " + e.toString());
		}

	}

}
