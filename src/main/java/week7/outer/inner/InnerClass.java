package week7.outer.inner;

//import week7.outer.DefaultClass;
import week7.outer.PrivateMethodClass;
import week7.outer.ProtectedMethodClass;
import week7.outer.PublicClass;

public class InnerClass {
    public static void main(String[] args) {
        PublicClass pbl = new PublicClass();
//        DefaultClass dft = new DefaultClass(); // default로 선언된 클래스라서 접근 불가
        ProtectedMethodClass prtc = new ProtectedMethodClass();
        PrivateMethodClass pmc = new PrivateMethodClass();

        pbl.print();    // public은 접근 가능 O
//        dft.print();    // default로 선언된 클래스라서 접근 불가 X
//        prtc.print();   // protected 메소드 접근 불가 X
//        pmc.print();    // private 메소드 접근 불가 X
    }
}