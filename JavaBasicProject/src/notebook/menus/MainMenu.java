package notebook.menus;

import notebook.menus.extend.AbstractMenuV1_Field;
import notebook.menus.extend.AbstractMenuV4_Process;
import notebook.menus.submenu.Submenu;

public class MainMenu extends AbstractMenuV4_Process {
    @Override
    protected String downView() {
        return "!. 컨테이너 생성 | @. 컨테이너 삭제 | #. 즐겨찾기 | -. 종료";
    }

    @Override
    protected int processInt(int userInputInt) {

        int address;
        if (userInputInt >= 0 && userInputInt < getMenus().size()){
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

        submenu.checkInputString("!", -1, this::createContainer);
        submenu.checkInputString("@", -1, this::deleteContainer);
        submenu.checkInputString("#", -11);  // 즐겨찾기
        submenu.checkInputString("-", -4);

        submenu.setDefaultFlag(-100);

        return submenu.execute(userInput);
    }

    private void createContainer(){
        System.out.println();

        System.out.println("제목을 적어주세요.");
        String title = scanner.nextLine();

        AbstractMenuV1_Field newMenu = new ContainerMenu();
        newMenu.setTitle(title);

        addMenus(newMenu);
    }

    private void deleteContainer(){
        System.out.println();

        System.out.println("---------------------------");
        System.out.print(topView());
        System.out.println("---------------------------");

        System.out.println("삭제할 컨테이너의 인덱스를 적어주세요.");
        String userInput = scanner.nextLine();

        boolean isDelete = deleteMenus(userInput);

        if (!isDelete){
            deleteContainer();     // 조건에 만족할 때까지 반복
        }
    }
}
