package com.chige.service;


import com.chige.domain.Guest;

import java.util.List;


public interface GuestService {

 /**
  *  获取所有嘉宾信息
  * @return
  */
 List<Guest> allGuests();

 /**
  * 增加嘉宾  返回值为：成功或失败
  * @param guest
  * @return
  */
 boolean addOne(Guest guest);

 /**
  * 根据姓名删除嘉宾
  * @param name
  * @return
  */
 boolean deleteOne(String name);

 /**
  * 更新某一位嘉宾的角色
  * @param guest
  * @return
  */
 boolean updateOne(Guest guest);

 Guest selectOne(String name);
}
