## 목차
[11.1 자바 API 도큐먼트](#111-자바-api-도큐먼트)   
[11.2 java.lang과 java.util 패키지](#112-javalang과-javautil-패키지)   
[11.3 Object 클래스(1)](#113-object-클래스1)   
    [- equals()](#equals)   
    [- hashCode()](#hashcode)   
    [- toString()](#tostring)   
[11.3 Object 클래스(2)](#113-object-클래스2)   
    [- clone()](#clone)   
    [- finalize()](#finalize)   
[11.4 Objects 클래스(1)](#114-objects-클래스1)   
[참고자료](#참고자료)   

## **11.1 자바 API 도큐먼트**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11.png)

- 자바 API
    - 자바에서 기본적으로 제공해주는 라이브러리
    - 프로그램 개발에 자주 사용되는 클래스 및 인터페이스 모음
- [자바 API 도큐먼트 HTML 홈페이지](https://docs.oracle.com/javase/7/docs/api/)
    - 상속관계, 인터페이스 구현, 설명, 예제 코드, 필드, 생성자, 메서드
    - 맨 상단 SUMMARY: 요약
    - NESTED: 내부 클래스, 중첩 클래스

## **11.2 java.lang과 java.util 패키지**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(1).png)

- Wrapper 클래스 예) int 값을 Integer로, 객체화해서 만들 수 있음

## **11.3 Object 클래스(1)**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(2).png)

- 다음 코드는 extends 없이 아무런 상속을 받지 않았지만, 암시적으로 Object 클래스를 상속받음
    
    ```java
    class xxx {
    	// ...
    }
    ```
    
- Object 클래스 내 메서드는 모든 클래스에서 사용 가능

### equals()

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(3).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(4).png)

- equals() 메서드 재정의

### hashCode()

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(5).png)

- 두 객체 비교 과정: 두 객체의 hashCode 검증(hashCode) → 두 객체의 내부 데이터 검증(equals) → 리턴

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(6).png)

- hashMap의 데이터 저장 구조

### toString()

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(7).png)

- `System.out.println(Object)`는 자동으로 toString() 결과를 리턴함(클래스명@해시코드)

## **11.3 Object 클래스(2)**
### clone()

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(8).png)

- 얕은 복제: 기본 타입 필드 값 복제, 참조 타입 필드 번지 공유
- 깊은 복제: 기본 타입 필드 값 복제, 참조하고 있는 객체 복제
- 조건: Clonable 인터페이스를 구현한 객체만 clone() 메서드 사용 가능
- clone() 메서드는 기본적으로 얕은 복제 제공, 깊은 복제는 메서드 재정의 필수

### finalize()

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(9).png)

- Object가 finalize()를 가지기 때문에, 모든 객체는 finalize()를 가짐
- Object의 finalize()는 기본적으로 비어 있어, 아무런 동작이 없음 → 객체가 소멸되기 전에 실행할 코드가 있다면 재정의
- 하지만, 될 수 있다면 소멸자를 사용하지 않는 게 좋음
    
    → 가비지 컬렉터는 객체 일부만 소멸시겨서 남아 있는 객체에서는 finalize()를 실행시키지 않기 때문에, 메서드 호출이 안 될 수도 있음
    
- 그러니까, 실행 될 수도, 안 될 수도 있으니 그냥 쓰지 말 것

## **11.4 Objects 클래스(1)**

## 참고자료

[강의교안_11장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_11%EC%9E%A5.ppt)