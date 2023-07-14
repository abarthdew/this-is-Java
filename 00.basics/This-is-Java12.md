## 목차

[12.1 멀티 스레드 개념](#121-멀티-스레드-개념)   
[12.2 작업 스레드 생성과 실행](#122-작업-스레드-생성과-실행)   
[- 12.2-1. Thread 클래스로부터 직접 생성하는 방법](#122-1-thread-클래스로부터-직접-생성하는-방법)   
[- 12.2-1. 정리](#122-1-정리)   
[- 12.2-2. Thread 하위 클래스로부터 생성하는 방법](#122-2-thread-하위-클래스로부터-생성하는-방법)   
[- 12.2-2. 실습](#122-2-실습)   
[- 12.2-2. 정리](#122-2-정리)   
[- 결론](#결론)   
[12.3 스레드 우선 순위](#123-스레드-우선-순위)   
[12.4 동기화 메소드와 동기화 블록](#124-동기화-메소드와-동기화-블록)   
[- 여러 스레드가 공유하는 객체가 항상 변할 수 있다는 문제점을 해결할 방법](#여러-스레드가-공유하는-객체가-항상-변할-수-있다는-문제점을-해결할-방법)   
[12.5 스레드 상태](#125-스레드-상태)   
[- 실습 - 12.5. thread](#실습---125-thread)   
[- 실습 - 12.5. thread (detail)](#실습---125-thread-detail)   
[12.6 스레드 상태 제어(1)](#126-스레드-상태-제어1)   
[12.6 스레드 상태 제어(2)](#126-스레드-상태-제어2)   
[12.7 데몬 스레드](#127-데몬-스레드)   
[12.8 스레드 그룹](#128-스레드-그룹)   
[- 실습 - 12.7.group2](#실습---127group2)   
[12.9 스레드풀(1)](#129-스레드풀1)   
[- ExecutorService, 즉, 스레드 풀의 동작 원리](#executorservice-즉-스레드-풀의-동작-원리)   
[12.9 스레드풀(2)](#129-스레드풀2)   
[- 실습 - 12.9.ExecuteSubmit4Exam.java](#실습---129executesubmit4examjava)   
[- 실습 - 12.9.blocking](#실습---129blocking)   
[12.9 스레드풀(3)](#129-스레드풀3)   
[- 실습 - 12.9.result](#실습---129result)    
[12.9 스레드풀(4)](#129-스레드풀4)   
[- 실습 - 12.9.CompletionService](#실습---129completionservice)    
[참고자료](#참고자료)

## **12.1 멀티 스레드 개념**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(1).png)

- 프로그램을 실행할 때, 운영체제는 프로세스를 하나 만들어, CPU와 메모리를 사용할 수 있도록 함
- 프로그램 당 여러 개의 프로세스가 실행될 수 있음
- 각 프로세스들은 독립적으로 운영체제에서 실행되며, CPU와 메모리를 사용함

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(2).png)

- 예) 크롬 실행 → 1개의 프로세스 생성, 크롬 하나 더 실행 → 프로세스 하나 더 생성됨
- 작업 관리자 창의 응용 프로그램 각 하나 하나가 프로세스임
- 하나의 프로그램이라도 몇 번 실행했는가에 따라 여러 개의 프로세스가 만들어 질 수 있음

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(3).png)

- main() 메서드는 JVM에서 생성되는 main 스레드가 생성함
- 즉, main() 메서드를 실행하는 스레드가 main 스레드
- 스레드는 하나의 코드 실행 흐름이라고 할 수 있음
- main 스레드는 main() 메서드를 첫 코드 부터 아래로 순차적으로 실행함

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(4).png)

- JVM이 main 스레드를 만들고, main 스레드가 작업 스레드(또 다른 스레드)를 만듬
- 싱글 스레드: main 스레드 하나만 있는 스레드
- 멀티 스레드: main 스레드가 실행되며 main 스레드가 다른 스레드를 만들어 실행하는 스레드 환경
- 멀티 스레드 애플리케이션
    - 프로세스 생성 → JVM이 main 스레드 생성 → main() 메서드 실행

      → main() 메서드 실행 중 어떤 시점에 새로운 작업 스레드 생성

      → 작업 스레드 코드 실행

      → main 스레드가 먼저 종료될 시, 애플리케이션은 종료하지 않고, 나머지 스레드가 모두 종료되어야 프로세스는 종료됨

## **12.2 작업 스레드 생성과 실행**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(5).png)

### 12.2-1. Thread 클래스로부터 직접 생성하는 방법

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(6).png)

- 동시에 실행을 할 수 있다는 의미에서, Runnable 인터페이스를 구현
- Runnable 인터페이스는 작업 스레드가 실행할 수 있는 클래스를 만들겠다는 뜻
- Runnable의 run() 메서드를 정의한 후, main 스레드 실행 동안 동시에 실행할 또 다른 스레드의 코드를 run()에 넣음
- 여기까지 진행 후, 스레드로부터 run() 메서드를 실행할 수 있게 만들어 줘야 함
    1. Runnable 구현 객체를 생성

        ```java
        Runnable task = new Task();
        Thread thread = new Thread(task); // Thread 객체가 task 실행하게 됨 => 결국 task 안의 run() 실행
        // Thread 객체: 자바에서는 하나의 스레드도 객체화 해서 사용함
        ```

    2. 익명 객체 생성(1과 같음, 표현만 다름)

        ```java
        Thread thread = new Thread(new Runnable() {
          public void run() {
            // 스레드가 실행할 코드
          }
        });
        ```

    3. 자바 8부터 추가된 람다식 사용

        ```java
        Thread thread = new Thread(() -> {
          // 스레드가 실행할 코드
        });
        ```

        - 람다식으로 작성 가능한 이유: Runnable 인터페이스가 run() 이라는 메서드 단 하나만 가지고 있기 때문

          → Runnable은 함수적 인터페이스에 해당됨

        - Runnable에 매개값이 없기 때문에 () → {} 와 같이 ()로 표현 가능
        - () → {} 의 {}는 아래 코드의 {}과 동일함

        ```java
        public void run() {
          // 스레드가 실행할 코드
        }
        ```

        - 람다식은 결국 Runnable 이라는 객체로 생성됨
- 1, 2, 3은 모두 동일한 의미의 코드며, 표현만 다름
- 새로운 스레드 생성 후, `thread.start()`로 새로운 메서드를 호출 시켜주면, 비로소 스레드가 실행됨

  ⇒ 이 때, 스레드가 실행하는 코드는 run() 메서드 안에 있는 코드

### 12.2-1. 정리

- 동시에 실행해야 할 작업들이 있다

  → 해당 작업에 대한 클래스들을 생성하고 Runnable 인터페이스 구현체로 만듬

  → run() 메서드 재정의 후, 스레드가 실행할 코드를 넣어 줌

  → (여기까지, 이 작업 자체가 스레드인 건 아니고, 그냥 동시 실행해야 할 작업들을 클래스에 정의한 것)

  → Thread 객체 생성 후, 매개값으로 작업 객체를 넣어 주면,

  → 해당 스레드 객체가 `start()` 메서드 호출 시 작업 객체의 `run()`을 실행하게 됨

### 12.2-2. Thread 하위 클래스로부터 생성하는 방법

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(7).png)

- 이전에 Thread 클래스로부터 직접 생성하는 방법에선 Runnable 객체가 필요했지만, Thread를 직접 상속받으면 하위 클래스로부터 Thread 객체를 직접 만들 수 있음

1. 명시적으로 하위 클래스를 만들어 Thread 객체를 생성하는 방법

    ```java
    Public class WorkerThread extends Thread { // Thread 상속
      @Override
      public void run() {
        // 스레드가 실행할 코드
      }
    }
    Thread thread = new WorkerThread(); // 하위 클래스로부터 Thread 객체 직접 만들기
    ```

2. 익명 객체를 만들어 Thread를 생성하는 방법

    ```java
    				// new Thread()로 생성자 호출
    Thread thread = new Thread() { // {}: Thread를 상속하는 하위 객체를 익명 객체로 만듬
      public void run() { // run() 메서드 재정의, 새로운 작업 스레드가 실행할 코드 작성
        // 스레드가 실행할 코드
      }
    };
    ```

- 실행: `thread.start();`

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(8).png)

- 스레드는 개별적으로 별도의 이름을 가질 수 있음
- main 스레드도 main 이라는 이름을 가지고 있는 것(JVM이 main 스레드를 생성할 때 이름을 부여)
- 작업 스레드를 생성하게 되면, 기본적으로 Thread-1, 2, 3, … 라는 이름이 부여됨

### 12.2-2. 실습

```java
Thread thread2  = new ThreadA();
System.out.println(Thread.currentThread().getName()); // main
thread2.start();
```

- `Thread.currentThread().getName()`: 해당 스레드를 생성한 스레드(ThreadA를 생성한 스레드)

  ⇒ 즉, 현재 이 코드를 실행하는 스레드를 얻어, 이름을 가져온다

- 아래 두 코드는 main 에서 실행되지만,

    ```java
    Thread thread2  = new ThreadA();
    thread2.start();
    ```

  ⇒ `thread.start()`를 하는 순간, ThreadA의 `run()` 메서드가 실행됨

### 12.2-2. 정리

- Thread를 생성함과 동시에, start() 메서드를 호출할 수 있음
- Thread threadA = new ThreadA(); 와 같이 스레드 생성 후, start() 메서드 호출 후, run() 메서드가 실행되고 나면, 다시 start()를 재호출 할 수 없음

  ⇒ start()는 딱 한 번만 호출 가능

- 만약, 새로운 스레드가 필요한데 이전 스레드와 작업 내용이 같다면, 그 때 start()를 재호출 할 수는 없음

  ⇒ 아래 예시와 같이 threadA를 다시 호출한 후 start()를 사용해야 함

    ```java
    Thread threadA = new ThreadA();
    threadA.start(); // 재사용 불가
    
    threadA = new ThreadA();
    threadA.start(); // 재사용 불가
    ```

### 결론

- 해당 코드 자체는 main 스레드에 의해 실행됨

```java
System.out.println("작업 스레드 이름(ThreadA의 이름): " + thread2.getName()); // main 스레드가 threadA의 이름을 얻기 위해 getName() 메서드 호출 
```

- 항상 해당 작업을 어떤 스레드가 실행시키는가를 알아야 함

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(9).png)

- 위 코드는 모두 main 스레드가 실행하는 것
- 하지만, threadA와 threadB가 **실제로 실행하는 코드**는 각각의 객체에 재정의된 run() 메서드 안의 코드임

## **12.3 스레드 우선 순위**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(10).png)

- 스레드 우선 순위: 여러 가지 스레드가 있을 때, 어떤 스레드가 실행 우선 순위를 가지느냐
- 동시성: CPU의 코어 중 하나에서, 2개 이상의 스레드가 실행되는 현상
    - 하나의 코어는 한 시점에 하나의 스레드만 실행 가능
    - 때문에, 하나의 코어에서 멀티 스레드를 실행하려면, 한 시점에 스레드1을 조금 실행 시키고, 한 시점에 스레드 2를 조금 실행시키고, 스레드를 번갈아서 실행시키는 형태로 진행함
    - 코어 하나에 스레드 여러 개기 때문에, 코어가 어떤 스레드를 실행하는 도중엔 다른 스레드는 대기 상태가 됨
- 병렬성: 각각의 코어에서 스레드 하나씩 실행
    - 스레드1이 실행될 동안 스레드 2도 실행됨
    - 각각의 스레드는 실행에 방해를 받지 않고 계속 코드를 실행해 나갈 수 있음
    - 처리 속도가 보다 빠름

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(11).png)

- 각 스레드는 대기 상태로 있다가, 스케줄링에 의해 하나의 스레드가 선택되면 실행하게 됨

  → 이 스레드가 실행해야 할 run() 메서드를 모두 실행하는 것이 아니라, 조금씩 실행함

  → 스레드 1이 실행된다고 하면, run()이 다 실행되지 않은 시점에서 다시 대기 상태가 되고,

  → 뒤이어 스레드 2가 실행되어 run()을 실행하다가 다시 대기 상태가 됨

  → 뒤이어 스레드3이 실행되어 run()을 실행하다가 다시 대기 상태가 됨

  → 이렇게 반복적으로 계속 실행

  → 스레드 1이 run() 메서드를 다 실행하게 되면, 스레드 1 종료, 대기 상태에서 빠지게 됨

- 자바에서는 스레드 스케줄링으로 `우선 순위 방식`과 `순환할당(라운드 로빈)` 방식을 이용함
    - 우선순위: 우선순위가 높은 스레드가 좀 더 많은 실행 기회를 가짐
    - 순환 할당: 정해진 시간 할당량 만큼 각각의 스레드를 실행함
- **자바에서는 기본적으로 순환 할당 방식을 사용하며**, 부가적으로 스레드에 우선순위를 주어 우선 순위 방식을 사용할 수도 있음

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(12).png)

- 쿼드 코어에, 4개 이하의 스레드를 실행할 경우, 우선 순위 방식은 크게 영향을 미치지 못함

  → 코어가 4개, 스레드가 4개 이하이므로, 코어 당 스레드가 하나씩 독립적으로 실행되기 때문에 우선 순위를 매기는 의미가 없음

## **12.4 동기화 메소드와 동기화 블록**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(13).png)

- user1 스레드와 user2 스레드가 똑같이 Calculator 객체를 사용한다고 가정한다
- 위 예에서, user1 스레드의 memory 값은 100이 아닌 50으로 출력됨

  ⇒ 공유 객체를 사용할 때, 다른 스레드가 값을 변경하게 되면 또 다른 스레드에 영향을 미침

### 여러 스레드가 공유하는 객체가 항상 변할 수 있다는 문제점을 해결할 방법

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(14).png)

- 하나의 스레드가 동기화 메서드 또는 동기화 블록을 사용할 때, 다른 스레드는 이 메서드를 사용할 수 없음
- 이 예시에서는 user1이 완전히 끝날 때까지 다른 스레드가 동기화 블록 안에 있는 Calculator 필드 값을 바꿀 수 없음
- 즉, 동기화 메서드 또는 동기화 블록은 한 번에 하나의 스레드만 사용 가능
- 만약, 스레드1, 스레드2가 동시에 실행이 된다고 가정할 때

  ⇒ 스레드1 이 먼저 동기화 블록을 사용하게 됐다면, 스레드2는 스레드1이 동기화 블록 사용을 종료할 때까지 대기 상태가 됨

  ⇒ 스레드1이 동기화 블록 사용을 종료하면 그제야 스레드2도 동기화 블록 사용 가능

- 잠금: user1이 동기화 블록 내 Calculator 객체를 사용할 때, 다른 스레드가 이 객체를 사용할 수 없도록 잠궈버림

  ⇒ 다른 동기화 메서드도 전부 사용 안 됨

  ⇒ 만약, Calculator 객체 안에 동기화 메서드가 5개가 있다고 가정하면, user1의 스레드가 그 중 하나를 사용하고 있을 때, user2는 나머지 4개의 동기화 메서드에도 접근하지 못함

  ⇒ Calculator 객체 자체가 잠겨있기 때문에

- synchronized(공유 객체) {}: 공유 객체에는 ‘잠금 객체’가 매개값으로 들어 감

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(15).png)

- 위 예제와 같이, user1 스레드가 m1(), m2(), m3() 셋 중 하나만 사용 중이라도 user2 스레드는 m1(), m2(), m3() 중 아무것도 사용하지 못함

  ⇒ Calculator 객체 자체가 잠금 되기 때문에

- 만약, synchronized 가 붙어있지 않는 m4() 메서드가 있다면, user1이 실행되는 와중에도 user2는 m4() 메서드 사용 가능

## **12.5 스레드 상태**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(16).png)

- 스레드 객체 생성: Thread는 new 연산자로 객체 생성 후 종료 시까지 여러 상태를 가질 수 있음
- 실행 대기: start() 메서드를 호출하면 스레드는 실행 대기 상태가 됨
- 실행: 실행 대기 상태에 있는 스레드는 CPU 스케줄로 인해 선택이 되면 실행되게 됨
- 실행하다 실행 대기 상태가 되고, 또 실행하다 실행 대기 상태가 되는 것을 반복하다가, run() 메서드를 종료하게 되면 종료 상태가 됨
- 실행 상태에서 실행 대기로 가지 않고, 일시 정지로 가는 경우도 있음

  ⇒ 일시 정지 상태: waiting, time_waiting, blocked

- 일시 정지 상태에 있는 스레드는 다시 실행 대기 상태로 감 → 여기서 CPU 스케줄로 선택 받아서 실행하게 됨
- **[표]**: 스레드 상태에 대한 열거 상수들
    - blocked
        - 스레드 a가 동기화 블록을 사용하고 있을 때, 스레드 b는 해당 동기화 블록에 접근할 수 없으므로 blocked 상태가 됨
        - 스레드 a가 동기화 블록 사용을 완료하면 스레드 b는 blocked 상태가 해제되어 실행 대기 상태가 됨 → 실행
    - waiting
        - Object가 가지고 있는 wait() 메서드가 있는데, 이를 호출하게 되면 스레드 c는 일시정지 상태로 감
        - waiting된 스레드 c는 다른 스레드 d가 notify() 메서드를 호출해야 비로소 실행 대기 상태로 갈 수 있음
        - 즉, waiting된 스레드는 자기 스스로 실행 대기 상태로 갈 수 없고, 다른 스레드가 알려줘야 실행 대기 상태로 갈 수 있음
    - timed_waiting
        - sleep() 메서드에 시간을 주게 되면, 그 시간동안 스레드는 일시 정지 상태가 됨
        - 주어진 시간이 지나면 자동으로 실행 대기 상태로 감
    - terminated
        - 스레드는 한번 생성되고 종료되면 재사용이 불가능
        - 스레드를 다시 사용 하고 싶다면 새로 생성 후 start() 해서 실행 대기 상태로 만들어 주어야 함

### 실습 - 12.5. thread

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(17).png)

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(18).png)

- java.lang → Thread → class Thread 의 중첩 클래스인 NESTED 클릭

  ⇒ Thread.State라는 열거 타입이 있는 것을 확인할 수 있음

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(19).png)

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(20).png)

- Enum으로 선언되어 있음을 확인할 수 있음

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(21).png)

- 위와 같은 열거 상수가 정의되어 있음을 확인할 수 있음

### 실습 - 12.5. thread (detail)

```java
public class StatePrintThread extends Thread {
  // 1. StatePrintThread는 targetThread의 상태를 계속해서 출력하는 스레드
  
  private Thread targetThread;
  
  // 2. 생성 시 targetThread의 객체를 받아 필드에 저장
  public StatePrintThread (Thread targetThread) { 
    this.targetThread = targetThread;
  }
  
  @Override
  public void run() {
    while (true) {
      // 3. StatePrintThread 실행 시, targetThread의 상태를 얻어냄
      Thread.State state = targetThread.getState();
      // 4. 얻어 낸 targetThread의 상태를 출력
      System.out.println("타겟 스레드 상태: " + state);
      // 5. targetThread 상태가 NEW가 되면(처음 만들어졌으면) 이 스레드를 start() 시킴 -> targetThread의 run() 메서드 실행
      if (state == Thread.State.NEW) { 
        targetThread.start();
      }
      // 6. statePrintThread는 0.5초 주기로 반복문을 돌며 계속 targetThread의 상태를 출력함
      // 7. 그러다 targetThread가 종료되면, while 문을 빠져나옴
      if (state == Thread.State.TERMINATED) { 
        break;
      }
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {} 
    }
  }
}
```

- **타겟 스레드 상태: NEW**

  ![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(22).png)

    - new TargetThread 객체를 생성한 상태
- **타겟 스레드 상태: RUNNABLE**

  ![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(23).png)

    - targetThread.start()가 호출되면 실행 대기 상태가 됨
    - 실행 대기 상태에서 CPU 스케줄로 선택되면 실행 상태가 됨

      ⇒ 실행 대기, 실행 상태 모두 포함 의미

    ![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(24).png)
    
    - RUNNABLE 상태는 targetThread가 for문을 실행할 단계의 상태임

- 타겟 스레드 상태: RUNNABLE
    - 실행 대기, 실행 상태를 오가며 상태가 변경되고 있음
- 타겟 스레드 상태: RUNNABLE
    - 실행 대기, 실행 상태를 오가며 상태가 변경되고 있음
- **타겟 스레드 상태: TIMED_WAITING**

  ![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(25).png)

    - 1.5초 동안 일시정지 되었을 때
- 타겟 스레드 상태: TIMED_WAITING
- 타겟 스레드 상태: TIMED_WAITING
- **타겟 스레드 상태: RUNNABLE**

  ![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(26).png)

    - 1.5초 뒤, 다시 targetThread가 for 문을 반복하며 RUNNABLE 상태가 됨
    - CPU의 선택을 받아 실행, 대기 상태를 왔다 갔다 하며 실행과 대기를 반복함
- 타겟 스레드 상태: RUNNABLE
- **타겟 스레드 상태: TERMINATED**

  ![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(27).png)

    - run() 종료, targetThread는 TERMINATED 상태가 됨
- targetThread가 종료되면 statePrintThread도 break로 반복문을 빠져나감 → 종료

  ![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(28).png)

## **12.6 스레드 상태 제어(1)**

- 스레드 상태를 변화시키기 위해서는 메서드를 사용해야 함

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(29).png)

- 처음 스레드를 생성하게 되면, **실행 대기** 상태가 됨

  → CPU 스케줄러에 의해 선택되면, **실행** 상태가 됨

  → 실행 상태에서 시간 할당량이 다 되면 다시 **실행 대기** 상태가 됨

- `yield() 호출`: **실행** 중, 시간 할당량이 되기 전에, **실행 대기** 상태로 만듦
- `sleep() 호출`:
    - **실행** 중, timed_watiting이 되어, 주어진 시간 동안 **일시 정지** 상태로 만듦
    - 주어진 시간이 지나면 다시 **실행 대기** 상태가 됨
- `join() 호출`:
    - **실행** 중, **일시 정지** 상태로 만듦
    - join() 메서드를 호출한 스레드가 종료되면 다시 **실행 대기** 상태가 됨
- `wait() 호출`:
    - **실행** 중, **일시 정지** 상태가 됨
    - wait()로 일시 정지된 스레드는 자기 스스로 실행 대기 상태가 될 수 없음
    - 다른 스레드가 notify() 또는 notifyAll()을 실행해 줘야 일시 정지가 풀려 실행 **대기 상태**가 될 수 있음
- `interrupt() 호출`:
    - **일시 정지** 상태에서 호출되면 예외 발생, 예외 발생과 동시에 일시 정지 상태가 풀리며 **실행 대기** 상태로 갈 수 있음
- `resume(), suspend()`: deplicated. 더 이상 사용하지 않음.
- `stop()`:
    - **실행** 중 호출하면 바로 **종료 상태**가 됨, 그러나 사용하지 않음
    - 갑자기 실행 중 종료되면 프로그램 상태가 불안정해지기 때문에, 가급적 사용하지 않는 것을 권장

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(30).png)

- 주어진 시간 동안 **일시 정지** → 주어진 시간 후 **실행 대기** 상태
- 일시 정지 도중에 interrupt() 메서드가 호출되면 예외가 발생할 수 있기 때문에, 예외 처리 필수

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(31).png)

- 실행 대기 상태인 스레드1, 스레드2가 있는 경우
- 스레드1이 실행 중일 때, yield() 메서드 호출 시 스레드1은 즉시 실행 대기 상태가 됨

  ⇒ 스레드1과 동일하거나 보다 높은 우선순위를 갖는 스레드2가 실행할 수 있도록 함

- 즉, yield()는 현재 실행 상태인 스레드를 실행 대기 상태로 되돌리는 역할을 함
- 보통 yield() 메서드는 무의미한 반복을 하지 않고, 다른 스레드에게 실행을 양보할 때 주로 사용됨

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(32).png)

- 무의미한 반복 → work가 false가 될 경우, 다른 스레드에게 실행을 양보하는 코드

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(33).png)

- join() 메서드 테스트를 위해서는 2개의 스레드가 필요
- `스레드a`에서 `스레드b`를 start() → `스레드b` run()

  ⇒ `스레드a`에서 `스레드b.join()` 호출 → `스레드b`가 아닌, `스레드 a`가 일시 정지 상태가 됨

- `스레드b`가 run() 메서드를 종료할 때까지 `스레드a`를 **일시 정지** 상태로 만듦

  ⇒ `스레드b`가 run() 메서드를 종료하면, `스레드 a`는 일시 정지 상태에서 풀려나 **실행 대기** 상태가 됨

  ⇒ `스레드a`는 이후 순차적으로 코드를 실행해 나감

- 보통 스레드a가 계산 작업 클래스인 스레드b의 계산 결과를 받아 작업하는 경우에 사용

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(34).png)

- `sleep()`, `yield()`, `join()`이 스레드가 가지는 메서드인 것에 반해, `wait()`, `notify()`, `notifyAll()`은 스레드 메서드가 아님

  ⇒ Object가 가지는 메서드(모든 객체가 가지고 있는 메서드)

- 일반 메서드는 `wait()`, `notify()`, `notifyAll()`를 호출할 수 없고, 동기화 메서드 또는 블록만 호출 가능함

  ⇒ (1), (2) 부분에만 사용 가능(공유 객체를 사용할 때 호출하는 메서드들이기 때문)

    ```java
    // 동기화 메서드
    synchronized void method () {
      // ...(1)
    }
    
    void method() {
      // 동기화 블럭(메서드 일부분)
      synchronized(this) {
        // ...(2)
      }
    }
    ```

- `wait()`:
    - 호출한 스레드는 일시 정지 상태가 되며, watiting pool에 스레드가 관리됨
    - 일시 정지 된 스레드는 자기 스스로 실행 대기 상태로 갈 수 없음

      ⇒ 실행 상태인 다른 스레드가 notify(), notifyAll()을 호출해 줘야 실행 대기 상태로 갈 수 있음

- `wait(long timeout, [int nanos])`:
    - wait()와는 달리 매개 값으로 들어 온 시간이 지나면 자동으로 대기 상태가 됨
    - 매개 값인 timeout 시간이 지나기 전에, 다른 스레드가 notify(), notifyAll()을 호출해 주면, 그 즉시 실행 대기 상태로 감

## **12.6 스레드 상태 제어(2)**

### wait(), notify()를 이용해 공유 객체를 번갈아 사용하는 예제

- 소비자 스레드가 데이터 소비, 생성자 스레드가 데이터 생성

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(35).png)

- stop() 메서드는 스레드를 즉시 종료시키지만, 불안정한 종료가 되므로 권장하지 않음
- 스레드의 종료: run() 메서드가 종료됨을 의미
- 안전한 종료 방법:
    1. stop 플래그로 run() 메서드의 정상 종료를 유도

       ⇒ 일시 정지 상태의 스레드를 종료하지는 못함

    2. interrupt() 메서드 사용

       ⇒ 일시 정지 상태인 스레드도 종료 가능

       ⇒ interrupt() 호출 시, 일시 정지 상태인 스레드에서 InterruptedException 발생

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(36).png)

- `Thread.sleep(1);` 와 같이 스레드가 일시 정지된 상태에서 `threadB.interrupt();` 와 같이 interrupt() 메서드 호출 시 → 예외 발생

  ⇒ while 반복문에서 catch로 내려와 스레드의 run() 메서드가 종료됨

- 실행 대기, 실행 상태에서는 InterruptExcaption이 발생하지 않음

  ⇒ 위 그림의 ThreadB에서 `Thread.sleep(1);` 코드가 없다면, `threadB.interrupt();` 와 같이 interrupt() 메서드가 호출되더라도 예외가 발생하지 않음

- **즉, interrupt() 메서드를 호출해도 일시 정지 코드가 있어야 예외가 발생하고, run() 메서드가 종료함**
- 일시 정지 상태로 만들지 않고 whild 문을 빠져나오는 방법: `interrupted()`, `isInterrupted()` 사용

    ```java
    // interrupt() 메서드가 호출되었으면 true, 아니면 false를 return
    boolean status = Thread.interrupted(); // Thread의 정적 메서드 사용
    boolean status = objThread.isInterrupted(); // Thread 객체를 생성한 후 인스턴스 메서드 사용
    ```

## **12.7 데몬 스레드**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(37).png)

- `thread.setDaemon(true)`: AutoSaveThread 스레드는 main 스레드의 데몬 스레드가 됨
- 마지막 }에서 main 스레드가 종료되면 AutoSaveThread는 자동으로 종료됨

## **12.8 스레드 그룹**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(38).png)

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(39).png)

- 스레드 그룹을 계층적으로 만들어 관리할 수 있음
- 자동 생성되는 스레드 그룹도 있음

  ⇒ 자바 프로그램을 실행하게 되면, system 그룹과 system의 하위 그룹인 main 그룹이 자동으로 생성됨

- 스레드는 기본적으로 자신을 생성한 스레드와 같은 그룹에 속하게 됨

  ⇒ main 그룹에 있는 main 스레드에서 스레드를 생성하게 되면, main 그룹에 자동으로 소속됨

  ⇒ sub 그룹에 소속된 sub 스레드가 스레드를 생성하게 되면, 자동적으로 sub 그룹에 소속됨

- main 스레드가 소속된 그룹이 main 그룹이므로, main 스레드가 생성하는 또 다른 스레드는 모두 기본적으로 main 그룹에 속함

  ⇒ 명시적으로 스레드 그룹에 포함시키지 않으면 기본적으로 main 그룹에 속함

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(40).png)

```java
ThreadGroup tg = new ThreadGroup(String name); // 현재 스레드가 속한 그룹의 하위 그룹으로 생성됨
ThreadGroup tg = new ThreadGroup(ThreadGroup parent, String name); // parent 그룹 밑의 하위 그룹으로 생성됨
```

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(41).png)

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(42).png)

