### **학습 할 내용들**

-   자바 상속의 특징
-   super 키워드
-   메소드 오버라이딩
-   다이나믹 메소드 디스패치 (Dynamic Method Dispatch)
-   추상 클래스
-   final 키워드
-   Object 클래스

### **자바 상속의 특징**

---

**상속의 매우 치명적인 오해 :**

> "상속은 코드의 재활용을 위한 문법입니다." (**X**)

---

> "연관된 일련의 클래스들에 대해 공통적인 규약을 정의할 수 있습니다." (**O**)

#### **상속의 가장 기본적인 특성**

-   부모클래스의 필드, 메소드만 상속되며, 생성자와 초기화 블록은 상속되지 않는다.
-   부모 클래스의 private, default로 설정된 멤버는 자식 클래스에서 상속 받지만 접근할 수는 없다.

**Animal 클래스**

```
public class Animal {
	String name;
    String bark;

	public void bark() {
    	System.out.println(name + ": " + bark);
    }
}
```

**Dog 클래스**

```
public class Dog extends Animal {
	// 상위 클래스의 변수 name, barking이 존재
	// String name;
    // String bark;
    
    // 상위 클래스의 bark() 메소드 존재
	// public void bark() { ... }

    public Dog(String name, String bark) {
    	super();	// 자바 컴파일러가 자동으로 상위클래스의 생성자를 호출!
    	this.name = name;
        this.bark = bark;
    }
}
```

자바 컴파일러에 의해 부모 클래스의 생성자가 호출 되게 된다!

```
// Main
public static void main(String[] args){
	Dog dog1 = new Dog("웰시코기" , "멍멍");
    	dog1.bark();
}
```

**실행 결과**

```
웰시코기: 멍멍
```



#### **IS - A 관계**

Dog클래스는 Animal클래스를 상속받았다. 즉, Dog는 Animal의 하위 개념이라고 할 수 있겠다.

**개는 동물이다. (O)**

```
Animal dog = new Dog();
```

**동물은 개다. (X)**

```
Dog dog = new Animal(); // compile error
```

---

### **super 키워드**

---

super 키워드는 부모 클래스로부터 상속받은 필드나 메소드를 자식 클래스에서 참조하는데 사용하는 참조 변수이다.

인스턴스 변수의 이름과 지역 변수 이름이 같을 경우 **this 키워드**로 구분할 수 있었는데,

이와 마찬가지로 부모 클래스의 멤버와 자식 클래스의 멤버 이름이 같을 경우 **super 키워드**로 구별할 수 있다.

```
class Parent{
    int a = 10;
}

class Child extends Parent {
    a = 20;
    
    void display() {
    	System.out.println(a);
        System.out.println(this.a);
        System.out.println(super.a);
    }
}

public class Main{
     public static void main(String[] args){
    	Child child = new Child();
        child.display();
     }
}
```

실행 결과

```
20
20
10
```

#### **super() 키워드**

```
class Parent {
	int a;
    
    public Parent() {
    	a = 10;
    }
    
    public Parent(int a) {
    	this.a = a;
    }
}

class Child extend Parent {
	int b;
    
    public Child() {
    	// super(); 무조건 부모클래스의 기본생성자가 호출됨
    	b = 20;
    }
    
    void display() {
    	System.out.println(a);
        System.out.println(b);
    }
}

public class Main{
	public static void main(String[] args) {
    	Child child = new Child();
        child.display();
    }
}
```

**실행 결과**

```
10
20
```

---

### **메소드 오버라이딩**

---

> **오버 로딩(overloading)이란 서로 다른 시그니처를 갖는 여러 메소드를 하나의 이름으로 정의하는 것.**

> **오버 라이딩(overriding)이란 상속 관계에 있는 부모 클래스에서 이미 정의된 메소드를 자식 클래스에서 같은 시그니쳐를 갖는 메소드로 다시 정의하는 것.  
> **

#### **오버라이딩의 조건**

1. 오버라이딩이란 메소드의 동작만을 재정의하는 것이므로, 메소드의 선언부는 기존 메소드와 완전히 같아야 합니다.

하지만 메소드의 반환 타입은 부모 클래스의 반환 타입으로 타입 변환할 수 있는 타입이라면 변경할 수 있습니다.

2. 부모 클래스의 메소드보다 접근 제어자를 더 좁은 범위로 변경할 수 없습니다

3. 부모 클래스의 메소드보다 더 큰 범위의 예외를 선언할 수 없습니다.

