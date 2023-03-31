package notebook.menus;

import notebook.menus.extend.AbstractMenuV4_Process;
import notebook.menus.submenu.Submenu;
import notebook.statics.Singleton;

public class PostMenu extends AbstractMenuV4_Process {
    /**
     * content를 추가하여 메모 내용을 받을 수 있는 변수 추가
     */
    private String content;
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 노트 내용을 출력하기 위해 topView() 재정의
     * @return
     */
    @Override
    protected String topView(){
        return getContent() + "\n";
    }

    @Override
    protected String downView() {
        return "!. 노트 수정 | #. 노트 즐겨찾기 | -. 노트 나가기";
    }


    @Override
    protected int processInt(int userInputInt) {
        return -3;
    }

    @Override
    protected int processString(String userInput) {
        Submenu submenu = new Submenu();

        submenu.checkInputString("!", -1, this::updatePost);
        submenu.checkInputString("#", -1, this::addFavorities);
        submenu.checkInputString("-", -2);

        submenu.setDefaultFlag(-3);

        return submenu.execute(userInput);
    }

    private void addFavorities() {
        System.out.println("즐겨찾기에 추가되었습니다.");
        Singleton.getFavoritiesMenu().addMenus(this);
    }

    private void updatePost(){
        System.out.println();

        System.out.println("제목을 적어주세요.");
        String title = scanner.nextLine();

        System.out.println("내용을 적어주세요.");
        String content = scanner.nextLine();

        setTitle(title);
        setContent(content);

        System.out.println("내용이 수정되었습니다.");
    }
}
