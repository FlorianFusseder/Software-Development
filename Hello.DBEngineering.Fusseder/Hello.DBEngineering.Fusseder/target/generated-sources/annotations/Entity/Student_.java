package Entity;

import Entity.Professor;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-25T21:57:24")
@StaticMetamodel(Student.class)
public class Student_ extends Person_ {

    public static volatile SingularAttribute<Student, Professor> Erstpruefer;
    public static volatile SingularAttribute<Student, Professor> ZweitPruefer;

}