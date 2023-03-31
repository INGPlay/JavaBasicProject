package notebook.menus;

import notebook.menus.extend.AbstractMenuV4_Process;
import notebook.menus.submenu.Submenu;
import notebook.statics.Singleton;

public class ContainerMenu extends AbstractMenuV4_Process {
    @Override
    protected String downView() {
        return "!. 노트 생성 | @. 노트 삭제 | #. 컨테이너 즐겨찾기 | $. 컨테이너 이름 변경 | -. 메인메뉴로";
    }
    @Override
    protected int processInt(int userInputInt) {

        int address;
        if (userInputInt >= 0 && userInputInt < getMenus().size()){
            address = userInputInt;
        } else {
            // 입력할 수 있는 숫자값을 넘어간 경우
            address = -3;
        }

        return address;
    }

    @Override
    protected int processString(String userInput) {

        Submenu submenu = new Submenu();
        submenu.checkInputString("!", -1, this::createPost);
        submenu.checkInputString("@", -1, this::deletePost);
        submenu.checkInputString("#", -1, this::addFavorities);
        submenu.checkInputString("$", -1, this::updateContainer);
        submenu.checkInputString("-", -2);

        submenu.setDefaultFlag(-100);

        return submenu.execute(userInput);
    }

    private void addFavorities() {
        System.out.println("즐겨찾기에 추가되었습니다.");
        Singleton.getFavoritiesMenu().addMenus(this);
    }

    private void createPost(){
        System.out.println();

        System.out.println("제목을 적어주세요.");
        String title = scanner.nextLine();

        System.out.println("내용을 적어주세요.");
        String content = scanner.nextLine();

        PostMenu post = new PostMenu();
        post.setTitle(title);
        post.setContent(content);

        addMenus(post);

        System.out.println("노트가 생성되었습니다.");
    }

    private void deletePost(){
        System.out.println();

        System.out.println("---------------------------");
        System.out.print(topView());
        System.out.println("---------------------------");

        System.out.println("삭제할 메모의 인덱스를 적어주세요.");
        String userInput = scanner.nextLine();

        boolean isDelete = deleteMenus(userInput);

        if (!isDelete){
            deletePost();     // 조건에 만족할 때까지 반복
        }
    }

    private void updateContainer(){
        System.out.println("제목을 적어주세요.");
        String title = scanner.nextLine();

        String temp = getTitle();

        setTitle(title);
        System.out.printf("\"%s\" 에서 \"%s\" 로 변경되었습니다\n", temp, title);
    }

}
