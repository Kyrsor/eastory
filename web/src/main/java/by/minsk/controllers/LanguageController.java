package by.minsk.controllers;

import by.minsk.dto.LanguageDTO;
import by.minsk.impl.LanguageServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/language")
@Api
public class LanguageController {

    private LanguageServiceImpl languageService;

    @Autowired
    public LanguageController(LanguageServiceImpl languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public ResponseEntity<List<LanguageDTO>> findAll() {
        log.info("LanguageController, findAll");
        return new ResponseEntity<>(languageService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LanguageDTO> findById(@PathVariable Integer id) {
        log.info("LanguageController, findById");
        return new ResponseEntity<>(languageService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LanguageDTO> create(@RequestBody LanguageDTO languageDTO) {
        log.info("LanguageController, create");
        return new ResponseEntity<>(languageService.create(languageDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<LanguageDTO> update(@RequestBody LanguageDTO languageDTO) {
        log.info("LanguageController, update");
        return new ResponseEntity<>(languageService.update(languageDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        log.info("LanguageController, deleteById");
        languageService.deleteById(id);
        return ResponseEntity.ok("Language is deleted");
    }


}
