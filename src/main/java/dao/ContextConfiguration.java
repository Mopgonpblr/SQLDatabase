package dao;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

import org.springframework.core.*;

public class ContextConfiguration {

    public static DataSource dataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUser("username");
        dataSource.setPassword("password");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/my_ticket_service_db");
        return dataSource;
    }
}
