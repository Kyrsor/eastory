package by.minsk.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "languages", schema = "eastory")
public class Language {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "language")
    private String languageText;

}
