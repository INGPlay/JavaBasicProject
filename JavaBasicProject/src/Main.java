import notebook.MenuImpl;
import notebook.interfaces.MenuInterface;

public class Main {
    public static void main(String[] args) {

        MenuInterface mainMenu = new MenuImpl();

        mainMenu.menu();
    }
}