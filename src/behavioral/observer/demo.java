package behavioral.observer;

import behavioral.observer.editor.Editor;
import behavioral.observer.listeners.LogOpenListener;
import behavioral.observer.listeners.EmailNotificationListener;

public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        Editor editor2 = new Editor();

        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        LogOpenListener logListener = new LogOpenListener("/path/to/log/file2.txt");
        editor2.events.subscribe("open", logListener);
        try {
            editor.openFile("test.txt");
            editor.saveFile();
            editor2.openFile("file2.txt");
            editor2.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        editor2.events.unsubscribe("open", logListener);
        
        editor2.openFile("file2.txt");
    }

}
