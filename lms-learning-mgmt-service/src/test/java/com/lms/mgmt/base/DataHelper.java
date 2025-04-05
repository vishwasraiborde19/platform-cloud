package com.lms.mgmt.base;



import com.lms.mgmt.dto.TopicDTO;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {

    public static TopicDTO getTopic() {
        TopicDTO topicDTO = new TopicDTO();
       // topicDTO.setTopicId(1);
        topicDTO.setTopicName("Test Topic");
        topicDTO.setTopicDescription("Test Description");
        topicDTO.setTopicStatus("ACTIVE");
        topicDTO.setLink("https://lms.mgmt.com");
        return topicDTO;
    }

    public static List<TopicDTO> getTopics() {
        int id = 1;
        List<TopicDTO> userDTOList = new ArrayList<>();
        for(int i= id ; id<=10 ; id ++) {
            TopicDTO topicDTO = new TopicDTO();
            //topicDTO.setTopicId(id);
            topicDTO.setTopicName("Test Topic");
            topicDTO.setTopicDescription("Test Description");
            topicDTO.setTopicStatus("ACTIVE");
            topicDTO.setLink("https://lms.mgmt.com");
            userDTOList.add(topicDTO);
        }
        return userDTOList;
    }
}
