package Entitys;

import Entitys.Adress;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-15T00:33:02")
@StaticMetamodel(Person.class)
public abstract class Person_ extends SingleIdEntity_ {

    public static volatile SingularAttribute<Person, String> firstName;
    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile SingularAttribute<Person, Adress> adress;

}