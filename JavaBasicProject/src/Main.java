import notebook.abstractMenus.MainMenu;
import notebook.abstractMenus.extend.AbstractMenuV3_DecideMenu;
public class Main {
    public static void main(String[] args) {

        AbstractMenuV3_DecideMenu mainMenu = new MainMenu();
        mainMenu.setTitle("메인 메뉴");

        mainMenu.menu();
    }
}