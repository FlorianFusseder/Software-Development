package Entitys;

import Entitys.AbstractBook;
import Entitys.Customer;
import Technicals.GeneratedIdEntity_;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-15T23:21:03")
@StaticMetamodel(Bill.class)
public class Bill_ extends GeneratedIdEntity_ {

    public static volatile SingularAttribute<Bill, BigDecimal> total;
    public static volatile ListAttribute<Bill, AbstractBook> books;
    public static volatile SingularAttribute<Bill, Date> buyingDate;
    public static volatile SingularAttribute<Bill, Customer> customer;

}