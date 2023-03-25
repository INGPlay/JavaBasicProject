package notebook;

import notebook.interfaces.MenuInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuImpl implements MenuInterface {
    private List<Container> containers = new ArrayList<>();

    @Override
    public void menu(Scanner scanner) {
        System.out.println("------------저장소 목록----------");

        for (int i = 0; i < containers.size(); i++){
            Container post = containers.get(i);
            System.out.printf("%d. %s\n", i, post.getTitle());
        }

        System.out.println("-------------------------");
        System.out.println("!. 노트 생성 | @. 컨테이너 삭제 | #. 휴지통 | -. 종료");
        System.out.println("-------------------------");

        String choiceMenu = scanner.nextLine();

        switch (choiceMenu){
            case "!" :
                create(scanner);
                break;

            case "@" :
                break;

            case "#" :
                break;

            case "-" :
                out();
                break;

            default:
                try{
                    int choiceIndex = Integer.parseInt(choiceMenu);
                    MenuInterface container = containers.get(choiceIndex);

                    container.menu(scanner);

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

        Container container = new Container(this);
        container.setTitle(title);

        containers.add(container);

        System.out.println("저장소가 생성되었습니다.");

        menu(scanner);
    }

    void out(){
        System.out.println("종료합니다");
        System.exit(0);
    }
}
