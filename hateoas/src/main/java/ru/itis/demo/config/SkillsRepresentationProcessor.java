package ru.itis.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ru.itis.demo.controllers.SkillsController;
import ru.itis.demo.controllers.SkillsStatusController;
import ru.itis.demo.models.Client;
import ru.itis.demo.models.Skill;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SkillsRepresentationProcessor implements RepresentationModelProcessor<EntityModel<Skill>> {

    @Override
    public EntityModel<Skill> process(EntityModel<Skill> model) {
        Skill skill = model.getContent();
        if (skill != null) {
            switch (skill.getSkillStatus()) {
                case WISH:
                    model.add(linkTo(methodOn(SkillsStatusController.class).startLearning(skill.getId())).withRel("startLearning"));
                    break;
                case IN_PROCESS:
                    model.add(linkTo(methodOn(SkillsStatusController.class).study(skill.getId())).withRel("study"));
                    break;
            }
        }
        return model;
    }

}
