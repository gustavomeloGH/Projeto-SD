package br.com.sistemasDistribuidos.Fabrikam;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.sistemasDistribuidos.ContosoMobile.IContosoMobile;
import br.com.sistemasDistribuidos.DuwamishDelivery.IDuwamishDelivery;

public class Fabrikam extends UnicastRemoteObject implements IFabrikam {

	private static final long serialVersionUID = 1L;
	private IContosoMobile contosoMobile;
	private IDuwamishDelivery duwamishDelivery;
	
	
	public Fabrikam() throws RemoteException { 
		initServers();
	}
	
	@Override
	public String openProcess(Integer id, String phone) throws RemoteException {
		contosoMobile.setStartRequisition(phone);
		return duwamishDelivery.addProcess(id);
	}

	@Override
	public String closeProcess(Integer id, String phone) throws RemoteException {
		contosoMobile.setFinishRequisition(phone);
		return duwamishDelivery.removeProcess(id);
	}
	
	@Override
	public ArrayList<Integer> listProcess() throws RemoteException {
		return duwamishDelivery.list();
	}
	
	private void initServers() throws RemoteException {
		try {
			contosoMobile = (IContosoMobile) Naming.lookup("rmi://localhost/cm");
			duwamishDelivery = (IDuwamishDelivery) Naming.lookup("rmi://localhost/dd");
		} catch (MalformedURLException | NotBoundException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}
	
}
