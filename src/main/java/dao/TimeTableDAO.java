package dao;

import entities.Lesson;
import entities.Topic;

import java.util.List;

public interface TimeTableDAO {

    //create elements in database representation

    void createTimeTable(Lesson lesson);

    //update elements in database representation
    void updateTimeTable(Lesson timetable);

    //read elements from database representation
    List<Lesson> showAllTimeTables();

    //show List of timetables for one topic
    public List<Lesson> showLessonsForTopic(Topic topic);

    //show Lesson info from db
    Lesson getTimeTable(Lesson lesson);

    // delete element
    void deleteTimeTable(Lesson lesson);
}
