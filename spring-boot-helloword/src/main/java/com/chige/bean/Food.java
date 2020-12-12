package com.chige.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Food {

    private String rice;
    private String meat;
    public Food(){}
    public Food(String rice,String meat){
        this.rice = rice;
        this.meat = meat;
    }


}
