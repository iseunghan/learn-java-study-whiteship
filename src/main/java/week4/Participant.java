package week4;

public class Participant {
    private int success;
    private String userName;
    private boolean[] isSuccess;

    public Participant(String userName) {
        this.userName = userName;
        isSuccess = new boolean[19];
    }

    public void todayHomeWorkSuccess(int week) {
        isSuccess[week] = true; // parameter로 받아온 week에 해당하는 배열의 값을 true로 설정!
        success++; // 그리고 완료 횟수도 증가!
    }

    public int getSuccess() {
        return success;
    }

    public String getUserName() {
        return userName;
    }

    public boolean[] getIsSuccess() {
        return isSuccess;
    }

    public boolean is_HW_Done(int week) {
        return this.isSuccess[week];
    }
}