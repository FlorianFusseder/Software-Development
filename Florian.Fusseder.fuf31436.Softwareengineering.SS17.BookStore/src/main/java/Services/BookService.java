/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitys.AbstractBook;
import Technicals.SingleIdEntityRepository;
import javax.transaction.Transactional;

/**
 *
 * @author Florian
 */
@Transactional(Transactional.TxType.REQUIRED)
public class BookService extends  SingleIdEntityRepository<String, AbstractBook>
{

    public BookService(Class<AbstractBook> type)
    {
        super(type);
    }

}
