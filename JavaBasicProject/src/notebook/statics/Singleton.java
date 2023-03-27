package notebook.statics;

import notebook.abstractMenus.FavoritiesMenu;

import java.util.Scanner;

public class Singleton {
    private static Scanner scanner;

    private static FavoritiesMenu favorities;

    private Singleton() {
    }

    public static Scanner getScanner() {
        if(scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static FavoritiesMenu getFavorities() {
        if(favorities == null) {
            favorities = new FavoritiesMenu();
        }
        return favorities;
    }
}
