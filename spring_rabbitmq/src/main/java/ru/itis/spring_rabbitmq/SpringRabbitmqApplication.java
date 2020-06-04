package ru.itis.spring_rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.itis.spring_rabbitmq.producer.Producer;

import java.io.IOException;

import static ru.itis.spring_rabbitmq.Constants.*;

@SpringBootApplication
public class SpringRabbitmqApplication {


  @Bean
  public ConnectionFactory connectionFactory() {
    return new CachingConnectionFactory("localhost");
  }

  @Bean
  public AmqpAdmin amqpAdmin() {
    return new RabbitAdmin(connectionFactory());
  }

  @Bean
  public RabbitTemplate rabbitTemplate() {
    return new RabbitTemplate(connectionFactory());
  }

  @Bean
  public Queue queue1() {
    return new Queue(QUEUE_1);
  }

  @Bean
  public Queue queue2() {
    return new Queue(QUEUE_2);
  }

  @Bean
  public Queue queue3() {
    return new Queue(QUEUE_3);
  }
  @Bean
  public TopicExchange topicExchange(){
    return new TopicExchange(IMG_EXCHANGE);
  }
  @Bean
  public Binding binding2(){
    return BindingBuilder.bind(queue2()).to(topicExchange()).with(JPG_ROUTING_KEY);
  }

  @Bean
  public Binding binding3(){
    return BindingBuilder.bind(queue3()).to(topicExchange()).with(PNG_ROUTING_KEY);
  }

  public static void main(String[] args) throws IOException {
    ApplicationContext context = SpringApplication.run(SpringRabbitmqApplication.class, args);
    Producer producer = context.getBean(Producer.class);

    producer.sendMessage("Hello");
    producer.sendMessage("Message");

    producer.sendImages();

  }

}
