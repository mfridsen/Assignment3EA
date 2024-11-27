package dev.groupeighteen.db.repositories;

import dev.groupeighteen.db.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Mattias Fridsén
 * @project Assignment3EA
 * @package dev.groupeighteen.db.repositories
 * @contact matfir-1@student.ltu.se
 * @date 2024-11-21 19:19:54
 */
public interface CourseRepository extends JpaRepository<Course, Long>
{
    List<Course> findByCourseCode(String courseCode);
}