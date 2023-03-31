package notebook.menus.exception;

public class FaultValueException extends Exception{
    FaultValueException(){
    }

    public FaultValueException(String s){
        super(s);
    }
}
