package com.cc_internship.skischoolreportfileapp;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import logic.YearlyInstructorStatistic;

/**
 *
 * @author bhemrik
 */
public class StatisticsWriter {
    
    private final List<YearlyInstructorStatistic> stats;

    public StatisticsWriter(List<YearlyInstructorStatistic> stats) {
        this.stats = stats;
    }
    
    public void writeToFile() throws IOException{
        String fileName = createFileName();
        FileWriter writer = new FileWriter(fileName);
        for (YearlyInstructorStatistic stat : stats) {
            if (stat != null) {
                writeStat(stat, writer);
            }
        }
        writer.close();
    }

    private String createFileName() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "yyyy-M-d__HH-mm-ss");
        String nowString = now.format(formatter);
        return "New_Statistic_" + nowString;
    }
    
    private void writeStat(YearlyInstructorStatistic stat, FileWriter writer) 
            throws IOException {
            writer.append("Season: " + stat.getSeason());
            writer.append(System.lineSeparator());
            writer.append("Instructor: " + stat.getFirstName() + " " 
                    + stat.getLastName());
            writer.append("Lesson Count: " + stat.getLessonCount());
            writer.append(System.lineSeparator());
            writer.append("Total Work Hours: " + stat.getHoursWorked());
            writer.append(System.lineSeparator());
            writer.append("Average Student Age: " + stat.getAverageStudentAge());
            writer.append(System.lineSeparator());
            writer.append(System.lineSeparator());
            writer.append(System.lineSeparator());
    }

}
