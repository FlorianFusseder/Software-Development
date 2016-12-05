package Entitys;

import Entitys.CartItem;
import Technicals.Id.GeneratedIdEntity_;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-04T03:22:09")
@StaticMetamodel(ShoppingCart.class)
public class ShoppingCart_ extends GeneratedIdEntity_ {

    public static volatile SingularAttribute<ShoppingCart, BigDecimal> total;
    public static volatile ListAttribute<ShoppingCart, CartItem> shoppingList;
    public static volatile SingularAttribute<ShoppingCart, Date> creationDate;

}