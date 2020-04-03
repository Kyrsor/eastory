package by.minsk.impl;

import by.minsk.converters.TopicConverter;
import by.minsk.dto.TopicDTO;
import by.minsk.entity.Language;
import by.minsk.entity.Topic;
import by.minsk.intefaces.TopicService;
import by.minsk.repository.TopicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TopicServiceImpl implements TopicService {

    private TopicConverter topicConverter;
    private TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicConverter topicConverter, TopicRepository topicRepository) {
        this.topicConverter = topicConverter;
        this.topicRepository = topicRepository;
    }

    public List<TopicDTO> getAll() {
        log.info("TopicServiceImpl, getAll");
        return topicRepository.findAll()
                              .stream()
                              .map(topicConverter::convertToDTO)
                              .collect(Collectors.toList());

    }

    public TopicDTO getById(int id) {
        log.info("TopicServiceImpl, getById");

        Topic topic = topicRepository.findOne(id);

        if (topic == null) {

            throw new EntityNotFoundException("Cannot find topic by this parameter");

        }

        return topicConverter.convertToDTO(topic);

    }

    public TopicDTO getByName(String topicText) {
        log.info("TopicServiceImpl, getByName");
        Topic topic = topicRepository.findTopicByTopicText(topicText);

        if (topic == null) {

            throw new EntityNotFoundException("Cannot find topic by this parameter");
        }

        return topicConverter.convertToDTO(topic);

    }

    public TopicDTO create(TopicDTO topicDTO) {
        log.info("TopicServiceImpl, create");
        Topic topic = topicConverter.convertToEntity(topicDTO);

        topic = topicRepository.save(topic);

        return topicConverter.convertToDTO(topic);
    }

    public TopicDTO update(TopicDTO topicDTO) {
        log.info("TopicServiceImpl, update");
        Topic topic = topicRepository.findOne(topicDTO.getId());

        if (topic == null) {

            throw new EntityNotFoundException("No such language to update");

        }

        topic.setTopicText(topicDTO.getTopicText());

        topic = topicRepository.save(topic);

        return topicConverter.convertToDTO(topic);
    }


    public void deleteById(int id) {
        log.info("TopicServiceImpl, delete");

        topicRepository.deleteById(id);

    }

    public void deleteByTopicText(String topicText) {
        log.info("TopicServiceImpl, delete");

        topicRepository.deleteByTopicText(topicText);

    }
}
