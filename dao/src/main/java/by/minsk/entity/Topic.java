package by.minsk.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "topics")
public class Topic {
    int id;
    String topicText;
}
