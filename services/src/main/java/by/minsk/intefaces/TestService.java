package by.minsk.intefaces;

import by.minsk.dto.TestDTOs;

import java.util.List;

public interface TestService {
    List<TestDTOs> getAll();

    TestDTOs getById(int id);

    TestDTOs getByName(String testName);

    TestDTOs create(TestDTOs testDTOs);

    TestDTOs update(TestDTOs testDTOs);

    void delete(int id);


}
