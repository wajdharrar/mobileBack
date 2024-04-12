package com.bri.mobile.mail;

import com.bri.mobile.tool.mail.EmailDetails;
import com.bri.mobile.tool.mail.Success;

public interface EmailService {
    Success sendSimpleEmail(EmailDetails emailDetails);
    Success sendHtmlEmail(EmailDetails emailDetails);
    Success sendMailWithAttachment(EmailDetails emailDetails);
}
