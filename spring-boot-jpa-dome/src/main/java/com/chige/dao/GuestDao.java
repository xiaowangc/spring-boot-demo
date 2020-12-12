package com.chige.dao;

import com.chige.domain.Guest;
import com.chige.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;



@Repository
public class GuestDao {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> allGuests(){
        return guestRepository.findAll();
    }



}
