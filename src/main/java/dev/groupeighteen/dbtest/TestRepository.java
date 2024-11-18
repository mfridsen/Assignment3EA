package dev.groupeighteen.dbtest;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mattias Fridsén
 * @project Assignment3EA
 * @package dev.groupeighteen.dbtest
 * @contact matfir-1@student.ltu.se
 * @date 2024-11-18 16:48:49
 */
public interface TestRepository extends JpaRepository<TestEntity, Long>
{
}