package com.yq.wechatcontent.service;

/**
 * @author yq
 * @title: ContentAnalyseBuilder
 * @date 2020/10/15
 */
public abstract class BaseService {


    /**
     * 统计对话次数
     * @return
     */
    abstract void countBuilder();

    /**
     * 筛选频率最高的关键字
     * @return
     */
    abstract void keyWordRankingBuilder();
}
