/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Payment;

import Services.Interfaces.ITransactionService;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.NoArgsConstructor;

/**
 *
 * @author Florian Fußeder
 */
@NoArgsConstructor
public class PaymentReichelBank implements ITransactionService {

	@Inject
	private Logger logger;

	@Override
	@Transactional
	public boolean transfer(long amountInCent, String fromIBAN, String toIBAN, String description) {

		boolean result;

		try { // Call Web Service Operation
			de.jreichl.service.web.TransactionWSService service = new de.jreichl.service.web.TransactionWSService();
			de.jreichl.service.web.ITransactionWS port = service.getTransactionWSPort();
			// TODO initialize WS operation arguments here

			result = port.transfer(amountInCent, fromIBAN, toIBAN, description);
		} catch (Exception ex) {

			System.out.println(ex.getMessage());
			result = false;
		}
		return result;
	}
}
