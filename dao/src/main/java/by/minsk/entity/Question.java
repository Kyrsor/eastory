package by.minsk.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "questions", schema = "eastory")
public class Question {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "question")
    private String questionText;

    @Column(name = "answer_1")
    private String answer1;

    @Column(name = "answer_2")
    private String answer2;

    @Column(name = "answer_3")
    private String answer3;

    @Column(name = "answer_4")
    private String answer4;

    @Column(name = "right_answer")
    private Integer rightAnswer;

    @Column(name = "image")

    private byte[] image;

    @Column(name = "description")
    private String description;

    @Column(name = "language_id")
    private Integer languageId;

}
