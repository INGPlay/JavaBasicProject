package notebook.oldVersion.v3Menus;

import notebook.menus.extend.AbstractMenuV3_Handle;
import notebook.statics.Singleton;

public class PostMenuV3 extends AbstractMenuV3_Handle {
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
    protected int process(String userInput) {
        int address;

        switch (userInput){
            case "!" :
                address = updatePost();     // -1
                break;

            case "#" :
                Singleton.getFavoritiesMenu().addMenus(this);
                address = -1;
                break;

            case "-" :
                address = -2;
                break;

            default:
                // 오류 발생
                address = -3;
                break;
        }
        return address;
    }

    private int updatePost(){
        System.out.println();

        System.out.println("제목을 적어주세요.");
        String title = scanner.nextLine();

        System.out.println("내용을 적어주세요.");
        String content = scanner.nextLine();

        setTitle(title);
        setContent(content);

        System.out.println("내용이 수정되었습니다.");

        return -1;
    }
}
