package week8;

public class SmartPhone implements Camera{
    @Override
    public void takePhoto() {

    }

    @Override
    public void print() {
        Camera.super.print();
        MusicPlayer.playMusic();
        System.out.println("smartPhone");
    }


    public static void main(String[] args) {
        Camera c = new SmartPhone();
        c.print();
    }
}
