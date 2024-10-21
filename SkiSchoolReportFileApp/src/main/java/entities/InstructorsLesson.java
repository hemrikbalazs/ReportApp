package entities;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author bhemrik
 */
public class InstructorsLesson {
    
    private final int instructorLessonID;
    private final int lessonID;
    private final LocalDateTime dateTime;
    private final Duration duration;
    private final int classID;
    private final String className;
    private final int studentCount;
    private final double avrageStudentAge;
    private final int instructorID;
    private final String instructorFirstName;
    private final String instructorLastName;
    private final String instructorJobTitle;
    private final int instructorBaseSalaryHuf;
    private final Duration instructorHours;
    private final boolean overtime;
    private final Integer instructorHourlyRate;

    public InstructorsLesson(int instructorLessonID, int lessonID,
            LocalDateTime localDateTime, Duration duration, int classID,
            String className, int studentCount, double avrageStudentAge,
            int instructorID, String instructorFirstName,
            String instructorLastName, String instructorJobTitle,
            int instructorBaseSalaryHuf, Duration instructorHours,
            boolean overtime, Integer instructorHourlyRate) {
        this.instructorLessonID = instructorLessonID;
        this.lessonID = lessonID;
        this.dateTime = localDateTime;
        this.duration = duration;
        this.classID = classID;
        this.className = className;
        this.studentCount = studentCount;
        this.avrageStudentAge = avrageStudentAge;
        this.instructorID = instructorID;
        this.instructorFirstName = instructorFirstName;
        this.instructorLastName = instructorLastName;
        this.instructorJobTitle = instructorJobTitle;
        this.instructorBaseSalaryHuf = instructorBaseSalaryHuf;
        this.instructorHours = instructorHours;
        this.overtime = overtime;
        this.instructorHourlyRate = instructorHourlyRate;
    }

    public int getInstructorLessonID() {
        return instructorLessonID;
    }

    public int getLessonID() {
        return lessonID;
    }

    public LocalDateTime getLocalDateTime() {
        return dateTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public int getClassID() {
        return classID;
    }

    public String getClassName() {
        return className;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public double getAvrageStudentAge() {
        return avrageStudentAge;
    }

    public int getInstructorID() {
        return instructorID;
    }

    public String getInstructorFirstName() {
        return instructorFirstName;
    }

    public String getInstructorLastName() {
        return instructorLastName;
    }

    public String getInstructorJobTitle() {
        return instructorJobTitle;
    }

    public int getInstructorBaseSalaryHuf() {
        return instructorBaseSalaryHuf;
    }

    public Duration getInstructorHours() {
        return instructorHours;
    }

    public boolean isOvertime() {
        return overtime;
    }

    public Integer getInstructorHourlyRate() {
        return instructorHourlyRate;
    }
    
}
