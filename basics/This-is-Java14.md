## 목차
[14.1 람다식이란](#141-람다식이란)   
[14.2 람다식 기본 문법](#142-람다식-기본-문법)   
[14.3 타겟 타입과 함수적 인터페이스](#143-타겟-타입과-함수적-인터페이스)   
    [- 실습 - 14.3.lambda](#실습---143lambda)   
[14.4 클래스 멤버와 로컬 변수 사용](#144-클래스-멤버와-로컬-변수-사용)   
[14.5 표준 API의 함수적 인터페이스](#145-표준-api의-함수적-인터페이스)   
[14.6 메소드 참조](#146-메소드-참조)   
    [- 정리 - 메서드 레퍼런스를 사용하는 방법](#정리---메서드-레퍼런스를-사용하는-방법)   
[참고자료](#참고자료)   

## **14.1 람다식이란**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14.png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(1).png)

- 함수적 인터페이스: 한 개의 메서드를 가지고 있는 인터페이스 / 한 개의 메서드를 정의하고 있는 인터페이스
- 예) Runnable 인터페이스는 run() 이라는 메서드를 하나만 가지고 있음
- `new Runnable() {…}` 이런 식으로 익명 구현 객체를 만들 수 있는데, 이와 똑같은 역할을 하는 것이 람다식
- 함수적 인터페이스는 한 개의 메서드만 가지고 있기 때문에, 다음과 같은 식으로 Runnable 변수에 람다식 대입 가능
    
    ```java
    Runnable runnable = () -> {...};
    // Runnable 변수에 람다식을 대입
    // 자바는 runnable이 가지고 있는 메서드를 찾게 됨 -> run() 밖에 없음
    // 매개값이 없으므로 ()는 빈 값
    
    // (): 매개변수
    // {}: 코드 블록
    ```
    
    ```java
    // 람다식
    (매개변수) -> {...코드블록...}
    
    // 익명 구현 객체
    new Runnable() {
    	public void run(매개변수) {...코드블록...}
    }
    ```
    
- 어떤 인터페이스를 구현할지는 대입되는 인터페이스에 달려있음
    - 예시에서는 Runnable이었으므로, 여기에 대입되는 람다식은 run()을 실행

## **14.2 람다식 기본 문법**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(2).png)

1. 매개변수의 타입: 함수적 인터페이스의 메서드 타입을 보고 자동으로 인식되기 때문에 **생략 가능**
2. 하나의 매개변수만 있을 때: 괄호 생략 가능
3. 하나의 실행문만 있을 때: 중괄호 생략 가능
4. 매개변수가 없을 시 괄호 새ㄹㅇ략 불가능
5. 리턴값이 있을 경우, return 사용
6. 중괄호에 return 만 있을 경우, 중괄호 및 return문 생략 가능

## **14.3 타겟 타입과 함수적 인터페이스**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(3).png)

- 타겟 타입: 람다식이 대입되는 인터페이스
    - 예) `Runnable runnable = () → {…}` 의 **Runnable**
- `@FunctionalInterface`: 명시적으로 이 어노테이션을 붙여주면 자바 컴파일러가 하나의 추상 메서드만 가지는지 검사함. 필수는 아님.

### 실습 - 14.3.lambda

- 다음 람다식은 익명 객체와 동일함

```java
() -> {
    String str = "method call1";
    System.out.println(str);
};

() -> { System.out.println("method call2"); };

() -> System.out.println("method call3");
```

```java
new MyFuncInterface() {
    public void method() {
        System.out.println("method call4");
    };
};
```

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(4).png)

```java
@FunctionalInterface
public interface MyFuncInterface {
	public int method(intx, int y);
}

// 람다식
MyFuncInterface fi = (x, y) -> { return 값; } // method()의 리턴값이 int라고 되어 있으므로 return 값 필수
int result = fi.method(2, 5);
```

## **14.4 클래스 멤버와 로컬 변수 사용**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(5).png)

- 중첩된클래스에서 람다식이 사용되었을 경우 필드 구분
    - this.innerField: 중첩된 클래스의 인스턴스(Inner)
    - ThisExample.this.ouuterField: 바깥 쪽 클래스의 인스턴스(ThisExample)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(6).png)

- 원래 자바의 익명 구현 객체에서 로컬 변수를 사용하게 되면, 그 로컬 변수는 final 특성을 가지게 됨
- 람다식은 익명 구현 객체를 생성하므로, 역시 람다식 안에서 사용되는 로컬 변수, 매개변수는 final 특성을 가지게 됨
- 묵시적으로 final 특성을 가지므로, final을 명시하지 않아도 컴파일러가 알아서 해석함
- 예) int arg, int localVar는 final 특성을 가지므로 최초 값 대입 이후 수정 불가 ⇒ 오리지날 값을 가지고 람다식 내에서 사용 가능

## **14.5 표준 API의 함수적 인터페이스**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(7).png)

1. Runnable 객체를 만들고 그걸 new Thread(runnable) 처럼 생성자 매개값으로 넣어 스레드를 생성할 수 있지만,
2. 람다식을 쓰면 new Thread를 사용해 스레드를 생성할 때, 바로 매개값에 람다식을 넣어 사용할 수 있음
    
    ⇒ 인터페이스를 매개 타입으로 가지는 api에서, 인터페이스의 매개값을 람다식으로 작성해서 사용하는 경우가 대부분
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(8).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(9).png)

- java.util.function 패키지 내 interfaces에 접미사가 Consumer, Operator 등이 있는 것을 확인할 수 있음
1. Consumer: 데이터를 소비만 하고 끝내는 기능을 제공해 주는 함수적 인터페이스
2. Supplier: 데이터를 공급해주는 공급자 기능을 제공, 데이터를 리턴시켜주는 기능을 가지고 있음
3. Funtion: a 라는 데이터를 b로 `(타입) 변환`할 때 주로 사용
4. Operator: 어떤 데이터를 `연산`할 때 사용
5. Predicate: 어떤 매개값을 조사해서 참, 거짓 판별해서 리턴

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(10).png)

- 이들 함수적 인터페이스는 주로 어떤 api의 매개타입으로 사용됨
- 이들 함수적 인터페이스의 구현 객체를 작성할 때  람다식을 이용해 매개값으로 제공됨
- 예시)
    - 어떤 메서드의 매개변수 타입이 Consumer라고 가정
    
    ```java
    method(Consumer con) {...}
    ```
    
    - 이 메서드를 호출할 때, Consumer 타입의 변수를 매개변수로 넣어주는 대신 람다식 작성 가능
    
    ```java
    method((x) -> {
    	//...(실행문)...
    }); // Consumer는 매개값만 있고 리턴값이 없으므로 이렇게 작성
    ```
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(11).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(12).png)

