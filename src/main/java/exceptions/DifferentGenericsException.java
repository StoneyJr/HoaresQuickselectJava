package exceptions;

import java.io.Serial;

public class DifferentGenericsException extends IllegalArgumentException{
    @Serial
    private static final long serialVersionUID = 1L;

    public DifferentGenericsException(String message){
        super(message);
    }

}
