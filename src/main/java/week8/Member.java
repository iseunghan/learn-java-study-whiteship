package week8;

public class Member implements JoinMember{
    public static void main(String[] args) {
        Member m = new Member();
        m.preJoin();
        StaticJoinMember.preJoin();
    }
}
