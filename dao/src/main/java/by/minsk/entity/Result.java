package by.minsk.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "results", schema = "eastory")
public class Result {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "topic_id")
    private Integer topicId;
    @Column(name = "number_of_answers")
    private Integer numberOfAnswers;
}
