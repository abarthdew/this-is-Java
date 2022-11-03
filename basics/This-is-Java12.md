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

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/12(5).png)

### 12.2-1. Thread 클래스로부터 직접 생성하는 방법

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/12(6).png)

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
- 새로운 스레드 생성 후, `thread.start()`로 새로운 메서드를 호출 시켜주면,  비로소 스레드가 실행됨
    
    ⇒ 이 때, 스레드가 실행하는 코드는 run() 메서드 안에 있는 코드
    

### 12.2-1. 정리

- 동시에 실행해야 할 작업들이 있다
    
    → 해당 작업에 대한 클래스들을 생성하고 Runnable 인터페이스 구현체로 만듬
    
    → run() 메서드 재정의 후, 스레드가 실행할 코드를 넣어 줌
    
    → (여기까지, 이 작업 자체가 스레드인 건 아니고, 그냥 동시 실행해야 할 작업들을 클래스에 정의한 것)
    
    → Thread 객체 생성 후, 매개값으로 작업 객체를 넣어 주면,
    
    → 해당 스레드 객체가 `start()` 메서드 호출 시 작업 객체의 `run()`을 실행하게 됨
    

### 12.2-2. Thread 하위 클래스로부터 생성하는 방법

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/12(7).png)

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

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/12(8).png)

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

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/12(9).png)

- 위 코드는 모두 main 스레드가 실행하는 것
- 하지만, threadA와 threadB가 **실제로 실행하는 코드**는 각각의 객체에 재정의된 run() 메서드 안의 코드임

## **12.3 스레드 우선 순위**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/12(10).png)

- 스레드 우선 순위: 여러 가지 스레드가 있을 때, 어떤 스레드가 실행 우선 순위를 가지느냐
- 동시성: CPU의 코어 중 하나에서, 2개 이상의 스레드가 실행되는 현상
    - 하나의 코어는 한 시점에 하나의 스레드만 실행 가능
    - 때문에, 하나의 코어에서 멀티 스레드를 실행하려면, 한 시점에 스레드1을 조금 실행 시키고, 한 시점에 스레드 2를 조금 실행시키고, 스레드를 번갈아서 실행시키는 형태로 진행함
    - 코어 하나에 스레드 여러 개기 때문에, 코어가 어떤 스레드를 실행하는 도중엔 다른 스레드는 대기 상태가 됨
- 병렬성: 각각의 코어에서 스레드 하나씩 실행
    - 스레드1이 실행될 동안 스레드 2도 실행됨
    - 각각의 스레드는 실행에 방해를 받지 않고 계속 코드를 실행해 나갈 수 있음
    - 처리 속도가 보다 빠름

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/12(11).png)

- 각 스레드는 대기 상태로 있다가, 스케줄링에 의해 하나의 스레드가 선택되면 실행하게 됨
    
    → 이 스레드가 실행해야 할 run() 메서드를 모두 실행하는 것이 아니라, 조금씩 실행함
    
    → 스레드 1이 실행된다고 하면, run()이 다 실행되지 않은 시점에서 다시 대기 상태가 되고,
    
    → 뒤이어 스레드 2가 실행되어 run()을 실행하다가 다시 대기 상태가 됨
    
    → 뒤이어 스레드3이 실행되어 run()을 실행하다가 다시 대기 상태가 됨
    
    → 이렇게 반복적으로 계속 실행
    
    → 스레드 1이 run() 메서드를 다 실행하게 되면, 스레드 1 종료, 대기 상태에서 빠지게 됨
    
- 자바에서는 스레드 스케줄링으로 `**우선 순위 방식**`과 `**순환할당(라운드 로빈)**` 방식을 이용함
    - 우선순위: 우선순위가 높은 스레드가 좀 더 많은 실행 기회를 가짐
    - 순환 할당: 정해진 시간 할당량 만큼 각각의 스레드를 실행함
- **자바에서는 기본적으로 순환 할당 방식을 사용하며**, 부가적으로 스레드에 우선순위를 주어 우선 순위 방식을 사용할 수도 있음

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/12(12).png)

- 쿼드 코어에, 4개 이하의 스레드를 실행할 경우, 우선 순위 방식은 크게 영향을 미치지 못함
    
    → 코어가 4개, 스레드가 4개 이하이므로, 코어 당 스레드가 하나씩 독립적으로 실행되기 때문에 우선 순위를 매기는 의미가 없음
    

## **12.4 동기화 메소드와 동기화 블록**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/12(13).png)

- user1 스레드와 user2 스레드가 똑같이 Calculator 객체를 사용한다고 가정한다
- 위 예에서, user1 스레드의 memory 값은 100이 아닌 50으로 출력됨
    
    ⇒ 공유 객체를 사용할 때, 다른 스레드가 값을 변경하게 되면 또 다른 스레드에 영향을 미침
    

### 여러 스레드가 공유하는 객체가 항상 변할 수 있다는 문제점을 해결할 방법

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/12(14).png)

- 하나의 스레드가 동기화 메서드 또는 동기화 블록을 사용할 때, 다른 스레드는 이 메서드를 사용할 수 없음
- 이 예시에서는 user1이 완전히 끝날 때까지 다른 스레드가 동기화 블록 안에 있는 Calculator 필드 값을 바꿀 수 없음
- 즉, 동기화 메서드 또는 동기화 블록은 한 번에 하나의 스레드만 사용 가능
- 만약, 스레드1, 스레드2가 동시에 실행이 된다고 가정할 때
    
    ⇒ 스레드1 이 먼저 동기화 블록을 사용하게 됐다면, 스레드2는 스레드1이 동기화 블록 사용을 종료할 때까지 대기 상태가 됨
    
    ⇒ 스레드1이 동기화 블록 사용을 종료하면 그제야 스레드2도 동기화 블록 사용 가능
    
- 잠금: user1이 동기화 블록 내 Calculator 객체를 사용할 때, 다른 스레드가 이 객체를 사용할 수 없도록 잠궈버림
    
    ⇒ 다른 동기화 메서드도 전부 사용 안 됨
    
    ⇒ 만약, Calculator 객체 안에 동기화 메서드가 5개가 있다고 가정하면,  user1의 스레드가 그 중 하나를 사용하고 있을 때, user2는 나머지 4개의 동기화 메서드에도 접근하지 못함
    
    ⇒ Calculator 객체 자체가 잠겨있기 때문에
    
- synchronized(공유 객체) {}: 공유 객체에는 ‘잠금 객체’가 매개값으로 들어 감

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/12(15).png)

- 위 예제와 같이, user1 스레드가 m1(), m2(), m3() 셋 중 하나만 사용 중이라도 user2 스레드는 m1(), m2(), m3() 중 아무것도 사용하지 못함
    
    ⇒ Calculator 객체 자체가 잠금 되기 때문에
    
- 만약, synchronized 가 붙어있지 않는 m4() 메서드가 있다면, user1이 실행되는 와중에도 user2는 m4() 메서드 사용 가능

## **12.5 스레드 상태**

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/40f6c4b2-d7c1-4583-8290-63742e6758fe/Untitled.png)

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

## 참고자료

[강의교안_12장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_12%EC%9E%A5.ppt)