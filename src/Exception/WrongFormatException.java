package Exception;

public class WrongFormatException extends RuntimeException{
    private String message = "формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";

    @Override
    public String toString() {
        return message;
    }
}
