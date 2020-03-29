package by.minsk.impl;

import by.minsk.dto.TestDTOs;
import by.minsk.intefaces.TestService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
public class TestServiceImpl implements TestService {
    public List<TestDTOs> getAll() {
        log.info("TestServiceImpl, getAll");
        return null;
    }

    public TestDTOs getById(int id) {
        log.info("TestServiceImpl, getById");
        return null;
    }

    public TestDTOs getByName(String testName) {
        log.info("TestServiceImpl, getByName");
        return null;
    }

    public TestDTOs create(TestDTOs testDTOs) {
        log.info("TestServiceImpl, create");
        return null;
    }

    public TestDTOs update(TestDTOs testDTOs) {
        log.info("TestServiceImpl, update");
        return null;
    }

    public void delete(int id) {
        log.info("TestServiceImpl, delete");

    }
}
