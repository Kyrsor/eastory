package by.minsk.controllers;

import by.minsk.dto.TopicDTO;
import by.minsk.impl.TopicServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/topic")
@Api
public class TopicController {

    private TopicServiceImpl topicService;

    @Autowired
    public TopicController(TopicServiceImpl topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public ResponseEntity<List<TopicDTO>> getAll() {
        log.info("TopicController, getAll");
        List<TopicDTO> topicDTOList = topicService.getAll();
        return new ResponseEntity<>(topicDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TopicDTO> getById(@PathVariable int id) {
        log.info("TopicController, getById");
        TopicDTO topicDTO = topicService.getById(id);
        return new ResponseEntity<>(topicDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{topicText}")
    public ResponseEntity<TopicDTO> getByName(@PathVariable String topicText) {
        log.info("TopicController, getByName");
        TopicDTO topicDTO = topicService.getByName(topicText);
        return new ResponseEntity<>(topicDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TopicDTO> create(@RequestBody TopicDTO topicDTO) {
        log.info("TopicController, create");
        TopicDTO topicDTONew = topicService.create(topicDTO);
        return new ResponseEntity<>(topicDTONew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TopicDTO> update(@RequestBody TopicDTO topicDTO) {
        log.info("TopicController, update");
        TopicDTO topicDTONew = topicService.update(topicDTO);
        return new ResponseEntity<>(topicDTONew, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        log.info("TopicController, delete");
        topicService.deleteById(id);
        return ResponseEntity.ok("Topic is deleted");
    }

    @DeleteMapping(value = "/{topicText}")
    public ResponseEntity deleteByTopicText(@PathVariable String topicText) {
        log.info("TopicController, delete");
        topicService.deleteByTopicText(topicText);
        return ResponseEntity.ok("Topic is deleted");
    }

}
