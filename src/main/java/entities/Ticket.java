package entities;

import enums.TicketType;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.time.LocalDate;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "ticket_type")
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private TicketType ticketType;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private LocalDate creationDate;

    public Ticket(){}
    public Ticket(int id, int userId, TicketType ticketType){
        this.id = id;
        this.userId = userId;
        this.ticketType = ticketType;
        this.creationDate = LocalDate.now();
    }

    public void setTicketType(TicketType ticketType){
        this.ticketType = ticketType;
    }

    public String toString(){
        return this.id + " | " + this.userId + " | " + this.ticketType + " | " + this.creationDate;
    }
}
