package com.chige.redistemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{

    public static final long serialVersionUID = -3083861014351415989L;

    public String userName;
    public String phone;

    private Integer userId;
}
