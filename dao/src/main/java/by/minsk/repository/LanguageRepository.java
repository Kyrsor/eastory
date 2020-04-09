package by.minsk.repository;

import by.minsk.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {


    @Transactional
    void deleteById(Integer id);
}
