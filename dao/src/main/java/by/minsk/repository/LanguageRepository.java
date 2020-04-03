package by.minsk.repository;

import by.minsk.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {


    Language findLanguageByLanguageText(String languageText);

    void deleteByLanguageText(String languageText);

    void deleteById(int id);
}
