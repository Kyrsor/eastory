package by.minsk.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Blob;


@Data
@Entity
@Table(name = "questions")
public class Question {

    int id;
    String questionText;
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    int rightAnswer;
    Blob image;
    String description;
    int languageId;


}
