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
public class TestPaymentService implements ITransactionService {

	public TestPaymentService() {
	}

	@Override
	public boolean transfer(long amountInCent, String fromIBAN, String toIBAN, String description) {
		System.out.println(amountInCent + " ct, from " + fromIBAN + ", to " + toIBAN + "\n" + description);
		return true;
	}
}
