/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Payment;

import Services.Interfaces.ITransactionService;
import java.util.logging.Logger;
import javax.inject.Inject;
import lombok.NoArgsConstructor;

/**
 *
 * @author Florian Fußeder
 */
@NoArgsConstructor
public class TestPaymentService implements ITransactionService {
	
	@Override
	public boolean transfer(long amountInCent, String fromIBAN, String toIBAN, String description) {
		return true;
	}
}
