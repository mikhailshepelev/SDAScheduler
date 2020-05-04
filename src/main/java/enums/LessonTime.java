package enums;

public enum LessonTime {
    SHORT ("09.00 - 12.00"),
    LONG ("09.00 - 16.00"),
    HRCLASS ("18.30 - 21.30"),
    EMPTY("");

    public String time;

    LessonTime(String time) {
        this.time = time;
    }
}
