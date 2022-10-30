## 목차
[12.1 멀티 스레드 개념](#121-멀티-스레드-개념)   
[12.2 작업 스레드 생성과 실행](#122-작업-스레드-생성과-실행)   
    [- 12.2-1. Thread 클래스로부터 직접 생성하는 방법](#실습)   
    [- 12.2-1. 정리](#실습)   
    [- 12.2-2. Thread 하위 클래스로부터 생성하는 방법](#실습)   
    [- 12.2-2. 실습](#실습)   
    [- 12.2-2. 정리](#실습)   
    [- 결론](#실습)   
[12.3 스레드 우선 순위](#참고자료)   
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


## 참고자료

[강의교안_12장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_12%EC%9E%A5.ppt)