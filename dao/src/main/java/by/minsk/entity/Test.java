package by.minsk.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "tests")
public class Test {

    @Column(name = "topic_id")
    int topicId;

    @Column(name = "question_id")
    int questionId;

}