### 실습 - 12.7.group2

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(43).png)

- WorkThread가 스레드 그룹에 포함되기 위해서는

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(44).png)

- Thread의 생성자를 호출해 주어야 함

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(45).png)

- 스레드 그룹은 생성자 외부에서 받도록 하고, 스레드 이름을 두 번째 매개 값으로 받음

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(46).png)

- run() 메서드 재정의: 무한 루프를 돌되, 1초 동안 쉬게 해 줌
- 나중에 interrupt() 메서드가 호출될 시 예외가 발생하도록 하기 위함

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(47).png)

- 이 코드를 실행하는 것은 main 메서드, 즉 main 스레드 이므로, 결국 main 스레드가 포함된 main 그룹에 myGroup이 하위 그룹으로 만들어짐

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(48).png)

- main 그룹 밑에 main 스레드, main 그룹 밑에 myGroup

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(49).png)

- 다음 단계: myGroup 밑에 workThreadA, workThreadB를 포함시킴

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(50).png)

- 처음 JVM 이 실행되면,
    1. system이라는 스레드 그룹 생성
    2. system 밑에 main 그룹 생성
    3. main 그룹 밑에 main 스레드 포함
    4. main 그룹의 서브 그룹으로 myGroup 포함
    5. myGroup 밑에 workThreadA, workThreadB 포함
