package com.github.sonus21.task.executor;

import com.github.sonus21.rqueue.annotation.RqueueListener;
import com.github.sonus21.task.executor.entity.Mail;
import com.github.sonus21.task.executor.repository.MailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
@Slf4j
public class MessageListener {
  @Autowired
  private JavaMailSender sender;

  @Autowired
  MailRepository mailRepository;

  @RqueueListener(value = "${email.queue.name}")
  public void sendEmail(Email email) throws Exception{
    MimeMessage message = sender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);
    Mail mailDB = mailRepository.findById(1).orElse(new Mail());
    helper.setTo(mailDB.getMail());
    helper.setText(email.getContent());
    helper.setSubject(email.getSubject());
    sender.send(message);
    log.info("Email {}", email);
  }

  @RqueueListener(value = "${invoice.queue.name}")
  public void generateInvoice(Invoice invoice) {
    log.info("Invoice {}", invoice);
  }
}
