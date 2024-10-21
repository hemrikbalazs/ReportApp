package utils;

/**
 *
 * @author bhemrik
 */
public class Constants {

    public static final String CONNECTION_STRING;
    public static final String USERNAME;
    public static final String PASSWORD;
    public static final String IL_HANDLER_SELECT;

    static {
        CONNECTION_STRING = "jdbc:oracle:thin:@//localhost:1521/SKI_SCHOOL";
        USERNAME = "VIEW_USER";
        PASSWORD = "userpwd";
        IL_HANDLER_SELECT = "SELECT * FROM INSTRUCTORS_LESSONS WHERE "
                + "INST_ID = %d";
    }
    
}
