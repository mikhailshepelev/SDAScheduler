package dao;

import entities.Topic;

import java.util.List;

public interface TopicDAO {

    //create elements in database representation
    void createTopic(Topic topic);

    //update elements in database representation
    void updateTopic(Topic topic);

    //read elements from database representation
    List<Topic> getTopics();
    Topic getTopicInfo(Topic topic);

    // delete course
    void deleteTopic(Topic topic);
}