- 출력 결과

    ```java
    // main 스레드 그룹의 list() 메서드 출력 내용
    java.lang.ThreadGroup[name=main,maxpri=10]
      Thread[main,5,main]
      java.lang.ThreadGroup[name=myGroup,maxpri=10]       
        Thread[workThreadA,5,myGroup]
        Thread[workThreadB,5,myGroup]
    ```

    - java.lang.ThreadGroup[name=main,maxpri=10]
        - 스레드 그룹의 이름이 main 이며, 이 스레드 그룹에 포함된 스레드가 가질 수 있는 최대 우선순위는 10번
    - Thread[main,5,main]
        - 이 스레드 그룹에 포함된 스레드 중 하나의 이름은 main 이고, 우선순위는 5며, 이 스레드가 포함된 스레드 그룹의 이름은 main임
    - java.lang.ThreadGroup[name=myGroup,maxpri=10]
        - main 그룹 내 서브 그룹으로 myGroup이 있으며, 이 그룹에 소속된 스레드가 가질 수 있는 최대 우선순위는 10번
    - Thread[workThreadA,5,myGroup]
        - myGroup에 포함된 스레드 workThreadA, 우선순위는 5번이며, 이 스레드가 포함된 그룹 이름은 myGroup
    - Thread[workThreadB,5,myGroup]
        - myGroup에 포함된 스레드 workThreadB, 우선순위는 5번이며, 이 스레드가 포함된 그룹 이름은 myGroup

