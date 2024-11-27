package dev.groupeighteen.gui;

import javafx.stage.Stage;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<GUI.StageReadyEvent> {
    @Override
    public void onApplicationEvent(GUI.StageReadyEvent event) {
        Stage stage = event.getStage();

    }
}
