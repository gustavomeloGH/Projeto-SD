package br.com.sistemasDistribuidos.DuwamishDelivery;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

/**
 * @author Jefferson Coelho
 */
public class MainClient {

	public static void main(String[] args) {
		
				try {
		
					IMonitor monitor = (IMonitor) Naming.lookup("rmi://localhost/dd");
		
					try {
		
						JOptionPane.showMessageDialog(null, "Teste = " + monitor.addProcess(new Monitor(1)));
						JOptionPane.showMessageDialog(null, "Teste = " + monitor.addProcess(new Monitor(6)));
						JOptionPane.showMessageDialog(null, "Teste = " + monitor.addProcess(new Monitor(6)));
		
					} catch (HeadlessException | RemoteException e) {
						JOptionPane.showMessageDialog(null, e.toString());
					}
		
					try {
						for (int i = 0; i < monitor.show().size(); i++) {
		
							JOptionPane.showMessageDialog(null, monitor.show().get(i));
						}
					} catch (RemoteException e) {
						JOptionPane.showMessageDialog(null, e.toString());
					}
		
				} catch (RemoteException e) {
					JOptionPane.showMessageDialog(null, "(Erro no registro da aplicação) " + e.toString());
				} catch (NotBoundException e) {
					JOptionPane.showMessageDialog(null, e.toString());
				} catch (MalformedURLException e) {
					JOptionPane.showMessageDialog(null, "(Erro no link da aplicação) " + e.toString());
				}
		
			}

}
