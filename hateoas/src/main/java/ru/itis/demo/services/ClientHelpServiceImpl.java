package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.demo.models.Client;
import ru.itis.demo.models.ClientsHelp;
import ru.itis.demo.models.Skill;
import ru.itis.demo.repositories.ClientHelpRepository;
import ru.itis.demo.repositories.ClientRepository;
import ru.itis.demo.repositories.SkillsRepository;

@Service
public class ClientHelpServiceImpl implements ClientHelpService {

    @Autowired
    ClientHelpRepository clientHelpRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    SkillsRepository skillsRepository;

    @Transactional
    @Override
    public ClientsHelp help(Long assistantId, Long toClientId, Long skillId) {
        Client assistant = clientRepository.findById(assistantId).orElseThrow(IllegalArgumentException::new);
        Client toClient = clientRepository.findById(toClientId).orElseThrow(IllegalArgumentException::new);

        Skill skill = skillsRepository.findById(skillId).orElseThrow(IllegalArgumentException::new);

        ClientsHelp clientsHelp = ClientsHelp.builder()
                .assistant(assistant)
                .toClient(toClient)
                .build();
        clientsHelp.help(skill);
        clientHelpRepository.save(clientsHelp);
        skillsRepository.save(skill);
        return clientsHelp;
    }
}
