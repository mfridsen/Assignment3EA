package dev.groupeighteen.controllers;

/**
 * @author Mattias Fridsén
 * @project Assignment3EA
 * @package dev.groupeighteen.persnummer
 * @contact matfir-1@student.ltu.se
 * @date 2024-11-19 14:30:20
 */

import dev.groupeighteen.services.StudentITSservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The PersnumberController handles incoming HTTP requests and maps them to the appropriate service methods.
 * It’s the entry point for the REST API.
 */
@RestController
public class StudentITSController {
    @Autowired
    private StudentITSservice service;

    @GetMapping("/api/get_Personnnummer")
    public String getPersonalnumber(@RequestParam String username) {
        return service.getPersonalnumberByUsername(username);
    }

}