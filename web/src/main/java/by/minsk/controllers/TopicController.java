package by.minsk.controllers;

import by.minsk.dto.TopicDTO;
import by.minsk.impl.TopicServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/topic")
public class TopicController {

    private TopicServiceImpl topicService;

    @Autowired
    public TopicController(TopicServiceImpl topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public ResponseEntity<List<TopicDTO>> getAll() {
        List<TopicDTO> topicDTOList = topicService.getAll();
        return new ResponseEntity<>(topicDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TopicDTO> getById(@PathVariable int id) {
        TopicDTO topicDTO = topicService.getById(id);
        return new ResponseEntity<>(topicDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{topicText}")
    public ResponseEntity<TopicDTO> getByName(@PathVariable String topicText) {
        TopicDTO topicDTO = topicService.getByName(topicText);
        return new ResponseEntity<>(topicDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TopicDTO> create(@RequestBody TopicDTO topicDTO) {
        TopicDTO topicDTONew = topicService.create(topicDTO);
        return new ResponseEntity<>(topicDTONew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TopicDTO> update(@RequestBody TopicDTO topicDTO) {
        TopicDTO topicDTONew = topicService.update(topicDTO);
        return new ResponseEntity<>(topicDTONew, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        topicService.delete(id);
        return ResponseEntity.ok("Topic is deleted");
    }

}
