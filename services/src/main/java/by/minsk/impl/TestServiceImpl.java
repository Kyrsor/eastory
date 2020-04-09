package by.minsk.impl;

import by.minsk.converters.TestConverter;
import by.minsk.dto.TestDTO;
import by.minsk.entity.Test;
import by.minsk.intefaces.TestService;
import by.minsk.repository.TestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TestServiceImpl implements TestService {

    private TestConverter testConverter;
    private TestRepository testRepository;

    @Autowired
    public TestServiceImpl(TestConverter testConverter, TestRepository testRepository) {
        this.testConverter = testConverter;
        this.testRepository = testRepository;
    }

    @Override
    public Map<Integer, List<TestDTO>> findAll() {

        log.info("TestServiceImpl, findAll");

        return testRepository.findAll()
                             .stream()
                             .map(testConverter::convertToDTO)
                             .collect(Collectors.groupingBy(TestDTO::getTopicId));

    }

    @Override
    public List<TestDTO> findById(Integer id) {

        log.info("TestServiceImpl, findById");

        return testRepository.findAllByTopicId(id)
                             .stream()
                             .map(testConverter::convertToDTO)
                             .collect(Collectors.toList());

    }

    /* @Override
     public List<TestDTO> findByName(String testName) {
         log.info("TestServiceImpl, findByName");
         return null;
     }
 */
    @Override
    public List<TestDTO> create(List<TestDTO> testDTOList) {
        log.info("TestServiceImpl, create");
        List<Test> testList = new ArrayList<>();
        for (TestDTO testDTO : testDTOList) {
            testList.add(testConverter.convertToEntity(testDTO));
        }
        testList = testRepository.save(testList);

        testDTOList = new ArrayList<>();
        for (Test test : testList) {
            testDTOList.add(testConverter.convertToDTO(test));
        }
        return testDTOList;

    }

    @Override
    public List<TestDTO> update(List<TestDTO> testDTOList) {
        log.info("TestServiceImpl, update");
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        log.info("TestServiceImpl, deleteById");

        testRepository.deleteAllByTopicId(id);
    }
}
