package by.minsk.intefaces;

import by.minsk.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {

    List<QuestionDTO> getAll();

    List<QuestionDTO> getAllByLanguageId(int id);

    QuestionDTO getById(int id);

    QuestionDTO create(QuestionDTO questionDTO);

    QuestionDTO update(QuestionDTO questionDTO);

    void delete(int id);

}
