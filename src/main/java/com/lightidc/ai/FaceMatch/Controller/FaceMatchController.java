package com.lightidc.ai.FaceMatch.Controller;

import com.lightidc.ai.FaceMatch.Services.FaceMatchService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author Clarence By 轻互联 版权所有
 * @since 1.7+
 * @version 1.0
 * 人脸识别控制器
 */
@Controller
@RequestMapping("auth")
public class FaceMatchController
{
    @Autowired
    private FaceMatchService service;

    @RequestMapping("face")
    @ResponseBody
    public JSONObject FaceMatch(String image1, String image2)
    {
        JSONObject object=null;
        try
        {
            String result = service.FaceMatch(image1,image2);
            object = new JSONObject();
            object= JSONObject.fromObject(result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            object=new JSONObject();
            object.put("code",500);
            object.put("msg","数据获取失败!");
        }
        return object;
    }
}
