### 목표

자바의 프리미티브 타입, 변수 그리고 배열을 사용하는 방법을 익힙니다.

### 학습할 것

-   프리미티브 타입 종류와 값의 범위 그리고 기본 값
-   프리미티브 타입과 레퍼런스 타입
-   리터럴
-   변수 선언 및 초기화하는 방법
-   변수의 스코프와 라이프타임
-   타입 변환, 캐스팅 그리고 타입 프로모션
-   1차 및 2차 배열 선언하기
-   타입 추론, var

---

### 프리미티브 타입 종류와 값의 범위 그리고 기본 값

자바는 총 8가지의 기본형 타입(Primitive Type)을 미리 정의하여 제공한다.

기본 값이 있기 때문에 null이 존재하지 않는다. 만약 null을 넣고 싶다면 래퍼 클래스를 활용한다.

<table style="border-collapse: collapse; width: 100.348%; height: 554px;" border="1" data-ke-style="style12"><tbody><tr style="height: 19px;"><td style="width: 11.3594%; text-align: center; height: 19px;">&nbsp;</td><td style="width: 20.8065%; text-align: center; height: 19px;"><span style="color: #000000;">타입</span></td><td style="width: 21.8433%; text-align: center; height: 19px;"><span style="color: #000000;">할당되는 메모리 크기</span></td><td style="width: 15.8526%; text-align: center; height: 19px;"><span style="color: #000000;">기본 값</span></td><td style="width: 30.1382%; text-align: center; height: 19px;"><span style="color: #000000;">데이터의 표현 범위</span></td></tr><tr style="height: 19px;"><td style="width: 11.3594%; text-align: center; height: 19px;"><span style="color: #000000;">논리형</span></td><td style="width: 20.8065%; text-align: center; height: 19px;"><span style="color: #000000;">boolean</span></td><td style="width: 21.8433%; text-align: center; height: 19px;"><span style="color: #000000;">1 byte</span></td><td style="width: 15.8526%; text-align: center; height: 19px;"><span style="color: #000000;">false</span></td><td style="width: 30.1382%; text-align: center; height: 19px;"><span style="color: #000000;">true, false</span></td></tr><tr style="height: 19px;"><td style="width: 11.3594%; text-align: center; height: 79px;" rowspan="4"><span style="color: #000000;">정수형</span></td><td style="width: 20.8065%; text-align: center; height: 19px;"><span style="color: #000000;">byte</span></td><td style="width: 21.8433%; text-align: center; height: 19px;"><span style="color: #000000;">1 byte</span></td><td style="width: 15.8526%; text-align: center; height: 19px;"><span style="color: #000000;">0</span></td><td style="width: 30.1382%; text-align: center; height: 19px;"><span style="color: #000000;">-128 ~ 127</span></td></tr><tr style="height: 19px;"><td style="width: 20.8065%; text-align: center; height: 19px;"><span style="color: #000000;">short</span></td><td style="width: 21.8433%; text-align: center; height: 19px;"><span style="color: #000000;">2 byte</span></td><td style="width: 15.8526%; text-align: center; height: 19px;"><span style="color: #000000;">0</span></td><td style="width: 30.1382%; text-align: center; height: 19px;"><span style="color: #000000;">-32,768 ~ 32,767</span></td></tr><tr style="height: 22px;"><td style="width: 20.8065%; text-align: center; height: 22px;"><span style="color: #000000;">int(기본)</span></td><td style="width: 21.8433%; text-align: center; height: 22px;"><span style="color: #000000;">4 byte</span></td><td style="width: 15.8526%; text-align: center; height: 22px;"><span style="color: #000000;">0</span></td><td style="width: 30.1382%; text-align: center; height: 22px;"><span style="color: #000000;">-2,147,483,648</span><br><span style="color: #000000;">~ 2,147,483,648</span></td></tr><tr style="height: 19px;"><td style="width: 20.8065%; text-align: center; height: 19px;"><span style="color: #000000;">long</span></td><td style="width: 21.8433%; text-align: center; height: 19px;"><span style="color: #000000;">8 byte</span></td><td style="width: 15.8526%; text-align: center; height: 19px;"><span style="color: #000000;">0L</span></td><td style="width: 30.1382%; text-align: center; height: 19px;"><span style="color: #000000;">&nbsp;-9,223,372,036,854,775,808&nbsp;<br>~&nbsp;9,223,372,036,854,775,807</span></td></tr><tr style="height: 19px;"><td style="width: 11.3594%; text-align: center; height: 38px;" rowspan="2"><span style="color: #000000;">실수형</span></td><td style="width: 20.8065%; text-align: center; height: 19px;"><span style="color: #000000;">float</span></td><td style="width: 21.8433%; text-align: center; height: 19px;"><span style="color: #000000;">4 byte</span></td><td style="width: 15.8526%; text-align: center; height: 19px;"><span style="color: #000000;">0.0F</span></td><td style="width: 30.1382%; text-align: center; height: 19px;"><span style="color: #000000;">(3.4 X 10-38) ~ (3.4 X 1038) 의 근사값</span></td></tr><tr style="height: 19px;"><td style="width: 20.8065%; text-align: center; height: 19px;"><span style="color: #000000;">double(기본)</span></td><td style="width: 21.8433%; text-align: center; height: 19px;"><span style="color: #000000;">8 byte</span></td><td style="width: 15.8526%; text-align: center; height: 19px;"><span style="color: #000000;">0.0</span></td><td style="width: 30.1382%; text-align: center; height: 19px;"><span style="color: #000000;">(1.7 X 10-308) ~ (1.7 X 10308) 의 근사값</span></td></tr><tr style="height: 97px;"><td style="width: 11.3594%; text-align: center; height: 97px;"><span style="color: #000000;">문자형</span></td><td style="width: 20.8065%; text-align: center; height: 97px;"><span style="color: #000000;">char</span></td><td style="width: 21.8433%; text-align: center; height: 97px;"><span style="color: #000000;">2 byte (유니코드)</span></td><td style="width: 15.8526%; text-align: center; height: 97px;"><span style="color: #000000;">"Wu0000"</span></td><td style="width: 30.1382%; text-align: center; height: 97px;"><span style="color: #000000;">&nbsp;0 ~ 65,535</span></td></tr></tbody></table>

