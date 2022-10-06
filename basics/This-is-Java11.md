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
    [- Objects.compare()](#objectscompare)   
    [- Objects.equals(), Objects.deepEquals()](#objectsequals-objectsdeepequals)   
[11.4 Objects 클래스(2)](#114-objects-클래스2)   
    [- hash(), hashCode()](#hash-hashcode)    
    [- isNull(), nonNull(), requireNonNull()](#isnull-nonnull-requirenonnull)    
[11.5 System 클래스](#115-system-클래스)   
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

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(10).png)

- Objects는 java.lang이 아니라, java.util 패키지에 포함되어 있음
- java.util 패키지에는 다양한 유틸리티 클래스가 포함됨
- 유틸리티 클래스는 다양한 기능을 제공해 주는 클래스를 뜻함
- 객체를 생성해서 사용하는 게 아니라, 유틸리티 메서드를 이용해서 기능 사용

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(11).png)

- 연산이 되는 정적 유틸리티 메서드를 제공하는 클래스라고 설명되어 있음
- 대부분의 메서드들이 static으로 선언 → 객체를 만들지 않고도 메서드를 사용할 수 있음

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(12).png)

- deepEquals(): 비교 대상이 되는 객체 a, b가 배열일 경우, 배열의 번지가 아닌 항목의 값을 비교 → 항목이 같으면 true, 하나라도 다르면 false- 
- **equals()**: a, b 객체의 번지만 비교
- **hash()**: 배열(여러 개의 Object)인 매개값의 해쉬 코드를 생성
- **hashCode()**: 객체 하나에 대한 해쉬 코드를 생성

### Objects.compare()

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(13).png)

- compare() 메서드 사용 시, 반드시 Comparator 인터페이스를 구현한 구현 객체를 만들어야 함

### Objects.equals(), Objects.deepEquals()

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(14).png)

- **equals()**: 객체 자체에 대한 비교 → 객체가 동일한 번지를 갖고 있느냐, 객체가 논리적으로 동등하냐 비교
    - `a ≠ null, b ≠ null`: Objects.equals()를 재정의하지 않고 쓴다면 ==와 같이 두 객체의 번지를 비교
    - a, b 둘 중 하나가 null이면 return false
    - a, b 둘 다 null이면 return true
- **deepEquals()**: 두 배열을 비교 → 두 배열의 항목이 같으냐, 항목이 하나라도 다르냐를 비교
    - `null이 아닌 a가 배열이 아니고, null이 아닌 b가 배열이 아닐 경우`: a.equals(b)로 작용함
    - `null이 아닌 a가 배열이고, null이 아닌 b가 배열일 경우`: 메서드 내부에서 Arrays.deepEquals()라는 메서드 사용 → a, b 각각의 항목의 값을 비교해 같으면 true, 하나라도 틀리면 false
    - a, b 둘 중 하나가 null이면 return false
    - a, b 둘 다 null이면 return true

## **11.4 Objects 클래스(2)**

### hash(), hashCode()

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(15).png)

- **hash()**: 해시 코드를 생성하는 역할을 함
    - Object의 hashCode() 메서드를 재정의할 때, 리턴해야 할 값에 해당 → hash() 메서드를 통해 그 값을 자동으로 생성
    - 여러 개의 필드를 조합해 자동적으로 해시 코드를 만들어낼 수 있음
    - 여러 개의 필드를 조합해 하나의 해시 코드를 만들어낼 때 유용
- **hashCode()**: Object가 가지고 메서드이기도 함
    - 매개값으로 제공되는 오브젝트의 해시 코드를 얻어 리턴시켜주는 역할
    - 해시 코드를 생성한다기 보다, 오브젝트가 가지고 있는 해시 코드를 얻어내는 역할
    - 매개값이 null일 시, 해시 코드는 0을 리턴

### isNull(), nonNull(), requireNonNull()

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(16).png)

- 매개 값으로 제공되는 객체가 null인지 아닌지 판별 → null 이면 예외 발생
- **isNull()**: 매개 값이 null 일 경우 true, not null 일 경우 false
- **nonNull()**: 매개 값이 null 일 경우 false, not null 일 경우 true
- **requireNonNull()**: null이 아님을 요구함
    - 매개 값이 not null일 경우 매개 값 리턴, null일 경우 예외 발생
    - message를 매개 값으로 보낼 경우 예외 발생 시 message가 예외 메세지 설정됨
    - Supplier를 매개 값으로 보낼 경우 Supplier에서 만들어 주는 문자열을 예외에 제공

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(17).png)

- Object 클래스의 toString()이 객체를 표현하는 대표 문자열을 리턴한다면,
- Objects 클래스의 toString()은
    1. 매개로 들어온 객체의 값을 리턴, 매개 값이 null이면 null 리턴(Object 클래스의 toString()과 동일)
    2. 매개로 들어온 객체가 null 일 경우, 두번째 매개 값이 리턴됨

## **11.5 System 클래스**

## 참고자료

[강의교안_11장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_11%EC%9E%A5.ppt)