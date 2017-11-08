package br.com.sistemasDistribuidos.ContosoMobile;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Jefferson Coelho
 */
public interface IContosoMobile extends Remote {

	public void setStartRequisition(String phone) throws RemoteException;
	public void setFinishRequisition(String phone) throws RemoteException;

}
