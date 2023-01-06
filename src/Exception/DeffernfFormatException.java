package Exception;

public class DeffernfFormatException extends RuntimeException{
   private String message = "используются одновременно разные системы счисления";

    @Override
    public String toString() {
        return message;
    }
}
