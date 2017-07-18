/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.spring.vuejs.controller;

import com.spring.vuejs.model.Message;
import com.spring.vuejs.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Author : Quang Tran Dang
 * Email: quang.trandang@homedirect.com
 * 18/07/2017
 */

@RestController
@RequestMapping("/")
public class MessageController {

    @Autowired
    private MessageService service;

    @GetMapping(value = {"/message"})
    public ModelAndView home(){
        return new ModelAndView("message");
    }

    @GetMapping(value = {"/get-message"})
    public List<Message> getMessage(){
        return service.getMessage();
    }

    @GetMapping(value = {"/test"})
    @ResponseBody
    public String test(){
        service.getMessage();
        return "OK";
    }

}
