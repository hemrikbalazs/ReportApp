package persistence;

import utils.Constants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bhemrik
 */
class SqlConnection {

    private static Connection connection;

    public static Connection getConnection() throws SQLException{
        if (connection == null){
            connection = DriverManager.getConnection(Constants.CONNECTION_STRING, 
                    Constants.USERNAME, Constants.PASSWORD);
        }
        return connection;
    }
}
