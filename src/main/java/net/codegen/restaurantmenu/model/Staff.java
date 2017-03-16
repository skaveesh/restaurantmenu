package net.codegen.restaurantmenu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by samintha on 3/16/2017.
 */

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "staff_id")
    private int staffId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(name = "username",unique = true)
    private String username;

    @JsonIgnore
    private String password;

    private String fname;

    private String lname;

    @Column(name = "emp_id")
    private String empId;

    @Column(name = "profile_pic_img_url")
    private String profilePicImgUrl;

    @Column(name = "is_waiter")
    private boolean isWaiter;

    @Column(name = "suspend_status")
    private boolean suspendStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private List<Orders> ordersList;

    protected Staff(){}

    public Staff(Restaurant restaurant, String username, String password, String fname, String lname, String empId, String profilePicImgUrl, boolean isWaiter, boolean suspendStatus) {
        this.restaurant = restaurant;
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.empId = empId;
        this.profilePicImgUrl = profilePicImgUrl;
        this.isWaiter = isWaiter;
        this.suspendStatus = suspendStatus;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getProfilePicImgUrl() {
        return profilePicImgUrl;
    }

    public void setProfilePicImgUrl(String profilePicImgUrl) {
        this.profilePicImgUrl = profilePicImgUrl;
    }

    public boolean isWaiter() {
        return isWaiter;
    }

    public void setWaiter(boolean waiter) {
        isWaiter = waiter;
    }

    public boolean isSuspendStatus() {
        return suspendStatus;
    }

    public void setSuspendStatus(boolean suspendStatus) {
        this.suspendStatus = suspendStatus;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
