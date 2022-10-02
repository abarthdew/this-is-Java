## 목차
[11.1 자바 API 도큐먼트](#111-자바-api-도큐먼트)   
[11.2 java.lang과 java.util 패키지](#112-javalang과-javautil-패키지)   
[11.3 Object 클래스(1)](#113-object-클래스1)   
    [- equals()](#equals)   
    [- hashCode()](#hashcode)   
    [- toString()](#tostring)   
[11.3 Object 클래스(2)](#113-object-클래스2)   
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

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(8).png)


## 참고자료

[강의교안_11장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_11%EC%9E%A5.ppt)