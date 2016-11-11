package Entitys;

import Entitys.Book;
import Entitys.Customer;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-11T22:29:27")
@StaticMetamodel(Bill.class)
 class Bill_ extends SingleIdEntity_ {

    public static volatile SingularAttribute<Bill, BigDecimal> total;
    public static volatile ListAttribute<Bill, Book> books;
    public static volatile SingularAttribute<Bill, Date> buyingDate;
    public static volatile SingularAttribute<Bill, Customer> customer;

}