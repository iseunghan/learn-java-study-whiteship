package week8;

public interface Camera {
    void takePhoto();
    default void takeVideo() {
        System.out.println("take a Video!");
    }
    default void print() {
        System.out.println("camera");
    }
}
