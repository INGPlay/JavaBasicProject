package notebook;

import notebook.interfaces.MenuInterface;
import notebook.model.TitleContent;
import notebook.statics.Singleton;
import notebook.util.Submit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Container implements MenuInterface {

    private Scanner scanner = Singleton.getScanner();

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
    public void menu() {
        view();

        String choiceMenu = scanner.nextLine();

        switch (choiceMenu){
            case "!" :      // 노트생성
                System.out.println();

                System.out.println("제목을 적어주세요.");
                String title = scanner.nextLine();

                System.out.println("내용을 적어주세요.");
                String content = scanner.nextLine();

                TitleContent titleContent = Submit.submitTitleContent(title, content);
                create(titleContent);

                menu();
                break;

            case "@" :      // 노트 삭제
                String scan = scanner.nextLine();

                if (scan.equals("-")){
                    menu();

                } else {
                    int index = Integer.parseInt(scan);

                    delete(index);

                    menu();
                }

                menu();
                break;

            case "#" :      // 이 컨테이너 이름 변경
                System.out.println();

                System.out.println("제목을 적어주세요.");


                String title_ = scanner.nextLine();

                TitleContent titleOnly = Submit.submitTitleOnly(title_);

                update(titleOnly);

                menu();
                break;

            case "-" :      // 뒤로 가기(컨테이너 나가기)
                quit();
                break;

            default:
                try{
                    int choiceIndex = Integer.parseInt(choiceMenu);
                    MenuInterface post = posts.get(choiceIndex);

                    post.menu();

                } catch (Exception e){
                    System.out.println("잘못 입력하셨습니다.");
                    menu();
                }

                break;
        }
    }

    public void quit(){
        before.menu();
    }

    private void view() {
        System.out.println("************노트 목록*************");

        for (int i = 0; i < posts.size(); i++){
            Post post = posts.get(i);
            System.out.printf("%d. %s\n", i, post.getTitle());
        }

        System.out.println("-------------------------");
        System.out.println("!. 노트 생성 | @. 노트 삭제 | #. 컨테이너 이름 변경 | -. 뒤로가기");
        System.out.println("-------------------------");
    }

    public void create(TitleContent titleContent){

        String title = titleContent.getTitle();
        String content = titleContent.getContent();

        Post post = new Post(this);
        post.setTitle(title);
        post.setContent(content);

        posts.add(post);

        System.out.println("노트가 생성되었습니다.");

    }

    public void update(TitleContent titleContent){
        this.title = titleContent.getTitle();

        System.out.println("저장소 제목이 수정되었습니다.");
    }

    public void delete(int index){
        posts.remove(index);
        System.out.println("노트가 삭제되었습니다");
    }

}
