/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.spring.vuejs.model;

import java.util.List;

/**
 * Author : Quang Tran Dang
 * Email: quang.trandang@homedirect.com
 * 18/07/2017
 */


public class Message {

    private String title;

    private List<MessageDetail> list;

    public String getTitleCommon() {
        return title;
    }

    public void setTitleCommon(String title) {
        this.title = title;
    }

    public List<MessageDetail> getList() {
        return list;
    }

    public void setList(List<MessageDetail> list) {
        this.list = list;
    }
}
