package com.yq.wechatcontent.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.WordDictionary;
import com.yq.wechatcontent.model.entity.Message;
import com.yq.wechatcontent.model.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.yq.wechatcontent.utils.Constant.*;
import static java.util.regex.Pattern.compile;

/**
 * @author yuerfeifei
 * @title: ContentService
 * @date 2020/10/15
 */
@Service
public class ContentService implements BaseService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public void countPrint() {
        //查询自己发送的条数
        long senderCount = messageMapper.getCountBySender(IS_SENDER, TALKER);

        //查询对方发送的条数
        long notSenderCount = messageMapper.getCountBySender(NOT_SENDER, TALKER);

        System.out.println("自己发送了"+senderCount+"条,"+"对方发送了"+notSenderCount+"条");

    }

    @Override
    public void keyWordRankingPrint() {
        //发送者排名
        LinkedHashMap<String, Integer> senderRank = getRank(IS_SENDER, TALKER);

        //接收者排名
        LinkedHashMap<String, Integer> receiverRank = getRank(NOT_SENDER, TALKER);

        String senderRankString = JSONArray.toJSONString(senderRank);

        String receiverRankString = JSONObject.toJSONString(receiverRank);
        System.out.println(senderRankString);
//        System.out.println(receiverRankString);
    }

    @Override
    public void hourRankingPrint() {
        List<Message> messageList = messageMapper.getAll(IS_SENDER, TALKER);
        Map<Integer, Integer> result = new HashMap<>();
        messageList.forEach(x -> {
            int hour = x.getCreatetime().getHour();
            if (result.containsKey(hour)) {
                Integer count = result.get(hour) + 1;
                result.put(hour, count);
            } else {
                result.put(hour, 1);
            }
        });
        LinkedHashMap<Integer, Integer> collect = result.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(collect);
    }

    private LinkedHashMap<String, Integer> getRank(int isSender, String talker) {
        List<Message> all = messageMapper.getAll(isSender, talker);
        StringBuilder sb = new StringBuilder();
        //把所有内容都放到一个字符串
        all.forEach(x -> {
            sb.append(x.getContent());
        });
        JiebaSegmenter segmenter = new JiebaSegmenter();
        WordDictionary.getInstance().init(Paths.get("src/main/resources"));
        List<String> list = segmenter.sentenceProcess(sb.toString());

        Map<String, Integer> result = new HashMap<>(1000);
        Pattern p = compile("[\u4e00-\u9fa5]");
        list.forEach(x -> {
            //过滤非汉字
            Matcher m = p.matcher(x);
            if (!m.find()) {
                return;
            }

            if (x.length() < 2) {
                return;
            }
            if (result.containsKey(x)) {
                Integer count = result.get(x) + 1;
                result.put(x, count);
            } else {
                result.put(x, 1);
            }
        });
        LinkedHashMap<String, Integer> collect = result.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return collect;
    }
}
