package dev.groupeighteen.controllers;
import dev.groupeighteen.db.entities.Module;
import dev.groupeighteen.services.EpokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mattias Fridsén
 * @project Assignment3EA
 * @package dev.groupeighteen.modul
 * @contact matfir-1@student.ltu.se
 * @date 2024-11-19 14:30:27
 */
@RestController
public class EpokController {

    @Autowired
    private EpokService service;

    @GetMapping("/api/get_Modul")
    public List <Module> getModules(@RequestParam String courseCode) {
        return service.getActiveModulesByCourseCode(courseCode);
    }

}