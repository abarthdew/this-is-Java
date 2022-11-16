## 목차
[13.1 왜 제네릭(Generic)을 사용해야 하는가?](#131-왜-제네릭generic을-사용해야-하는가)   
[13.2 제네릭 타입](#132-제네릭-타입)   
[13.3 멀티 타입 파라미터](#133-멀티-타입-파라미터)   
[참고자료](#참고자료)   

## **13.1 왜 제네릭(Generic)을 사용해야 하는가?**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/13.png)

- List는 어떠한 객체든 다 저장할 수 있기 때문에, list.add(”hello”)는 `내부적으로 Object로 변환`되어 저장됨
    
    ⇒ list.get(0) 또한 String이 아니라 `Object 타입으로 리턴`됨
    
    ⇒ 이를 String str로 얻기 위해선 String으로 강제 타입 변환을 해야 함
    
- 타입 변환을 여러 번 하기 번거로우므로, List<String> list와 같이 String 타입만 저장하겠다고 정함
    
    ⇒ 내부적으로 저장할 때 String으로 저장되고,
    
    ⇒ 찾아올 때도 String으로 리턴됨
    

## **13.2 제네릭 타입**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/13(1).png)

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
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/13(2).png)

```java
Box<String> box =  new Box<String>();
box.set("hello"); // String 타입만 대입 가능하므로 Object -> String 타입 변환이 일어나지 않음
String str = box.get(); // String 타입으로 리턴되므로 강제 타입 변환을 할 필요 없음
```

## **13.3 멀티 타입 파라미터**


## 참고자료

[강의교안_13장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_13%EC%9E%A5.ppt)