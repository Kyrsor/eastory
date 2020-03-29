package by.minsk.impl;

import by.minsk.dto.TopicDTO;
import by.minsk.intefaces.TopicService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
public class TopicServiceImpl implements TopicService {
    public List<TopicDTO> getAll() {
        log.info("TopicServiceImpl, getAll");
        return null;
    }

    public TopicDTO getById(int id) {
        log.info("TopicServiceImpl, getById");
        return null;
    }

    public TopicDTO getByName(String topicText) {
        log.info("TopicServiceImpl, getByName");
        return null;
    }

    public TopicDTO create(TopicDTO topicDTO) {
        log.info("TopicServiceImpl, create");
        return null;
    }

    public TopicDTO update(TopicDTO topicDTO) {
        log.info("TopicServiceImpl, update");
        return null;
    }


    public void delete(int id) {
        log.info("TopicServiceImpl, delete");

    }
}
