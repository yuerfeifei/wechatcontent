package com.yq.wechatcontent;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//@SpringBootTest
class WechatcontentApplicationTests {

    @Test
    void contextLoads() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime localDateTime = LocalDateTime.parse("1602568913000");
        LocalDateTime dateTime = new Date(1602568913000L).toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
        System.out.println(formatter.format(dateTime));
    }

}
