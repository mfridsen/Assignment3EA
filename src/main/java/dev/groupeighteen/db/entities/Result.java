package dev.groupeighteen.db.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * @author Mattias Fridsén
 * @project Assignment3EA
 * @package dev.groupeighteen.db.entities
 * @contact matfir-1@student.ltu.se
 * @date 2024-11-26 19:50:12
 */
@Entity
@Table(name = Result.TABLE_NAME)
public class Result {

 public static final String TABLE_NAME = "results";
 public static final String COLUMN_ID = "result_id";
 public static final String COLUMN_DATE = "date";
 public static final String COLUMN_GRADE = "grade";
 public static final String COLUMN_STATUS = "status";
 public static final String COLUMN_STUDENT_ID = "student_id";
 public static final String COLUMN_MODULE_ID = "module_id";

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = COLUMN_ID)
 private Long resultId;

 @Column(name = COLUMN_DATE, nullable = false)
 private LocalDate date;

 @Column(name = COLUMN_GRADE, nullable = false, length = 5)
 private String grade;

 @Column(name = COLUMN_STATUS, nullable = false, length = 20)
 private String status = "pending";

 @ManyToOne(optional = false)
 @JoinColumn(name = COLUMN_STUDENT_ID, referencedColumnName = Student.COLUMN_ID, nullable = false)
 private Student student;

 @ManyToOne(optional = false)
 @JoinColumn(name = COLUMN_MODULE_ID, referencedColumnName = Module.COLUMN_ID, nullable = false)
 private Module module;

 // Constructors
 public Result() {
 }

 public Result(LocalDate date, String grade, String status, Student student, Module module) {
  this.date = date;
  this.grade = grade;
  this.status = status;
  this.student = student;
  this.module = module;
 }

 // toString method
 @Override
 public String toString() {
  return "Result{" +
          "resultId=" + resultId +
          ", date=" + date +
          ", grade='" + grade + '\'' +
          ", status='" + status + '\'' +
          ", student=" + student +
          ", module=" + module +
          '}';
 }

 // Getters and setters
 public Long getResultId() {
  return resultId;
 }

 public void setResultId(Long resultId) {
  this.resultId = resultId;
 }

 public LocalDate getDate() {
  return date;
 }

 public void setDate(LocalDate date) {
  this.date = date;
 }

 public String getGrade() {
  return grade;
 }

 public void setGrade(String grade) {
  this.grade = grade;
 }

 public String getStatus() {
  return status;
 }

 public void setStatus(String status) {
  this.status = status;
 }

 public Student getStudent() {
  return student;
 }

 public void setStudent(Student student) {
  this.student = student;
 }

 public Module getModule() {
  return module;
 }

 public void setModule(Module module) {
  this.module = module;
 }
}