/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.awt.print.Book;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Florian
 */
public class BookService
{

    @PersistenceContext(unitName = "BookStorePU")
    private EntityManager manager;

    @Transactional(Transactional.TxType.REQUIRED)
    public Book persistCustomer(Book b)
    {
        manager.persist(b);
        return b;
    }

}
