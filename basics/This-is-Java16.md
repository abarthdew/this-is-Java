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
[16.12 병렬 처리](#1612-병렬-처리)   
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

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(28).png)

- 오리지널 스트림 → 필터링 → 매핑 → 집계 → 컬렉션
- 오리지널 스트림 → 그룹핑 → 집계(리덕션)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(29).png)

- **수집:** 오리지널 스트림 → 필요한 요소만 필터링 → 별도의 컬렉션으로 만듦
- 수집을 하기 위해 collect() 메서드 호출
- 매개 변수인 Collector<>가 요소를 어떤 컬렉션에 수집할 건지 결정
- collect() 메서드는 수집이 완료된 새로운 컬렉션을 리턴
- Collector<> 객체는 직접 만드는 것이아니라, Collectors 클래스의 정적 메서드를 이용해 Collector<>의 객체를 얻어낼 수 있음
    - `Collectors.toCollection()`: 매개변수인 **Supplier가 제공해주는 컬렉션**의 요소를 수집하는 Collector를 얻음
    - `Collectors.toConcurrentMap()`: 멀티 스레드 환경에서 스레드에 안전한 **ConcurrentMap**을 만들어 거기에 요소를 수집하는 Collector를 얻음
    - `Collectors.toList()`: 요소를 **List 컬렉션**에 수집시키는 Collector를 얻음
    - `Collectors.toMap()`: 요소를 **Map 컬렉션**에 수집시키는 Collector를 얻음
    - `Collectors.toSet()`: **Set 컬렉션**에 요소를 수집하는 Collector를 얻음
- 즉, collect(Collector<T,A,R> collect)의 매개변수에 Collects 클래스의 정적 메서드를 이용한 리턴 결과인 Collector 타입을 넣어 주면 **요소가 각각의 List, Map, Set에 수집되어 리턴**됨
- ?인 누적기가 하는 역할: T, R요소를 컬렉션에 수집하는 역할
    - 널리 알려져 있는 컬렉션(List, Map, Set)의 경우, Collector 내부에서 저장 방법이 이미 설정되어 있기 때문에 별도의 누적기가 필요 없음
        
        ⇒ 그래서 ?로 표시됨.
        
- 예시) 전체 학생에서 남학생만 List로 생성하기
    
    ```java
    List<Student> maleList 
     = totalList.stream() // 오리지날 스트림 생성
    	.filter(s -> s.getSex() == Student.sex.MALE) // 성별 필터링
    	.collect(Collectors.toList()); // 결과를 List에 담기 
    ```
    
- 예시) 전체 학생에서 여학생만 HashSet으로 생성
    
    ```java
    Set<Student> femaleSet 
     = totalList.stream()
    	.filter(s -> s.getSex() == Student.sex.FEMALE)
    	.collect(Collectors.toCollection(HashSet::new)); // Collectors.toCollection(Supplier<T>) 사용
    																	// Supplier라는 익명 구현 객체를 메서드 참조로 사용
    																	// Collectos.toSet()을 사용해도 무방함
    ```
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(30).png)

- 사용자 정의 컨테이너: 개발자가 작성한 클래스
- List, Set, Map에 수집하는 것과 같이 collect() 메서드를 사용하는 건 동일
- collect() 메서드의 매개 변수:
    - Supplier: 요소들이 수집될 컨테이너 객체를 생성하는 역할, 즉, 사용자 정의 컨테이너 객체를 만드는 역할
    - Consumer: 객체를 사용자 정의 컨테이너에 수집하는 역할
    - BiConsumer: 병렬 처리와 관련.
        - 순차 처리: 순차 처리에서는 사용되지 않지만, 그래도 객체는 만들어 줘야 함
        - 병렬 처리: 스레드 별로 생성된 사용자 정의 컨테이너를 하나의 컨테이너에 결합시키는 역할을 함. 즉, 각각의 컨테이너에 수집된 요소들을 하나의 컨테이너에 누적시킴.
- 리턴값 R: Supplier가 생성한 사용자 정의 컨테이너

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(31).png)

- collect() 메서드는 단순히 요소를 수집하는 기능 외, 컬렉션의 요소들을 그룹핑해 Map 객체로 생성하는 기능도 제공
    
    ⇒ 예시) 전체 학생에서 남학생만 남학생 key로 저장, 여학생은 여학생 key로 저장해서 Map 객체로 리턴되도록 함
    
- Map 객체로 리턴되게 하기 위해 collect() 메서드에 제공해야 할 매개 값
    - Collectors.groupingBy()
    - Collectors.groupingByConcurrent()
    
    ⇒ 결과 값으로 Collector 객체가 리턴됨
    
