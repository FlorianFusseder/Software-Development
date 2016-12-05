package Entitys;

import Entitys.BankDetail;
import Entitys.ShoppingCart;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-04T03:22:09")
@StaticMetamodel(Customer.class)
public class Customer_ extends Person_ {

    public static volatile ListAttribute<Customer, ShoppingCart> payedShoppingCarts;
    public static volatile SingularAttribute<Customer, ShoppingCart> shoppingCart;
    public static volatile SingularAttribute<Customer, BankDetail> bankDetail;

}