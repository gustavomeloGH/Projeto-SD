package br.com.sistemasDistribuidos.ContosoMobile;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;
import br.com.facilitamovel.bean.SmsSimples;
import br.com.facilitamovel.service.SendMessage;


public class ContosoMobile extends UnicastRemoteObject implements IContosoMobile {

	private static final long serialVersionUID = 1L;

	public ContosoMobile() throws RemoteException { }

	@Override
	public void setStartRequisition(String phone) throws RemoteException {

		if (!isPhone(phone)) {
			throw new Error("Digite o número do celular! \nSiga o padrão: (DD) 9.XXXX-XXXX");
		} else {

			SmsSimples sms = getSms("Seu pedido efetuado com sucesso. Aguarde a entrega em breve!", phone);
			try {
				//SendMessage.simpleSend(sms);
				System.out.printf("Enviou mensagem inicial para: %s\n", phone);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "(Erro ao enviar mensagem)" + e.toString());
			}
		}

	}

	@Override
	public void setFinishRequisition(String phone) throws RemoteException {

		if (!isPhone(phone)) {
			throw new Error("Digite o número do celular! \nSiga o padrão: (DD) 9.XXXX-XXXX");
		} else {
			SmsSimples sms = getSms("Seu pedido esta proximo ao destino, obrigado!", phone);
			try {
				//SendMessage.simpleSend(sms);
				System.out.printf("Enviou mensagem final para: %s\n", phone);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "(Erro ao enviar mensagem)" + e.toString());
			}
		}

	}
	
	private SmsSimples getSms (String msg, String phone) {
		
		SmsSimples sms = new SmsSimples();
		sms.setUser("JeffersonCoelho");
		sms.setPassword("vitorlindo");
		sms.setDestinatario(phone);
		sms.setMessage(msg);
		return sms;
		
	}
	
	private boolean isPhone(String phone) {
		return phone.matches("^[0-9]*$") && phone.length() == 11;
	}
	
}
