package week8;

public interface JoinMember extends StaticJoinMember{

    default void preJoin() {
        System.out.println("default join");
    }
}