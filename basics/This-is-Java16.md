## 목차
[16.1 스트림 소개](#161-스트림-소개)   
[16.2 스트림의 종류](#162-스트림의-종류)   
[16.3 스트림 파이프라인](#163-스트림-파이프라인)   
[](#)   
[참고자료](#참고자료)   

## **16.1 스트림 소개**

- 스트림: 요소를 처리하는 반복자

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16.png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(1).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(2).png)

- 외부 반복자: Iterator
    
    ```jsx
    List<String> list = Arrays.asList("1", "2", "3"); // 컬렉션
    Iterator<String> iter = list.iterator();
    while(iter.hasNext()) {
        String name = iter.next(); // 컬렉션 바깥쪽에서 하나씩 가져옴
        System.out.println(name);
    }
    ```
    
    ```mermaid
    flowchart LR
    	a[개발자 코드]-->b[next]-->c[컬렉션]-->d[처리]
    ```
    
    - iterator.next()로 List 요소를 하나씩 가져오도록 하는데, 이건 컬렉션 내부가 아닌 바깥쪽에서 일어남
- 내부 반복자
    - 개발자 코드: Stream에 주어지는 람다식 / 요소를 어떻게 처리해야 할지 알려주는 람다식
    - 컬렉션은 내부적으로 요소를 반복하는 스트림을 이용해 개발자가 알려준 방식대로, 즉 개발자 코드가 제공해준 람다식을 요소마다 하나씩 다 적용해서 처리
    
    ```mermaid
    flowchart LR
    	subgraph 개발자코드
    	b[/처리코드\n제공\]
    	end
    	subgraph 컬렉션
    	d[처리]-->e[처리]-->f[처리]
    	end
    개발자코드-->컬렉션
    ```
    
- 내부 반복자 이점
1. 개발자는 요소 처리 코드에만 집중
    - 외부: 가져올 요소가 있는지 확인 후, next()로 가져오는 코드를 작성
    - 내부: 다음 요소를 가져오는 next() 코드 작성 안 해도 됨
        
        ```java
        stream.forEach(name -> System.out.println(name));
        ```
        
        - 다음과 같이 “어떻게 처리할지” 람다식으로 제공만 하면 됨
        - 컬렉션 안에 있는 스트림에서 요소를 하나씩 `name -> System.out.println(name)` 와 같이 처리함
2. 컬렉션 요소가 많이 있을 경우
    - 외부: 반복자를 이용해 컬렉션에 있는 요소들을 하나씩 가져와 병렬처리 하려면 2개 이상의 스레드 코드를 개발자가 만들어야 함
    - 내부: 요소를 나누어 별도의 스트림으로 만들어 각각의 코어에서 병렬적으로 처리 가능
3. 병렬처리 방법
    - 예) 1~1000 까지 모든 수를 더하기
        - 한 가지 작업: 1~1000 까지 모든 수를 더하기
        - 서브작업: 1000개의 작업을 500개 씩 나누고, 코어1, 2에서 작업하도록 하자. 코어1에는 1~500까지의 합을, 코어 2에서는 501~1000까지의 합을 구한다.
        - 그리고 코어 1, 2에서 나온 최종적 결과를 다시 합한다.
        
        ⇒ 최종: 전체(1~1000 까지 모든 수의 합)에 대한 결과를 얻어낼 수 있음. 
        
- 병렬처리가 가능한 스트림을 얻게 되면, 내부적으로 ForkJoinPool이라는 프레임워크를 이용해 병렬처리를 할 수 있음
    
    ⇒ 직접 컬렉션 내부에 병렬처리를 하는 코드를 작성할 필요는 없음
    
    ⇒ 병렬처리를 하는 스트림을 얻어내기만 하면 됨
    
    ⇒ 스트림 내부에서 ForkJoinPool을 이용해 요소들을 나누고 각각 처리를 한 후, 서브작업 결과를 취합해 최종 결과를 제공함
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(3).png)

- 순차 처리: 싱글 스레드를 이용해 요소들을 반복적으로 처리
- 병렬 처리: 여러 개의 스레드를 이용해 요소들을 병렬적으로 처리
- 차이점: `list.stream()` vs `list.parallelStream()`

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(4).png)

## **16.2 스트림의 종류**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(5).png)

- 모든 스트림은 전부 BaseStream을 상속받고 있음
- BaseStream는 직접적으로 사용되지 않고, 주로 하위 스트림을 사용함

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(6).png)

