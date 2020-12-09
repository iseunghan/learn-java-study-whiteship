![study HALLE](../images/study_HALLE.jpg)

---

### 학습 할 내용들

-   선택문
-   반복문

### 과제 제출

-   과제 0. JUnit5 학습
-   과제 1. live-study 대시 보드를 만드는 코드 작성
-   과제 2. LinkedList 구현
-   과제 3. Stack 구현
-   과제 4. 앞서 만든 ListNode를 이용해서 Stack 구현
-   과제 5. Queue를 구현 (Optional)
    -   배열을 사용해서 한번
    -   ListNode를 사용해서 한번.

---

## 선택문

-   if문
-   switch문

#### if문

```
if (조건1) {
	// 조건1이 참일 때, 실행 ( {} 중괄호 블럭 안 부분만 실행!)
}

// if문이 종료 되고 난 후에 실행 (조건1 을 만족 안해도 실행된다.)
```

if - else 문

```
if(조건1) {
	// 조건1이 참일 때 실행
} else {
	// 조건1이 거짓일 때 실행
}
```

다중 if문

```
if(조건1) {
	// 조건1이 참일 때 실행
} else if (조건2) {
	// 조건2이 참일 때 실행
} else if (조건3) {
	// 조건3이 참일 때 실행
} ..
  ..
else {
	// 모든 조건을 만족 하지 못할 경우 실행
}
```

#### switch 문

```
Scanner sc = new Scanner(System.in);
int input = sc.nextInt();

switch(input) {
    case 0:
        // input이 0일 경우에 실행!
        break; //case에는 항상 break를 넣어줘서 종료 시켜줘야함!
    case 1:
        // input이 1일 경우에 실행!
        break;
    case 2: case 3:
        // input이 2, 3일 경우에 실행!
        break;
    default :
        // case 설정 안한 값일 경우에 실행!
        break;
}
```

## 반복문

-   while문

```
while(조건) { // 조건이 참일 경우에만 실행, 거짓이면 종료!
	//참일 때 실행
	..
    
}
```

예시 코드

```
int N = 1;

while(N < 10) { // N=10일때 종료!

	System.out.print(N + " ");
    N++;
}
// 실행결과 : 1 2 3 4 5 6 7 8 9 

```

-   do-while문

```
do { // 조건 검사 이전에 먼저 실행!
	System.out.println(N + " ");
	N++;
    
} while( N < 10 ); // 실행이 끝나고 조건을 검사! N = 11일 때 종료!

// 실행결과 : 1 2 3 4 5 6 7 8 9 10
```

-   for문

for문의 실행 순서

