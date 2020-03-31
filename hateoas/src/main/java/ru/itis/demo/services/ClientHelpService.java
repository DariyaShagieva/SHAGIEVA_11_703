package ru.itis.demo.services;

import ru.itis.demo.models.ClientsHelp;

public interface ClientHelpService {
    ClientsHelp help(Long assistantId, Long toClientId, Long skillId);

}
