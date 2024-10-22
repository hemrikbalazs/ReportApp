package models;

/**
 *
 * @author bhemrik
 */
public class Statistic {
    private final String firstName;
    private final String lastName;
    private final String season;
    private final int lessonCount;
    private final int hoursWorked;
    private final double averageStudentAge;

    public Statistic(String firstName, String lastName, String season, 
            int lessonCount, int hoursWorked, double averageStudentAge) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.season = season;
        this.lessonCount = lessonCount;
        this.hoursWorked = hoursWorked;
        this.averageStudentAge = averageStudentAge;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSeason() {
        return season;
    }

    public int getLessonCount() {
        return lessonCount;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getAverageStudentAge() {
        return averageStudentAge;
    }
}
