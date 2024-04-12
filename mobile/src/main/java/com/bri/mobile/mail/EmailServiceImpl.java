package com.bri.mobile.mail;

import com.bri.mobile.Entity.User;
import com.bri.mobile.Repo.UserRepo;
import com.bri.mobile.tool.mail.EmailDetails;
import com.bri.mobile.tool.mail.Success;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sender;
    @Autowired
    UserRepo userRepo;
    public Success sendSimpleEmail(EmailDetails emailDetails){
        try{
            SimpleMailMessage simpleMailMessage =new SimpleMailMessage();
            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setSubject(emailDetails.getSubject());
            simpleMailMessage.setTo(emailDetails.getRecipient());
            simpleMailMessage.setText(emailDetails.getMsgBody());
            javaMailSender.send(simpleMailMessage);
            Success success=new Success();
            success.setMsg("mail sent Successfully");
            return success;
        }catch (Exception e){
            Success success=new Success();
            success.setMsg("error sending mail");
            return success;
        }
    }
    public Success sendHtmlEmail(EmailDetails emailDetails){
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        String userEmail=emailDetails.getRecipient();
        if(userRepo.findByEmail(userEmail).isPresent()) {
            User user=userRepo.findByEmail(userEmail).get();
            emailDetails.setMsgBody("<div><a href=http://localhost:4200/password/"+user.getIdUtilisateur()+"> Click here to reset your password</a></div>");
            try {
                mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
                mimeMessageHelper.setFrom(sender);
                mimeMessageHelper.setTo(emailDetails.getRecipient());
                mimeMessageHelper.setSubject(emailDetails.getSubject());
                mimeMessageHelper.setText(emailDetails.getMsgBody(), true);

                javaMailSender.send(mimeMessage);
                Success success=new Success();
                success.setMsg("mail sent Successfully");
                return success;
            }catch (Exception e){
                Success success=new Success();
                success.setMsg("error sending mail");
                return success;
            }
        }else{
            throw new RuntimeException("user not found");
        }
    }
    public Success sendMailWithAttachment(EmailDetails emailDetails){
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        try{
            mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(emailDetails.getRecipient());
            mimeMessageHelper.setSubject(emailDetails.getSubject());
            mimeMessageHelper.setText(emailDetails.getMsgBody());

            FileSystemResource fileSystemResource=new FileSystemResource(emailDetails.getAttachment());
            mimeMessageHelper.addAttachment(Objects.requireNonNull(fileSystemResource.getFilename()),fileSystemResource);

            javaMailSender.send(mimeMessage);
            Success success=new Success();
            success.setMsg("mail sent Successfully");
            return success;
        }catch (Exception e){
            Success success=new Success();
            success.setMsg("error sending mail");
            return success;
        }
    }

}
