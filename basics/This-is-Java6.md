## 목차
[6.1 객체 지향 프로그래밍](#61-객체-지향-프로그래밍)   
[6.2 객체와 클래스](#62-객체와-클래스)   
[6.3 클래스 선언](#63-클래스-선언)   
[6.4 객체 생성과 클래스 변수](#64-객체-생성과-클래스-변수)   
[6.5 클래스의 구성 멤버](#65-클래스의-구성-멤버)   
[6.6 필드](#66-필드)   
[6.7 생성자(1)](#67-생성자1)   
[6.7 생성자(2)](#67-생성자2)   
[6.8 메소드(1)](#68-메소드1)   
[6.8 메소드(2)](#68-메소드2)   
[6.8 메소드(3)](#68-메소드3)   
[6.9 인스턴스 멤버와 this](#69-인스턴스-멤버와-this)   

## **6.1 객체 지향 프로그래밍**

- 자바로 객체 지향 프로그래밍을 작성하기 위해서는 클래스부터 선언해야 함

![Untitled](./images/6.png)

- 객체지향 프로그래밍: 자동차를 만들 때, 타이어 객체, 엔진 객체, 문 객체, 핸들 객체를 합쳐 만드는 것처럼, 각 부품 객체들을 조립해 완성된 프로그램을 만드는 것
- 객체: 속성과 동작을 가지는 모든 것
- 자바 객체: 필드(속성), 메서드(동작)으로 구성됨
- 객체 모델링: 현실 세계를 소프트웨어 객체로 변환하는 것

![Untitled](./images/6(1).png)

![Untitled](./images/6(2).png)

- 집합 관계: “어떤 부품들이 모여 완성품이 만들어진다”
    - 엔진 객체, 타이어 객체, 핸들 객체 → 자동차 객체
- 사용 관계: “어떤 객체가 어떤 객체의 메서드를 호출해서 사용한다”
    - 사람이 → 자동차를 사용
- 상속 관계: “어떤 객체가 어떤 객체의 내용을 물려받아서 사용한다”
    - 자동차 객체는 → 기계 객체의 데이터(속성, 동작)을 사용할 수 있음

![Untitled](./images/6(3).png)

- 실제 필드와 메서드를 외부로부터 보이지 않게 구조를 숨김
- 몇 가지 필드와 메서드만 외부에 제공

![Untitled](./images/6(4).png)

![Untitled](./images/6(5).png)

- 객체의 부품화: 그때그때 객체를 바꿔 끼워 사용할 수 있음
- 다형성: 설계할 때 타입은 ‘타이어’로 모두 동일하지만, 실제 구현 객체는 ‘타이어의 하위 객체’인 한국 타이어, 금호 타이어로, 실행 결과가 다양하게 나올 수 있음

## **6.2 객체와 클래스**

![Untitled](./images/6(6).png)

## **6.3 클래스 선언**

![Untitled](./images/6(7).png)

![Untitled](./images/6(8).png)

- 2개 이상의 Class가 선언된 소스 파일을 컴파일 하면, 선언된 Class 개수만큼 바이트 코드 파일 생성됨
- 하나의 소스 파일은 Class들을 담고 있는 그릇 역할만 하고, 컴파일 되어 나오는 바이트 코드 파일의 수는 Class의 수가 결정함

## **6.4 객체 생성과 클래스 변수**

![Untitled](./images/6(9).png)

- new 연산자로 생성된 클래스 객체는 힙 영역에 위치
- new 연산자는 힙 영역에 생성된 객체의 번지를 리턴하고, 이 번지가 스택 영역에 선언된 클래스 변수에 저장됨

![Untitled](./images/6(10).png)

- 클래스 용도
    - 1) 라이브러리
        - 클래스를 작성할 때, main() 메서드를 넣지 않고 필드, 생성자, 메서드 내용으로만 클래스를 작성하게 되면 그 클래스는 실행할 수 없는 클래스가 됨
        - 라이브러리용 클래스는 반드시 객체를 생성한 후 사용해야 함(정적 필드, 정적 메서드 제외)
        - 예) Student 객체
    - 2) 실행용: main()

## **6.5 클래스의 구성 멤버**

![Untitled](./images/6(11).png)

- 생성자
    - 객체 생성. 초기화 담당. `실행 블록({})`을 가짐.
    - `new 생성자();` 로 생성자를 호출하므로, 이때 생성자의 `{}`이 실행되고, 블록이 끝나는 시점에서 객체가 완성됨.
    - 리턴 타입이 없음
- 메서드: void 외 리턴 타입을 반드시 지정해야 함

## **6.6 필드**

![Untitled](./images/6(12).png)

![Untitled](./images/6(13).png)

![Untitled](./images/6(14).png)

![Untitled](./images/6(15).png)

## **6.7 생성자(1)**

![Untitled](./images/6(16).png)

![Untitled](./images/6(17).png)

![Untitled](./images/6(18).png)

![Untitled](./images/6(19).png)

![Untitled](./images/6(20).png)

## **6.7 생성자(2)**

![Untitled](./images/6(21).png)

![생성자 코드 중복의 예시](./images/6(22).png)

생성자 코드 중복의 예시

![Untitled](./images/6(23).png)

- 중복 코드를 피하는 방법: this() 사용
- this(): 객체의 다른 생성자를 지칭, 즉 자신의 다른 생성자를 지칭

```java
Car(String model, String color, int maxSpeed) {
	this.model = model;
	this.color = color;
	this.maxSpeed = maxSpeed;
}
// (1) 공통 실행 코드를 작성해 놓고, this()로 이 코드를 호출함

Car(String model) { // (2)
	this(model, null, 0); // 생성자를 호출만 함(매개변수 외의 값은 기본값)
// 즉, (2)는내부적으로 (1)에 선언한 생성자를 실행하는 것
}
```

- this()는 생성자의 가장 첫 줄에 작성되어야 함

```java
// 올바른 예
Car(String model) {
	this(model, null, 0);
	System.out.println();
}
```

```java
// 올바르지 않은 예
Car(String model) {
	System.out.println();
	this(model, null, 0);
}
```

## **6.8 메소드(1)**

![Untitled](./images/6(24).png)

![Untitled](./images/6(25).png)

![Untitled](./images/6(26).png)

![Untitled](./images/6(27).png)

## **6.8 메소드(2)**

![Untitled](./images/6(28).png)

![Untitled](./images/6(29).png)

## **6.8 메소드(3)**

![Untitled](./images/6(30).png)

![Untitled](./images/6(31).png)

![Untitled](./images/6(32).png)

- method1()을 double타입으로 받으면 double로 자동 타입 전환됨

![Untitled](./images/6(33).png)

![Untitled](./images/6(34).png)

## **6.9 인스턴스 멤버와 this**