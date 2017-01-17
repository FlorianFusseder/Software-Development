/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Factories;

import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import lombok.NoArgsConstructor;

/**
 *
 * @author Florian
 */

@Dependent
@NoArgsConstructor
public class LoggerFactory {
	
	@Produces
	public Logger getLogger(InjectionPoint p){
		return Logger.getLogger(p.getMember().getDeclaringClass().getSimpleName());
	}	
}
