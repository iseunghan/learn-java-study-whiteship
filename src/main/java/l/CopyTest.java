package l;

public class CopyTest {
    private People man;
    public static class People {
        int age;
        String name;

        public People(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
/*
        CopyTest c1 = new CopyTest();
        People i1 = new People(1, "c");
        c1.man = i1;
        People test = c1.man;
        System.out.println(test);

        People p1 = new People(10, "a");
        c1.man = p1;
        System.out.println(c1.man);

        People p2 = new People(20, "b");
        c1.man = p2;
        System.out.println(c1.man);

        People test2 = c1.man;
        System.out.println(test.age); // expect : 20, actual : nullPointerException
        System.out.println(test2.age); // 20
        System.out.println(test2);
*/

        // 1번
        CopyTest copy = new CopyTest();
        People people1 = new People(10, "a");
        copy.man = people1;
        People test = copy.man; // c2.man을 바라보는게 아니라, t1의 주소값을 참조한다. 그러므로 변경해도 소용이 없다.
        System.out.println(test); // people1의 주소값 찍힘

        // 2번
        People people2 = new People(20, "b"); // heap 영역에 새로운 객체 생성
        copy.man = people2; // copy.man 이 기존에 참조하던 people1을 더이상 참조하지 않고, 새로운 people2를 참조하고 있다.
        People test2 = copy.man; // man1은 people2를 참조하고 있다. copy.man의 값이 바뀌어도 man1에는 영향이 없다.

        System.out.println(test); // people1의 주소값 찍힘
        System.out.println(test2); // people2의 주소값 찍힘.

        copy.man.age = 30; // copy.man은 people2의 주소값을 참조함. 바뀌는것은 people2의 age가 30으로 바뀜.

        System.out.println(test.age); // 1
        System.out.println(test2.age); // 30


        // =============================================

        CopyTest c1 = new CopyTest();
        People test3 = new People(10, "a");
        c1.man = test; // c1.man이 test를 참조하는게 아니고, test의 힙 주소값을 참조하고 있다. (이 말은, test의 주소값이 변경되어도 c1.man이 참조하는 주소값이 바뀌진 않는다.)

        People peo2 = new People(20, "b");
        test = peo2; // 원래라면 GC에 의해 new People(100,"100")이 정리 되는데, c1.man이 잡고 있어서 아직 대상이 아니게 된다.
        System.out.println(c1.man.age);
        System.out.println(test.age);
    }
}
