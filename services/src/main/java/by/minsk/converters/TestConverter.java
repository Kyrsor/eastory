package by.minsk.converters;

import by.minsk.dto.TestDTO;
import by.minsk.entity.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestConverter {
    public TestDTO convertToDTO(Test test){

        log.info("TestConverter, convertToDTO");

        int topicId=test.getTopicId();

        int questionId=test.getQuestionId();

        TestDTO testDTO=new TestDTO();

        testDTO.setTopicId(topicId);

        testDTO.setQuestionId(questionId);

        return testDTO;

    }

    public Test convertToEntity(TestDTO testDTO){

        log.info("TestConverter, convertToEntity");

        int topicId=testDTO.getTopicId();

        int questionId=testDTO.getQuestionId();

        Test test=new Test();

        test.setTopicId(topicId);

        test.setQuestionId(questionId);

        return test;

    }
}
