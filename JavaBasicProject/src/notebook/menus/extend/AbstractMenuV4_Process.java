package notebook.menus.extend;

public abstract class AbstractMenuV4_Process extends AbstractMenuV3_Handle{
    /**
     * 유저가 정수 입력을 받을 경우 -> processInt(int)
     * 유저가 그 외의 입력을 받을 경우 -> processString(String)
     * @param userInput
     * @return
     */
    @Override
    protected int process(String userInput) {
        try{
            // 숫자 입력의 경우
            int userInputInt = Integer.parseInt(userInput);

            return processInt(userInputInt);

        } catch (NumberFormatException ne) {
            // NumberForamtException : 숫자로 변환할 수 없는 문자열을 변환할 경우
            // 일반 문자열의 경우

            return processString(userInput);
        }
    }

    /**
     * 정수인 유저 입력을 받는 경우
     * @param userInputInt
     * @return 정수인 유저 입력을 받는 경우 출력할 flag
     */
    protected abstract int processInt(int userInputInt);

    /**
     * 정수를 제외한 유저 입력을 받는 경우
     * @param userInput
     * @return 정수를 제외한 유저 입력을 받는 경우 출력할 flag
     */
    protected abstract int processString(String userInput);
}
