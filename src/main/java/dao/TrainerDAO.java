package dao;

import entities.Topic;
import entities.Trainer;

import java.util.List;

public interface TrainerDAO {

    void createTrainer(Trainer trainer);

    List<Trainer> getFullListOfTrainers();

    List<Topic> getListOfTopics(int trainerID);

    void deleteTrainer(int trainerID);

    void addTrainerToTopic(int trainerID, int topicID);

    void removeTrainerFromTopic(int trainerID);
}
