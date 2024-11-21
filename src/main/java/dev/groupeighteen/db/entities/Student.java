package dev.groupeighteen.db.entities;

import jakarta.persistence.*;

/**
 * @author Mattias Fridsén
 * @project Assignment3EA
 * @package dev.groupeighteen.db.entities
 * @contact matfir-1@student.ltu.se
 * @date 2024-11-21 18:59:05
 */
@Entity
@Table(name = "students", uniqueConstraints = {
        @UniqueConstraint(columnNames = "personnummer"),
        @UniqueConstraint(columnNames = "username")
})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(name = "student_name", nullable = false, length = 100)
    private String studentName;

    @Column(name = "personnummer", nullable = false, unique = true, length = 13)
    private String personnummer;

    @Column(name = "username", nullable = false, unique = true, length = 8)
    private String username;

    // Constructors
    public Student() {
    }

    public Student(String studentName, String personnummer, String username) {
        this.studentName = studentName;
        this.personnummer = personnummer;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", personnummer='" + personnummer + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public void setPersonnummer(String personnummer) {
        this.personnummer = personnummer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
