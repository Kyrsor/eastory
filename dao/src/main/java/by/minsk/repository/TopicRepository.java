package by.minsk.repository;

import by.minsk.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
    @Transactional
    void deleteById(Integer id);

}
