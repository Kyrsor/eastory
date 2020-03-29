package by.minsk.intefaces;

import by.minsk.dto.TopicDTO;

import java.util.List;

public interface TopicService {

    List<TopicDTO> getAll();

    TopicDTO getById(int id);

    TopicDTO getByName(String topicText);

    TopicDTO create(TopicDTO topicDTO);

    TopicDTO update(TopicDTO topicDTO);

    void delete(int id);

}
