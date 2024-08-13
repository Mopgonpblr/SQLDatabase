package dao;
import data.SqlQueries;

import java.sql.*;
import java.time.LocalDate;

public class UserDao extends Dao {

    public UserDao(Connection connection) {
        super(connection);
    }

    public void saveUsers(int id, String name) {

        executeStatement(String.format(SqlQueries.SAVEUSERS, id, name, LocalDate.now()));
    }

    public void fetchUsers(int id) throws SQLException {
        ResultSet resultSet = executeQuery(String.format(SqlQueries.FETCHUSERS, id));

        System.out.println("ID| Name | Creation Date");
        System.out.println("------------------------------------------------");
        while (resultSet != null && resultSet.next()) {
            String columnValue = resultSet.getString("id") +
                    " | " + resultSet.getString("name") +
                    " | " + resultSet.getString("creation_date");
            System.out.println(columnValue);
            System.out.println("------------------------------------------------");
        }
    }

    public void deleteUsers(int id) {
        executeStatement(String.format(SqlQueries.DELETEUSERS, id));
    }
}