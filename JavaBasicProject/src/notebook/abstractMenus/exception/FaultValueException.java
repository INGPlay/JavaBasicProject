package notebook.abstractMenus.exception;

public class FaultValueException extends Exception{
    FaultValueException(){
    }

    public FaultValueException(String s){
        super(s);
    }
}
