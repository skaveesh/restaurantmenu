package net.codegen.restaurantmenu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.codegen.restaurantmenu.core.MenuitemPK;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

/**
 * Created by samintha on 3/14/2017.
 */

@Entity
@Table(name = "menuitem")
@IdClass(value = MenuitemPK.class)
public class Menuitem {

    @Id
    @Column(name = "restaurant_id")
    private Integer restaurantId;

    @Id
    @Column(name = "item_no")
    private String itemNo;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_desc")
    private String itemDesc;

    @Column(name = "item_price")
    private Double itemPrice;

    @Column(name = "item_tax")
    private Double itemTax;

    @Column(name = "item_ingredients")
    private String itemIngredients;

    @Column(name = "item_img_url")
    private String itemImgUrl;

    @Column(name = "no_of_diners")
    private int noOfDiners;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "filter_id")
    private Filter filter;

    private int vegetarian;

    private int availability;

    protected Menuitem(){}

    public Menuitem(Integer restaurantId, String itemNo, String itemName, String itemDesc, Double itemPrice, Double itemTax, String itemIngredients, String itemImgUrl, int noOfDiners, Category category, Filter filter, int vegetarian, int availability) {
        this.restaurantId = restaurantId;
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemPrice = itemPrice;
        this.itemTax = itemTax;
        this.itemIngredients = itemIngredients;
        this.itemImgUrl = itemImgUrl;
        this.noOfDiners = noOfDiners;
        this.category = category;
        this.filter = filter;
        this.vegetarian = vegetarian;
        this.availability = availability;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Double getItemTax() {
        return itemTax;
    }

    public void setItemTax(Double itemTax) {
        this.itemTax = itemTax;
    }

    public String getItemIngredients() {
        return itemIngredients;
    }

    public void setItemIngredients(String itemIngredients) {
        this.itemIngredients = itemIngredients;
    }

    public String getItemImgUrl() {
        return itemImgUrl;
    }

    public void setItemImgUrl(String itemImgUrl) {
        this.itemImgUrl = itemImgUrl;
    }

    public int getNoOfDiners() {
        return noOfDiners;
    }

    public void setNoOfDiners(int noOfDiners) {
        this.noOfDiners = noOfDiners;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public int getVegitarian() {
        return vegetarian;
    }

    public void setVegitarian(int vegitarian) {
        this.vegetarian = vegitarian;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
}
