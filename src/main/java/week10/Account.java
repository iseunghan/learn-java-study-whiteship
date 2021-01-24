package week10;

public class Account {
    int money = 1000;

    public synchronized void payMoney(int money) {
        if (this.money >= money) {
            try {
                System.out.println(Thread.currentThread().getName() + " 출금 > " + money);
                Thread.sleep(1000);
                this.money -= money;
                System.out.println("현재 남은 금액 : " + this.money);
            } catch (InterruptedException e) {

            }
        }
    }
}
