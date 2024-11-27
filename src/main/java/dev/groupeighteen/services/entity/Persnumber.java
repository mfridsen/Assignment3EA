package dev.groupeighteen.services.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Johan Lund
 * @project Assignment3EA
 * @package dev.groupeighteen.persnummer.entity
 * @contact ojaulz-2@student.ltu.se
 * @created 2024-11-19
 */

/**
 * The Persnumber class represents the database table and is mapped using JPA annotations.
 * It acts as the model for the data your application handles.
 */

@Entity
@Table(name = "students")
public class Persnumber {
    @Id
    private String username;
    private String personalnumber;


    //Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPersonalnumber() {
        return personalnumber;
    }

    public void setPersonalnumber(String personnummer) {
        this.personalnumber = personnummer;
    }
}
