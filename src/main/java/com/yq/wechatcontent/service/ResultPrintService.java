package com.yq.wechatcontent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yuerfeifei
 * @title: ResultPrint
 * @date 2020/10/15
 */
@Component
public class ResultPrintService {
    @Autowired
    private ContentService contentService;

    public void resultPrint(){
//        contentService.countPrint();
        contentService.keyWordRankingPrint();
    }
}
