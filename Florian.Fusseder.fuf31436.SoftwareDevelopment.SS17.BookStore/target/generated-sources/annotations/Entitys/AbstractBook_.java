package Entitys;

import Entitys.Author;
import Technicals.Id.RandomIdEntity_;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-04T03:22:09")
@StaticMetamodel(AbstractBook.class)
public abstract class AbstractBook_ extends RandomIdEntity_ {

    public static volatile SingularAttribute<AbstractBook, Date> release;
    public static volatile ListAttribute<AbstractBook, Author> author;
    public static volatile SingularAttribute<AbstractBook, BigDecimal> price;
    public static volatile SingularAttribute<AbstractBook, String> isbn;
    public static volatile SingularAttribute<AbstractBook, String> name;

}