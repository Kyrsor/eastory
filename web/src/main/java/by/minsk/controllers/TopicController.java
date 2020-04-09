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
    public ResponseEntity<List<TopicDTO>> findAll() {
        log.info("TopicController, findAll");

        return new ResponseEntity<>(topicService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TopicDTO> findById(@PathVariable Integer id) {
        log.info("TopicController, findById");
        return new ResponseEntity<>(topicService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TopicDTO> create(@RequestBody TopicDTO topicDTO) {
        log.info("TopicController, create");
        return new ResponseEntity<>(topicService.create(topicDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TopicDTO> update(@RequestBody TopicDTO topicDTO) {
        log.info("TopicController, update");
        return new ResponseEntity<>(topicService.update(topicDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        log.info("TopicController, deleteById");
        topicService.deleteById(id);
        return ResponseEntity.ok("Topic is deleted");
    }

    /*@DeleteMapping(value = "/{topicText}")
    public ResponseEntity deleteByTopicText(@PathVariable String topicText) {
        log.info("TopicController, delete");
        topicService.deleteByTopicText(topicText);
        return ResponseEntity.ok("Topic is deleted");
    }*/

}
