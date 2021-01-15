package week9;

public class TestException {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        try {
            method(a, b);  // 0으로 나눈다?
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    // throws 예외 처리 회피!
    public static void method(int a, int b) throws ArithmeticException{
        System.out.println(a / b);
    }
}