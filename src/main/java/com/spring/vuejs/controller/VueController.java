/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.spring.vuejs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author : Quang Tran Dang
 * Email: quang.trandang@homedirect.com
 * 20/07/2017
 */

@RestController
@RequestMapping(value = {"/vue"})
public class VueController {

    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("vue");
    }

}
