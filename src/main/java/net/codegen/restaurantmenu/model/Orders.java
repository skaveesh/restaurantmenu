package net.codegen.restaurantmenu.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.omg.CORBA.ServerRequest;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by samintha on 3/16/2017.
 */

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int orderId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private RestaurantTable restaurantTable;

    @ManyToOne
    @JoinColumn(name = "waiter_id", referencedColumnName = "staff_id")
    private Staff staff;

    private String token;

    @Column(name = "discount_details")
    private String discountDetails;

    @Column(name = "discount_percentage")
    private double discountPercentage;

    @Column(name = "other_details")
    private String otherDetails;

    private BigDecimal total;

    private boolean paid;

    @Column(name = "active_status")
    private boolean activeStatus;

    @Column(name = "timestamp_of_order")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Timestamp timestampOfOrder;

    protected Orders(){}

    public Orders(Restaurant restaurant, RestaurantTable restaurantTable, Staff staff, String token, String discountDetails, double discountPercentage, String otherDetails, BigDecimal total, boolean paid, boolean activeStatus) {
        this.restaurant = restaurant;
        this.restaurantTable = restaurantTable;
        this.staff = staff;
        this.token = token;
        this.discountDetails = discountDetails;
        this.discountPercentage = discountPercentage;
        this.otherDetails = otherDetails;
        this.total = total;
        this.paid = paid;
        this.activeStatus = activeStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public RestaurantTable getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDiscountDetails() {
        return discountDetails;
    }

    public void setDiscountDetails(String discountDetails) {
        this.discountDetails = discountDetails;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Timestamp getTimestampOfOrder() {
        return timestampOfOrder;
    }

    public void setTimestampOfOrder(Timestamp timestampOfOrder) {
        this.timestampOfOrder = timestampOfOrder;
    }
}
