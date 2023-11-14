package behavior;

import Documents.DocumentInfo;

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
    private static final String DIRECTORY_PATH="src/oop2";
    private final Set<String> NAMES_FILE;
    public  static void commit(){
        Instant ins = Instant.now();
        lastCommit = FileTime.from(ins);

    }
    public Commands(){
        this.NAMES_FILE = Stream.of(Objects.requireNonNull(new File(DIRECTORY_PATH).listFiles()))
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());

    }
    public void status() throws IOException {
        DocumentInfo docInfo;
        boolean directoryChanged=false;
        for (String fileName:
                NAMES_FILE) {
            docInfo = new DocumentInfo(DIRECTORY_PATH+"/"+fileName);
            if (docInfo.getCreationTime().compareTo(lastCommit)>0){
                System.out.println("SINCE The LAST COMMIT CREATED FILE "+fileName);
                directoryChanged=true;
                continue;
            }
            if (docInfo.getlastModification().compareTo(lastCommit)>0) {
                System.out.println("SINCE THE LAST COMMIT THE FILE "+fileName +" WAS CHANGED");
                directoryChanged=true;
            }
        }
        if (!directoryChanged) System.out.println("No changes since last commit");
    }

    public void displayChanges() throws IOException{
        DocumentInfo docInfo;
        boolean directoryChanged=false;
        for (String fileName:
                NAMES_FILE) {
            DocumentInfo file = new DocumentInfo(DIRECTORY_PATH + "/" + fileName);
            if (file.getCreationTime().compareTo(FileTime.from(Instant.now().minusMillis(5000)))>0){
                System.out.println("Created a new file: " + fileName);
                directoryChanged=true;
                continue;
            }
            if (file.getlastModification().compareTo(FileTime.from(Instant.now().minusMillis(5000)))>0) {
                System.out.println("The file " + fileName + " was changed");
                directoryChanged=true;
            }
        }
    }
    public void displayInfo(String fileName) throws IOException{
        DocumentInfo fileInfo=new DocumentInfo(DIRECTORY_PATH+"/"+fileName);
        switch (fileInfo.getExtension()){
            case "png","jpg" -> {
                ImageInfo imageInfo = new ImageInfo(DIRECTORY_PATH+"/"+fileName);
                imageInfo.printInfo();
            }
            case "txt"-> {
                TextInfo textInfo = new TextInfo(DIRECTORY_PATH+"/"+fileName);
                textInfo.printInfo();
            }
            case "py", "java" ->{
                ProgramInfo programInfo = new ProgramInfo(DIRECTORY_PATH+"/"+fileName);
                programInfo.printInfo();
            }
        }
    }


}
