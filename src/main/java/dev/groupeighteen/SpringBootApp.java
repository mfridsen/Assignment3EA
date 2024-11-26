package dev.groupeighteen;
import javafx.application.Application;
import dev.groupeighteen.gui.GUI;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Mattias Fridsén
 * @project Assignment3EA
 * @package dev.groupeighteen
 * @contact matfir-1@student.ltu.se
 * @date 2024-11-08 14:48:11
 */
@SpringBootApplication
public class SpringBootApp {
    public static void main(String[] args) {
        Application.launch(GUI.class, args);
        //SpringApplication.run(Application.class, args);
    }
}