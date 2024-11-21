package dev.groupeighteen.db.repositories;

import dev.groupeighteen.db.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mattias Fridsén
 * @project Assignment3EA
 * @package dev.groupeighteen.db.entities
 * @contact matfir-1@student.ltu.se
 * @date 2024-11-21 19:00:09
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{
}