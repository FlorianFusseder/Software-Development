package Entitys;

import Entitys.Adress;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-11T22:29:27")
@StaticMetamodel(Person.class)
public abstract class Person_ extends SingleIdEntity_ {

    public static volatile SingularAttribute<Person, String> name;
    public static volatile SingularAttribute<Person, Adress> adress;

}