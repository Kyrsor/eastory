package by.minsk.repository;

import by.minsk.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

    List<Test> findAllByTopicId(Integer id);

    void deleteAllByTopicId(Integer id);


}