- t는 accept()의 매개변수
    
    ```java
    Consumer<String> consumer = t -> { t를 소비하는 실행문; };
    // Consumer의 타입 파라미터로 String을 줬기 때문에,
    // t에 매개값을 줄 때는 반드시 String 타입이여야 함
    ```
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(13).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(14).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(15).png)

- 타입을 변환하는 역할을 함
- 예) A타입 매개값을 → B 타입으로 변환해 리턴

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(16).png)

- 매개값은 Studnet, 리턴값은 String
    
    ```java
    Function<Student, String> function = t -> { return t.getName(); };
    ```
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(17).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(18).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(19).png)

- `IntBinaryOperator`: 두 개의 정수값을 받아 하나를 리턴

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(20).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(21).png)

- andThen(), compose(): 두 개의 함수적 인터페이스가 연결되어 있는 것
    1. 첫 번째 함수적 인터페이스를 먼저 실행하고, 
    2. 그 리턴값을 받아서 그 다음 함수적 인터페이스에 매개값으로 제공을 해 주고, 
    3. 최종적인 결과값을 얻음
- andThen(), compose() 차이점: 어떤 함수적 인터페이스부터 처리하느냐
- andThen() 디폴트 메서드
    
    ```java
    인터페이스AB = 인터페이스A.andThen(인터페이스B);
    최종결과 = 인터페이스AB.method();
    ```
    
    ⇒ 인터페이스AB.method() 호출 → 인터페이스A의 람다식 먼저 실행 → 리턴된 결과값을 받아 인터페이스B의 매개값으로 제공 → 인터페이스B 람다식 실행 → 최종 결과 리턴
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(22).png)

- compose() 디폴트 메서드
    
    ```java
    인터페이스AB = 인터페이스A.compose(인터페이스B);
    최종결과 = 인터페이스AB.method();
    ```
    
    ⇒ 인터페이스AB.method() 호출 → 인터페이스B의 람다식 먼저 실행 → 리턴된 결과값을 받아 인터페이스A의 매개값으로 제공 → 인터페이스A 람다식 실행 → 최종 결과 리턴
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(23).png)

- andThen()은 거의 모두 제공, compose()는 4개만 제공됨

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(24).png)

- 결과값이 없기 때문에 매개값으로 제공될 것도 없음
    
    ⇒ andThen(), compose()는 단순히 두 함수적 인터페이스(Consumer)의 실행 순서만 정함
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(25).png)

