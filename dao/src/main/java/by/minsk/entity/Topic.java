package by.minsk.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "topics", schema = "eastory")
public class Topic {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "topic")
    private String topicText;

}
