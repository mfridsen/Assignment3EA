package dev.groupeighteen.dbtest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Mattias Fridsén
 * @project Assignment3EA
 * @package dev.groupeighteen.dbtest
 * @contact matfir-1@student.ltu.se
 * @date 2024-11-18 16:49:05
 */
@Component
public class TestDataLoader {

 @Bean
 CommandLineRunner loadData(TestRepository repository) {
  return args -> {
   // Insert sample data
   TestEntity entity = new TestEntity();
   entity.setId(1L);
   entity.setName("Sample Data");
   repository.save(entity);

   // Fetch and print data
   repository.findAll().forEach(System.out::println);
  };
 }
}