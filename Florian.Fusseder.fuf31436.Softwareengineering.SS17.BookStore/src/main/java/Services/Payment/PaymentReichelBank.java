/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Payment;

import javax.enterprise.context.RequestScoped;
import Services.Interfaces.ITransactionService;

/**
 *
 * @author Florian Fußeder
 */
@RequestScoped
public class PaymentReichelBank implements ITransactionService {

	private de.jreichl.service.web.TransactionWSService service;
	private de.jreichl.service.web.TransactionWS port;

	public PaymentReichelBank() {
		try {
			//todo: bleibt der port gleich -> so lassen oder ändert er sich -> in den transfer!	
			this.service = new de.jreichl.service.web.TransactionWSService();
			this.port = service.getTransactionWSPort();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}

	}

	@Override
	public boolean transfer(long amountInCent, String fromIBAN, String toIBAN, String description) {

		try {
			boolean result = this.port.transfer(amountInCent, fromIBAN, toIBAN, description);
			System.out.println("Result = " + result);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return false;
	}

}
