package by.minsk.controllers;

import by.minsk.dto.TestDTO;
import by.minsk.impl.TestServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/test")
@Api
public class TestController {

    private TestServiceImpl testService;

    @Autowired
    public TestController(TestServiceImpl testService) {
        this.testService = testService;
    }


    @GetMapping
    public ResponseEntity<Map<Integer, List<TestDTO>>> getAll() {
        log.info("TestController, getAll");
        Map<Integer, List<TestDTO>> testDTOMap = testService.getAll();
        return new ResponseEntity<>(testDTOMap, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<TestDTO>> getById(@PathVariable int id) {
        log.info("TestController, getById");
        List<TestDTO> testDTOList = testService.getById(id);
        return new ResponseEntity<>(testDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{testName}")
    public ResponseEntity<List<TestDTO>> getByName(@PathVariable String testName) {
        log.info("TestController, getByName");
        List<TestDTO> testDTOList = testService.getByName(testName);
        return new ResponseEntity<>(testDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<TestDTO>> create(@RequestBody List<TestDTO> testDTOList) {
        log.info("TestController, create");
        List<TestDTO> testDTOsNew = testService.create(testDTOList);
        return new ResponseEntity<>(testDTOsNew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<List<TestDTO>> update(@RequestBody List<TestDTO> testDTOList) {
        log.info("TestController, update");
        List<TestDTO> testDTONew = testService.update(testDTOList);
        return new ResponseEntity<>(testDTONew, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        log.info("TestController, delete");
        testService.deleteById(id);
        return ResponseEntity.ok("Test is deleted");
    }

}
