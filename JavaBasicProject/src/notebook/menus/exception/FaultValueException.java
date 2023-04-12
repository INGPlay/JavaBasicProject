package notebook.menus.exception;

public class FaultValueException extends Exception{
    /**
     * 잘못된 값에 대한 예외 처리를 위한 클래스
     */
    FaultValueException(){
    }

    public FaultValueException(String s){
        super(s);
    }
}
