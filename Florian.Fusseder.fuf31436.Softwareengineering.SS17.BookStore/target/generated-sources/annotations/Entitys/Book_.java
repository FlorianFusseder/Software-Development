package Entitys;

import Entitys.Author;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-10T22:45:54")
@StaticMetamodel(Book.class)
abstract class Book_ extends SingleIdEntity_ {

    public static volatile SingularAttribute<Book, Date> release;
    public static volatile ListAttribute<Book, Author> author;
    public static volatile SingularAttribute<Book, BigDecimal> price;
    public static volatile SingularAttribute<Book, String> isbn;
    public static volatile SingularAttribute<Book, String> name;

}