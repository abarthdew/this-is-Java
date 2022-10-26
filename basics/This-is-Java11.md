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
    [- Objects.hash(), Objects.hashCode()](#objectshash-objectshashcode)    
    [- Objects.isNull(), Objects.nonNull(), Objects.requireNonNull()](#objectsisnull-objectsnonnull-objectsrequirenonnull)    
[11.5 System 클래스](#115-system-클래스)   
    [- System.exit()](#systemexit)   
    [- System.gc()](#systemgc)   
    [- System.currentTimeMillis(), System.nanoTime()](#systemcurrenttimemillis-systemnanotime)   
    [- System.getProperty()](#systemgetproperty)   
    [- System.getenv()](#systemgetenv)   
[11.6 Class 클래스](#116-class-클래스)   
[11.7 String 클래스(1)](#117-string-클래스1)   
    [- 키보드로 받은 byte 배열을 String으로 변환하기](#키보드로-받은-byte-배열을-string으로-변환하기)   
[11.7 String 클래스(2)](#117-string-클래스2)   
[11.8 StringTokenizer 클래스](#118-stringtokenizer-클래스)   
[11.9 StringBuffer, StringBuilder 클래스](#119-stringbuffer-stringbuilder-클래스)   
[11.10 정규 표현식과 Pattern 클래스](#1110-정규-표현식과-pattern-클래스)   
[11.11 Arrays 클래스(1)](#1111-arrays-클래스1)   
[11.11 Arrays 클래스(2)](#1111-arrays-클래스2)   
    [- 실습](#실습)   
[11.12 포장 클래스](#1112-포장-클래스)   
[11.13 Math, Random 클래스](#1113-math-random-클래스)   
[11.14 Date,Calendar 클래스](#1114-datecalendar-클래스)   
[11.15 Format 클래스](#1115-format-클래스)   
[11.16 java.time 패키지(1)](#1116-javatime-패키지1)   
[11.16 java.time 패키지(2)](#1116-javatime-패키지2)   
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

### Objects.hash(), Objects.hashCode()

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(15).png)

- **hash()**: 해시 코드를 생성하는 역할을 함
    - Object의 `hashCode()` 메서드를 재정의할 때, 리턴해야 할 값에 해당 → hash() 메서드를 통해 그 값을 자동으로 생성
    - 여러 개의 필드를 조합해 자동적으로 해시 코드를 만들어낼 수 있음
    - 여러 개의 필드를 조합해 하나의 해시 코드를 만들어낼 때 유용
- **hashCode()**: Object가 가지고 메서드이기도 함
    - 매개값으로 제공되는 오브젝트의 해시 코드를 얻어 리턴시켜주는 역할
    - 해시 코드를 생성한다기 보다, 오브젝트가 가지고 있는 해시 코드를 얻어내는 역할
    - 매개값이 null일 시, 해시 코드는 0을 리턴

### Objects.isNull(), Objects.nonNull(), Objects.requireNonNull()

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(16).png)

- 매개 값으로 제공되는 객체가 null인지 아닌지 판별 → null 이면 예외 발생
- **isNull()**: 매개 값이 null 일 경우 true, not null 일 경우 false
- **nonNull()**: 매개 값이 null 일 경우 false, not null 일 경우 true
- **requireNonNull()**: null이 아님을 요구함
    - 매개 값이 not null일 경우 매개 값 리턴, null일 경우 예외 발생
    - message를 매개 값으로 보낼 경우 예외 발생 시 message가 예외 메세지 설정됨
    - Supplier를 매개 값으로 보낼 경우 Supplier에서 만들어 주는 문자열을 예외에 제공

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(17).png)

- Object 클래스의 `toString()`이 객체를 표현하는 대표 문자열을 리턴한다면,
- Objects 클래스의 `toString()`은
    1. 매개로 들어온 객체의 값을 리턴, 매개 값이 null이면 null 리턴(Object 클래스의 `toString()`과 동일)
    2. 매개로 들어온 객체가 null 일 경우, 두번째 매개 값이 리턴됨

## **11.5 System 클래스**

### System.exit()

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(18).png)

- System 클래스의 out 필드를 사용해 println() 메서드 호출: 콘솔에 출력
- System.exit(”값”)에 특정 상태값이 입력되었을 경우에만 종료하고 싶다면 자바의 보안 관리자를 설정

### System.gc()

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(19).png)

- `gc()`가 호출되면 가급적 빨리 쓰레기 객체 수거를 요청한다는 뜻
- 사용하지 않은 객체를 정리해 메모리를 정리하기 위함
- JVM은 CPU가 한가할 때 gc를 실행함 → 내가 원할 때 gc()를 호출할 수도 있는 것
- `myCar = null`이 되면 Car는 더 이상 사용되지 않는 쓰레기 객체가 됨
- 또는, 다른 객체가 변수에 참조되어 남겨진 객체는 쓰레기 객체가 됨

### System.currentTimeMillis(), System.nanoTime()

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(20).png)

- 보통 프로그램 실행 시간을 측정할 때 사용함

### System.getProperty()

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(21).png)

- 키-값 형태기 때문에 key를 매개변수로 결과값을 얻음

### System.getenv()

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(22).png)

## **11.6 Class 클래스**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(23).png)

- `**Class.forName(String className)**` 매개변수에는 패키지명이 포함된 클래스명을 넣어 줌 → 해당 클래스가 있을 경우 위치를 리턴시켜 줌
- 리플렉션: 메타 데이터를 얻는 것
- `**getDeclared[Filds|Contructor|Methods]()**`: 해당 접근 제한자 상관없이, 클래스에만 선언된 필드, 생성자, 메서드만 가져 옴
- `**get[Filds|Contructor|Methods]()**`: 부모에 있는 public 필드, 생성자, 메서드 전부 가져 옴

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(24).png)

- `new ____()`를 만들 때, 클래스 종류를 코딩할 땐 모르고, 실행 도중 클래스 이름이 결정되게 하려면? ⇒ new 연산자 사용 불가
- `newInstance()`는 실행 도중 클래스 이름이 결정되고, 그 이름을 객체를 생성하는 기능을 제공함
    
    ⇒ 이 경우, 어떤 클래스가 만들어지는지 알 수 없기 때문에 `newInstance()`로 만든 객체의 타입은 Object며, 타입 변환(캐스팅)이 가능함
    
    ⇒ 위 예시와 같이, Action 인터페이스 객체를 구현해 선언된 action.execute()의 execute() 메서드는 Action이 아닌 구현 객체(SendAction 또는 ReceiveAction)의 메서드임

## **11.7 String 클래스(1)**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(25).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(26).png)

- Defelicated: 업데이트 전 버전이니 사용하지 말 것

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(27).png)

- byte 배열을 이용해 String 객체를 만드는 방법
    
    ⇒ 파일의 내용을 읽거나, 네트워크를 통해 받은 데이터는 모두 byte 배열
    
    ⇒ 이 byte 배열을 문자열로 변환해서 이용하는 경우가 많기 때문에, new String(byte[] bytes)와 같이 String 생성자에서 byte 배열을 받는 것들을 알아둘 필요가 있음
    
    (파일의 내용을 읽거나, 네트워크를 통해 데이터를 받으려면 IO/NIO를 알아야 함)
    
### 키보드로 받은 byte 배열을 String으로 변환하기

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(28).png)

1. String str = new String(byte[] bytes): 배열 전체를 String 객체로 생성
2. String str = new String(byte[] bytes, String charsetName): byte 배열을 특정 문자 종류(UTF-8 등)로 디코딩
3. String str = new String(byte[] bytes, int offset, int length): byte 배열의 일부분만 문자열로 만들 때
    
    ⇒ offset: 시작 위치
    
    ⇒ length: 시작 위치로 부터 몇 개의 배열을 문자열을 만들 것인가

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(29).png)

- System.in.read(bytes)와 같이 System.in.read에 빈 객체 byte를 넣어 줌
    
    ⇒ (byte)에는 키보드 입력 내용(Hello + [enter])이 저장되고, 입력된 문자에 대한 byte 배열의 수가 readByteNo에 저장됨(7)
    
- [enter]키 문자를 뺀 나머지를 String으로 변환

```java
String str = new String(bytes, 0, readByteNo - 2);
// readByteNo - 2: enter 키 제외
```

- Byte[] bytes 배열에 Hello\r\n이라는 문자가 차례로 저장되지는 않음
    
    ⇒ 실제 bytes 배열에 저장되는 값은 H, e, l, l, o, \r, \n에 대한 각각의 key code 번호가 저장됨(72, 101, …, 13, 10) 

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(30).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(31).png)

- charAt(n): String 배열에서 n 번째 배열의 문자만 뽑아내고 싶을 때 
    (ex) 주민번호 추출 등   

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(32).png)

- 문자열을 바이트 배열로 만듬
    
    ⇒ 파일에 내용을 적거나, 네트워크로 데이터를 보내야 할 시 사용
    
- 잘못된 문자 셋으로 인코딩 될 시 예외가 발생할 수 있음

## **11.7 String 클래스(2)**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(33).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(34).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(35).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(36).png)

- valueOf: 정적 메서드(기본 타입 값을 문자열로 만들어줌)

## **11.8 StringTokenizer 클래스**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(37).png)

- split(): 정규표현식을 통해 구분자 찾음, 좀 더 복잡한 구분자를 정규표현식으로 표현 가능. 더 범용성 있음.
- tokenizer(): 구분자 제시 후 구분, 구분자는 하나만 가능
    - `토큰`: 구분자를 기준으로 구분된 문자
    - `hasMoreTokens()`: 가져올 토큰이 있는가(true/false)
    - `nextToken()`: 토큰을 가져온다(ex. 홍길동, 이수홍, 박연수)
    - `countToken()`: nextToken()으로 가져오지 않은 토큰의 수
        
        (만약 홍길동을 꺼낸 후 호출한다면, 남아있는 토큰의 수는 2)
        
    - `new StringTokenizer()` 생성 후 `nextToken()`으로 모든 토큰을 얻었을 때, 처음으로 돌아가서 `nextToken()`을 다시 사용할 수 없음
        
        ⇒ 새로운 객체를 또 생성한 후 nextToken()을 사용해야 함
        
        ⇒ 즉, 기존 `new StringTokenizer()`는 재사용이 불가능
        

## **11.9 StringBuffer, StringBuilder 클래스**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(38).png)

- `StringBuffer`, `StringBuilder` 클래스: String 클래스의 단점을 보완한 클래스
- String은 내부의 문자열을 수정할 수 없으므로, 연산을 할 때마다 새로운 객체가 생성되어, 메모리에 다수의 객체가 계속해서 생성되는 단점이 있음
    
    ```java
    String data = val1 + val2 + val3; // 일 경우,
    // val1, val2, val3, val1 + val2, (val1+val2+val3) 총 5개의 객체가 생성됨
    // data는 마지막 (val1+Val2+Val3) 객체를 참조하게 됨
    ```
    
- `StringBuffer`, `StringBuilder`는 내부에 버퍼를 가지고 있어 이 버퍼에 문자열 데이터를 저장해두고 사용함
- 버퍼 내부에서 추가, 수정, 삭제 작업 가능
- 즉, 버퍼 내부에서만 변화되지 String 객체처럼 비슷한 객체가 여러 개 생성되지 않음
- `StringBuffer`, `StringBuilder`의 공통점: 내부에서 버퍼를 사용하며, 사용 방법은 같음
- `StringBuffer`, `StringBuilder`의 차이점:
    - `StringBuffer`: 멀티 스레드 환경에서 안전하게 사용할 수 있는 객체(JavaFX)
    - `StringBuilder`: 불안정해서 멀티 스레드 환경에서 사용할 수 없음, 단일 스레드 환경에서 사용
    
    ```java
    StringBuilder sb = new StringBuilder(); // 기본적인 공간을 가지는 객체 생성
    StringBuffer sb = new StringBuffer(); // 기본적인 공간을 가지는 객체 생성
    
    StringBuilder sb = new StringBuilder(16); // 16자가 기본적으로 저장될 버퍼사이즈가 만들어지고, 객체가 생성됨
    StringBuffer sb = new StringBuffer(16); // 16자가 기본적으로 저장될 버퍼사이즈가 만들어지고, 객체가 생성됨
    
    StringBuilder sb = new StringBuilder("Java"); // 기본적으로 Java라는 데이터를 가진 객체가 생성됨
    StringBuffer sb = new StringBuffer("Java"); // 기본적으로 Java라는 데이터를 가진 객체가 생성됨
    ```
    
- 이렇게 데이터 생성 후, 각 클래스가 가진 메서드를 사용해 데이터를 추가, 삭제, 대치할 수 있음
    - `append()`: 데이터 끝 부분에 데이터 추가
    - `insert()`: 데이터 중간에 데이터 삽입
    - `delete(int start, int end)`: 데이터 배열에서 start ~ end 까지의 데이터 삭제
    - `deleteCharAt()`: 몇 번째 문자 하나만 삭제
    - `replace()`: 데이터 대치
    - `StringBuilder reverse()`: 데이터 순서 뒤바꿈
    - `setCharAt(int index, char ch)`: 주어진 index 문자를 ch로 바꿈

## **11.10 정규 표현식과 Pattern 클래스**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(39).png)

- 정규 표현식: 사용자가 입력한 데이터가 올바른 형식대로 입력되었는지 검증하는 데 사용

## **11.11 Arrays 클래스(1)**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(40).png)

- 배열 조작 기능을 가진 util 클래스

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(41).png)

- `Arrays.copyOf()`, `copyOfRange()`: Arrays의 메서드
    - `Arrays.copyOf(원본 배열, 복사할 길이)`: 원본 배열을, 복사할 길이만큼 복사(복사할 길이가 원본 배열의 길이보다 클 경우, 빈 배열을 포함한 길이의 배열이 복사됨)
    - `copyOfRange(원본 배열, 시작 인덱스, 끝 인덱스)`: 원본 배열의 일부분(시작~끝 인덱스) 만큼 복사함
- `System.arraycopy()`: System의 메서드
    - 원본 배열의 시작 인덱스를 타겟 배열의 특정 인덱스에 복사하고 싶을 때
    - 타겟 배열: 원본 배열 또는 그 일부를 복사 붙여넣기 할 배열

## **11.11 Arrays 클래스(2)**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(42).png)

- Arrays.equals()는 A1, A2 배열의 a, b, c의 값(번지)을 각각 비교함

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(43).png)

- 예를 들어, Arrays.equals()는 `100번지와 300번지를(false)`, `200번지와 400번지(false)`를 비교함
- Arrays.deepEquals()는 중첩된 배열까지 전부 비교함
    
    ⇒ `100번지의 a, b와 300번지의 a, b(true)`, `200번지의 c, d와 400 번지의 c, d(true)` 까지 비교함
    
- Arrays.sort(): int[], double[], String[] 배열은 자동 정렬
    
    ⇒ Member[] 와 같이 개발자 정의 배열은 Comparable 인터페이스 구현 필요
    
- Arrays.binarySearch()를 사용하기 위해선 Arrays.sort()로 먼저 정렬 필요

### 실습

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(44).png)

[얕은 복사 후 비교]

- 배열 번지 비교: orginal(100), clone1(400)의 번지 비교
- 1차 배열 항목 값 비교: original[0]의 번지(200)와 [1](300)번지 비교
    
    ⇒ clone1은 original을 얕은 복사 했으므로 original[0], [1]의 항목을 각각 가리키고 있음
    
    ⇒ clone1[0], [1]에는 original[0], [1]의 주소값이 저장됨
    
- 중첩 배열 항목 값 비교
    
    ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(45).png)
    
    ⇒ original, clone1이 가리키는 항목(1,2,3,4)가 서로 같으므로 true

[깊은 복사 후 비교]

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(46).png)

- 배열 번지 비교: false `(100 ≠ 200)`
- 1차 배열 항목 값 비교: false `(300 ≠ 500 && 400 ≠ 600)`
- 중첩 배열 항목 값 비교: true `(1 == 1 && 2 == 2 && 3 == 3 && 4 == 4)`

## **11.12 포장 클래스**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(47).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(48).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(49).png)

- obj는 Wrapper 객체
- obj.byteValue(): obj는 Byte의 Wrapper 객체며, byteValue()를 통해 Byte Wrapper 객체 안의 byte 값이 리턴됨
- obj.charValue(): obj는 Character의 Wrapper 객체며, charValue()를 통해 Character Wrapper 객체 안의 char 값이 리턴됨
- obj.intValue(): obj는 Integer의 Wrapper 객체며, intValue()를 통해 Integer Wrapper 객체 안의 int 값이 리턴됨

```java
Integer obj = 100; // 자동 박싱

List<Integer> list = new ArrayList<Integer>(); // List 컬렉션에서는 객체만 저장 가능하므로 int가 아닌 Integer
list.add(200); // 200은 int지만 Integer로 자동 박싱됨
```

- 자동 박싱: 100이라는 int 값을 포장 클래스에 대입하면, 자동 박싱이 일어남

```java
Integer obj = new Integer(200);
int value = obj; // 자동 언박싱(int는 기본타입이지만 Integer 객체 대입 가능)
```

- 자동 언박싱: 기본 타입에 포장 객체 대입 가능
- 언박싱 정리
1. 객체가 기본 타입에 대입이 될 때
2. 객체가 연산이 될 때
    
    ⇒ 이 객체는 반드시 Wrapper 객체가 되어야 언박싱 가능
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(50).png)

- Wrapper 클래스는 기본 값을 랩핑할 용도로만 사용되지 않고, 문자열을 기본 타입으로 변환해서 활용할 경우에도 사용됨
- Byte.parseByte(”10”): 문자열 “10”을 byte 타입으로 변환하고 싶을 때, Byte Wrapper 클래스의 정적 메서드인 parseByte()를 사용해 변환
- Integer.parseInt(”1000”): 문자열 “1000”을 int 값으로 변환하고 싶을 때
- 포장 객체는 객체이므로 ==, ≠가 아닌 equals() 메서드로 내부 값 비교
    
    ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(51).png)
    
- **예외: boolean, char, byte, short, int는 ==, ≠ 사용 가능**
    
    ⇒ 번지 비교가 아닌, 객체 안의 값을 비교함
    
    ⇒ 다만, `byte`, `short`, `int`는 **-128 ~ 127 범위**만 ==, ≠ 가능하며, 이 범위를 넘어서는 값은 equals()로 비교 가능
    

## **11.13 Math, Random 클래스**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(52).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(53).png)

- 난수를 얻는 방법
    1. Math.randon() 사용
        
        ⇒ 1 ~ n 사이 정수 중, 시작 수가 start인 임의의 정수
        
        ```java
        int num = (int) (Math.random() * n) + start;
        ```
        
    2. java.util 패키지 내 Random 클래스 사용

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(54).png)

- 종자값이 달라지만 다른 난수를 얻음

## **11.14 Date,Calendar 클래스**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(55).png)

- 날짜, 시간을 얻어내는 클래스
- Date: 날짜를 얻는다기 보다, 현재 시간의 날짜를 표현하는 클래스. 현재 시간의 스냅샷, 현  시점의 바로 그 값을 가지고 있는 객체를 만들 때 사용. **즉, 객체는 생성되는 순간의 시스템의 날짜를 가지고 있게 됨.**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(56).png)

- Calender는 생성자를 이용해 객체를 만들지 않고, getInstance()를 이용해 현재 시스템의 날짜로 만든 달력 객체를 리턴해 줌

## **11.15 Format 클래스**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(57).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(58).png)

- {0}, {1}, {2}: 매개변수이며, 이 자리에는 어떠한 데이터가 들어옴
    
    ⇒ 0번 인덱스, 1번 인덱스, 2번 인덱스 데이터
    
- MessageFormat 클래스의 정적 메서드인 format(message, id, name, tel)을 호출
    
    ⇒ message는 String message 변수에 대입된 값 자체며, 그 뒤부터(id, name, tel)이 각각 0, 1, 2번 인덱스 데이터가 되어 result 변수에 리턴됨
    
- 매개 변수 값을 배열로 만드는 방법도 있으며, 이때 이 배열을 파라미터로 넘김
    
    ```java
    Object[] arguments = {id, name, tel};
    MessageFormat.format(text, argument);
    ```

## **11.16 java.time 패키지(1)**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(59).png)

- 날짜와 시간을 조작한다 = 날짜를 연산한다
- `java.time`: Local 접두사로 봐서, 현재 시스템 날짜 시간 정보를 가지고 있는 객체들을 모은 패키지(국제 표준)
- `java.time.chrono`: 세계 표준에 맞지 않는 달력 등을 구현할 때, 표준 달력 이외의 시스템을 사용하고 싶을 때 사용(음력 등)
- `java.time.format`: 문자열을 파싱에서 날짜, 시간 정보를 만들거나, 날짜, 시간 정보를 문자열로 파싱

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(60).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(61).png)

- LocalDateTime: 날짜, 시간 정보를 모두 가지고 있음
- ZonedDateTime: 날짜, 시간, 존 정보를 모두 가지고 있음(+는 시차, [Asia/Seoul]은 지역을 의미함)
    
    ⇒ `getAbailableDs()` 메서드를 통해 어떤 존 아이디를 사용할 수 있는지 알 수 있음

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/11(62).png)

- Instant는 LocalDateTime 등과 같이 날짜를 얻고 조작하는 데 사용되지 않고, 단순히 날짜 정보만 전달함
- 현재 시간을 가지고 있는 객체로서만 의미가 있음
- Local 컴퓨터(시스템)의 날짜 및 시간을 이용하는 게 아닌, 협정 세계시를 기준으로 함

## **11.16 java.time 패키지(2)**

## 참고자료

[강의교안_11장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_11%EC%9E%A5.ppt)