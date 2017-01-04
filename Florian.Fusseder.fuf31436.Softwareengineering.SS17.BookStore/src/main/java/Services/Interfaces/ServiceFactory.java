/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Interfaces;

import Services.Impl.TestPaymentService1;
import Services.Impl.TestPaymentService2;
import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import Annotations.PaymentAnnotation;
import Config.Config;

/**
 *
 * @author Florian Fußeder
 */
@Dependent
public class ServiceFactory implements Serializable {

	public ServiceFactory() {
	}

	@Produces
	@PaymentAnnotation
	public ITransactionService createPaymentService(InjectionPoint p) {
		String point = p.getMember().getDeclaringClass().getSimpleName();

		switch (Config.getOption()) {
			case Productiv:
				if (point.equals("ShoppingService")) {
					return new TestPaymentService2(); //todo jürgens bank einfügen
				}
			case Test:
				if (point.equals("ShoppingService")) {
					return new TestPaymentService1();
				}
			default:
				throw new AssertionError();
		}
	}
}
