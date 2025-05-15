package it.epicode.retro_vault.common;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public EmailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;

        // Se il mailSender è di tipo JavaMailSenderImpl, puoi forzare le proprietà qui
        if (mailSender instanceof org.springframework.mail.javamail.JavaMailSenderImpl) {
            org.springframework.mail.javamail.JavaMailSenderImpl senderImpl =
                    (org.springframework.mail.javamail.JavaMailSenderImpl) mailSender;
            Properties props = senderImpl.getJavaMailProperties();
            props.put("mail.smtp.ssl.trust", "*");
            props.put("mail.smtp.ssl.checkserveridentity", "false");
        }
    }

    public void sendEmail(String to, String subject, String text) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);

        mailSender.send(message);
    }

    public void sendEmailWithAttachment(String to, String subject, String body, byte[] attachmentBytes, String attachmentName) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        // 'true' abilita il supporto multipart per gli allegati
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // Splitta la stringa "to" usando virgola o punto e virgola come delimitatori
        String[] recipients = to.split("\\s*[,;]\\s*");
        helper.setTo(recipients);

        helper.setSubject(subject);
        helper.setText(body, true);
        helper.addAttachment(attachmentName, new ByteArrayResource(attachmentBytes));
        mailSender.send(message);
        System.out.println("Email inviata con successo a " + to + " con allegato: " + attachmentName);
    }
}
