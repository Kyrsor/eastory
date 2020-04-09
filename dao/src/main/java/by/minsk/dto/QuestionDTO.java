package by.minsk.dto;

import lombok.Data;

@Data
public class QuestionDTO {

    private Integer id;

    private String questionText;

    private String answer1;

    private String answer2;

    private String answer3;

    private String answer4;

    private Integer rightAnswer;

    private byte[] image;

    private String description;

    private Integer languageId;

}
