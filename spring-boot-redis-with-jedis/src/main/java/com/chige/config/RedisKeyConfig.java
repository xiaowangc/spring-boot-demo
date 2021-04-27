package com.chige.config;


public interface RedisKeyConfig {

    String RANDOM_PACKET_LIST = "redpacket:";
    String ID_KEY = "id:generator:redpackey:";
    String RED_PACKET_CONSUME_KEY = "redpacket:consume:";
}
