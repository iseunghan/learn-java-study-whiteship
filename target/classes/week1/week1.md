# Week1 JVM이란 무엇이며 자바 코드는 어떻게 실행하는 것인가.

## JVM이란 무엇인가
JVM은 자바 가상 머신(__Java Virtual Machine__)의 약자로 자바 바이트 코드(*__.class__* 파일)을 OS에 특화된 코드로 변환(일반적으로, *__인터프리터__* 나 *__JIT__* 컴파일 방식으로 다른 컴퓨터 위에서 바이트 코드를 실행할 수 있도록 구현한다)하여 실행한다.  JVM은 운영체제 마다 다르다. 윈도우에 특화된 JVM이 있고, Linux에 특화된 JVM이 있고, Mac OS에 특화된 JVM이 있을것이다. 하지만 자바의 바이트코드(.class파일)는 어떤 JVM에서나 다 동작을 하기 때문에, 표준 자바 API까지 동일한 동작을 하도록 구현한 상태에서는 모든 자바 프로그램은 운영 체제의 종류와 상관없이 독립적이다 라고 할 수 있는 것이다. 운영체제에 대해서는 독립적이게 됐지만, JVM에 대해서는 종속적이게 된다.

## 컴파일 하는 방법
- 실행 환경 : mac OS, JDK 11
    - `Terminal` 실행
        - 작성한 `.java` 파일 경로 진입
        
```
$ javac Test.java
```     

컴파일을 하면 아무 반응이 일어나지 않는다.
하지만 해당 파일 경로에 가보면 `Test.class` 파일이 생성이 되어있을 것이다.


## 실행하는 방법
- 실행하는 법은 명령어 `java Test` 로 실행

```
$ java Test
```

## 바이트코드란 무엇인가
- 자바 바이트코드(Bytecode)란 JVM이 이해할 수 있는 언어로 변환된 자바 소스 코드를 의미한다.
- 변환된 코드의 명령어 크기가 1바이트라서 자바 바이트코드라고 불리고 있다.
- 이러한 자바 바이트코드의 확장자는 `.class`이다
- 자바 바이트코드는 JVM만 설치되어이 있으면, 어떤 운영체제에서라도 실행 가능하다.


## JIT Compiler란 무엇이며 어떻게 동작하는가?
`Interpreter` 방식 : JVM이 최초 버전에 사용. Bytecode를 *__한 라인씩 읽고 해석__* 하여 실행하는 방식(속도가 느리다)

그래서 등장한 방식이 *__JIT 컴파일러__* 이다.<br>

*__JIT 컴파일러__* 는 Bytecode를 어셈블러 같은 Native Code로 변경되어 수행실행 속도는 빨라졌지만 어셈블러 코드로 변경하는데 비용이 발생한다.
<br>

*__JIT 컴파일러__* 의 큰 장점은 반복 수행할 때이다. 왜냐하면 한번 컴파일한 파일을 캐시 해놓기 때문에 다음번에 또 수행할 경우 불러와서 사용하기 때문에 속도가 빠르다.
<br>

하지만 모든 자바 컴파일러는 `Interpreter` 방식으로 실행하다가 적절한 시점에 `JIT Compiler` 가 바이트코드 전체를 컴파일하여 네이티브 코드(기계어)로 변경하고 이후에는 네이티브 코드로 직접 실행하는 방식이다.
<br>

## JVM 구성요소

* Java Source : 사용자가 작성한 JAVA 코드
* Java Compiler　: JAVA 코드를 Byte Code 로 변환시켜주는 기능
* Class Loader :　Class파일을 메모리(Runtime Data Area)에 적재하는 기능
* Execution Engine : Load 된 .class 의 Byte Code 를 실행하는 Runtime Module
* Gabage Collector : 가비지란 '정리되지 않은 메모리', '유효하지 않은 메모리 주소'를 말한다. 이것을 Heap Memory에서 발견해 없애주는 역할을 한다.
* Runtime Data Area : 프로그램을 수행하기 위해 OS에서 할당 받은 메모리 공간

