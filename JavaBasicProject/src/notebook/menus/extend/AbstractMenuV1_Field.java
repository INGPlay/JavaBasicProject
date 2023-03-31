package notebook.menus.extend;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMenuV1_Field extends AbstractMenuV0_Base {
    /**
     * 필드 및 프로퍼티
     * title : 메뉴 제목
     * before : 이전 메뉴
     * menus : 이 메뉴에 속한 메뉴
     */
    private String title;
    private AbstractMenuV1_Field before;

    private List<AbstractMenuV1_Field> menus = new ArrayList<>();

    /**
     * 프로퍼티
     */
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public AbstractMenuV1_Field getBefore() {
        return before;
    }
    public void setBefore(AbstractMenuV1_Field before) {
        this.before = before;
    }


    protected List<AbstractMenuV1_Field> getMenus() {
        return menus;
    }
    protected void addMenus(AbstractMenuV1_Field menu) {
        if (!menus.contains(menu)) {
            menus.add(menu);
        } else {
            System.out.println("중복된 추가입니다.");
        }
    }
    protected boolean deleteMenus(String userInput) {
        try{
            int index = Integer.parseInt(userInput);

            if (isMenusIndex(index)){
                menus.remove(index);
                System.out.println("메모가 삭제되었습니다");
            } else {
                System.out.println("인덱스의 최대 범위를 넘어갑니다.");
            }

        } catch (NumberFormatException ne) {
            // NumberForamtException : 숫자로 변환할 수 없는 문자열을 변환할 경우

            // 오류 발생시키기
            System.out.println("숫자가 아닌 문자를 입력하셨습니다.");
            return false;
        }

        return true;
    }

    /**
     * 입력된 index가 menus에 가용한 정수인지 판별
     * @param index
     * @return
     */
    protected boolean isMenusIndex(int index){
        if (index >= 0 && index < menus.size()){
            return true;
        }

        return false;
    }
}
