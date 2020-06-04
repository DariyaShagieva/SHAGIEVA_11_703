package ru.itis.spring_rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

import static ru.itis.spring_rabbitmq.Constants.*;

@Component
public class Producer {
  @Autowired
  private RabbitTemplate rabbitTemplate;


  public void sendMessage( String message) {
    rabbitTemplate.convertAndSend(QUEUE_1, message);
  }


  public void sendImages() throws IOException {
    File file = new File("images.txt");

    BufferedReader reader = new BufferedReader(new FileReader(file));
    String currentFile;
    while ((currentFile = reader.readLine()) != null) {
      String currentRouting = currentFile.substring(currentFile.lastIndexOf("."));

      if (currentRouting.equals(".jpeg")) {
        currentRouting = ".jpg";
      }

      if (".png".equals(currentRouting)) {
        currentRouting = PNG_ROUTING_KEY;
      } else {
        currentRouting = JPG_ROUTING_KEY;
      }
      rabbitTemplate.convertAndSend(IMG_EXCHANGE, currentRouting, currentFile );
    }
  }
}
