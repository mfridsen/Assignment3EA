package dev.groupeighteen.persnumber.service;


/**
 * @author Johan Lund
 * @project Assignment3EA
 * @package dev.groupeighteen.persnummer.service
 * @contact ojaulz-2@student.ltu.se
 * @created 2024-11-19
 */

import dev.groupeighteen.persnumber.entity.Persnumber;
import dev.groupeighteen.persnumber.repository.PersnumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The PersnummerService class contains the business logic.
 * It serves as a bridge between the PersnummerRepository (data layer) and the PersnummerController (API layer).
 */

@Service
public class PersnumberService {
    @Autowired
    private PersnumberRepository repository;

    public String getPersonalnumberByUsername(String username) {
        Persnumber persnumber = repository.findByUsername(username);
        if (persnumber == null) {
            throw new RuntimeException("Student not found");
        }
        return persnumber.getPersonalnumber();
    }
}
