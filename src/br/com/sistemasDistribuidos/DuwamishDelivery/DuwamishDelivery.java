package br.com.sistemasDistribuidos.DuwamishDelivery;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class DuwamishDelivery extends UnicastRemoteObject implements IDuwamishDelivery {

	private static final long serialVersionUID = 1L;
	public static HashMap<Integer, ArrayList> listprocess;

	public DuwamishDelivery() throws RemoteException {
		listprocess = new HashMap<Integer, ArrayList>();
	}

	@Override
	public String addProcess(Integer id, String phone) {
		String result = "";
			
		if (listprocess.containsKey(id)) {
			result = ("ID já existente, tente outra!");
		} else {
			ArrayList data = new ArrayList<>();
			Calendar date = getCalendar();
			data.add(date); data.add(phone);
			listprocess.put(id, data);
			System.out.printf("Foi criado um novo processo -> Dados: ID: %d, Phone: %s Hora que encerra: %d:%d\n", id, phone, date.get(Calendar.HOUR_OF_DAY), date.get(Calendar.MINUTE));
			result = "Processo adicionado com sucesso!";
		}
		return result;
	}

	@Override
	public String removeProcess(Integer id) {
		String result = "";

		if (listprocess.containsKey(id)) {
			listprocess.remove(id);
			result = "Processo entregue com sucesso.";
		} else {
			result = ("Esse processo não existe, verifique o ID!");
		}
		return result;
	}

	@Override
	public HashMap<Integer, ArrayList> list() {
		return listprocess;
	}
	
	private Calendar getCalendar() {
		Random random = new Random();
		Calendar date = Calendar.getInstance();
		int randomNum = 5 + (int)(Math.random() * 5); 
		date.set(Calendar.YEAR, Calendar.MONTH, Calendar.DATE, date.get(Calendar.HOUR_OF_DAY), date.get(Calendar.MINUTE) + randomNum, date.get(Calendar.SECOND));
		return date;
		
	}
	
}