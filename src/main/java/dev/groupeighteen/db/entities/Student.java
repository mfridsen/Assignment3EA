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
@Table(
        name = Student.TABLE_NAME,
        uniqueConstraints = { // social ID number and usernames have to be unique
                @UniqueConstraint(name = "uc_personnummer", columnNames = Student.COLUMN_PERSONNUMMER),
                @UniqueConstraint(name = "uc_username", columnNames = Student.COLUMN_USERNAME)
        }
)
public class Student {

    // Table and column names
    public static final String TABLE_NAME = "students";
    public static final String COLUMN_ID = "student_id";
    public static final String COLUMN_NAME = "student_name";
    public static final String COLUMN_PERSONNUMMER = "personnummer";
    public static final String COLUMN_USERNAME = "username";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID)
    private int studentId;

    @Column(name = COLUMN_NAME, nullable = false, length = 100)
    private String studentName;

    @Column(name = COLUMN_PERSONNUMMER, nullable = false, unique = true, length = 13)
    private String personNummer;

    @Column(name = COLUMN_USERNAME, nullable = false, unique = true, length = 8)
    private String username;

    // Constructors
    public Student() {
    }

    public Student(String studentName, String personNummer, String username) {
        this.studentName = studentName;
        this.personNummer = personNummer;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", personnummer='" + personNummer + '\'' +
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

    public String getPersonNummer() {
        return personNummer;
    }

    public void setPersonNummer(String personNummer) {
        this.personNummer = personNummer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
