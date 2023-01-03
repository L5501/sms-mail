package com.lee.sms.controller;

import com.lee.sms.service.SendMailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by a handsome man
 *
 * @Author: mental_test
 * @Date: 2023/01/03/18:17
 * @Description:
 */
@RestController
@RequestMapping("/mail")
public class SendMailController {

    @Resource
    SendMailService sendMailService;

    @PostMapping("send")
    public String sendMail(@RequestParam("stamp")String stamp ){
        boolean b = sendMailService.sendMail(stamp, "您好，这是一封测试邮件，无需回复", "测试邮件");
        if (b) {
            return "发送成功";
        }
        return "发送失败";
    }
}
