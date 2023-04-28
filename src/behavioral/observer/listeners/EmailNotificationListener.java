package behavioral.observer.listeners;

import java.io.File;

public class EmailNotificationListener implements EventListener{

    private String email;
    
    

    public EmailNotificationListener(String email) {
        this.email = email;
    }



    @Override
    public void update(String eventType, File file) {
        System.out.printf("Email to %s : Someone has performed %s operation with the following file: %s\n", this.email, eventType, file.getName());
    }
    
}
