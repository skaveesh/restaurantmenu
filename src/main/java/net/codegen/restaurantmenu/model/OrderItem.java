package net.codegen.restaurantmenu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

/**
 * Created by samintha on 3/17/2017.
 */

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_item_id")
    private int orderItemId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @JoinColumns(value = {
            @JoinColumn(name = "restaurant_id",referencedColumnName = "restaurant_id"),
            @JoinColumn(name = "item_no", referencedColumnName = "item_no")})
    @ManyToOne()
    private Menuitem menuitem;

    private int quantity;

    @Column(name = "order_turn")
    private int orderTurn;

    protected OrderItem() {
    }

    public OrderItem(Orders orders, Menuitem menuitem, int quantity, int orderTurn) {
        this.orders = orders;
        this.menuitem = menuitem;
        this.quantity = quantity;
        this.orderTurn = orderTurn;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Menuitem getMenuitem() {
        return menuitem;
    }

    public void setMenuitem(Menuitem menuitem) {
        this.menuitem = menuitem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderTurn() {
        return orderTurn;
    }

    public void setOrderTurn(int orderTurn) {
        this.orderTurn = orderTurn;
    }
}
