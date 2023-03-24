package notebook.menu;

import notebook.Data;
import notebook.model.Post;

import java.util.List;
import java.util.Scanner;

public class MainMenu {

    private static Data data = Data.getInstance();
    private static Scanner scanner = new Scanner(System.in);

    public void menu(){

        System.out.println("------------노트 목록----------");
        List<Post> posts = data.getPosts();
        for (int i = 0; i < posts.size(); i++){
            Post post = posts.get(i);
            System.out.printf("%d. %s\n", i, post.getTitle());
        }

        System.out.println("-------------------------");
        System.out.println("!. 노트 생성 | @. 휴지통 | -. 종료");
        System.out.println("-------------------------");

        String choiceMenu = scanner.nextLine();

        switch (choiceMenu){
            case "!" :
                createPost();
                break;

            case "-" :
                terminate();
                break;
        }

        try{
            int choiceIndex = Integer.parseInt(choiceMenu);
            Post choicePost = posts.get(choiceIndex);

            postMenu(choicePost);

        } catch (Exception e){
            System.out.println("잘못 입력하셨습니다.");
            menu();
        }
    }

    void createPost(){
        System.out.println();

        List<Post> posts = data.getPosts();

        System.out.println("제목을 적어주세요.");
        String title = scanner.nextLine();

        System.out.println("내용을 적어주세요.");
        String content = scanner.nextLine();

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);

        posts.add(post);

        System.out.println("노트가 생성되었습니다.");

        menu();
    }

    void postMenu(Post post){
        String title = post.getTitle();
        String content = post.getContent();

        System.out.println(title);
        System.out.println("--------------------");
        System.out.println(content);
        System.out.println("--------------------");

        System.out.println("-------------------------");
        System.out.println("!. 노트 수정 | @. 노트삭제 | -. 돌아가기");
        System.out.println("-------------------------");

        String choiceMenu = scanner.nextLine();

        switch (choiceMenu){
            case "!" :

                break;

            case "-" :
                menu();
                break;

            default:
                System.out.println("잘못 입력하셨습니다.");
                postMenu(post);
        }
    }

    void terminate(){
        System.out.println("종료합니다");
        System.exit(0);
    }
}
