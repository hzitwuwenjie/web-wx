/**
 * Copyright 2017 bejson.com
 */
package com.web.entity;

import java.util.List;

/**
 * Auto-generated: 2017-08-11 9:46:36
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ImageAndTextMessage {

    private String ToUserName;
    private String FromUserName;
    private long CreateTime;
    private String MsgType;
    private int ArticleCount;
    private List<Item> Articles;
    public void setToUserName(String ToUserName) {
        this.ToUserName = ToUserName;
    }
    public String getToUserName() {
        return ToUserName;
    }

    public void setFromUserName(String FromUserName) {
        this.FromUserName = FromUserName;
    }
    public String getFromUserName() {
        return FromUserName;
    }

    public void setCreateTime(long CreateTime) {
        this.CreateTime = CreateTime;
    }
    public long getCreateTime() {
        return CreateTime;
    }

    public void setMsgType(String MsgType) {
        this.MsgType = MsgType;
    }
    public String getMsgType() {
        return MsgType;
    }

    public void setArticleCount(int ArticleCount) {
        this.ArticleCount = ArticleCount;
    }
    public int getArticleCount() {
        return ArticleCount;
    }

    public List<Item> getArticles() {
        return Articles;
    }

    public void setArticles(List<Item> articles) {
        Articles = articles;
    }
}