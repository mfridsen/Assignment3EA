package dev.groupeighteen.dbtest;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @author Mattias Fridsén
 * @project Assignment3EA
 * @package dev.groupeighteen.dbtest
 * @contact matfir-1@student.ltu.se
 * @date 2024-11-18 16:47:51
 */
@Entity
public class TestEntity {

    @Id
    private Long id;
    private String name;

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}