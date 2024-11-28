package dev.groupeighteen.services;

import dev.groupeighteen.db.entities.Module;
import dev.groupeighteen.db.repositories.CourseRepository;
import dev.groupeighteen.db.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Johan Lund
 * @project Assignment3EA
 * @package dev.groupeighteen.epok.service
 * @contact ojaulz-2@student.ltu.se
 * @created 2024-11-22
 */

@Service
public class EpokService {

    @Autowired
    private ModuleRepository moduleRepository;
    private CourseRepository courseRepository;

    public List<Module> getActiveModulesByCourseCode(String courseCode) {
        return moduleRepository.findModuleByCourse(courseRepository.findByCourseCode(courseCode));
    }

}
