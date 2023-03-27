package notebook.abstractMenus.extend;

import notebook.statics.Singleton;

public abstract class AbstractMenuV3_DecideMenu extends AbstractMenuV2_View{

    /**
     * 유저 입력에 따른 처리 및 메뉴 반환
     * process() -> 유저 입력에 따른 처리
     * redirect() -> 처리가 끝난 후 보여줄 메뉴 반환
     * @param userInput
     * @return
     */
    @Override
    protected AbstractMenuV0_BasicMehod handle(String userInput) {
        int address = process(userInput);

        AbstractMenuV1_Field menu = redirect(address);

        return menu;
    }

    /**
     * 사용자의 입력에 따른 address(정수값) 반환
     * 반환된 정수값에 redirect() 에서 처리되어 메뉴를 반환함
     * @param userInput
     * @return
     */
    protected abstract int process(String userInput);

    /**
     * process()에서 반환한 정수값에 따라 다음 메뉴를 반환
     *
     * 입력 정수에 따른 이동 메뉴
     * 0~ : menus에 포함된 메뉴 ( menus.get(i) )
     * -1 : 현재 메뉴 ( this )
     * -2 : 뒤로가기 ( getBefore() )
     * -3 : 인덱스 범위 오류 ( this )
     * -4 : 애플리케이션 종료 ( System.exit(0) )
     * 그 외 : 예상치 못한 오류
     *
     * @param address : process()가 반환한 정수 값
     * @return
     */
    protected AbstractMenuV1_Field redirect(int address){
        AbstractMenuV1_Field menu = null;

        if (isMenusIndex(address)){     // menus에 포함된 메뉴로 리다이렉트
            menu = menus.get(address);
            menu.setBefore(this);   // 뒤로갈 메뉴 정보 넣기

        } else if (address == -1) {     // 현재 메뉴
            menu = this;

        } else if (address == -2){      // 뒤로가기
            menu = getBefore();

        } else if (address == -3) {      // 입력할 수 있는 숫자값을 넘어간 경우
            System.out.println("잘못된 입력 값 입니다.");       // 오류 발생
            menu = this;

        } else if (address == -4) {     // 종료
            quit();
        } else if (address == -11){
            menu = Singleton.getFavorities();
            menu.setBefore(this);

        } else {        // 잘못 입력된 경우
            System.out.println("예상치 못한 에러입니다.");
            menu = this;

        }

        return menu;
    };

    private void quit(){
        System.out.println("종료합니다");
        System.exit(0);
    }
}
