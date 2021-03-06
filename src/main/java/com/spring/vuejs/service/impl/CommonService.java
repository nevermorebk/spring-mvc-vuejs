/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.spring.vuejs.service.impl;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Author : Quang Tran Dang
 * Email: quang.trandang@homedirect.com
 * 18/07/2017
 */


public class CommonService {

    private final static Logger LOGGER = Logger.getLogger(CommonService.class);

    public <T> T convertStringToModel(String item, T t){
        Type type = new TypeToken<List<String>>() {
        }.getType();
        Gson gson = new Gson();
        List<String> strings = gson.fromJson(item, type);
        return null;
    }

    public String getMessageFromBind() {
        String restUrl = "http://netlife.vn/notification.json";

        HttpGet httpGet = createGetConnectivity(restUrl);

        return executeGetReq(httpGet);
    }

    private HttpGet createGetConnectivity(String restUrl) {
        HttpGet get = new HttpGet(restUrl);
        return get;
    }


    private String executeGetReq(HttpGet httpGet) {
        String json = "";
        try {
            json = executeHttpGetRequest(httpGet);
            return json;
        } catch (UnsupportedEncodingException e) {
            LOGGER.info("error while encoding api url : " + e);
        } catch (IOException e) {
            LOGGER.info("ioException occured while sending http request : " + e);
        } catch (Exception e) {
            LOGGER.info("exception occured while sending http request : " + e);
        } finally {
            httpGet.releaseConnection();
            return json;
        }
    }

    private String executeHttpGetRequest(HttpGet httpGet) throws IOException {
        HttpResponse response;
        String line;
        StringBuffer result = new StringBuffer();
        HttpClient client = HttpClientBuilder.create().build();
        response = client.execute(httpGet);
        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }

}
