import dto.ScheduleDTO;
import service.ScheduleService;

import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        ScheduleService ss = new ScheduleService();
        List<ScheduleDTO> listForStudents = ss.getStudentSchedule("6549836");

        System.out.println("************************************");
        for (ScheduleDTO s: listForStudents
             ) {
            System.out.println(s.toString());
        }
        System.out.println("************************************");
        List<ScheduleDTO> listForTrainers = ss.getTrainerSchedule("54584357");
        for (ScheduleDTO s: listForTrainers
        ) {
            System.out.println(s.toString());
        }
        System.out.println("************************************");
    }
}