## **12.9 스레드풀(1)**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(51).png)

- 브라우저에서 웹 서버에 접근하게 되면, 웹 서버는 하나의 스레드를 만들어 처리함
- 수천 개의 브라우저가 웹 서버에 접근하게 되면, 스레드도 수천 개 만들어져 동시에 실행됨

  ![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(52).png)

  ⇒ 스레드 폭증, CPU 과부하, 웹 서버 메모리도 많이 사용됨

  ⇒ 웹 서버에서 실행하는 서버 애플리케이션 성능이 급격히 저하됨

- `스레드 풀`: 아무리 많은 브라우저가 접근하더라도, 웹 서버 내 스레드 개수를 적절히 조절

  ![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(53).png)

    - 여러 작업 요청이 들어오면, 이 요청들을 큐 라는 공간에 저장해 놓고, 작업 당 스레드가 처리하도록 함
    - 즉, 제한된 스레드가 큐에 있는 작업을 하나씩 맡아 처리하는 방식
    - 작업을 다 처리한 스레드는 큐에서 다음 작업을 가져와 처리하는 것을 반복
    - 즉, 스레드는 작업을 하나 처리하고 일회용적으로 종료되는 것이 아니라, 계속 큐에 있는 작업을 가져와 처리

      ⇒ 제한된 갯수를 사용하더라도 충분히 작업들을 처리 가능

