package by.minsk.converters;

import by.minsk.dto.LanguageDTO;
import by.minsk.entity.Language;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LanguageConverter {
    public LanguageDTO convertToDTO(Language language) {
        log.info("LanguageConverter, convertToDTO");

        int id=language.getId();
        String locale=language.getLanguageText();

        LanguageDTO languageDTO=new LanguageDTO();

        languageDTO.setId(id);
        languageDTO.setLanguageText(locale);

        return languageDTO;
    }

    public Language convertToEntity(LanguageDTO languageDTO) {
        log.info("LanguageConverter, convertToEntity");

        int id=languageDTO.getId();
        String locale=languageDTO.getLanguageText();

        Language language=new Language();

        language.setId(id);
        language.setLanguageText(locale);

        return language;
    }
}
