package Entitys;

import Entitys.AbstractBook;
import Technicals.Id.GeneratedIdEntity_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-04T03:22:09")
@StaticMetamodel(CartItem.class)
public class CartItem_ extends GeneratedIdEntity_ {

    public static volatile SingularAttribute<CartItem, Integer> count;
    public static volatile SingularAttribute<CartItem, AbstractBook> abstractBook;

}