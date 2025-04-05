package com.lms.mgmt.controller;


import com.lms.mgmt.dto.TopicDTO;
import com.lms.mgmt.service.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic-mgmt/v1")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/topics")
    public List<TopicDTO> getTopics() {
        return topicService.getTopics();
    }

    @GetMapping("/topics/{id}")
    public TopicDTO getTopic(@RequestParam Integer id) {
        return topicService.getTopicById(id).orElse(new TopicDTO());
    }

    @PostMapping("/topics")
    public TopicDTO addTopic(@RequestBody TopicDTO TopicDTO) {
        return topicService.saveTopic(TopicDTO);
    }

    @DeleteMapping("/topics/{id}")
    public void addTopic(@RequestParam Integer id) {
        topicService.deleteTopic(id);
    }


}
