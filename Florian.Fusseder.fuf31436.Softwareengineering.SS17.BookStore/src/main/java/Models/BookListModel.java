/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entitys.AbstractBook;
import Services.Interfaces.IBookService;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Florian
 */
@Named
@RequestScoped
@NoArgsConstructor
public class BookListModel {

	@Inject
	private Logger logger;

	@Inject
	private IBookService bookService;

	@Setter
	@Getter
	private List<AbstractBook> bookList;

	@Getter
	@Setter
	private String searchTerm;

	@PostConstruct
	public void init() {
		logger.info("init ShoppingSiteModel");
		searchTerm = "";
		this.bookList = this.bookService.findAll();
	}

	public void searchFor() {
		logger.info("searchFor ShoppingSiteModel");
		if (!this.searchTerm.isEmpty()) {
			this.bookList = this.bookService.searchBooks(this.searchTerm);
		} else {
			this.bookList = this.bookService.findAll();
		}
	}

}