- Map과 ConcurrentMap의 차이
    - Map: 싱글 스레드 환경에서 사용하는 컬렉션
    - ConcurrentMap: 멀티 스레드 환경에서 사용하는 컬렉션
- 여러 개지 groupingBy() 메서드 중 어떤 것을 사용하느냐에 따라 Map 객체 안에 들어있는  value 값이 달라짐**[그림의 ‘설명’ 부분 참조]**
1. **K(key)가 주어지고, 이 key에 대한 value 값으로 List 객체가 들어감**
    
    
    | 리턴 타입 | 메서드 |
    | --- | --- |
    | Collector<T, ?, Map<K, List<T>>> | groupingBy(
      Function<T, K> classifier
    ) |
    | Collector<T, ?, ConcurrentMap<K, List<T>>> | groupingByConcurrent(
      Function<T, K> classifier
    ) |
    - K(key)가 주어지고, 이 key에 대한 value 값으로 List 객체가 들어감
        
        ⇒ key값인 K 밑에 요소들이 List 안에 그대로 저장됨
        
    - List 객체 안에 요소 T가 저장됨
    - **key인 K는 어떻게 만들어지느냐?** groupingBy[Concurrent]() 메서드의 매개 값으로 주어지는 Function에 따라 결정됨
    - 매개 값인 Function<T, K>은 요소를 어떤 key에 저장할 건지를 정의함
        
        ⇒ Function의 정의 내용에 따라 key가 결정되고, 그 밑의 요소들이 저장됨
        
2. **K(key)로 요소를 저장하는데, 순수한 요소 T를 저장하는 것이 아니라, 이 T를 매핑한 객체를 D에 저장**
    
    
    | 리턴 타입 | 메서드 |
    | --- | --- |
    | Collector<T, ?, Map<K, D>> | groupingBy(
      Function<T, K> classifier,
      Collector<T,A,D> downstream
    ) |
    | Collector<T, ?, ConcurrentMap<K, D>> | groupingByConcurrent(
      Function<T, K> classifier,
      Collector<T,A,D> downstream
    ) |
    - K(key)로 요소를 저장하는데, 순수한 요소 T를 저장하는 것이 아니라, 이 T를 매핑한 객체를 D에 저장
        
        ⇒ T를 그대로 저장하는 것이 아니라, T를 매핑해서 다른 요소를 가지는 컬렉션을 값으로 가짐
        
        ⇒ 어떤 요소 T를 어떤 컬렉션 D에 담은 건지는 Collector<T,A,D>에 달려 있음
        
    - 예) 남학생을 저장할 때, 남학생 객체를 직접 저장하는 것이 아닌, 남학생 객체의 이름/점수/주소 등 남학생을 대체한 다른 요소들을 저장할 때
    - **어떤  T 요소(이름/점수/주소)를 저장할 것이냐?** 는 groupBy[Concurrent]() 메서드의 두 번째 매개값인 Collector<T,A,D>가 결정함
    - Collector<T,A,D> downstream에는 주소 매핑된 내용이 오게 됨: 남학생의 이름/점수/주소
        
        ⇒ T(원래 요소의 타입), A(누적기), D(원래 요소인 T를 매핑해서 D컬렉션에 저장)
        
    - 즉, Collector라는 객체를 두번째 매개 값으로 받아 원래 요소를 매핑해서 새로운 컬렉션에 요소를 저장하는 역할을 함
    - 내부적으로 Map 객체를 생성함
3. **2. 와 동일**
    
    
    | 리턴 타입 | 메서드 |
    | --- | --- |
    | Collector<T, ?, Map<K, D>> | groupingBy(
      Function<T, K> classifier,
      Supplier<Map<K, D>> mapFactory,
      Collector<T, A, D> downstream
    ) |
    | Collector<T, ?, ConcurrentMap<K, D>> | groupingByConcurrent(
      Function<T, K> classifier,
      Supplier<Map<K, D>> mapFactory,
      Collector<T, A, D> downstream
    ) |
    - 2와의 차이점:
        - 2) 내부적으로 Map 객체를 생성함(자동적으로 만들어진 Map을 사용)
        - 3) 두번째 매개값인 Supplier가 제공하는 Map 객체를 사용함(Supplier가 제공해 주는 Map을 사용)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(32).png)

