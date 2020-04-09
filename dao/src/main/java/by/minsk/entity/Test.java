package by.minsk.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "tests", schema = "eastory")
public class Test {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "topic_id")
    private Integer topicId;

    @Column(name = "question_id")
    private Integer questionId;

}
