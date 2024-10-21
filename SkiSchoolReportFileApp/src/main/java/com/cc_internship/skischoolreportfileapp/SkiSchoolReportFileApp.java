package com.cc_internship.skischoolreportfileapp;

import exceptions.PersistenceException;
import java.io.IOException;
import java.util.List;
import logic.TenYearInstructorStatisticGenerator;
import logic.YearlyInstructorStatistic;

/**
 *
 * @author bhemrik
 */
public class SkiSchoolReportFileApp {

    public static void main(String[] args) 
            throws PersistenceException, IOException {
       
        int instructorId = checkArgs(args);
        TenYearInstructorStatisticGenerator generator
                = new TenYearInstructorStatisticGenerator(instructorId);
        List<YearlyInstructorStatistic> stats
                = generator.getTenYearInstructorStatistics();
        StatisticsWriter statWriter = new StatisticsWriter(stats);
        statWriter.writeToFile();
    }

    private static int checkArgs(String[] args) {
        int result = 0;
        if (args.length > 0) {
            String arg = args[0];
            if (arg.matches("\\d+")) {
                result = Integer.parseInt(arg);
            }
        }
        return result;
    }

}
