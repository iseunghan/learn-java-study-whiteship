package week9;

public class Main {
    public static void main(String[] args) throws AgeException {
        setAge(-1);
    }

    private static void setAge(int age) throws AgeException {
        if (age < 0) {
            throw new AgeException("나이를 다시 입력하세요.");
        }
    }
}
