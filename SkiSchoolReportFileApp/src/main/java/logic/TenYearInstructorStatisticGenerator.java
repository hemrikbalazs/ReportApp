package logic;

import entities.InstructorsLesson;
import exceptions.PersistenceException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import persistence.InstructorsLessonHandler;

/**
 *
 * @author bhemrik
 */
public class TenYearInstructorStatisticGenerator {
    
    private final InstructorsLessonHandler handler;
    private final List<InstructorsLesson> lessons;

    public TenYearInstructorStatisticGenerator(int filter)
            throws PersistenceException {
        handler = new InstructorsLessonHandler();
        lessons = handler.selectAllWhere(filter);
    }

    public List<YearlyInstructorStatistic> getTenYearInstructorStatistics() {
        List<YearlyInstructorStatistic> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            LocalDate seasonEnd = calculateSeasonEnd(i);
            List<InstructorsLesson> lessonsSubList = createSubList(seasonEnd);
            YearlyInstructorStatistic statistic = createStatistic(
                    lessonsSubList, seasonEnd);
            result.add(statistic);
        }
        return result;
    }

    private List<InstructorsLesson> createSubList(LocalDate seasonEnd) {
        List<InstructorsLesson> result = new ArrayList<>();
        LocalDate seasonStart = seasonEnd.minusYears(1);
        for (InstructorsLesson lesson : lessons) {
            LocalDate lessonDate = lesson.getLocalDateTime().toLocalDate();
            if (isBetweenDates(lessonDate, seasonEnd, seasonStart)) {
                result.add(lesson);
            }
        }
        return result;
    }

    private LocalDate calculateSeasonEnd(int yearIndex) {
        LocalDate now = LocalDate.now();
        LocalDate firstSeasonEnd = LocalDate.of(now.getYear(), 7, 1);
        if (now.isBefore(firstSeasonEnd)) {
            firstSeasonEnd = firstSeasonEnd.minusYears(1);
        }
        return firstSeasonEnd.minusYears(yearIndex);
    }

    private boolean isBetweenDates(LocalDate lessonDate, LocalDate end,
            LocalDate start) {
        boolean afterStart = lessonDate.isAfter(start);
        boolean beforeEnd = lessonDate.isBefore(end);
        return afterStart && beforeEnd;
    }

    private YearlyInstructorStatistic createStatistic(
            List<InstructorsLesson> lessonsSubList, LocalDate seasonEnd) {
        YearlyInstructorStatistic result = null;
        if (!lessonsSubList.isEmpty()) {
            String season = createSeasonString(seasonEnd);
            String firstName = lessonsSubList.get(0).getInstructorFirstName();
            String lastName = lessonsSubList.get(0).getInstructorLastName();
            int lessonCount = 0;
            Duration hoursWorked = Duration.ZERO;
            double averageStudentAge = 0;
            for (InstructorsLesson lesson : lessonsSubList) {
                lessonCount += 1;
                hoursWorked = hoursWorked.plus(lesson.getDuration());
                averageStudentAge += lesson.getAvrageStudentAge();
            }
            averageStudentAge = Math.round(
                    (averageStudentAge/lessonCount) * 100) / 100.0;
            result = new YearlyInstructorStatistic(firstName, lastName, season, 
                    lessonCount, hoursWorked, averageStudentAge);
        }
        return result;
    }

    private String createSeasonString(LocalDate seasonEnd) {
        int seasonEndAsYear = seasonEnd.getYear() % 100;
        int seasonStartAsYear = seasonEndAsYear - 1;
        return Integer.toString(seasonStartAsYear) + "/" + Integer.toString(
                seasonEndAsYear);
    }

}
