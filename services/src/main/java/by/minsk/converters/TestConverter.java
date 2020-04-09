package by.minsk.converters;

import by.minsk.dto.TestDTO;
import by.minsk.entity.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestConverter {
    public TestDTO convertToDTO(Test test) {

        log.info("TestConverter, convertToDTO");
        Integer id = test.getId();

        Integer topicId = test.getTopicId();

        Integer questionId = test.getQuestionId();

        TestDTO testDTO = new TestDTO();
        testDTO.setId(id);
        testDTO.setTopicId(topicId);

        testDTO.setQuestionId(questionId);

        return testDTO;

    }

    public Test convertToEntity(TestDTO testDTO) {

        log.info("TestConverter, convertToEntity");
        Integer id = testDTO.getId();

        Integer topicId = testDTO.getTopicId();

        Integer questionId = testDTO.getQuestionId();

        Test test = new Test();

        test.setId(id);

        test.setTopicId(topicId);

        test.setQuestionId(questionId);

        return test;

    }
}
