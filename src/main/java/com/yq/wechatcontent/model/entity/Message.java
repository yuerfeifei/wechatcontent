package com.yq.wechatcontent.model.entity;

import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Alias("message")
public class Message {
    private Integer msgid;

    private Integer msgsvrid;

    private Integer type;

    private Integer status;

    private Integer issend;

    private Integer isshowtimer;

    private LocalDateTime createtime;

    private String talker;

    private String content;

    private String imgpath;

    private String reserved;

    private String lvbuffer;

    private String transcontent;

    private String transbrandwording;

    private Integer talkerid;

    private String bizclientmsgid;

    private Integer bizchatid;

    private String bizchatuserid;

    private Integer msgseq;

    private Integer flag;

    private String solitairefoldinfo;

    public Integer getMsgid() {
        return msgid;
    }

    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
    }

    public Integer getMsgsvrid() {
        return msgsvrid;
    }

    public void setMsgsvrid(Integer msgsvrid) {
        this.msgsvrid = msgsvrid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIssend() {
        return issend;
    }

    public void setIssend(Integer issend) {
        this.issend = issend;
    }

    public Integer getIsshowtimer() {
        return isshowtimer;
    }

    public void setIsshowtimer(Integer isshowtimer) {
        this.isshowtimer = isshowtimer;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {

        this.createtime = new Date(createtime).toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
    }

    public String getTalker() {
        return talker;
    }

    public void setTalker(String talker) {
        this.talker = talker == null ? null : talker.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath == null ? null : imgpath.trim();
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved == null ? null : reserved.trim();
    }

    public String getLvbuffer() {
        return lvbuffer;
    }

    public void setLvbuffer(String lvbuffer) {
        this.lvbuffer = lvbuffer == null ? null : lvbuffer.trim();
    }

    public String getTranscontent() {
        return transcontent;
    }

    public void setTranscontent(String transcontent) {
        this.transcontent = transcontent == null ? null : transcontent.trim();
    }

    public String getTransbrandwording() {
        return transbrandwording;
    }

    public void setTransbrandwording(String transbrandwording) {
        this.transbrandwording = transbrandwording == null ? null : transbrandwording.trim();
    }

    public Integer getTalkerid() {
        return talkerid;
    }

    public void setTalkerid(Integer talkerid) {
        this.talkerid = talkerid;
    }

    public String getBizclientmsgid() {
        return bizclientmsgid;
    }

    public void setBizclientmsgid(String bizclientmsgid) {
        this.bizclientmsgid = bizclientmsgid == null ? null : bizclientmsgid.trim();
    }

    public Integer getBizchatid() {
        return bizchatid;
    }

    public void setBizchatid(Integer bizchatid) {
        this.bizchatid = bizchatid;
    }

    public String getBizchatuserid() {
        return bizchatuserid;
    }

    public void setBizchatuserid(String bizchatuserid) {
        this.bizchatuserid = bizchatuserid == null ? null : bizchatuserid.trim();
    }

    public Integer getMsgseq() {
        return msgseq;
    }

    public void setMsgseq(Integer msgseq) {
        this.msgseq = msgseq;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getSolitairefoldinfo() {
        return solitairefoldinfo;
    }

    public void setSolitairefoldinfo(String solitairefoldinfo) {
        this.solitairefoldinfo = solitairefoldinfo == null ? null : solitairefoldinfo.trim();
    }
}