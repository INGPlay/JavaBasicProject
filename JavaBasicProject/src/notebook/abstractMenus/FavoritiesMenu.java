package notebook.abstractMenus;

import notebook.abstractMenus.extend.AbstractMenuV1_Field;
import notebook.abstractMenus.extend.AbstractMenuV3_DecideMenu;

import static notebook.abstractMenus.util.Check.isStringToInt;

public class FavoritiesMenu extends AbstractMenuV3_DecideMenu {

    /**
     * 다른 메뉴에서 추가할 수 있도록 menus를 열어준다
     * @param menu
     */
    public void addMenus(AbstractMenuV1_Field menu){
        this.menus.add(menu);
    }

    /**
     * title을 적기 위해 생성자 생성
     */
    public FavoritiesMenu(){
        setTitle("즐겨 찾기");
    }

    @Override
    protected String downView() {
        return "!. 즐겨찾기 삭제 | -. 뒤로가기";
    }

    @Override
    protected int process(String userInput) {

        int address;

        if (isStringToInt(userInput)) {
            // 숫자로 변환할 수 있는 경우
            int userIndex = Integer.parseInt(userInput);

            if (userIndex >= 0 && userIndex < menus.size()) {
                address = userIndex;
            } else {
                // 입력할 수 있는 숫자값을 넘어간 경우
                address = -3;
            }
        } else {
            switch (userInput){
                case "!" :
                    address = deleteFavorites();    // -1
                    break;

                case "-" :
                    address = -2;
                    break;

                default:
                    // 오류 발생
                    address = -3;
                    break;
            }
        }

        return address;
    }

    private int deleteFavorites(){
        System.out.println();

        System.out.println("---------------------------");
        System.out.println(topView());
        System.out.println("---------------------------");

        System.out.println("삭제할 메모의 인덱스를 적어주세요.");
        String str = scanner.nextLine();

        if (isStringToInt(str)){
            int index = Integer.parseInt(str);

            if (isMenusIndex(index)){
                menus.remove(index);
                System.out.println("메모가 삭제되었습니다");
            } else {
                System.out.println("인덱스의 최대 범위를 넘어갑니다.");
            }

        } else {
            // 오류 발생시키기
            System.out.println("숫자가 아닌 문자를 입력하셨습니다.");
            deleteFavorites();     // 조건에 만족할 때까지 반복
        }

        return -1;
    }
}
