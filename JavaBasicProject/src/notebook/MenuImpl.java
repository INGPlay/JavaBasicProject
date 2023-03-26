package notebook;

import notebook.interfaces.MenuInterface;
import notebook.model.TitleContent;
import notebook.statics.Singleton;
import notebook.util.Submit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuImpl implements MenuInterface {
    private List<Container> containers = new ArrayList<>();
    private Scanner scanner = Singleton.getScanner();

    @Override
    public void menu() {
        view();

        int flag = process();

        redirect(flag);
    }

    private void view() {
        System.out.println("************저장소 목록************");

        for (int i = 0; i < containers.size(); i++){
            Container post = containers.get(i);
            System.out.printf("%d. %s\n", i, post.getTitle());
        }

        System.out.println("-------------------------");
        System.out.println("!. 컨테이너 생성 | @. 컨테이너 삭제 | #. 휴지통 | -. 종료");
        System.out.println("-------------------------");
    }

    private int process() {
        String choiceMenu = scanner.nextLine();

        int flag = -1;

        switch (choiceMenu){
            case "!" :      // 컨테이너 생성
                System.out.println();

                System.out.println("제목을 적어주세요.");
                String title = scanner.nextLine();

                TitleContent titleContent = Submit.submitTitleOnly(title);
                create(titleContent);

                flag = -1;
                break;

            case "@" :      // 컨테이너 삭제
                System.out.println();

                System.out.println("삭제할 컨테이너의 인덱스를 적어주세요.");
                String str = scanner.nextLine();

                int index = Integer.parseInt(str);

                delete(index);

                flag = -1;
                break;
//
//            case "#" :      // 휴지통으로
//                break;

            case "-" :      // 종료
                flag = -2;
                break;

            default:        // 예외 상황
                try{
                    flag = Integer.parseInt(choiceMenu);

                    if (flag < 0 || flag >= containers.size()) {        //
                        System.out.println("인덱스의 범위를 넘어갑니다.");
                        flag = -1;
                    }
                } catch (Exception e){
                    System.out.println("잘못 입력하셨습니다.");
                    flag = -1;
                }

                break;
        }

        return flag;
    }

    private void redirect(int flag) {
        if (flag == -1){
            menu();
        } else if (flag == -2){
            quit();
        } else if (flag >= 0){
            MenuInterface container = containers.get(flag);
            container.menu();
        } else{
            System.out.println("잘못된 메뉴입니다");
            menu();
        }
    }

    public void quit() {
        System.out.println("종료합니다");
        System.exit(0);
    }


    public void create(TitleContent titleContent){
        Container container = new Container(this);
        String title = titleContent.getContent();

        container.setTitle(title);

        containers.add(container);

        System.out.println("컨테이너가 생성되었습니다.");
    }

    public void delete(int index) {
        if (index >= 0 && index < containers.size()){
            containers.remove(index);
            System.out.println("컨테이너가 삭제되었습니다");
        } else {
            System.out.println("인덱스의 최대 범위를 넘어갑니다.");
        }

    }

}
