package week8;

public interface MusicPlayer {
    static void playMusic() {
        System.out.println("play the music!");
    }

    default void print() {
        System.out.println("Music");
    }
}
