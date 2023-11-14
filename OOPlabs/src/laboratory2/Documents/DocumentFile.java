package laboratory2.Documents;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DocumentFile extends File {
    private String extention;
    public DocumentFile(Path path) {
        super(path.toString());

        int index = getName().lastIndexOf(".");
        extention = (index > 0) ? getName().substring(index + 1) : "";
    }

    public DocumentFile(String pathname) {
        super(pathname);
    }

    public String getExtension() {
        return extention;
    }

    public String getCreationTime() {
        try {
            BasicFileAttributeView attributeView = Files.getFileAttributeView(toPath(), BasicFileAttributeView.class);
            BasicFileAttributes attributes = attributeView.readAttributes();
            FileTime creationTime = attributes.creationTime();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(creationTime.toMillis());
            return sdf.format(date);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getModificationTime() {
        try {
            BasicFileAttributeView attributeView = Files.getFileAttributeView(toPath(), BasicFileAttributeView.class);
            BasicFileAttributes attributes = attributeView.readAttributes();
            FileTime creationTime = attributes.lastModifiedTime();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(creationTime.toMillis());
            return sdf.format(date);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getInformation() {
        extention = null;
        String ext = extention.isEmpty() ? "empty" : extention;

        return "Name: " + getName() + "\nExtention: " + ext + "\nUpdated at: " + getModificationTime() + "\nCreated at: " + getCreationTime();
    }
}
