
package by.minsk.intefaces;

import by.minsk.dto.AnswerDTO;

import java.util.List;

public interface CheckAnswersService {

    Integer checkRightAnswers(Integer topicId, List<AnswerDTO> answerDTOList);
}

