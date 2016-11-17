/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technicals.Repo;

import Entitys.AbstractBook;

/**
 *
 * @author Florian
 */
public class AbstractBookRepo extends SingleEntityRepository<String, AbstractBook> {

    public AbstractBookRepo() {
        super(AbstractBook.class);
    }

}
