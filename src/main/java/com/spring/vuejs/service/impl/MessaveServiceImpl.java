/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.spring.vuejs.service.impl;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.spring.vuejs.model.Message;
import com.spring.vuejs.service.MessageService;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Author : Quang Tran Dang
 * Email: quang.trandang@homedirect.com
 * 18/07/2017
 */

@Component
public class MessaveServiceImpl extends CommonService implements MessageService{

    private final static Logger LOGGER = Logger.getLogger(MessaveServiceImpl.class);

    @Override
    public List<Message> getMessage() {

        Gson gsonReceiver = new Gson();
        Type type = new TypeToken<List<Message>>(){}.getType();
        List<Message> messages = gsonReceiver.fromJson(new JSONObject(getMessageFromBind()).get("news").toString(),type);

        LOGGER.info(messages.size());
        return messages;
    }
}
