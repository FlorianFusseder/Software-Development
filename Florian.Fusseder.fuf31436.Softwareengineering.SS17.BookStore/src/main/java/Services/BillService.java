/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Technicals.Repo.BillRepo;
import javax.inject.Inject;

/**
 *
 * @author Florian
 */
public class BillService {

    @Inject
    private BillRepo billRepo;

    public BillService() {
    }

}
