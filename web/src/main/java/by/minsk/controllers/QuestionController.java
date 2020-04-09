package by.minsk.controllers;

import by.minsk.dto.QuestionDTO;
import by.minsk.impl.QuestionServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/question")
@Api
public class QuestionController {

    private QuestionServiceImpl questionService;

    @Autowired
    public QuestionController(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public ResponseEntity<List<QuestionDTO>> findAll() {
        log.info("QuestionController, findAll");
        return new ResponseEntity<>(questionService.findAll(), HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<QuestionDTO> findById(@PathVariable Integer id) {
        log.info("QuestionController, findById");

        return new ResponseEntity<>(questionService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/findByLanguageId/{id}")
    public ResponseEntity<List<QuestionDTO>> findByLanguageId(@PathVariable Integer id) {
        log.info("QuestionController, findByLanguageId");

        return new ResponseEntity<>(questionService.findByLanguageId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<QuestionDTO> create(@RequestBody @Valid QuestionDTO questionDTO) {
        log.info("QuestionController, create");
        return new ResponseEntity<>(questionService.create(questionDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<QuestionDTO> update(@RequestBody @Valid QuestionDTO questionDTO) {
        log.info("QuestionController, update");
        return new ResponseEntity<>(questionService.update(questionDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        log.info("QuestionController, deleteById");
        questionService.deleteById(id);
        return ResponseEntity.ok("Question is deleted");
    }

}
