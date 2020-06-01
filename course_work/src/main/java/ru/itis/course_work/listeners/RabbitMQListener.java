package ru.itis.course_work.listeners;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;;

@Component
@EnableRabbit
public class RabbitMQListener {
  @Autowired
  public JavaMailSender emailSender;


  @RabbitListener(queues = "offers")
  public void sendOffers(String aggregatorOffer) {
    String email = aggregatorOffer.split("\n")[0];
    String messageText = aggregatorOffer.replace(email,"");
    sendMessage(email, messageText);
  }
  @RabbitListener(queues = "answers")
  public void sendAnswer(String answer) {
    String email = answer.split("\n")[0];
    String messageText = answer.replace(email,"");
    sendMessage(email, messageText);
  }

  private void sendMessage (String email, String messageText) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(email);
    message.setText(messageText);

    emailSender.send(message);

  }
}
