package notebook;

import notebook.interfaces.MenuInterface;

import java.util.Scanner;

public class Post implements MenuInterface {
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
    public void menu(Scanner scanner) {
        System.out.println("---------------N-O-T-E---------------");
        System.out.println(title);
        System.out.println("-------------------------");
        System.out.println(content);

        System.out.println("-------------------------");
        System.out.println("!. 노트 수정 | -. 뒤로가기");
        System.out.println("-------------------------");

        String choiceMenu = scanner.nextLine();

        switch (choiceMenu){
            case "!" :
                update(scanner);
                break;

            case "@" :
                break;

            case "-" :
                out(scanner);
                break;
        }

        System.out.println("잘못 입력하셨습니다.");
        menu(scanner);
    }

    void update(Scanner scanner){
        System.out.println();

        System.out.println("제목을 적어주세요.");
        String title = scanner.nextLine();

        System.out.println("내용을 적어주세요.");
        String content = scanner.nextLine();

        this.title = title;
        this.content = content;

        System.out.println("노트가 수정되었습니다.");

        menu(scanner);
    }

    void create(Scanner scanner){

    }

    void out(Scanner scanner){
        before.menu(scanner);
    }
}
