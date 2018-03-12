package com.lightidc.ai.FaceMatch;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @author Clarence By 轻互联 版权所有
 * @since 1.7+
 * @version 1.0
 * 获取百度云面部识别请求参数AccessToken
 */
public class AccessTokenUtil
{
    /**
     * 获取百度云API的AccessToken
     * @param apikey
     * @param secretkey
     * @return
     */
    public static String getToken(String apikey,String secretkey)
    {
        String authHost=Constant.ACCESSTOKENURL
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. client_id为您在百度云获取的API KEY
                + "&client_id="+Constant.APIKEY
                // 3. client_secret为您API KEY对应的Secret Key
                + "&client_secret="+Constant.SECRETKEY;

        try {
            URL realUrl = new URL(authHost);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }
}
