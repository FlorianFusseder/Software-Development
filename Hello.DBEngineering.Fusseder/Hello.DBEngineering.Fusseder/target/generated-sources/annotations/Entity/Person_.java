package Entity;

import Entity.Adresse;
import Entity.Email;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-25T21:57:24")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, Adresse> Adresse;
    public static volatile SingularAttribute<Person, String> NachName;
    public static volatile SingularAttribute<Person, Email> EmailAdresse;
    public static volatile SingularAttribute<Person, String> VorName;
    public static volatile SingularAttribute<Person, Long> Id;

}