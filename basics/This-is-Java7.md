## 목차
[7.1 상속 개념](#71-상속-개념)   
[7.2 클래스 상속](#72-클래스-상속)   
[7.3 부모 생성자 호출](#73-부모-생성자-호출)   
[7.4 메소드 재정의](#74-메소드-재정의)   
[7.5 final 클래스와 final 메소드](#75-final-클래스와-final-메소드)   
[7.6 protected 접근 제한자](#76-protected-접근-제한자)   
[7.7 타입변환과 다형성(1)](#77-타입변환과-다형성1)   
[7.7 타입변환과 다형성(2)](#77-타입변환과-다형성2)   

## **7.1 상속 개념**

![Untitled](./images/7.png)

- 현실: 부모가 자식 선택, 상속해 줌
- 객체 지향 프로그램: 자식이 부모 선택, 상속 받음

![Untitled](./images/7(1).png)

![Untitled](./images/7(2).png)

- 패키지가 다를 경우, package2에 있는 자식 클래스는 package2에 있는 부모 클래스가 가진 `default` 필드와 메서드를 상속 받지 못함

## **7.2 클래스 상속**

![Untitled](./images/7(3).png)

## **7.3 부모 생성자 호출**

![Untitled](./images/7(4).png)

- 자식 클래스로부터 자식 객체를 생성할 때: 부모 객체 생성 → 자식 객체 생성
    
    ```java
    public DmbCellPhone () { // 자식 객체가 생성될 때,
    	super(); // 컴파일러가 자동으로 넣은 super()가 먼저 부모의 기본 생성자를 호출
    } // 자식 생성자 생성
    ```
    
- dmbCellPhone 변수는 자식 객체를 참조함

![Untitled](./images/7(5).png)

- 자식 생성자 안에 super()라는 부모 생성자를 선언하지 않아도 컴파일러가 자동으로 추가
- 자식 생성자 안에서 부모 생성자의 기본 생성자를 호출해서 부모 객체 생성 → 그 후 자식 객체 생성
- 개발자가 직접 super를 작성하고 매개값을 추가할 수도 있음
- 부모 클래스에 매개변수 없는 기본 생성자가 없다면 자식 클래스에 super() 선언 해줘야 함

## **7.4 메소드 재정의**

![Untitled](./images/7(6).png)

- 메서드 재정의 = 오버라이드
- @Override: 코드가 제대로 작성했는지 검사하는 어노테이션

![Untitled](./images/7(7).png)

- 재정의된 method2()는 부모 클래스가 아닌 자식 클래스의 메서드를 가리킴
- override 단축기: ctrl + space

![Untitled](./images/7(8).png)

- 부모 메서드를 호출해서 사용하는 경우 ⇒ super 키워드 사용
- super: 부모 객체의 참조(자기 자신 객체의 참조 this와 비슷)
- 메서드 재정의:
    - 앞에 아무것도 안 붙은 경우: 자식 클래스의 메서드
    - 앞에 super가 붙은 경우: 부모 클래스의 메서드

## **7.5 final 클래스와 final 메소드**

![Untitled](./images/7(9).png)

- final은 필드, 클래스, 메서드 앞에 모두 붙을 수 있음
- final 필드: 수정 불가능한 필드
- final 클래스, 메서드: 부모로 사용할 수 없는 클래스, 자식이 재정의할 수 없는 메서드
- 예) String 클래스 ⇒ 부모로 사용할 수 없음
    
    ```java
    public final class String {...}
    ```
    

## **7.6 protected 접근 제한자**

![Untitled](./images/7(10).png)

- protected 접근 제한자: 다른 패키기에 있는 클래스의 경우 자식 클래스에게 상속만 가능
- 예1) 같은 패키지의 A, B: A의 protected 필드를 B에서 사용 가능
- 예2) 다른 패키지의 A, C, D:
    - A의 protected 필드를 C에서 사용 불가능
    - A의 protected 필드를 자식 클래스 D에서 사용 가능

## **7.7 타입변환과 다형성(1)**

![Untitled](./images/7(11).png)

![Untitled](./images/7(12).png)

- A타입을 상속 받은 B, C에 대해,
    
    ```java
    A a = new B();
    A a = new C();
    ```
    
    와 같이 표현할 수 있음.
    
- Animal 타입을 상속받은 Cat, Dog에 대해,
    
    ```java
    Animal a = new Cat();
    Animal a = new Dog();
    ```
    
    와 같이 표현할 수 있음.
    
- 다형성: 하나의 타입에 종류가 다른 다양한 객체를 대입할 수 있는 성질
- 다형성은 객체를 부품화 시킬 수 있어, 자동차에 각기 다른 브랜드의 타이어를 부착하는 것처럼 자유롭게 바꿔 끼울 수 있음

![Untitled](./images/7(13).png)

- 자동 타입 변환: 부모 타입에 여러 자식 객체를 대입할 수 있음

![Untitled](./images/7(14).png)

- cat == animal은 같은 번지를 참조하므로 true지만, 타입은 각각 Cat, Animal로 다름

![Untitled](./images/7(15).png)

- A에는 B, C, D, E 모두 대입 가능
- B에는 D 대입 가능
- C에는 E 대입 가능

![Untitled](./images/7(16).png)

- method3()은 온전히 자식 클래스의 메서드므로 부모 타입 변수로는 사용할 수 없음
- method2()는 자식 클래스의 재정의된 메서드가 실행되는데, child의 타입을 변환한다고 해서 Child 클래스가 없어지는 건 아니기 때문

## **7.7 타입변환과 다형성(2)**

![Untitled](./images/7(17).png)

- 필드, 매개변수를 통해서 등 다형성이 발생할 수 있음