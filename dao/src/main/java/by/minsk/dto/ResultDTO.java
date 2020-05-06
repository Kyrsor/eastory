package by.minsk.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResultDTO {

    private String name;
    private Integer topicId;
    private List<AnswerDTO> answerDTOList = new ArrayList<>();
}
