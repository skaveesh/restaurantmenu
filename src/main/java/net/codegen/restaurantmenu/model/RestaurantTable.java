package net.codegen.restaurantmenu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by samintha on 3/16/2017.
 */

@Entity
@Table(name = "restaurant_table")
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "table_id")
    private int tableId;

    @Column(name = "table_name")
    private String tableName;

    private String location;

    @Column(name = "number_of_person_for_the_table")
    private String numberOfPersonForTheTable;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurantTable", cascade = CascadeType.ALL)
    private List<Orders> ordersList;


    protected RestaurantTable(){}

    public RestaurantTable(String tableName, String location, String numberOfPersonForTheTable, Restaurant restaurant) {
        this.tableName = tableName;
        this.location = location;
        this.numberOfPersonForTheTable = numberOfPersonForTheTable;
        this.restaurant = restaurant;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNumberOfPersonForTheTable() {
        return numberOfPersonForTheTable;
    }

    public void setNumberOfPersonForTheTable(String numberOfPersonForTheTable) {
        this.numberOfPersonForTheTable = numberOfPersonForTheTable;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
