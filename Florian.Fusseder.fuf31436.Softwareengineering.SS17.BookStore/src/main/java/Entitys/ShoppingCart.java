/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import Technicals.Id.GeneratedIdEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Florian
 */
@Entity
public class ShoppingCart extends GeneratedIdEntity {

    @ManyToMany
    private List<CartItem> shoppingList;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    private BigDecimal total;

    public ShoppingCart() {
        this.shoppingList = new ArrayList<>();
        this.creationDate = new Date();
        this.total = BigDecimal.ZERO;
    }

    @PreUpdate
    @PrePersist
    private void Load() {
        this.total = shoppingList.stream()
				.map((cartItem) -> cartItem.getAbstractBook().getPrice())
				.reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<CartItem> getShoppingList() {
        return Collections.unmodifiableList(shoppingList);
    }

    public void addToShoppingList(CartItem cartItem) {
        this.shoppingList.add(cartItem);
    }

    public void addToShoppingList(List<CartItem> cartItems) {
        this.shoppingList.addAll(cartItems);
    }

    public void clearShoppingCart() {
        this.shoppingList.clear();
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
