package notebook.statics;

import java.util.Scanner;

public class Singleton {
    private static Scanner scanner;

    private Singleton() {
    }

    public static Scanner getScanner() {
        if(scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
