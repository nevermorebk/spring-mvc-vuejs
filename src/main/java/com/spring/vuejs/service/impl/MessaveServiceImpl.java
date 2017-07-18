/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.spring.vuejs.service.impl;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.spring.vuejs.model.Message;
import com.spring.vuejs.model.MessageDetail;
import com.spring.vuejs.service.MessageService;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Author : Quang Tran Dang
 * Email: quang.trandang@homedirect.com
 * 18/07/2017
 */

@Component
public class MessaveServiceImpl extends CommonService implements MessageService {

    private final static Logger LOGGER = Logger.getLogger(MessaveServiceImpl.class);

    @Override
    public List<Message> getMessage() {

        Gson gson = new Gson();
        Type type = new TypeToken<List<Message>>() {
        }.getType();

        String json = new JSONObject(getMessageFromBind()).get("news").toString();
        LOGGER.info(json);
        List<Message> messages = gson.fromJson(json, type);

        /*Function<String, Message> func = item -> {
            Message message = new Message();
            message.setTitle(new JSONObject(item).get("title").toString());

            String detail = new JSONObject(item).get("list").toString();

            return gsonReceiver.fromJson(item, new TypeToken<Message>(){}.getType());
        };*/
//        List<MessageDetail> messages = strings.stream().map(func).collect(Collectors.toList());
        LOGGER.info(messages.size());
        LOGGER.info(messages.get(0).getTitle());
        LOGGER.info(messages.get(0).getList().get(0).getTitle());
        return messages;
    }



}