- (1) Function<Member, **Address**> → (2) Function<**Address**, String>
    
    ⇒ (1)에서 (2) Function 함수적 인터페이스 실행할 때, (1)의 결과 값인 Address를 (2)의 매개값으로 제공
    
- (결과) Funtion<Member, String>: 결국 **Member를 제공하고, String을 얻는 것과 같음**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(26).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(27).png)

- targetObject: 비교할 것
- sourceObject: targetObject과 비교할 객체
    
    ⇒ Ojbects.equals(sourceObject, targetObject)를 test()의 결과로 리턴
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(28).png)

## **14.6 메소드 참조**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(29).png)

- IntBinaryOperator가 가지고 있는 추상 메서드의 매개 변수의 타입, 매개 변수의 수, 리턴 타입이 Math의 max() 메서드와 동일하므로 아래의 코드는 성립함
    
    ```java
    IntBinaryOperator operator = Math::max;
    // IntBinaryOperator 타입 변수도, Math.max() 메서드도 2개의 정수를 매개값으로 가지고, int 값을 리턴하기 때문에 성립함
    ```
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(30).png)

- 정적 메서드 참조
    
    ```java
    (x, y) -> Calculator.staticMethod(x, y);
    Calculator :: staticMethod;
    // 두 코드는 같음
    ```
    
- 인스턴스 메서드 참조
    
    ```java
    (x, y) -> obj.instanceMethod(x, y);
    obj :: instanceMethod;
    // 두 코드는 같음
    ```
    

### 정리 - 메서드 레퍼런스를 사용하는 방법

- Calculator 클래스의 메서드 staticMethod(), instanceMethod()의 매개 변수, 리턴 타입을 따져,
- IntBinaryOperator와 같은 **함수적 인터페이스의 추상 메서드와 같은지 다른지 생각**해야 함
- 정적이냐, 인스턴스냐에 따라 작성법도 다름

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(31).png)

- 두 개의 매개변수 a, b를 받아,
    
    실행부에서 첫번째 변수 a의 인스턴스 메서드를 호출해,
    
    두번째 매개값인 b를 매개값으로 사용
    
     ⇒  람다식으로 표현: `클래스(a의 타입)::instanceMethod`
    
- `String::compareToIngoreCase;` 와 같이 코드만 봐서는 클래스가 가진 정적 메서드를 참조하는 것 같지만, 사실 해당 클래스의 인스턴스 메서드를 호출한 것
    - 어떻게 정적 메서드인지, 인스턴스 메서드인지 구분하나?
        
        ⇒ **함수적 인터페이스의 추상 메서드의 매개 변수와 리턴 타입을 보고 결정**
        
- 함수적 인터페이스 `ToIntBiFunction`: 2개의 매개값을 받아 int로 매핑함

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/14(32).png)

- 실행부에 객체를 생성하고, 리턴하는 코드만 있을 경우 간단하게 생성자 참조를 이용할 수 있음
    
    ⇒ `클래스::new`
    
- 생성자의 매개값의 타입, 생성자의 매개값의 수는 이 생성자 참조가 대입되는 **함수적 인터페이스의 추상 메서드가 어떻게 선언되어 있는지**에 따라 결정됨
- `Function<String, Member>`: String 타입 매개변수를 받아 Member 타입으로 매핑해 리턴하는 함수적 인터페이스
    - 이 함수적 인터페이스에 대입되는 생성자 참조는 이런 모양
    
    ```java
    Function<String, Member> function = Member::new
    // function.apply() 메서드는 String 매개값을 가지며, 이를 Member타입으로 리턴함
    Member member = function.apply("angel");
    // 결국, 생성자의 매개값으로 angel을 제공해 객체를 생성하도록 함
    
    // Member::new 생성자 참조는 아래와 같은 코드를 호출하게 되어있음
    public Member(String id) { // id = angel
    	this.id = id;
    }
    ```
    
- BiFunction<String, String, Member>: 두 개의 String 타입 매개변수를 받아 Member 타입으로 매핑해 리턴하는 함수적 인터페이스
    
    ```java
    // 이 함수적 인터페이스에 대입된 생성자 참조인 Member::new는 두 개의 매개값을 제공받아 다음과 같은 객체를 생성함
    public Member(String name, String id) {
    	this.name = name;
    	this.id = id;
    }
    ```
    
- 결국, 생성자 참조로 객체를 생성할 때 중요한 건 **어떤 생성자가 호출되느냐**임
    
    ⇒ 함수적 인터페이스의 매개 값의 타입, 매개 값의 수에 따라 생성자가 결정이 됨

## 참고자료

[강의교안_14장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_14%EC%9E%A5.ppt)