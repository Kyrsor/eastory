package by.minsk.impl;

import by.minsk.converters.ResultConverter;
import by.minsk.converters.TestConverter;
import by.minsk.dto.ResultDTO;
import by.minsk.dto.TestDTO;
import by.minsk.entity.Result;
import by.minsk.entity.Test;
import by.minsk.intefaces.TestService;
import by.minsk.repository.QuestionRepository;
import by.minsk.repository.ResultRepository;
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
    private QuestionRepository questionRepository;
    private ResultRepository resultRepository;
    private ResultConverter resultConverter;

    @Autowired
    public TestServiceImpl(ResultConverter resultConverter,TestConverter testConverter, ResultRepository resultRepository, TestRepository testRepository, QuestionRepository questionRepository) {
        this.testConverter = testConverter;
        this.testRepository = testRepository;
        this.questionRepository = questionRepository;
        this.resultRepository = resultRepository;
        this.resultConverter=resultConverter;
    }

    @Override
    public void checkResults(ResultDTO resultDTO) {

        log.info("TestServiceImpl, checkResults");
        Result result = new Result();
        result.setId(0);
        result.setName(resultDTO.getName());
        result.setTopicId(resultDTO.getTopicId());
        result.setNumberOfAnswers(resultDTO.getRightAnswers());
        resultRepository.save(result);
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

    @Override
    public List<ResultDTO> findAllResults() {
        return resultRepository.findAll()
                .stream()
                .map(resultConverter::convertToDTO)
                .collect(Collectors.toList());
    }


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
