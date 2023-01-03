package com.lee.sms;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void sms(){
        // appId
        int appId = 1400621558;
        // appKey
        String appKey = "20058bb215babddd26ea58929b910336";
        // 模板id
        int templateId = 1274866;
        // 签名内容
        String smsSign = "骑着蜗牛跑路";

        // 可变参数
        // 手机号码
        String phoneNumber = "13545809343";
        // 验证码
        String code="1234";
        // 有效时长
        String min = "5";
        try {
            // param1：验证码；param2:时长，具体情况可参照模板
            String[] params = {code,min};
            SmsSingleSender smsSingleSender = new SmsSingleSender(appId,appKey);
            SmsSingleSenderResult smsSingleSenderResult = smsSingleSender.sendWithParam("86", phoneNumber, templateId, params, smsSign, "", "");
            System.out.println(smsSingleSenderResult);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
