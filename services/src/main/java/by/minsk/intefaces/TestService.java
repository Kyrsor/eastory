package by.minsk.intefaces;

import by.minsk.dto.ResultDTO;
import by.minsk.dto.TestDTO;

import java.util.List;
import java.util.Map;

public interface TestService {

    Map<Integer, List<TestDTO>> findAll();

    List<TestDTO> findById(Integer id);

    List<ResultDTO> findAllResults();

    List<TestDTO> create(List<TestDTO> testDTOList);

    List<TestDTO> update(List<TestDTO> testDTOList);

    void deleteById(Integer id);

    void checkResults(ResultDTO resultDTO);
}
