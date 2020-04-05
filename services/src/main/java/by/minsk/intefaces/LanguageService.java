package by.minsk.intefaces;

import by.minsk.dto.LanguageDTO;

import java.util.List;

public interface LanguageService {

    LanguageDTO getById(int id);

    List<LanguageDTO> getAll();

    LanguageDTO create(LanguageDTO languageDTO);

    LanguageDTO update(LanguageDTO languageDTO);

    void deleteById(int id);


}
