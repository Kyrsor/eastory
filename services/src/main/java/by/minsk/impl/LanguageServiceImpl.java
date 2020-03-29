package by.minsk.impl;

import by.minsk.dto.LanguageDTO;
import by.minsk.intefaces.LanguageService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
public class LanguageServiceImpl implements LanguageService {
    public LanguageDTO getById(int id) {
        log.info("LanguageServiceImpl, getById");
        return null;
    }

    public List<LanguageDTO> getAll() {
        log.info("LanguageServiceImpl, getAll");
        return null;
    }

    public LanguageDTO getByName(String languageText) {
        log.info("LanguageServiceImpl, getByName");
        return null;
    }

    public LanguageDTO create(LanguageDTO languageDTO) {
        log.info("LanguageServiceImpl, create");
        return null;
    }

    public LanguageDTO update(LanguageDTO languageDTO) {
        log.info("LanguageServiceImpl, update");
        return null;
    }

    public void delete(int id) {
        log.info("LanguageServiceImpl, delete");

    }
}
