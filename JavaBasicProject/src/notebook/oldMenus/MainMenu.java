package notebook.oldMenus;

import notebook.oldMenus.interfaces.MenuInterface;
import notebook.oldMenus.model.TitleContent;
import notebook.statics.Singleton;
import notebook.oldMenus.util.Submit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu implements MenuInterface {
    private List<ContainerMenu> containerMenus = new ArrayList<>();
    private Scanner scanner = Singleton.getScanner();

    @Override
    public void menu() {
        view();

        String choiceMenu = scanner.nextLine();

        int flag = process(choiceMenu);

        MenuInterface menuInterface = redirect(flag);

        menuInterface.menu();
    }

    private void view() {
        System.out.println("************저장소 목록************");

        for (int i = 0; i < containerMenus.size(); i++){
            ContainerMenu post = containerMenus.get(i);
            System.out.printf("%d. %s\n", i, post.getTitle());
        }

        System.out.println("-------------------------");
        System.out.println("!. 컨테이너 생성 | @. 컨테이너 삭제 | #. 휴지통 | -. 종료");
        System.out.println("-------------------------");
    }

    private int process(String choiceMenu) {


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

                    if (flag < 0 || flag >= containerMenus.size()) {        //
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

    private MenuInterface redirect(int flag) {
        if (flag == -1){
            return this;
        } else if (flag == -2){
            quit();
            return null;
        } else if (flag >= 0){
            MenuInterface container = containerMenus.get(flag);
            return container;
        } else{
            System.out.println("잘못된 메뉴입니다");
            return this;
        }
    }

    public void quit() {
        System.out.println("종료합니다");
        System.exit(0);
    }


    public void create(TitleContent titleContent){
        ContainerMenu containerMenu = new ContainerMenu(this);
        String title = titleContent.getContent();

        containerMenu.setTitle(title);

        containerMenus.add(containerMenu);

        System.out.println("컨테이너가 생성되었습니다.");
    }

    public void delete(int index) {
        if (index >= 0 && index < containerMenus.size()){
            containerMenus.remove(index);
            System.out.println("컨테이너가 삭제되었습니다");
        } else {
            System.out.println("인덱스의 최대 범위를 넘어갑니다.");
        }

    }

}
