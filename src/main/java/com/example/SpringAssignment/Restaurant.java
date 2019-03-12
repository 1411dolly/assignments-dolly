package com.example.SpringAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;


public class Restaurant {

    @Autowired
    HotDrink hotDrink;

    public Restaurant(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }

    public HotDrink getHotDrink() {
        return hotDrink;
    }

    //Q8...Use @Required annotation for hotDrink setter method in Restaurant class.
    @Required
    public void setHotDrink(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }

    public Restaurant() {
    }
}
