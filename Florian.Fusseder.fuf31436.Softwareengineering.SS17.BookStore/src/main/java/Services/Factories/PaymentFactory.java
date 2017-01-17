/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Factories;

import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import Config.Config;
import Services.Impl.ShoppingService;
import Services.Interfaces.ITransactionService;
import Services.Payment.PaymentReichelBank;
import Services.Payment.TestPaymentService;
import lombok.NoArgsConstructor;

/**
 *
 * @author Florian Fußeder
 */
@Dependent
@NoArgsConstructor
public class PaymentFactory implements Serializable {

	@Produces
	public ITransactionService createPaymentService(InjectionPoint p) {
		String point = p.getMember().getDeclaringClass().getSimpleName();

		switch (Config.getOption()) {
			case Productiv:
				if (point.equals(ShoppingService.class.getSimpleName())) {
					return new PaymentReichelBank();
				} 
			case Test:
				if (point.equals(ShoppingService.class.getSimpleName())) {
					return new TestPaymentService();
				} 
			default:
				throw new AssertionError();
		}
	}
}
