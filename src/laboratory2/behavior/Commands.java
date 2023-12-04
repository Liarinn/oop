package laboratory2.behavior;

import laboratory2.Documents.CodeFile;
import laboratory2.Documents.DocumentInfo;
import laboratory2.Documents.ImageFile;
import laboratory2.Documents.TextFile;

import javax.print.Doc;
import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Commands {
    private static FileTime lastCommit;
    private static final String DIRECTORY_PATH = "src/laboratory2/files";
    private final Set<String> NAMES_FILE;

    public static void commit() {
        Instant ins = Instant.now();
        lastCommit = FileTime.from(ins);

    }

    public Commands() {
        this.NAMES_FILE = Stream.of(Objects.requireNonNull(new File(DIRECTORY_PATH).listFiles()))
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());

    }

    public void status() throws IOException {
        DocumentInfo docInfo;
        boolean directoryChanged = false;
        for (String fileName :
                NAMES_FILE) {
            docInfo = new DocumentInfo(DIRECTORY_PATH + "/" + fileName);
            if (docInfo.getCreationTime().compareTo(lastCommit) > 0) {
                System.out.println("SINCE The LAST COMMIT CREATED FILE " + fileName);
                directoryChanged = true;
                continue;
            }
            if (docInfo.getlastModification().compareTo(lastCommit) > 0) {
                System.out.println("SINCE THE LAST COMMIT THE FILE " + fileName + " WAS CHANGED");
                directoryChanged = true;
            }
        }
        if (!directoryChanged) System.out.println("No changes since last commit");
    }

    public void displayChanges() throws IOException {
        DocumentInfo docInfo;
        boolean directoryChanged = false;
        for (String fileName :
                NAMES_FILE) {
            DocumentInfo file = new DocumentInfo(DIRECTORY_PATH + "/" + fileName);
            if (file.getCreationTime().compareTo(FileTime.from(Instant.now().minusMillis(5000))) > 0) {
                System.out.println("Created a new file: " + fileName);
                directoryChanged = true;
                continue;
            }
            if (file.getlastModification().compareTo(FileTime.from(Instant.now().minusMillis(5000))) > 0) {
                System.out.println("The file " + fileName + " was changed");
                directoryChanged = true;
            }
        }
    }
    public void displayInfo(String fileName) throws IOException{
        String path = DIRECTORY_PATH + "/" + fileName;
        DocumentInfo fileInfo=new DocumentInfo(path);
        switch (fileInfo.getExtension()){
            case "png", "jpg" -> {
                DocumentInfo imageInfo = new ImageFile(path);
                imageInfo.printInfo();
            }
            case "txt"-> {
                DocumentInfo textInfo = new TextFile(path);
                textInfo.printInfo();
            }
            case "py", "java" ->{
                CodeFile programInfo = new CodeFile(path);
                programInfo.printInfo();
            }
        }
    }

    }