```
class Parent {

    void display() { System.out.println("부모 클래스의 display() 메소드입니다."); }

}

class Child extends Parent {

    void display() { System.out.println("자식 클래스의 display() 메소드입니다."); }

}

 

public class Inheritance05 {
    public static void main(String[] args) {

        Parent pa = new Parent();

        pa.display();

        Child ch = new Child();

        ch.display();

        Parent pc = new Child();

        pc.display(); // = child.display();

    }
}
```

**실행 결과**

```
부모 클래스의 display() 메소드입니다.
자식 클래스의 display() 메소드입니다.
자식 클래스의 display() 메소드입니다.
```

---

### **다이나믹 메소드 디스패치 (Dynamic Method Dispatch)**

---

Dispatch

-   Static Dispatch
-   Dynamic Dispatch

static

---

### **추상** **클래스**

---

추상 메소드(abstract method)란 자식 클래스에서 **반드시 오버라이딩**해야만 사용할 수 있는 메소드를 의미합니다.

공통적인 부분을 미리 다 만들어놓고, 그 부분을 **재정의**함으로써 생산성 향상되는 장점이 있습니다.

이러한 추상 메소드는 선언부만 존재하며, 구현부는 작성되어 있지 않다.

```
abstract 반환타입 메소드이름();	// 선언부만 있고, 구현부는 없다는 의미로 세미콜론(;)
```

하나 이상의 추상 메소드를 포함하는 클래스를 추상 클래스라고 한다.

```
abstract class Animal{
	abstract void cry();
}

class Dog extends Animal {
	void cry() {
    	System.out.println("멍멍");
    }
}

class Cat extends Animal {
	void cry() {
    	System.out.println("냐옹");
    }
}

public clas Main {
	public static void main(String[] args){
        Animal ani = new Animal();	// 추상 클래스는 인스턴스 생성 X
        Dog dog = new Dog();
        Cat cat = new Cat();
        
        dog.cry();
        cat.cry();
    }
}
```

```
멍멍
냐옹
```

---

### **final 키워드**

---

자바에서 final 키워드는 여러 컨텍스트에서 단 한번만 할당될 수 있는 entity를 정의할 때 사용 됩니다.

**원시 타입**

```
public class Test_Final {

    final int x = 1;
    
    x = 3;	// 변경할 수 없는 상수값이 된다.
}
```

**객체 타입**

```
public class Main{

    final Member member = new Member();
    
    member = new Member();	// 다른 객체로 변경 불가!
    
    member.setName("another name");	// 필드 변경은 가능
}
```

**메소드 인자**

```
public class Main {
    public void setName(final String name){
    	name = "another name";	// final 인자는 메소드 내에서 변경 불가
    }
}
```

### **Final 메소드**

**final 키워드로 선언된 메소드는 오버라이딩 불가!**

```
class Animal {

    final void bark() {
    
    }
}

class Dog extends Animal {
	
    void bark() {
    	// final로 선언된 메소드는 overriding 불가!
    }
}
```

### **Final 클래스**

```
public final class Animal {	}

// final 클래스는 상속할 수 없다!
class Dog extends Animal {	}
```

---

### **Object 클래스**

---

자바에서 Object 클래스는 모든 클래스의 부모 클래스가 되는 클래스입니다.

따라서 자바의 모든 클래스는 자동으로 Object 클래스의 모든 필드와 메소드를 상속받게 됩니다.

즉, 자바의 모든 클래스는 별도로 extends 키워드를 사용하여 Object 클래스의 상속을 명시하지 않아도 Object 클래스의 모든 멤버를 자유롭게 사용할 수 있습니다.

자바의 모든 객체에서 toString()이나 clone()과 같은 메소드를 바로 사용할 수 있는 이유가 해당 메소드들이 Object 클래스의 메소드이기 때문입니다.

#### **toString() 메소드**

toString() 메소드는 해당 인스턴스에 대한 정보를 문자열로 반환합니다.

이때 반환되는 문자열은 클래스 이름과 함께 구분자로 '@'가 사용되며, 그 뒤로 16진수 해시 코드(hash code)가 추가됩니다.

16진수 해시 코드 값은 인스턴스의 주소를 가리키는 값으로, 인스턴스마다 모두 다르게 반환됩니다.

```
class Member {

}

public class Main {
    Member member = new Member();
    Member member2 = new Member();
    
    System.out.println(member);
    System.out.println(member2);
}
```

```
Member@15db9742
Member@6d06d69c
```

#### **Object 메소드**

