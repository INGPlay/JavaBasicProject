package notebook.statics;

import notebook.menus.FavoritiesMenu;

import java.util.Scanner;

public class Singleton {
    private static Scanner scanner;

    private static FavoritiesMenu favoritiesMenu;

    private Singleton() {
    }

    public static Scanner getScanner() {
        if(scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static FavoritiesMenu getFavoritiesMenu() {
        if(favoritiesMenu == null) {
            favoritiesMenu = new FavoritiesMenu();
        }
        return favoritiesMenu;
    }
}
