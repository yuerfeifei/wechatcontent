package com.yq.wechatcontent;

import com.yq.wechatcontent.service.ResultPrintService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = {"com.yq.wechatcontent.*"})
public class WechatcontentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(WechatcontentApplication.class, args);
        ResultPrintService resultPrint = (ResultPrintService) run.getBean("resultPrintService");
        resultPrint.resultPrint();
    }

}
