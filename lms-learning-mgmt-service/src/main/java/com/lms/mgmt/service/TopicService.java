package com.lms.mgmt.service;


import com.lms.mgmt.dto.TopicDTO;
import com.lms.mgmt.entity.Topic;
import com.lms.mgmt.mapper.GenericModelMapper;
import com.lms.mgmt.repository.TopicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TopicService {

    private final TopicRepository topicRepository;
    private final GenericModelMapper modelMapper;

    public TopicService(TopicRepository topicRepository, GenericModelMapper modelMapper) {
        this.topicRepository = topicRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<TopicDTO> getTopicById(Integer id) {
        Optional<Topic> Topic = topicRepository.findById(id);
        if (Topic.isPresent()) {
            TopicDTO TopicDTO = modelMapper.map(Topic.get(), TopicDTO.class);
            return Optional.of(TopicDTO);
        }
        return Optional.empty();
    }

    public List<TopicDTO> getTopics() {
        List<Topic> Topics = topicRepository.findAll();
        List<TopicDTO> TopicDto = modelMapper.map(Topics, List.class);
        return TopicDto;
    }

    public TopicDTO saveTopic(TopicDTO TopicDTO) {
        Topic Topic = modelMapper.map(TopicDTO, Topic.class);
        Topic = topicRepository.save(Topic);
        TopicDTO = modelMapper.map(Topic, TopicDTO.class);
        return TopicDTO;
    }

    public void deleteTopic(Integer id) {
        Topic topic = new Topic();
        topic.setTopicId(id);
        topicRepository.delete(topic);
    }

}
