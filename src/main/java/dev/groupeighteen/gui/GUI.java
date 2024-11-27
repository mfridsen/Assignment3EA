package dev.groupeighteen.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;


public class GUI extends Application {
    private ConfigurableApplicationContext applicationContext;


    @Override
    public void init() throws Exception {
        applicationContext = new SpringApplicationBuilder(GUI.class).run();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/fxml/StudentGrades.fxml"));
        Parent root = fxmlloader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Student Grades Management");
        stage.show(); // Ensure the stage is shown
        applicationContext.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

    static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }

        public Stage getStage() {
            return ((Stage) getSource());
        }
    }
}
