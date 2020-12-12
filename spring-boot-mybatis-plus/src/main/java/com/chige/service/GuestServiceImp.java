package com.chige.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chige.mapper1.GuestMapper;
import com.chige.domain.Guest;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImp extends ServiceImpl<GuestMapper,Guest> implements GuestService{

}