- 애플리케이션이 작업 요청을 하기 위해 큐에 작업 내용 저장해 두면 → 스레드가 작업을 하나씩 가져와 처리 → 그 결과를 애플리케이션에 전달

  ![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(54).png)

### ExecutorService, 즉, 스레드 풀의 동작 원리

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(55).png)

- ExecutorService, 즉, 스레드 풀 안에는 작업을 저장하는 공간인 `작업 큐`가 있음
- 작업 큐에 있는 작업을 가지고 와서 처리해 주는 `스레드`들이 제한된 갯수만큼 존재함
- `애플리케이션`은 스레드가 작업을 처리하도록 요청만 함
    - 스레드에서 실행할 수 있는 건 Runnable 객체
    - 애플리케이션은 단지 Runnable 이라는 객체를 만들어 작업 큐에 저장하기만 함

      → 작업 큐에 넣어진 Runnable 객체, 즉, 작업 객체는 자동적으로 스레드 풀에서 처리

- 스레드는 작업 큐에 있는 작업을 가지고 처리 후 → 처리 결과를 애플리케이션으로 전달함
- 애플리케이션은 이 결과 값을 받아 또 다른 작업 진행
- 스레드 풀을 사용함으로써, 아무리 많은 작업 요청이 들어와도, 작업 큐의 작업량만 늘어날 뿐 스레드의 갯수가 늘어나는 것은 아님
- 스레드는 제한된 갯수만 사용하고, 이를 가지고 작업 큐에 있는 작업들을 하나씩 처리함
- 갑자기 많은 요청이 들어오면, 작업 큐의 용량만 커질 뿐 스레드의 갯수는 증가되지 않음 → 갑작스러운 애플리케이션의 성능 저하는 발생하지 않음
- 스레드 풀은 서버 애플리케이션, 즉, 서버 프로그램을 만들 때 많이 사용함

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(56).png)

- 스레드 풀은 Executors 클래스의 두 가지 정적 메서드 중 하나로 생성할 수 있음
- 초기 스레드 수: 스레드 풀을 처음 만들 때 **기본적으로 들어가 있는 스레드 수**
- 코어 스레드 수: 스레드 풀에 스레드가 증가되어 많은 스레드가 있을 경우, 사용되지 않는 스레드를 풀에서 제거하는데, **제거하지 않고 유지해야 하는 최소한의 스레드 수**
- 최대 스레드 수: 스레드 풀에서 스레드를 계속 생성할 때, **최대 생성할 수 있는 스레드 수**
- `newCachedThreadPool()`
    - 최대 스레드 수: 이론적으로 int 값의 최대 값 만큼 생성 가능()

      ⇒ 어디까지나 이론적인 얘기고, 실제로는 이 정도 생성되지 않고 메모리 상황에 따라 다름

    - 놀고 있는 스레드가 있으면 60초 제한 기준으로 풀에서 제거됨
- `newFixedThreadPool(int nThreads)`:
    - 한 번 생성된 스레드는 풀에서 제거되지 않고 계속 남아있음
    - 코어 스레드 개수 = 최대 스레드 개수이기 때문
    - 놀고 있는 스레드라 하더라도 개수가 줄지 않음

    ```java
    ExecutorService executorService = Executors.newFixedThreadPool(
      Runtime.getRuntime().availableProcessors(); // 최대 스레드 갯수
    );
    ```

    - `availableProcessors()`: 현재 CPU의 코어 수

      ⇒ 가장 이상적인 병렬 처리: CPU가 가진 코어 수 만큼 스레드를 만들어 씀

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(57).png)

- `newCachedThreadPool()`와 `newFixedThreadPool(int nThreads)`는 내부적으로 ThreadPoolExecutor를 만들어 리턴함

  ⇒ 때문에 직접 ThreadPoolExecutor를 만들 수 있음

- 스레드 풀을 직접 만들 경우 다양한 옵션을 줄 수 있음

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(58).png)

- 멀티 스레드 애플리케이션은 최종 하나의 스레드가 종료되기 전까지, 애플리케이션은 종료되지 않음
- 즉, 스레드 풀의 스레드가 계속 실행하고 있다면, 애플리케이션은 종료되지 않음
- 따라서, 애플리케이션을 강제적으로 종료하고 싶다면, 스레드 풀을 종료해 모든 스레드를 종료해야 함
- 스레드풀 종료 메서드
    - `shouDownNow()`: 미처리된 작업 때문에 가급적이면 사용하지 않는 편이 좋음
    - `awaitTermination()`: 시간 제한을 주고 중지

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(59).png)

- Callable 객체를 만들 때 <T> 에는 리턴할 결과 값(애플리케이션이 받아야 할 결과 값)의 타입을 명시해 줌

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(60).png)

- **작업 처리 요청**: 애플리케이션이 작업 큐에 Runnable 또는 Callable 객체를 넣는 행위를 뜻함
- 애플리케이션은 ExecutorService에 있는 execute(), submit() 메서드를 이용해 Runnable, Callable 객체를 작업 큐에 넣을 수 있음
- 작업 처리 도중 예외가 발생할 경우
    - `execute()`
        - 스레드 자체가 종료됨 → 새로운 스레드를 만들어 갯수 유지
        - Runnable 객체를 처리하던 t1이라는 스레드에 예외가 발생했다면, t1은 스레드 풀에서 제거되고, t2가 새로 생성됨
    - `submit()`
        - 스레드를 제거하지 않고, 현재 작업 중인 작업을 버린 후 다음 작업을 가져와 계속 실행
        - Runnable1 객체를 처리하던 t1이라는 스레드에 예외가 발생했다면, t1은 현재 진행 중인 작업을 버리고 Runnable2를 처리함
        - 스레드는 재사용하는 게 좋음 → 스레드를 생성하게 되면 CPU와 메모리를 사용해야 하기 때문에

## **12.9 스레드풀(2)**

### 실습 - 12.9.ExecuteSubmit4Exam.java

- 예외 발생 시켜 보기 - **execute() 의 경우**

```java
for (int i=0; i<10; i++) {
  Runnable runnable = new Runnable() {
    @Override
    public void run() {
      ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
      int poolSize = threadPoolExecutor.getPoolSize();
      String threadName = Thread.currentThread().getName();
      System.out.println("총 스레드 개수: " + poolSize + " / 작업 스레드 이름: " + threadName);
      int value = Integer.parseInt("삼"); // 예외 발생 지점
    }
  };
  executorService.execute(runnable);
  Thread.sleep(10);
}
```

- 출력결과

