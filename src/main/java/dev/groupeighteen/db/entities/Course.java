package dev.groupeighteen.db.entities;

import jakarta.persistence.*;

/**
 * @author Mattias Fridsén
 * @project Assignment3EA
 * @package dev.groupeighteen.db.entities
 * @contact matfir-1@student.ltu.se
 * @date 2024-11-21 19:18:53
 */
@Entity
@Table(
        name = Course.TABLE_NAME,
        uniqueConstraints = {
                @UniqueConstraint(name = "uc_course_code", columnNames = Course.COLUMN_CODE)
        }
)
public class Course {

    // Table and column names
    public static final String TABLE_NAME = "courses";
    public static final String COLUMN_ID = "course_id";
    public static final String COLUMN_NAME = "course_name";
    public static final String COLUMN_CODE = "course_code";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID)
    private Long courseId;

    @Column(name = COLUMN_NAME, nullable = false, length = 100)
    private String courseName;

    @Column(name = COLUMN_CODE, nullable = false, length = 10, unique = true)
    private String courseCode;

    // Default constructor
    public Course() {
    }

    // Constructor
    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    // toString method
    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }

    // Getters and setters
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}