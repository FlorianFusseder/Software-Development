/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Technicals.Repo.ShopingCartRepo;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Florian
 */
public class ShopingService {

    @Inject
    private ShopingCartRepo shopingRepo;

    public ShopingService() {
    }

    public ShopingCartRepo getShopingRepo() {
        return shopingRepo;
    }

    public void setShopingRepo(ShopingCartRepo shopingRepo) {
        this.shopingRepo = shopingRepo;
    }

}
