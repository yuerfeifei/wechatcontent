package com.yq.wechatcontent.service;

/**
 * @author yq
 * @title: ContentAnalyseBuilder
 * @date 2020/10/15
 */
public interface BaseService {


    /**
     * 统计对话次数
     * @return
     */
    void countPrint();

    /**
     * 筛选频率最高的关键字
     * @return
     */
    void keyWordRankingPrint();

    void hourRankingPrint();
}
