package by.minsk.controllers;

import by.minsk.dto.LanguageDTO;
import by.minsk.dto.TestDTOs;
import by.minsk.impl.TestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    private TestServiceImpl testService;

    @Autowired
    public TestController(TestServiceImpl testService) {
        this.testService = testService;
    }


    @GetMapping
    public ResponseEntity<List<TestDTOs>> getAll() {
        List<TestDTOs> languageDTOList = testService.getAll();
        return new ResponseEntity<>(languageDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TestDTOs> getById(@PathVariable int id) {
        TestDTOs testDTOs = testService.getById(id);
        return new ResponseEntity<>(testDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "/{testName}")
    public ResponseEntity<TestDTOs> getByName(@PathVariable String testName) {
        TestDTOs testDTOs = testService.getByName(testName);
        return new ResponseEntity<>(testDTOs, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<TestDTOs> create(@RequestBody TestDTOs testDTOs) {
        TestDTOs testDTOsNew = testService.create(testDTOs);
        return new ResponseEntity<>(testDTOsNew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TestDTOs> update(@RequestBody TestDTOs testDTOs) {
        TestDTOs testDTOsNew = testService.update(testDTOs);
        return new ResponseEntity<>(testDTOsNew, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity  delete(@PathVariable int id) {
        testService.delete(id);
        return ResponseEntity.ok("Test is deleted");
    }

}
