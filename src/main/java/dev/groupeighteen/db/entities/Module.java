package dev.groupeighteen.db.entities;

import jakarta.persistence.*;

/**
 * @author Mattias Fridsén
 * @project Assignment3EA
 * @package dev.groupeighteen.db.entities
 * @contact matfir-1@student.ltu.se
 * @date 2024-11-26 19:31:53
 */
@Entity
@Table(
        name = Module.TABLE_NAME,
        uniqueConstraints = { // A module code has to be unique for a given course
                @UniqueConstraint(name = "uc_module_code_course_id", columnNames = {Module.COLUMN_CODE, Module.COLUMN_COURSE_ID})
        }
)
public class Module {

    // Table and column names
    public static final String TABLE_NAME = "modules";
    public static final String COLUMN_ID = "module_id";
    public static final String COLUMN_NAME = "module_name";
    public static final String COLUMN_CODE = "module_code";
    public static final String COLUMN_COURSE_ID = "course_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID)
    private Long moduleId;

    @Column(name = COLUMN_NAME, nullable = false, length = 100)
    private String moduleName;

    @Column(name = COLUMN_CODE, nullable = false, length = 10)
    private String moduleCode;

    @ManyToOne
    @JoinColumn(name = COLUMN_COURSE_ID, nullable = false)
    private Course course;

    // Default constructor
    public Module() {
    }

    // Constructor
    public Module(String moduleName, String moduleCode, Course course) {
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
        this.course = course;
    }

    // toString method
    @Override
    public String toString() {
        return "Module{" +
                "moduleId=" + moduleId +
                ", moduleName='" + moduleName + '\'' +
                ", moduleCode='" + moduleCode + '\'' +
                ", course=" + (course != null ? course.getCourseName() : null) +
                '}';
    }

    // Getters and setters
    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}