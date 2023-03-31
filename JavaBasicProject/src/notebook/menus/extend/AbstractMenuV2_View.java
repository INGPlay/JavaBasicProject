package notebook.menus.extend;

import java.util.List;

public abstract class AbstractMenuV2_View extends AbstractMenuV1_Field {

    /**
     * View() : topView() + downView()
     */
    @Override
    protected void view() {
        System.out.printf("************ %s ************\n", this.getTitle());

        System.out.print(topView());

        System.out.println("------------------------------");

        System.out.println(downView());

        System.out.println("------------------------------");
    }

    /**
     * 위쪽 뷰
     * 기본적으로 menus의 title을 출력하여 보여주도록 설정
     * @return
     */
    protected String topView(){
        String result = "";

        List<AbstractMenuV1_Field> menus = getMenus();
        for (int i = 0; i < menus.size(); i++){
            AbstractMenuV1_Field menu = menus.get(i);
            result += String.format("%d. %s\n", i, menu.getTitle());
        }

        return result;
    }

    /**
     * 아래쪽 뷰
     * 기본적으로 가상 메소드
     * 직접 정의해야 함
     * @return
     */
    protected abstract String downView();
}
