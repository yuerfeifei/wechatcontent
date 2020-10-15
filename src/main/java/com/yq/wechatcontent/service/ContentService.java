package com.yq.wechatcontent.service;

import com.yq.wechatcontent.model.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.yq.wechatcontent.utils.Constant.*;

/**
 * @author yq
 * @title: ContentHandleBuilder
 * @date 2020/10/15
 */
@Service
public class ContentService extends BaseService{

    @Autowired
    private MessageMapper messageMapper;

    @Override
    void countBuilder() {
        //查询自己发送的条数
        long senderCount = messageMapper.getCountBySender(IS_SENDER, TALKER);

        //查询对方发送的条数
        long notSenderCount = messageMapper.getCountBySender(NOT_SENDER, TALKER);

        System.out.println("自己发送了"+senderCount+"条,"+"对方发送了"+notSenderCount+"条");

    }

    @Override
    void keyWordRankingBuilder() {
    }
}
