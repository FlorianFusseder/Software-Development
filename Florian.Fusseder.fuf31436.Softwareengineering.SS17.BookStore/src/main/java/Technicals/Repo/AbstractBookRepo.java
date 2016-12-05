/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technicals.Repo;

import Entitys.AbstractBook;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Florian
 */
@RequestScoped
public class AbstractBookRepo extends SingleEntityRepository<String, AbstractBook>
implements Serializable {

    public AbstractBookRepo() {
        super(AbstractBook.class);
    }
}
