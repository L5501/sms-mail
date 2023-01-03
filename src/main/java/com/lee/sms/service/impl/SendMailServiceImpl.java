package com.lee.sms.service.impl;



import com.lee.sms.service.SendMailService;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by a handsome man
 *
 * @Author: mental_test
 * @Date: 2023/01/03/17:38
 * @Description:
 */
@Service
public class SendMailServiceImpl implements SendMailService {
    private static final String account  = "2290132536@qq.com";
    private static final String password  = "dcwonwfznkciebaj";
    public static String myEmailSMTPHost = "smtp.qq.com";



    @Override
    public boolean sendMail(String to, String text, String title) {
        // 1.创建连接对象，链接到邮箱服务器
        Properties props = new Properties();
        // 参数配置
        // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.transport.protocol", "smtp");
        // 发件人的邮箱的 SMTP
        props.setProperty("mail.smtp.host", myEmailSMTPHost);
        // 服务器地址
        // 需要请求认证
        props.setProperty("mail.smtp.auth", "true");

        // 2.根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(account, password);
            }
        });

        try {
            // 3.创建邮件对象
            Message message = new MimeMessage(session);
            // 3.1设置发件人
            message.setFrom(new InternetAddress(account));
            // 3.2设置收件人
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            // 3.3设置邮件的主题
            message.setSubject(title);
            // 3.4设置邮件的正文
            // message.setContent("<h1>来自智慧电梯的激活邮件，您的验证码是：</h1><h3><a href='http://localhost:10080/Demo_JavaMail/active?code="
            // + code + "'>http://localhost:10080/Demo_JavaMail/active?code=" +
            // code + "</h3>", "text/html;charset=UTF-8");
            message.setContent(text,"text/html;charset=UTF-8");
            // 4.发送邮件
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }

}
