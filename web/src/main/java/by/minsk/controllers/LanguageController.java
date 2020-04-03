package by.minsk.controllers;

import by.minsk.dto.LanguageDTO;
import by.minsk.impl.LanguageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/language")
public class LanguageController {

    private LanguageServiceImpl languageService;

    @Autowired
    public LanguageController(LanguageServiceImpl languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public ResponseEntity<List<LanguageDTO>> getAll() {
        log.info("LanguageController, getAll");
        List<LanguageDTO> languageDTOList = languageService.getAll();
        return new ResponseEntity<>(languageDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LanguageDTO> getById(@PathVariable int id) {
        log.info("LanguageController, getById");
        LanguageDTO languageDTO = languageService.getById(id);
        return new ResponseEntity<>(languageDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{languageText}")
    public ResponseEntity<LanguageDTO> getByName(@PathVariable String languageText) {
        log.info("LanguageController, getByName");
        LanguageDTO languageDTO = languageService.getByName(languageText);
        return new ResponseEntity<>(languageDTO, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<LanguageDTO> create(@RequestBody LanguageDTO languageDTO) {
        log.info("LanguageController, create");
        LanguageDTO languageDTONew = languageService.create(languageDTO);
        return new ResponseEntity<>(languageDTONew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<LanguageDTO> update(@RequestBody LanguageDTO languageDTO) {
        log.info("LanguageController, update");
        LanguageDTO languageDTONew = languageService.update(languageDTO);
        return new ResponseEntity<>(languageDTONew, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity  deleteById(@PathVariable int id) {
        log.info("LanguageController, deleteById");
        languageService.deleteById(id);
        return ResponseEntity.ok("Language is deleted");
    }

    @DeleteMapping(value = "/{languageText}")
    public ResponseEntity  deleteByLanguageText(@PathVariable String languageText) {
        log.info("LanguageController, deleteByLanguageText");
        languageService.deleteByLanguageText(languageText);
        return ResponseEntity.ok("Language is deleted");
    }

}
