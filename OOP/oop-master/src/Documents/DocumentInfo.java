package Documents;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.BasicFileAttributes;

public class DocumentInfo {
    private String docPath;
    private  String docName;
    private  String extension;
    private FileTime lastModification;
    private  FileTime creationTime;
//    private FileTime lastCommitTime;

    public DocumentInfo(String docPath) throws IOException {
        this.docPath = docPath;
        BasicFileAttributes attrs = Files.readAttributes(Path.of(docPath), BasicFileAttributes.class);
        this.lastModification = attrs.lastModifiedTime();
        this.creationTime = attrs.creationTime();
        this.docName = docPath.substring(docPath.lastIndexOf("/") + 1);
        this.extension = docName.substring(docName.lastIndexOf(".") + 1);


    }
    public String getdocName(){
        return this.docName;
    }
    public String getExtension(){
        return this.extension;
    }

    public FileTime getlastModification() {
        return lastModification;
    }

    public FileTime getCreationTime() {
        return creationTime;
    }

    public String getdocPath() {
        return docPath;
    }

    public void setdocPath(String docPath) {
        this.docPath = docPath;
    }

    public void setdocName(String docName) {
        this.docName = docName;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setlastModification(FileTime lastModification) {
        this.lastModification = lastModification;
    }

    public void setCreationTime(FileTime creationTime) {
        this.creationTime = creationTime;
    }

    public void printInfo() {
        System.out.println("extension: "+this.extension+"\nI was created at: "+this.creationTime+
                "\nI was last updated at: "+ this.lastModification);
    }
}
