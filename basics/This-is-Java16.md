## 목차
[16.1 스트림 소개](#161-스트림-소개)   
[16.2 스트림의 종류](#162-스트림의-종류)   
[16.3 스트림 파이프라인](#163-스트림-파이프라인)   
[16.4 필터링 - distinct(), filter()](#164-필터링---distinct-filter)   
[16.5 매핑-flatMapXXX(), mapXXX(), asXXXStream(), box](#165-매핑-flatmapxxx-mapxxx-asxxxstream-box)   
[16.6 정렬 - sorted()](#166-정렬---sorted)   
[16.7 루핑 - peek(), forEach()](#167-루핑---peek-foreach)   
[16.8 매칭 - allMatch(), anyMatch(), noneMatch()](#168-매칭---allmatch-anymatch-nonematch)   
[16.9 기본 집계 - sum(), count(), average(), max(), min](#169-기본-집계---sum-count-average-max-min)   
[16.10 커스텀 집계 - reduce()](#1610-커스텀-집계---reduce)   
[16.11 수집 - collect()](#1611-수집---collect)   
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

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(12).png)

- 스트림은 중간 처리와 최종 처리로 구분됨
- 보통 최종 처리는 리덕션이라는 행위를 함
- 리덕션(집계): 전체 요소에서 하나의 값을 산출하는 것
- 스트림을 통해 얻을 수 있는 요소가 리덕션을 하기 적합하지 않은 형태일 때 → 이 경우, 최종 처리를 위해 중간 처리가 필요함
    
    ⇒ 중간 처리: 필터링, 매핑, 정렬, 그룹핑
    
- 파이프라인: 오리지날 스트림 → (중간 처리) → 중간 스트림 → 최종 처리

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(13).png)

```mermaid
flowchart LR
	a[오리지날\n스트림]---b[중간\n스트림1]---A[중간\n스트림2]-- 최종 스트림\n집계 기능 시작 ---B[결과물]
```

- 최종 스트림의 집계 기능이 시작될 때: 마지막 중간 스트림에서 최종 처리를 하기 위해서 최종 처리 집계 메서드를 호출할 때
- 표시된 곳에서(1) 스트림 요소들에 대한 최종 처리 메서드를 호출하기 전까지는, 중간 처리 스트림(중간 스트림1, 2) 부분이 동작하지 않음
- 즉, `최종 처리`인 집계 기능이 시작 되어야, 비로소 `오리지날 스트림`→ `중간처리 스트림1` 이 되고, `중간처리 스트림1` → `중간처리 스트림2` 을 거쳐 최종 처리가 됨
- 다시 말해, 최종 처리 단계가 시작되지 않으면, 중간 처리 스트림은 동작하지 않음(지연)
- 예) 미리 전체 학생(오리지날 스트림)에서 남학생만 뽑아내고(중간 스트림1), 점수를 뽑아내서(중간 스트림2) 준비를 하고 있다가 최종처리를 한다(X)
    
    ⇒ 최종 처리를 하는 순간 오리지날 스트림→중간 스트림1→중간 스트림2 단계를 거쳐 최종 처리가 됨
    
    ⇒ 중간 처리만으로는 동작하지 않고, 반드시 최종 처리 메서드가 호출되어야 단계적으로 실행됨
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(14).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(15).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(16).png)

- 스트림 메서드는 중간 처리 메서드와 최종 처리 메서드로 구분할 수 있음
- **중간 처리 메서드**: 요소를 필터링, 매핑, 정렬, 루핑해서 중간 스트림을 만들어 냄
    
    ⇒ 최종 처리 메서드가 실작해야 중간 처리 메서드도 동작함
    
- **최종 처리 메서드**: 합계, 평균, 카운팅, 최소 최대값을 집계, 즉 리덕션하는 메서드
- 리턴타입을 보면 중간 처리 메서드인지, 최종 처리 메서드인지 구분 가능
- 소속된 인터페이스: 각 스트림 메서드는 모든 스트림에서 제공하는 것도 있고, 특정 스트림에서만 제공하는 것도 있음

## **16.4 필터링 - distinct(), filter()**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(17).png)

- distinct()
    - 원래 스트림[BABA] → `distinct()` → 중간 스트림[BA]

## **16.5 매핑-flatMapXXX(), mapXXX(), asXXXStream(), box**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(18).png)

- 매핑: 스트림 요소를 다른 요소로 대체하는 것
- 예) 객체 → int / 객체 → double
- 반드시 하나의 요소가 하나의 요소로 대체되는 것은 아님
    
    ⇒ 하나의 요소가 여러 개의 요소로 대체될 수도 있음
    
- flatMapXXX(): 하나의 요소를 여러 개의 요소로 대체
- flatMap의 매개변수 Function 타입 객체
    - T: 원래 스트림에 포함된 요소들의 타입(`A`, `B`)
    - Stream<R>: 각 T 요소에 대해 대체되는 복수 개의 요소(`A2`, `A1` / `B2`, `B1`)
- T(double, int, long) 타입을 → 여러 개의 T(double, int, long)으로 만듦
- 객체를 → 여러 개의 T(double, int, lont)으로 만듦

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(19).png)

- map(): 원래 스트림에 있던 요소를 다른 요소로 대체한 스트림을 구성함
- flatMap()과는 달리 하나의 요소를 하나의 다른 요소로 대체함
- map(DoubleUnaryOperator): double 원래 요소를 다시 double로 바꾸어 스트림을 새로 만듦
- mapToObj(IntFunction<U>): double 요소를 객체로 바꾸어 객체 타입 스트림을 만듦

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(20).png)

- boxed(): int, long, double 타입 요소를 Integer, Long, Double과 같은 객체 타입 요소로 박싱한 다음, 이 객체들로 이루어진 스트림을 만듦

## **16.6 정렬 - sorted()**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(21).png)

- sorted() 메서드는 각 스트림에 하나씩 있는데, Stream<T>에는 두개 있음
- Stream<T> 타입 sorted(), sorted(Comparator<T>):
    - sorted(): 객체가 가진 Comparable 구현 방법에 따라 정렬
        
        ⇒ Stream<T>의 객체 요소(T)가 Comparable을 구현하지 않으면 sort() 메서드 호출 시 ClassCastException이 발생
        
    - sorted(Comparator<T>): Comparable을 구현했거나, 또는 구현하지 않았더라도 정렬을 할 수 있게 Comparator 객체를 매개값으로 가짐
        
        ⇒ Comparator는 함수적 인터페이스
        

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(22).png)

- 위 예시의 위 코드는 오름차순, 아래 코드는 내림차순 정렬임

## **16.7 루핑 - peek(), forEach()**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(23).png)

- 루핑: 중간 처리, 최종 처리에서 쓸 수 있음
    - 중간 처리에서의 루핑 메서드: `peek()`
        
        ⇒ 중간 처리 메서드이므로 최종 처리 메서드가 호출되어야 실행됨
        
    
    ```jsx
    // 최종 처리 메서드가 호출되지 않았으므로 실행 안 됨
    intStream
     .filter(...)
     .peek(...)
    
    // 최종 처리 메서드가 호출되어야 동작함
    intStream
     .filter(...)
     .peek(...)
     .sum()
    ```
    
    - 최종 처리에서의 루핑 메서드: `forEach()`

## **16.8 매칭 - allMatch(), anyMatch(), noneMatch()**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(24).png)

## **16.9 기본 집계 - sum(), count(), average(), max(), min**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(25).png)

- 대량의 데이터를 가공해서 축소: 대량의 데이터를 하나의 값으로 만든다는 의미

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(26).png)

- isPresent(): 집계값이 존재하는가?
- orElse(): 집계값이 존재하지 않을 경우 기본값
- ifPresent(): 집계값이 존재할 경우, 그 집계값을 소비할 Consumer 매개값을 지정함

## **16.10 커스텀 집계 - reduce()**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(27).png)

- reduce(): 개발자가 프로그램화해서 다양한 집계 결과물을 만들 수 있음
- 각 스트림에 2개씩 reduce() 메서드가 있음
    - reduce(BinaryOperator<T>)
        - BinaryOperator<T>는 두 개의 T타입 매개 값을 받아 연산을 한 이후, 그 결과를 리턴
    - reduce(T, BinaryOperator<T>)
        - BinaryOperator<T> 연산 결과가 없다면, 기본 값으로 T 타입 값 설정
- 연산이 없는 경우 = 요소가 없는 경우이므로,
    - reduce(BinaryOperator<T>): 예외 발생(NoSuchElementException)
    - reduce(T, BinaryOperator<T>): 기본 값 리턴
- 예시
    
    ```jsx
    int sum = studentList.stream()
    	.map(Student::getScore)
    	.reduce((a,b)->a+b) // 두 성적을 매개값으로 받아 합산함
    	// 마지막 하나가 나올 때까지 계속 합산 
    	// 모든 요소를 더해서 최종적으로 하나의 합을 구함
    	.get();
    ```
    

## **16.11 수집 - collect()**

## 참고자료

[강의교안_16장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_16%EC%9E%A5.ppt)