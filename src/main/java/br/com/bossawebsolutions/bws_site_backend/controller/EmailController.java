package br.com.bossawebsolutions.bws_site_backend.controller;

import br.com.bossawebsolutions.bws_site_backend.domain.EmailRequest;
import br.com.bossawebsolutions.bws_site_backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public ResponseEntity<Map<String, String>> sendEmail(@RequestBody EmailRequest emailRequest) {
        String subject = "Nova mensagem de " + emailRequest.getName();
        String text = "Nome: " + emailRequest.getName() +
                "\nE-mail: " + emailRequest.getEmail() +
                "\nTelefone: " + emailRequest.getPhone() +
                "\nMensagem: " + emailRequest.getMessage();

        emailService.sendEmail("contato@bossawebsolutions.com.br", subject, text);

        Map<String, String> response = new HashMap<>();
        response.put("message", "E-mail enviado com sucesso!");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}