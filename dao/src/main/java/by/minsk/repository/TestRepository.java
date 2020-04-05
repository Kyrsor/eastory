package by.minsk.repository;

import by.minsk.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

    List<Test> findAllByTopicId(int id);


    void deleteAllByTopicId(int id);


}
