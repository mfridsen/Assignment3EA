package dev.groupeighteen.db.repositories;

import dev.groupeighteen.db.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mattias Fridsén
 * @project Assignment3EA
 * @package dev.groupeighteen.db.repositories
 * @contact matfir-1@student.ltu.se
 * @date 2024-11-26 19:42:59
 */
public interface ModuleRepository extends JpaRepository<Module, Long>
{
}