- sex.MALE/sex.FEMALE ⇒ 키
- Map<Key, Value> ⇒ Map<Student.Sex, List<Stdent>>
    
    ```java
    Map<Student.Sex, List<Stdent>> mayBySex 
    	= totalList.stream()
    		.collect(Collectors.groupingBy(Student::getSex));
    																	 // Function<Student>의 익명 구현 객체
    																	 // (Student::getSex)의 리턴값이 곧 key가 됨
    	// 결과: 같은 sex를 리턴하는 객체만 따로 그룹핑됨
    	// 즉, Sex.MALE / Sex.FEMALE를 키값으로 남학생/여학생 리스트가 각각 value로 옴
    ```
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(33).png)

```java
Map<Student.City, List<String>> mapByCity
	= totalList.stream()
		.collect(
			Collectors.groupingBy(
				Student::getCity, // 키값: 키가 무엇이 될 것이냐(학생의 거주 도시)
				// 동일한 city를 리턴하는 학생들은 동일한 key에 저장됨
				// 여기까지는 각 key에 대한 Student 객체만 저장됨
				Collectors.mapping(Student::getMame, Collectors.toList())
				// 1번째 매개값: Student의 이름을 얻어내는 Funtion 함수적 인터페이스
				// 2번째 매개값: String을 List로 만들기
				// => Student로부터 이름을 얻어 이 결과를 List에 저장해 Collector를 만듦
				// Student 객체에서 -> 이름으로 매핑되어 key에 대한 value 값으로 들어감
			)
		);
```

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(34).png)

- 위에 학습한 내용 중
    
    ```java
    groupingBy(
      Function<T, K> classifier,
      Supplier<Map<K, D>> mapFactory,
      Collector<T, A, D> downstream // (*) 요소를 집계, 매핑해서 그루핑함
    )
    ```
    
    (*)와 같이 Collector 자리에 Collectos.mapping()말고도, 리턴값이 Collector인 다양한 메서드를 쓸 수 있음
    
- Collectors.mapping(Functon, Collector): 요소를 그루핑한 이후, 요소를 대체하는 다른 요소로 매핑해서 컬렉션에 저장(원래 요소를 다른 요소로 대체해서 저장)
    - Functon: 어떻게 매핑할 것인가(Function 함수적 인터페이스 타입)
    - Collector: 어떤 컬렉션에 저장할 것인가
- Collectors.maxBy(Comparator): 최대값을 저장
    - Comparator: 무엇이 최대값인지 비교할 수 있도록 힌트 제공
- Collectors.reducing(): 개발자가 커스팀 리덕션을 할 수 있도록 제공되는 메서드

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(35).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(36).png)

- Map<성별, 평균 점수>
    
    ```java
    Map<Student.Sex, Double> map // 결과값: Map 객체로 만들어져 리턴됨
     = totalList.stream() // 전체 리스트에서 스트림을 얻어 냄
    	.collect( // 그루핑 메서드 호출
    		// Collectors.groupingBy()의 리턴값은 collect() 메서드의 매개값으로 제공됨
    		Collectors.groupingBy( // groupingBy 메서드 호출
    			Student::getSex, // 키 값(성별)
    			Collectors.avragingDouble(Student::getScore) // 그루핑 후의 평균값을 구함(학생의 점수로 매핑됨)
    		)
    	);
    ```
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(37).png)

- Map<성별, 쉼표로 구분된 학생 이름>
    
    ```java
    Map<Student.Sex, String> mapByName
     = totalList.stream() // 전체 스트림 얻기
    	.collect(
    		Collectors.groupingBy(
    			Student::getSex, // 키
    			Collectors.mapping( // 학생 객체 -> 이름으로 매핑
    				Student::getName, // 매핑 방법
    				Collectors.joining(",") // 학생 이름을 ,로 연결해 값으로 저장
    			)
    		)
    	);
    ```
    

## **16.12 병렬 처리**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(38).png)

- 병렬 처리: 동시에 처리하는 것
- 자바 8에서는 API 차원에서 병렬 처리를 할 수 있도록 병렬 스트림을 제공함
- 요소를 나누어(병렬적으로) 처리함으로서 전체 처리 시간이 줄어듬
- 동시성: **하나의 코어**에서 여러 개의 작업이 번갈아서 처리됨. 워낙 빨리 번갈아 실행되기 때문에, 마치 작업들이 동시에 실행되는 것처럼 보임.
- 병렬성: **두 개 이상의 코어**가 작업을 병렬적으로(동시에) 처리.

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(39).png)

