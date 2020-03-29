package by.minsk.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "tests")
public class Test {
    int topicId;
    int questionId;


}
