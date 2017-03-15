package net.codegen.restaurantmenu.core;

import java.io.Serializable;

/**
 * Created by samintha on 3/15/2017.
 */
public class MenuitemPK implements Serializable {

    private Integer restaurantId;
    private String itemNo;

    public MenuitemPK(){}

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MenuitemPK){
            MenuitemPK menuitemPK = (MenuitemPK) obj;

            if(menuitemPK.getRetaurantId() != (restaurantId)){
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

    public int getRetaurantId() {
        return restaurantId;
    }

    public void setRetaurantId(int retaurantId) {
        this.restaurantId = retaurantId;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }
}
