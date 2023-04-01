package notebook.menus;

import notebook.menus.extend.AbstractMenuV1_Field;
import notebook.menus.extend.AbstractMenuV4_Process;
import notebook.menus.submenu.Submenu;

import java.util.List;

public class FavoritiesMenu extends AbstractMenuV4_Process {

    /**
     * 다른 메뉴에서 추가할 수 있도록 menus를 열어준다
     * @param menu
     */
    public void addFavorities(AbstractMenuV1_Field menu){
        super.addMenus(menu);
    }

    /**
     * title을 적기 위해 생성자 생성
     */
    public FavoritiesMenu(){
        setTitle("즐겨 찾기");
    }

    /**
     * Post와 Container를 구분해서 메뉴 리스트를 보여주기 위한 재정의
     * @return
     */
    @Override
    protected String topView(){
        String result = "";

        List<AbstractMenuV1_Field> menus = getMenus();

        for (int i = 0; i < menus.size(); i++){
            AbstractMenuV1_Field menu = menus.get(i);

            String tag = "";
            if (menu instanceof ContainerMenu){
                tag = "Container";
            } else if (menu instanceof PostMenu){
                tag = "Post";
            }
            result += String.format("%d. %s : %s\n", i, menu.getTitle(), tag);
        }

        return result;
    }

    @Override
    protected String downView() {
        return "!. 즐겨찾기 삭제 | -. 뒤로가기";
    }

    @Override
    protected int processInt(int userInputInt) {
        int address;

        if (userInputInt >= 0 && userInputInt < getMenus().size()) {
            address = userInputInt;
        } else {
            // 입력할 수 있는 숫자값을 넘어간 경우
            address = -3;
        }

        return address;
    }

    @Override
    protected int processString(String userInput) {
        Submenu submenu = new Submenu();

        submenu.checkInputString("!", -1, this::deleteFavorites);
        submenu.checkInputString("-", -2);

        submenu.setDefaultFlag(-3);

        return submenu.execute(userInput);
    }

    private void deleteFavorites(){
        System.out.println();

        System.out.println("---------------------------");
        System.out.print(topView());
        System.out.println("---------------------------");

        System.out.println("삭제할 메모의 인덱스를 적어주세요.");
        String userInput = scanner.nextLine();

        boolean isDelete = deleteMenus(userInput);

        if (!isDelete){
            deleteFavorites();     // 조건에 만족할 때까지 반복
        }
    }
}
