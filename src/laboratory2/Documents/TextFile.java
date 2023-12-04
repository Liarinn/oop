package laboratory2.Documents;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFile extends DocumentInfo {
    private int lineCount;
    private int wordCount;
    private int charCount;
    public TextFile(String filePath) throws IOException {
        super(filePath);
        this.computeTextFileAttributes();
    }

    private void computeTextFileAttributes() {
        File file = new File(this.getdocPath());
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                this.lineCount++;
                this.charCount += line.length();

                String[] words = line.split("\\s+");
                this.wordCount += words.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

// git checkout main dupa Pull Request in GitHub
    // git pull pentru ultimele schimbari
    // deschizi Intellij oop-labs, nu curent
    // happy coding

    public int getLineCount() {
        return lineCount;
    }


    public int getWordCount() {
        return wordCount;
    }


    public int getCharCount() {
        return charCount;
    }
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("The line count is: " + lineCount);
        System.out.println("The word count is: " + wordCount);
        System.out.println("The character count is: " + charCount);
    }
}
