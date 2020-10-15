package com.yq.wechatcontent;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.WordDictionary;
import org.junit.jupiter.api.Test;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.file.Paths;

//@SpringBootTest
class WechatcontentApplicationTests {

    @Test
    void contextLoads() {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        String sentences = "北京京天威科技发展有限公司大庆车务段的装车数量";
        WordDictionary.getInstance().loadUserDict(Paths.get("src/main/resources/my.dict"), Charset.forName("utf-8"));
        System.out.println(segmenter.sentenceProcess(sentences));

        StringBuilder result = new StringBuilder();
        IKSegmenter ik = new IKSegmenter(new StringReader(sentences), false);
        try {
            Lexeme word = null;
            while ((word = ik.next()) != null) {
                result.append(word.getLexemeText()).append(" ");
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println(result.toString());
    }

}
