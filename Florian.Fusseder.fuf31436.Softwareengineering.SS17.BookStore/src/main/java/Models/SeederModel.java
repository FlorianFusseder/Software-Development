/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Annotations.AuthorAnnotation;
import Annotations.CustomerAnnotation;
import Entitys.AbstractBook;
import Entitys.Address;
import Entitys.Author;
import Entitys.BankDetail;
import Entitys.Customer;
import Entitys.ElectronicBook;
import Entitys.PaperBook;
import Services.Interfaces.IBookService;
import Services.Interfaces.IPersonService;
import Services.Interfaces.IShoppingService;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
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
	@CustomerAnnotation
	private IPersonService<Customer> customerService;

	@Inject
	@AuthorAnnotation
	private IPersonService<Author> authorService;

	@Inject
	private IBookService bookService;

	@Inject
	private IShoppingService shoppingService;

	String output = "hello";

	@PostConstruct
	public void init() {

		if (customerService.findAll().isEmpty()) {

			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

			Address addr1 = new Address("Musterstrasse", "Musterstadt", 84140);
			Address addr2 = new Address("Dummystrasse", "Dummystadt", 84140);

			BankDetail bank1 = new BankDetail("BYLADEM1DQE", "DE55772300000000000067");
			BankDetail bank2 = new BankDetail("BYLADEM1DQE", "DE71772300000000000070");

			AbstractBook javaFuerAnfaenger;
			AbstractBook datenbanken;
			AbstractBook hci;
			AbstractBook uml;

			AbstractBook grundkursJava;
			AbstractBook javaUML;

			try {
				javaFuerAnfaenger = new PaperBook(
						"Java-Programmierung für Anfänger: Programmieren lernen ohne Vorkenntnisse",
						"978-1517358389",
						sdf.parse("20.05.2016"),
						BigDecimal.valueOf(29.99),
						100);

				datenbanken = new PaperBook(
						"Datenbanken & SQL für Einsteiger: Datenbankdesign und MySQL in der Praxis", 
						"978-1492951049", 
						sdf.parse("09.10.2013"),
						BigDecimal.valueOf(24.90), 
						39);
				
				
				hci = new PaperBook(
						"Designing Interactive Systems: A comprehensive Guide to HCI and interaction design", 
						"978-0321435330", 
						sdf.parse("01.04.2010"),
						BigDecimal.valueOf(64.15), 
						4);
				
				uml = new PaperBook(
						"UML 2.5: Das umfassende Handbuch", 
						"978-3836229777", 
						sdf.parse("23.02.2015"),
						BigDecimal.valueOf(34.90), 
						67);
				
				grundkursJava = new ElectronicBook(
						"Grundkurs JAVA: Von den Grundlagen bis zu Datenbank- und Netzanwendungen", 
						"978-3658138066", 
						sdf.parse("20.05.2016"),
						BigDecimal.valueOf(60.00), 
						"B01JGQNCB2");
				
				javaUML = new ElectronicBook(
						"Einführung in die Programmierung: Grundlagen, Java, UML", 
						"978-3540328551", 
						sdf.parse("20.04.2006"),
						BigDecimal.valueOf(16.99), 
						"B00TSOZ7QG");



			Customer c1 = new Customer("Florian", "Fusseder", addr1, bank1);
			Customer c2 = new Customer("Sonja", "Riethig", addr2, bank2);

			customerService.create(c1);
			customerService.create(c2);

			Author AuthorJavaFuerAnfaenger =	new Author("Daniel", "Loring", addr1);
			Author AuthorDatenbanken =			new Author("Marco", "Emeric", addr1);
			Author AuthorHCI =					new Author("David", "Benyon", addr1);
			Author AuthorUML1 =					new Author("Christoph", "Kecher", addr1);
			Author AuthorUML2 =					new Author("Alexander", "Salvanos", addr1);
			Author AuthorGrundkursJava =		new Author("Dietmar", "Abts", addr1);
			Author AuthorJavaUML =				new Author("Robert", "Braun", addr1);
			
			
			authorService.create(AuthorJavaFuerAnfaenger);
			authorService.create(AuthorDatenbanken);
			authorService.create(AuthorHCI);
			authorService.create(AuthorUML1);
			authorService.create(AuthorUML2);
			authorService.create(AuthorGrundkursJava);
			authorService.create(AuthorJavaUML);

			
			bookService.persistNewBook(javaFuerAnfaenger, AuthorJavaFuerAnfaenger);
			bookService.persistNewBook(datenbanken, AuthorDatenbanken);
			bookService.persistNewBook(hci, AuthorHCI);
			bookService.persistNewBook(uml, Arrays.asList(AuthorUML1, AuthorUML2));
			bookService.persistNewBook(grundkursJava, AuthorGrundkursJava);
			bookService.persistNewBook(javaUML, Arrays.asList(AuthorJavaUML, AuthorUML1, AuthorJavaFuerAnfaenger));

			
			} catch (Exception ex) {
				Logger.getLogger(SeederModel.class.getName()).log(Level.SEVERE, null, ex);
			}

		}

	}

}
