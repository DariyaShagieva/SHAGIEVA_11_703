package ru.itis.spring_rabbitmq.receivers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import static ru.itis.spring_rabbitmq.Constants.*;

@Component
public class Listener {

  @RabbitListener(queues = QUEUE_1)
  public void receiveMessage(String message) {
    System.out.println("Received: " + message);
  }

  //jpg
  @RabbitListener(queues = QUEUE_2)
  public void downloadPng(String message) throws MalformedURLException {
    String imageUrl = message;
    System.out.println("Start  load image " + imageUrl);
    URL url = new URL(imageUrl);
    String fileName = url.getFile();
    try {
      BufferedImage image = ImageIO.read(url);
      File output = new File("downloaded/images/" + UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf(".")));
      ImageIO.write(image, "jpg", output);
      System.out.println("Finish from 2 load image " + imageUrl);
    } catch (IOException e) {
      System.err.println("FAILED");
    }


  }
  //png
  @RabbitListener(queues = QUEUE_3)
  public void downloadJpg(String message) throws MalformedURLException {
    String imageUrl = message;
    System.out.println("Start  load image " + imageUrl);
    URL url = new URL(imageUrl);
    String fileName = url.getFile();
    try {
      BufferedImage image = ImageIO.read(url);

      BufferedImage converted = new BufferedImage(
        image.getWidth(),
        image.getHeight(),
        BufferedImage.TYPE_INT_RGB);
      converted.createGraphics().drawImage(image, 0, 0, Color.PINK, null);

      File output = new File("downloaded/images/" + UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf(".")));
      ImageIO.write(converted, "jpg", output);
      System.out.println("Finish from 3 load image " + imageUrl);
    } catch (IOException e) {
      System.err.println("FAILED");
    }
  }

}
