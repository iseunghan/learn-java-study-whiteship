package week7.outer;

public class OuterClass {
    public static void main(String[] args) {
        PublicClass pbl = new PublicClass();
        DefaultClass dft = new DefaultClass();
        ProtectedMethodClass prtc = new ProtectedMethodClass();
        PrivateMethodClass pmc = new PrivateMethodClass();

        pbl.print();
        dft.print();
        prtc.print();
//        pmc.print();
    }
}
