package notebook;

import notebook.interfaces.MenuInterface;
import notebook.model.TitleContent;
import notebook.statics.Singleton;
import notebook.util.Submit;

import java.util.Scanner;

public class Post implements MenuInterface {
    private Scanner scanner = Singleton.getScanner();

    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private MenuInterface before;

    public Post(MenuInterface before) {
        this.before = before;
    }

    @Override
    public void menu() {
        view();

        String choiceMenu = scanner.nextLine();

        switch (choiceMenu){
            case "!" :      // 이 노트 수정
                System.out.println();

                System.out.println("제목을 적어주세요.");
                String title = scanner.nextLine();

                System.out.println("내용을 적어주세요.");
                String content = scanner.nextLine();

                TitleContent titleContent = Submit.submitTitleContent(title, content);

                update(titleContent);

                menu();
                break;

            case "-" :      // 노트 나가기
                quit();
                break;
        }

        System.out.println("잘못 입력하셨습니다.");
        menu();
    }

    public void quit() {
        before.menu();
    }

    private void view() {
        System.out.println("**************N-O-T-E**************");
        System.out.println(title);
        System.out.println("-------------------------");
        System.out.println(content);

        System.out.println("-------------------------");
        System.out.println("!. 노트 수정 | -. 뒤로가기");
        System.out.println("-------------------------");
    }

    public void create(TitleContent titleContent) {

    }

    public void update(TitleContent titleContent){

        this.title = titleContent.getTitle();
        this.content = titleContent.getContent();

        System.out.println("노트가 수정되었습니다.");
    }

    public void delete(int index) {

    }



    public void except(Object object) {

    }
}
