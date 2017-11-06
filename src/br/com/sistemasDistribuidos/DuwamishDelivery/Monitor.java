package br.com.sistemasDistribuidos.DuwamishDelivery;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * @author Jefferson Coelho
 */

public class Monitor extends UnicastRemoteObject implements IMonitor {

	private static final long serialVersionUID = 1L;

	public Monitor() throws RemoteException {
	}

	public Monitor(int id) throws RemoteException {
		this.id = id;
		this.status = true;
	}

	public static ArrayList<Monitor> listprocess = new ArrayList<>();

	@SuppressWarnings("unused")
	private int id;
	@SuppressWarnings("unused")
	private boolean status;

	public String addProcess(Monitor monitor) {
		String result = "";

		try {

			if (listprocess.contains(monitor)) {

				result = "ID já existente, tente outra!";
			} else {

				listprocess.add(monitor);
				result = "Processo adicionado com sucesso!";
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "(Erro ao tentar adicionar o processo) " + e.toString());
		}

		return result;
	}

	public String removeProcess(Monitor monitor) {
		String result = "";

		try {
			if (listprocess.contains(monitor)) {

				listprocess.remove(monitor);
				result = "Processo entregue com sucesso.";
			} else {
				result = "Esse processo não existe, verifique o ID!";
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "(Erro ao tentar remover o processo) " + e.toString());
		}

		return result;
	}

	public ArrayList<Monitor> show() {
		return listprocess;
	}

}