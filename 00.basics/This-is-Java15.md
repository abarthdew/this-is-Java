## 목차

[15.1 컬렉션 프레임워크 소개](#151-컬렉션-프레임워크-소개)   
[15.2 List 컬렉션](#152-list-컬렉션)   
[15.3 Set 컬렉션](#153-set-컬렉션)   
[15.4 Map 컬렉션](#154-map-컬렉션)   
[15.5 검색 기능을 강화시킨 컬렉션](#155-검색-기능을-강화시킨-컬렉션)   
[15.6 LIFO와 FIFO 컬렉션](#156-lifo와-fifo-컬렉션)   
[15.7 동기화된 컬렉션](#157-동기화된-컬렉션)   
[참고자료](#참고자료)

## **15.1 컬렉션 프레임워크 소개**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15.png)

- 배열의 문제점
    1. `new Product[10]`: 저장할 수 있는 객체 수가 배열을 생성할 때 결정됨
    2. 객체를 삭제했을 때 해당 인덱스가 비게 됨 = **조각났다** = 중간에 객체가 비어있다

       ⇒ 컬렉션은 이 두 가지 문제점을 해결함

- 프레임워크: 인터페이스와 클래스의 모음
- 라이브러리: 인터페이스, 클래스
- 정형화된 방법: 컬렉션을 사용하는 방법이 통일화되어 있다는 뜻

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(1).png)

- List(인터페이스): 인덱스에 객체를 저장, **중복 저장 가능**
    - 구현클래스: ArrayList, Vector, LinkedList
- Set(인터페이스): 구슬 주머니 형태에 객체를 저장, **중복 저장 불가**
    - 구현클래스: HashSet, TreeSet
- Map(인터페이스): List와 유사, 차이점은 Map은 인덱스가 아닌 key에 객체를 저장함, **키 중복 불가(키가 다르다면 객체 중복 가능)**
    - 구현클래스: HashMap, Hashtable, TreeMap, Properties
- List와 Set은 공통된 부분이 많기 때문에, 그 공통된 부분을 컬렉션에 정의해 놓고 Collection을 상속받아 만들어짐
- Map은 별도로 만들어짐

## **15.2 List 컬렉션**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(2).png)

- List 컬렉션: List 인터페이스를 구현한 컬렉션
- 각각의 인덱스에 객체의 생성 번지를 저장함(1, 2 인덱스는 같은 객체를 가리킴)

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(3).png)

- 중간 인덱스에 저장된 객체가 삭제되면, 인덱스가 삭제된 만큼 칸을 이동해 다시 배열이 만들어짐(객체가 삭제되어도 중간에 빈 부분이 발생하지 않음)

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(4).png)

- ArrayList는 List 인터페이스를 구현했기 때문에, List 인터페이스 변수에 대입 가능
- ArrayList는 생성 시 기본적으로 10개의 <E>타입 객체를 저장할 수 있는 내부 배열이 생성됨

  ⇒ 인덱스 안에는 객체가 없는 상태, 즉 null 상태가 됨

  ⇒ `new ArrayList<E>();` 의 괄호 안에 초기 배열의 길이를 지정할 수 있음

- (기본 배열 길이인 10개에서) 11번째 객체를 저장하게 되면, 저장 공간이 자동으로 늘어남

  ⇒ 다시 10개씩 배열이 늘어남(0~9인덱스 → `+`10~19 인덱스)

- 중간 인덱스의 객체가 삭제되면 뒷 순서의 인덱스 객체들이 삭제된 만큼 앞으로 당겨짐

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(5).png)

- `add()`: 불특정 객체들을 저장할 때
- `Arrays.asList()`: 고정 객체들을 저장할 때

  ⇒ `Arrays.asList(”a”, “b”, “c”);`: 0, 1, 2 인덱스에 각각의 객체가 저장됨

    ```java
    List<Integer> list = Arrays.asList(1, 2, 3); // 각 객체가 Integer로 자동 박싱됨
    for (int val : list) { // Integer로 박싱된 객체가 나오면서 int 타입으로 자동 언박싱됨
      val;
    }
    ```

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(6).png)

- ArrayList의 add(): public boolean add() {…}
    - 싱글 스레드 환경에서 더 성능적으로 유리
- Vector의 add(): public synchronized boolean add() {…}
    - **동기화 처리가 되어 있음**
    - 멀티 스레드 환경에서 하나의 스레드가 add()를 실행하면, 다른 스레드는 add()를 실행할 수 없음
    - 두 스레드가 동시에 객체를 저장할 때, 한 번에 하나의 스레드만이 add()를 호출 가능
    - 멀티 스레드 환경에서 안전하게 사용할 수 있음

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(7).png)

- 하나의 요소의 참조: 앞에 있는 요소, 뒤에 있는 요소
- 요소의 앞, 뒤에 누가 있는지 저장됨 + 요소가 저장하는 객체를 참조함
- 즉, 각각의 요소는 앞, 뒤에 누가 있는지에 관한 참조가 구성되어, 체인처럼 관리됨
- 객체를 삭제하거나, 특정 인덱스에 삽입할 때 매우 유리한 컬렉션
- 예) 3번째 요소를 삭제할 때:
    - 3번째 요소에 연결된 이전, 다음 참조를 끊어버림
    - 2번째 요소에 연결된 다음 요소를 끊음
    - 4번째 요소에 연결된 이전 요소를 끊음
    - 2번째, 4번째 요소가 서로 이전, 다음 요소로 새롭게 연결됨

  ⇒ 해당 부분의 링크만 수정이 되고, 나머지 요소에 대한 링크는 수정할 필요가 없음.

- 예) 중간에 요소를 추가할 때

  ![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(8).png)

