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
    public void persistBill(Customer c, AbstractBook abstractBook)
    {

        if (abstractBook.getClass() == PaperBook.class)
        {
            this.persistBill(c, (PaperBook) abstractBook);
        } else
        {
            this.persistBill(c, (ElectronicBook) abstractBook);
        }
    }

    @Transactional(Transactional.TxType.REQUIRED)
    private void persistBill(Customer c, ElectronicBook eb)
    {
        c = manager.merge(c);
        eb = manager.merge(eb);

        ArrayList<AbstractBook> l = new ArrayList<>();
        l.add(eb);

        Bill b = new Bill(c, l);

        c.addBill(b);

        manager.persist(b);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    private void persistBill(Customer c, PaperBook eb)
    {
        c = manager.merge(c);
        eb = manager.merge(eb);

        ArrayList<AbstractBook> l = new ArrayList<>();
        l.add(eb);

        Bill b = new Bill(c, l);

        c.addBill(b);
        manager.persist(b);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void persistBill(Customer c, List<AbstractBook> l)
    {
        c = manager.merge(c);
        ArrayList<AbstractBook> mlist = new ArrayList<>();
        
        for (AbstractBook abstractBook : l)
        {
            mlist.add(manager.merge(abstractBook));
        }
        
        Bill b = new Bill(c, mlist);
        c.addBill(b);
        manager.persist(b);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void persistNewBook(Author a, AbstractBook b)
    {
        if (b.getClass() == PaperBook.class)
        {
            this.persistBook((PaperBook) b);
        } else
        {
            this.persistBook((ElectronicBook) b);
        }

        b = manager.merge(b);
        a = manager.merge(a);

        a.addBook(b);
        b.addAuthor(a);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void persistNewBook(Author a, List<AbstractBook> books)
    {
        for (AbstractBook b : books)
        {
            this.persistNewBook(a, b);
        }
    }

    @Transactional(Transactional.TxType.REQUIRED)
    private PaperBook persistBook(PaperBook pb)
    {
        for (PBookData temp : pb.getCopies())
        {
            manager.persist(temp);
        }

        manager.persist(pb);
        return pb;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    private ElectronicBook persistBook(ElectronicBook eb)
    {
        manager.persist(eb);
        return eb;
    }

}
