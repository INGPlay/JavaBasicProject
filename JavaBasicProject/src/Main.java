import notebook.MenuImpl;
import notebook.interfaces.MenuInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MenuInterface mainMenu = new MenuImpl();

        mainMenu.menu(scanner);
    }
}