- ArrayList에서 중간 요소가 삭제되면, 나머지 요소들이 그만큼 앞으로 당겨오는 것에 반해,
- LinkedList는 나머지 요소들은 링크를 그대로 유지하고, 수정된 요소와 그 앞-뒤 요소만 빠지거나 추가됨. 즉 특정 부분만 링크가 수정됨.
  ⇒ 중간에 객체가 삭제되거나, 삽입될 경우, 다른 컬렉션보다는 좀 더 빠른 성능을 냄

## **15.3 Set 컬렉션**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(9).png)

- Set 컬렉션: 구슬 주머니와 같은 저장 형태

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(10).png)

- 형태: `Set<String> set = 구현클래스;`
- 두 코드는 동일한 결과를 얻음

    ```java
    Set<String set = 구현 클래스;
    
    // 1.
    Iterrator<String> iter = set.iterator();
    while (iter.hasNext()) {
      String str = iterator.next(); // 객체를 하나씩 가져옴
    }
    
    // 2.
    for (String str : set) {
      // ...
    }
    ```

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(11).png)

- remove()를 사용하면 Set 컬랙션의 요소를 완전히 삭제할 수 있음
- 두 객체가 동등 객체로 판단될 경우, 중복 저장하지 않음(hashCode로 판별)

## **15.4 Map 컬렉션**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(12).png)

- 키, 값으로 구성된 한 쌍을 Map.Entry라는 객체로 표현
- 키와 값은 모두 객체: 키로 객체를 참조, 값으로도 객체를 참조

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(13).png)

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(14).png)

- 전체 객체를 대상으로 반복해서 얻기: 두 예시는 결과가 같음
- 다만, 두 번째 예시는 key, value를 좀 더 쉽게 얻을 수 있음

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(15).png)

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(16).png)

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(17).png)

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(18).png)

- ClassPath를 이용: 자바 코드가 있는 디렉토리
    - ~.class가 있는 디렉토리에 ~.properties 파일이 존재 한다면, 위 방법으로 Properties 객체를 만들 수 있음

## **15.5 검색 기능을 강화시킨 컬렉션**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(19).png)

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(20).png)

- TreeSet은 Set 인터페이스를 구현한 컬렉션
- Set 인터페이스 타입 변수에 대입해도 되지만, TreeSet이 가진 검색과 관련된 메서드가 있기 때문에 TreeSet 객체는 TreeSet 변수에 대입하는 것이 좋음
- 왼쪽과 오른쪽 자식 노드를 참조하기 위한 두 개의 변수로 구성
    - left: 좌측 자식 노드(자식 객체)에 대한 참조(번지)
    - value: 실체 객체의 참조(번지)가 저장되는 곳
    - right: 우측 자식 노드에 대한 참조

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(21).png)

- 중앙 부분에 키, 값으로 되어있는 Map.Entry 객체의 참조를 저장함
- 좌: 죄측 자식노드 객체의 참조가 저장
- 우: 우측 자식노드 객체의 참조가 저장
- 중앙값의 키 값을 가지고 값을 비교함. 이 키를 보고 왼 쪽에 저장할 것인지, 오른쪽에 저장할 것인지를 결정함.

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(22).png)

- 특정 클래스를 TreeSet, TreeMap의 키로 저장할 때는 반드시 그 특정 클래스에 Comparable을 구현해야 함

## **15.6 LIFO와 FIFO 컬렉션**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(23).png)

## **15.7 동기화된 컬렉션**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(24).png)

- ArrayList, HashSet과 같은 비동기화된 컬렉션을 동기화된 컬렉션으로 만드는 방법
    - ArrayList:  Collections.synchronizedList() 메서드를 호출하고 매개값으로 ArrayList를 넣어 줌

      ⇒ ArrayList를 랩핑한 동기화 컬렉션이 만들어짐

      ⇒ 내부에 ArrayList를 가지고 있으며, 랩핑한 컬렉션의 메서드를 호출하면 안쪽에 담긴 ArrayList의 내용을 변경해 주는 원리

      ⇒ 랩핑한 컬렉션에 대해서는, 한 번에 하나의 스레드만 접근 가능

    - HashSet: Collections.synchronizedSet() 메서드 호출, 이하 ArrayList와 원리 같음

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/15(25).png)

- HashMap도 마찬가지
    - Collections.synchronizedMap() 메서드에 HashMap 객체를 매개값으로 주면, HashMap을 랩핑하는 동기화된 Map이 리턴됨
    - 내부에 HashMap을 가지고 있으며, 동기화된 메서드를 가지고 있음
    - 스레드1이 동기화된 컬렉션의 메서드를 호출할 때, 다른 스레드는 접근 불가능

## 참고자료

[강의교안_15장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/00.basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_15%EC%9E%A5.ppt)
