package dev.groupeighteen.db;

import dev.groupeighteen.db.entities.Course;
import dev.groupeighteen.db.entities.Student;
import dev.groupeighteen.db.entities.Module;
import dev.groupeighteen.db.entities.Result;
import dev.groupeighteen.db.repositories.CourseRepository;
import dev.groupeighteen.db.repositories.ModuleRepository;
import dev.groupeighteen.db.repositories.ResultRepository;
import dev.groupeighteen.db.repositories.StudentRepository;
import jakarta.persistence.Table;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Mattias Fridsén
 * @project Assignment3EA
 * @package dev.groupeighteen.db
 * @contact matfir-1@student.ltu.se
 * @date 2024-11-21 19:02:38
 */
@Configuration
public class TestDataConfig
{
    @Bean
    CommandLineRunner commandLineRunner(
            CourseRepository courseRepository,
            StudentRepository studentRepository,
            ModuleRepository moduleRepository,
            ResultRepository resultRepository
    ) {
        return args -> {
            // Students
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
            printTableEntries(Student.class, studentRepository);

            // Courses
            Course course1 = new Course("Enterprise Architecture", "EA101");
            Course course2 = new Course("Data Science", "DS102");
            Course course3 = new Course("Artificial Intelligence", "AI103");

            courseRepository.save(course1);
            courseRepository.save(course2);
            courseRepository.save(course3);

            // Print courses to verify
            printTableEntries(Course.class, courseRepository);

            // Modules
            Module module1 = new Module("Introduction to EA", "EA101-01", course1);
            Module module2 = new Module("Advanced Data Science", "DS102-02", course2);
            Module module3 = new Module("Machine Learning Basics", "AI103-03", course3);

            moduleRepository.save(module1);
            moduleRepository.save(module2);
            moduleRepository.save(module3);

            // Print modules to verify
            printTableEntries(Module.class, moduleRepository);

            // Results
            Result result1 = new Result(LocalDate.now(), "A", "completed", student1, module1);
            Result result2 = new Result(LocalDate.now().minusDays(10), "B", "completed", student2, module2);
            Result result3 = new Result(LocalDate.now().minusDays(20), "C", "pending", student3, module3);

            resultRepository.save(result1);
            resultRepository.save(result2);
            resultRepository.save(result3);

            // Print results to verify
            printTableEntries(Result.class, resultRepository);

            // Testing non-existent and empty tables
            JpaRepository<?, ?> teacherRepository = null;
            printTableEntries(null, teacherRepository); // non-existent
        };
    }

    // Helper method to print table entries
    private <T> void printTableEntries(Class<T> entityClass, JpaRepository<T, ?> repository) {

        if (repository == null) {
            System.out.println("\nError: Repository for table is not initialized (null).");
            return;
        }
        String tableName = getTableName(entityClass);
        System.out.println("\nEntries found in " + tableName + " table:");
        try {
            List<T> entries = repository.findAll();
            if (entries.isEmpty()) {
                System.out.println("No entries found in " + tableName + " table.");
            } else {
                entries.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error accessing table " + tableName + ": " + e.getMessage());
        }
    }

    private String getTableName(Class<?> domainClass) {
        if (domainClass.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = domainClass.getAnnotation(Table.class);
            return tableAnnotation.name();
        } else {
            return domainClass.getSimpleName(); // Fall back to class name if @Table is missing
        }
    }
}