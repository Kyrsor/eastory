package by.minsk.intefaces;

import by.minsk.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {

    List<QuestionDTO> findAll();

    QuestionDTO findById(Integer id);

    List<QuestionDTO> findByLanguageId(Integer id);

    QuestionDTO create(QuestionDTO questionDTO);

    QuestionDTO update(QuestionDTO questionDTO);

    void deleteById(Integer id);

}
