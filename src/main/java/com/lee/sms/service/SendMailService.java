package com.lee.sms.service;

/**
 * Created by a handsome man
 *
 * @Author: mental_test
 * @Date: 2023/01/03/17:38
 * @Description:
 */
public interface SendMailService {

    public boolean sendMail(String to,String text,String title);
}
