package notebook.abstractMenus.util;

public class Check {
    public static boolean isStringToInt(String userInput){
        try{
            Integer.parseInt(userInput);
        } catch (NumberFormatException ne) {
            // NumberForamtException : 숫자로 변환할 수 없는 문자열을 변환할 경우
            return false;
        }

        return true;
    }
}
