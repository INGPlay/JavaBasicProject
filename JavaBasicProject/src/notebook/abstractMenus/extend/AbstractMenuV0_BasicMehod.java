package notebook.abstractMenus.extend;

import notebook.statics.Singleton;

import java.util.Scanner;

public abstract class AbstractMenuV0_BasicMehod {

    protected Scanner scanner = Singleton.getScanner();
    public void menu(){
        view();

        String userInput = scanner.nextLine();

        AbstractMenuV0_BasicMehod menu = handle(userInput);

        menu.menu();
    }

    /**
     * 보여주는 것(뷰 View)을 정의하는 가상 메소드
     */
    protected abstract void view();

    /**
     * 사용자의 입력을 받고 처리한 후 다음 메뉴를 결정할 메소드
     * @param userInput
     * @return
     */
    protected abstract AbstractMenuV0_BasicMehod handle(String userInput);

}
