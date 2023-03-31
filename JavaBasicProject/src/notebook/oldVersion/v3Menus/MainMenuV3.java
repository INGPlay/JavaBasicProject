package notebook.oldVersion.v3Menus;

import notebook.menus.extend.AbstractMenuV1_Field;
import notebook.menus.extend.AbstractMenuV3_Handle;

import static notebook.menus.util.Check.isStringToInt;

public class MainMenuV3 extends AbstractMenuV3_Handle {
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

        AbstractMenuV1_Field newMenu = new ContainerMenuV3();
        newMenu.setTitle(title);

        addMenus(newMenu);

        return -1;
    }

    private int deleteContainer(){
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

        return -1;
    }
}
