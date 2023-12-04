package laboratory2.behavior;

import laboratory2.Documents.DocumentInfo;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class FileChangeDetector extends Thread {
    private static final String DIRECTORY_PATH="src/laboratory1";
    private  Set<String> fileNames;
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                Commands commands = new Commands();
                commands.displayChanges();
            } catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
