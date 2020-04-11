package dao;

import entities.Topic;

import java.util.List;

public interface TopicDAO {
    public void createTopic(Topic topic);
    public void updateTopic(Topic topic);
    public List<Topic> getTopics();
    public Topic getTopicInfo(int id);
    public List<Topic> getTopicWithoutTrainer();
    public void deleteTopic(Topic topic);

}
