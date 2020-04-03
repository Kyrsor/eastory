package by.minsk.controllers;

import by.minsk.dto.QuestionDTO;
import by.minsk.impl.QuestionServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<QuestionDTO>> getAll() {
        log.info("QuestionController, getAll");
        List<QuestionDTO> cityDTOList = questionService.getAll();
        return new ResponseEntity<>(cityDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<QuestionDTO>> getAllByLanguageId(@PathVariable int id) {
        log.info("QuestionController, getAllByLanguageId");
        List<QuestionDTO> cityDTOList = questionService.getAllByLanguageId(id);
        return new ResponseEntity<>(cityDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<QuestionDTO> getById(@PathVariable int id) {
        log.info("QuestionController, getById");
        QuestionDTO questionDTO = questionService.getById(id);
        return new ResponseEntity<>(questionDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<QuestionDTO> create(@RequestBody QuestionDTO questionDTO) {
        log.info("QuestionController, create");
        QuestionDTO questionDTONew = questionService.create(questionDTO);
        return new ResponseEntity<>(questionDTONew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<QuestionDTO> update(@RequestBody QuestionDTO questionDTO) {
        log.info("QuestionController, update");
        QuestionDTO questionDTONew = questionService.update(questionDTO);
        return new ResponseEntity<>(questionDTONew, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        log.info("QuestionController, delete");
        questionService.deleteById(id);
        return ResponseEntity.ok("Question is deleted");
    }

}
