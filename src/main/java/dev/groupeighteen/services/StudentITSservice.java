package dev.groupeighteen.services;

import dev.groupeighteen.db.entities.Student;
import dev.groupeighteen.db.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Johan Lund
 * @project Assignment3EA
 * @package dev.groupeighteen.persnummer.service
 * @contact ojaulz-2@student.ltu.se
 * @created 2024-11-19
 *
 * The PersnumberService class contains the business logic.
 * It serves as a bridge between the PersnumberRepository (data layer) and the PersnumberController (API layer).
 */

@Service
public class StudentITSservice {
    @Autowired
    private StudentRepository repository;

    public String getPersonnummerByUsername(String username) {
        Student student = repository.findByUsername(username);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        return student.getPersonNummer();
    }
}
