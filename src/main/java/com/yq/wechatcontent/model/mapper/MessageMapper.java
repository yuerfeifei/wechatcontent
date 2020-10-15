package com.yq.wechatcontent.model.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * message表对应mapper
 * @author yuerfeifei
 */
@Repository
public interface MessageMapper extends BaseMapper {


    /**
     * 查询发送者对应对话内发送的条数
     * @param isSender 是否为发送者
     * @param talker 对话目标
     * @return
     */
    long getCountBySender(@Param("isSender") int isSender,@Param("talker") String talker);
}