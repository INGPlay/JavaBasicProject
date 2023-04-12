package notebook.statics;

import notebook.menus.FavoritiesMenu;

import java.util.Scanner;

public class Singleton {
    private static Scanner scanner;

    private static FavoritiesMenu favoritiesMenu;

    private Singleton() {
    }

    /**
     * @return Scanner 객체
     */
    public static Scanner getScanner() {
        if(scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    /**
     * @return FavoritiesMenu(즐겨찾기 메뉴) 객체
     */
    public static FavoritiesMenu getFavoritiesMenu() {
        if(favoritiesMenu == null) {
            favoritiesMenu = new FavoritiesMenu();
        }
        return favoritiesMenu;
    }
}
