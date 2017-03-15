package net.codegen.restaurantmenu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by samintha on 3/14/2017.
 */

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurant_id")
    private int restaurantId;

    @Column(name = "restaurant_uname")
    private String restaurantUname;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "email_for_cust")
    private String emailForCust;

    @Column(name = "email_sender_name")
    private String emailSenderName;

    @Column(name = "contact_to_display_1")
    private String contactToDisplay1;

    @Column(name = "contact_to_display_2")
    private String contactToDisplay2;

    private String address;

    private String country;

    @Column(name = "rating_number")
    private int ratingNumber;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "open_hours")
    private String openHours;

    private String description;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "disabled_status")
    private int disabledStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Filter> filterList;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Category> categoryList;


    protected Restaurant() {
    }

    public Restaurant(String restaurantUname, String restaurantName, String emailForCust, String emailSenderName, String contactToDisplay1, String contactToDisplay2, String address, String country, int ratingNumber, String imgUrl, String openHours, String description) {
        this.restaurantUname = restaurantUname;
        this.restaurantName = restaurantName;
        this.emailForCust = emailForCust;
        this.emailSenderName = emailSenderName;
        this.contactToDisplay1 = contactToDisplay1;
        this.contactToDisplay2 = contactToDisplay2;
        this.address = address;
        this.country = country;
        this.ratingNumber = ratingNumber;
        this.imgUrl = imgUrl;
        this.openHours = openHours;
        this.description = description;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantUname() {
        return restaurantUname;
    }

    public void setRestaurantUname(String restaurantUname) {
        this.restaurantUname = restaurantUname;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getEmailForCust() {
        return emailForCust;
    }

    public void setEmailForCust(String emailForCust) {
        this.emailForCust = emailForCust;
    }

    public String getEmailSenderName() {
        return emailSenderName;
    }

    public void setEmailSenderName(String emailSenderName) {
        this.emailSenderName = emailSenderName;
    }

    public String getContactToDisplay1() {
        return contactToDisplay1;
    }

    public void setContactToDisplay1(String contactToDisplay1) {
        this.contactToDisplay1 = contactToDisplay1;
    }

    public String getContactToDisplay2() {
        return contactToDisplay2;
    }

    public void setContactToDisplay2(String contactToDisplay2) {
        this.contactToDisplay2 = contactToDisplay2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getRatingNumber() {
        return ratingNumber;
    }

    public void setRatingNumber(int ratingNumber) {
        this.ratingNumber = ratingNumber;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDisabledStatus() {
        return disabledStatus;
    }

    public void setDisabledStatus(int disabledStatus) {
        this.disabledStatus = disabledStatus;
    }

    public List<Filter> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<Filter> filterList) {
        this.filterList = filterList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
