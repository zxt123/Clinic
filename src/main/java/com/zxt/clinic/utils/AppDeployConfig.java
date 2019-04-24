package com.zxt.clinic.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AppDeployConfig {

    private static final String fileName = "/config/app-deploy.json";

    static {

    }

    public static JSONObject getInstance() {
        try {
        final BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String content = "";
        String tempString;
        while ((tempString = reader.readLine()) != null) {
            content += tempString;
        }
        return JSON.parseObject(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private AppDeployConfig() {
    }

}
