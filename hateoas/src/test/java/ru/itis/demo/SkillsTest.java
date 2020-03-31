package ru.itis.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import ru.itis.demo.models.Skill;
import ru.itis.demo.models.SkillStatus;
import ru.itis.demo.services.SkillsService;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class SkillsTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SkillsService skillsService;

    @BeforeEach
    public void setUp() {
        when(skillsService.changeStatus(1L)).thenReturn(study());
        when(skillsService.changeStatus(2L)).thenReturn(startLearning());
    }

    @Test
    public void skillsStudyTest() throws Exception {
        mockMvc.perform(put("/skills/1/study")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.skillName").value(study().getSkillName()))
                .andExpect(jsonPath("$.description").value(study().getDescription()))
                .andExpect(jsonPath("$.skillStatus").value(study().getSkillStatus().toString()))
                .andDo(document("studied_skills", responseFields(
                        fieldWithPath("skillName").description("Название навыка"),
                        fieldWithPath("description").description("Описание"),
                        fieldWithPath("skillStatus").description("Состояние")
                )));
    }

    @Test
    public void skillsStartLearningTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(put("/skills/2/startLearning")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.skillName").value(startLearning().getSkillName()))
                .andExpect(jsonPath("$.description").value(startLearning().getDescription()))
                .andExpect(jsonPath("$.skillStatus").value(startLearning().getSkillStatus().toString()))
                .andDo(document("in_process_skills", responseFields(
                        fieldWithPath("skillName").description("Название навыка"),
                        fieldWithPath("description").description("Описание"),
                        fieldWithPath("skillStatus").description("Состояние"),
                        subsectionWithPath("_links").ignored()
                        )
                ));
    }

    private Skill startLearning() {
        return Skill.builder()
                .id(2L)
                .skillName("Готовить пиццу")
                .description("Прям очень вкусную")
                .skillStatus(SkillStatus.IN_PROCESS)
                .build();
    }

    private Skill study() {
        return Skill.builder()
                .id(1L)
                .skillName("Готовить пиццу")
                .description("Прям очень вкусную")
                .skillStatus(SkillStatus.STUDIED)
                .build();
    }
}
