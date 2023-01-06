public class NegativeNumberException extends RuntimeException{
    private String message = " в римской системе нет отрицательных чисел";

    @Override
    public String toString() {
        return  message;

    }
}
