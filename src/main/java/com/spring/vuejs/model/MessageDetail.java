/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.spring.vuejs.model;

import java.util.Date;

/**
 * Author : Quang Tran Dang
 * Email: quang.trandang@homedirect.com
 * 18/07/2017
 */


public class MessageDetail {

    private Date Date;

    private String title;

    private String content;

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
