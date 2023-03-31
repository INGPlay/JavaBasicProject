package notebook.menus.submenu;

import java.util.HashMap;
import java.util.Map;

public class Submenu {
    private final Map<String, SubmenuInterface> checkMap = new HashMap<>();
    private final Map<String, Integer> flagMap = new HashMap<String, Integer>();

    /**
     * defaultFlag = 사용자의 입력이 검사되지 않을 경우 반환될 플래그
     */
    private int defaultFlag = -100;
    public void setDefaultFlag(int defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    /**
     * - 검사 조건을 추가한다.
     * userInput에 해당하는 사용자 입력이 들어오면
     * submenuInterface.submenu()가 호출되고
     * flag를 반환한다.
     * @param userInput : 사용자 입력
     * @param flag : 반환될 플래그 정수
     * @param submenuInterface : 입력될 경우 호출될 함수
     */
    public void checkInputString(String userInput, int flag, SubmenuInterface submenuInterface){
        checkMap.put(userInput, submenuInterface);
        flagMap.put(userInput, flag);
    }

    /**
     * - 검사 조건을 추가한다.
     * userInput에 해당하는 사용자 입력이 들어오면
     * flag를 반환한다.
     * @param userInput : 사용자 입력
     * @param flag : 반환될 플래그 정수
     */
    public void checkInputString(String userInput, int flag){
        checkMap.put(userInput, () -> {});
        flagMap.put(userInput, flag);
    }

    public int execute(String userInput){
        for (String checkString : checkMap.keySet()){

            if (userInput.equals(checkString)){
                checkMap.get(checkString).submenu();

                return flagMap.get(checkString);
            }
        }

        return defaultFlag;
    }

}
