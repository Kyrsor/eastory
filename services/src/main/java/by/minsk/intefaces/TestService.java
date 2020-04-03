package by.minsk.intefaces;

import by.minsk.dto.TestDTO;

import java.util.List;
import java.util.Map;

public interface TestService {

    Map<Integer, List<TestDTO>> getAll();

    List<TestDTO> getById(int id);

    List<TestDTO> getByName(String testName);

    List<TestDTO> create(List<TestDTO> testDTOList);

    List<TestDTO> update(List<TestDTO> testDTOList);

    void deleteById(int id);

}
