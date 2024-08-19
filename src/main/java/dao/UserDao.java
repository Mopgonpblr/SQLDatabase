package dao;

import data.SqlQueries;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class UserDao {

    private final DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void saveUsers(int id, String name) throws SQLException {
        try (PreparedStatement preparedStatement
                     = dataSource.getConnection().prepareStatement(SqlQueries.SAVE_USERS)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setDate(3, Date.valueOf(LocalDate.now()));
            preparedStatement.execute();
        }
    }

    public void fetchUsers(int id) throws SQLException {
        try (PreparedStatement preparedStatement
                     = dataSource.getConnection().prepareStatement(SqlQueries.FETCH_USERS)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet != null && resultSet.next()) {
                System.out.println("ID| Name | Creation Date");
                System.out.println("------------------------------------------------");

                String columnValue = resultSet.getString("id") +
                        " | " + resultSet.getString("name") +
                        " | " + resultSet.getString("creation_date");
                System.out.println(columnValue);
                System.out.println("------------------------------------------------");
            }
        }
    }


    public void deleteUsers(int id) throws SQLException {
        try (PreparedStatement preparedStatement
                     = dataSource.getConnection().prepareStatement(SqlQueries.DELETE_USERS)
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        }
    }
}