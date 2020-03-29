package by.minsk.impl;

import by.minsk.dto.QuestionDTO;
import by.minsk.intefaces.QuestionService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
public class QuestionServiceImpl implements QuestionService {
    public List<QuestionDTO> getAll() {
        log.info("QuestionServiceImpl, getAll");
        return null;
    }

    public List<QuestionDTO> getAllByLanguageId(int id) {
        log.info("QuestionServiceImpl, getAllByLanguageId");
        return null;
    }

    public QuestionDTO getById(int id) {
        log.info("QuestionServiceImpl, getById");
        return null;
    }

    public QuestionDTO create(QuestionDTO questionDTO) {
        log.info("QuestionServiceImpl, create");
        return null;
    }

    public QuestionDTO update(QuestionDTO questionDTO) {
        log.info("QuestionServiceImpl, update");
        return null;
    }

    public void delete(int id) {
        log.info("QuestionServiceImpl, delete");
    }
}
