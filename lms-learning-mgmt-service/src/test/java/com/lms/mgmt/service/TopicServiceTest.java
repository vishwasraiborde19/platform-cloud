package com.lms.mgmt.service;


import com.lms.mgmt.base.BaseIntegrationTest;
import com.lms.mgmt.base.DataHelper;
import com.lms.mgmt.dto.TopicDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class TopicServiceTest extends BaseIntegrationTest {

    @Autowired
    TopicService topicService;

    @Test
    void getUserById() {
    }

    @Test
    void getTopics() {
        List<TopicDTO> users = DataHelper.getTopics();
        for (TopicDTO topicDTO : users) {
            topicDTO = topicService.saveTopic(topicDTO);
            log.info("user data is persisted [{}]", topicDTO.toString());
        }
        List<TopicDTO> usersRetrieved = topicService.getTopics();
        assertTrue(usersRetrieved.size() >= 10);
    }

    @Test
    void saveTopic() {
        List<TopicDTO> users = DataHelper.getTopics();
        for (TopicDTO topicDTO : users) {
            topicDTO = topicService.saveTopic(topicDTO);
            log.info("user data is persisted [{}]", topicDTO.toString());
        }
        assertNotNull(topicService.getTopicById(5));
    }

    @Test
    void deleteTopic() {
        List<TopicDTO> users = DataHelper.getTopics();
        for (TopicDTO topicDTO : users) {
            topicDTO = topicService.saveTopic(topicDTO);
            log.info("user data is persisted [{}]", topicDTO.toString());
        }
        topicService.deleteTopic(5);
        Optional<TopicDTO> TopicDTO = topicService.getTopicById(5);
        assertEquals(TopicDTO.isPresent(), Boolean.FALSE);
    }

}