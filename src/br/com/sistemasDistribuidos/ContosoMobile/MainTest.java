package br.com.sistemasDistribuidos.ContosoMobile;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import br.com.facilitamovel.bean.SmsSimples;
import br.com.facilitamovel.service.SendMessage;

/**
 * @author Jefferson Coelho
 */
public class MainTest {

	public static void main(String[] args) {

		try {
			setRequisition("81982063902");
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, "(Erro ao enviar mensagem)" + e.toString());
		}

	}

	private static void setRequisition(String fone) throws RemoteException {

		SmsSimples sms = new SmsSimples();

		sms.setUser("JeffersonCoelho");
		sms.setPassword("vitorlindo");
		sms.setDestinatario(fone);
		sms.setMessage("Seu pedido sera entregue em breve!");

		try {
			SendMessage.simpleSend(sms);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "(Erro ao enviar mensagem)" + e.toString());
		}
		System.err.println("PEGOU");
	}

}
