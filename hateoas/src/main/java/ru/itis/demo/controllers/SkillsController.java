package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.demo.services.ClientHelpService;

@RepositoryRestController
public class SkillsController {

    @Autowired
    ClientHelpService clientHelpService;

    @RequestMapping(value = "/skills/{skill-id}/help", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<?> help(@RequestBody  Long clientId, @PathVariable("skill-id") Long skillId, @RequestBody Long assistantId) {
        return ResponseEntity.ok(
                new EntityModel<>(
                        clientHelpService.help(assistantId,clientId,skillId)));
    }

}
