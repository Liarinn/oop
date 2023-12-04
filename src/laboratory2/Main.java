package laboratory2;
import laboratory2.behavior.AplicationLoop;
import laboratory2.behavior.FileChangeDetector;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        AplicationLoop aplicationLoop = new AplicationLoop();
        System.out.println(AplicationLoop.MAIN_MENU);
        FileChangeDetector fileChangeDetector = new FileChangeDetector();
        fileChangeDetector.setPriority(Thread.MAX_PRIORITY);
        aplicationLoop.setPriority(Thread.MIN_PRIORITY);
        aplicationLoop.start();
        fileChangeDetector.start();

    }
}