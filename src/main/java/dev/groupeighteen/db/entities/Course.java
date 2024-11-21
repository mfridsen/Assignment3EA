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
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false, length = 100)
    private String courseName;

    @Column(nullable = false, length = 10, unique = true)
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