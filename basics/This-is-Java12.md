## 목차
[12.1 멀티 스레드 개념](#121-멀티-스레드-개념)   
[12.2 작업 스레드 생성과 실행](#122-작업-스레드-생성과-실행)   
[참고자료](#참고자료)   

## **12.1 멀티 스레드 개념**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/12(1).png)

- 프로그램을 실행할 때, 운영체제는 프로세스를 하나 만들어, CPU와 메모리를 사용할 수 있도록 함
- 프로그램 당 여러 개의 프로세스가 실행될 수 있음
- 각 프로세스들은 독립적으로 운영체제에서 실행되며, CPU와 메모리를 사용함

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/12(2).png)

- 예) 크롬 실행 → 1개의 프로세스 생성, 크롬 하나 더 실행 → 프로세스 하나 더 생성됨
- 작업 관리자 창의 응용 프로그램 각 하나 하나가 프로세스임
- 하나의 프로그램이라도 몇 번 실행했는가에 따라 여러 개의 프로세스가 만들어 질 수 있음

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/12(3).png)

- main() 메서드는 JVM에서 생성되는 main 스레드가 생성함
- 즉, main() 메서드를 실행하는 스레드가 main 스레드
- 스레드는 하나의 코드 실행 흐름이라고 할 수 있음
- main 스레드는 main() 메서드를 첫 코드 부터 아래로 순차적으로 실행함

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/12(4).png)

- JVM이 main 스레드를 만들고, main 스레드가 작업 스레드(또 다른 스레드)를 만듬
- 싱글 스레드: main 스레드 하나만 있는 스레드
- 멀티 스레드: main 스레드가 실행되며 main 스레드가 다른 스레드를 만들어 실행하는 스레드 환경
- 멀티 스레드 애플리케이션
    - 프로세스 생성 → JVM이 main 스레드 생성 → main() 메서드 실행
        
        → main() 메서드 실행 중 어떤 시점에 새로운 작업 스레드 생성
        
        → 작업 스레드 코드 실행
        
        → main 스레드가 먼저 종료될 시, 애플리케이션은 종료하지 않고, 나머지 스레드가 모두 종료되어야 프로세스는 종료됨
        

## **12.2 작업 스레드 생성과 실행**

## 참고자료

[강의교안_12장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_12%EC%9E%A5.ppt)