---

### 프리미티브 타입과 레퍼런스 타입

-   _**프리미티브 타입 (Primitive Type)**_
    -   실제 값이 저장되는 공간이므로 _**스택(Stack)**_ 메모리에 저장이 된다.
-   _**레퍼런스 타입 (Reference Type)**_
    -   기본형 타입을 제외한 모든 타입들은 참조형 타입 (Reference Type) 이다.
    -   빈 객체를 의미하는 null이 존재.
    -   객체의 _**주소값**_ 을 저장하므로 _**힙(Heap)**_ 메모리에 저장된다.

#### 레퍼런스 타입 (Reference Type) 종류

-   _**클래스 타입**_
    -   new 연산자로 객체를 생성하면 클래스 타입이다.

```
Car car = new Car("G80", "7000"); // 클래스 타입 객체 생성
```

```
String name = new String("name");
String name1 = "name";
```

래퍼 클래스 중 String 타입 선언

String, Integer 등 모든 래퍼 클래스는 이런 식으로 생성 할 수 있다.

-   _**배열타입**_

[##_Image|kage@AUocU/btqNWgtDgdC/vlkL27m4BmWzeGDkcMzOBK/img.png|alignCenter|data-origin-width="0" data-origin-height="0" data-ke-mobilestyle="widthContent"|배열의 참조의 메모리 구조||_##]

```
int[][] arr = new int[5][5];

System.out.println(arr);	// arr의 주소값 출력 : ex) I@74a14482 <- 이런식으로 나옴
System.out.println(arr[0]); // arr[0] 주소값 출력 : ex) I@74a14490
System.out.println(arr[1]); // arr[1] 주소값 출력 : ex) I@74a14491
System.out.println(arr[2]); // arr[2] 주소값 출력 : ex) I@74a14492
System.out.println(arr[3]); // arr[3] 주소값 출력 : ex) I@74a14493
System.out.println(arr[4]); // arr[4] 주소값 출력 : ex) I@74a14494

System.out.println(arr[0][0]); // arr[0][0] 들어있는 값 출력 : 0
...
..
System.out.println(arr[4][4]); // arr[4][4] 들어있는 값 출력 : 0
```

-   _**열거타입**_
-   _**인터페이스 타입**_

---

### 리터럴(literal)

프로그램에서 직접 표현한 값을 _**리터럴(literal)**_ 이라고 한다.

**종류**

-   정수 리터럴
-   실수 리터럴
-   문자 리터럴
-   논리 리터럴
-   문자열 리터럴

#### 정수 리터럴

> int a = 15;        ->  10진수 리터럴 15  
> int b = 015;      ->  0으로 시작하면 8진수   
> int c = 0x15;     -> 0x로 시작하면 16진수  
> int d = 0b0101;  -> 0b로 시작하면 2진수  
> long e = 1L;      -> long 타입 리터럴은 숫자 뒤에 L 또는 l을 붙인다.

#### 실수 리터럴

> double a = 0.123;  
> double b = 123E-3;  -> 123 \* (10^(-4)) a 와 동일.  
>   
> float c = 0.123f;  // Essential  
> doublc d = 0.123D; // optional

#### 문자 리터럴

**' ' 로 문자 표현**

> char a = 'A';  
> char b = '아';

#### 문자열 리터럴

**" " 로 문자열 표현**

> String a = "name";  
>   
> String b = a + "1"; //새로운 인스턴스 생성  
> +(연산자) 사용 가능 

  
참고 - [https://mine-it-record.tistory.com/100](https://mine-it-record.tistory.com/100)

---

### 변수 선언 및 초기화하는 방법

변수 선언

```
int a; // a 라는 이름의 int 형 변수 선언
```

변수 초기화

```
a = 1; // a에 1 값을 넣는다
```

변수를 선언함과 동시에 초기화

```
int a = 1; // 선언과 동시에 초기화
```

---

### 변수의 스코프와 라이프타임

#### 변수의 스코프

프로그램상에서 사용되는 변수들은 사용 가능한 범위(**스코프**)를 가진다. 

변수가 선언된 블럭이 그 변수의 **사용범위**이다.

```
public class Test{

        int globalScope = 10;   // 인스턴스 변수 

        public void scopeTest(int value){   
            int localScope = 10;
            System.out.println(globalScope); // 사용가능!
            System.out.println(localScpe);
            System.out.println(value);
        }
    }
```

-   클래스 속성으로 선언된 변수 globalScope의 스코프는 클래스 전체가 된다.
-   메소드 블럭 내에서 선언된 localScope의 스코프는 메소드 블럭 내에서 이다.

**main메소드에서 사용하기**

```
public class Test {
        int globalScope = 10; 

        public void scopeTest(int value){
            int localScope = 20;            
            System.out.println(globalScope);
            System.out.println(localScope);
            System.out.println(value);
        }   
        public static void main(String[] args) {
            System.out.println(globalScope);  //오류
            System.out.println(localScope);   //오류
            System.out.println(value);        //오류  
        }   
    }
```

-   globalScope는 같은 클래스앞에 있어도 사용 할 수 없다. 
    -   main메소드는 static이 붙었기 때문에, static 변수가 아니면 사용 할 수 없다.

#### 변수의 라이프타임

전역변수 : 클래스가 종료되면 끝난다.

지역변수 : 메소드 내부에 선언된 변수 -> 메소드 실행 시 메모리에 로딩, 메소드 종료 시 메모리 해제

---

### 타입 변환, 캐스팅 그리고 타입 프로모션

#### 타입 변환

-   묵시적 타입 변환(자동 타입 변환)
-   명시적 타입 변환(강제 타입 변환)

**묵시적 타입 변환(자동 타입 변환, implicit conversion)**

[##_Image|kage@9KqJQ/btqNWDI6pnO/Sr78bpNOw6my8vSJAlg7dK/img.png|alignCenter|data-origin-width="0" data-origin-height="0" data-ke-mobilestyle="widthContent"|자동 타입 변환||_##]

```
double num1 = 10; // int -> double 로 자동 타입 변환 발생
int num2 = 3.14; // 데이터 손실 : 컴파일러가 오류 발생
double num3 = 7.0f + 3.14; // 자동으로 float -> double 형으로 타입 변환

System.out.println(num1); // 10.0
System.out.println(num3); // 10.14
```

**명시적 타입 변환(강제 타입 변환, explicit conversion)**

```
int num1 = 1;
int num2 = 4;

double result1 = num1 / num2;  // 0.0
double result2 = (double) num1 / num2;  // 0.25
```

int형 데이터 끼리 연산한 결과값은 항상 int값이 출력된다.

---

### 1차 및 2차 배열 선언하기

**배열 선언**

-   **1차 배열**

```
int[] arr = new int[5];
int[] arr1 = {1,2,3,4,5}; // 선언과 동시에 초기화
```

-   **2차 배열**

```
int[][] arr1 = new int[3][3];

int[][] arr = {
    {10, 20, 30},
    {40, 50, 60}
}; // 선언과 동시에 초기화

```

**배열의 메모리 참조 과정**

[##_Image|kage@AUocU/btqNWgtDgdC/vlkL27m4BmWzeGDkcMzOBK/img.png|alignCenter|data-origin-width="0" data-origin-height="0" data-ke-mobilestyle="widthContent"|배열의 참조의 메모리 구조||_##]

```
int[][] arr = new int[5][5];

System.out.println(arr);	// arr의 주소값 출력 : ex) I@74a14482 <- 이런식으로 나옴
System.out.println(arr[0]); // arr[0] 주소값 출력 : ex) I@74a14490
System.out.println(arr[1]); // arr[1] 주소값 출력 : ex) I@74a14491
System.out.println(arr[2]); // arr[2] 주소값 출력 : ex) I@74a14492
System.out.println(arr[3]); // arr[3] 주소값 출력 : ex) I@74a14493
System.out.println(arr[4]); // arr[4] 주소값 출력 : ex) I@74a14494

System.out.println(arr[0][0]); // arr[0][0] 들어있는 값 출력 : 0
...
..
System.out.println(arr[4][4]); // arr[4][4] 들어있는 값 출력 : 0
```

---

### 타입 추론, var

자바 10 부터 데이터 타입을 추론 해주는 _**var**_ 타입이 생겼다.

_**var **_타입은 데이터 타입을 명시하지 않아도 컴파일러가 변수의 타입을 추론해서 정해주는 것이다.

```
var a = 10;	// var = int
var b = "string"; // var = String

long c = 1L;
var b = a; // var = long


```

---

참고 : 

[programmers.co.kr/learn/courses/5/lessons/231](https://programmers.co.kr/learn/courses/5/lessons/231)

[www.tcpschool.com/java/java\_array\_twoDimensional](http://www.tcpschool.com/java/java_array_twoDimensional)