- 스트림 자체가 요소를 처리하는 반복자이기 때문에, 요소를 제공하는 어떤 소스든 스트림 구현 객체가 될 수 있음
- 소스:
    - 컬렉션: 객체 저장, 객체를 요소로 해서 스트림을 만들 수 있음
        - 모든 컬렉션에서 스트림을 만들 수 있는 건 아님
        - java.util.Collection 인터페이스 구현체만 스트림 객체를 생성할 수 있음(List, Set 계열 컬렉션)
        - `java.util.Collection.stream()`: 싱글 스레드 환경에서 요소를 처리하는 스트림을 얻어내는 메서드
        - `java.util.Collection.ParallelStream()`: 병렬처리를 하기 위한 스트림을 얻어내는 메서드
    - 배열: 인덱스로 관리되는 요소를 가지고 있으므로 스트림 객체를 얻을 수 있음
        - Arrays 클래스를 이용하는 방법
        - 직접 Stream 인터페이스를 이용하는 방법
    - int 범위: 시작~끝 사이 정수를 처리하는 스트림 객체를 얻을 수 있음
        - IntStream.range(): 끝 값을 포함하지 않음
        - IntStream.rangeClose(): 끝 값 포함
    - 디렉토리: 디렉토리 내 파일이나 하위 디렉토리, path 정보를 요소로 가지는 스트림 객체를 얻을 수 있음(파일 자체 요소X)
        - Files.find(): 디렉토리 BiPredicate로 필터링한 파일 경로를 요소로 가지는 스트림을 얻음
        - Files.list(Path): Path 안에 있는 파일 경로를 요소로 가지는 스트림을 얻음
    - 파일: 파일에 라인으로 구분되어 있는 내용이 들어가 있다면, 각 라인을 요소로 가지는 스트림을 얻음
        - 각 라인을 하나씩 읽어 이에 대한 text 정보를 요소로 가지므로 String 타입
        - 각 라인의 문자 요소를 스트림으로 가지므로 문자 파일만 가능
        - BufferedReader: java.io에 있는 성능 향상을 위한 보조 스트림.  문자 파일을 읽어 파일 내용을 얻을 때 사용.

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(7).png)

- `studentList.stream()`: Student 객체를 요소로 하는 스트림을 얻음
- `Stream<Student> stream`: 만들어진 Student 타입 스트림 객체. Student 객체가 요소가 되어 스트림에서 반복적으로 처리가 됨.
- `stream.forEach(s -> { 람다식으로 처리 })`: 얻어낸 스트림 객체를 활용함. stream을 통해 Student 객체가 하나씩 매개값 s로 대입, 이를 이용해 람다식으로 처리.

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(8).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(9).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(10).png)

- 파일 내용은 [실행 결과]와 같이 각각의 라인으로 구성되어 있음
- 파일로부터 파일에 대한 경로 정보를 가지고 있는 path 객체 먼저 얻음 → 스트림 생성
- 스트림을 생성하는 방법
    1. Files.lines() 메서드 이용
        - 매개 값: 경로, 문자 셋(default=운영체제 기본 문자 셋)
        - 리턴 값: String 타입 Stream을 리턴(파일 데이터가 문자이기 때문)
        - 스트림이 처리하는 요소: 각 라인을 요소로 하는 스트림 객체를 만듬 → forEach로 각 라인을 한번 씩 가지고 와서 람다식 또는 메서드 참조로 처리
    2. BufferedReader의 lines() 메서드 이용
        - File 객체로 파일 객체 얻기
        - FileReader는 문자 파일을 읽는 스트림 → 파일 객체를 매개값으로 제공해 얻음
        - BufferedReader에 fileReader를 매개값으로 제공해 읽기 성능 향상된 객체를 얻음
        - lines() 메서드로 스트림 객체를 얻음
        - 스트림이 처리하는 요소: 각 라인을 요소로 하는 스트림 객체를 만듬 → forEach로 각 라인을 한번 씩 가지고 와서 람다식 또는 메서드 참조로 처리

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(11).png)

- 디렉토리 내 파일, 서브 디렉토리를 콘솔에 출력하는 예제
1. 디렉토리 지정
2. Path 객체 얻기
3. Files.list()로 Path에 있는 디렉토리의 내용을 요소로 하는 스트림 리턴
4. 스트림 요소 타입이 Path
    
    ⇒ 디렉토리의 파일, 서브 디렉토리의 경로 정보 객체인 Path가 스트림 요소가 됨
    
5. forEach를 사용해 Path를 하나씩 가져와 콘솔에 출력
    
    ⇒ 매개변수 p에는 디렉토리 내 파일, 서브 디렉토리의 Path 객체가 대입됨
    

## **16.3 스트림 파이프라인**


## 참고자료

[강의교안_16장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_16%EC%9E%A5.ppt)