package by.minsk.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;


@Data
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "question")
    String questionText;

    @Column(name = "answer_1")
    String answer1;

    @Column(name = "answer_2")
    String answer2;

    @Column(name = "answer_3")
    String answer3;

    @Column(name = "answer_4")
    String answer4;

    @Column(name = "right_answer")
    int rightAnswer;

    @Column(name = "image")
    Blob image;

    @Column(name = "description")
    String description;

    @Column(name = "language_id")
    int languageId;



}
