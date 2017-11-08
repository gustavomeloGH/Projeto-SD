package br.com.sistemasDistribuidos.DuwamishDelivery;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author Jefferson Coelho
 */
public interface IDuwamishDelivery extends Remote {

	public String addProcess(Integer id) throws RemoteException;
	public String removeProcess(Integer id) throws RemoteException;
	public ArrayList<Integer> list() throws RemoteException;
}