```java
총 스레드 개수: 1 / 작업 스레드 이름: pool-1-thread-1
Exception in thread "pool-1-thread-1" java.lang.NumberFormatException: For input string: "삼"
    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
    at java.lang.Integer.parseInt(Integer.java:580) 
    at java.lang.Integer.parseInt(Integer.java:615) 
    at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    at java.lang.Thread.run(Thread.java:748)        
총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-3
Exception in thread "pool-1-thread-3" java.lang.NumberFormatException: For input string: "삼"
    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
    at java.lang.Integer.parseInt(Integer.java:580) 
    at java.lang.Integer.parseInt(Integer.java:615) 
    at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    at java.lang.Thread.run(Thread.java:748)        
총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-2
Exception in thread "pool-1-thread-2" java.lang.NumberFormatException: For input string: "삼"
    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
    at java.lang.Integer.parseInt(Integer.java:580) 
    at java.lang.Integer.parseInt(Integer.java:615) 
    at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    at java.lang.Thread.run(Thread.java:748)        
총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-4   
Exception in thread "pool-1-thread-4" java.lang.NumberFormatException: For input string: "삼"
    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
    at java.lang.Integer.parseInt(Integer.java:580) 
    at java.lang.Integer.parseInt(Integer.java:615) 
    at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-5
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    at java.lang.Thread.run(Thread.java:748)        
Exception in thread "pool-1-thread-5" java.lang.NumberFormatException: For input string: "삼"
    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
    at java.lang.Integer.parseInt(Integer.java:580) 
    at java.lang.Integer.parseInt(Integer.java:615) 
    at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-6
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    at java.lang.Thread.run(Thread.java:748)        
Exception in thread "pool-1-thread-6" java.lang.NumberFormatException: For input string: "삼"
    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
    at java.lang.Integer.parseInt(Integer.java:580) 
총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-7   
    at java.lang.Integer.parseInt(Integer.java:615) 
    at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    at java.lang.Thread.run(Thread.java:748)        
Exception in thread "pool-1-thread-7" java.lang.NumberFormatException: For input string: "삼"
    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
    at java.lang.Integer.parseInt(Integer.java:580) 
    at java.lang.Integer.parseInt(Integer.java:615)
총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-8   
    at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-9   
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    at java.lang.Thread.run(Thread.java:748)        
총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-10
Exception in thread "pool-1-thread-9" 
Exception in thread "pool-1-thread-8" java.lang.NumberFormatException: For input string: "삼"
    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
    at java.lang.Integer.parseInt(Integer.java:580)
    at java.lang.Integer.parseInt(Integer.java:615) 
    at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    at java.lang.Thread.run(Thread.java:748)        
java.lang.NumberFormatException: For input string: "삼" 
    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
    at java.lang.Integer.parseInt(Integer.java:580) 
    at java.lang.Integer.parseInt(Integer.java:615) 
    at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    at java.lang.Thread.run(Thread.java:748)        
Exception in thread "pool-1-thread-10" java.lang.NumberFormatException: For input string: "삼"
    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
    at java.lang.Integer.parseInt(Integer.java:580) 
    at java.lang.Integer.parseInt(Integer.java:615) 
    at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    at java.lang.Thread.run(Thread.java:748)
```

- 분석

    | thread-1 |
    | --- |
    - 작업 큐에 작업이 쌓임 → 스레드 생성 → 작업 처리
        - 출력: `총 스레드 개수: 1` / 작업 스레드 이름: pool-1-thread-1
            
            ⇒ 예외 발생 → thread-1 스레드 종료 → 풀에서 제거됨
            
    
    | thread-3 | thread-2 |
    | --- | --- |
    - 작업 큐에 작업이 많이 쌓여있기 때문에, 스레드 풀은 최대 스레드 2개를 생성 → 작업 처리
        - `총 스레드 개수: 2` / 작업 스레드 이름: pool-1-thread-3
            
            ⇒ 예외 발생 → thread-3 종료 → 풀에서 제거됨
            
    
    | thread-2 | thread-4 |
    | --- | --- |
    - 스레드 풀은 개수를 유지하기 위해 새로운 스레드를 하나 더 생성, 스레드 풀은 최대 스레드 2개를 유지 → 작업 처리
        - `총 스레드 개수: 2` / 작업 스레드 이름: pool-1-thread-2
            
            ⇒ 예외 발생 → thread-2 종료 → 풀에서 제거됨
            
    
    | thread-4 | thread-5 |
    | --- | --- |
    - 이런 식으로 계속해서 스레드가 예외가 발생되면 제거되고, 새로 생성되며 최대 스레드 개수가 유지되며, 스레드 풀이 사용됨
        - `총 스레드 개수: 2` / 작업 스레드 이름: pool-1-thread-4
            
            ⇒ 예외 발생 → thread-4 종료 → 풀에서 제거됨
            
        - `총 스레드 개수: 2` / 작업 스레드 이름: pool-1-thread-5
            
            ⇒ 예외 발생 → thread-5 종료 → 풀에서 제거됨

- 예외 발생 시켜 보기 - **submit() 의 경우**

```java
executorService.submit(runnable);
```

- 출력결과

```java
총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-2   
총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-1   
총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-2   
총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-1   
총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-2   
총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-1   
총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-2
```

- 분석
    - 스레드 풀은 작업 큐에 작업이 쌓이면 자기가 가져올 수 있는 최대 스레드 수인 2개 만큼 스레드를 생성 시킴
    - 그래서 만들어진 게 `thread-1`, `thread-2`
    - 작업 큐에 있는 작업들을 thread-1, 2가 각각 가져와 처리
    - 중간 중간에 예외가 발생해도 스레드는 작업 큐에 있는 작업을 가져와 계속 처리함

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(61).png)

- 블로킹 방식: 뭔가를 요청하고 나서 그 결과가 올 때까지 기다리는 방식
- 결과 값이 없는 작업을 작업 큐에 저장하기 위해 submit() 메서드 사용

    ```java
    submit(Runnable task);
    ```

  → sumit() 메서드로 작업 객체(Runnable task)를 작업 큐에 넣고

  → 스레드가 이들 작업 객체(Runnable task)를 처리함

- submit()은 Future라는 객체를 리턴함
- Future 객체:
    - 작업 결과 X
    - 작업 결과가 나올 때까지 기다리는 객체 O
    - 지연 객체, 지연 완료 객체라고 부르기도 함

      ⇒ sumit() 메서드가 호출되면 그 즉시 Future 객체가 리턴됨

      ⇒ 즉, 스레드가 Runnable 또는 Callable<V> 의 코드를 실행하지 않은 상태에서 Future 객체가 얻어지는 것

      ⇒ 때문에, Future는 작업 결과가 아니라, 작업이 스레드에서 처리가 완료된 후의 그 결과 값을 받을 목적으로 만들어진 객체임

      ⇒ 결과가 나중에 나오기 때문에 지연 객체라고 함

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(62).png)

- get(): 작업이 완료될 때까지 블로킹 되었다가(스레드가 작업을 완료할 때까지 기다렸다가)  처리 결과 V를 리턴
- Runnable 객체를 담는 submit()은 결과값이 없는 작업을 처리할 때 쓰이는 메서드임

    ```java
    submit(Runnable task); // 결과 값이 없는 작업(Runnable task)을 작업 큐에 넣는다(submit)
    ```

    - 스레드가 실행이 다 되고, 작업 처리를 완료한다면, 결과가 없기 때문에 future.get()은 결국 null을 리턴함

    ```java
    submit(Runnable task, Integer result);
    ```

    - 두 번째 매개 값인 Integer result가 결과 값
    - 즉, future.get()은 int 타입 값을 리턴

    ```java
    submit(Callable<String> task);
    ```

    - submit()에 Callable 객체를 저장할 때, 그 값을 String으로 지정하면, Callable의 작업 처리 결과가 String으로 나옴
    - 즉, future.get()은 String 타입 값을 리턴
- 스레드에서 Runnable, Callable 객체를 처리할 때 예외가 발생 시

  ⇒ get() 메서드는 처리 결과가 리턴될 때까지 기다리는데, 스레드가 작업 처리를 하는 도중에 예외 발생 시, get() 메서드에서도 예외가 발생함

  ⇒ 예외 발생 시 결과 값을 얻을 수 없기 때문에, get() 메서드는 예외가 발생하도록 되어 있음

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(63).png)

- Future의 get() 메서드는 블로킹이 되기 때문에, 스레드가 작업을 완료할 때까지 이 get()은 멈춰 있음

  ⇒ 때문에, get()은 UI를 생성하거나 변경하는 스레드에서 호출하면 안 됨

  ⇒ UI가 멈춰있는 상태가 되기 때문 → 이벤트 처리를 할 수 없게 됨

