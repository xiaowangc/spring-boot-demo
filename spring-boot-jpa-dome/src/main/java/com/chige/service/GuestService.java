package com.chige.service;


import com.chige.domain.Guest;

import java.util.List;


public interface GuestService {

    /**
     *  获取所有嘉宾信息
     * @return
     */

    List<Guest> allGuests();


}
