package Entitys;

import Entitys.BankDetail;
import Entitys.Bill;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-15T23:21:03")
@StaticMetamodel(Customer.class)
public class Customer_ extends Person_ {

    public static volatile ListAttribute<Customer, Bill> bills;
    public static volatile SingularAttribute<Customer, BankDetail> bankDetail;

}