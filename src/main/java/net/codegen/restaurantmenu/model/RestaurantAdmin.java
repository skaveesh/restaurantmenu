package net.codegen.restaurantmenu.model;

import javax.persistence.*;

/**
 * Created by samintha on 3/14/2017.
 */

@Entity
@Table(name = "restaurant_admin")
public class RestaurantAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id")
    private int adminId;

    @Column(name = "firebase_user_uid")
    private String firebaseUserUid;

    private String email;

    @Column(name = "admin_fname")
    private String adminFname;

    @Column(name = "admin_lname")
    private String adminLname;

    @OneToOne
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    protected RestaurantAdmin(){}

    public RestaurantAdmin(String firebaseUserUid, String email, String adminFname, String adminLname, Restaurant restaurant) {
        this.firebaseUserUid = firebaseUserUid;
        this.email = email;
        this.adminFname = adminFname;
        this.adminLname = adminLname;
        this.restaurant = restaurant;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getFirebaseUserUid() {
        return firebaseUserUid;
    }

    public void setFirebaseUserUid(String firebaseUserUid) {
        this.firebaseUserUid = firebaseUserUid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdminFname() {
        return adminFname;
    }

    public void setAdminFname(String adminFname) {
        this.adminFname = adminFname;
    }

    public String getAdminLname() {
        return adminLname;
    }

    public void setAdminLname(String adminLname) {
        this.adminLname = adminLname;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
