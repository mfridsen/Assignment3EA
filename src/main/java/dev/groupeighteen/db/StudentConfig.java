package dev.groupeighteen.db;

import dev.groupeighteen.db.entities.Student;
import dev.groupeighteen.db.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mattias Fridsén
 * @project Assignment3EA
 * @package dev.groupeighteen.db
 * @contact matfir-1@student.ltu.se
 * @date 2024-11-21 19:02:38
 */
@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student student1 = new Student("Anna Andersson", "920226-1234", "annaand");
            Student student2 = new Student("Björn Berg", "850101-5678", "bjornber");
            Student student3 = new Student("Cecilia Carlsson", "780315-9876", "cecilcar");
            Student student4 = new Student("David Dahl", "940820-4321", "daviddah");
            Student student5 = new Student("Eva Eriksson", "990912-8765", "evaerik");

            studentRepository.save(student1);
            studentRepository.save(student2);
            studentRepository.save(student3);
            studentRepository.save(student4);
            studentRepository.save(student5);

            // Print students to verify
            studentRepository.findAll().forEach(System.out::println);
        };
    }
}