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
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Fabrikam extends UnicastRemoteObject implements IFabrikam {

	private static final long serialVersionUID = 1L;
	private IContosoMobile contosoMobile;
	private IDuwamishDelivery duwamishDelivery;
	ArrayList<Integer> nearDeliveryId;
	
	
	public Fabrikam() throws RemoteException { 
		nearDeliveryId = new ArrayList<Integer>();
		initServers();
	}
	
	@Override
	public String openProcess(Integer id, String phone) throws RemoteException {
		contosoMobile.setStartRequisition(phone);
		return duwamishDelivery.addProcess(id, phone);
	}

	@Override
	public String closeProcess(Integer id, String phone) throws RemoteException {
		contosoMobile.setFinishRequisition(phone);
		return duwamishDelivery.removeProcess(id);
	}
	
	@Override
	public HashMap<Integer, ArrayList> listProcess() throws RemoteException {
		return duwamishDelivery.list();
	}
	
	@Override
	public void startCheckAllStatus()  throws RemoteException {
		Timer timer = new Timer();
		int seg = 60*1000;
	    timer.schedule(new TimerTask() {
	        public void run() {
	           try {
				doCheck();
				} catch (RemoteException e) {
					JOptionPane.showMessageDialog(null, e.toString());
				}
	        }
	     }, 0, seg);
	}
	
	private void doCheck () throws RemoteException {
		HashMap<Integer, ArrayList> list = listProcess();
		if(!list.isEmpty()) {
	    	//curr.key() -> id, curr.getValue() -> 0 - CALENDAR | 1 - PHONE
			String phone; 
			Calendar date;
			int id;
			
			for (Map.Entry<Integer, ArrayList> curr : list.entrySet()) {
				
				id = curr.getKey();
				phone = (String) curr.getValue().get(1);
				date = (Calendar) curr.getValue().get(0);
				
			    if(isDelivery(date)) {
			    	
			    	duwamishDelivery.removeProcess(id);
			    	if(!nearDeliveryId.isEmpty()) nearDeliveryId.remove(new Integer(id));
			    	System.out.printf("Encerrou o processo ID: %d, Phone: %s\n", id, phone);
			    	
			    } else if (isNearDelivery(date) && !nearDeliveryId.contains(id)) {
			    	
			    	contosoMobile.setFinishRequisition(phone);
			    	nearDeliveryId.add(id);
			    	System.out.printf("Enviou mensagem de fim pro phone: %s, ID: %d\n", phone, id);
			    }
			}
		} else {
			System.out.println("Lista está vazia...");
		}
	}
	
	private void initServers() throws RemoteException {
		try {
			contosoMobile = (IContosoMobile) Naming.lookup("rmi://localhost/cm");
			duwamishDelivery = (IDuwamishDelivery) Naming.lookup("rmi://localhost/dd");
		} catch (MalformedURLException | NotBoundException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}
	
	private boolean isNearDelivery (Calendar date) {

		int restMin = getDifereceBetweenDates(date);
		return Math.abs(restMin) <= 3;
		
	}
	
	private boolean isDelivery (Calendar date) {
		int restMin = getDifereceBetweenDates(date);
		return (restMin <= 0);
	}
	
	private int getDifereceBetweenDates(Calendar date) {
		int finalHour = date.get(Calendar.HOUR_OF_DAY);
		int finalMin = date.get(Calendar.MINUTE);
		
		Calendar currDate = Calendar.getInstance();
		int currHour = currDate.get(Calendar.HOUR_OF_DAY);
		int currMin = currDate.get(Calendar.MINUTE);

		int restMin = ((finalHour * 60) + finalMin) - ((currHour * 60) + currMin);
		return restMin;
	}
	
	
}
