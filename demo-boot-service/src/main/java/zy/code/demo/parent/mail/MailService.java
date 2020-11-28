package zy.code.demo.parent.mail;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import zy.code.demo.common.util.MyResult;
import zy.code.demo.common.util.MyResultUtils;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MailService {

    @Value("${mail.sender}")
    private String from;

    @Resource
    private JavaMailSender mailSender;


    @Autowired
    private FreeMarkerConfigurer configurer;   //发送邮件的模板引擎



    public <T> MyResult sendTempMail(List<String> receiverMails,List<String> ccMails, String subject, T data,String templateName){

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            String[] receiverMailArray = receiverMails != null ? receiverMails.stream().toArray(String[]::new) : new String[]{};
            String[] ccMailArray = ccMails != null ? ccMails.stream().toArray(String[]::new) : new String[]{};

            helper.setFrom(from);               //发送者
            helper.setSubject(subject);         //邮件标题
            helper.setTo(receiverMailArray);    //收件人
            helper.setCc(ccMailArray);          //抄送人
                                                //添加附件
//            FileSystemResource file = new FileSystemResource(new File("E:\\图片\\haha.jpg"));
//            helper.addAttachment("附件.jpg", file);

            //添加模板
            Map<String, Object> model = new HashMap<>();
            model.put("data", data);
            Template template = configurer.getConfiguration().getTemplate(templateName + ".ftl");
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            helper.setText(text, true);

            //发送邮件
            mailSender.send(message);

            return MyResultUtils.wrapSuccess("发送成功");

        } catch (Exception e) {
            e.printStackTrace();
            return  MyResultUtils.wrapFailed(e);
        }



    }
}