- 병렬성은 데이터 병렬성, 작업 병렬성 두 가지로 구분됨
    - **데이터 병렬성**: 전체 데이터 → (쪼개기) → 서브 데이터 → (병렬 처리)
    - **작업 병렬성**: 서로 다른 작업 병렬 처리(웹서버)
        - 예시) 인터넷 검색 시, 웹서버에 접속해서 해당 HTML을 내려받음
            
            ⇒ 사용자가 많을 시, 웹 서버는 많은 사용자들에게 HTML 페이지를 동시에 줘야 함
            
            ⇒ 웹 서버는 사용자 요청을 하나의 작업으로 보고, 여러 사용자가 요청한 작업을 동시에 실행시킴 ⇒ **작업 병렬성**
            
- 병렬 스트림은 데이터 병렬성을 구현한 것임
    
    ⇒ 멀티 코어의 수만큼 대용량 요소를 서브 요소로 나눔
    
    ⇒ 예를 들어, 쿼드 코어는 4개의 서브 요소들로 나뉘고, 4개의 스레드가 각각 서브 요소를 병렬 처리함
    
- 병렬 스트림은 포크 조인 프레임워크를 이용함
    
    ⇒ 개발자가 직접 구현할 필요 없음
    
    ⇒ 병렬 스트림을 얻게 되면, 내부적으로 구현된 포크 조인 프레임워크를 이용해 병렬 처리를 할 수 있음
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(40).png)

- 포크 조인 프레임워크는 두 가지 단계가 있음
    1. 포크 단계: 대용량 데이터를 서브 데이터로 반복적으로 분리 → 서브 데이터를 멀티 코어에서 병렬 처리
    2. 조인 단계: 서브 결과를 결합해 최종 결과를 만들어 냄
- [그림]
    
    
    | FORK | 전체 요소 1…N: 처리해야 할 요소 |
    | --- | --- |
    |  | 요소 1...1/4N, 요소 1...2/4N, 요소 1...3/4N, 요소 1...4/4N |
    |  | 분할된 서브 요소들을 각각의 코어에서 처리함 |
    |  | 요소1 처리결과, 요소2 처리결과, 요소3 처리결과, 요소4 처리결과 |
    | JOIN | 각 서브 데이터에 대한 결과가 나오게 되면, 이 결과를 JOIN 단계에서 결합함 |
    |  | (요소1 결과 + 요소2 결과) 부분결합 + (요소3 결과 + 요소4 결과) 부분결합 |
    |  | (요소 1...N) 최종결합 |

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(41).png)

- 요소 분할은 순차적이지 않음 → 내부적으로 서브 요소로 나누는 알고리즘이 있음
    
    ⇒ 개발자는 병렬 스트림만 잘 사용하면 됨
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(42).png)

- 포크 조인 프레임워크는 스레드를 내부적으로 포크 조인 풀에서 관리함
- 코어에서 작업을 하려면, 코어 별로 스레드가 별도로 존재해야 함
- 포크 조인 프레임워크는 ExecutorService의 구현 객체인 ForkJoinPool을 사용해 각 스레드를 관리함
- 4개의 코어를 가진 CPU의 경우, 4개의 스레드를 만들어 사용을 함

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(43).png)

- 병렬 스트림을 얻는 방법 2가지
    1. 컬렉션으로부터 직접 parallelStream() 을 호출해서 병렬 스트림 얻기
    2. 이미 스트림을 만들었다면, 이들 스트림이 가지고 있는 parallel() 메서드를 호출해서 병렬 스트림으로 변환하기
        
        ⇒ 이미 존재하는 스트림을 병렬 스트림으로 변환
        

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(44).png)

- 순차 처리 스트림
    
    ```java
    MaleStudent maleStudent // 사용자 정의 컨테이너: 남학생만 저장
    	= totalList.stream() // 스트림 얻기
    		.filter(s->s.getSex() == Student.Sex.MALE) // 남학생 필터링
    		.collect( // 남학생을 어디에 수집할 것인가?
    			MaleStudent::new, // 컨테이너 객체 생성: MaleStudent 객체에 남학생 수집
    			MaleStudent::accumulate, // 남학생을 MaleStudent 컨테이너 객체에 저장하는 누적기
    			MaleStudent::combine // 순차 처리 스트림(싱글 스레드)에서는 사용되지 않음
    		);
    ```
    
