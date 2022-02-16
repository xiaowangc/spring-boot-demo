package com.chige.es.domain;

import lombok.Data;


@Data
public class ESAccountDO {

    /**
     * ID 主键
     */
    private Integer id;

    private Long accountNumber;
    /**
     *  地址
     */
    private String address;
    /**
     *  金额
     */
    private Long balance;
    /**
     * 姓氏
     */
    private String firstName;

    /**
     * 名字
     */
    private String lastName;

    private Long age;

    private String city;

    private String email;
    /**
     *  雇用者
     */
    private String employer;

    private String state;

    private String gender;


}
