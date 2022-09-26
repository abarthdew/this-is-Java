## 목차
[9.1 중첩 클래스와 중첩 인터페이스란?](#91-중첩-클래스와-중첩-인터페이스란)   
[9.2 중첩 클래스](#92-중첩-클래스)   
[9.3 중첩 클래스의 접근 제한](#93-중첩-클래스의-접근-제한)   
[9.4 중첩 인터페이스](#94-중첩-인터페이스)   
[참고자료](#참고자료)   

## **9.1 중첩 클래스와 중첩 인터페이스란?**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/9.png)

- 외부에서 사용하지 않고, 해당 클래스나 인터페이스 안에서만 사용

## **9.2 중첩 클래스**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/9(1).png)

- 멤버 클래스: 클래스 선언부에 선언된 중첩 클래스
    - 인스턴스 멤버 클래스: 객체 A가 생성이 되어야 클래스 B를 쓸 수 있음
    - 정적 멤버 클래스: 객체 A가 생성되지 않아도 클래스 B 사용 가능
- 로컬 클래스: 메서드 안에서 선언된 중첩 클래스(static을 붙일 수 없음)
- 중첩 클래스의 바이트 코드 파일: 멤버 클래스일 경우 $만 붙고, 로컬 클래스일 경우 $에 순번이 붙음

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/9(2).png)

- 인스턴스 멤버 클래스는 바깥 클래스 A가 생성되어야 클래스 B를 사용할 수 있음
- 중첩 클래스 B에서 static 필드, static 메서드 사용 불가

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/9(3).png)

- 바깥 객체인 A가 생성되지 않아도, C를 사용할 수 있음
- `new A.C();`와 같이, A 객체를 생성하지 않고 바로 A 클래스를 통해 C클래스에 접근 가능
- static field2, static method2는 클래스로 바로 접근 가능

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/9(4).png)

- 바깥 메서드를 벗어나 사용할 수 없음
- 중첩 클래스 내부에 정적 멤버를 사용할 수 없음
- 메서드 안에서 중첩 클래스 선언, 사용
- 중첩 클래스 선언 시 상속을 받아 부모의 멤버를 사용할 수도 있음

## **9.3 중첩 클래스의 접근 제한**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/9(5).png)

- 정적 필드 초기화
    - `static B field3 = new B();`: 에러 ⇒ 인스턴스 멤버 클래스 B는 A 객체가 생성되어야 사용 가능하기 때문에
    - `static C field4 = new C();`: 정상 작동 ⇒ C는 static으로 선언된 정적 멤버 클래스므로 A 객체 생성 전에도 사용 가능
- 정적 메서드
    - `B var1 = new B();`: 에러 ⇒ static void method2()는 정적 메서드로, A 객체 생성 없이도 사용 가능하지만 B는 A 객체가 생성되어야 사용 가능하기 때문
    - `C var2 = new C();`: 정상 작동 ⇒ C는 static으로 선언된 정적 멤버 클래스므로 A 객체 생성 전에도 사용 가능
- 중첩 클래스 중 멤버 클래스는 바깥 클래스(A)의 필드와 메서드에서 사용 가능
    - 인스턴스 필드와 인스턴스 메서드는 인스턴스 멤버 클래스, 정적 멤버 클래스 전부 사용 가능
    - 정적 필드와 정적 메서드는 정적 멤버 클래스만 사용 가능

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/9(6).png)

- 바깥 클래스(A)에 선언된 필드, 메서드를 중첩 클래스 내부에서 어떻게 접근해서 사용하는가?
- B는 인스턴스 멤버 클래스, C는 정적 멤버 클래스
- B는 A의 멤버를 전부 사용 가능
- C는 A가 생성되지 않아도 사용 가능하기 때문에, A 객체가 필요한 인스턴스 멤버는 C의 method() 안에서 사용 불가

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/9(7).png)

- 메서드 내에서 중첩 클래스를 선언하려면 메서드의 매개변수와 메서드 안 로컬 변수는 final 키워드를 붙여야 함
    
    ⇒ 메서드는 실행이 완료되면 메서드 안에서 선언된 매개변수, 로컬 변수는 스택 메모리에서 제거가 됨
    
    ⇒ 로컬 클래스의 객체가 생성되어 힙 메모리에 만들어지면, method1()의 종류와는 별도로 자기 자신의 메서드(method())를 계속 실행할 수 있음
    
    ⇒ 만약 method() 에 반복문이 있을 경우, 반복문이 실행되는 상황에서 매개변수와 로컬 변수를 계속 사용하게 됨
    
    ⇒ 그런데 이 변수가 사라져 버리면 오류가 생기기 때문에 fianl을 붙여 로컬 클래스 안쪽으로 복사해서 사용함
    
    ⇒ **자바 8에서는 final 키워드를 생략해도 됨(붙이지 않아도 자동으로 final로 해석함)**
    
- 자바 7과 8의 매개변수, 로컬 변수 차이점
    - 자바 7에서는 메서드의 매개변수와 로컬 변수를 중첩 클래스의 메서드 안에 지역 변수로 복사해서 사용
    - 자바 8에서는 메서드의 매개변수와 로컬 변수를 중첩 클래스의 필드로 복사해서 사용
- 로컬 클래스에서 메서드의 매개변수나 로컬 변수를 사용할 때, final 성격을 띄므로 값 변경 불가

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/9(8).png)

## **9.4 중첩 인터페이스**

## 참고자료

[강의교안_9장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_9%EC%9E%A5.ppt)