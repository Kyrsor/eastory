package by.minsk.controllers;

import by.minsk.dto.ResultDTO;
import by.minsk.dto.TestDTO;
import by.minsk.entity.Result;
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
    public ResponseEntity<Map<Integer, List<TestDTO>>> findAll() {
        log.info("TestController, findAll");
        return new ResponseEntity<>(testService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/find_all_results")
    public ResponseEntity<?> findAllResults() {
        log.info("TestController, findAllResults");
        return new ResponseEntity<>(testService.findAllResults(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<TestDTO>> findById(@PathVariable Integer id) {
        log.info("TestController, findById");
        return new ResponseEntity<>(testService.findById(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<List<TestDTO>> create(@RequestBody List<TestDTO> testDTOList) {
        log.info("TestController, create");
        return new ResponseEntity<>(testService.create(testDTOList), HttpStatus.CREATED);
    }

    @PostMapping(value = "/check_results")
    public ResponseEntity checkResults(@RequestBody ResultDTO resultDTO) {
        log.info("TestController, checkResults");
        testService.checkResults(resultDTO);
        return ResponseEntity.ok("Result is saved");
    }

    @PutMapping
    public ResponseEntity<List<TestDTO>> update(@RequestBody List<TestDTO> testDTOList) {
        log.info("TestController, update");
        return new ResponseEntity<>(testService.update(testDTOList), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        log.info("TestController, deleteById");
        testService.deleteById(id);
        return ResponseEntity.ok("Test is deleted");
    }

}
