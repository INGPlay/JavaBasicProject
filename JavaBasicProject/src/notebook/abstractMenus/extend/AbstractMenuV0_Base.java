package notebook.abstractMenus.extend;

import notebook.statics.Singleton;

import java.util.Scanner;

public abstract class AbstractMenuV0_Base {

    protected Scanner scanner = Singleton.getScanner();

    /**
     * 메뉴
     * view() -> 유저 입력 -> handle() -> 메뉴 호출
     */
    public void menu(){
        // 메뉴를 보여주고
        view();

        // 사용자 입력을 받고
        String userInput = scanner.nextLine();

        // 사용자의 입력을 받아 처리하여
        AbstractMenuV0_Base menu = handle(userInput);

        // 다음 메뉴를 호출한다
        menu.menu();
    }

    /**
     * 보여주는 것(뷰 View)을 정의하는 가상 메소드
     */
    protected abstract void view();

    /**
     * 사용자의 입력을 받아 처리하고, 다음 메뉴를 결정할 가상 메소드
     * @param userInput
     * @return
     */
    protected abstract AbstractMenuV0_Base handle(String userInput);

}
