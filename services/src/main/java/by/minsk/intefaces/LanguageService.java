package by.minsk.intefaces;

import by.minsk.dto.LanguageDTO;

import java.util.List;

public interface LanguageService {

    LanguageDTO findById(Integer id);

    List<LanguageDTO> findAll();

    LanguageDTO create(LanguageDTO languageDTO);

    LanguageDTO update(LanguageDTO languageDTO);

    void deleteById(Integer id);

}
