package by.minsk.impl;

import by.minsk.converters.LanguageConverter;
import by.minsk.dto.LanguageDTO;
import by.minsk.entity.Language;
import by.minsk.intefaces.LanguageService;
import by.minsk.repository.LanguageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LanguageServiceImpl implements LanguageService {

    private LanguageConverter languageConverter;

    private LanguageRepository languageRepository;

    @Autowired
    public LanguageServiceImpl(LanguageConverter languageConverter, LanguageRepository languageRepository) {

        this.languageConverter = languageConverter;

        this.languageRepository = languageRepository;

    }

    public LanguageDTO getById(int id) {

        log.info("LanguageServiceImpl, getById");

        Language language = languageRepository.findLanguageById(id);

        if (language == null) {

            throw new EntityNotFoundException("Cannot find language by this parameter");

        }

        return languageConverter.convertToDTO(language);

    }

    public List<LanguageDTO> getAll() {

        log.info("LanguageServiceImpl, getAll");

        return languageRepository.findAll()
                                 .stream()
                                 .map(languageConverter::convertToDTO)
                                 .collect(Collectors.toList());

    }

    public LanguageDTO getByName(String languageText) {

        log.info("LanguageServiceImpl, getByName");

        Language language=languageRepository.findLanguageByLanguageText(languageText);

        if(language==null){

            throw new EntityNotFoundException("Cannot find language by this parameter");
        }

        return languageConverter.convertToDTO(language);

    }

    public LanguageDTO create(LanguageDTO languageDTO) {

        log.info("LanguageServiceImpl, create");

        Language language=languageConverter.convertToEntity(languageDTO);

        language=languageRepository.save(language);

        return languageConverter.convertToDTO(language);

    }

    public LanguageDTO update(LanguageDTO languageDTO) {

        log.info("LanguageServiceImpl, update");

        Language language=languageRepository.findLanguageById(languageDTO.getId());

        if(language==null){

            throw new EntityNotFoundException("Cannot update language with such parameters");

        }

        language.setLanguageText(languageDTO.getLanguageText());

        language=languageRepository.save(language);

        return languageConverter.convertToDTO(language);

    }

    @Override
    public void deleteById(int id) {

        log.info("LanguageServiceImpl, deleteById");

        languageRepository.deleteById(id);

    }

    @Override
    public void deleteByLanguageText(String languageText) {

        log.info("LanguageServiceImpl, deleteByLanguageText");

        languageRepository.deleteByLanguageText(languageText);

    }
}
