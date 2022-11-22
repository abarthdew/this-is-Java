## 목차
[15.1 컬렉션 프레임워크 소개](#151-컬렉션-프레임워크-소개)   
[15.2 List 컬렉션](#152-list-컬렉션)   
[참고자료](#참고자료)   

## **15.1 컬렉션 프레임워크 소개**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/15.png)

- 배열의 문제점
    1. `new Product[10]`: 저장할 수 있는 객체 수가 배열을 생성할 때 결정됨
    2. 객체를 삭제했을 때 해당 인덱스가 비게 됨 = **조각났다** = 중간에 객체가 비어있다
        
        ⇒ 컬렉션은 이 두 가지 문제점을 해결함
        
- 프레임워크: 인터페이스와 클래스의 모음
- 라이브러리: 인터페이스, 클래스
- 정형화된 방법: 컬렉션을 사용하는 방법이 통일화되어 있다는 뜻

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/15(1).png)

- List(인터페이스): 인덱스에 객체를 저장, **중복 저장 가능**
    - 구현클래스: ArrayList, Vector, LinkedList
- Set(인터페이스): 구슬 주머니 형태에 객체를 저장, **중복 저장 불가**
    - 구현클래스: HashSet, TreeSet
- Map(인터페이스): List와 유사, 차이점은 Map은 인덱스가 아닌 key에 객체를 저장함, **키 중복 불가(키가 다르다면 객체 중복 가능)**
    - 구현클래스: HashMap, Hashtable, TreeMap, Properties
- List와 Set은 공통된 부분이 많기 때문에, 그 공통된 부분을 컬렉션에 정의해 놓고 Collection을 상속받아 만들어짐
- Map은 별도로 만들어짐

## **15.2 List 컬렉션**

## 참고자료

[강의교안_15장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_15%EC%9E%A5.ppt)