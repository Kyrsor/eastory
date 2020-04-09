package by.minsk.impl;

import by.minsk.converters.QuestionConverter;
import by.minsk.dto.LanguageDTO;
import by.minsk.dto.QuestionDTO;
import by.minsk.entity.Question;
import by.minsk.intefaces.QuestionService;
import by.minsk.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;
    private QuestionConverter questionConverter;
    private LanguageServiceImpl languageService;

    public QuestionServiceImpl(QuestionRepository questionRepository, QuestionConverter questionConverter, LanguageServiceImpl languageService) {
        this.questionRepository = questionRepository;
        this.questionConverter = questionConverter;
        this.languageService = languageService;
    }

    @Autowired


    @Override
    public List<QuestionDTO> findAll() {

        log.info("QuestionServiceImpl, findAll");

        return questionRepository.findAll()
                                 .stream()
                                 .map(questionConverter::convertToDTO)
                                 .collect(Collectors.toList());

    }


    @Override
    public QuestionDTO findById(Integer id) {

        log.info("QuestionServiceImpl, findById");

        Question question = questionRepository.findOne(id);

        if (question == null) {

            throw new EntityNotFoundException("Cannot find question by this parameter");

        }

        return questionConverter.convertToDTO(question);

    }

    @Override
    public List<QuestionDTO> findByLanguageId(Integer id) {
        log.info("QuestionServiceImpl, findByLanguageId");
        LanguageDTO languageDTO = languageService.findById(id);

        return questionRepository.findAllByLanguageId(languageDTO.getId())
                                 .stream()
                                 .map(questionConverter::convertToDTO)
                                 .collect(Collectors.toList());


    }

    @Override
    public QuestionDTO create(QuestionDTO questionDTO) {

        log.info("QuestionServiceImpl, create");

        Question question = questionConverter.convertToEntity(questionDTO);

        question = questionRepository.save(question);

        return questionConverter.convertToDTO(question);

    }

    @Override
    public QuestionDTO update(QuestionDTO questionDTO) {

        log.info("QuestionServiceImpl, update");

        Question question = questionRepository.findOne(questionDTO.getId());

        if (question == null) {

            throw new EntityNotFoundException("No such question to update");

        }

        question.setQuestionText(questionDTO.getQuestionText());

        question.setAnswer1(questionDTO.getAnswer1());

        question.setAnswer2(questionDTO.getAnswer2());

        question.setAnswer3(questionDTO.getAnswer3());

        question.setAnswer4(questionDTO.getAnswer4());

        question.setRightAnswer(questionDTO.getRightAnswer());

        question.setDescription(questionDTO.getDescription());

        question.setImage(questionDTO.getImage());

        question.setLanguageId(questionDTO.getLanguageId());

        question = questionRepository.save(question);

        return questionConverter.convertToDTO(question);

    }

    @Override
    public void deleteById(Integer id) {

        log.info("QuestionServiceImpl, delete");

        Question question = questionRepository.findOne(id);

        if (question == null) {
            throw new EntityNotFoundException("No such question to delete");

        }
        questionRepository.delete(id);

    }
}
