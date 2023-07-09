## 목차
[13.1 왜 제네릭(Generic)을 사용해야 하는가?](#131-왜-제네릭generic을-사용해야-하는가)   
[13.2 제네릭 타입](#132-제네릭-타입)   
[13.3 멀티 타입 파라미터](#133-멀티-타입-파라미터)   
[13.4 제네릭 메소드](#134-제네릭-메소드)  
[13.5 제한된 타입 파라미터](#135-제한된-타입-파라미터)   
[13.6 와일드카드 타입](#136-와일드카드-타입)   
[13.7 제네릭 타입의 상속과 구현](#137-제네릭-타입의-상속과-구현)   
[참고자료](#참고자료)   

## **13.1 왜 제네릭(Generic)을 사용해야 하는가?**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/13.png)

- List는 어떠한 객체든 다 저장할 수 있기 때문에, list.add(”hello”)는 `내부적으로 Object로 변환`되어 저장됨
    
    ⇒ list.get(0) 또한 String이 아니라 `Object 타입으로 리턴`됨
    
    ⇒ 이를 String str로 얻기 위해선 String으로 강제 타입 변환을 해야 함
    
- 타입 변환을 여러 번 하기 번거로우므로, List<String> list와 같이 String 타입만 저장하겠다고 정함
    
    ⇒ 내부적으로 저장할 때 String으로 저장되고,
    
    ⇒ 찾아올 때도 String으로 리턴됨
    

## **13.2 제네릭 타입**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/13(1).png)

- <T>: 타입 결정이 되지 않은 상태. 구체적 타입 결정은 개발자가 개발 코드를 작성할 때 지정.
    
    ⇒ “어떤 타입이 들어올 것이다”
    
- Object은 모든 자바 클래스의 최상위 부모 클래스
    
    ⇒ 어떤 클래스건 Object을 상속받음
    
    ⇒ extends를 붙이지 않아도 자동적으로 컴파일러가 extends Object 붙임
    
- 자동 타입 변환으로, 자식 객체는 부모 타입에 저장될 수 있음
- 즉, 어떠한 객체든 Object에 저장될 수 있음
    
    ```java
    Object object = (어떠한 자바 객체);
    ```
    
    ```java
    private Object object; // 어떠한 객체든 이 필드에 저장 가능
    ```
    
    ```java
    Box box = new Box();
    box.set("hello"); // String 타입으로 대입됐지만 set(Object object)므로 Object로 저장됨
    box.get(); // get() 리턴 타입이 Object이므로 Object로 리턴됨
    ```
    

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/13(2).png)

```java
Box<String> box =  new Box<String>();
box.set("hello"); // String 타입만 대입 가능하므로 Object -> String 타입 변환이 일어나지 않음
String str = box.get(); // String 타입으로 리턴되므로 강제 타입 변환을 할 필요 없음
```

## **13.3 멀티 타입 파라미터**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/13(3).png)

## **13.4 제네릭 메소드**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/13(4).png)

1. 선언

```java
// <T>와 같은 타입파라미터는 리턴타입과 매개 변수에 사용함 
public <T> Box<T> boxing(T t) {...}
// 리턴타입: Box<T> (T가 지정이 된 Box 객체가 리턴)
// 매개타입: (T t)
```

2. 호출

```java
// Box<Integer>: [1. 선언]의 리턴타입
Box<Integer> box = <Integer>boxing(100); // 매개값 100: [1. 선언]의 매개변수
Box<Integer> box = boxing(100); // 보통 <Integer>는 생략 가능 -> 컴파일러가 자동으로 유추함
```

## **13.5 제한된 타입 파라미터**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/13(5).png)

- 타입 파라미터에는 어떤 객체도 올 수 있는데, 원하는 타입만 오게 하고 싶을 때 제한된 타입 파라미터를 지정할 수 있음
- 주의: 메서드 실행 블록 안에서는 지정된 T 타입의 필드, 메서드만 사용 가능
    
    ```java
    // <T>는 자식 클래스거나, 구현 클래스임
    public <T extends Number> int compare(T t1, T t2) {
      // Number의 필드, 메서드만 올 수 있음
      // Number 또는 Number의 자식 클래스가 매개 변수로 들어올 수 있기 때문에, 이들이 공통적으로 사용 가능한 것은 Number의 필드, 메서드 뿐임
      // Number의 자식 클래스의 필드, 메서드는 매개변수로 사용할 수 없음
    }
    ```
    
## **13.6 와일드카드 타입**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/13(6).png)

- <T extends 상위 또는 인터페이스> 표현: 제네릭 타입을 선언할 때 타입 파라미터를 제한하는 것
- 와일드 카드 타입: 이미 선언된 제네릭 타입을 매개 변수나 리턴 타입으로 사용할 때, 타입 파라미터를 제한할 목적으로 이용
    
    ```java
    public static void registerCourse(Course<?> course) {...}
    public static void registerCourseStudent(Course<? extends Student> course) {...}
    public static void registerCourseWorker(Course<? super Worker> course) {...}
    ```
    
- 와일드 카드 타입의 세 가지 형태
    1. `제네릭 타입<?>: <?>에는 어떤 타입도 가능`
        
        ```java
        public static void registerCourse(Course<?> course) {...}
          // Course<Integer>
          // Course<String>
        ```
        
    2. `제네릭 타입<? extends 상위타입>: <?>에는 상위타입 이하 클래스만 가능`
    3. `제네릭 타입<? super 하위타입>: <?>에는 하위타입 이상 클래스만 가능`
- `클래스 D` → `C` → `B` → `최상위 클래스 A` 순이라고 가정
    1. `<? extends C>의 경우 C, D, E만 가능` (C가 **최상위** 클래스)
    2. `<? super C>의 경우 C, B, A만 가능`(C가 **최하위** 클래스)

## **13.7 제네릭 타입의 상속과 구현**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/13(7).png)

- 제네릭 타입을 부모 타입으로 사용할 경우, 자식 클래스도 부모 타입의 제네릭 타입 파라미터를 언급해 줘야 함
- 부모가 제네릭이면, 자식도 제네릭
- 자식은 부모 제네릭 언급 필수, 추가로 타입 파라미터 지정 가능
- 제네릭 인터페이스를 구현할 때도, 구현 클래스는 인터페이스와 동일한 제네릭 타입 파라미터를 선언해 줘야 함


## 참고자료

[강의교안_13장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/00.basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_13%EC%9E%A5.ppt)