- 병렬 스트림으로 수정
    
    ```java
    MaleStudent maleStudent
    	= totalList.parallelStream() // 1.
    		.filter(s->s.getSex() == Student.Sex.MALE)
    		.collect( 
    			MaleStudent::new, // 2. 4번 실행
    			MaleStudent::accumulate, // 3.
    			MaleStudent::combine // 4.
    		);
    ```
    
    1. [포크 조인 프레임워크의 fork 단계]: CPU 코어의 개수만큼 전체 요소(totalList)는 서브 요소로 나뉘어지고, 해당 개수만큼 스레드 생성
        
        ![최종적으로 4개의 서브 요소로 나뉘어짐(요소 1…1/4N)](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(45).png)
        
        최종적으로 4개의 서브 요소로 나뉘어짐(요소 1…1/4N)
        
    2. 각 스레드는 서브 요소를 수집해야 하므로, 4개의 MaleStudent 객체를 생성해야 함
        
        ![서브 요소들이 MaleStudent 컨테이너에 남학생 저장](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(46).png)
        
        서브 요소들이 MaleStudent 컨테이너에 남학생 저장
        
        ⇒ 전체 학생 4개로 분할
        
        → 각 요소 별로 남학생을 찾아 사용자 정의 컨테이너 MaleStudent에 담아야 함
        
        → 사용자 정의 컨테이너도 결국 4개가 있어야 된다는 의미
        
        → 결국 collect()의 첫번째 매개 값인 MaleStudent를 생성하는 메서드 참조는 4번 실행됨
        
        → 그래야 서브 요소들이 남학생을 추려 각각의 MaleStudent에 저장할 수 있기 때문
        
    3. 각각의 서브 요소에서 남학생이 발견되면 각각의 MaleStudent에 누적
    4. 각각의 서브 요소들이 남학생을 각각의 MaleStudent에 전부 저장을 다 하고 나서, MaleStudent를 결합할 때 사용
        
        ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(47).png)
        
        ⇒ 결합 과정: 전체 서브요소의 개수 - 1
        
        ⇒ 4개의 서브요소로 나뉘었으므로, 결합 과정은 3개가 필요함
        

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(48).png)

1. 컬렉션에는 4개의 Student 요소가 들어 있음
2. 병렬 처리를 위해 totalList.parallelStream() 와 같이 병렬 스트림을 만들게 되면, main 스레드 이외 3개의 스레드가 더 생성됨
    
    ⇒ 총 메서드: 4개
    
3. collect() 메서드가 호출
    1. `MaleStudent::new`: MaleStudent 객체는 4개가 생성됨
        
        ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(49).png)
        
    2. `MaleStudent::accumulate`: accumulate() 메서드는 두 번 실행됨
        
        ⇒ totalList 내 Student 객체의 남학생이 2명이므로, 이 두 객체를 MaleStudent::new에 저장해야 하기 때문
        
        ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(50).png)
        
        ⇒ 체크된 곳(임의)의 MaleStudent 객체에 남학생 객체가 저장됨
        
        ⇒ 저장이 될 때 accumulate() 메서드가 호출됨
        
4. 3번의 combine() 실행됨
    
    ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(51).png)
    
    ⇒ 생성된 MaleStudent 객체 4개가 → 2개로 결합 → 1개로 결합(3번 결합)
    
    ⇒ **최종으로 만들어진 MaleStudent1이 collect() 메서드의 리턴값이 됨**
    
5. 출력 결과
    
    ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(52).png)
    
    ⇒ 4개의 스레드에서 MaleStudent::new 호출
    
    ⇒ 2개의 스레드에서 accumulate() 호출
    
    ⇒ 3개의 스레드에서 combine() 호출
    
- 정리:
    
    ⇒ parallelStream()으로 병렬 처리 스트림을 얻으면, 코어의 수 만큼 스레드가 생성됨
    
    ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(53).png)
    
    ⇒ 이 요소들을 코어의 수 만큼  4개로 분할해서, 각각 스레드가 처리
    
    ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(54).png)
    
    ⇒ 처리가 다 된 후에는, 3번의 결합으로 완성된 MaleStudent를 만들어 냄
    
    ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(55).png)
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/16(56).png)

- 요소의 수, 요소당 처리 시간에 따라 병렬 처리의 성능이 더 떨어질 수도 있음
- 컬렉션의 요소 수가 적고, 요소당 처리 시간이 짧으면 순차 처리가 더 빠를 수도 있음
- 스트림 소스의 종류
    - ArrayList, 배열: 인덱스로 관리되므로, 포크 단계에서 요소를 쉽게 분리할 수 있음
    - HashSet, TreeSet: 인덱스로 관리하지 않기 때문에 요소를 분리하기가 쉽지 않음
    - LinkedList: 요소 분리 어려움
        
        ⇒ 소스 종류에 따라 병렬 처리 성능이 떨어질 수도 있음
        
- 싱글 코어: 순차 처리가 더 빠름
    
    ⇒ 동시성으로 실행하고, 스레드를 만들수록 스레드의 생성 시간 ↑, 번갈아 실행해야 하기 때문에

## 참고자료

[강의교안_16장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_16%EC%9E%A5.ppt)