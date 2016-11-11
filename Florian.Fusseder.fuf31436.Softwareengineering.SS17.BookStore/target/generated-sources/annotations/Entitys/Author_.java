package Entitys;

import Entitys.Book;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-11T22:29:27")
@StaticMetamodel(Author.class)
public class Author_ extends Person_ {

    public static volatile SingularAttribute<Author, String> sold;
    public static volatile ListAttribute<Author, Book> books;

}