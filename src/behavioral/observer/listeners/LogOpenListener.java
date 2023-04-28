package behavioral.observer.listeners;

import java.io.File;

public class LogOpenListener implements EventListener{
    private File log;   

    public LogOpenListener(String log) {
        this.log = new File(log);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.printf("Save to log %s: Someone has performed %s operation with the following file: %s\n", log, eventType, file.getName());
    }
    
}
