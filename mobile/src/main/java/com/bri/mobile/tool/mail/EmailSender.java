package com.bri.mobile.tool.mail;

import com.bri.mobile.DTO.Mapper.UserMap;
import com.bri.mobile.Entity.User;
import com.bri.mobile.Repo.UserRepo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmailSender {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    UserRepo userRepo;

    public void sendSetPasswordEmail(String email) throws MessagingException {
        Optional<User> user = userRepo.findByEmail(email);
        if (user.isPresent()) {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSubject("Set New Password");
            mimeMessageHelper.setText(
                    "<div>" +"<a href=http://localhost:4200/password> Click here to reset your password</a>"+"</div>",true
            );
            javaMailSender.send(mimeMessage);
        } else {
            throw new RuntimeException("user not found");
        }
    }
}
