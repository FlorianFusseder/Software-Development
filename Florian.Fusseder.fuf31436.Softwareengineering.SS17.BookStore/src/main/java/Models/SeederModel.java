/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entitys.AbstractBook;
import Entitys.Address;
import Entitys.Author;
import Entitys.BankDetail;
import Entitys.ElectronicBook;
import Entitys.PaperBook;
import Services.Interfaces.IBookService;
import Services.Interfaces.IPersonService;
import Services.Interfaces.IShoppingService;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author Florian Fußeder
 */
@RequestScoped
@Named
@Getter
@Setter
@NoArgsConstructor
public class SeederModel implements Serializable {

	@Inject
	private IPersonService personService;

	@Inject
	private IBookService bookService;

	@Inject
	private IShoppingService shoppingService;

	String output = "hello";

	@PostConstruct
	public void init() {

		Address addr1 = new Address("Brunhuberstrasse", "Regensburg", 93053);
		Address addr2 = new Address("Langenkatzbach", "Gangekofen", 84140);

		BankDetail bank1 = new BankDetail("BYLADEM1DQE", "DE55772300000000000067"); //00000000067
		BankDetail bank2 = new BankDetail("BYLADEM1DQE", "DE71772300000000000070");	//00000000070

		AbstractBook pb1 = new PaperBook("Harry Potter und der Stein der Weisen",
				"fff-fff-fff1", new Date(), BigDecimal.valueOf(49.99), 15);

		AbstractBook pb2 = new PaperBook("Harry Potter und der Stein die Kammer des Schreckens",
				"fff-fff-fff1", new Date(), BigDecimal.valueOf(59.99), 15);

		AbstractBook fb = new PaperBook("Ulimativ Wizzard Knight Fight", "ababa-ababa",
				new Date(), BigDecimal.valueOf(99.99), 2);

		AbstractBook eb1 = new ElectronicBook("A Song of Ice and Fire A Game of Thrones", "ee-eee-333",
				new Date(), BigDecimal.valueOf(60.00), "12-34-45-3232");

		AbstractBook eb2 = new ElectronicBook("A Song of Ice and Fire A Clash of Kings", "ee-eee-334",
				new Date(), BigDecimal.valueOf(65.00), "12-34-45-3233");

		personService.createCustomer("Florian", "Fusseder", addr1, bank1);
		personService.createCustomer("Sonja", "Rietig", addr2, bank2);
		Author a = personService.createAuthor("Joanne K.", "Rowling", addr1);
		Author b = personService.createAuthor("George R. R.", "Martin", addr2);

		a = bookService.persistNewBook(pb1, a);
		a = bookService.persistNewBook(pb2, a);

		b = bookService.persistNewBook(eb1, b);
		b = bookService.persistNewBook(eb2, b);

		List<Author> alist = new ArrayList<Author>();
		alist.add(a);
		alist.add(b);

		alist = bookService.persistNewBook(fb, alist);
		a = alist.get(0);
		b = alist.get(1);

	}

}
