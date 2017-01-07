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



	public PaymentReichelBank() {

	}

	@Override
	public boolean transfer(long amountInCent, String fromIBAN, String toIBAN, String description) {
		
		try { // Call Web Service Operation
			de.jreichl.service.web.TransactionWSService service = new de.jreichl.service.web.TransactionWSService();
			de.jreichl.service.web.TransactionWS port = service.getTransactionWSPort();
			boolean result = port.transfer(amountInCent, fromIBAN, toIBAN, description);
			System.out.println("Result = "+result);
		} catch (Exception ex) {
			
			System.out.println("\n\n");
			System.out.println("________________________________________________________________");
			ex.printStackTrace();
			
			System.out.println("des war nix -> " + ex.getMessage());
			
			System.out.println("________________________________________________________________");
		}


		return false;
	}

}
