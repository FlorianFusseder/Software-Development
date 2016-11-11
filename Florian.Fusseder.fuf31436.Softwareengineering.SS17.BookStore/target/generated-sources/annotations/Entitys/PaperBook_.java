package Entitys;

import Entitys.Book;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-11T22:29:27")
@StaticMetamodel(PaperBook.class)
public class PaperBook_ extends Book_ {

    public static volatile ListAttribute<PaperBook, Book> copies;
    public static volatile SingularAttribute<PaperBook, String> location;

}