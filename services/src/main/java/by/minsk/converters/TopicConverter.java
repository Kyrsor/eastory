package by.minsk.converters;

import by.minsk.dto.TopicDTO;
import by.minsk.entity.Topic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TopicConverter {
    public TopicDTO convertToDTO(Topic topic) {

        log.info("TopicConverter, convertToDTO");

        int id = topic.getId();

        String topicText = topic.getTopicText();

        TopicDTO topicDTO = new TopicDTO();

        topicDTO.setId(id);

        topicDTO.setTopicText(topicText);

        return topicDTO;

    }

    public Topic convertToEntity(TopicDTO topicDTO) {

        log.info("TopicConverter, convertToDTO");

        int id = topicDTO.getId();

        String topicText = topicDTO.getTopicText();

        Topic topic = new Topic();

        topic.setId(id);

        topic.setTopicText(topicText);

        return topic;

    }
}
