package com.booking_house_be.service.impl;

import com.booking_house_be.dto.BillPDF;
import com.booking_house_be.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;
    public void sendEmail(String toEmail, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("huhuh8918@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(content);
        javaMailSender.send(message);
    }

    public void sendBill(String toEmail, Booking booking) throws MessagingException, IOException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setSubject("Hóa đơn thuê nhà");
        helper.setFrom("huhuh8918@gmail.com");
        helper.setTo(toEmail);

        helper.setText("<b>Chào bạn</b>,<br><p>Đây là hóa đơn thuê nhà của bạn</p>", true);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BillPDF billPDF = new BillPDF(booking);

        billPDF.export(outputStream);
        byte[] bytes = outputStream.toByteArray();

        DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
        helper.addAttachment("Bill.pdf", dataSource);

        javaMailSender.send(message);
    }
}