- 그렇다면 get() 메서드를 어떻게 호출해야 하느냐?
    - 새로운 스레드를 생성해서 호출하거나

    ```java
    // 1. 스레드 객체를 생성하고
    new Thread(new Runnable() { // 2. 매개값으로 Runnable 객체 지정
      @Override
      public void run() { // 3. run() 재정의
        try {
          future.get(); // 4. future.get() 메서드를 호출하도록
        } catch(Exception e) {
          e.printStackTrace();
        }
      }
    }).start(); // 5. start()로 새로운 스레드가 run()을 실행하도록 함
    ```

    - 스레드풀의 스레드가 호출하도록 해 주거나

    ```java
    // 3. submit() 이라는 메서드로 작업 큐에 넣어 줌
    executorService.submit(new Runnable() { // 2. 작업 객체를 만들어서
      @Override
      public void run() {
        try {
          future.get(); // 1. 이것을 처리하는,
        } catch(Exception e) {
          e.printStackTrace();
        }
      }
    });
    // 4. 스레드가 작업 큐에 들어간 작업을 처리하며, run()이 실행됨
    ```

  ⇒ 이런 방법은 UI 생성, 변경, 이벤트 처리하는 스레드에서 future.get()이 실행되지 않기 때문에 문제되지 않음

- 다른 메서드: Future의 또 다른 메서드
    - cancel(boolean mayInterruptIfRunning): 스레드 작업 도중 취소
        - boolean mayInterruptIfRunning: 필요한 경우 interrupt를 할 것인가(true - 스레드에 interrupt 호출, interruptException 발생됨)
    - isCancel(): 보통 cancel()로 작업 취소 후 확인용

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(64).png)

- 리턴값이 없는 작업 완료 통보

  ⇒ 리턴값이 없는 작업을 만들어서 → 작업 큐에 넣음 → 스레드가 작업 큐에서 작업을 가져와 처리 → 처리 후 완료를 통보

    ```java
    // 1. 리턴값이 없는 작업 객체 생성
    Runnable task = new Runnable() {
      @Override
      public void run() {
          // 2. 스레드가 처리할 작업 내용
      }
    }
    Future future = executorService.submit(task);
    // 3. 스레드 풀(executorService)의 submit() 메서드에 작업 객체 삽입
    // 4. submit()은 3. 이후 즉시 Future 객체 리턴
    ```

    - future를 가지고 스레드가 작업을 완료했는지, 처리 도중인지 알 수 있음

    ```java
    try {
      future.get(); // get()을 호출하게 되면 블로킹 발생 -> 작업을 완료할 때까지 (해당 코드를 실행하는)스레드는   여기서 멈춰있음
      // Runnable 객체에 리턴값이 없기 때문에 여기서 리턴값을 받을 필요는 없음
      // 여기서의 get() 은 '스레드가 작업을 완료할 때까지 기다린다'는 의미
    } catch(InterruptedException e) {
      // 작업 처리 도중 스레드가 interrupt 될 경우 실행할 코드
    } catch(ExecuteException e) {
      // 작업 처리 도중 예외가 발생된 경우 실행할 코드
    }
    ```

  ![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(65).png)

    - 스레드 풀(pool) 안에 Runnable이라는 작업이 있음
    - 이 작업을 스레드 풀의 스레드가 ↓ 이렇게 실행
    - 실행 동안, get() 메서드는 블로킹됨
    - 실행이 완료가 되면, 즉 풀의 스레드가 Runnable 객체의 run() 메서드를 다 실행하게 되면, 비로소 future.get() 결과가 리턴됨
    - 즉, future.get()이 블로킹에서 빠져나옴
    - 하지만, 작업 결과가 없기 때문에 future.get()은 null이 리턴됨
- 발생할 수 있는 예외의 종류

    | ↓ (스레드 실행) | 작업 도중 interrupt() 호출: InterruptedException e |
    | --- | --- |
    | ↓ (스레드 실행) |  |
    | ↓ (스레드 실행) | 작업 도중 예외 발생: ExecuteException e |

### 실습 - 12.9.blocking

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(66).png)

- main 스레드 실행 방향

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(67).png)

- 스레드 풀의 스레드가 Runnable 작업 객체 내 run()을 계속 실행 → 실행이 끝나면,

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(68).png)

- 비로소 get()은 리턴 됨
- main 스레드는 get()을 호출한 시점에 블로킹 됨 → pool에서 run()이 완전히 종료되면 future.get(); 부분의 블로킹이 풀림
- 이 후 코드 순차 실행

## **12.9 스레드풀(3)**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(69).png)

- 리턴 값이 있는 작업일 경우, Callable 이라는 객체를 만듦
- T에는 리턴값 타입을 지정
- Callable이 가지고 있는 메서드 call()을 재정의
- 이 call() 메서드 내 내용이 결국 스레드에서 실행할 내용
- call() 메서드는 리턴 값이 있기 때문에 리턴 타입 T를 지정
- call() 메서드에서 예외가 발생할 수 있기 때문에 throws Exception 추가

```java
Future<T> future = executorService.submit(task);
```

- 만들어진 Callable 작업 객체를 submit() 이라는 메서드를 사용해 작업 큐에 넣음
- submit() 메서드에 Callable 객체 task를 삽입
- 그러면 submit()은 그 즉시 Future<T> 객체 리턴
- Future가 나중에 얻게 될 결과값의 타입은 T
- 결국, Callable의 T와 Future의 T는 같은 타입

```java
future.get();
```

- Future의 get() 메서드를 호출하면, 스레드는 call() 메서드를 다 실행할 때까지 기다림(블로킹)
- call() 모두 실행 후, get()은 리턴 값 T를 리턴함
- 즉, call()의 리턴 값을 get()이 T result에 리턴하는 것

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(70).png)

- 작업 처리 결과는 스레드에서 만들어짐

  ⇒ 결과 값을 스레드가 아닌 외부 객체에 저장하는 경우

- 스레드 1과 스레드 2에서 각각 처리된 작업의 결과를 취합하고 싶을 때

  ⇒ 이런 경우 스레드가 처리한 작업의 결과를 → 외부 객체에 저장

```java
Result result = ...; // 스레드 1, 2가 공통적으로 사용하는 공유 객체
Runnable task = new Task(result); // 작업 객체를 만들고, result를 매개 변수로 삽입해 작업 내용에서 쓸 수 있도록 함

```

- 작업 객체에 result를 넣어주는 이유: 스레드가 Runnable task 작업을 처리하고 나서 처리 결과를 result에 누적 시키려면, 스레드는 result의 참조를 알고 있어야 하기 때문에

```java
// submit(task, result)에 지정된 타입이 result이기 때문에 Future<Result>가 됨
Future<Result> future
  = executorService.submit(task, result);
  // submit() 호출하고, 
  // 첫번째에 작업 객체, 
  // 두번째에 result를 넣어 줌: 나중에 future.get()으로 얻을 결과 값이 결국 result 타입이라는 것을 지정하는 것
// submit은 즉시 future 리턴
result = future.get(); // get() 호출 시, get()은 result 타입 결과 값을 리턴함
```

- result의 타입이 결국 Future<T>의 T와 같아야 하며, get()이 리턴하는 결과 값의 타입 또한 result와 동일한 타입임

```java
Runnable task = new Task(result);
↓
↓
↓
```

```java
// Runnable task를 만드는 방법
class Task implemetns Runnable {
  Result result; // new Task(result); 로 받은 result를 필드에 저장
  Task(Result result) { this.result = result; } // 필드에 전달된 값을 저장
  @Override
  public void run() { // run() 재정의
    // 작업 코드
    // 처리 결과를 result 저장
  }
}
```

### 실습 - 12.9.result

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(71).png)

- 세 번째 submit()이 외부 객체에 결과값을 저장하는 메서드

## **12.9 스레드풀(4)**

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(72).png)

