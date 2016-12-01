/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entitys.AbstractBook;
import Entitys.Adress;
import Entitys.Author;
import Entitys.BankDetail;
import Entitys.Customer;
import Entitys.ElectronicBook;
import Entitys.PaperBook;
import Services.BookService;
import Services.PersonService;
import Services.ShoppingService;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Setter;
import lombok.Getter;

/**
 *
 * @author Florian Fußeder
 */
@RequestScoped
@Named
public class SeedingModel implements Serializable{

	@Inject
	private PersonService personService;

	@Inject
	private BookService bookService;

	@Inject
	private ShoppingService shoppingService;

	@Setter
	private String output;
	
	@Getter
	@Setter
	private StringBuilder builder;

	public SeedingModel() {
		
	}

	private void addToOutput(Object s){
		this.builder.append(s.toString() + "\n");
	}

	public String getOutput() {
		
				this.builder = new StringBuilder();
		
		Adress addr = new Adress("MusterStrasse", "Musterstadt", 84140);
		this.addToOutput(addr);
		BankDetail b = new BankDetail("55551", "55551");
		this.addToOutput(b);
		AbstractBook pb = new PaperBook("Musterbuch", "ff-ff--fff", new Date(), BigDecimal.ONE, 14);
		this.addToOutput(pb);
		AbstractBook eb = new ElectronicBook("MusterEBook", "ee-eee-333",
				new Date(), new BigDecimal(150), "lichensetwo2");
		this.addToOutput(eb);

		Customer c1 = personService.createCustomer("Max", "MusterCustomer1", addr, b);
		this.addToOutput(c1);
		Customer c2 = personService.createCustomer("Max", "MusterCustomer2", addr, b);
		this.addToOutput(c2);
		Author a = personService.createAuthor("Max", "MusterAuthor", addr);
		this.addToOutput(a);
		
		a = bookService.persistNewBook(eb, a);
		a = bookService.persistNewBook(pb, a);
		this.addToOutput(a);

		shoppingService.addBookToCart(c1, eb);
		shoppingService.addBookToCart(c1, pb);
		shoppingService.addBookToCart(c1, pb);
		this.addToOutput(c1);

		shoppingService.addBookToCart(c2, eb);
		shoppingService.addBookToCart(c2, pb);
		shoppingService.addBookToCart(c2, pb);
		this.addToOutput(c2);

		shoppingService.buyCurrentCart(c1);
		this.addToOutput(c1); 
		return builder.toString();
	}
	
	
}
