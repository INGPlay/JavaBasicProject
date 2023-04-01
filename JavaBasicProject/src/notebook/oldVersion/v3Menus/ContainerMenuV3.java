package notebook.oldVersion.v3Menus;

import notebook.menus.extend.AbstractMenuV3_Handle;
import notebook.statics.Singleton;

import static notebook.menus.util.Check.isStringToInt;

public class ContainerMenuV3 extends AbstractMenuV3_Handle {
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

            if (userIndex >= 0 && userIndex < getMenus().size()){
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
                    Singleton.getFavoritiesMenu().addFavorities(this);
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

        PostMenuV3 post = new PostMenuV3();
        post.setTitle(title);
        post.setContent(content);

        addMenus(post);

        System.out.println("노트가 생성되었습니다.");

        return -1;
    }

    private int deletePost(){
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

        return -1;
    }

    private int updateContainer(){
        System.out.println("제목을 적어주세요.");
        String title = scanner.nextLine();

        String temp = getTitle();

        setTitle(title);
        System.out.printf("\"%s\" 에서 \"%s\" 로 변경되었습니다\n", temp, title);

        return -1;
    }

}
