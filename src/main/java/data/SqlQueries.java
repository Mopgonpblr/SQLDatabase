package data;

import java.time.LocalDate;

public class SqlQueries {
    public static final String SAVEUSERS = "INSERT INTO users VALUES (%d,'%s','%s');";
    public static final String FETCHUSERS = "SELECT * FROM users WHERE id = %d;";
    public static final String DELETEUSERS = "DELETE FROM users WHERE EXISTS (SELECT * FROM users WHERE id = %d);";

    public static final String SAVETICKETS = "INSERT INTO tickets VALUES (%d, %d, '%s', '%s');";
    public static final String FETCHTICKETS = "SELECT * from tickets WHERE id = %d AND user_id = %d;";
    public static final String UPDATETICKETTYPE = "UPDATE tickets SET ticket_type ='%s' WHERE id = %d;";
    public static final String DELETETICKETS = "DELETE FROM tickets WHERE EXISTS (SELECT * FROM tickets WHERE id = %d);";
}
