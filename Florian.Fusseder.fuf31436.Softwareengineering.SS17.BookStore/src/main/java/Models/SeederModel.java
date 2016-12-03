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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
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
@ManagedBean
@Getter
@Setter
@NoArgsConstructor
public class SeederModel implements Serializable {

	@Inject
	private PersonService personService;

	@Inject
	private BookService bookService;

	@Inject
	private ShoppingService shoppingService;

	private List<String> output;

	private void addToOutput(Object s) {
		this.output.add(s.toString());
	}

	@PostConstruct
	public void init() {

		this.output = new ArrayList<>();

		Adress addr = new Adress("MusterStrasse", "Musterstadt", 84140);
		this.addToOutput(addr);
		BankDetail bank = new BankDetail("55551", "55551");
		this.addToOutput(bank);
		AbstractBook pb = new PaperBook("Musterbuch", "ff-ff--fff", new Date(), BigDecimal.ONE, 14);
		this.addToOutput(pb);
		AbstractBook eb = new ElectronicBook("MusterEBook", "ee-eee-333",
				new Date(), new BigDecimal(150), "lichensetwo2");
		this.addToOutput(eb);

		Customer c1 = personService.createCustomer("Max", "MusterCustomer1", addr, bank);
		this.addToOutput(c1);
		Customer c2 = personService.createCustomer("Max", "MusterCustomer2", addr, bank);
		this.addToOutput(c2);
		Author a = personService.createAuthor("Max", "MusterAuthor", addr);
		this.addToOutput(a);
		Author b = personService.createAuthor("Max", "MusterAuthor2", addr);
		this.addToOutput(a);

		a = bookService.persistNewBook(eb, a);

		List<Author> alist = new ArrayList<Author>();
		alist.add(a);
		alist.add(b);

		alist = bookService.persistNewBook(pb, alist);
		a = alist.get(0);
		b = alist.get(1);

		this.addToOutput(a);
		this.addToOutput(b);

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
	}

}
