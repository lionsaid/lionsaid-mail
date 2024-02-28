package com.lionsaid.mail;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "邮箱 rest api")
@Slf4j
@RequestMapping("mail")
@RestController
@AllArgsConstructor
public class MailController {
    private final MailService mailService;


    @SneakyThrows
    @Operation(description = "Email sendVerificationCodeMail")
    @PostMapping("/sendVerificationCodeMail")
    @ResponseBody
    public ResponseEntity<String> sendVerificationCodeMail(@Valid @Email String mail) {
        mailService.sendVerificationCodeMail(mail, RandomStringUtils.randomNumeric(6));
        return ResponseEntity.ok("邮件已发送");
    }

    @SneakyThrows
    @Operation(description = "Email sendVerificationCodeMail")
    @GetMapping("/readReceipt")
    @ResponseBody
    public void readReceipt(String id) {

        log.error("=================================== readReceipt [{}]", id);
    }


}
