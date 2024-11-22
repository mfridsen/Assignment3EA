package dev.groupeighteen.studentITS.repository;


import dev.groupeighteen.studentITS.entity.Persnumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Johan Lund
 * @project Assignment3EA
 * @package dev.groupeighteen.persnummer.repository
 * @contact ojaulz-2@student.ltu.se
 * @created 2024-11-19
 */

/**
 * This interface provides access to the database by abstracting CRUD operations and custom queries.
 * It connects the Student entity to the database.
 */

@Repository
public interface PersnumberRepository extends JpaRepository<Persnumber, String> {
    Persnumber findByUsername (String username);
}
