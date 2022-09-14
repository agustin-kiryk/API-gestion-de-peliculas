package com.disney.alkemy.Service.impl;

import com.disney.alkemy.Service.EmailService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailServiceImpl implements EmailService {
        @Autowired
        private Environment env;
        @Value("${alkemy.disney.email.sender}")
        private String emailSender;

        public void sendWelcomeEmailTo(String to){
            String apiKey = env.getProperty("EMAIL_API_KEY");

            Email fromEmail = new Email(emailSender);
            Email toEmail = new Email(to);
            Content content = new Content("text/plain", "Bienvenido al portal de peliculas! :) " );
            String subject = "Te registraste correctamente :) !";

            Mail mail = new Mail(fromEmail, subject, toEmail, content);
            SendGrid sg = new SendGrid(apiKey);
            Request request = new Request();

            try{
                request.setMethod(Method.POST);
                request.setEndpoint("mail/send");
                request.setBody(mail.build());
                Response response = sg.api(request);

            }
            catch (IOException e){
                System.out.println("Error al intentar enviar el correo electrónico");
            }
        }


    }

