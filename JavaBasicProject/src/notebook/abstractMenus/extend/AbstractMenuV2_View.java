package notebook.abstractMenus.extend;

public abstract class AbstractMenuV2_View extends AbstractMenuV1_Field {

    /**
     * view 자동화
     */
    @Override
    protected void view() {
        System.out.printf("************ %s ************\n", this.getTitle());

        System.out.println(topView());

        System.out.println("------------------------------");

        System.out.println(downView());

        System.out.println("------------------------------");
    }

    /**
     * 위쪽 뷰
     * @return
     */
    protected String topView(){
        String result = "";
        for (int i = 0; i < menus.size(); i++){
            AbstractMenuV1_Field post = menus.get(i);
            result += String.format("%d. %s\n", i, post.getTitle());
        }

        return result;
    }

    /**
     * 아래쪽 뷰
     * @return
     */
    protected abstract String downView();
}
