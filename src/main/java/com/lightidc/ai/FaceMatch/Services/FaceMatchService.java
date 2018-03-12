package com.lightidc.ai.FaceMatch.Services;
import com.lightidc.ai.FaceMatch.AccessTokenUtil;
import com.lightidc.ai.FaceMatch.Constant;
import com.lightidc.ai.FaceMatch.Utils.XHRUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Clarence By 轻互联 版权所有
 * @since 1.7+
 * @version 1.0
 * 人脸识别服务类
 */
@Service
public class FaceMatchService
{
    public String FaceMatch(String image1,String image2) throws Exception
    {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("images",image1+","+image2);
        String result = XHRUtils.net(Constant.FACEMATCHURL+"?access_token="+ AccessTokenUtil.getToken(Constant.APIKEY,Constant.SECRETKEY),map,"POST");
        return result;
    }
}
