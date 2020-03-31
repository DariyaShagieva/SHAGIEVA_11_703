package ru.itis.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ru.itis.demo.models.Client;
import ru.itis.demo.models.Skill;
import ru.itis.demo.models.SkillStatus;
import ru.itis.demo.repositories.ClientRepository;
import ru.itis.demo.repositories.SkillsRepository;

import java.util.Collections;

import static java.util.Arrays.asList;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context =SpringApplication.run(DemoApplication.class, args);

        ClientRepository clientRepository = context.getBean(ClientRepository.class);
        SkillsRepository skillsRepository = context.getBean(SkillsRepository.class);

        Skill skillCooking = Skill.builder().skillName("Готовить пиццу").description("Прям очень вкусную").skillStatus(SkillStatus.STUDIED).build();
        Skill skillRead = Skill.builder().skillName("Быстро читать").skillStatus(SkillStatus.WISH).build();

        Skill skillRun = Skill.builder().skillName("Бегать").skillStatus(SkillStatus.IN_PROCESS).build();



        Client clientFirst = Client.builder().firstName("Первый пользователь").skills(asList(skillCooking, skillRead)).build();
        Client clientSecond = Client.builder().firstName("Второй пользователь").skills(Collections.singletonList(skillRun)).build();


        skillsRepository.saveAll(asList(skillCooking, skillRead,skillRun));
        clientRepository.saveAll(asList(clientFirst, clientSecond));

    }

}
