package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.demo.services.SkillsService;

@RepositoryRestController
public class SkillsStatusController {

    @Autowired
    SkillsService skillsService;

    @RequestMapping(value = "/skills/{skill-id}/study", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<?> study(@PathVariable("skill-id") Long skillId) {
        return ResponseEntity.ok(
                new EntityModel<>(
                        skillsService.changeStatus(skillId)));
    }

    @RequestMapping(value = "/skills/{skill-id}/startLearning", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<?> startLearning(@PathVariable("skill-id") Long skillId) {
        return ResponseEntity.ok(
                new EntityModel<>(
                        skillsService.changeStatus(skillId)));
    }

}
