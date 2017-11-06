package br.com.sistemasDistribuidos.DuwamishDelivery;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author Jefferson Coelho
 */
public interface IMonitor extends Remote {

	public String addProcess(Monitor monitor) throws RemoteException;
	public String removeProcess(Monitor monitor) throws RemoteException;
	public ArrayList<Monitor> show() throws RemoteException;
}
