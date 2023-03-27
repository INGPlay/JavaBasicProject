package notebook.abstractMenus;

import notebook.abstractMenus.extend.AbstractMenuV1_Field;
import notebook.abstractMenus.extend.AbstractMenuV3_DecideMenu;

import static notebook.abstractMenus.util.Check.isStringToInt;

public class MainMenu extends AbstractMenuV3_DecideMenu {
    @Override
    protected String downView() {
        return "!. 컨테이너 생성 | @. 컨테이너 삭제 | #. 즐겨찾기 | -. 종료";
    }

    @Override
    protected int process(String userInput) {
        int address;

        if (isStringToInt(userInput)){
            // 숫자로 변환할 수 있는 경우
            int userIndex = Integer.parseInt(userInput);

            if (isMenusIndex(userIndex)){
                address = userIndex;
            } else {
                // 입력할 수 있는 숫자값을 넘어간 경우
                address = -3;
            }
            
        } else {
            // 숫자로 변환할 수 없는 경우

            switch (userInput) {
                case "!":
                    address = createContainer();    // -1
                    break;

                case "@":
                    address = deleteContainer();    // -1
                    break;

                case "#" :
                    address = -11;
                    break;

//                case "$" :        // 휴지통 할까? 말까?
//
//                    break;

                case "-":
                    // quit();
                    address = -4;
                    break;

                default:
                    System.out.println("MainMenu.process");
                    address = -100;
                    break;
            }
        }

        return address;
    }

    private int createContainer(){
        System.out.println();

        System.out.println("제목을 적어주세요.");
        String title = scanner.nextLine();

        AbstractMenuV1_Field newMenu = new ContainerMenu();
        newMenu.setTitle(title);

        menus.add(newMenu);

        return -1;
    }

    private int deleteContainer(){
        System.out.println();

        System.out.println("---------------------------");
        System.out.println(topView());
        System.out.println("---------------------------");

        System.out.println("삭제할 컨테이너의 인덱스를 적어주세요.");
        String str = scanner.nextLine();

        if (isStringToInt(str)){
            int index = Integer.parseInt(str);

            if (isMenusIndex(index)){
                menus.remove(index);
                System.out.println("컨테이너가 삭제되었습니다");
            } else {
                System.out.println("인덱스의 최대 범위를 넘어갑니다.");
            }

        } else {
            // 오류 발생시키기
            System.out.println("숫자가 아닌 문자를 입력하셨습니다.");
            deleteContainer();     // 조건에 만족할 때까지 반복
        }

        return -1;
    }
}
