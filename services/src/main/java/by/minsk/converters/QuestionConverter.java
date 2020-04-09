package by.minsk.converters;

import by.minsk.dto.QuestionDTO;
import by.minsk.entity.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QuestionConverter {
    public QuestionDTO convertToDTO(Question question) {

        log.info("QuestionConverter, convertToDTO");

        Integer id = question.getId();

        String questionText = question.getQuestionText();

        String answer1 = question.getAnswer1();

        String answer2 = question.getAnswer2();

        String answer3 = question.getAnswer3();

        String answer4 = question.getAnswer4();

        Integer rightAnswer = question.getRightAnswer();

        byte[] image = question.getImage();

        String description = question.getDescription();

        Integer languageId = question.getLanguageId();

        QuestionDTO questionDTO = new QuestionDTO();

        questionDTO.setId(id);

        questionDTO.setQuestionText(questionText);

        questionDTO.setAnswer1(answer1);

        questionDTO.setAnswer2(answer2);

        questionDTO.setAnswer3(answer3);

        questionDTO.setAnswer4(answer4);

        questionDTO.setRightAnswer(rightAnswer);

        questionDTO.setImage(image);

        questionDTO.setDescription(description);

        questionDTO.setLanguageId(languageId);

        return questionDTO;

    }

    public Question convertToEntity(QuestionDTO questionDTO) {

        log.info("QuestionConverter, convertToEntity");

        Integer id = questionDTO.getId();

        String questionText = questionDTO.getQuestionText();

        String answer1 = questionDTO.getAnswer1();

        String answer2 = questionDTO.getAnswer2();

        String answer3 = questionDTO.getAnswer3();

        String answer4 = questionDTO.getAnswer4();

        Integer rightAnswer = questionDTO.getRightAnswer();

        byte[] image = questionDTO.getImage();

        String description = questionDTO.getDescription();

        Integer languageId = questionDTO.getLanguageId();

        Question question = new Question();

        question.setId(id);

        question.setQuestionText(questionText);

        question.setAnswer1(answer1);

        question.setAnswer2(answer2);

        question.setAnswer3(answer3);

        question.setAnswer4(answer4);

        question.setRightAnswer(rightAnswer);

        question.setImage(image);

        question.setDescription(description);

        question.setLanguageId(languageId);

        return question;

    }
}
