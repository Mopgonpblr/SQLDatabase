package entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    private int id;

    @Column
    private String name;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private LocalDate creationDate;

    public User(){}
    public User(int id, String name){
        this.id = id;
        this.name = name;
        this.creationDate = LocalDate.now();
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        return this.id + " | " + this.name + " | " + this.creationDate;
    }
}
