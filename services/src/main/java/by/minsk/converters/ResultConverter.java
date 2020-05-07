package by.minsk.converters;

import by.minsk.dto.ResultDTO;
import by.minsk.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ResultConverter {
    public ResultDTO convertToDTO(Result result) {

        log.info("ResultConverter, convertToDTO");

        Integer id = result.getId();

        String name = result.getName();

        Integer rightAnswers=result.getNumberOfAnswers();

        Integer topicId=result.getTopicId();

        ResultDTO resultDTO = new ResultDTO();



        resultDTO.setName(name);
        resultDTO.setRightAnswers(rightAnswers);
        resultDTO.setTopicId(topicId);
        return resultDTO;

    }

}
