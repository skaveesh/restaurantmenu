package net.codegen.restaurantmenu.core;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by samintha on 3/15/2017.
 */

@Embeddable
public class MenuitemPK implements Serializable {

    @Column(name = "restaurant_id")
    private Integer restaurantId;

    @Column(name = "item_no")
    private String itemNo;

    public MenuitemPK(){}

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MenuitemPK){
            MenuitemPK menuitemPK = (MenuitemPK) obj;

            if(!menuitemPK.getRestaurantId().equals(restaurantId)){
                return false;
            }

            if(!menuitemPK.getItemNo().equals(itemNo)){
                return false;
            }

            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return restaurantId.hashCode() + itemNo.hashCode();
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
}