[##_Image|kage@drA1mg/btqON8cfF4u/gnLoMkqVifKFq0Q4zJdy0k/img.png|alignCenter|width="476" height="NaN" data-origin-width="0" data-origin-height="0" data-ke-mobilestyle="widthContent"|||_##]

```
int N = 10;

for(int i=N; i>=1; i--){ // N = 10 부터~ 1까지 반복!
	System.out.print(N + " ");
}

// 실행결과 : 10 9 8 7 6 5 4 3 2 1
```

---

## 과제 0. JUnit 5 학습하세요.

---

-   인텔리J, 이클립스, VS Code에서 JUnit 5로 테스트 코드 작성하는 방법에 익숙해 질 것.
-   이미 JUnit 알고 계신분들은 다른 것 아무거나!

JUnit5 부터는 모듈의 집합으로 구성이 되어있다. (java8 이상의 버전을 필요로 하지만, 이전 JDK 버전이여도 컴파일된 코드도 테스트 가능)

> **JUnit 5 = Junit Platform + Junit Jupiter + Junit Vintage 로 구성 되어 있다.**

-   **JUnit Platform**
    -   Testing Frameworks를 구동하기 위한 역할을 한다.
    -   Testing Frameworks를 개발하기 위한 TestEngine API를 제공한다.
    -   Console Launcher를 제공한다.
-   **JUnit Jupiter**
    -   JUnit5 에서 테스트 및 확장을 작성하기 위한 새로운 프로그래밍 모델과 확장 모델이다. TestEngine을 제공한다.
-   **JUnit Vintage**
    -   JUnit3 와 JUnit4 기반 테스트를 실행하기 위한 TestEngine을 제공한다.

### 테스트를 작성하는 법

---

테스트를 진행하기 위해 Sample 클래스를 하나 생성한다. 간단하게 name과 price를 가지고 있다.

[##_Image|kage@NHQvC/btqO6f8hOhY/vf3BUGX8KzoQm2u7HV4f2K/img.png|alignCenter|data-origin-width="0" data-origin-height="0" width="469" height="NaN" data-ke-mobilestyle="widthContent"|||_##]

**Ctrl** + **shift** + **T** 를 누르면 테스트를 생성 할 수 있다.

#### 테스트 이름은 **...test** 라고 이름을 설정하는게 좋다.

[##_Image|kage@0riFC/btqOS8i9Z3a/kBmdnC5TOAGiS3BpfI6jgK/img.png|alignCenter|data-origin-width="0" data-origin-height="0" data-ke-mobilestyle="widthContent"|||_##]

이 테스트에서는 간단하게 sample에다가 "sample1"이름을 넣고, sample.getName()이 sample1을 리턴하는지 테스트를 하는 코드이다.

-   기본 문법은 Given , When , Then 세가지로 나눈다.
-   assertEqauls( **expected , Actual** ); 기대값과 비교 할 실제 값을 넣어준다.

#### 테스트를 실행해주면 ?

[##_Image|kage@bS7600/btqOYtNxGDB/ZKKYPni5qfnNbeM8reySpk/img.png|alignCenter|data-origin-width="0" data-origin-height="0" width="607" height="NaN" data-ke-mobilestyle="widthContent"|||_##]

실행이 아주 잘 되는것을 알 수 있다.

#### 만약 **sample2**라고 예측하고 테스트를 돌리게 되면?

[##_Image|kage@rvLJ2/btqO6h6b3D6/kuN4f49AcUn1aAN3mchTtK/img.png|alignCenter|data-origin-width="0" data-origin-height="0" data-ke-mobilestyle="widthContent"|||_##]

기대 값은 sample2 인데 , 실제 값은 sample1이 반환되어서 테스트가 깨지게 된다.

#### **@DisplayName** : 테스트 메소드 이름 설정하는 법

[##_Image|kage@b0m8v2/btqO3yUEKcR/Qd7lWxZZ8Xzhg95gkk8rm0/img.png|alignCenter|data-origin-width="0" data-origin-height="0" data-ke-mobilestyle="widthContent"|||_##]

-   @DisplayName( String s ) 를 설정해주면, 아래와 같이 테스트 실행하면 내가 설정한 이름이 나오게 된다. 테스트 개수가 엄청 많을 경우에 이 기능을 사용하면 테스트를 구별할 때 편리 할 것이다.

[##_Image|kage@DGOMj/btqO6hrBzlF/qggGWYyP7zQv3ps2jLzEEK/img.png|alignCenter|data-origin-width="0" data-origin-height="0" data-ke-mobilestyle="widthContent"|||_##]

JUnit 테스트에 대해서는 나중에 포스트로 더 자세히 다루겠습니다.

---

## **과제 1. live-study 대시 보드를 만드는 코드를 작성하세요.**

---

-   깃헙 이슈 1번부터 18번까지 댓글을 순회하며 댓글을 남긴 사용자를 체크 할 것.
-   참여율을 계산하세요. 총 18회에 중에 몇 %를 참여했는지 소숫점 두자리가지 보여줄 것.
-   [Github 자바 라이브러리](https://github-api.kohsuke.org/)를 사용하면 편리합니다.
-   깃헙 API를 익명으로 호출하는데 제한이 있기 때문에 본인의 깃헙 프로젝트에 이슈를 만들고 테스트를 하시면 더 자주 테스트할 수 있습니다.

---

## 과제 2. LinkedList를 구현하세요.

---

-   LinkedList에 대해 공부하세요.
-   정수를 저장하는 ListNode 클래스를 구현하세요.
-   ListNode add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요.
-   ListNode remove(ListNode head, int positionToRemove)를 구현하세요.
-   boolean contains(ListNode head, ListNode nodeTocheck)를 구현하세요.

[iseunghan.tistory.com/232?category=912560](https://iseunghan.tistory.com/232?category=912560)

[

LinkedList 개념, 사용법, 코드

LinkedList 의 개념 ArrayList 배열의 구조를 사용한다. 그렇기 때문에 데이터를 삭제하거나 추가하면 더 큰 공간으로 (또는 더 작은 공간으로) 이동해야 한다. (시간이 많이 소요됨) 만약 크기가 5인 li

iseunghan.tistory.com



](https://iseunghan.tistory.com/232?category=912560)

---

## 과제 3. Stack을 구현하세요.

---

-   int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.
-   void push(int data)를 구현하세요.
-   int pop()을 구현하세요.

---

## 과제 4. 앞서 만든 ListNode를 사용해서 Stack을 구현하세요.

---

-   ListNode head를 가지고 있는 ListNodeStack 클래스를 구현하세요.
-   void push(int data)를 구현하세요.
-   int pop()을 구현하세요.

---

## (optional) 과제 5. Queue를 구현하세요.

---

-   배열을 사용해서 한번
-   ListNode를 사용해서 한번.

---

## References

[raccoonjy.tistory.com/10](https://raccoonjy.tistory.com/10)
