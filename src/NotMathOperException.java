public class NotMathOperException extends RuntimeException {
    private String  message = "строка не является математической операцией";

    @Override
    public String toString() {
        return  message;

    }
}