<table style="border-collapse: collapse; width: 100%; height: 333px;" border="1" data-ke-style="style12"><tbody><tr style="height: 19px;"><td style="height: 19px; text-align: center; width: 28.3721%;"><b>메소드</b></td><td style="height: 19px; text-align: center; width: 71.5116%;"><b>설명</b></td></tr><tr style="height: 19px;"><td style="height: 19px; width: 28.3721%; text-align: center;">protected Object clone()</td><td style="height: 19px; width: 71.5116%;">해당 객체의 복제본을 생성하여 반환함.</td></tr><tr style="height: 19px;"><td style="height: 19px; width: 28.3721%; text-align: center;">boolean equals(Object obj)</td><td style="height: 19px; width: 71.5116%;">해당 객체와 전달받은 객체가 같은지 여부를 반환함.</td></tr><tr style="height: 38px;"><td style="height: 38px; width: 28.3721%; text-align: center;">protected void finalize()</td><td style="height: 38px; width: 71.5116%;">해당 객체를 더는 아무도 참조하지 않아 가비지 컬렉터가 객체의 리소스를 정리하기 위해 호출함.</td></tr><tr style="height: 19px;"><td style="height: 19px; width: 28.3721%; text-align: center;">Class&lt;T&gt; getClass()</td><td style="height: 19px; width: 71.5116%;">해당 객체의 클래스 타입을 반환함.</td></tr><tr style="height: 19px;"><td style="height: 19px; width: 28.3721%; text-align: center;">int hashCode()</td><td style="height: 19px; width: 71.5116%;">해당 객체의 해시 코드값을 반환함.</td></tr><tr style="height: 38px;"><td style="height: 38px; width: 28.3721%; text-align: center;">void notify()</td><td style="height: 38px; width: 71.5116%;">해당 객체의 대기(wait)하고 있는 하나의 스레드를 다시 실행할 때 호출함.</td></tr><tr style="height: 19px;"><td style="height: 19px; width: 28.3721%; text-align: center;">void notifyAll()</td><td style="height: 19px; width: 71.5116%;">해당 객체의 대기(wait)하고 있는 모든 스레드를 다시 실행할 때 호출함.</td></tr><tr style="height: 19px;"><td style="height: 19px; width: 28.3721%; text-align: center;">String toString()</td><td style="height: 19px; width: 71.5116%;">해당 객체의 정보를 문자열로 반환함.</td></tr><tr style="height: 50px;"><td style="height: 50px; width: 28.3721%; text-align: center;">void wait()</td><td style="height: 50px; width: 71.5116%;">해당 객체의 다른 스레드가 notify()나 notifyAll() 메소드를 실행할 때까지 현재 스레드를 일시적으로 대기(wait)시킬 때 호출함.</td></tr><tr style="height: 10px;"><td style="height: 10px; width: 28.3721%; text-align: center;">void wait(long timeout)</td><td style="height: 10px; width: 71.5116%;"><p>해당 객체의 다른 스레드가 notify()나 notifyAll() 메소드를 실행하거나 전달받은 시간이 지날&nbsp;때까지 현재 스레드를 일시적으로 대기(wait)시킬 때 호출함.</p></td></tr><tr style="height: 64px;"><td style="height: 64px; width: 28.3721%; text-align: center;">void wait(long timeout, int nanos)</td><td style="height: 64px; width: 71.5116%;">해당 객체의 다른 스레드가 notify()나 notifyAll() 메소드를 실행하거나 전달받은 시간이 지나거나 다른 스레드가 현재 스레드를 인터럽트(interrupt) 할 때까지 현재 스레드를 일시적으로 대기(wait)시킬 때 호출함.</td></tr></tbody></table>

---

## **REFERENCES**

---

[multifrontgarden.tistory.com/133](https://multifrontgarden.tistory.com/133)

[blog.advenoh.pe.kr/java/%EC%9E%90%EB%B0%94%EC%97%90%EC%84%9C-final%EC%97%90-%EB%8C%80%ED%95%9C-%EC%9D%B4%ED%95%B4/](https://blog.advenoh.pe.kr/java/%EC%9E%90%EB%B0%94%EC%97%90%EC%84%9C-final%EC%97%90-%EB%8C%80%ED%95%9C-%EC%9D%B4%ED%95%B4/)

[www.tcpschool.com/java/java\_inheritance\_super](http://www.tcpschool.com/java/java_inheritance_super)

[wikidocs.net/280](https://wikidocs.net/280)