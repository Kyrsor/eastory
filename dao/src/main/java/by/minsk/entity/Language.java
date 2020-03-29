package by.minsk.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "languages")
public class Language {

    int id;
    String languageText;


}
