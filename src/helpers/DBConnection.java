package helpers;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {

    private final static String DB_USER = "root";
    private final static String DB_PASS = "bemobile04";
    private final static String DB_NAME = "epos";
    private final static String DB_SERVER = "localhost";

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        return connection == null ? createConnection() : connection;
    }

    private static Connection createConnection() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setServerName(DB_SERVER);
        dataSource.setUser(DB_USER);
        dataSource.setPassword(DB_PASS);
        dataSource.setDatabaseName(DB_NAME);

        return dataSource.getConnection();
    }


}
