package by.minsk.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "tests")
public class Test {

    @Id
    @Column(name = "topic_id")
    int topicId;

    @Column(name = "question_id")
    int questionId;

}
