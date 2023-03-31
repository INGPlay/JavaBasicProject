import notebook.menus.MainMenu;
import notebook.menus.extend.AbstractMenuV3_Handle;
public class Main {
    public static void main(String[] args) {

        AbstractMenuV3_Handle mainMenu = new MainMenu();
        mainMenu.setTitle("메인 메뉴");

        mainMenu.menu();
    }
}