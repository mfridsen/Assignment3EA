package dev.groupeighteen.controllers.repository;


import dev.groupeighteen.controllers.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Johan Lund
 * @project Assignment3EA
 * @package dev.groupeighteen.epok.repository
 * @contact ojaulz-2@student.ltu.se
 * @created 2024-11-21
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCourseCodeAndActiveTrue(String courseCode);
}
