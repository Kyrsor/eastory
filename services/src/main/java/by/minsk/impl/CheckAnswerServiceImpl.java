
package by.minsk.impl;

import by.minsk.converters.TestConverter;
import by.minsk.dto.AnswerDTO;
import by.minsk.entity.Test;
import by.minsk.intefaces.CheckAnswersService;
import by.minsk.repository.QuestionRepository;
import by.minsk.repository.TestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CheckAnswerServiceImpl implements CheckAnswersService {


    private TestRepository testRepository;

    private QuestionRepository questionRepository;

    @Autowired
    public CheckAnswerServiceImpl(TestRepository testRepository, QuestionRepository questionRepository) {
        this.testRepository = testRepository;

        this.questionRepository = questionRepository;
    }


    @Override
    public Integer checkRightAnswers(Integer topicId, List<AnswerDTO> answerDTOList) {
        Integer rightAnswerCounter = 0;
        if (answerDTOList.isEmpty()) {
            return rightAnswerCounter;
        } else {

            List<Test> testList = testRepository.findAllByTopicId(topicId);
            for (int i = 0; i < testList.size(); i++) {

                int questionId = testList.get(i).getQuestionId();

                int rightAnswer = questionRepository.findOne(questionId).getRightAnswer();

                for (int j = 0; j < answerDTOList.size(); j++) {
                    if (answerDTOList.get(j).getQuestionId() == questionId
                            && answerDTOList.get(j).getAnswer() == rightAnswer) {

                        rightAnswerCounter++;
                        testList.remove(i);
                        answerDTOList.remove(j);
                        break;
                    }
                }
            }
        }
        return rightAnswerCounter;
    }
}

