package by.minsk.repository;

import by.minsk.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;



public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
