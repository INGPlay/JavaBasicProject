package notebook;

import notebook.interfaces.MenuInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Container implements MenuInterface {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private List<Post> posts = new ArrayList<>();

    private MenuInterface before;

    public Container(MenuInterface before) {
        this.before = before;
    }

    @Override
    public void menu(Scanner scanner) {
        System.out.println("------------노트 목록----------");

        for (int i = 0; i < posts.size(); i++){
            Post post = posts.get(i);
            System.out.printf("%d. %s\n", i, post.getTitle());
        }

        System.out.println("-------------------------");
        System.out.println("!. 노트 생성 | @. 노트 삭제 | #. 저장소 이름 변경 | -. 뒤로가기");
        System.out.println("-------------------------");

        String choiceMenu = scanner.nextLine();

        switch (choiceMenu){
            case "!" :
                create(scanner);
                break;

            case "@" :
                delete(scanner);
                break;

            case "#" :
                update(scanner);
                break;

            case "-" :
                out(scanner);
                break;

            default:
                try{
                    int choiceIndex = Integer.parseInt(choiceMenu);
                    MenuInterface post = posts.get(choiceIndex);

                    post.menu(scanner);

                } catch (Exception e){
                    System.out.println("잘못 입력하셨습니다.");
                    menu(scanner);
                }

                break;
        }

    }

    void create(Scanner scanner){
        System.out.println();

        System.out.println("제목을 적어주세요.");
        String title = scanner.nextLine();

        System.out.println("내용을 적어주세요.");
        String content = scanner.nextLine();

        Post post = new Post(this);
        post.setTitle(title);
        post.setContent(content);

        posts.add(post);

        System.out.println("노트가 생성되었습니다.");

        menu(scanner);
    }

    void update(Scanner scanner){
        System.out.println();

        System.out.println("제목을 적어주세요.");
        String title = scanner.nextLine();

        this.title = title;

        System.out.println("저장소 제목이 수정되었습니다.");

        menu(scanner);
    }

    void delete(Scanner scanner){
        System.out.println();

        System.out.println("번호를 적어주세요. | -. 뒤로가기");

        try{
            String scan = scanner.nextLine();

            if (scan.equals("-")){
                menu(scanner);

            } else {
                int index = Integer.parseInt(scan);

                posts.remove(index);
                System.out.println("노트가 삭제되었습니다");

                menu(scanner);
            }

        } catch (Exception e){

            System.out.println("잘못 적으셨습니다.");
            delete(scanner);
        }

    }

    void out(Scanner scanner){
        before.menu(scanner);
    }
}
