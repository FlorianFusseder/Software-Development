/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitys.AbstractBook;
import Entitys.Author;
import Entitys.BankDetail;
import Entitys.Bill;
import Entitys.Customer;
import Entitys.ElectronicBook;
import Entitys.PBookData;
import Entitys.PaperBook;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Florian
 */
public class PersonService
{

    @PersistenceContext(unitName = "BookStorePU")
    private EntityManager manager;

    @Transactional(Transactional.TxType.REQUIRED)
    public Customer persistCustomer(Customer c)
    {
        manager.persist(c);
        return c;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public BankDetail persistBankDetails(BankDetail d)
    {
        manager.persist(d);
        return d;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Customer persistCustomer(Customer c, BankDetail d)
    {
        manager.persist(d);
        c = manager.merge(c);
        c.setBankDetail(d);
        return c;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Author persistAuthor(Author a)
    {
        manager.persist(a);
        return a;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public PaperBook persistBook(PaperBook pb)
    {
        for (PBookData temp : pb.getCopies())
        {
            manager.persist(temp);
        }

        manager.persist(pb);
        return pb;
    }

    public PaperBook find(PaperBook p)
    {
        return manager.find(PaperBook.class, p.getId());
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void persistBill(Customer c, PaperBook lb)
    {
        c = manager.merge(c);
        lb = manager.merge(lb);
        Author a = null;
        
        for (Author author : lb.getAuthor())
        {
            a = manager.merge(author);
            a.increaseSold(1);
        }

        ArrayList<AbstractBook> l = new ArrayList<>();
        l.add(lb);

        
        Bill b = new Bill(c, l);

        c.addBill(b);

        manager.persist(b);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void persistNewBook(Author a, PaperBook pb)
    {
        a = manager.merge(a);
        pb = manager.merge(pb);
        
        a.addBook(pb);
        return;
    }

}
