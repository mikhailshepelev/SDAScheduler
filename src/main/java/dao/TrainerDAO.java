package dao;

import entities.Trainer;

import java.util.List;

public interface TrainerDAO {

    void createTrainer(Trainer trainer);

    List<Trainer> getFullListOfTrainers();

    List<Trainer> getListOfTrainersAndTopics();

    void deleteTrainer(int trainerID);

    void addTrainerToTopic(int trainerID, int topicID);

    void removeTrainerFromTopic(int trainerID);
}
