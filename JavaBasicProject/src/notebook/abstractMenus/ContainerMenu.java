package notebook.abstractMenus;

import notebook.abstractMenus.extend.AbstractMenuV3_DecideMenu;
import notebook.statics.Singleton;

import static notebook.abstractMenus.util.Check.isStringToInt;

public class ContainerMenu extends AbstractMenuV3_DecideMenu {
    @Override
    protected String downView() {
        return "!. 노트 생성 | @. 노트 삭제 | #. 컨테이너 즐겨찾기 | $. 컨테이너 이름 변경 | -. 메인메뉴로";
    }

    @Override
    protected int process(String userInput) {
        int address;

        if (isStringToInt(userInput)){
            // 숫자로 변환할 수 있는 경우
            int userIndex = Integer.parseInt(userInput);

            if (userIndex >= 0 && userIndex < menus.size()){
                address = userIndex;
            } else {
                // 입력할 수 있는 숫자값을 넘어간 경우
                address = -3;
            }

        } else {
            // 숫자로 변환할 수 없는 경우

            switch (userInput){
                case "!" :
                    address = createPost();     // -1
                    break;

                case "@" :
                    address = deletePost();     // -1
                    break;

                case "#" :
                    Singleton.getFavorities().addMenus(this);
                    address = -1;
                    break;

                case "$" :
                    address = updateContainer();    // -1
                    break;

                case "-" :
                    // quit();
                    address = -2;
                    break;

                default:
                    address = -3;
                    break;
            }
        }

        return address;
    }

    private int createPost(){
        System.out.println();

        System.out.println("제목을 적어주세요.");
        String title = scanner.nextLine();

        System.out.println("내용을 적어주세요.");
        String content = scanner.nextLine();

        PostMenu post = new PostMenu();
        post.setTitle(title);
        post.setContent(content);

        menus.add(post);

        System.out.println("노트가 생성되었습니다.");

        return -1;
    }

    private int deletePost(){
        System.out.println();

        System.out.println("---------------------------");
        System.out.println(topView());
        System.out.println("---------------------------");

        System.out.println("삭제할 메모의 인덱스를 적어주세요.");
        String str = scanner.nextLine();

        if (isStringToInt(str)){
            int index = Integer.parseInt(str);

            if (isMenusIndex(index)){
                menus.remove(index);
                System.out.println("메모가 삭제되었습니다");
            } else {
                System.out.println("인덱스의 최대 범위를 넘어갑니다.");
            }

        } else {
            // 오류 발생시키기
            System.out.println("숫자가 아닌 문자를 입력하셨습니다.");
            deletePost();     // 조건에 만족할 때까지 반복
        }

        return -1;
    }

    private int updateContainer(){
        System.out.println("제목을 적어주세요.");
        String title = scanner.nextLine();

        String temp = getTitle();

        setTitle(title);
        System.out.printf("\"%s\" 에서 \"%s\" 로 변경되었습니다", temp, title);

        return -1;
    }

}
