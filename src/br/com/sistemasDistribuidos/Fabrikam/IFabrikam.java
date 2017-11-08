package br.com.sistemasDistribuidos.Fabrikam;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IFabrikam extends Remote {

	public String openProcess(Integer id, String phone) throws RemoteException;
	public String closeProcess(Integer id, String phone) throws RemoteException;
	public ArrayList<Integer> listProcess() throws RemoteException;
	
}
