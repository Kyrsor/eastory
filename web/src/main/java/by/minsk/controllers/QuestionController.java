package by.minsk.controllers;

import by.minsk.dto.QuestionDTO;
import by.minsk.impl.QuestionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionServiceImpl questionService;

    @Autowired
    public QuestionController(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public ResponseEntity<List<QuestionDTO>> getAll() {
        List<QuestionDTO> cityDTOList = questionService.getAll();
        return new ResponseEntity<>(cityDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<QuestionDTO>> getAllByLanguageId(@PathVariable int id) {
        List<QuestionDTO> cityDTOList = questionService.getAllByLanguageId(id);
        return new ResponseEntity<>(cityDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<QuestionDTO> getById(@PathVariable int id) {
        QuestionDTO questionDTO = questionService.getById(id);
        return new ResponseEntity<>(questionDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<QuestionDTO> create(@RequestBody QuestionDTO questionDTO) {
        QuestionDTO questionDTONew = questionService.create(questionDTO);
        return new ResponseEntity<>(questionDTONew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<QuestionDTO> update(@RequestBody QuestionDTO questionDTO) {
        QuestionDTO questionDTONew = questionService.update(questionDTO);
        return new ResponseEntity<>(questionDTONew, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        questionService.delete(id);
        return ResponseEntity.ok("Question is deleted");
    }

}