#### JVM 실행 과정
1. 자바 컴파일러에 의해 자바코드가 클래스파일로 컴파일된 후 클래스로더로 해당 클래스 파일들을 로드 시킨다.
1. 로딩된 `.class` 파일은 Execution Engine 을 통해 해석된다.
1. 바이트코드를 한 라인씩 읽고 해석하여 실행하는 방식인 `Interpreter` (속도가 느림) 방식과, `Interpreter` 방식의 단점을 보완해 등장하는 것이 `JIT(just in time) Compiler` 방식이다.
    - 바이트코드를 `JIT Compiler`를 통해 어셈블러 같은 Native Code로 변경되어 수행
    - 실행속도는 빨라졌지만 어셈블러 코드로 변경하는데 비용이 발생함.
    - 어셈블러로 변환하면 속도가 빨라지지만 어셈블러 코드로 변환하는데 비용이 발생한다. 이 때문에 반복 수행이 발생하지 않으면 `Interpreter` 방식이 빠르다.
1.  JVM은 모든 코드를 `JIT Compiler` 방식으로 실행하지 않고 `Interpreter` 방식을 사용하다 일정한 기준이 넘어가면 `JIT Compiler` 방식으로 실행한다.
1. 이후 로딩된 바이트코드를 실행엔진을 이용하여 해석(*__Interpret__*)하여 Runtime Data Areas ( 아래에서 자세히 다루겠음.) 에 배치시킨다.

#### Runtime Data Areas 메모리 구조

메모리 구조는 5가지로 구성된다.

- *__Method Area (= Class Area = Static Area)__*
    - 클래스 정보를 처음 메모리 공간에 올릴 때 초기화 되는 대상을 저장하기 위한 메모리 공간
    - 모든 Thread가 공유한다.
    - 클래스, 변수, Method, static 변수, 상수 정보 등이 저장되는 영역이다.
        - Field Information : 멤버변수의 이름, 데이터 타입, 접근 제어자에 대한 정보
        - Method Information : 메소드의 이름, 리턴 타입, 매개변수, 접근 제어자에 대한 정보
        - Type Information : Type의 속성이 Class인지 Interface인지의 여부 저장
        - 상수 풀(Constant Pool) : 문자 상수, 타입, 필드, Method의 symbolic reference
(객체 이름으로 참조하는 것)도 저장
        - Static 변수(Class Variable) : 모든 객체가 공유 할 수 있고, 객체 생성 없이 접근 가능
        - Class 사용 이전에 메모리 할당 : final class 변수의 경우 -> (상수로 치환되어) 상수 풀에 값 복사

- *__Heap Area__*
    - 객체를 저장하는 가상 메모리 공간.(모든 Thread가 공유)
        - new 연산자로 생성된 객체와 배열을 저장한다. (class Area 영역에 올라온 클래스들만 객체로 생성 가능!)
        - Gabage Collection 이슈는 이 영역에서 일어난다.
        - Heap 영역은 Young Generation, Old Generation, Permanent Generation 으로 구성되는데 자세하게는 안다루겠다.

- *__Stack Area__*
    - 메소드 내에서 사용되는 값들(매개변수, 지역변수, 리턴값 등)이 저장되는 구역으로 메소드 호출 시마다 각각의 메소드마다 스택프레임(각 메소드를 위한 공간)이 생성이 된다. 
    - LIFO (Last In First Out)을 준수하며, 메소드를 빠져나가면(수행이 끝나면) 해당 스택프레임은 LIFO를 지키며 소멸이 된다.

- *__PC Register__*
    - Thread가 생성 될 때마다 생성되는 공간
    - 현재 Thread가 실행되는 부분의 주소와 명령과 저장

- *__Native Method Stack__*
    - 자바의 언어로 작성된 네이티브 코드를 위한 메모리 영역

<br>

## JDK와 JRE의 차이
>JRE (Java Runtime Environment) 자바 런타임(실행) 환경

JRE는 말 그대로 자바를 실행하기 위해 필요한 필수적인 컴포넌트들을 제공한다. (그러나 새 프로그램은 작성할 수 없다.)

JVM (Java Virtual Machine), Java 클래스 라이브러리 등 자바를 실행하기 위한 모든 패키지를 제공한다.

<br>

>JDK (Java Development Kit) 자바 개발 키트 ( JRE의 상위 집합 / JDK > JRE > JVM )
JDK는 말 그대로 자바를 개발하기 위해 필요한 기능(javac, java 등) 들을 제공한다.

JRE = JVM + JAVA 패키지 클래스 (java.util , java.Math, java.lang , java.awt , java.Swing 등) + 런타임 라이브러리

JDK = JRE + 개발/디버깅 툴 (javac, java 등)
