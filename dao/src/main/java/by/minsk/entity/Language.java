package by.minsk.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "languages")
public class Language {

    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "language")
    String languageText;

}
