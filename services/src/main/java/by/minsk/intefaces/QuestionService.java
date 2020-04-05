package by.minsk.intefaces;

import by.minsk.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {

    List<QuestionDTO> getAll();

    QuestionDTO getById(int id);

    QuestionDTO create(QuestionDTO questionDTO);

    QuestionDTO update(QuestionDTO questionDTO);

    void deleteById(int id);

}