- 작업 요청 순서: 작업 큐에 저장된 순서
- 먼저 요청한 작업: 작업 큐에 먼저 들어온 작업
- 여러 개의 작업들이 순차적으로 처리될 필요성이 없음 → 작업들이 독립적이라는 뜻
- 작업 큐에 있는 작업들은 모두 독립적이고, 그 작업들이 순서와는 상관없이 처리 결과가 나온다면 처리 결과가 빨리 나오는 것부터 이용하는 것이 좋음
- `poll()`:
    - get() 과 비슷하나 완료된 작업의 Future를 가져옴
    - 완료된 작업이 없다면 즉시 null 리턴 → 블로킹이 아니라는 뜻
    - poll()을 실행하는 시점에서, 완료된 작업이 있으면 가져오거나 null 리턴하는 것
- `poll(long timeout, TimeUnit unit)`: timeout 시간 동안 기다렸다가, 즉 블로킹 되었다가 완료된 작업이 있으면 가져옴
- `take()`: 완료된 작업이 없으면 계속 대기 상태, 완료된 작업이 생기면 그 때 리턴이 되어 Future 를 얻어 옴

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(73).png)

```java
// 스레드 풀 객체 ExecutorService 생성
ExecutorService executorService = Executors.newFixedThreadPool(
  Runtime.getRuntime().acailableProcessors()
);

CompletionService<V> completionService 
  // new ExecutorCompletionService<V> 객체 생성
  = new ExecutorCompletionService<V>( // V: 스레드 풀이 작업을 다 처리하고나서 생성된 결과 타입을 지정
  executorService // 매개값: 스레드 풀 객체
);
```

- poll()과 take() 메서드를 이용해 처리 완료된 작업의 Future을 얻으려면
- completionService의 submit() 메서드로 작업 처리 요청을 해야 함

  ⇒ executorService의 submit()을 이용하면 안 됨

  ⇒ **작업 큐에 작업을 저장할 때 executorService가 아닌 completionService를 사용해야 poll()과 take() 이용 가능**

    ```java
    CompletionService<V> completionService = new ExecutorCompletionService<V>( 
      executorService 
    );
    ```

    ```java
    completionService.submit(Callable<V> task); // completionSerivice.submit()를 이용해 Callable task를 작업 큐에 넣어 줌
    completionService.submit(Runnable task, V result);// completionSerivice.submit()를 이용해 Runnable을 작업 큐에 넣어 주고, 외부 객체 값도 넣어 줌
    ```

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(74).png)

- take()는 완료된 작업이 있을 때까지 블로킹됨
- 블로킹되기 때문에, 결국은 스레드에서 이 take()를 호출함
- UI를 생성하거나 변경하는 스레드에서 take()를 호출하면, 작업이 완료될 때까지 블로킹, 즉 멈추기 때문에, UI 작업을 할 수 없음
- UI 작업 이외에서 take()를 호출하는 것이 바람직함

```java
// 스레드 풀의 스레드 executorService가 take() 를 사용해 완료된 작업을 처리하는 예제

executorService.submit(new Runnable() { // 작업 객체인 Runnable 생성
  @Override
  public void run() { // 재정의
    while(true) {
      try {
        Future<Integer> future = completionService.take(); // 스레드 풀의 스레드가 완료한 작업이 있을 때 그 작업의 Future를 리턴(반복)
        int value = future.get(); // 그 작업의 결과를 얻어 이용(반복)
        System.out.println("처리 결과:" + value);
      } catch(Exception e) {
        break;
      }
    }
  }
});
```

### 실습 - 12.9.CompletionService

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(75).png)

- 스레드 풀 안의 작업 큐에 c1, c2, c3 작업들이 순서대로 들어 왔다고 가정
- 이 작업들을 스레드 t1, t2가 하나씩 처리함
- 그러나, 반드시 c1이 먼저 끝난다는 보장이 없음
- c2가 t2에 의해 먼저 결과가 나올 수도 있음
- 스레드의 실행 환경, 생성 시간 때문에 먼저 작업 큐에 들어간 Callable이 먼저 처리가 끝나는 것이 아님
- c1, c2, c3는 모두 독립성을 가지고 있고, 어떤 작업이 끝나더라도 상관 없는 경우 완료된 작업을 알아내 그 작업을 처리해 주는 것이 효율적임

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(76).png)

- 블로킹 방식: future 객체를 이용하는 방식
    - `(1)` main 스레드가 스레드 풀에게 작업 처리 요청(submit)

      → 스레드 풀이 작업을 받아 처리

      → `(2)` submit()은 즉시 Future 객체 리턴

      → `(3)` main 스레드는 Future를 이용해 get() 호출

      → get()은 스레드 풀의 `(4)` 스레드가 작업 처리를 완료할 때까지 블로킹

      → 작업이 완료되면 결과를 받음

      → `(5)` 그 다음 코드 실행

- 콜백 방식: 자동적으로 메서드가 호출되는 방식
    - `(1)` main 스레드가 스레드 풀에게 작업 처리 요청(submit)

      → 스레드 풀이 작업을 받아 처리

      → `(2)` submit()은 즉시 Future 객체 리턴

      → Future를 이용하지 않고, `(3)` main 스레드는 일단 작업 처리 요청만 하고 자기 할 일을 계속 수행함

      → 스레드 풀의 스레드가 작업 처리를 완료하면, 자동적으로 콜백 메서드를 실행, `(4)` 이 콜백 메서드의 작업을 수행

    - main 스레드가 future.get()을 호출해 작업 처리가 끝날 때까지 기다리는 것이 아니라, 자기 할 일을 계속 함
    - 스레드 풀의 스레드가 작업을 완료하게 되면 자동적으로 콜백 메서드를 실행하게 함
    - 콜백 메서드 내에서 작업을 처리한 결과를 가지고 이용하도록 함

![Untitled](https://github.com/abarthdew/this-is-java/raw/main/00.basics/images/12(77).png)

- 콜백 방식을 이용하려면 먼저 콜백 객체를 생성해야 함
- `java.nio.channels.CompletionHandler`: 콜백 객체를 만들기 위한 인터페이스
- 꼭 이 객체를 사용할 필요는 없음(하나의 예시)

```java
// V: 스레드가 작업을 처리한 이휴의 결과값
// A: 콜백 메서드에서 사용할 수 있는 첨부 객체
CompletionHandler<V, A> callback
  = new CompletionHandler<V, A>(){ // 익명 객체로 구현 객체 생성
  @Override
  public void completed(V result, A attachment) {
      // 처리를 완료했을 때 시행하는 콜백 메서드
      // V: 스레드가 처리한 결과값
      // A: CompletionHandler<V, A>에서 지정한 A 객체(첨부객체)
  }
  @Override
  public void failed(Throwable exc, A attachment) {
      // 스레드가 처리를 실패하거나 예외가 발생했을 때 시행하는 콜백 메서드
      // Throwable exc: 예외
      // A attachment: 첨부 객체
  }
}
```

```java
// 작업객체 생성
Runnable task = new Runnable() {
  @Override
  public void run() {
    try {
      // 작업 처리
      V result = ...;
      callback.completed(result, null); // 필요한 시점에 콜백 객체의 콜백 메서드 호출
      // 이 콜백 메서드를 실행함으로써 결과를 애플리케이션에서 이용하도록 할 수 있음
    } catch(Exception e) {
      callback.failed(e, null); // 필요한 시점에 콜백 객체의 콜백 메서드 호출
      // 작업 처리 중 예외 발생 시, 콜백 객체의 failed() 메서드를 호출해 예외 발생 시 애플리케이션이 처리해야 할 코드를 실행
    }
  }
}
```

- 콜백 메서드를 실행하는 것은 main 스레드가 아니라, 스레드 풀의 스레드임

```java
CompletionHandler<V, A> callback = new CompletionHandler<V, A>(){
  @Override
  public void completed(V result, A attachment) {
    // ui 생성, 변경 메서드를 이 위치에서 작성할 시 에러 발생
  }
  @Override
  public void failed(Throwable exc, A attachment) {
    // ui 생성, 변경 메서드를 이 위치에서 작성할 시 에러 발생
  }
}
```

- 콜백 메서드를 실행하는 것은 스레드 풀의 스레드이므로, 콜백 메서드 안에 UI 생성, 변경 메서드를 작성하면 에러가 발생

  ⇒ 자바 FX, 안드로이드 X의 경우, UI 생성 및 변경 코드는 UI 스레드에서 다뤄야 함

## 참고자료

[강의교안_12장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/00.basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_12%EC%9E%A5.ppt)
