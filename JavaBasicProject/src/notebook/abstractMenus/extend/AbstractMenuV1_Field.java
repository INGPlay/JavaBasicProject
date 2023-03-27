package notebook.abstractMenus.extend;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMenuV1_Field extends AbstractMenuV0_BasicMehod {
    /**
     * 기본적인 정보 (Title, 이전 메뉴, 컨테이너에 속한 메뉴)
     */
    private String title;
    protected AbstractMenuV1_Field before;

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

    protected List<AbstractMenuV1_Field> menus = new ArrayList<>();

    protected boolean isMenusIndex(int index){
        if (index >= 0 && index < menus.size()){
            return true;
        }

        return false;
    }
}
