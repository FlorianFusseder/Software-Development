package Entitys;

import Entitys.Adress;
import Technicals.Id.GeneratedIdEntity_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-04T03:22:09")
@StaticMetamodel(Person.class)
public abstract class Person_ extends GeneratedIdEntity_ {

    public static volatile SingularAttribute<Person, String> firstName;
    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile SingularAttribute<Person, Adress> adress;

}