/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Interfaces;

/**
 *
 * @author Florian Fußeder
 */
public interface ITransactionService {

	public boolean transfer(long amountInCent, String fromIBAN, String toIBAN, String description);
}
