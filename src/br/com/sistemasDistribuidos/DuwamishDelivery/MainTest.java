package br.com.sistemasDistribuidos.DuwamishDelivery;

import java.awt.HeadlessException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;
import br.com.sistemasDistribuidos.DuwamishDelivery.IMonitor;

/**
 * @author Jefferson Coelho
 */
public class MainTest {

	public static void main(String[] args) {

		IMonitor monitor = null;
		try {
			monitor = new Monitor();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}

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
	}

}
