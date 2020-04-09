package by.minsk.intefaces;

import by.minsk.dto.TopicDTO;

import java.util.List;

public interface TopicService {

    List<TopicDTO> findAll();

    TopicDTO findById(Integer id);

    TopicDTO create(TopicDTO topicDTO);

    TopicDTO update(TopicDTO topicDTO);

    void deleteById(Integer id);
}
