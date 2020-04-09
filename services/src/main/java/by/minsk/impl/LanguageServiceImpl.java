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

    @Override
    public LanguageDTO findById(Integer id) {

        log.info("LanguageServiceImpl, findById");

        Language language = languageRepository.findOne(id);

        if (language == null) {

            throw new EntityNotFoundException("Cannot find language by this parameter");

        }

        return languageConverter.convertToDTO(language);
    }

    @Override
    public List<LanguageDTO> findAll() {

        log.info("LanguageServiceImpl, findAll");

        return languageRepository.findAll()
                                 .stream()
                                 .map(languageConverter::convertToDTO)
                                 .collect(Collectors.toList());
    }

    @Override
    public LanguageDTO create(LanguageDTO languageDTO) {

        log.info("LanguageServiceImpl, create");

        Language language = languageConverter.convertToEntity(languageDTO);

        language = languageRepository.save(language);

        return languageConverter.convertToDTO(language);
    }

    @Override
    public LanguageDTO update(LanguageDTO languageDTO) {

        log.info("LanguageServiceImpl, update");

        Language language = languageRepository.findOne(languageDTO.getId());

        if (language == null) {

            throw new EntityNotFoundException("No such language to update");

        }

        language.setLanguageText(languageDTO.getLanguageText());

        language = languageRepository.save(language);

        return languageConverter.convertToDTO(language);
    }

    @Override
    public void deleteById(Integer id) {

        log.info("LanguageServiceImpl, deleteById");

        Language language = languageRepository.findOne(id);

        if (language == null) {
            throw new EntityNotFoundException("No such language to delete");
        }

        languageRepository.deleteById(id);
    }
}
