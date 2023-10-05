package com.booking_house_be.controller;

import com.booking_house_be.entity.Account;
import com.booking_house_be.service.IAccountService;
import com.booking_house_be.service.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ForgotPasswordController {
    @Autowired
    IAccountService accountService;
    @Autowired
    EmailService emailService;

    @PostMapping("/forgot")
    public ResponseEntity<?> requestPasswordReset(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");

        // Kiểm tra xem email có tồn tại trong cơ sở dữ liệu không
        Account account = accountService.getAccountByEmail(email);
        if (account == null) {
            return ResponseEntity.badRequest().body("Email không tồn tại");
        }

        // Tạo mã reset password và lưu vào cơ sở dữ liệu
        String resetCode = generateResetCode();
        account.setResetCode(resetCode);
        accountService.save(account);

        // Gửi email chứa mã reset password
        String resetLink = "http://http://localhost:3000/login";
        String emailContent = "Mật khẩu của bạn là " + account.getPassword() + " Vui lòng truy cập đường link sau để tiếp tục:\n" + resetLink;
        emailService.sendEmail(email, "Yêu cầu gửi lại mật khẩu", emailContent);

        return ResponseEntity.ok("Email đã được gửi");
    }

    public String generateResetCode() {
        // Sử dụng lớp UUID để tạo một chuỗi UUID ngẫu nhiên
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
