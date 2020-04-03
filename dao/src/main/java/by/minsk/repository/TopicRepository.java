package by.minsk.repository;

import by.minsk.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {

    Topic findTopicByTopicText(String topicText);

    void deleteById(int id);

    void deleteByTopicText(String topicText);

}
