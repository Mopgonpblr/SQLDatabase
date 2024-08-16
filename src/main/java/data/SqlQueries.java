package data;

public class SqlQueries {
    public static final String SAVE_USERS = "INSERT INTO users VALUES (?, ?, ?);";
    public static final String FETCH_USERS = "SELECT * FROM users WHERE id = ?;";
    public static final String DELETE_USERS = "DELETE FROM users WHERE EXISTS (SELECT * FROM users WHERE id = ?);";

    public static final String SAVE_TICKETS = "INSERT INTO tickets VALUES (?, ?, ?::ticket_type, ?);";
    public static final String FETCH_TICKETS_BY_ID = "SELECT * from tickets WHERE id = ?;";
    public static final String FETCH_TICKETS_BY_USER_ID = "SELECT * from tickets WHERE user_id = ?;";
    public static final String UPDATE_TICKET_TYPE = "UPDATE tickets SET ticket_type = ?::ticket_type WHERE id = ?;";
    public static final String DELETE_TICKETS = "DELETE FROM tickets WHERE EXISTS (SELECT * FROM tickets WHERE id = ?);";
}
