/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.spring.vuejs.service.impl;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.spring.vuejs.model.Message;
import com.spring.vuejs.model.MessageDetail;
import com.spring.vuejs.model.News;
import com.spring.vuejs.service.MessageService;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.LinkedList;
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
    public List<News> getMessage() {

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

        List<News> list = new LinkedList<>();

        for(Message message : messages){
            for (MessageDetail detail : message.getList()){
                News news = new News();
                news.setTitle(message.getTitle());
                news.setSubTitle(detail.getTitle());
                news.setContent(detail.getContent());
                news.setDate(detail.getDate());
                list.add(news);
            }
        }

        LOGGER.info(list.size());

        return list;
    }



}
