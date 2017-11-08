package br.com.sistemasDistribuidos.DuwamishDelivery;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * @author Jefferson Coelho
 */

public class DuwamishDelivery extends UnicastRemoteObject implements IDuwamishDelivery {

	private static final long serialVersionUID = 1L;
	public static ArrayList<Integer> listprocess = new ArrayList<>();

	public DuwamishDelivery() throws RemoteException {}

	public String addProcess(Integer id) {
		String result = "";
			
		if (listprocess.contains(id)) {
			result = ("ID já existente, tente outra!");
		} else {
			listprocess.add(id);
			result = "Processo adicionado com sucesso!";
		}
		return result;
	}

	public String removeProcess(Integer id) {
		String result = "";

		if (listprocess.contains(id)) {
			listprocess.remove(id);
			result = "Processo entregue com sucesso.";
		} else {
			result = ("Esse processo não existe, verifique o ID!");
		}
		return result;
	}

	public ArrayList<Integer> list() {
		return listprocess;
	}
	
	
	
}