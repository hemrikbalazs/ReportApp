package persistence;

import utils.Converter;
import utils.Constants;
import entities.InstructorsLesson;
import exceptions.PersistenceException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bhemrik
 */
public class InstructorsLessonHandler {

    public List<InstructorsLesson> selectAllWhere(int filter)
            throws PersistenceException {
        String queryString = String.format(Constants.IL_HANDLER_SELECT, filter);
        return executeQuery(queryString);
    }
    private List<InstructorsLesson> executeQuery(String queryString)
            throws PersistenceException{
        List<InstructorsLesson> result = null;
        try (Statement statement = SqlConnection.getConnection()
                .createStatement(); ResultSet resultSet = statement
                .executeQuery(queryString)){
            result = getResultFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
        return result;
    }
    
    private List<InstructorsLesson> getResultFromResultSet(ResultSet resultSet) throws SQLException {
        List<InstructorsLesson> result = new ArrayList<>();
        InstructorsLesson temp;
        while (resultSet.next()) {
            temp = createInstructorsLesson(resultSet);
            result.add(temp);
        }
        return result;
    }

    private InstructorsLesson createInstructorsLesson(ResultSet resultSet)
            throws SQLException {
        int instructorLessonID = resultSet.getInt(1);
        int lessonID = resultSet.getInt(2);
        LocalDateTime dateTime = Converter.toLocalDateTime(resultSet.getString(3));
        Duration duration = Converter.toDuration(resultSet.getString(4));
        int classID = resultSet.getInt(5);
        String className = resultSet.getString(6);
        int studentCount = resultSet.getInt(7);
        double avrageStudentAge = resultSet.getDouble(8);
        int instructorID = resultSet.getInt(9);
        String instructorFirstName = resultSet.getString(10);
        String instructorLastName = resultSet.getString(11);
        String instructorJobTitle = resultSet.getString(12);
        int instructorBaseSalaryHuf = resultSet.getInt(13);
        Duration instructorHours = Converter.toDuration(resultSet.getString(14));
        boolean overtime = Converter.toBoolean(resultSet.getInt(15));
        int instructorHourlyRate = resultSet.getInt(16);
        return new InstructorsLesson(instructorLessonID, lessonID, dateTime,
                duration, classID, className, studentCount, avrageStudentAge,
                instructorID, instructorFirstName, instructorLastName,
                instructorJobTitle, instructorBaseSalaryHuf, instructorHours,
                overtime, instructorHourlyRate);
    }

}
